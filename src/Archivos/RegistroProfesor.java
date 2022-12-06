package Archivos;

import Usuarios.Profesor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistroProfesor {
    final String DOC = "RegistroProsor.txt";
    final int EXCEPCION_CODE = 0;
    public void registrarProfesor(Profesor profesor) {

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(DOC,true));

        } catch (FileNotFoundException e) {
            System.out.println("Error");
            System.exit(EXCEPCION_CODE);
        }
        outputStream.println(profesor.getNombre());
        outputStream.println(profesor.getApellido());
        outputStream.println(profesor.getTelefono());
        outputStream.println(profesor.getCorreo());
        outputStream.println(profesor.getClave());
        System.out.println("Escribiendo");
        outputStream.close();
    }

    public boolean buscarProfesor(String clave){
        boolean estado=false;
        try {
            Scanner scan = new Scanner(new File(DOC));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.equals(clave)){
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
