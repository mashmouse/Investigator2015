package database.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database.tools.SaveTools;
import database.RoboTeam;

public class CreateTeams {
	public static void main(String[] args) {
		try {
			System.out.println((new File("competitors.txt")).getAbsolutePath());
			Scanner fileScanner = new Scanner(new File("competitors.txt"));
			
			while(fileScanner.hasNextInt()) {
				RoboTeam team = new RoboTeam(fileScanner.next());
				SaveTools.saveRoboTeam(team);
			}
		} catch(FileNotFoundException ex) {
			System.err.println("Hey bra, FileNotFoundException");
		}
	}
}
