package scoutapp;

import java.util.*;
import java.io.*;

public class Competition 
{
    private int competitionID;
    private String compName;
    private String compDate;
    protected ArrayList<Match> matches;
    protected ArrayList<Integer> teamIDs;

    public Competition(int compID) //Constructor for competition with just an ID
    {
        competitionID = compID;
        compName = competitionID+"";
        compDate = "";
        matches = new ArrayList<Match>();
        teamIDs = new ArrayList<Integer>();
    }
    
    public Competition(int compID, String name, String date) //Constructor for competition with name and date
    {
        competitionID = compID;
        compName = name;
        compDate = date;
        matches = new ArrayList<Match>();
        teamIDs = new ArrayList<Integer>();
    }

    public void addTeam(Team team) //Adds a new team to the teamIDs arraylist if its not already in there
    {
        int id = team.getTeamID();
        if(!teamIDs.contains(id))
            teamIDs.add(team.getTeamID());
    }

    public void addMatch(Match match) //Adds the match to the competition and to the teams involved
    {
        matches.add(match);
        
        //update the teams
        addTeam(match.getBlue1ID());
        addTeam(match.getBlue2ID());
        addTeam(match.getRed1ID());
        addTeam(match.getRed2ID());
    }
    
    private void addTeam(int teamID){ //Adds a team to the competition
        for(Integer team : teamIDs){
            if(team == teamID){
                return;
            }
        }
        teamIDs.add(teamID);
    }

    public ArrayList<Match> getMatches() //Returns matches from the competition
    {
        return matches;
    }

    public Match getMatchByNum(int matchNum){ //Returns match by the match number
        for(Match m : matches){
            if(m.getMatchNum() == matchNum)
                return m;
        }
        return null;
    }
    
    public void replaceMatch(int matchNum, Match newMatch){ //Replaces match with another match
        for(int i = 0; i < matches.size(); i++){
            if(matches.get(i).getMatchNum() == matchNum)
                matches.set(i, newMatch);
        }
    }
    
    public ArrayList<Integer> getTeamIDs() //Returns all teamIDs in the competition
    {
        return teamIDs;
    }

    public void setMatches(ArrayList<Match> a) //Sets the whole match arraylist
    {
        matches = a;
    }

    public void setTeamIDs(ArrayList<Integer> IDs) //Sets the teamIDs arraylist
    {
        teamIDs = IDs;
    }

    public int getCompetitionID() //Returns the competition ID
    {
        return competitionID;
    }

    public String getCompName() //Returns the name of the competition
    {
        return compName;
    }

    public void setCompName(String compName) //Sets the competition name
    {
        this.compName = compName;
    }

    public String getCompDate() //Sets the competition date
    {
        return compDate;
    }

    public void setCompDate(String compDate) //Sets competition date
    {
        this.compDate = compDate;
    }
    
    public int getNextMatchID() //Returns the next available match ID
    {
        int highestID = -1;
        for (Match m : matches) {
            if (m.getMatchNum() > highestID){
                highestID = m.getMatchNum();
            }
        }
        return ++highestID;
    }
}