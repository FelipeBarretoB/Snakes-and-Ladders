package model;

public class Player {
	char icon;
	Player next;
	
	public Player(char icon) {
		this.icon = icon;
		this.next = null;
	}
	public Player(char icon, Player next) {
		this.icon = icon;
		this.next = next;
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
	
}
