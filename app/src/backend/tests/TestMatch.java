package tests;

import tools.SaveTools;
import match.Match;

public class TestMatch {
	public static void main(String[] args) {
		Match match = new Match("1");
		
		match.addTeam("6666");
			match.addContainerSet("6666");
			match.addCooperationSet("6666");
			match.addRobotSet("6666");
			match.addStackedToteSet("6666");
			match.addToteSet("6666");
			match.addNoodleInBin("6666");
			match.addPushNoodle("6666");
			match.addStackBin("6666", 5);
			match.addStackTote("6666");
		match.addTeam("279");
			match.addNoodleInBin("279");
			match.addPushNoodle("279");
			match.addStackBin("279", 5);
			match.addStackTote("279");
		match.addTeam("101");
			match.addContainerSet("101");
			match.addCooperationSet("101");
			match.addRobotSet("101");
			match.addStackedToteSet("101");
			match.addToteSet("101");
		SaveTools.saveMatch(match);
	}
}
