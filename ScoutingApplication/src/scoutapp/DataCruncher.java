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

    public int calcMMR(int curMMR, int allyMMR, int score)
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
        ArrayList<Integer> mmrs = new ArrayList();
        return mmr;
    }

    public static int getAvgMMROfPartners(int teamID, ArrayList<Match> matches)
    {
        int mmr = -1;
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
