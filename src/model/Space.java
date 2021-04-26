package model;

public class Space {
	private String playersIn;
	private Space right;
	private Space left;
	private Space up;
	private Space down;
	private int space;
	private String special;
	
	/**
	*The constructor of the class Space<br>
	*@param right, the Space object to the right of the current Space object
	*@param left, the Space object to the left of the current Space object
	*@param up, the Space object to the up of the current Space object
	*@param down, the Space object to the down of the current Space object
	*@param space, the number on the board this Space represents
	*@param special, represents if the tile has a snake or a ladder on it 
	*/	
	public Space(Space right, Space left, Space up, Space down, int space, String special) {
		this.playersIn = "";
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
		this.space=space;
		this.special=special;
	}
	/**
	*Adds a player icon to the space<br>
    *<b>pre: </b> 
	*<b>post: Changes the value of playersIn </b>
	*@param c, the icon of the player
	*/
	public void addPlayerIn(char c) {
		playersIn += c;
	}

	/**
	*The method returns the value of special <br>
    *<b>pre: The creation of special </b> 
	*<b>post: Returns the value of special </b>
	*@return String, the value of special
	*/
	public String getSpecial() {
		return special;
	}


	/**
	*The method gives a new value to the field: special <br>
    *<b>pre: The creation of special </b> 
	*<b>post: Changes the value of special </b>
	*@param special, the new value for the field: special
	*/
	public void setSpecial(String special) {
		this.special = special;
	}


	/**
	*The method returns the value of space <br>
    *<b>pre: The creation of space </b> 
	*<b>post: Returns the value of space </b>
	*@return int, the value of space
	*/
	public int getSpace() {
		return space;
	}


	/**
	*The method gives a new value to the field: space <br>
    *<b>pre: The creation of space </b> 
	*<b>post: Changes the value of space </b>
	*@param space, the new value for the field: space
	*/
	public void setSpace(int space) {
		this.space = space;
	}


	/**
	*The method returns the value of playersIn <br>
    *<b>pre: The creation of playersIn </b> 
	*<b>post: Returns the value of playersIn </b>
	*@return String, the value of playersIn
	*/
	public String getPlayersIn() {
		return playersIn;
	}

	/**
	*The method gives a new value to the field: playersIn <br>
    *<b>pre: The creation of playersIn </b> 
	*<b>post: Changes the value of playersIn </b>
	*@param playersIn, the new value for the field: playersIn
	*/
	public void setPlayersIn(String playersIn) {
		this.playersIn = playersIn;
	}

	/**
	*The method returns the value of right <br>
    *<b>pre: The creation of right </b> 
	*<b>post: Returns the value of right </b>
	*@return Space, the value of right
	*/
	public Space getRight() {
		return right;
	}

	/**
	*The method gives a new value to the field: right <br>
    *<b>pre: The creation of right </b> 
	*<b>post: Changes the value of right </b>
	*@param right, the new value for the field: right
	*/
	public void setRight(Space right) {
		this.right = right;
	}

	/**
	*The method returns the value of left <br>
    *<b>pre: The creation of left </b> 
	*<b>post: Returns the value of left </b>
	*@return Space, the value of left
	*/
	public Space getLeft() {
		return left;
	}

	/**
	*The method gives a new value to the field: left <br>
    *<b>pre: The creation of left </b> 
	*<b>post: Changes the value of left </b>
	*@param left, the new value for the field: left
	*/
	public void setLeft(Space left) {
		this.left = left;
	}

	/**
	*The method returns the value of up <br>
    *<b>pre: The creation of up </b> 
	*<b>post: Returns the value of up </b>
	*@return Space, the value of up
	*/
	public Space getUp() {
		return up;
	}

	/**
	*The method gives a new value to the field: up <br>
    *<b>pre: The creation of up </b> 
	*<b>post: Changes the value of up </b>
	*@param up, the new value for the field: up
	*/
	public void setUp(Space up) {
		this.up = up;
	}

	/**
	*The method returns the value of down <br>
    *<b>pre: The creation of down </b> 
	*<b>post: Returns the value of down </b>
	*@return Space, the value of down
	*/
	public Space getDown() {
		return down;
	}

	/**
	*The method gives a new value to the field: down <br>
    *<b>pre: The creation of down </b> 
	*<b>post: Changes the value of down </b>
	*@param down, the new value for the field: down
	*/
	public void setDown(Space down) {
		this.down = down;
	}
	
	
	
}
