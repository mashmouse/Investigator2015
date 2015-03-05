package database;

import java.util.ArrayList;

import database.match.Match;
import main.ServerRunner;

public class TeamDataBase {

    private ArrayList<RoboTeam> TEAMS;
    private ArrayList<Match> MATCHES;

    public TeamDataBase() {
        TEAMS = new ArrayList<RoboTeam>();
    }

    public void addTeam(RoboTeam team) {
        TEAMS.add(team);
    }

    public void addMatch(Match match){
        MATCHES.add(match);
        while(match.getTeams().hasMoreElements()){
            ServerRunner.THE_DATABASE.getTeam(match.getTeams().nextElement()).addMatch(match);
        }
    }

    public ArrayList<RoboTeam> searchTeamNumber(String search) {
        ArrayList<RoboTeam> teams = new ArrayList<RoboTeam>();
        for (RoboTeam currentTeam : TEAMS) {
            if (currentTeam.getTeamNumber().startsWith(search)) {
                teams.add(currentTeam);
            }
        }
        return teams;
    }

    public RoboTeam getTeam(String teamNumber) {
        RoboTeam team = null;
        for (RoboTeam currentTeam : TEAMS) {
            if (currentTeam.getTeamNumber().equals(teamNumber)) {
                team = currentTeam;
            }
        }
        return team;
    }

    public Match getMatch(String matchNumber) {
        for (Match m : MATCHES) {
            if (m.getMatchNumber().equals(matchNumber)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Match> getMatches() {
        return MATCHES;
    }
    
    public static void printTeamArray(ArrayList<RoboTeam> teams) {
        for (RoboTeam team : teams) {
            System.out.println(team);
        }
    }

    public String toString() {
        String output = "";
        for (RoboTeam team : TEAMS) {
            output += team + "\n";
        }
        return output;
    }
}