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

    public Competition(int compID)
    {
        competitionID = compID;
        compName = competitionID+"";
        compDate = "";
        matches = new ArrayList<Match>();
        teamIDs = new ArrayList<Integer>();
    }
    
    public Competition(int compID, String name, String date)
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
    
    private void addTeam(int teamID){
        for(Integer team : teamIDs){
            if(team == teamID){
                return;
            }
        }
        teamIDs.add(teamID);
    }

    public ArrayList<Match> getMatches()
    {
        return matches;
    }

    public Match getMatchByNum(int matchNum){
        for(Match m : matches){
            if(m.getMatchNum() == matchNum)
                return m;
        }
        return null;
    }
    
    public void replaceMatch(int matchNum, Match newMatch){
        for(int i = 0; i < matches.size(); i++){
            if(matches.get(i).getMatchNum() == matchNum)
                matches.set(i, newMatch);
        }
    }
    
    public ArrayList<Integer> getTeamIDs()
    {
        return teamIDs;
    }

    public void setMatches(ArrayList<Match> a)
    {
        matches = a;
    }

    public void setTeamIDs(ArrayList<Integer> IDs)
    {
        teamIDs = IDs;
    }

    public int getCompetitionID()
    {
        return competitionID;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDate() {
        return compDate;
    }

    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }
    
    public int getNextMatchID() {
        int highestID = -1;
        for (Match m : matches) {
            if (m.getMatchNum() > highestID){
                highestID = m.getMatchNum();
            }
        }
        return ++highestID;
    }
}