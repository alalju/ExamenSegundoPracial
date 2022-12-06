package Archivos;

import Usuarios.Alumno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistroAlumno {
    final String DOC = "RegistroAlumnos.txt";
    final int EXCEPCION_CODE = 0;
    public void registrarAlumno(Alumno alumno) {


        PrintWriter outputStream = null;
        PrintWriter aux = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(DOC,true));

        } catch (FileNotFoundException e) {
            System.out.println("Error");
            System.exit(EXCEPCION_CODE);
        }
        outputStream.println(alumno.getNombre());
        outputStream.println(alumno.getApellido());
        outputStream.println(alumno.getTelefono());
        outputStream.println(alumno.getCorreo());
        outputStream.println(alumno.getMatricula());

        System.out.println("Escribiendo");
        outputStream.close();
    }
    public boolean buscarAlumno(String matricula){
        boolean estado=false;
        try {
            Scanner scan = new Scanner(new File(DOC));
            while(scan.hasNextLine() && estado!=true){
                String line = scan.nextLine();
                if(line.equals(matricula)){
                    estado=true;
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problema al abrir el archivo.");
        } catch (Exception e) {
            System.out.println("Error de lectura ");
        }
        return estado;
    }


}
