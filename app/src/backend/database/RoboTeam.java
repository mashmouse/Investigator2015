package database;
import java.util.ArrayList;

import match.Match;

public class RoboTeam {
	private ArrayList<Match> matches;
	private String teamNumber;
	private PitNotes pitNotes;
//	private Photo ROBOT_PICTURE;
	
	public RoboTeam(String teamNumber) {
		matches = new ArrayList<Match>();
		this.teamNumber = teamNumber;
		pitNotes = new PitNotes();
	}
	
	public String getTeamNumber() {
		return teamNumber;
	}
	
	public void addMatch(Match match) {
		matches.add(match);
	}
	
	public ArrayList<Match> getMatches() {
		return matches;
	}
	
	public void printMatches() {
		for(Match currentMatch: matches) {
			System.out.println(currentMatch.getMatchNumber() + ":");
			currentMatch.getTeamActions(teamNumber).printActions();
		}
	}
	
	public PitNotes getPitNotes() {
		return pitNotes;
	}
	
	public String toString() {
		String output = "";
		output += teamNumber + ":\n";
		output += "  Matches: \n";
		for(Match match: matches) {
			output += "    -" + match.getTitle() + " "+ match.getMatchNumber() + "\n";
		} 
		output += "  " + pitNotes; 
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
