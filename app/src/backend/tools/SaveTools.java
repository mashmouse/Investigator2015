package tools;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import match.AutonomousMatch;
import match.Match;
import match.TeleopMatch;
import database.RoboTeam;

public class SaveTools {

	public static void saveRoboTeam(RoboTeam team) {
		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter(new File("C:\\Users\\ros_dmlamarca\\Desktop\\" + team.getTeamNumber() + ".rtm"));
			ArrayList<Match> matches = team.getMatches();
			for(Match currentMatch : matches) {
				fileWriter.print(currentMatch.getMatchNumber() + " ");
			}
			fileWriter.println();
			fileWriter.println(team.getPitNotes().FUNCTION_NOODLE);
			fileWriter.println(team.getPitNotes().FUNCTION_BIN);
			fileWriter.println(team.getPitNotes().FUNCTION_TOTE);
			fileWriter.println(team.getPitNotes().FUNCTION_SLOPE);
			fileWriter.println(team.getPitNotes().FUNCTION_FLIP_TOTE);
			fileWriter.println(team.getPitNotes().FUNCTION_OMNIWEEL);
			fileWriter.println(team.getPitNotes().FUNCTION_BALANCE_ROBOT);
			fileWriter.println(team.getPitNotes().FUNCTION_BALANCE_STACK);
			fileWriter.print(team.getPitNotes().getMiscFunctions());
			fileWriter.close();
		} catch(IOException io) {
			System.err.println("IOException bitch... sorry");
		}
	}
	
	public static void saveMatch(RoboTeam team, Match match) {
		PrintWriter fileWriter = null;
		String fileType = ".err";
		if(match instanceof AutonomousMatch) {
			fileType = ".aut";
		} else if(match instanceof TeleopMatch) {
			fileType = ".tel";
		}
		
		try {
			fileWriter = new PrintWriter(new File("C:\\Users\\ros_dmlamarca\\Desktop\\" + team.getTeamNumber() + "." + match.getMatchNumber() + fileType));
			fileWriter.println();
			fileWriter.close();
		} catch(IOException io) {
			System.err.println("IOException bitch... sorry");
		}
	}
}
