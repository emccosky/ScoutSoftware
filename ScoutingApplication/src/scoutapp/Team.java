package scoutapp;

import java.util.*;
import java.io.*;

public class Team
{
    int teamID;
    String teamName;
    String location;
    ArrayList<String> labels = new ArrayList<String>();
    Boolean[] scouting;
    ArrayList<String> sliderLabels = new ArrayList<String>();
    Integer[] sliders;
    String baseType;
    String designComments;
    String adjective;
    private ArrayList<Match> teamMatches;
    

    public Team(int id) //Team constructor with just an ID
    {
        labels.addAll(Arrays.asList("pushbotRadio", "notPushbotRadio", "debrisFloorBox","debrisLowBox","debrisMidBox","debrisHighBox","lowZoneBox","midZoneBox","highZoneBox","hangBox","noneEndgameBox","autoClimbersBox","autoNoneBox","autoLowZoneBox","autoMidZoneBox","autoHighZoneBox","autoBeaconBox","autoPartlyBox"));
        sliderLabels.addAll(Arrays.asList("debrisLevelSlider","climbLevelSlider","hangLevelSlider"));
        this.scouting = new Boolean[labels.size()];
        for(int i = 0; i < labels.size(); i++){
            scouting[i] = false;
        }
        this.sliders = new Integer[sliderLabels.size()];
        for(int i = 0; i < sliderLabels.size(); i++){
            sliders[i] = 0;
        }
        baseType = "";
        designComments = "";
        adjective = "";
        teamID = id;
        teamName = "";
        teamMatches = new ArrayList<Match>();
    }

    public Team(int id, String name) //Team constructor with an ID and name
    {
        labels.addAll(Arrays.asList("pushbotRadio", "notPushbotRadio", "debrisFloorBox","debrisLowBox","debrisMidBox","debrisHighBox","lowZoneBox","midZoneBox","highZoneBox","hangBox","noneEndgameBox","autoClimbersBox","autoNoneBox","autoLowZoneBox","autoMidZoneBox","autoHighZoneBox","autoBeaconBox","autoPartlyBox"));
        sliderLabels.addAll(Arrays.asList("debrisLevelSlider","climbLevelSlider","hangLevelSlider"));
        this.scouting = new Boolean[labels.size()];
        for(int i = 0; i < labels.size(); i++){
            scouting[i] = false;
        }
        this.sliders = new Integer[sliderLabels.size()];
        for(int i = 0; i < sliderLabels.size(); i++){
            sliders[i] = 0;
        }
        baseType = "";
        designComments = "";
        adjective = "";
        teamID = id;
        teamName = name;
        teamMatches = new ArrayList<Match>();
    }

    public String getTeamName() //Returns the team name
    {
        return teamName;
    }

    public void setTeamName(String teamName) //Sets the team name
    {
        this.teamName = teamName;
    }

    public ArrayList<Match> getTeamMatches() //Gets 
    {
        return teamMatches;
    }

    public void setTeamMatches(ArrayList<Match> teamMatches) //Sets the team matches
    {
        this.teamMatches = teamMatches;
    }

    public void addMatch(Match match) //Adds match
    {
        teamMatches.add(match);
    }

    public void clearMatches() //Clears your moms matches
    {
        teamMatches.clear();
    }

    public int getTeamID() //Gets the ID of the team
    {
        return teamID;
    }
    
    public String getLocation() //Returns location
    {
        return location;
    }

    public void setLocation(String location) //Sets the location
    {
        this.location = location;
    }

    public ArrayList<String> getLabels() //Returns the labels object
    {
        return labels;
    }
    
    public ArrayList<String> getSliderLabels() //Returns the slider labels
    {
        return sliderLabels;
    }

    public Boolean[] getScouting() //Returns scouting array
    {
        return scouting;
    }

    public void setScouting(Boolean[] scouting) //Sets scouting boolean array
    {
        this.scouting = scouting;
    }

    public Integer[] getSliders() //Returns all the slider info
    {
        return sliders;
    }

    public void setSliders(Integer[] sliders) //Sets the sliders array
    {
        this.sliders = sliders;
    }

    public String getBaseType() //Sets the type of base
    {
        return baseType;
    }

    public void setBaseType(String baseType) //Sets the base type
    {
        this.baseType = baseType;
    }

    public String getDesignComments() //Returns the comments on the design
    {
        return designComments;
    }

    public void setDesignComments(String designComments) //Sets the design comments
    {
        this.designComments = designComments;
    }

    public String getAdjective() //Returns the "team adjective"
    {
        return adjective;
    }

    public void setAdjective(String adjective) //Sets the "team adjective"
    {
        this.adjective = adjective;
    }

    public ArrayList<Match> getMatches() //Gets the team's matches
    {
        return teamMatches;
    }

    public ArrayList<Match> getMatchesFromCompetition(int compID) //Gets the matches from a specific competition
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

    public double getAvgScore() //Returns the team's average score for the whole season
    {
        double avg = DataCruncher.getAvgMatchScore(teamID, teamMatches);
        return avg;
    }

    public double getAvgScoreAtCompetition(int compID) //Get average competition
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

    public int getMMR() //Gets the team's MMR
    {
        int MMR = DataCruncher.getMMR(teamID, teamMatches);
        return MMR;
    }

    public int getMMRAtCompetition(int compID) //Gets team's MMR at a specific competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int MMR = DataCruncher.getMMR(teamID, competitionMatches);
        return MMR;
    }

    public double getAvgPartnerMMR() //Gets the team's partner's MMR for the whole season
    {
        double avgPartnerMMR = DataCruncher.getAvgMMROfPartners(teamID, teamMatches);
        return avgPartnerMMR;
    }

    public double getAvgPartnerMMRAtCompetition(int compID) //Gets the team's partner's MMR for a specific competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        double avgPartnerMMR = DataCruncher.getAvgMMROfPartners(teamID, competitionMatches);
        return avgPartnerMMR;
    }

    public double getConsistency() //Returns the team's consistency
    {
        double consistency = DataCruncher.getConsistency(teamID, teamMatches);
        return consistency; //Format to two decimal places
    }

    public double getConsistencyAtCompetition(int compID) //Returns the team's consistency at a competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        double consistency = DataCruncher.getConsistency(teamID, competitionMatches);
        return consistency;
    }

    public double getDefensiveness() //Returns team's defensiveness
    {
        double defensiveness = DataCruncher.getDefensiveness(teamID, teamMatches);
        return defensiveness;
    }

    public double getDefensivenessAtCompetition(int compID) //Returns team's defensiveness
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        double defensiveness = DataCruncher.getDefensiveness(teamID, competitionMatches);
        return defensiveness;
    }

    public int getQP() //Returns the team's QP for the whole season
    {
        int QP = DataCruncher.getQP(teamID, teamMatches);
        return QP;
    }

    public int getQPAtCompetition(int compID) //Returns the team's QP at a specific competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int QP = DataCruncher.getQP(teamID, competitionMatches);
        return QP;
    }

    public int getRP() //Returns the team's RP for the whole season
    {
        int RP = DataCruncher.getRP(teamID, teamMatches);
        return RP;
    }

    public int getRPAtCompetition(int compID) //Returns the team's RP for the competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        int RP = DataCruncher.getRP(teamID, competitionMatches);
        return RP;
    }

    public String getPredictedScoreRange() //Returns the team's predicted score range for the whole season
    {
        String predictedScoreRange = DataCruncher.getPredictedScoreRange(teamID, teamMatches);
        return predictedScoreRange;
    }

    public String getPredictedScoreRangeAtCompetition(int compID) //Returns the team's predicted score range at a competition
    {
        ArrayList<Match> competitionMatches = this.getMatchesFromCompetition(compID);
        String predictedScoreRange = DataCruncher.getPredictedScoreRange(teamID, competitionMatches);
        return predictedScoreRange;
    }
    
    public boolean equals(Team t){ //Compares the team to another team
        if(t.getTeamID() == teamID)
            return true;
        return false;
    }
}