

import java.time.LocalDate;

public class Usuario {
    private Integer idUsuario;  // Puede ser null
    private String nombre;
    private int edad;
    private String genero;
    private LocalDate fechaRegistro;
    private String contraseña;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor sin ID (para crear nuevos usuarios)
    public Usuario(String nombre, int edad, String genero, LocalDate fechaRegistro, String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        this.contraseña = contraseña;
    }

    // Constructor completo (por si ya tienes el ID desde la BD)
    public Usuario(Integer idUsuario, String nombre, int edad, String genero, LocalDate fechaRegistro, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.fechaRegistro = fechaRegistro;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
