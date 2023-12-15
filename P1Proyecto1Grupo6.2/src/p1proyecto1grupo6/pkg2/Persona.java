package p1proyecto1grupo6.pkg2;

public class Persona {
    //ATRIBUTOS
    private String nombres;
    private String apellidos;
    private int edad;
    public Persona() {
        this.nombres = null;
        this.apellidos =null;
        this.edad = 0;
    }
    public Persona(String nombres, String apellidos, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    
    //GET AND SET
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
