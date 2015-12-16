/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoutapp;

import java.util.*;
import java.io.*;
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

    public static double getDefensiveness(int teamID, ArrayList<Match> matches)
    {
        double defensiveness = -1.0;

        return format(defensiveness);
    }

    public static double getConsistency(int teamID, ArrayList<Match> matches)
    {
        double consistency = -1.0;

        return format(consistency);
    }

    private static int calcMMR(int curMMR, int allyMMR, int score)
    {
        double newMMR = (double) curMMR;
        double dAllyMMR = (double) allyMMR;
        double dScore = (double) score;
        double divisor = newMMR;
        double subtract = dAllyMMR * dAllyMMR;
        subtract /= 10000;
        //subtract = subtract / divisor;
        //subtract = subtract / 1100000;
        if(curMMR < 1200)
            divisor = 1200.0 / 1500.0;
        else if(curMMR < 2000)
            divisor = newMMR / 2000;
        else
            divisor = newMMR / 1500;
        //System.out.println(divisor);
        double add = score * 44;
        //System.out.println(add);
        add = add * add;
        //System.out.println(add);
        add = Math.pow(add, 1.0/3);
        add = add / divisor;
        //System.out.println(add);
        // if(divisor < 1)
        //   add = add * (1/divisor);
        //else
          //  add = add / divisor;
        //System.out.println(newMMR);
        //System.out.println(add);
        newMMR += add;
        //System.out.println(newMMR);
        newMMR -= subtract;
        //System.out.println(newMMR);
        int finalMMR = (int) Math.round(newMMR);
        return finalMMR;
    }

    public static int getMMR(int teamID, ArrayList<Match> matches)
    {
        int mmr = -1;
        TreeMap<Integer,Integer> mmrs = new TreeMap(); //Key is team #, other thing is MMR
        ArrayList<Team> teams = new ArrayList();
        ArrayList<Integer> teamInts = new ArrayList();

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
        for(int i = 0; i < teamInts.size(); i++)
        {
            teams.add(new Team(teamInts.get(i)));
            mmrs.put(teamInts.get(i),1500);
        }
        for(int rep = 0; rep < 2; rep++) //Calc MMR (5 times total)
        {
            for(int m = 0; m < matches.size(); m++) //Loop thru each match
            {
               //Calcs MMR for each team in the match (edits mmrs)
               Match match = matches.get(m);
               mmrs.put(match.getMatchRed1ID(), calcMMR(mmrs.get(match.getMatchRed1ID()),mmrs.get(match.getMatchRed2ID()),match.getMatchRedScoreAdjusted()));
               mmrs.put(match.getMatchRed2ID(), calcMMR(mmrs.get(match.getMatchRed2ID()),mmrs.get(match.getMatchRed1ID()),match.getMatchRedScoreAdjusted()));
               mmrs.put(match.getMatchBlue1ID(), calcMMR(mmrs.get(match.getMatchBlue1ID()),mmrs.get(match.getMatchBlue2ID()),match.getMatchBlueScoreAdjusted()));
               mmrs.put(match.getMatchBlue2ID(), calcMMR(mmrs.get(match.getMatchBlue2ID()),mmrs.get(match.getMatchBlue1ID()),match.getMatchBlueScoreAdjusted()));
            }
            for(int i = 0; i < teams.size(); i++)
            {
                teams.get(i).clearMatches();
            }
        }
        mmr = mmrs.get(teamID);
        return mmr;
    }

    public static double getAvgMMROfPartners(int teamID, ArrayList<Match> matches)
    {
        double mmr = -1;
        DataCruncher cruncher = new DataCruncher();
        int c = 0;
        for(Match m : matches)
        {
            
        }
        for(Match m : matches)
        {
            if(m.getAlliancePartnerID(teamID) != -1)
            {
                mmr += cruncher.getMMR(m.getAlliancePartnerID(teamID),matches);
                c++;
            }
        }
        mmr /= c;
        return mmr;
    }

    public static String getPredictedScoreRange(int teamID, ArrayList<Match> matches)
    {
        return "STRING-1STRING";
    }

    public static int getRP(int teamID, ArrayList<Match> matches)
    {
        int rp = -1;
        return rp;
    }

    public static int getQP(int teamID, ArrayList<Match> matches)
    {
        int qp = -1;
        return qp;
    }
}