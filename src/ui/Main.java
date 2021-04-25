package ui;

public class Main {
	private Menu mn;
	
	/**
	*The constructor for the class Main <br>
    *<b>pre: The creation of the class Menu </b> 
	*/
	public Main() {
		mn= new Menu();
	}
	
	/**
	*The method main <br>
	*@param args, Array of Strings 
	*/
	public static void main(String [] args) {
		Main ui= new Main();
		ui.mn.waitForOption(1);
		
	}
	
}
