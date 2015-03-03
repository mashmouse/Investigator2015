package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import match.Match;
import match.Action;
import database.RoboTeam;

public class SaveTools {

	public static void saveRoboTeam(RoboTeam team) {
		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter(new File("database\\" + team.getTeamNumber() + ".rtm"));
			ArrayList<Match> matches = team.getMatches();
			for(Match currentMatch : matches) {
				fileWriter.print(currentMatch.getMatchNumber() + " ");
				saveMatch(currentMatch, team);
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
	
	public static RoboTeam loadRoboTeam(String teamNumber) {
		File database = new File("database");
		File[] teams = database.listFiles();
		RoboTeam newTeam = null;
		for(File currentFile:teams) {
			if(currentFile.getName().equals(teamNumber + ".rtm")) {
				try {
					newTeam = new RoboTeam(teamNumber);
					Scanner fileScanner = new Scanner(currentFile);
					String matchLine = fileScanner.nextLine();
					Scanner matchNumberScanner = new Scanner(matchLine);
					while(matchNumberScanner.hasNextInt()) {
						newTeam.addMatch(loadMatch(matchNumberScanner.nextInt() + "",teamNumber));
					}
					newTeam.getPitNotes().FUNCTION_NOODLE = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_BIN = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_TOTE = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_SLOPE = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_FLIP_TOTE = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_OMNIWEEL = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_BALANCE_ROBOT = fileScanner.nextBoolean();
					newTeam.getPitNotes().FUNCTION_BALANCE_STACK = fileScanner.nextBoolean();
					fileScanner.nextLine();
					newTeam.getPitNotes().setMiscFunctions(fileScanner.nextLine());
					return newTeam;
				} catch (FileNotFoundException e) {
					System.err.println("Sorry bra, FileNotFoundException");
				}
			}
		}
		return null;
	}
	
	public static void saveMatch(Match match, RoboTeam team) {
		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter(new File("database\\matches\\" + match.getMatchNumber() +  "." + team.getTeamNumber() + ".mch"));
			ArrayList<Action> autonomousActions = match.getAutonomousActions();
			for(Action currentAction : autonomousActions) {
				fileWriter.println(currentAction.getData());
			}
			ArrayList<Action> teleopActions = match.getTeleopActions();
			for(Action currentAction : teleopActions) {
				fileWriter.println(currentAction.getData());
			}
			fileWriter.close();
		} catch(IOException io) {
			System.err.println("IOException bitch... sorry");
		}
	}

	public static Match loadMatch(String matchNumber, String teamNumber) {
		File database = new File("database\\matches");
		File[] teams = database.listFiles();
		String fileNamePrefix = matchNumber + "." + teamNumber;
		try {
			for(File currentFile:teams) {
				if(currentFile.getName().equals(fileNamePrefix + ".mch")) {
						Match match = new Match(matchNumber);
						Scanner fileScanner = new Scanner(currentFile);
						while(fileScanner.hasNextLine()) {
							String line = fileScanner.nextLine();
							if(line.startsWith("STACKTOTE")) {
								match.newStackTote();
							} else if(line.startsWith("STACKBIN")) {
								int numberOfBins = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.length()))/4;
								match.newStackBin(numberOfBins);
							} else if(line.startsWith("NOODLEINBIN")) {
								match.newNoodleInBin();
							} else if(line.startsWith("PUSHNOODLE")) {
								match.newPushNoodle();
							} else if(line.startsWith("COOPERATIONSET")) {
								match.newCooperationSet();
							} else if(line.startsWith("ROBOTSET")) {
								match.newRobotSet();
							} else if(line.startsWith("TOTESET")) {
								match.newToteSet();
							} else if(line.startsWith("CONTAINERSET")) {
								match.newContainerSet();
							} else if(line.startsWith("STACKEDTOTESET")) {
								match.newStackedToteSet();
							}
						}
						return match;
				} 
			}
		} catch (FileNotFoundException e) {
			System.err.println("Sorry bra, FileNotFoundException");
		}
		return null;
	}
}