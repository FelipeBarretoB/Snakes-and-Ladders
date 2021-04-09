package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.ManageBoard;


public class Main {
	private BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	private BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	private ManageBoard mB;
	
	public Main() {
		mB = new ManageBoard();
	}
	
	public static void main(String [] args) {
		Main ui=new Main();
		try {
			ui.die();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void die()throws IOException {
			bw.write(""+mB.rollDie());
			bw.newLine();

	}

	
	public int showMenu() throws IOException, NumberFormatException {

		int option=0;
		bw.write(
				"Menú principal, seleccione una opción\n" +
						"(1) Para registrar documento de la persona \n" +
						"(2) Para consultar cuantas personas han intentado ingresar al minimercado \n"+
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

			bw.write("\n \n");
			bw.flush();
			break;
		case 2:
			bw.write(" \n \n");
			bw.flush();
			break;
		default:
			bw.write("Seleccione una opcion valida \n \n");
			bw.flush();

		}
	}
}
