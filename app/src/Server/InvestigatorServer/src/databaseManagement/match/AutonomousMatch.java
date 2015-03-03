package databaseManagement.match;

public class AutonomousMatch extends Match {
	public AutonomousMatch(String matchNumber) {
		super(matchNumber);
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
}
