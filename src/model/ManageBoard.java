package model;

import java.util.Random;

public class ManageBoard {

	public ManageBoard() {}
	
	public int rollDie() {
		Random random = new Random();
		return  random.nextInt(6 - 1 + 1) + 1;
	}
	
	
}

