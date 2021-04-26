package model;

public class Player {

	private char icon;
	private Player next;
	private int inSpace;
	private boolean turn;
	private int timesMoved;

	/**
	*The constructor method creates an objet Player <br>
    *<b>pre: To create a player is needed a char with the icon or the game pice </b> 
	*<b>post: Creates an objet player with the icon </b>
	*@param icon, the icon of the Player
	*/
	public Player(char icon) {
		this.icon = icon;
		this.next = null;
		this.inSpace = 1;
		this.turn = false;
		this.timesMoved = 0;
		
	}
	/**
	*The constructor method creates an objet Player <br>
    *<b>pre: To create a player is needed a char with the icon or the game pice and a Player thas is going to be the next</b> 
	*<b>post: Creates an objet player with the icon and adds the player next to it </b>
	*@param icon, the icon of the Player
	*@param next, the next Player
	*/
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
