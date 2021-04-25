package model;

public class Player {

	private char icon;
	private Player next;
	private int inSpace;
	private boolean turn;
	private int timesMoved;


	
	public Player(char icon) {
		this.icon = icon;
		this.next = null;
		this.inSpace = 1;
		this.turn = false;
		this.timesMoved = 0;
		
	}
	public Player(char icon, Player next) {
		this.icon = icon;
		this.next = next;
		this.inSpace = 1;
		this.turn = false;
	}
	


	
	public int getTimesMoved() {
		return timesMoved;
	}
	public void setTimesMoved(int timesMoved) {
		this.timesMoved = timesMoved;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public char getIcon() {
		return icon;
	}
	public void setIcon(char icon) {
		this.icon = icon;
	}
	public Player getNext() {
		return next;
	}
	public void setNext(Player next) {
		this.next = next;
	}
	public int getInSpace() {
		return inSpace;
	}
	public void setInSpace(int inSpace) {
		this.inSpace = inSpace;
	}
	

	
}
