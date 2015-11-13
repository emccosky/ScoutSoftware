package scoutapp;

import java.util.*;
import java.io.*;

public class Season
{
    int startYear;
    public ArrayList<Competition> competitions;
    public ArrayList<Team> teams;

    public Season()
    {
        competitions = new ArrayList<Competition>();
        teams = new ArrayList<Team>();
        startYear = 2015;
    }

      public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }


    public void setCompetitions(ArrayList<Competition> competitions) {
        this.competitions = competitions;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addCompetition(Competition comp)
    {
        competitions.add(comp);
    }
    
    public void addTeam(Team team)
    {
        teams.add(team);
    }
    
    public void addMatch(Match match)
    {
        for(Competition comp : competitions)
        {
            if(comp.getCompetitionID() == match.getMatchCompetitionID())
                comp.addMatch(match);
        }

    }
}
