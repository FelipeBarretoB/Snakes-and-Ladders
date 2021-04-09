package model;

public class Space {
	private String info;
	private Space right;
	private Space left;
	private Space up;
	private Space down;
	
	public Space(String info, Space right, Space left, Space up, Space down) {
		this.info = info;
		this.right = right;
		this.left = left;
		this.up = up;
		this.down = down;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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
