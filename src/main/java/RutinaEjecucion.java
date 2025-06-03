

import java.time.LocalDateTime;

public class RutinaEjecucion {
    private Integer idEjecucion;           // PK autoincremental
    private Integer idRutina;              // FK a Rutina
    private LocalDateTime fechaEjecucion;
    private Integer duracionMinutos;       // Opcional
    private String notas;                  // Opcional

    // Constructor vacío
    public RutinaEjecucion() {
    }

    // Constructor sin ID (para insertar)
    public RutinaEjecucion(Integer idRutina, LocalDateTime fechaEjecucion, Integer duracionMinutos, String notas) {
        this.idRutina = idRutina;
        this.fechaEjecucion = fechaEjecucion;
        this.duracionMinutos = duracionMinutos;
        this.notas = notas;
    }

    // Constructor completo
    public RutinaEjecucion(Integer idEjecucion, Integer idRutina, LocalDateTime fechaEjecucion, Integer duracionMinutos, String notas) {
        this.idEjecucion = idEjecucion;
        this.idRutina = idRutina;
        this.fechaEjecucion = fechaEjecucion;
        this.duracionMinutos = duracionMinutos;
        this.notas = notas;
    }

    // Getters y Setters
    public Integer getIdEjecucion() {
        return idEjecucion;
    }

    public void setIdEjecucion(Integer idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public LocalDateTime getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(LocalDateTime fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
}
