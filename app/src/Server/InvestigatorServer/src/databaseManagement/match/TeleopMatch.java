package databaseManagement.match;


public class TeleopMatch extends Match {
	public TeleopMatch(String matchNumber) {
		super(matchNumber);
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
