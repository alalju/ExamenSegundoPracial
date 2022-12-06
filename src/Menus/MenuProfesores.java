package Menus;

import Archivos.Archivo;
import Archivos.RegistroProfesor;
import Usuarios.Profesor;
import operaciones.OperacionesProfesor;

import java.util.Scanner;

public class MenuProfesores {
    public  void registar(String nombre,String apellido, String telefono, String correo, String matricula){
        RegistroProfesor registroProfesor=new RegistroProfesor();
        Profesor profesor=new Profesor(nombre,apellido,telefono,correo,matricula);
        registroProfesor.registrarProfesor(profesor);
    }
    public void mostarMenuProfesores() {
        int op;
        String matricula;
        String grupo;
        double promedio=0;
        Archivo archivo=new Archivo();
        Scanner scanner=new Scanner(System.in);
        OperacionesProfesor operacionesProfesor=new OperacionesProfesor();

        System.out.println("Elija una opción");
        System.out.println("1- Capturar calificación parcial por alumno");
        System.out.println("2- registrar promedio grupal ");
        System.out.println("3- Calcular promedio grupal ");
        System.out.println("4- Calcular promedio por alumno ");

        String file;


        op=scanner.nextInt();
        switch (op){
            case 1:
                System.out.println("Ingrese la matricula del alumno: ");
                matricula=scanner.next();
                file=archivo.guardarArchivoRuta(matricula);
                operacionesProfesor.registrarCalificacionPorAlumno(file);

                break;
            case 2:
                System.out.println("Ingrese el grupo: ");
                grupo=scanner.next();
                file=archivo.guardarArchivoRuta(grupo);
                operacionesProfesor.registrarCalificacionGrupo(file);
                break;
            case 3:
                System.out.println("Ingrese la matricula del alumno:  ");
                matricula=scanner.next();
                promedio=operacionesProfesor.calcularPromedioA(matricula);
                System.out.println(promedio);
                file=archivo.guardarArchivoRuta("Promedio"+matricula);
                operacionesProfesor.registarPromedio(file,promedio);
                break;
            case 4:
                System.out.println("Ingrese el grupo:  ");
                grupo=scanner.next();
                promedio=operacionesProfesor.calcularPromedioG(grupo);
                System.out.println(promedio);
                file=archivo.guardarArchivoRuta("Promedio"+grupo);
                operacionesProfesor.registarPromedio(file,promedio);
                break;
            default:
                break;
        }
    }
}
