package main.tests;

import match.AutonomousMatch;
import match.Match;
import match.TeleopMatch;
import database.RoboTeam;
import tools.SaveTools;

public class FolderTest {
	public static void main(String[] args) {
		RoboTeam team = new RoboTeam("4180");
		Match matchT = new TeleopMatch("1");
		Match matchA = new AutonomousMatch("43");
		team.addMatch(matchT);
		team.addMatch(matchA);
		SaveTools.saveRoboTeam(team);
	}
}
