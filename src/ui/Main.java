package ui;

import java.util.Scanner;

import exceptions.ForbiddenIdType;
import exceptions.NotAllowedToLeave;
import model.MiniMarket;

public class Main {
	
	private static Scanner in;
	private static MiniMarket miniMarket;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		miniMarket = new MiniMarket();
		boolean leave = false;
		for(;!leave;) {
			showMenu();
			int selected = readOption();
			switch(selected) {
			case 1:
				readPerson();
			break;
			
			case 2:
				System.out.println("El numero de personas que han intentado entrar han sido: " + miniMarket.getAmountOfTries());
			break;
			
			case 3:
				leave = true;
			break;
			
			default:
				leave = true;
			}
		}
	}
	
	private static void showMenu() {
		System.out.println("Bienvenido, ingrese el numero de la opcion que desea ejecutar\n");
		System.out.println("1. Agregar una nueva persona\n");
		System.out.println("2. Consultar la cantidad de personas que han intentado entrar\n");
		System.out.println("3. Salir\n");
	}
	
	private static int readOption() {
		int selected = in.nextInt();
		return selected;
	}
	
	private static void readPerson() {
		System.out.println("Ingrese\n1 si es Tarjeta de identidad\n2 si es Cedula de ciudadania\n3 si es Pasaporte\n4 si es Cedula extranjera");
		int selectedType = in.nextInt();
		System.out.println(selectedType);
		System.out.println("Ingrese el numero de identificacion");
		int idInt = in.nextInt();
		System.out.println(idInt);
		String id = String.valueOf(idInt);
		try {
			miniMarket.addPerson(selectedType, id);
			System.out.println("Persona agregada correctamente");
		} catch (ForbiddenIdType e) {
			System.out.println("No se ha podido agregar la persona porque la persona posee Tarjeta de identidad\n");
		} catch (NotAllowedToLeave e) {
			System.out.println("No se ha podido agregar la persona porque segun la normativa del gobierno no se le permite salir hoy\n");
		}
	}
}
