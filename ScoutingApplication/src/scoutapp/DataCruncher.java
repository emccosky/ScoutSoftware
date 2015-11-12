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
        return -1;
    }

    public static double getDefensiveness(int teamID, ArrayList<Match> matches)
    {
        double ret = 0.0;
        
        return format(ret);
    }

    public static double getConsistency(int teamID, ArrayList<Match> matches)
    {
        double consistency = -1.0;
        
        return format(consistency);
    }

    public static int getMMR(int teamID, ArrayList<Match> matches)
    {
        return -1;
    }

    public static int getAvgMMROfPartners(int teamID, ArrayList<Match> matches)
    {
        return -1;
    }

    public static String getPredictedScoreRange(int teamID, ArrayList<Match> matches)
    {
        return "STRING-1STRING";
    }

    public static int getRP(int teamID, ArrayList<Match> matches)
    {
        return -1;
    }

    public static int getQP(int teamID, ArrayList<Match> matches)
    {
        return -1;
    }
}
