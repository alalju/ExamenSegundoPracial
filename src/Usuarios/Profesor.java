package Usuarios;

public class Profesor extends Usuario {
    public String clave;

    public Profesor(String nombre, String apellido, String telefono, String correo, String clave) {
        super(nombre, apellido, telefono, correo);
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
