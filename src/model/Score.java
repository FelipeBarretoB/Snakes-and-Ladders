package model;

public class Score {
	private Score root;
	private Score left;
	private Score right;
	private int score;
	
	public Score(Score root, Score left, Score right, int score) {
		this.root = root;
		this.left = left;
		this.right = right;
		this.score=score;
	}

	public Score getRoot() {
		return root;
	}

	public void setRoot(Score root) {
		this.root = root;
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
	
	
	
	
	
	
}
