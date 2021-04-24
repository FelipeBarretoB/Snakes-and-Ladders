package model;

public class Space {
	private String playersIn;
	private Space right;
	private Space left;
	private Space up;
	private Space down;
	private int space;
	private String special;
	
	
	public Space(Space right, Space left, Space up, Space down, int space, String special) {
		this.playersIn = "";
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
		this.space=space;
		this.special=special;
	}

	public void addPlayerIn(char c) {
		playersIn += c;
	}
	public String getSpecial() {
		return special;
	}



	public void setSpecial(String special) {
		this.special = special;
	}



	public int getSpace() {
		return space;
	}



	public void setSpace(int space) {
		this.space = space;
	}



	public String getPlayersIn() {
		return playersIn;
	}


	public void setPlayersIn(String playersIn) {
		this.playersIn = playersIn;
	}


	public Space getRight() {
		return right;
	}

	public void setRight(Space right) {
		this.right = right;
	}

	public Space getLeft() {
		return left;
	}

	public void setLeft(Space left) {
		this.left = left;
	}

	public Space getUp() {
		return up;
	}

	public void setUp(Space up) {
		this.up = up;
	}

	public Space getDown() {
		return down;
	}

	public void setDown(Space down) {
		this.down = down;
	}
	
	
	
}
