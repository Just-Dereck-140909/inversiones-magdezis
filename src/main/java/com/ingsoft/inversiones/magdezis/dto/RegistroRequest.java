
package main.java.com.ingsoft.inversiones.magdezis.dto;


public class RegistroRequest {

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public RegistroRequest(
            String nombre,
            String apellido,
            String correo,
            String contrasena) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
