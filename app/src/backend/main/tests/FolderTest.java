package main.tests;

import match.AutonomousMatch;
import match.Match;
import match.TeleopMatch;
import database.RoboTeam;
import tools.SaveTools;

public class FolderTest {
	public static void main(String[] args) {
//		RoboTeam team = new RoboTeam("4180");
//		TeleopMatch matchT = new TeleopMatch("1");
//		matchT.newStackTote();
//		matchT.newStackBin(1);
//		matchT.newNoodleInBin();
//		matchT.newPushNoodle();
//		matchT.newCooperationSet();
//		AutonomousMatch matchA = new AutonomousMatch("43");
//		matchA.newRobotSet();
//		matchA.newToteSet();
//		matchA.newContainerSet();
//		matchA.newStackedToteSet();
//		team.addMatch(matchT);
//		team.addMatch(matchA);
//		team.getPitNotes().setMiscFunctions("My least favorite person on the planet is Alex WhatHisButtWhoseAssIsAGhoat");
//		SaveTools.saveRoboTeam(team);
//		SaveTools.saveMatch(matchT, team);
//		RoboTeam team = SaveTools.loadRoboTeam("4180");
//		System.out.println(team);
		Match matchT = SaveTools.loadMatch("1", "4180");
		matchT.printActions();
	}
}
