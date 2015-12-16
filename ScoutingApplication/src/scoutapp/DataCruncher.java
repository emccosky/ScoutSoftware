/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutapp;

import java.util.*;
import java.io.*;
import static java.lang.System.out;
import java.text.DecimalFormat;

/**
 *
 * @author spencersharp
 */
public final class DataCruncher 
{
    private DataCruncher()
    {
        
    }

    private static double format(double num) //Formats a double to 2 decimal places
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String a = df.format(num);
        double ret = Double.parseDouble(a);
        return ret;
    }

    public static double getAvgMatchScore(int teamID, ArrayList<Match> matches) //Returns the average match score of a given match set
    {
        double score = 0.0;
        int matchCount = 0;
        for(Match m : matches)
        {
            if(m.getScore(teamID) != -1)
            {
                score += m.getScore(teamID);
                matchCount++;
            }
        }
        score /= matchCount;
        if(matchCount == 0)
            return -1;
        return format(score);
    }

    public static double getDefensiveness(int teamID, ArrayList<Match> matches) //Returns the defensiveness estimated of each team
    {
        double defensiveness = -1.0;

        return format(defensiveness);
    }

    public static double getConsistency(int teamID, ArrayList<Match> matches) //Returns the consistency estimated of each team
    {
        double consistency = -1.0;
        int avg = (int)getAvgMatchScore(teamID, matches);
        ArrayList<Integer> vars = new ArrayList<Integer>();
        ArrayList<Integer> scores = new ArrayList<Integer>();
        
        for(Match m : matches)
        {
            if(m.getScore(teamID) != -1)
                scores.add(m.getScore(teamID));
        }
        //get differences between each score and avg
        for(Integer score : scores)
        {
            vars.add(Math.abs(score - avg));
        }
        Double var = 0.0;
        for (Integer item : vars)
        {
            var += Math.pow(item, 2);
        }
        Double std = Math.sqrt(var/scores.size());
        return format(std);
    }

    private static int calcMMR(int curMMR, int allyMMR, int score) //Calculates the MMR given the current MMR, alliance partner MMR, and the score of the match
    {
        double newMMR = (double) curMMR;
        double dAllyMMR = (double) allyMMR;
        double dScore = (double) score;
        double divisor = newMMR;
        double subtract = dAllyMMR * dAllyMMR; //Factors in alliance MMR
        subtract /= 10000;
        //These curb upward scores
        if(curMMR < 1200)
            divisor = 1200.0 / 1500.0;
        else if(curMMR < 2000)
            divisor = newMMR / 2000;
        else
            divisor = newMMR / 1500;
        double add = score * 44;
        add = add * add;
        add = Math.pow(add, 1.0/3);
        add = add / divisor;
        newMMR += add;
        newMMR -= subtract;
        int finalMMR = (int) Math.round(newMMR);
        return finalMMR;
    }

    public static int getMMR(int teamID, ArrayList<Match> matches) //Returns the MMR of any team
    {
        int mmr = -1;
        TreeMap<Integer,Integer> mmrs = new TreeMap(); //Key is team #, other thing is MMR
        ArrayList<Team> teams = new ArrayList(); //Arraylist of all team objects used
        ArrayList<Integer> teamInts = new ArrayList(); //Arraylist of team numbers

        for(int m = 0; m < matches.size(); m++) //Adds all the teams to teamInts
        {
            Match match = matches.get(m);
            if(!teamInts.contains(match.getMatchRed1ID()))
            {
                teamInts.add(match.getMatchRed1ID());
            }
            if(!teamInts.contains(match.getMatchRed2ID()))
            {
                teamInts.add(match.getMatchRed2ID());
            }
            if(!teamInts.contains(match.getMatchBlue1ID()))
            {
                teamInts.add(match.getMatchBlue1ID());
            }
            if(!teamInts.contains(match.getMatchBlue2ID()))
            {
                teamInts.add(match.getMatchBlue2ID());
            }
        }
        for(int i = 0; i < teamInts.size(); i++) //Adds all the teams to teams, sets their MMRs to 1500
        {
            teams.add(new Team(teamInts.get(i)));
            mmrs.put(teamInts.get(i),1500);
        }
        for(int rep = 0; rep < 2; rep++) //Calc MMR (2 times total)
        { //This loop is to give the teams sort of decided MMRs at the second runthru, making it more accurate
            for(int m = 0; m < matches.size(); m++) //Loop thru each match
            {
               //Calcs MMR for each team in the match (edits mmrs)
               Match match = matches.get(m);
               mmrs.put(match.getMatchRed1ID(), calcMMR(mmrs.get(match.getMatchRed1ID()),mmrs.get(match.getMatchRed2ID()),match.getMatchRedTotalScore()));
               mmrs.put(match.getMatchRed2ID(), calcMMR(mmrs.get(match.getMatchRed2ID()),mmrs.get(match.getMatchRed1ID()),match.getMatchRedTotalScore()));
               mmrs.put(match.getMatchBlue1ID(), calcMMR(mmrs.get(match.getMatchBlue1ID()),mmrs.get(match.getMatchBlue2ID()),match.getMatchBlueTotalScore()));
               mmrs.put(match.getMatchBlue2ID(), calcMMR(mmrs.get(match.getMatchBlue2ID()),mmrs.get(match.getMatchBlue1ID()),match.getMatchBlueTotalScore()));
            }
        }
        mmr = mmrs.get(teamID);
        return mmr;
    }

    public static double getAvgMMROfPartners(int teamID, ArrayList<Match> matches) //Returns the average MMR of all your partners
    {
        double mmr = 0;
        DataCruncher cruncher = new DataCruncher();
        int c = 0;
        for(Match m : matches)
        {
            if(m.getScore(teamID) != -1)
            {
                mmr += (cruncher.getMMR(m.getAlliancePartnerID(teamID),matches)*2.5);
                c++;
            }
        }
       // out.println(c);
        mmr /= c;
        return mmr;
    }

    public static String getPredictedScoreRange(int teamID, ArrayList<Match> matches) //Returns the predicted score range of the team (75% of matches should be in this score range)
    {
        DataCruncher cruncher = new DataCruncher();
        int dev = (int)cruncher.getConsistency(teamID, matches);
        int avg = (int)cruncher.getAvgMatchScore(teamID, matches);
        String returnString = "";
        int q1 = (int)(avg - (1.25*dev));
        if(q1 < 0)
            q1 = 0;
        int q3 = (int)(avg + (1.25*dev));
        returnString += q1;
        returnString += " - ";
        returnString += q3;
        
        return returnString;
    }

    public static int getRP(int teamID, ArrayList<Match> matches) //Returns the RP of any team
    {
        int rp = -1;
        for(Match m : matches)
        {
            if(m.getScore(teamID) != -1)
            {
                rp += m.getOpponentScore(teamID);
            }
        }
        return rp;
    }

    public static int getQP(int teamID, ArrayList<Match> matches) //Returns the QP of any team
    {
        int qp = 0;
        for(Match m : matches)
        {
            if(m.getScore(teamID) != -1)
            {
                if(m.getScore(teamID) > m.getOpponentScore(teamID))
                    qp += 2;
                else if(m.getScore(teamID) == m.getOpponentScore(teamID))
                    qp += 1;
            }
        }
        return qp;
    }
}