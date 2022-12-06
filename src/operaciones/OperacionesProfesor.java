package operaciones;

import Archivos.Archivo;
import Archivos.RegistroAlumno;
import Menus.MenuAlumno;
import Usuarios.Alumno;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class OperacionesProfesor {

    public void registrarCalificacionPorAlumno(String ruta)  {
        //Para identificar el documento cun la calificación del usuario se nombra con su matricula
        Path file = Paths.get(ruta);
        PrintWriter outputStream = null;
        Scanner scanner=new Scanner(System.in);
        String calificacion;

        byte[] datos;
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file,CREATE));

            System.out.println("Ingrese calificacion parcial 1: ");
            calificacion=scanner.next()+"\n";
            datos = calificacion.getBytes();
            output.write(datos );
            System.out.println("Ingrese calificacion parcial 2: ");
            calificacion=scanner.next()+"\n";
            datos = calificacion.getBytes();
            output.write(datos );
            System.out.println("Ingrese calificacion parcial 2: ");
            calificacion=scanner.next()+"\n";
            datos = calificacion.getBytes();
            output.write(datos );


            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Mensaje: " + e);
        }
    }

    public void registrarCalificacionGrupo(String ruta){
        //Para identificar el documento cun la calificación del usuario se nombra con su matricula
        Path file = Paths.get(ruta);
        PrintWriter outputStream = null;
        Scanner scanner=new Scanner(System.in);
        String calificacion;

        Alumno alumno;
        String nombre;
        String apellido;
        String telefono;
        String correo;
        String identificador;
        RegistroAlumno registroAlumno=new RegistroAlumno();


        byte[] datos;
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file,CREATE));


            System.out.println("Ingresa el número de estudiantes que tiene el grupo");
            int integrantes=scanner.nextInt();
            for (int i=0;i<integrantes;i++){
                MenuAlumno menuAlumno=new MenuAlumno();

                System.out.println("Ingresar nombre: ");
                nombre=scanner.next()+"\n";
                datos = nombre.getBytes();
                output.write(datos );
                System.out.println("Ingrese calificacion parcial 1: ");
                calificacion=scanner.next()+"\n";
                datos = calificacion.getBytes();
                output.write(datos );
                System.out.println("Ingrese calificacion parcial 2: ");
                calificacion=scanner.next()+"\n";
                datos = calificacion.getBytes();
                output.write(datos );
                System.out.println("Ingrese calificacion parcial 2: ");
                calificacion=scanner.next()+"\n";
                datos = calificacion.getBytes();
                output.write(datos );
            }


            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println("Mensaje: " + e);
        }

    }

    public double calcularPromedioA(String matricula){
        double promedio=0;
        Archivo archivo=new Archivo();
        boolean estado=false;
        File docs = new File("C:\\Users\\albaa\\OneDrive\\Documents");
        File dow = new File("C:\\Users\\albaa\\OneDrive\\Downloads");
        File esc = new File("C:\\Users\\albaa\\OneDrive\\Escritorio");

        String[] listado1 = docs.list();
        String[] listado2 = dow.list();
        String[] listado3 = esc.list();
        
        if(archivo.buscarArchivo(docs,matricula)==true){
            promedio=leerPromedioA(docs,matricula);

        } else if (archivo.buscarArchivo(dow,matricula)==true) {
            promedio=leerPromedioA(dow,matricula);

        } else if (archivo.buscarArchivo(esc,matricula)==true) {
            promedio=leerPromedioA(esc,matricula);

        }else {
            System.out.println("No encontrado");
        }
        return promedio;

    }

    static double leerPromedioA(File file, String doc){

        String []listado=file.list();
        double prom=0,promedio=0;
        double cal=0;
        String buscado=doc+".txt";
        System.out.println(file+"\\"+buscado);
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(file+"\\"+buscado));

            String linea = inputStream.readLine();
            while (linea!= null){
                promedio= promedio+Double.parseDouble(linea);
                linea = inputStream.readLine();
            }

            inputStream.close();
            promedio = promedio / 3;
            return promedio;
        } catch (FileNotFoundException e) {
            System.out.println("Problema al abrir el archivo.");
        } catch (Exception e) {
            System.out.println("Error de lectura ");
        }



        return prom;
    }

    public void registarPromedio(String ruta,double promedio){
        PrintWriter outputStream = null;
        final int EXCEPTION_CODE_STATUS = 0;
        try {
            outputStream = new PrintWriter(new FileOutputStream(ruta));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Escribiendo en archivo.......");
        outputStream.println(promedio);
        outputStream.close();
    }

    public double calcularPromedioG(String grupo){
        double promedio=0;
        Archivo archivo=new Archivo();
        boolean estado=false;
        File docs = new File("C:\\Users\\albaa\\OneDrive\\Documents");
        File dow = new File("C:\\Users\\albaa\\OneDrive\\Downloads");
        File esc = new File("C:\\Users\\albaa\\OneDrive\\Escritorio");

        String[] listado1 = docs.list();
        String[] listado2 = dow.list();
        String[] listado3 = esc.list();

        if(archivo.buscarArchivo(docs,grupo)==true){
            promedio=leerPromedioG(docs,grupo);

        } else if (archivo.buscarArchivo(dow,grupo)==true) {
            promedio=leerPromedioG(dow,grupo);

        } else if (archivo.buscarArchivo(esc,grupo)==true) {
            promedio=leerPromedioG(esc,grupo);

        }else {
            System.out.println("No encontrado");
        }
        return promedio;

    }

    static double leerPromedioG(File file, String doc){

        double prom=0,promedio=0;
        double cal=0;
        int contador=1,contador2=1;
        String buscado=doc+".txt";
        System.out.println(file+"\\"+buscado);
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader(file+"\\"+buscado));

            String linea = inputStream.readLine();
            while (linea!= null){

                if(contador==1){
                    contador++;
                }else if(contador>1){
                        promedio= promedio+Double.parseDouble(linea);
                        linea = inputStream.readLine();
                        contador++;
                        if(contador==4){
                            contador=1;
                        }

                } else if (contador>4) {
                    contador=1;
                }

            }

            inputStream.close();
            promedio = promedio / 3;
            return promedio;
        } catch (FileNotFoundException e) {
            System.out.println("Problema al abrir el archivo.");
        } catch (Exception e) {
            System.out.println("Error de lectura ");
        }



        return prom;
    }

}
