package main.tests;

import match.AutonomousMatch;
import match.TeleopMatch;
import database.RoboTeam;
import tools.SaveTools;

public class FolderTest {
	public static void main(String[] args) {
		RoboTeam team = new RoboTeam("4180");
		TeleopMatch matchT = new TeleopMatch("1");
		matchT.newCooperationSet();
		matchT.newNoodleInBin();
		matchT.newStackBin(5);
		AutonomousMatch matchA = new AutonomousMatch("43");
		matchA.newRobotSet();
		matchA.newStackedToteSet();
		matchA.newContainerSet();
		team.addMatch(matchT);
		team.addMatch(matchA);
		team.getPitNotes().setMiscFunctions("My least favorite person on the planet is Alex WhatHisButtWhoseAssIsAGhoat");
		SaveTools.saveRoboTeam(team);
		SaveTools.saveMatch(matchA, team);
	}
}
