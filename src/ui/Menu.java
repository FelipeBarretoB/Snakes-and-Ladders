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

	public Menu() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bw= new BufferedWriter(new OutputStreamWriter(System.out));
		mB = new ManageBoard();
	}

	public void recursionMenu() {
		try {
			int n= Integer.parseInt(br.readLine());
			waitForOption(n);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

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
			bw.write("caso 2 \n \n");
			bw.flush();
			break;
		default:
			bw.write("Seleccione una opcion valida \n \n");
			bw.flush();

		}
	}

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

	public void play() throws IOException {
		String input = br.readLine();
		if(input.equals("menu")) {

		}else if(input.equals("num")) {
			bw.write(mB.printString());
			bw.newLine();
			bw.flush();
			play();
		}else if(input.equals("")) {
			bw.write(mB.actionPlayers());
			bw.newLine();
			bw.flush();
			play();
		}else if(input.equals("help")) {
			bw.write("Entre un salto de linea para lanzar el dado \nEscriba: menu para volver el menu y para el juego \nEscriba: num, para mostrar el tablero completo \nEscriba: simul, para simular el juego");
			bw.newLine();
			bw.flush();
			play();
		}else if(input.equals("simul")){
			bw.write("simul pog");
			bw.newLine();
			bw.flush();
			play();
		}else {
			bw.write("Opción no valida");
			bw.newLine();
			bw.flush();
			play();
		}
	}
}
