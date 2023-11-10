/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg12p1taller1lombeidaana;
import java.util.Scanner;//Libreria

/**
 *
 * @author LOMBEIDA ANA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            System.out.println("====================================================");
            System.out.println("    UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE-SS      ");
            System.out.println("    INGENIERIA EN TECNOLOGIAS DE LA INFORMACION     ");
            System.out.println("====================================================");
            System.out.println("           LOMBEIDA FAJARDO ANA ELIZABETH           ");
            System.out.println("            PROGRAMACION ORIENTADA A OBJETOS        ");
            System.out.println("                  ING.VERONICA MARTINEZ             ");
            System.out.println("                      10/11/2023                    ");
            System.out.println("====================================================");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el primer numero:");
            double n1= scanner.nextDouble();
            System.out.println("Ingrese el segundo numero:");
            double n2= scanner.nextDouble();
            double suma=n1+n2;
            double resta=n1-n2;
            double multiplicacion=n1*n2;
            double division=n1/n2;
            System.out.println("====================================================");
            System.out.println("La suma del numero 1 y 2 es :" +suma);
            System.out.println("La resta del numero 1 y 2 es :" +resta);
            System.out.println("La multiplicacion del numero 1 y 2 es :" +multiplicacion);
            System.out.println("La division del numero 1 y 2 es :" +division);
            System.out.println("====================================================");


    }
    
}
