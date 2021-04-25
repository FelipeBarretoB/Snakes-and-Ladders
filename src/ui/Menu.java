package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.ManageBoard;

public class Menu {

	private BufferedReader br;
	private BufferedWriter bw;
	private ManageBoard mB;
	/**
	*The constructor of the class menu <br>
	*gives value to br
	*gives value to bw
	*uses default constructor for mB
    *<b>pre: The existence of bw, br and mb, and the class Manage board </b> 
	*/
	public Menu() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		mB = new ManageBoard();
	}
	/**
	*The method uses recursion to create a menu through the console <br>
    *<b>pre: The creation of the methid waitForOption </b> 
	*<b>post: gives a value to the method waitForOption </b>
	*/
	public void recursionMenu() {
		try {
			int n= Integer.parseInt(br.readLine());
			waitForOption(n);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	*The method uses n to choose one of the options in the menu and then recursion to call it´s self <br>
    *<b>pre: The creation of the method showMenu and executeOperation </b> 
	*<b>post: Gives a value to executeOperation and waitForOptionMenu  </b>
	*@param n, the option the user has chosen  
	*/
	public void waitForOption(int n) {

		if(n!=0) {
			try {
				n=showMenu();
				executeOperation(n);
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			waitForOption(n);
		}
	}

	/**
	*The method prints the menu and returns the option the user chooses <br>
    *<b>pre:  </b> 
	*<b>post: returns the option chosen by the user </b>
	*@return int, the option the user has chosen 
	*/
	public int showMenu() throws IOException, NumberFormatException {

		int option=0;
		bw.write(
				"Menú principal, seleccione una opción\n" +
						"(1) Jugar \n" +
						"(2) Ver tablero de puntajes\n"+
						"(0) Para salir"
				);
		bw.newLine();
		bw.flush();
		option= Integer.parseInt(br.readLine());
		bw.newLine();
		bw.flush();
		return option;
	}

	/**
	*The method executes the operation the user has chosen <br>
    *<b>pre: The creation of the methods: createBoard and play </b> 
	*<b>post: Calls a method or closes the program </b>
	*@param operation, the option the user has chosen
	*/
	public void executeOperation(int operation) throws IOException{

		switch(operation) {
		case 0:
			bw.write("adios. \n \n");
			bw.flush();
			break;
		case 1:
			bw.write("Entre las variables del juego");
			bw.newLine();
			bw.flush();
			createBoard();
			bw.newLine();
			bw.flush();
			play();
			break;
		case 2:
			bw.write(mB.getPrintInOrder());
			bw.flush();
			break;
		default:
			bw.write("Seleccione una opcion valida \n \n");
			bw.flush();

		}
	}

	/**
	*The method creates the game board by asking for a String, if the board can´t be created, it calls for a new String <br>
    *<b>pre: The creation of the methods: createBoard, printBoardInGame and printString in the class ManageBoard </b> 
	*<b>post: The creation of the game board </b>
	*/
	public void createBoard() throws IOException {
		String input=br.readLine();
		String[] split =input.split(" ");
		if((Integer.parseInt(split[2])*2 + Integer.parseInt(split[3])*2)<Integer.parseInt(split[0])*Integer.parseInt(split[1])-2) {
			mB.createBoard(Integer.parseInt(split[0]),Integer.parseInt(split[1]) , Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[4]);
			bw.write(mB.printString());
			bw.newLine();
			bw.write(mB.printBoardInGame());
		}else {
			bw.write("Hay más escaleras serpientes que casillas disponibles");
			bw.newLine();
			bw.newLine();
			bw.write("Entre las variables del juego");
			bw.newLine();
			bw.flush();
			createBoard();
			
		}
	}

	/**
	*The method waits for a String input from the console, and does something according to said input <br>
	*if the input is menu, it returns to the menu
	*if the input is num, it calls the method printString from the class ManageBoard
	*if the input is simul, it calls the method simul from the class Menu
	*if the input is help, it prints the possible options the user can choose from
	*if the input is a line jump, it calls for the method actionPlayer from the class ManageBoard
	*if the input is anything else, it asks for a new input
    *<b>pre: The creation of the methods: actionPlayer and printString, from the class ManageBoard and the method simul from the class Menu </b> 
	*<b>post: Executes a method depending of the input </b>
	*/
	
	public void play() throws IOException {
		String input = br.readLine();
		if(input.equals("menu")) {

		}else if(input.equals("num")) {
			bw.write(mB.printString());
			bw.newLine();
			bw.flush();
			play();
		}else if(input.equals("")) {
			String s=mB.actionPlayers();

			if(s.contains("Juego terminado, ganador: ")) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}else {
				bw.write(s);
				bw.newLine();
				bw.flush();
				play();
			}
			
		}else if(input.equals("help")) {
			bw.write("Entre un salto de linea para lanzar el dado \nEscriba: menu para volver el menu y para el juego \nEscriba: num, para mostrar el tablero completo \nEscriba: simul, para simular el juego");
			bw.newLine();
			bw.flush();
			play();
		}else if(input.equals("simul")){
			String play= mB.actionPlayers();
			bw.write(play);
			bw.newLine();
			bw.flush();
			simul(play);
		}else {
			bw.write("Opción no valida");
			bw.newLine();
			bw.flush();
			play();
		}
	}
	
	
	/**
	*The method uses the game to play the game until someone has won <br>
    *<b>pre: the creation of the method actionPlayers </b> 
	*<b>post: The addition of a new Player object in the team's player array, and the same object added to the clubEmployees ArrayList </b>
	*@param play, the string that the method actionPlayers returns 
	*/
	public void simul(String play) throws IOException {
		if(play.contains("Juego terminado, ganador: ")) {
			bw.write(play);
			bw.newLine();
			bw.flush();
		}else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			play=mB.actionPlayers();
			bw.write(play);
			bw.newLine();
			bw.flush();
			simul(play);
		}
	}
	
}
