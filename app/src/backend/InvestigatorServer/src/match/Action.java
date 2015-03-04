package match;

public abstract class Action {
	protected int rewardedPoints = 0;
	protected ActionType actionType;
	String description = "";

	public Action(int rewardedPoints, ActionType actionType) {
		this.rewardedPoints = rewardedPoints;
		this.actionType = actionType;
	}

	public int getPoints() {
		return rewardedPoints;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		String title = this.getClass().toString();
		title = title.substring(title.indexOf("$") + 1,title.length()).toUpperCase();
		return title + " " + rewardedPoints;
	}
	
	protected enum ActionType {
		TELEOP,
		AUTONOMOUS
	}
}