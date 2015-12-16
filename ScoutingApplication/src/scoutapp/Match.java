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
    int redScoreAdjusted; //RedTotalScore - redScoreFromPenalties - blueScoreFromPenalties. Works better in MMR algorithm
    int blueTotalScore;
    int blueScoreFromPenalties; //How many points blue gained from penalties
    int blueScoreAdjusted; //blueTotalScore - redScoreFromPenalties - blueScoreFromPenalties. Works better in MMR algorithm

    boolean isRed1Surrogate; //Is this a surrogate match for red1
    boolean isRed2Surrogate; //Is this a surrogate match for red2
    boolean isBlue1Surrogate; //Is this a surrogate match for blue1
    boolean isBlue2Surrogate; //Is this a surrogate match for blue2
    
    String blueComments; //Comments on blue side of the match
    String redComments; //Comments on red side of the match

    public Match(int compID, int mNum) //Default constructor for a match (Competition ID and match # needed)
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
        blueComments = "";
        redComments = "";
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID) //Match constructor with compID, match #, and team IDs
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
        blueComments = "";
        redComments = "";
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rTotScore, int bTotScore, String bComments, String rComments) //Match constructor with compID, match #, team IDs, side scores, and match comments
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
        blueComments = bComments;
        redComments = rComments;
    }

    public Match(int compID, int mNum, int red1ID, int red2ID, int blue1ID, int blue2ID, int rTotScore, int bTotScore, boolean red1S, boolean red2S, boolean blue1S, boolean blue2S, String bComments, String rComments) //Match constructor with compID, match #, team IDs, side scores, match comments, and surrogate information
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
        isRed1Surrogate = red1S;
        isRed2Surrogate = red2S;
        isBlue1Surrogate = blue1S;
        isBlue2Surrogate = blue2S;
        blueComments = bComments;
        redComments = rComments;
    }

    public int getCompetitionID() { //Returns the ID of the competition the match is in
        return competitionID;
    }

    public void setCompetitionID(int competitionID) { //Sets the ID of the competition the match is in
        this.competitionID = competitionID;
    }

    public int getMatchNum() { //Returns the match number of the match
        return matchNum;
    }

    public void setMatchNum(int matchNum) {   //Sets the match number of the match
        this.matchNum = matchNum;
    }

    public int getRed1ID() { //Returns the teamID of the red1 team
        return red1ID;
    }

    public void setRed1ID(int red1ID) { //Sets the teamID of the red1 team
        this.red1ID = red1ID;
    }

    public int getRed2ID() { //Returns the teamID of the red2 team
        return red2ID;
    }

    public void setRed2ID(int red2ID) { //Sets the teamID of the red2 team
        this.red2ID = red2ID;
    }

    public int getBlue1ID() { //Returns the teamID of the blue1 team
        return blue1ID;
    }

    public void setBlue1ID(int blue1ID) { //Sets the teamID of the blue1 team
        this.blue1ID = blue1ID;
    }

    public int getBlue2ID() { //Returns the teamID of the blue2 team
        return blue2ID;
    }

    public void setBlue2ID(int blue2ID) { //Sets the teamID of the blue2 team
        this.blue2ID = blue2ID;
    }

    public int getRedTotalScore() { //Returns the totalScore of red
        return redTotalScore;
    }

    public void setRedTotalScore(int redTotalScore) { //Sets the total score of red
        this.redTotalScore = redTotalScore;
    }

    public int getRedScoreFromPenalties() { //Returns the amount of points red gained from penalties
        return redScoreFromPenalties;
    }

    public void setRedScoreFromPenalties(int redScoreFromPenalties) { //Sets the amount of points red gained from penalties
        this.redScoreFromPenalties = redScoreFromPenalties;
    }

    public int getRedScoreAdjusted() { //Returns the adjustedScore of red
        return redScoreAdjusted;
    }

    public void setRedScoreAdjusted(int redScoreAdjusted) { //Sets the adjustedScore of red
        this.redScoreAdjusted = redScoreAdjusted;
    }

    public int getBlueTotalScore() { //Returns blue's total score in the match
        return blueTotalScore;
    }

    public void setBlueTotalScore(int blueTotalScore) { //Sets blue's total score for the match
        this.blueTotalScore = blueTotalScore;
    }

    public int getBlueScoreFromPenalties() { //Returns the # of points blue gained from penalties
        return blueScoreFromPenalties;
    }

    public void setBlueScoreFromPenalties(int blueScoreFromPenalties) { //Sets the # of points blue gained from penalties
        this.blueScoreFromPenalties = blueScoreFromPenalties;
    }

    public int getBlueScoreAdjusted() { //Returns blue's adjusted score
        return blueScoreAdjusted;
    }

    public void setBlueScoreAdjusted(int blueScoreAdjusted) { //Sets blue's adjusted score
        this.blueScoreAdjusted = blueScoreAdjusted;
    }

    public boolean isIsRed1Surrogate() { //Returns true if it is a surrogate match for red1, false if it is not
        return isRed1Surrogate;
    }

    public void setIsRed1Surrogate(boolean isRed1Surrogate) { //Sets the isRed1Surrogate variable
        this.isRed1Surrogate = isRed1Surrogate;
    }

    public boolean isIsRed2Surrogate() { //Returns true if it is a surrogate match for red2, false if it is not
        return isRed2Surrogate;
    }

    public void setIsRed2Surrogate(boolean isRed2Surrogate) { //Sets the isRed2Surrogate variable
        this.isRed2Surrogate = isRed2Surrogate;
    }

    public boolean isIsBlue1Surrogate() { //Returns true if it is a surrogate match for blue1, false if it is not
        return isBlue1Surrogate;
    }

    public void setIsBlue1Surrogate(boolean isBlue1Surrogate) { //Sets the isBlue1Surrogate variable
        this.isBlue1Surrogate = isBlue1Surrogate;
    }

    public boolean isIsBlue2Surrogate() { //Returns true if it is a surrogate match for blue2, false if it is not
        return isBlue2Surrogate;
    }

    public void setIsBlue2Surrogate(boolean isBlue2Surrogate) { //Sets the isBlue2Surrogate variable
        this.isBlue2Surrogate = isBlue2Surrogate;
    }

    public String getBlueComments() { //Returns the comments for blue
        return blueComments;
    }

    public void setBlueComments(String blueComments) { //Sets the comments for blue
        this.blueComments = blueComments;
    }

    public String getRedComments() { //Returns the comments for red
        return redComments;
    }

    public void setRedComments(String redComments) { //Sets the comments for red
        this.redComments = redComments;
    }
    
    public int getScore(int teamID) //Returns an alliance's score based on the passed team's teamID
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueTotalScore;
        else if(teamID == red1ID || teamID == red2ID)
            return redTotalScore;
        else
            return -1;
    }
    
    public int getOpponentScore(int teamID) //Returns an opposing allinace's score based on the passed team's teamID
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return redTotalScore;
        else if(teamID == red1ID || teamID == red2ID)
            return blueTotalScore;
        else
            return -1;
    }

    public int getAdjustedScore(int teamID) //Returns an alliance's adjusted score based on the passed team's teamID
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueScoreAdjusted;
        else if(teamID == red1ID || teamID == red2ID)
            return redScoreAdjusted;
        else
            return -1;
    }

    public int getPointsFromPenalties(int teamID) //Returns an alliances points from penalties based on the passed team's teamID
    {
        if(teamID == blue1ID || teamID == blue2ID)
            return blueScoreFromPenalties;
        else if(teamID == red1ID || teamID == red2ID)
            return redScoreFromPenalties;
        else
            return -1;
    }

    public int getMatchBlue1ID() //Returns the ID of the blue1 team
    {
        return blue1ID;
    }

    public int getMatchBlue2ID() //Returns the teamID of the blue2 team
    {
        return blue2ID;
    }

    public int getMatchRed1ID() //Returns the ID of the red1 team
    {
        return red1ID;
    }

    public int getMatchRed2ID() //Returns the teamID of the red2 team
    {
        return red2ID;
    }

    public int getMatchRedTotalScore() //Returns red's total score for the match
    {
        return redTotalScore;
    }

    public int getMatchBlueTotalScore() //Returns blue's total score for the match
    {
        return blueTotalScore;
    }

    public int getMatchBlueScoreFromPenalties() //Gets blue's score from penalties
    {
        return blueScoreFromPenalties;
    }
    
    public int getMatchRedScoreFromPenalties() //Returns red's score from penalties
    {
        return redScoreFromPenalties;
    }
    
    public int getMatchRedScoreAdjusted() //Returns the adjusted score for red
    {
        return redScoreAdjusted;
    }
    
    public int getMatchBlueScoreAdjusted() //Returns the adjusted score for blue
    {
        return blueScoreAdjusted;
    }

    public boolean equals(Match a) //Compares two matches, returns true if they are the same, false if they are not
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

    public int getAlliancePartnerID(int teamID) //Returns the alliance partner ID of an alliance partner based on their 
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
    
    public boolean contains(int teamID){ //Checks if a team is in the mathc or not (True if it is, false if it isn't
        if(teamID == blue1ID || teamID == blue2ID || teamID == red1ID || teamID == red2ID)
            return true;
        else
            return false;
    }

    public int getMatchCompetitionID() //Returns the match's competitionID
    {
        return competitionID;
    }
}