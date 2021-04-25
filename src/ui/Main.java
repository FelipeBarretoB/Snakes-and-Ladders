package ui;

public class Main {
	private Menu mn;
	
	public Main() {
		mn= new Menu();
	}
	
	public static void main(String [] args) {
		Main ui= new Main();
		ui.mn.waitForOption(1);
		
	}
	
}
