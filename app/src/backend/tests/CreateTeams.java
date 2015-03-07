package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tools.SaveTools;
import database.RoboTeam;

public class CreateTeams {
	public static void main(String[] args) {
		try {
			System.out.println((new File("competitors.txt")).getAbsolutePath());
			Scanner fileScanner = new Scanner(new File("competitors.txt"));
			
			int count = 0;
			while(fileScanner.hasNextInt()) {
				count++;
//				RoboTeam team = new RoboTeam(fileScanner.next());
//				SaveTools.saveRoboTeam(team);
			}
			System.out.println(count);
		} catch(FileNotFoundException ex) {
			System.err.println("Hey bra, FileNotFoundException");
		}
	}
}
