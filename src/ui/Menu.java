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
						"(2) Ver tablero \n"+
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

			bw.write("caso 1 \n \n");
			mB.createBoard(3, 3, 0, 0, null);
			bw.flush();
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
}
