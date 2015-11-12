package scoutapp;

import java.util.*;
import java.io.*;

public class Competition 
{
    private int competitionID;
    protected ArrayList<Match> matches;
    protected ArrayList<Integer> teamIDs;

    public Competition(int compID)
    {
        competitionID = compID;
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
    }

    public ArrayList<Match> getMatches()
    {
        return matches;
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
}