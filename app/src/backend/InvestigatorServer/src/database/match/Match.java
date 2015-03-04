package database.match;

import java.util.ArrayList;

public class Match {
	private ArrayList<Action> autonomousActions;
	private ArrayList<Action> teleopActions;
	private String matchNumber;
	
	public Match(String matchNumber) {
		this.autonomousActions = new ArrayList<Action>();
		this.teleopActions = new ArrayList<Action>();
		this.matchNumber = matchNumber;
	}
	
	public int getTotalPoints() {
		int points = 0;
		points += getListPoints(autonomousActions);
		points += getListPoints(teleopActions);
		return points;
	}
	
	private int getListPoints(ArrayList<Action> actions) {
		int points = 0;
		for(Action action: actions) {
			points += action.getPoints();
		}
		return points;
	}
	
	public String getMatchNumber() {
		return matchNumber;
	}
	
	public String getTitle() {
		String title = this.getClass().toString();
		title = title.substring(title.indexOf("match.") + 6,title.length());
		return title;
	}
	
	public ArrayList<Action> getAutonomousActions() {
		return autonomousActions;
	}
	
	public ArrayList<Action> getTeleopActions() {
		return teleopActions;
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
	
	public void newRobotSet() {
		autonomousActions.add(new RobotSet());
	}
	
	public void newToteSet() {
		autonomousActions.add(new ToteSet());
	}
	
	public void newContainerSet() {
		autonomousActions.add(new ContainerSet());
	}
	
	public void newStackedToteSet() {
		autonomousActions.add(new StackedToteSet());
	}
	
	private class RobotSet extends Action {
		public RobotSet() {
			super(4,ActionType.AUTONOMOUS);
			super.setDescription("All robots on the team drive into the autozone.");//get in the zone, autozone
		}
	}
	
	private class ToteSet extends Action {
		public ToteSet() {
			super(6,ActionType.AUTONOMOUS);
			super.setDescription("All of the Totes are in the autozone");
		}
	}
	
	private class ContainerSet extends Action {
		public ContainerSet() {
			super(8,ActionType.AUTONOMOUS);
			super.setDescription("All of the Bins are in the autozone");
		}
	}
	
	private class StackedToteSet extends Action {
		public StackedToteSet() {
			super(20,ActionType.AUTONOMOUS);
			super.setDescription("All of the Totes are stacked in the autozone");
		}
	}
	
	public void newStackTote() {
		teleopActions.add(new StackTote());
	}
	
	public void newStackBin(int totes) {
		teleopActions.add(new StackBin(totes));
	}
	
	public void newNoodleInBin() {
		teleopActions.add(new NoodleInBin());
	}
	
	public void newPushNoodle() {
		teleopActions.add(new PushNoodle());
	}
	
	public void newCooperationSet() {
		teleopActions.add(new CooperationSet());
	}

	private class StackTote extends Action {
		public StackTote() {
			super(2,ActionType.TELEOP);
			super.setDescription("Put a tote on top of another tote or the ground");
		}
	}
	
	private class StackBin extends Action {
		public StackBin(int totes) {
			super(totes * 4,ActionType.TELEOP);
			if(totes > 6) {
				super.rewardedPoints = 24;
			}
			super.setDescription("Put a bin on top of a stack of totes");
		}
	}
	
	private class NoodleInBin extends Action {
		public NoodleInBin() {
			super(6,ActionType.TELEOP);
			super.setDescription("Put a noodle in a bin");
		}
	}
	
	private class PushNoodle extends Action {
		public PushNoodle() {
			super(1,ActionType.TELEOP);
			super.setDescription("Push a noodle into the landfill zone");
		}
	}
	
	private class CooperationSet extends Action {
		public CooperationSet() {
			super(20,ActionType.TELEOP);
			super.setDescription("Both teams cooperate to stack 4 yellow bins on the step");
		}
	}
	

}
