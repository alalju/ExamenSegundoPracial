package Menus;

import Archivos.RegistroAlumno;
import Archivos.RegistroProfesor;

import java.util.Scanner;

public class Menu {

    public void mostarMenuIngreso(){
        int op;
        Scanner scanner=new Scanner(System.in);
        int n;
        String nombre;
        String apellido;
        String telefono;
        String correo;
        String identificador;



        System.out.println("Elija una opción");
        System.out.println("1- Ingresar al sistema");
        System.out.println("2- Registarse en el sistema");

        op=scanner.nextInt();
        switch (op){
            case 1:
                String buscar;
                RegistroAlumno registroAlumno=new RegistroAlumno();
                RegistroProfesor registroProfesor=new RegistroProfesor();

                System.out.println("ingrese su clave/matricula");

                buscar= scanner.next();

                if(registroAlumno.buscarAlumno(buscar)==true){
                    MenuAlumno menuAlumno= new MenuAlumno();
                    menuAlumno.mostarMenuAlumno();

                } else if (registroProfesor.buscarProfesor(buscar)==true) {
                    MenuProfesores menuProfesores= new MenuProfesores();
                    menuProfesores.mostarMenuProfesores();

                }else{
                    System.out.println("Usuarios.Usuario no encontrado");
                }

                break;
            case 2:
                int opM = 0;
                System.out.println("Ingresa como deseas registrarte");
                System.out.println("1- Usuarios.Alumno");
                System.out.println("2- Usuarios.Profesor");
                opM= scanner.nextInt();

                if(opM==1){
                    MenuAlumno menuAlumno=new MenuAlumno();

                    System.out.println("Ingresar nombre: ");
                    nombre=scanner.next();
                    System.out.println("Ingresar apellido: ");
                    apellido= scanner.next();
                    System.out.println("Ingresar telefono: ");
                    telefono=scanner.next();
                    System.out.println("Ingresar correo: ");
                    correo=scanner.next();
                    System.out.println("Ingresar matricula: ");
                    identificador=scanner.next();
                    menuAlumno.registar(nombre,apellido,telefono,correo,identificador);

                } else if (opM==2) {
                    MenuProfesores menuProfesores=new MenuProfesores();
                    System.out.println("Ingresar nombre: ");
                    nombre=scanner.next();
                    System.out.println("Ingresar apellido: ");
                    apellido= scanner.next();
                    System.out.println("Ingresar telefono: ");
                    telefono=scanner.next();
                    System.out.println("Ingresar correo: ");
                    correo=scanner.next();
                    System.out.println("Ingresar clave: ");
                    identificador=scanner.next();
                    menuProfesores.registar(nombre,apellido,telefono,correo,identificador);

                }else {
                    System.out.println("Opción no valida");
                }


                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

}
