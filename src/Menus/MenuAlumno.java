package Menus;

import Archivos.Archivo;
import Archivos.RegistroAlumno;
import Usuarios.Alumno;
import operaciones.OperacionesAlumno;

import java.io.File;
import java.util.Scanner;

public class MenuAlumno {
    public  void registar(String nombre,String apellido, String telefono, String correo, String matricula){
        RegistroAlumno registroAlumno=new RegistroAlumno();
        Alumno alumno=new Alumno(nombre,apellido,telefono,correo,matricula);
        registroAlumno.registrarAlumno(alumno);
    }
    public void mostarMenuAlumno(){
        int op;
        String matricula;
        String ruta;
        File file;
        Scanner scanner=new Scanner(System.in);
        Archivo archivo=new Archivo();
        OperacionesAlumno operacionesAlumno=new OperacionesAlumno();


        System.out.println("Elija una opción");
        System.out.println("1- Consultar calificaciones por parcial");
        System.out.println("2- Consultar promedio final");

        op=scanner.nextInt();
        switch (op){
            case 1:
                System.out.println("Ingrese su matricula");
                matricula=scanner.next();
                ruta=archivo.buscarArchivoA(matricula);
                operacionesAlumno.consultarParcial(ruta);

                break;
            case 2:
                System.out.println("Ingrese su matricula");
                matricula=scanner.next();
                ruta=archivo.buscarArchivoA(matricula);
                operacionesAlumno.consultarPromedioF(ruta);
                file= new File(archivo.guardarArchivoRuta("Promedio Final"+matricula));
                break;
            default:
                break;
        }
    }
}
