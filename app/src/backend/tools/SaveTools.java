package tools;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import database.RoboTeam;

public class SaveTools {

	public static void saveRoboTeam(RoboTeam team) {
		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter(new File("C:\\Users\\Iron Rider\\Desktop\\" + team.getTeamNumber() + ".rtm"));
			fileWriter.println(team.getMatches());
			fileWriter.println(team.getPitNotes());
			fileWriter.close();
		} catch(IOException io) {
			System.err.println("IOException bitch... sorry");
		}
	}
}
