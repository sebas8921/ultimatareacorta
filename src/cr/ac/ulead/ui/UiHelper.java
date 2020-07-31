package cr.ac.ulead.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class UiHelper {
	private PrintStream output = new PrintStream(System.out);
	private Scanner input = new Scanner(System.in);

	public void menuPrincipal() {
		output.println("Bienvenido a la ultima tarea corta - Recorridos en arboles binarios");
		output.println("Usted se encuentra en el menu principal");
		output.println("-----------------------------------------------------------------------------");
		output.println("1. Insertar una persona");
		output.println("2. Leer un banco de personas desde un archivo de texto");
		output.println("3. Imprimir arbol bajo el metodo IN-ORDER");
		output.println("4. Imprimir arbol bajo el metodo PRE-ORDER");
		output.println("5. Imprimir arbol bajo el metodo POST-ORDER");
		output.println("6. Salir del programa");
	}

	public int leerOpcion() {
		output.println("Digite el numero de la opcion que desea realizar: ");
		return input.nextInt();
	}

	public String leerTexto() {
		return input.next();
	}

	public void msg(String msg) {
		output.println(msg);
	}

}
