package Vista;

import Modelo.Estudiante;
import java.util.Scanner;
        

public class Run {
    private final Scanner sc = new Scanner(System.in);
    public void showMenu(){
        System.out.println("\n==== MENU ====");
        System.out.println("1) Ver en qué carrera estás (buscar por nombre)");
        System.out.println("2) Ver ingresantes por carrera");
        System.out.println("3) Buscar por tu nombre");
        System.out.println("4) Salir");
        System.out.print("Elige una opción: ");
    }
    
    public int LeerOpcion(){
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch(Exception e) {
            return -1;
        }

    }
    
    
}
