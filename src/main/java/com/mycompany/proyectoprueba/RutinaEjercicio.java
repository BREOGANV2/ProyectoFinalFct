package com.mycompany.proyectoprueba;

public class RutinaEjercicio {
    private Integer idRutinaEjercicio;   // PK autoincremental
    private Integer idRutina;            // FK a Rutina
    private Integer idEjercicio;         // FK a Ejercicio
    private int orden;
    private int series;
    private String repeticiones;

    // Constructor vacío
    public RutinaEjercicio() {
    }

    // Constructor sin ID (para insertar)
    public RutinaEjercicio(Integer idRutina, Integer idEjercicio, int orden, int series, String repeticiones) {
        this.idRutina = idRutina;
        this.idEjercicio = idEjercicio;
        this.orden = orden;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Constructor completo
    public RutinaEjercicio(Integer idRutinaEjercicio, Integer idRutina, Integer idEjercicio, int orden, int series, String repeticiones) {
        this.idRutinaEjercicio = idRutinaEjercicio;
        this.idRutina = idRutina;
        this.idEjercicio = idEjercicio;
        this.orden = orden;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Getters y Setters
    public Integer getIdRutinaEjercicio() {
        return idRutinaEjercicio;
    }

    public void setIdRutinaEjercicio(Integer idRutinaEjercicio) {
        this.idRutinaEjercicio = idRutinaEjercicio;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }
}
