package p1proyecto1grupo6.pkg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1Proyecto1Grupo62 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final String[] usuario={"Ana","Dereck","Bryan"};
        final String[] contrasenia={"1","2","3"};
        String usuIngresar, conIngresar;
        boolean programa;
        encabazado();
        System.out.println("    =====================================================");
        System.out.println("                 PROGRAMA PARA UNA CLINICA");
        System.out.println("    =====================================================");
        System.out.println(" PARA INGRESAR AL PROGRAMA DEBE TENER [USURIO] Y [CONTRASEÑA]");
        System.out.println("    =====================================================");
        System.out.println("            USUARIO 1: [Ana]      CONTRACEÑA 1: [1]");
        System.out.println("            USUARIO 2: [Dereck]   CONTRACEÑA 2: [2]");
        System.out.println("            USUARIO 3: [Bryan]    CONTRACEÑA 3: [3]");
        System.out.println("    =====================================================");
        do{
            programa=false;
            System.out.print("Ingrese el Usuario: ");
            usuIngresar=scanner.next();
            System.out.print("Ingrese la contraseña: ");
            conIngresar=scanner.next();
            if (validarContraseniaUsuario(usuario, contrasenia, usuIngresar, conIngresar)) {
                System.out.println("    =====================================================");
                System.out.println("                INICIO DE SESIÓN [EXITOSO]");
                System.out.println("            BIENVENIDO AL PROGRAMA DE LA CLINICA");
                System.out.println("    =====================================================");
                menuPrincipal();
            }else{
                System.out.println("    =====================================================");
                System.out.println("                INICIO DE SESIÓN [FALLIDO]");
                System.out.println("              USUARIO O CONTRASEÑA INCORRECTO");
                System.out.println("    =====================================================");
                programa=true;
            }
        }while(programa);
    }
    
    //METODO ENCAVEZADO, [QUE SOLO SIERVER PARA LA CLASE MAIN]
    private static void encabazado(){
        System.out.println("    =====================================================");
        System.out.println("           UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE       ");
        System.out.println("              PROGRAMACIÓN ORIENTADA A OBJETOS           ");    
        System.out.println("        JIMENEZ DERECK - QUIROZ BRYAN - LOMBEIDA ANA     ");
        System.out.println("                      PROYECTO UNIDAD 1                  ");
        System.out.println("                    14 DE DICIEMBRE 2023                 ");
        System.out.println("    =====================================================");
    }
    //METODO PARA EL MENU PRINCIPAL
    private static void menuPrincipal(){
        Scanner scanner=new Scanner(System.in);
        int opcionMenu1;
        do{
            System.out.println("    =====================================================");
            System.out.println("                       MENU CLINICA");
            System.out.println("    =====================================================");
            System.out.println("    1. PACIENTE");
            System.out.println("    2. MEDICOS");
            System.out.println("    3. SALIR");
            System.out.println("    =====================================================");
            System.out.print("Ingrese la opcion: ");
            opcionMenu1=scanner.nextInt();
            switch(opcionMenu1){
                case 1:
                    menuPaciente();
                    break;
                case 2:
                    menuMedicos();
                    break;
                case 3:
                    System.out.println("[GRACIAS POR INGRESAR AL MENU]");
                    break;
                default:
                    System.out.println("[LA OPCION INGRESARDA ES INCORRECTA]");
            }
        }while(opcionMenu1!=3);
    }
    //METODO PARA EL MENU PARA LOS PACIENTES
    private static void menuPaciente(){
        Scanner scanner=new Scanner(System.in);
        Paciente obPaciente=new Paciente();
        ArrayList<Paciente> obPacientes=new ArrayList<>();
        String  csvFilename,siNo;
        int opcionMenu1,paciente=0,archivo=0;
        do{
            System.out.println("    =====================================================");
            System.out.println("                       MENU PACIENTE");
            System.out.println("    =====================================================");
            System.out.println("    1. REGISTRAR DATOS PACIENTE");
            System.out.println("    2. VER PACIENTES");
            System.out.println("    3. CREAR ARCHIVO CSV");
            System.out.println("    4. CARGAR ARCHIVO CSV");
            System.out.println("    5. SALIR");
            System.out.println("    =====================================================");
            System.out.print("Ingrese la opcion: ");
            opcionMenu1=scanner.nextInt();
            switch(opcionMenu1){
                case 1:
                    obPaciente.gestionarPaciente(obPacientes);
                    paciente++;
                    break;
                case 2:
                    if(paciente!=0){
                        obPaciente.verPaciente(obPacientes);
                    }else{
                        System.out.println("[NO HAY PACIENES REGISTRADOS, PARA VER SUS DATOS]");
                    }
                    break;
                case 3:
                    if(paciente!=0){
                        do{
                            archivo++;
                            System.out.print("Desea crear el archivo [S/N]: ");
                            siNo=scanner.next();
                            if(siNo.equals("S")||siNo.equals("s")){
                                System.out.print("Ingrese el nombre del archivo CSV: ");
                                csvFilename = scanner.next();
                                guardarDatosEnCSV(csvFilename, obPacientes);
                            }
                        }while((!siNo.equals("S")&&!siNo.equals("s"))&&(!siNo.equals("N")&&!siNo.equals("n")));
                    }else{
                        System.out.println("[NO HAY PACIENES REGISTRADOS, PARA CREAR EL ARCHIVO .csv]");
                    }
                    break;
                case 4:
                    System.out.println("archivo: "+ archivo);
                    if(archivo!=0){
                        // Ruta del directorio donde están los archivos
                        String directorio = "C:\\Users\\ISAI\\Desktop\\P1Proyecto1Grupo6.2";
                        verArchivosCreadosCSV(directorio);
                        do{
                           System.out.print("Desea ver el archivo [S/N]: ");
                                siNo=scanner.next();
                                if(siNo.equals("S")||siNo.equals("s")){
                                    System.out.print("Ingrese el nombre del archivo CSV: ");
                                    csvFilename = scanner.next();
                                    List<String[]> datosCSV = cargarContenidoCSV(csvFilename);
                                    // Imprimir o procesar los datos según tus necesidades
                                    for (String[] fila : datosCSV) {
                                        for (String columna : fila) {
                                            System.out.print(columna + " ");
                                        }
                                        System.out.println();  // Nueva línea para la próxima fila
                                    }
                                }
                        }while((!siNo.equals("S")&&!siNo.equals("s"))&&(!siNo.equals("N")&&!siNo.equals("n")));
                    }else{
                        System.out.println("[NO HAY NIGUN ARCHIVO CREADO, PARA VER SUS DATOS]");
                    }
                    break;
                case 5:
                    System.out.println("[GRACIAS POR INGRESAR AL MENU]");
                    break;
                default:
                    System.out.println("[LA OPCION INGRESARDA ES INCORRECTA]");
            }
        }while(opcionMenu1!=5);
    }
    
    //METODO PARA EL MENU PARA LOS PACIENTES
    private static void menuMedicos(){
        Scanner scanner=new Scanner(System.in);
        Medico obMedico=new Medico();
        Medico obMedico1=new Medico("DOCTOR GENERAL","CAMILA", "OBANDO",25);
        Medico obMedico2=new Medico("PEDIATRA","ANA", "LOMBEIDA",25);
        Medico obMedico3=new Medico("ODONTOLOGA","NATALI","QUILCA",27);
        ArrayList<Medico> obMedicos=new ArrayList<>();
        obMedicos.add(obMedico1);
        obMedicos.add(obMedico2);
        obMedicos.add(obMedico3);
        String  jsonFilename,siNo;
        int opcionMenu1,archivo=0;
        do{
            System.out.println("    =====================================================");
            System.out.println("                       MENU MEDICOS");
            System.out.println("    =====================================================");
            System.out.println("    1. REGISTRAR DATOS MEDICOS");
            System.out.println("    2. VER MEDICOS");
            System.out.println("    3. CREAR ARCHIVO JSON");
            System.out.println("    4. CARGAR ARCHIVO JSON");
            System.out.println("    5. SALIR");
            System.out.println("    =====================================================");
            System.out.print("Ingrese la opcion: ");
            opcionMenu1=scanner.nextInt();
            switch(opcionMenu1){
                case 1:
                    System.out.println("    =====================================================");
                    System.out.println("                    MÉDICOS [REGISTRADOS]");
                    System.out.println("    =====================================================");
                    obMedico.verMedicos(obMedicos);
                    do{
                        System.out.println("Desa registar un Médico [S/N]:");
                        siNo=scanner.next();
                        if(siNo.equals("S")||siNo.equals("s")){
                            obMedico.gestionarMedico(obMedicos);
                        }
                        }while((!siNo.equals("S")&&!siNo.equals("s"))&&(!siNo.equals("N")&&!siNo.equals("n")));
                    break;
                case 2:
                    obMedico.verMedicos(obMedicos);
                    break;
                case 3:
                    do{
                        archivo++;
                        System.out.print("Desea crear el archivo [S/N]: ");
                        siNo=scanner.next();
                        if(siNo.equals("S")||siNo.equals("s")){
                            System.out.print("Ingrese el nombre del archivo JSON: ");
                            jsonFilename = scanner.next();
                            guardarDatosEnJSON(jsonFilename,obMedicos);
                        }
                    }while((!siNo.equals("S")&&!siNo.equals("s"))&&(!siNo.equals("N")&&!siNo.equals("n")));
                    break;
                case 4:
                    if(archivo!=0){
                        // Ruta del directorio donde están los archivos
                        String directorio = "C:\\Users\\ISAI\\Desktop\\P1Proyecto1Grupo6.2";
                        verArchivosCreadosJSON(directorio);
                        do{
                            System.out.println("Desea ver el archivo [S/N]: ");
                            siNo=scanner.next();
                            if(siNo.equals("S")||siNo.equals("s")){
                                System.out.print("Ingrese el nombre del archivo JSON: ");
                                jsonFilename = scanner.next();
                                //cargarDatosDesdeJSON(jsonFilename, obMedicos);
                            }
                            }while((!siNo.equals("S")&&!siNo.equals("s"))&&(!siNo.equals("N")&&!siNo.equals("n")));
                    }else{
                        System.out.println("NO HAY NIGUN ARCHIVO CREADO, PARA VER SUS DATOS]");
                    }
                    break;
                case 5:
                    System.out.println("[GRACIAS POR INGRESAR AL MENU]");
                    break;
                default:
                    System.out.println("[LA OPCION INGRESARDA ES INCORRECTA]");
            }
        }while(opcionMenu1!=5);
    }
    
    //METODO PARA GUARDAD DATOS EN UN ARCHIVO CSV.
    private static void guardarDatosEnCSV(String filename, ArrayList<Paciente> pacientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".csv"))) {
            writer.write("NOMBRE,APELLIDO,EDAD,CANTIDAD DE SINTOMAS");
            writer.newLine();
            for (Paciente paciente : pacientes) {
                writer.write(paciente.getNombres()+ ","+paciente.getApellidos()+ ","+paciente.getEdad()+","+paciente.getCantidadSintomas());
                writer.newLine();
            }
            System.out.println("[DATOS GUARDADOS EN " + filename+"]");
        } catch (IOException e) {
            System.err.println("[ERROR AL GUARDAR DATOS EN CSV]: " + e.getMessage());
        }
    }
    
    private static void guardarDatosEnJSON(String nombreArchivo, ArrayList<Medico> medicos) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo + ".json")) {
            fileWriter.write("[\n");

            for (Medico medico : medicos) {
                fileWriter.write("  {\n");
                fileWriter.write("    \"NOMBRES\": \"" + medico.getNombres()+ "\",\n");
                fileWriter.write("    \"APELLIDOS\": \"" + medico.getApellidos()+ "\",\n");
                fileWriter.write("    \"EDAD\": \"" + medico.getEdad()+ "\",\n");
                fileWriter.write("    \"ESPECIALIDAD\": \"" + medico.getEspecialidad()+ "\"\n");
                fileWriter.write("  },\n");
            }

            fileWriter.write("]\n");

            System.out.println("[DATOS GUARDADOS EN " + nombreArchivo + ".json]");
        } catch (IOException e) {
            System.err.println("[ERROR AL GURARDAR DATOS EN JSON]: " + e.getMessage());
        }
    }
    //METODO PARA VER LOS ARCHIVOS (CSV) QUE TEMEMOS CREADOS
    private static void verArchivosCreadosCSV(String directorio){
        // Crear un objeto File con la ruta del directorio
        File folder = new File(directorio);
        // Verificar si el directorio existe
        if (folder.exists() && folder.isDirectory()) {
            // Obtener la lista de archivos en el directorio
            File[] files = folder.listFiles();
            // Mostrar los nombres de los archivos CSV
            if (files != null) {
                System.out.println("    =====================================================");
                System.out.println("            LOS ARCHIVOS QUE ESTAN CREADO");
                System.out.println("    =====================================================");
                for (File file : files) {
                    // Verificar si el nombre del archivo termina con ".csv"
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                        System.out.println(file.getName());
                    }
                }
                System.out.println("    =====================================================");
            } else {
                System.out.println("[EL DIRECTORIO ESTA VACIO]");
            }
        } else {
            System.out.println("[EL DIRECTORIO NO EXISTE O NO ES UN DIRECTORIO VALIDO]");
        }
    }
     
    //METODO PARA VER LOS ARCHIVOS (CSV) QUE TEMEMOS CREADOS
    private static void verArchivosCreadosJSON(String directorio){
        // Crear un objeto File con la ruta del directorio
        File folder = new File(directorio);
        // Verificar si el directorio existe
        if (folder.exists() && folder.isDirectory()) {
            // Obtener la lista de archivos en el directorio
            File[] files = folder.listFiles();
            // Mostrar los nombres de los archivos CSV
            if (files != null) {
                System.out.println("    =====================================================");
                System.out.println("            LOS ARCHIVOS QUE ESTAN CREADO");
                System.out.println("    =====================================================");
                for (File file : files) {
                    // Verificar si el nombre del archivo termina con ".csv"
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".json")) {
                        System.out.println(file.getName());
                    }
                }
                System.out.println("    =====================================================");
            } else {
                System.out.println("[EL DIRECTORIO ESTA VACIO]");
            }
        } else {
            System.out.println("[EL DIRECTORIO NO EXISTE O NO ES UN DIRECTORIO VALIDO]");
        }
    }
    //METODO VALIDAD LA CONTRASEÑA Y USUARIO, [QUE SOLO SIRVE PARA LA CASE MAIN]
    private static boolean validarContraseniaUsuario(String[] u, String[] c, String uI, String cI){
        for (int i = 0; i<u.length; i++) {
            if(u[i].equals(uI)&&c[i].equals(cI)){
                return true;
            }
        }
        return false;
    }
    private static List<String[]> cargarContenidoCSV(String filename) {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(filename + ".csv"))) {
            String linea;

            // Leer cada línea del archivo CSV
            while ((linea = lector.readLine()) != null) {
                // Dividir la línea en columnas usando la coma como separador
                String[] columnas = linea.split(",");
                datos.add(columnas);
            }

        } catch (IOException e) {
            // Manejar posibles errores de lectura del archivo
            System.out.println("Se ha producido un error al cargar el archivo CSV.");
            e.printStackTrace();
        }
        return datos;
    }
     /*private static void cargarDatosDesdeJSON(String nombreArchivo, ArrayList<Medico> medicos) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo + ".json"))) {
            String linea;
            StringBuilder jsonCompleto = new StringBuilder();
            while ((linea = reader.readLine()) != null) {
                jsonCompleto.append(linea).append("\n");
            }
            // Elimina la coma final antes del corchete de cierre (si existe)
            String jsonFinal = jsonCompleto.toString().trim();
            if (jsonFinal.endsWith(",")) {
                jsonFinal = jsonFinal.substring(0, jsonFinal.length() - 1);
            }
            // Convierte el JSON en un arreglo de cadenas (cada elemento es un JSON de un médico)
            String[] jsonMedicos = jsonFinal.split("\\},\n");
            // Recorre los JSON de médicos y agrega a la lista
            for (String jsonMedico : jsonMedicos) {
                String[] partes = jsonMedico.split("\",\n");
                String nombre = partes[0].split(": \"")[1];
                String apellidos = partes[1].split(": \"")[1];
                //int  edad = partes[2].split(": \"")[1];
                String especialidad = partes[2].split(": \"")[1];
                // Elimina comillas dobles alrededor de los valores
                nombre = nombre.replaceAll("\"", "");
                especialidad = especialidad.replaceAll("\"", "");
                apellidos=apellidos.replaceAll("\"", "");
                medicos.add(new Medico(especialidad, nombre, apellidos, 0));
            }

            System.out.println("Datos cargados desde " + nombreArchivo + ".json");
        } catch (IOException e) {
            System.err.println("Error al cargar datos desde JSON: " + e.getMessage());
        }
    }*/
}