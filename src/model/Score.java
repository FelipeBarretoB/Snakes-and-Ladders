package model;

public class Score {
	private Score parent;
	private Score left;
	private Score right;
	private int score;
	private char player;
	
	public Score(Score parent, Score left, Score right, int score, char player) {
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.score=score;
		this.player=player;
	}

	public Score getparent() {
		return parent;
	}

	public void setparent(Score parent) {
		this.parent = parent;
	}

	public Score getLeft() {
		return left;
	}

	public void setLeft(Score left) {
		this.left = left;
	}

	public Score getRight() {
		return right;
	}

	public void setRight(Score right) {
		this.right = right;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}
	
	
	
	
	
	
}
