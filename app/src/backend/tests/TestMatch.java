package tests;

import tools.SaveTools;
import match.Match;

public class TestMatch {
	public static void main(String[] args) {
		Match match = new Match("1");
		match.addTeam("4180");
			match.addContainerSet("4180");
			match.addCooperationSet("4180");
			match.addRobotSet("4180");
			match.addStackedToteSet("4180");
			match.addToteSet("4180");
		match.addTeam("7896");
			match.addNoodleInBin("7896");
			match.addPushNoodle("7896");
			match.addStackBin("7896", 5);
			match.addStackTote("7896");
		match.addTeam("3333");
			match.addContainerSet("3333");
			match.addCooperationSet("3333");
			match.addRobotSet("3333");
			match.addStackedToteSet("3333");
			match.addToteSet("3333");
			match.addNoodleInBin("3333");
			match.addPushNoodle("3333");
			match.addStackBin("3333", 5);
			match.addStackTote("3333");
			
		SaveTools.saveMatch(match);
	}
}
