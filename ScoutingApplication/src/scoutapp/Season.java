package scoutapp;

import java.util.*;
import java.io.*;

public class Season {

    int startYear;
    private ArrayList<Competition> competitions;
    private ArrayList<Team> teams;

    public Season() {
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
    
    public Team getTeam(int teamNum) {
        for (Team t : teams) {
            if (t.getTeamID() == teamNum) {
                return t;
            }
        }
        return null;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void addCompetition(Competition comp) {
        competitions.add(comp);
    }

    public void addTeam(Team team) {
        for(Team currTeam : teams){
            if(currTeam.equals(team))
                return;
        }
        teams.add(team);
    }
    
    public void changeTeamName(int teamID, String name){
        for (Team t : teams) {
            if (t.getTeamID() == teamID) {
                t.setTeamName(name);
            }
        }
    }
    
    public void changeTeamLocation(int teamID, String place){
        for (Team t : teams) {
            if (t.getTeamID() == teamID) {
                t.setLocation(place);
            }
        }
    }
    
    public boolean hasTeam(int teamNum) {
        for (Team t : teams) {
            if (t.getTeamID() == teamNum) {
                return true;
            }
        }
        return false;
    }

    public void addMatch(Match match) {
        for (Competition comp : competitions) {
            if (comp.getCompetitionID() == match.getMatchCompetitionID()) {
                comp.addMatch(match);
                addTeam(new Team(match.getBlue1ID()));
                addTeam(new Team(match.getBlue2ID()));
                addTeam(new Team(match.getRed1ID()));
                addTeam(new Team(match.getRed2ID()));
            }
        }
    }
    
    public int getNextCompID() {
        int highestID = -1;
        for (Competition comp : competitions) {
            if (comp.getCompetitionID() > highestID){
                highestID = comp.getCompetitionID();
            }
        }
        return ++highestID;
    }
    
    public Competition getCompByID(int compID) {
        for(Competition comp : competitions){
            if (comp.getCompetitionID() == compID)
                return comp;
        }
        return null;
    }
    
    public Competition getCompByName(String compName) {
        for(Competition comp : competitions){
            if (comp.getCompName().equals(compName))
                return comp;
        }
        return null;
    }
    
    public void replaceComp(int compID, Competition newComp){
        int index = competitions.indexOf(getCompByID(compID));
        competitions.set(index, newComp);
    }
}
