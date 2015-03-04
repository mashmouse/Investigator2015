package tests;

import database.RoboTeam;
import database.TeamDataBase;

public class TestTeamDataBase {
	public static void main(String[] args) {
//		RoboTeam team = new RoboTeam("4180");
//		team.addMatch(new TeleopMatch("4180","1"));
//		System.out.println(team);
		
		TeamDataBase database = new TeamDataBase();
		
		for(int count = 1; count <= 30; count++) {
			database.add(new RoboTeam(count + ""));
		}
	
//		database.getTeam("25").addMatch(new TeleopMatch("1"));
//		database.getTeam("26").addMatch(new TeleopMatch("2"));
//		database.getTeam("27").addMatch(new TeleopMatch("20"));
//		database.getTeam("28").addMatch(new TeleopMatch("32"));
		
		TeamDataBase.printTeamArray(database.searchTeamNumber("72"));
		
//		System.out.println(database);
		
		TeamDataBase.printTeamArray(database.searchMatchNumber("2"));
	}
}