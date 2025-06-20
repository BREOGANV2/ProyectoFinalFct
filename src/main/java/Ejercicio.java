public class Ejercicio {
    private Integer idEjercicio;            // Puede ser null si aún no está insertado
    private String nombre;
    private String grupoMuscular;
    private String descripcion;             // Opcional
    private String urlImagen;               // Opcional
    private String nombreImagen;            // NUEVO campo

    // Constructor vacío
    public Ejercicio() {
    }

    // Constructor sin ID (para crear nuevos ejercicios)
    public Ejercicio(String nombre, String grupoMuscular, String descripcion, String urlImagen, String nombreImagen) {
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.nombreImagen = nombreImagen;
    }

    // Constructor completo (con ID, por ejemplo, al leer desde la BD)
    public Ejercicio(Integer idEjercicio, String nombre, String grupoMuscular, String descripcion, String urlImagen, String nombreImagen) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.grupoMuscular = grupoMuscular;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.nombreImagen = nombreImagen;
    }

    // Getters y Setters
    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
