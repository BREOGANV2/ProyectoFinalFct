import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDAO {
    private static EjercicioDAO instance;
    private final Connection connection;

    private EjercicioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    public static EjercicioDAO getInstance() {
        if (instance == null) {
            instance = new EjercicioDAO();
        }
        return instance;
    }

    public void insert(Ejercicio ejercicio) throws SQLException {
        String sql = "INSERT INTO Ejercicios (nombre, grupo_muscular, descripcion, url_imagen) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ejercicio.getNombre());
            stmt.setString(2, ejercicio.getGrupoMuscular());
            stmt.setString(3, ejercicio.getDescripcion());
            stmt.setString(4, ejercicio.getUrlImagen());
            stmt.executeUpdate();
        }
    }

    public void update(Ejercicio ejercicio) throws SQLException {
        String sql = "UPDATE Ejercicios SET nombre=?, grupo_muscular=?, descripcion=?, url_imagen=? WHERE id_ejercicio=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ejercicio.getNombre());
            stmt.setString(2, ejercicio.getGrupoMuscular());
            stmt.setString(3, ejercicio.getDescripcion());
            stmt.setString(4, ejercicio.getUrlImagen());
            stmt.setInt(5, ejercicio.getIdEjercicio());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Ejercicios WHERE id_ejercicio=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Ejercicio> selectAll() throws SQLException {
        List<Ejercicio> list = new ArrayList<>();
        String sql = "SELECT * FROM Ejercicios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ejercicio ejercicio = new Ejercicio();
                ejercicio.setIdEjercicio(rs.getInt("id_ejercicio"));
                ejercicio.setNombre(rs.getString("nombre"));
                ejercicio.setGrupoMuscular(rs.getString("grupo_muscular"));
                ejercicio.setDescripcion(rs.getString("descripcion"));
                ejercicio.setUrlImagen(rs.getString("url_imagen"));
                list.add(ejercicio);
            }
        }
        return list;
    }
}
