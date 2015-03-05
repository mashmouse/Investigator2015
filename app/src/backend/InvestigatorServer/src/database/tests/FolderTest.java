package database.tests;

import database.match.Match;
import database.RoboTeam;
import database.tools.SaveTools;

public class FolderTest {
	public static void main(String[] args) {
//		RoboTeam team = new RoboTeam("4180");
//		Match match = new Match("1");
//		match.newStackTote();
//		match.newStackBin(1);
//		match.newNoodleInBin();
//		match.newPushNoodle();
//		match.newCooperationSet();
//		AutonomousMatch matchA = new AutonomousMatch("43");
//		match.newRobotSet();
//		match.newToteSet();
//		match.newContainerSet();
//		match.newStackedToteSet();
//		team.addMatch(matchT);
//		team.addMatch(matchA);
//		team.getPitNotes().setMiscFunctions("My least favorite person on the planet is Alex WhatHisButtWhoseAssIsAGhoat");
//		SaveTools.saveRoboTeam(team);
//		SaveTools.saveMatch(match, team);
//		RoboTeam team = SaveTools.loadRoboTeam("4180");
//		System.out.println(team + "\n");
//		team.printMatches();
		Match match = SaveTools.loadMatch("1", "4180");
		match.printActions();
	}
}
