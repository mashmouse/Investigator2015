package database.match;

public enum Action {
	ROBOT_SET(4,"ROBOT_SET"),
	TOTE_SET(6,"TOTE_SET"),
	CONTAINER_SET(8,"CONTAINER_SET"),
	STACKED_TOTE_SET(20,"STACKED_TOTE_SET"),
	STACK_TOTE(2,"STACK_TOTE"),
	STACK_BIN(0,"STACK_BIN"),
	NOODLE_IN_BIN(6,"NOODLE_IN_BIN"),
	PUSH_NOODLE(1,"PUSH_NOODLE"),
	COOPERATION_SET(20,"COOPERATION_SET");
	
	private int rewardedPoints;
	private String label;
	Action(int rewardedPoints, String label){
		this.rewardedPoints = rewardedPoints;
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getRewardedPoints() {
		return rewardedPoints;
	}
	
	public void addRewardedPoints(int points) {
		this.rewardedPoints += points;
	}
	
	public String getData() {
		return label + " " + rewardedPoints;
	}
}