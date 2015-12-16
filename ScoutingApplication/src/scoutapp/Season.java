package scoutapp;

import java.util.*;
import java.io.*;

public class Season { //Class for a season

    int startYear;
    private ArrayList<Competition> competitions;
    private ArrayList<Team> teams;

    public Season() { //Default constructor for the Season class
        competitions = new ArrayList<Competition>();
        teams = new ArrayList<Team>();
        startYear = 2015;
    }

    public int getStartYear() { //Returns the start year of the season
        return startYear;
    }

    public void setStartYear(int startYear) { //Sets the start year for the season
        this.startYear = startYear;
    }

    public ArrayList<Competition> getCompetitions() { //Returns the competitions arraylist
        return competitions;
    }

    public void setCompetitions(ArrayList<Competition> competitions) { //Sets the arraylist of competitions
        this.competitions = competitions;
    }

    public ArrayList<Team> getTeams() { //Returns the arraylist of teams
        return teams;
    }
    
    public Team getTeam(int teamNum) { //Returns the team indicated by the parameter "teamNum"
        for (Team t : teams) {
            if (t.getTeamID() == teamNum) {
                return t;
            }
        }
        return null;
    }

    public void setTeams(ArrayList<Team> teams) { //Sets the teams arraylist to the parameter
        this.teams = teams;
    }

    public void addCompetition(Competition comp) { //Adds a new competition to the season
        competitions.add(comp);
    }

    public void addTeam(Team team) { //Adds a new team to the season
        for(Team currTeam : teams){
            if(currTeam.equals(team))
                return;
        }
        teams.add(team);
    }
    
    public void changeTeamName(int teamID, String name){ //Change the team's name to name. Team is indicated by teamID
        for (Team t : teams) {
            if (t.getTeamID() == teamID) {
                t.setTeamName(name);
            }
        }
    }
    
    public void changeTeamLocation(int teamID, String place){ //Sets the team's location
        for (Team t : teams) {
            if (t.getTeamID() == teamID) {
                t.setLocation(place);
            }
        }
    }
    
    public boolean hasTeam(int teamNum) { //Returns true if the season has the team indicated by teamNum, false if it does not
        for (Team t : teams) {
            if (t.getTeamID() == teamNum) {
                return true;
            }
        }
        return false;
    }

    public void addMatch(Match match) { //Adds a new match to the competition
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
    
    public int getNextCompID() { //Returns the next available competition ID
        int highestID = -1;
        for (Competition comp : competitions) {
            if (comp.getCompetitionID() > highestID){
                highestID = comp.getCompetitionID();
            }
        }
        return ++highestID;
    }
    
    public Competition getCompByID(int compID) { //Parameter of a competition's ID, returns the competition with that name
        for(Competition comp : competitions){
            if (comp.getCompetitionID() == compID)
                return comp;
        }
        return null;
    }
    
    public Competition getCompByName(String compName) { //Parameter of a competition's name, returns the competition with that name
        for(Competition comp : competitions){
            if (comp.getCompName().equals(compName))
                return comp;
        }
        return null;
    }
    
    public void replaceComp(int compID, Competition newComp){ //Replaces the competition specified by the ID with a new competition, newComp
        int index = competitions.indexOf(getCompByID(compID));
        competitions.set(index, newComp);
    }
}