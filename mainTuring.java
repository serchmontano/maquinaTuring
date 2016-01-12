//Librerias necesarias para el funcionamiento del programa
import java.io.*;
import java.util.*;

public class mainTuring{
//Metodo principal que incluye el menu de opciones
  public static void main(String[] args) {
	menu();
  }
  public static void menu(){
	Scanner sc = new Scanner(System.in);
    String cadena;
    int opc;

    System.out.println("Selecciona una opcion.");
    System.out.println("\n1) Ingresa la cadena parte del lenguaje 0^n1^n.");
    System.out.println("2) Genera una cadena que sea parte del lenguaje 0^n1^n.");

    System.out.print("\nIngresa tu opcion: ");
    try{
		opc = sc.nextInt();
		switch(opc){
			case 1:
			cadena = ingresaCad().toLowerCase();
			maquinaTuring m = new maquinaTuring(cadena);
			break;
			case 2:
				cadena = generaCad().toLowerCase();
				maquinaTuring n = new maquinaTuring(cadena);
			break;
			default:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nOpcion no valida!");
				menu();
			break;
		}
	}
	catch(Exception e){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nCaracter no valido!");
		menu();
	}
  }
//Metodo que sirve para ingresar la cadena de 0n1n por el usuario
  public static String ingresaCad(){
    Scanner sc = new Scanner(System.in);
    String cadena;

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIngresa su cadena de 0's y 1's");
    System.out.println("Debe de seguir el orden 0^n y 1^n");
    System.out.print("Por ejemplo 01 - 0011 - 000111 - 000n111n: ");
    cadena = sc.nextLine();

    return cadena;
  }
//Metodo que genera la cadena de 0n1n aleatoriamente
  public static String generaCad(){
    Random rnd = new Random();
    String cadena;
  	String part1 = "";
  	String part2 = "";
  	int tam1, tam2, secR;

    tam1 = (int)(rnd.nextDouble() * 500 + 1);
    secR = 1000-tam1;
    tam2 = (int)(rnd.nextDouble() * secR + 1);
    for(int i = 0; i < tam1; i++){
		    part1 = part1 + "0";
    }
    for(int j = 0; j < tam2; j++){
		    part2 = part2 + "1";
	  }
    cadena = part1 + part2;
    return cadena;
  }
}
