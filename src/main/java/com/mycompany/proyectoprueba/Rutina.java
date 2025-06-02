package com.mycompany.proyectoprueba;

import java.time.LocalDate;

public class Rutina {
    private Integer idRutina;         // Autoincremental, puede ser null al crear
    private Integer idUsuario;        // FK → Usuarios.id_usuario
    private String nombre;
    private String descripcion;       // Opcional
    private String objetivo;          // Opcional
    private LocalDate fechaCreacion;

    // Constructor vacío
    public Rutina() {
    }

    // Constructor sin ID (para insertar)
    public Rutina(Integer idUsuario, String nombre, String descripcion, String objetivo, LocalDate fechaCreacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.fechaCreacion = fechaCreacion;
    }

    // Constructor completo (con ID, por ejemplo al leer de BD)
    public Rutina(Integer idRutina, Integer idUsuario, String nombre, String descripcion, String objetivo, LocalDate fechaCreacion) {
        this.idRutina = idRutina;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters
    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
