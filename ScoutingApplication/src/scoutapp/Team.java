package scoutapp;

import java.util.*;
import java.io.*;

public class Team
{
    int teamID;
    String teamName;
    private ArrayList<Match> teamMatches;

    public Team(int id, String name)
    {
        teamID = id;
        teamName = name;
        teamMatches = new ArrayList<Match>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<Match> getTeamMatches() {
        return teamMatches;
    }

    public void setTeamMatches(ArrayList<Match> teamMatches) {
        this.teamMatches = teamMatches;
    }

    public void addMatch(Match match)
    {
        teamMatches.add(match);
    }

    public int getTeamID()
    {
        return teamID;
    }

    public ArrayList<Match> getMatches()
    {
        return teamMatches;
    }
    
    public ArrayList<Match> getMatchesFromCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = new ArrayList<Match>();
        for(Match m : teamMatches)
        {
            if(m.getMatchCompetitionID() == compID)
            {
                competitionMatches.add(m);
            }
        }
        return competitionMatches;
    }

    public double getAvgScore()
    {
        double avg = DataCruncher.getAvgMatchScore(teamID, teamMatches);
        return avg;
    }

    public double getAvgScoreAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        for(Match m : teamMatches)
        {
            if(m.getMatchCompetitionID() == compID)
            {
                competitionMatches.add(m);
            }
        }
        double avg = DataCruncher.getAvgMatchScore(teamID, competitionMatches);
        return avg; //Format to two decimal places
    }

    public int getMMR()
    {
        int MMR = DataCruncher.getMMR(teamID, teamMatches);
        return MMR;
    }

    public int getMMRAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int MMR = DataCruncher.getMMR(teamID, competitionMatches);
        return MMR;
    }

    public int getAvgPartnerMMR()
    {
        int avgPartnerMMR = DataCruncher.getAvgMMROfPartners(teamID, teamMatches);
        return avgPartnerMMR;
    }

    public int getAvgPartnerMMRAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int avgPartnerMMR = DataCruncher.getAvgMMROfPartners(teamID, competitionMatches);
        return avgPartnerMMR;
    }

    public double getConsistency()
    {
        double consistency = DataCruncher.getConsistency(teamID, teamMatches);
        return consistency; //Format to two decimal places
    }

    public double getConsistencyAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        double consistency = DataCruncher.getConsistency(teamID, competitionMatches);
        return consistency;
    }

    public double getDefensiveness()
    {
        double defensiveness = DataCruncher.getDefensiveness(teamID, teamMatches);
        return defensiveness;
    }

    public double getDefensivenessAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        double defensiveness = DataCruncher.getDefensiveness(teamID, competitionMatches);
        return defensiveness;
    }

    public int getQP()
    {
        int QP = DataCruncher.getQP(teamID, teamMatches);
        return QP;
    }

    public int getQPAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int QP = DataCruncher.getQP(teamID, competitionMatches);
        return QP;
    }

    public int getRP()
    {
        int RP = DataCruncher.getRP(teamID, teamMatches);
        return RP;
    }

    public int getRPAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int RP = DataCruncher.getRP(teamID, competitionMatches);
        return RP;
    }

    public String getPredictedScoreRange()
    {
        String predictedScoreRange = DataCruncher.getPredictedScoreRange(teamID, teamMatches);
        return predictedScoreRange;
    }

    public String getPredictedScoreRangeAtCompetition(int compID)
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        String predictedScoreRange = DataCruncher.getPredictedScoreRange(teamID, competitionMatches);
        return predictedScoreRange;
    }
}