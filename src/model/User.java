package model;

public class User {
	private String login;
	private double score=120 ;
	private boolean RX=false;
	private boolean timer = false;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void addScore(double sc) {
		score+=sc;
	}
	public void minScore(double mn) {}
	public boolean hasRX() {
		return RX;
	}
	public void setRX(boolean rX) {
		RX = rX;
	}
	public boolean hasTimer() {
		return timer;
	}
	public void setTimer(boolean timer) {
		this.timer = timer;
	}
	
	
}
