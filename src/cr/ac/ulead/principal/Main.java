package cr.ac.ulead.principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import cr.ac.ulead.entidades.Persona;
import cr.ac.ulead.entidades.Tree;
import cr.ac.ulead.ui.UiHelper;

public class Main {

	static UiHelper interfaz = new UiHelper();
	static Tree arbol = new Tree();
	
    public static void main(String[] args) {
      
	  int opc = 0;
	  do{
		  interfaz.menuPrincipal();
		  opc = interfaz.leerOpcion();
		  switch(opc) {
		  case 1:
			  insertarPersona();
			  break;
		  case 2:
			  loadFileIntoTree(arbol);
			  break;
		  case 3:
			  arbol.inOrder(arbol.root);
			  break;
		  case 4:
			  arbol.preOrder(arbol.root);
			  break;
		  case 5:
			  arbol.postOrder(arbol.root);
			  break;
		  case 6:
			  interfaz.msg("Gracias por utilizar el programa...Hasta pronto!");
			  break;
		  default:
			  interfaz.msg("Opcion invalida");
			  break;
			  
		  }
	  }while(opc != 6);
	   
    }
    
    private static void loadFileIntoTree(Tree arbol) {
    	try {
			Scanner filereader = new Scanner(new File("C:\\dev\\ultimatareacorta\\personas.csv"), "UTF-8");
			ArrayList<String> registros = new ArrayList<String>();

			while (filereader.hasNextLine()) {
				String linea = filereader.nextLine();
				registros.add(linea);
			}
			registros.remove(0);
			filereader.close();
			for (int i = 0; i < registros.size(); i++) {
				String datos[] = registros.get(i).split(",");
				Persona per = new Persona();
				per.setNombre(datos[0]);
				per.setApellido(datos[1]);
				per.setCedula(datos[2]);
				per.setFecha_nac(stringToDate(datos[3]));
				arbol.insert(per);
			}
			interfaz.msg("El archivo fue cargado con exito..");

		} catch (FileNotFoundException e) {
			interfaz.msg("No fue posible encontrar el archivo...");
		}
		
	}

	private static void insertarPersona() {
    	Persona per = new Persona();
		interfaz.msg("Digite el nombre de la persona: ");
		per.setNombre(interfaz.leerTexto());
		interfaz.msg("Digite el apellido de la persona: ");
		per.setApellido(interfaz.leerTexto());
		interfaz.msg("Digite la cedula de la persona: ");
		per.setCedula(interfaz.leerTexto());
		interfaz.msg("Digite la fecha de nacimiento de la persona en el formato dd/mm/yyyy: ");
		per.setFecha_nac(stringToDate(interfaz.leerTexto()));
		arbol.insert(per);
		
	}

	public static LocalDate stringToDate(String date) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException e) {
        	interfaz.msg("Formato de fecha Invalida");
            return null;
        }
        return localDate;
    }
    
}
