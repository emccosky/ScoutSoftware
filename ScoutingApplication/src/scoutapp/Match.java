package scoutapp;

import java.util.*;
import java.io.*;

public class Match
{
    int competitionID;
    int matchNum;
    int red1ID;
    int red2ID;
    int blue1ID;
    int blue2ID;
    int redScore;
    int blueScore;
    boolean red1Surrogate;
    boolean red2Surrogate;
    boolean blue1Surrogate;
    boolean blue2Surrogate;

    public Match(int compID, int mNum)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = -1;
        this.red2ID = -1;
        this.blue1ID = -1;
        this.blue2ID = -1;
        redScore = -1;
        blueScore = -1;
        red1Surrogate = false;
        red2Surrogate = false;
        blue1Surrogate = false;
        blue2Surrogate = false;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redScore = -1;
        blueScore = -1;
        red1Surrogate = false;
        red2Surrogate = false;
        blue1Surrogate = false;
        blue2Surrogate = false;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rScore, int bScore)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redScore = rScore;
        blueScore = bScore;
        red1Surrogate = false;
        red2Surrogate = false;
        blue1Surrogate = false;
        blue2Surrogate = false;
    }
    
    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rScore, int bScore, boolean red1S, boolean red2S, boolean blue1S, boolean blue2S)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redScore = rScore;
        blueScore = bScore;
        red1Surrogate = red1S;
        red2Surrogate = red2S;
        blue1Surrogate = blue1S;
        blue2Surrogate = blue2S;
    }

    public int getScore(int teamID)
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueScore;
        else if(teamID == red1ID || teamID == red2ID)
            return redScore;
        else
            return -1;
    }

    public int getMatchBlue1ID()
    {
        return blue1ID;
    }

    public int getMatchBlue2ID()
    {
        return blue2ID;
    }

    public int getMatchRed1ID()
    {
        return red1ID;
    }

    public int getMatchRed2ID()
    {
        return red2ID;
    }

    public int getMatchRedScore()
    {
        return redScore;
    }

    public int getMatchBlueScore()
    {
        return blueScore;
    }

    public boolean equals(Match a)
    {
        if(competitionID != a.getMatchCompetitionID())
            return false;
        if(blue1ID != a.getMatchBlue1ID())
            return false;
        if(blue2ID != a.getMatchBlue2ID())
            return false;
        if(red1ID != a.getMatchRed1ID())
            return false;
        if(red2ID != a.getMatchRed2ID())
            return false;
        if(redScore != a.getMatchRedScore())
            return false;
        if(blueScore != a.getMatchBlueScore())
            return false;
        return true;
    }

    public int getMatchCompetitionID()
    {
        return competitionID;
    }
}