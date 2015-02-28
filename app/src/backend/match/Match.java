package match;

import java.util.ArrayList;

public class Match {
	protected ArrayList<Action> ACTIONS;
	protected String MATCH_NUMBER;
	
	public Match(String matchNumber) {
		ACTIONS = new ArrayList<Action>();
		MATCH_NUMBER = matchNumber;
	}
	
	public int getTotalPoints() {
		int points = 0;
		
		for(Action action: ACTIONS) {
			points += action.getPoints();
		}
		return points;
	}
	
	public String getMatchNumber() {
		return MATCH_NUMBER;
	}
	
	public String getTitle() {
		String title = this.getClass().toString();
		title = title.substring(title.indexOf("match.") + 6,title.length());
		return title;
	}
	
	public ArrayList<Action> getActions() {
		return ACTIONS;
	}
	
	public void printActions() {
		System.out.println("Actions:");
		for(Action action: ACTIONS) {
			System.out.print(" -" + action.getData() + "\n");
		}
	}
	
	public void newRobotSet() {
		ACTIONS.add(new RobotSet());
	}
	
	public void newToteSet() {
		ACTIONS.add(new ToteSet());
	}
	
	public void newContainerSet() {
		ACTIONS.add(new ContainerSet());
	}
	
	public void newStackedToteSet() {
		ACTIONS.add(new StackedToteSet());
	}
	
	private class RobotSet extends Action {
		public RobotSet() {
			super(4);
			super.setDescription("All robots on the team drive into the autozone.");//get in the zone, autozone
		}
	}
	
	private class ToteSet extends Action {
		public ToteSet() {
			super(6);
			super.setDescription("All of the Totes are in the autozone");
		}
	}
	
	private class ContainerSet extends Action {
		public ContainerSet() {
			super(8);
			super.setDescription("All of the Bins are in the autozone");
		}
	}
	
	private class StackedToteSet extends Action {
		public StackedToteSet() {
			super(20);
			super.setDescription("All of the Totes are stacked in the autozone");
		}
	}
	
	public void newStackTote() {
		ACTIONS.add(new StackTote());
	}
	
	public void newStackBin(int totes) {
		ACTIONS.add(new StackBin(totes));
	}
	
	public void newNoodleInBin() {
		ACTIONS.add(new NoodleInBin());
	}
	
	public void newPushNoodle() {
		ACTIONS.add(new PushNoodle());
	}
	
	public void newCooperationSet() {
		ACTIONS.add(new CooperationSet());
	}

	private class StackTote extends Action {
		public StackTote() {
			super(2);
			super.setDescription("Put a tote on top of another tote or the ground");
		}
	}
	
	private class StackBin extends Action {
		public StackBin(int totes) {
			super(totes * 4);
			if(totes > 6) {
				REWARDED_POINTS = 24;
			}
			super.setDescription("Put a bin on top of a stack of totes");
		}
	}
	
	private class NoodleInBin extends Action {
		public NoodleInBin() {
			super(6);
			super.setDescription("Put a noodle in a bin");
		}
	}
	
	private class PushNoodle extends Action {
		public PushNoodle() {
			super(1);
			super.setDescription("Push a noodle into the landfill zone");
		}
	}
	
	private class CooperationSet extends Action {
		public CooperationSet() {
			super(20);
			super.setDescription("Both teams cooperate to stack 4 yellow bins on the step");
		}
	}
	

}
