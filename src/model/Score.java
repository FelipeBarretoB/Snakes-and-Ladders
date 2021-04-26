package model;

public class Score {
	private Score parent;
	private Score left;
	private Score right;
	private int score;
	private char player;


	/**
	 *The constructor if the class Score <br>
	 *@param parent, the parent node of this node of the tree
	 *@param left, the node to the left of this node of the tree
	 *@param right, the node to the right of this node of the tree
	 *@param score, the score of the player
	 *@param player, the icon of the player
	 */
	public Score(Score parent, Score left, Score right, int score, char player) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.score=score;
		this.player=player;
	}

	/**
	 *The method returns the value of parent <br>
	 *<b>pre: The creation of parent </b> 
	 *<b>post: Returns the value of parent </b>
	 *@return Score, the value of parent
	 */
	public Score getparent() {
		return parent;
	}

	/**
	 *The method gives a new value to the field: parent <br>
	 *<b>pre: The creation of parent </b> 
	 *<b>post: Changes the value of parent </b>
	 *@param parent, the new value for the field: parent
	 */
	public void setparent(Score parent) {
		this.parent = parent;
	}

	/**
	 *The method returns the value of left <br>
	 *<b>pre: The creation of left </b> 
	 *<b>post: Returns the value of left </b>
	 *@return Score, the value of left
	 */
	public Score getLeft() {
		return left;
	}

	/**
	 *The method gives a new value to the field: left <br>
	 *<b>pre: The creation of left </b> 
	 *<b>post: Changes the value of left </b>
	 *@param left, the new value for the field: left
	 */
	public void setLeft(Score left) {
		this.left = left;
	}

	/**
	 *The method returns the value of right <br>
	 *<b>pre: The creation of right </b> 
	 *<b>post: Returns the value of right </b>
	 *@return Score, the value of right
	 */
	public Score getRight() {
		return right;
	}

	/**
	 *The method gives a new value to the field: right <br>
	 *<b>pre: The creation of right </b> 
	 *<b>post: Changes the value of right </b>
	 *@param right, the new value for the field: right
	 */
	public void setRight(Score right) {
		this.right = right;
	}

	/**
	 *The method returns the value of score <br>
	 *<b>pre: The creation of score </b> 
	 *<b>post: Returns the value of score </b>
	 *@return int, the value of score
	 */
	public int getScore() {
		return score;
	}

	/**
	 *The method gives a new value to the field: score <br>
	 *<b>pre: The creation of score </b> 
	 *<b>post: Changes the value of score </b>
	 *@param score, the new value for the field: score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 *The method returns the value of player <br>
	 *<b>pre: The creation of player </b> 
	 *<b>post: Returns the value of player </b>
	 *@return char, the value of player
	 */
	public char getPlayer() {
		return player;
	}

	/**
	 *The method gives a new value to the field: player <br>
	 *<b>pre: The creation of player </b> 
	 *<b>post: Changes the value of player </b>
	 *@param player, the new value for the field: player
	 */
	public void setPlayer(char player) {
		this.player = player;
	}






}
