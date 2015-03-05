package tests;

import match.Match;
import database.RoboTeam;
import tools.SaveTools;

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
		Match match = new Match("1");
		match.addTeam("4180");
		match.addContainerSet("4180");
		match.addCooperationSet("4180");
		match.addNoodleInBin("4180");
		match.addPushNoodle("4180");
		match.addRobotSet("4180");
		match.addStackBin("4180", 5);
		match.addStackTote("4180");
		match.addToteSet("4180");
		match.addContainerSet("4180");
		match.addCooperationSet("4180");
		match.addNoodleInBin("4180");
		match.addPushNoodle("4180");
		match.addRobotSet("4180");
		match.addStackBin("4180", 5);
		match.addStackTote("4180");
		match.addToteSet("4180");
		match.getTeamActions("4180").printActions();
	}
}
