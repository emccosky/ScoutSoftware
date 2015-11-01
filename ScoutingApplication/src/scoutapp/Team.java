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

    public void addMatch(Match match)
    {
        teamMatches.add(match);
    }

    public int getTeamID()
    {
        return teamID;
    }
    
    public int getAvgScoreAtCompetition(int compID)
    {
        double avgScore = 0.0;
        int c = 0;
        for(Match m : teamMatches)
        {
            if(m.getMatchCompetitionID() == compID)
            {
                avgScore += m.getScore(teamID);
                c++;
            }
        }
        avgScore /= c;
        return (int) avgScore;
    }
}
