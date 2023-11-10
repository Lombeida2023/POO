
package p1lombeidaana;
import java.util.Scanner;

/**
 *
 * @author LOMBEIDA ANA
 */
public class P1LombeidaAna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner =new Scanner(System.in);
        System.out.print("==========================================:");
        System.out.print("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE-SS:");
        System.out.print("LOMBEIDA FAJARDO ANA ELIZABETH:");
        System.out.print("PROGRAMACION ORIENTADA A OBJETOS:");
        System.out.print("ING.VERONICA MARTINEZ:");
        System.out.print("SUMA DE DOS NUMEROS:");
        System.out.print("==========================================:");
        System.out.print("Ingrese el primer numero:");
        double n1= scanner.nextDouble();
        System.out.print("Ingrese el segundo numero:");
        double n2= scanner.nextDouble();
        double suma=n1+n2;
        System.out.print("La suma del numero 1 y 2 es :" +suma);

        
    }
    
}
