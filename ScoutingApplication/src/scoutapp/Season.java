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

    public void addCompetition(Competition comp)
    {
        competitions.add(comp);
    }

    public void addMatch(Match m)
    {
        for(Competition comp : competitions)
            if(m.getMatchCompetitionID() == comp.getCompetitionID())
                comp.addMatch(m);
    }
}
