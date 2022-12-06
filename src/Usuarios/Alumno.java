package Usuarios;

public class Alumno extends Usuario {
    public String matricula;
    public String grupo;


    public Alumno(String nombre, String apellido, String telefono, String correo){
        super(nombre, apellido, telefono, correo);
    }
    public Alumno(String nombre, String apellido, String telefono, String correo, String matricula) {
        super(nombre, apellido, telefono, correo);
        this.matricula = matricula;
    }

    public Alumno(String nombre, String apellido, String telefono, String correo, String matricula, String grupo) {
        super(nombre, apellido, telefono, correo);
        this.matricula = matricula;
        this.grupo = grupo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
