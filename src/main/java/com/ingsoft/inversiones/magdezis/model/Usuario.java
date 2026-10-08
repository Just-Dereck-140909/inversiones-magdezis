package main.java.com.ingsoft.inversiones.magdezis.model;
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenaHash;
    private int idRol;
    private String nombreRol;

    public Usuario() {
    }

    public Usuario(
            int idUsuario,
            String nombre,
            String apellido,
            String correo,
            String contrasenaHash,
            int idRol,
            String nombreRol) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenaHash = contrasenaHash;
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}