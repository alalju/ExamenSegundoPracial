package operaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OperacionesAlumno {
    public void consultarParcial( String matricula) {
        int cont=1;
        try{
            File file = new File(matricula);
            Scanner inputFile = new Scanner(file);
            // Leemos las lineas del archivo hasta que exista más que leer.
            while (inputFile.hasNext()) {
                System.out.println("Calificación Parcial "+ cont);
                String cal = inputFile.nextLine();
                System.out.println(cal);
                cont++;
            }
            inputFile.close();

        } catch (FileNotFoundException e) {
           System.out.println("Error");
        }


    }
    public void consultarPromedioF( String matricula) {
        int cont=0;
        int calificacion;
        try{
            File file = new File(matricula);
            Scanner inputFile = new Scanner(file);
            // Leemos las lineas del archivo hasta que exista más que leer.
            while (inputFile.hasNext()) {

                String cal = inputFile.nextLine();
                calificacion= Integer.parseInt(cal);
                System.out.println(cal);
                cont=cont+calificacion;
            }
            calificacion=cont/3;
            System.out.println("Tu promedio final es:" + calificacion);
            inputFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }


    }
    public double consultarPromedioFinal( String matricula) {
        double cont=0;
        double calificacion=0;
        try{
            File file = new File(matricula);
            Scanner inputFile = new Scanner(file);
            // Leemos las lineas del archivo hasta que exista más que leer.
            while (inputFile.hasNext()) {

                String cal = inputFile.nextLine();
                calificacion= Integer.parseInt(cal);
                cont=cont+calificacion;
            }

            inputFile.close();
            return calificacion=cont/3;

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return calificacion;

    }


}
