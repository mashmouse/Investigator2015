package match;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Match {
	private Hashtable<String,TeamActions> teamTable;
	private String matchNumber;
	
	public Match(String matchNumber) {
		this.matchNumber = matchNumber;
		teamTable = new Hashtable<String,TeamActions>();
	}
	
	public void addTeam(String teamNumber) {
		teamTable.put(teamNumber, new TeamActions());
	}
	
	public String getMatchNumber() {
		return matchNumber;
	}
	
	public String getTitle() {
		String title = this.getClass().toString();
		title = title.substring(title.indexOf("match.") + 6,title.length());
		return title;
	}
	
	public TeamActions getTeamActions(String teamNumber) {
		return teamTable.get(teamNumber);
	}
	
	public Enumeration<String> getTeamNumbers() {
		return teamTable.keys();
	}

	public void addRobotSet(String teamNumber) {
		teamTable.get(teamNumber).addAutonomousAction(Action.ROBOT_SET);
	}
	
	public void addToteSet(String teamNumber) {
		teamTable.get(teamNumber).addAutonomousAction(Action.TOTE_SET);
	}
	
	public void addContainerSet(String teamNumber) {
		teamTable.get(teamNumber).addAutonomousAction(Action.CONTAINER_SET);
	}
	
	public void addCooperationSet(String teamNumber) {
		teamTable.get(teamNumber).addAutonomousAction(Action.COOPERATION_SET);
	}
	
	public void addStackedToteSet(String teamNumber) {
		teamTable.get(teamNumber).addAutonomousAction(Action.STACKED_TOTE_SET);
	}
	
	public void addStackTote(String teamNumber) {
		teamTable.get(teamNumber).addTeleopAction(Action.STACK_TOTE);
	}
	
	public void addStackBin(String teamNumber, int totes) {
		teamTable.get(teamNumber).addTeleopAction(Action.STACK_BIN);
		if(totes <= 6) {
			Action.STACK_BIN.addRewardedPoints(totes*4);
		} else {
			Action.STACK_BIN.addRewardedPoints(24);
		}
	}
	
	public void addNoodleInBin(String teamNumber) {
		teamTable.get(teamNumber).addTeleopAction(Action.NOODLE_IN_BIN);
	}
	
	public void addPushNoodle(String teamNumber) {
		teamTable.get(teamNumber).addTeleopAction(Action.PUSH_NOODLE);
	}

	public class TeamActions {
		private ArrayList<Action> autonomousActions;
		private ArrayList<Action> teleopActions;
		
		public TeamActions() {
			this.autonomousActions = new ArrayList<Action>();
			this.teleopActions = new ArrayList<Action>();
		}
		
		public ArrayList<Action> getAutonomousActions() {
			return autonomousActions;
		}
		
		public ArrayList<Action> getTeleopActions() {
			return teleopActions;
		}
		
		private void addAutonomousAction(Action action) {
			autonomousActions.add(action);
		}
		
		private void addTeleopAction(Action action) {
			teleopActions.add(action);
		}
		
		public int getTotalPoints() {
			int points = 0;
			points += getListPoints(autonomousActions);
			points += getListPoints(teleopActions);
			return points;
		}
		
		private int getListPoints(List<Action> actions) {
			int points = 0;
			boolean firstBin = true;
			for(Action action: actions) {
				if(action == Action.STACK_BIN) {
					if(firstBin) {
						points += action.getRewardedPoints();
					}
					firstBin = false;
				} else {
					points += action.getRewardedPoints();
				}
			}
			return points;
		}
		
		public void printActions() {
			System.out.println("AutonomousActions:");
			for(Action action: autonomousActions) {
				System.out.print(" -" + action.getData() + "\n");
			}
			System.out.println("TeleopActions:");
			for(Action action: teleopActions) {
				System.out.print(" -" + action.getData() + "\n");
			}
		}
	}
}
