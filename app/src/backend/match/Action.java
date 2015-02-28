package match;

public abstract class Action {
	protected int REWARDED_POINTS = 0;
	String DESCRIPTION = "";

	public Action(int rewardedPoints) {
		REWARDED_POINTS = rewardedPoints;
	}

	public int getPoints() {
		return REWARDED_POINTS;
	}

	public String getDescription() {
		return DESCRIPTION;
	}

	protected void setDescription(String description) {
		DESCRIPTION = description;
	}

	public String getData() {
		String title = this.getClass().toString();
		title = title.substring(title.indexOf("$") + 1,title.length()).toUpperCase();
		return title + " " + REWARDED_POINTS;
	}
}