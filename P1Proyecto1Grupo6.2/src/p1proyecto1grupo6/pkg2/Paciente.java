package p1proyecto1grupo6.pkg2;

import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Persona{
    //ATRINBUTOS
    private int cantidadSintomas;
    private ArrayList<String> sintomas;

    public Paciente() {
        this.cantidadSintomas = 0;
        this.sintomas = new ArrayList<>();
    }
    
    public Paciente(int cantidadSintomas, ArrayList<String> sintomas, String nombres, String apellidos, int edad) {
        super(nombres, apellidos, edad);
        this.cantidadSintomas = cantidadSintomas;
        this.sintomas = sintomas;
    }
    //METODOS GET AND SET
    public int getCantidadSintomas() {
        return cantidadSintomas;
    }
    public void setCantidadSintomas(int cantidadSintomas) {
        this.cantidadSintomas = cantidadSintomas;
    }
    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }
    //METODO PARA GESTIONAR LOS PACINETES
    public void gestionarPaciente(ArrayList<Paciente> p) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaSintomas = new ArrayList<>();
        String siNo;
        System.out.println("    =====================================================");
        System.out.println("                INGRESAR DATOS DEL PACIENTES");
        System.out.println("    =====================================================");
        System.out.print("Ingrese los nombres del paciente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese los apellidos del paciente: ");
        String apellidos = scanner.next();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        while(edad<1||edad>100){
            System.out.print("[Ingrese la edad del paciente]: ");
            edad = scanner.nextInt();
        }
        System.out.print("Ingrese la cantidad de sintomas tiene el paciente: ");
        int cantidadSintomas=scanner.nextInt();
        for (int i = 0; i < cantidadSintomas; i++) {
            System.out.print("Ingrese el sintoma " + (i + 1) + ": ");
            String sintoma = scanner.next();
            listaSintomas.add(sintoma);
        }
        System.out.println("    =====================================================");
        Paciente nuevoPaciente = new Paciente(cantidadSintomas, listaSintomas, nombre, apellidos, edad);
        p.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
    }
    //METODO PARA VER PACEINTES DE ARRAGLEGO DE LA LISTA.
    public void verPaciente(ArrayList<Paciente> p){
        for (Paciente paciente : p) {
            System.out.println("    =====================================================");
            System.out.println("                    DATOS DEL PACIENTES");
            System.out.println("    =====================================================");
            System.out.println("NOMBRES: " + paciente.getNombres());
            System.out.println("APELLIDOS: " + paciente.getApellidos());
            System.out.println("EDAD: "+paciente.getEdad());
            System.out.println("CANTIDAD DE SINTOMAS: "+paciente.getCantidadSintomas());
            ArrayList<String> sintomas = paciente.getSintomas();
            for (int i = 0; i < sintomas.size(); i++) {
                System.out.println("Síntoma " + (i + 1) + ": " + sintomas.get(i));
            }
            System.out.println("    =====================================================");
        }
    }
}
