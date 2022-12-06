package Archivos;

import operaciones.OperacionesAlumno;

import java.io.File;
import java.util.Scanner;

public class Archivo {


    public String guardarArchivoRuta(String identificador){
        String ruta;
        String rut=null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Selecciona la ruta para guardar el documento: ");
        System.out.println("1-Documentos");
        System.out.println("2-Escritorio");
        System.out.println("2-Descargas");
        int r=scanner.nextInt();

        if(r==1) {
            ruta = "Documents";
            rut =crearDocEnRuta(ruta,identificador);
        } else if (r==2) {
            ruta="Escritorio";
            rut =crearDocEnRuta(ruta,identificador);
        }else if (r==3){
            ruta="Downloads";
            rut =crearDocEnRuta(ruta,identificador);
        }
        return rut;
    }
    public String crearDocEnRuta(String ruta, String nombreDoc){
        String rutainicial="C:\\Users\\albaa\\OneDrive\\";
        rutainicial=rutainicial+ruta+"\\"+nombreDoc+".txt";
        System.out.println(rutainicial);
        return rutainicial;
    }

    public boolean buscarArchivo(File file, String identificador){
        String[] listado= file.list();
        boolean estado=false;
        String archivo=identificador+".txt";
        for (int i=0; i< listado.length; i++) {
            if(listado[i].equals(archivo)){

                System.out.println(file.getAbsolutePath());
                return estado=true;
            }

        }
        return estado;
    }

    public double calcularPromedioA(String matricula){
        OperacionesAlumno oa=new OperacionesAlumno();
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
            promedio=oa.consultarPromedioFinal(docs+"\\"+matricula+".txt");

        } else if (archivo.buscarArchivo(dow,matricula)==true) {
            promedio=oa.consultarPromedioFinal(dow+"\\"+matricula+".txt");

        } else if (archivo.buscarArchivo(esc,matricula)==true) {
            promedio=oa.consultarPromedioFinal(esc+"\\"+matricula+".txt");

        }else {
            System.out.println("No encontrado");
        }
        return promedio;

    }
    public String rutaCal(String matricula){
        OperacionesAlumno oa=new OperacionesAlumno();
        double promedio=0;
        Archivo archivo=new Archivo();
        boolean estado=false;
        File docs = new File("C:\\Users\\albaa\\OneDrive\\Documents");
        File dow = new File("C:\\Users\\albaa\\OneDrive\\Downloads");
        File esc = new File("C:\\Users\\albaa\\OneDrive\\Escritorio");

        String[] listado1 = docs.list();
        String[] listado2 = dow.list();
        String[] listado3 = esc.list();

        String ruta;

        if(archivo.buscarArchivo(docs,matricula)==true){
           return ruta=docs+matricula+"\\"+".txt";

        } else if (archivo.buscarArchivo(dow,matricula)==true) {
            return ruta=dow+matricula+"\\"+".txt";

        } else if (archivo.buscarArchivo(esc,matricula)==true) {
            return ruta=esc+matricula+"\\"+".txt";

        }else {
            System.out.println("No encontrado");
        }
        return ruta=null;

    }

    public String buscarArchivoA(String identificador){
        File docs = new File("C:\\Users\\albaa\\OneDrive\\Documents");
        File dow = new File("C:\\Users\\albaa\\OneDrive\\Downloads");
        File esc = new File("C:\\Users\\albaa\\OneDrive\\Escritorio");
        String[] listado;
        String ruta=null;
        String archivo=identificador+".txt";
        boolean estado=false;
        listado= dow.list();
        for (int i=0; i< listado.length; i++) {
            if(listado[i].equals(archivo)){
                ruta=dow.getAbsolutePath()+"\\"+archivo;
                return ruta;
            }

        }

        listado= docs.list();

        for (int i=0; i< listado.length; i++) {
            if(listado[i].equals(archivo)){
                ruta=docs.getAbsolutePath()+"\\"+archivo;
                return ruta;
            }

        }

        listado= esc.list();
        for (int i=0; i< listado.length; i++) {
            if(listado[i].equals(archivo)){
                ruta=esc.getAbsolutePath()+"\\"+archivo;
                return ruta;
            }

        }
        return ruta;
    }

    public void leerArchivo(){

    }
}
