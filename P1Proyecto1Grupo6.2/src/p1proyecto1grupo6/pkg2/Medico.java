package p1proyecto1grupo6.pkg2;

import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Persona{
    //ATRIBUTOS
    private String especialidad;
    public Medico() {
        this.especialidad = null;
    }
    public Medico(String especialidad, String nombres, String apellidos, int edad) {
        super(nombres, apellidos, edad);
        this.especialidad = especialidad;
    }
    //METODS GET AND SET
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void gestionarMedico(ArrayList<Medico> medicos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    =====================================================");
        System.out.println("                INGRESAR DATOS DEL MÉDICOS");
        System.out.println("    =====================================================");
        System.out.print("Ingrese los nombres del médico: ");
        String nombre = scanner.next();
        System.out.print("Ingrese los apellidos del médico: ");
        String apellidos = scanner.next();
        System.out.print("Ingrese la edad del médico: ");
        int edad = scanner.nextInt();
        while(edad<25||edad>100){
            System.out.print("[Ingrese la edad del médico]: ");
            edad = scanner.nextInt();
        }
        System.out.print("Ingrese la especialidad del médico: ");
        String especialidad = scanner.next();
        Medico nuevoMedico = new Medico(especialidad, nombre, apellidos, edad);
        medicos.add(nuevoMedico);
        System.out.println("Médico registrado con éxito.");
    }
    public void verMedicos(ArrayList<Medico> medicos) {
        for (Medico medico : medicos) {
            System.out.println("    =====================================================");
            System.out.println("                    DATOS DEL MÉDICOS");
            System.out.println("    =====================================================");
            System.out.println("NOMBRES: " + medico.getNombres());
            System.out.println("APELLIDOS: " + medico.getApellidos());
            System.out.println("EDAD: "+medico.getEdad());
            System.out.println("ESPECIALIDAD: "+medico.getEspecialidad());
            System.out.println("    =====================================================");
        }
    }
}
