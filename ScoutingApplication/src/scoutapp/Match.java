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
    int redTotalScore;
    int redScoreFromPenalties;
    int redScoreAdjusted;
    int blueTotalScore;
    int blueScoreFromPenalties;
    int blueScoreAdjusted;

    boolean isRed1Surrogate;
    boolean isRed2Surrogate;
    boolean isBlue1Surrogate;
    boolean isBlue2Surrogate;

    public Match(int compID, int mNum)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = -1;
        this.red2ID = -1;
        this.blue1ID = -1;
        this.blue2ID = -1;
        redTotalScore = -1;
        blueTotalScore = -1;
        redScoreAdjusted = -1;
        blueScoreAdjusted = -1;
        redScoreFromPenalties = -1;
        blueScoreFromPenalties = -1;
        isRed1Surrogate = false;
        isRed2Surrogate = false;
        isBlue1Surrogate = false;
        isBlue2Surrogate = false;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redTotalScore = -1;
        redScoreFromPenalties = -1;
        redScoreAdjusted = -1;
        blueTotalScore = -1;
        blueScoreFromPenalties = -1;
        blueScoreAdjusted = -1;
        isRed1Surrogate = false;
        isRed2Surrogate = false;
        isBlue1Surrogate = false;
        isBlue2Surrogate = false;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rTotScore, int bTotScore)
    {
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redTotalScore = rTotScore;
        redScoreFromPenalties = -1;
        redScoreAdjusted = -1;
        blueTotalScore = bTotScore;
        blueScoreFromPenalties = -1;
        blueScoreAdjusted = -1;
        isRed1Surrogate = false;
        isRed2Surrogate = false;
        isBlue1Surrogate = false;
        isBlue2Surrogate = false;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rTotScore, int bTotScore, boolean red1S, boolean red2S, boolean blue1S, boolean blue2S)
    { 
        competitionID = compID;
        matchNum = mNum;
        this.red1ID = red1ID;
        this.red2ID = red2ID;
        this.blue1ID = blue1ID;
        this.blue2ID = blue2ID;
        redTotalScore = rTotScore;
        redScoreFromPenalties = -1;
        redScoreAdjusted = -1;
        blueTotalScore = bTotScore;
        blueScoreFromPenalties = -1;
        blueScoreAdjusted = -1;
        isRed1Surrogate = false;
        isRed2Surrogate = false;
        isBlue1Surrogate = false;
        isBlue2Surrogate = false;
    }

    //TODO: ADD CONSTRUCTOR FOR PENALTIES
    public int getScore(int teamID)
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueTotalScore;
        else if(teamID == red1ID || teamID == red2ID)
            return redTotalScore;
        else
            return -1;
    }

    public int getAdjustedScore(int teamID)
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueScoreAdjusted;
        else if(teamID == red1ID || teamID == red2ID)
            return redScoreAdjusted;
        else
            return -1;
    }

    public int getPointsFromPenalties(int teamID)
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueScoreFromPenalties;
        else if(teamID == red1ID || teamID == red2ID)
            return redScoreFromPenalties;
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

    public int getMatchRedTotalScore()
    {
        return redTotalScore;
    }

    public int getMatchBlueTotalScore()
    {
        return blueTotalScore;
    }

    public int getMatchBlueScoreFromPenalties()
    {
        return blueScoreFromPenalties;
    }
    
    public int getMatchRedScoreFromPenalties()
    {
        return redScoreFromPenalties;
    }
    
    public int getMatchRedScoreAdjusted()
    {
        return redScoreAdjusted;
    }
    
    public int getMatchBlueScoreAdjusted()
    {
        return blueScoreAdjusted;
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
        if(redScoreAdjusted != a.getMatchRedTotalScore())
            return false;
        if(blueScoreAdjusted != a.getMatchBlueTotalScore())
            return false;
        if(blueScoreFromPenalties != a.getMatchBlueScoreFromPenalties())
            return false;
        if(redScoreFromPenalties != a.getMatchRedScoreFromPenalties())
            return false;
        if(redTotalScore != a.getMatchRedTotalScore())
            return false;
        if(blueTotalScore != a.getMatchBlueTotalScore())
            return false;
        return true;
    }

    public int getAlliancePartnerID(int teamID)
    {
        if(teamID == blue1ID)
            return blue2ID;
        else if(teamID == blue2ID)
            return blue1ID;
        else if(teamID == red1ID)
            return red2ID;
        else if(teamID == red2ID)
            return red1ID;
        else
            return -1;
    }

    public int getMatchCompetitionID()
    {
        return competitionID;
    }
}