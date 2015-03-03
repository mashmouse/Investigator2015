package databaseManagement.match;

import java.util.ArrayList;

public abstract class Match {
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
	
	public void printActions() {
		System.out.println("Actions:");
		for(Action action: ACTIONS) {
			System.out.print(" -" + action.getData() + "\n");
		}
	}
	
	protected abstract class Action {
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
}
