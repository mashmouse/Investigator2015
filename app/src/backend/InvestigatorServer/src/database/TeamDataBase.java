package database;
import java.util.ArrayList;

import match.Match;

public class TeamDataBase {
	private ArrayList<RoboTeam> TEAMS; 
	
	public TeamDataBase() {
		TEAMS = new ArrayList<RoboTeam>();
	}
	
	public void add(RoboTeam team) {
		TEAMS.add(team);
	}
	
	public ArrayList<RoboTeam> searchTeamNumber(String search) {
		ArrayList<RoboTeam> teams = new ArrayList<RoboTeam>();
		for(RoboTeam currentTeam: TEAMS) {
			if(currentTeam.getTeamNumber().startsWith(search)) {
				teams.add(currentTeam);
			}
		}
		return teams;
	}
	
	public RoboTeam getTeam(String teamNumber) {
		RoboTeam team = null;
		for(RoboTeam currentTeam: TEAMS) {
			if(currentTeam.getTeamNumber().equals(teamNumber)) {
				team = currentTeam;
			}
		}
		return team;
	}
	
	public ArrayList<RoboTeam> searchMatchNumber(String search) {
		ArrayList<RoboTeam> teams = new ArrayList<RoboTeam>();
		for(RoboTeam currentTeam: TEAMS) {
			for(Match currentMatch: currentTeam.getMatches()) {
				if(currentMatch.getMatchNumber().startsWith(search)) {
					teams.add(currentTeam);
					break;
				}
			}
		}
		return teams;
	}
	
	public static void printTeamArray(ArrayList<RoboTeam> teams) {
		for(RoboTeam team: teams) {
			System.out.println(team);
		}
	}
	
	public String toString() {
		String output = "";
		for(RoboTeam team:TEAMS) {
			output += team + "\n";
		}
		return output;
	}
}