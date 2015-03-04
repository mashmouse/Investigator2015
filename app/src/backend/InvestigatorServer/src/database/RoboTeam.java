package database;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import match.Match;

public class RoboTeam {
	private ArrayList<Match> MATCHES;
	private String TEAM_NUMBER;
	private PitNotes PIT_NOTES;
//	private Photo ROBOT_PICTURE;
	
	public RoboTeam(String teamNumber) {
		MATCHES = new ArrayList<Match>();
		TEAM_NUMBER = teamNumber;
		PIT_NOTES = new PitNotes();
	}
	
	public String getTeamNumber() {
		return TEAM_NUMBER;
	}
	
	public void addMatch(Match match) {
		MATCHES.add(match);
	}
	
	public ArrayList<Match> getMatches() {
		return MATCHES;
	}
	
	public void printMatches() {
		for(Match currentMatch: MATCHES) {
			System.out.println(currentMatch.getMatchNumber() + ":");
			currentMatch.printActions();
		}
	}
	
	public PitNotes getPitNotes() {
		return PIT_NOTES;
	}
	
	public String toString() {
		String output = "";
		output += TEAM_NUMBER + ":\n";
		output += "  Matches: \n";
		for(Match match: MATCHES) {
			output += "    -" + match.getTitle() + " "+ match.getMatchNumber() + "\n";
		} 
		output += "  " + PIT_NOTES; 
		return output;
	}
	
	public class PitNotes {
		public boolean FUNCTION_NOODLE;
		public boolean FUNCTION_BIN;
		public boolean FUNCTION_TOTE;
		public boolean FUNCTION_SLOPE;
		public boolean FUNCTION_FLIP_TOTE;
		public boolean FUNCTION_OMNIWEEL;
		public boolean FUNCTION_BALANCE_ROBOT;
		public boolean FUNCTION_BALANCE_STACK;
		private String FUNCTION_MISCELLANEOUS;
		
		public PitNotes() {
			FUNCTION_MISCELLANEOUS = "";
		}
		
		public String getMiscFunctions() {
			return FUNCTION_MISCELLANEOUS;
		}
		
		public void setMiscFunctions(String string) {
			FUNCTION_MISCELLANEOUS = string;
		}
		
		public String toString() {
			String output = "PitNotes: \n";
			output += "    -Noodle---[" + FUNCTION_NOODLE + "]\n";
			output += "    -Bin------[" + FUNCTION_BIN + "]\n";
			output += "    -Tote-----[" + FUNCTION_TOTE + "]\n";
			output += "    -Slope----[" + FUNCTION_SLOPE + "]\n";
			output += "    -Flip-----[" + FUNCTION_FLIP_TOTE + "]\n";
			output += "    -Omniweel-[" + FUNCTION_FLIP_TOTE + "]\n";
			output += "    -rBalance-[" + FUNCTION_BALANCE_ROBOT + "]\n";
			output += "    -sBalance-[" + FUNCTION_BALANCE_STACK + "]\n";
			output += "    -Misc-----[" + FUNCTION_MISCELLANEOUS + "]";
			return output;
		}
	}
}
