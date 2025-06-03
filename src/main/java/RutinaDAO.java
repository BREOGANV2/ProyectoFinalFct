import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RutinaDAO {
    private static RutinaDAO instance;
    private final Connection connection;

    private RutinaDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    public static RutinaDAO getInstance() {
        if (instance == null) {
            instance = new RutinaDAO();
        }
        return instance;
    }

    public void insert(Rutina rutina) throws SQLException {
        String sql = "INSERT INTO Rutinas (id_usuario, nombre, descripcion, objetivo, fecha_creacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rutina.getIdUsuario());
            stmt.setString(2, rutina.getNombre());
            stmt.setString(3, rutina.getDescripcion());
            stmt.setString(4, rutina.getObjetivo());
            stmt.setDate(5, Date.valueOf(rutina.getFechaCreacion()));
            stmt.executeUpdate();
        }
    }

    public void update(Rutina rutina) throws SQLException {
        String sql = "UPDATE Rutinas SET id_usuario=?, nombre=?, descripcion=?, objetivo=?, fecha_creacion=? WHERE id_rutina=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rutina.getIdUsuario());
            stmt.setString(2, rutina.getNombre());
            stmt.setString(3, rutina.getDescripcion());
            stmt.setString(4, rutina.getObjetivo());
            stmt.setDate(5, Date.valueOf(rutina.getFechaCreacion()));
            stmt.setInt(6, rutina.getIdRutina());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Rutinas WHERE id_rutina=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Rutina> selectAll() throws SQLException {
        List<Rutina> list = new ArrayList<>();
        String sql = "SELECT * FROM Rutinas";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Rutina rutina = new Rutina();
                rutina.setIdRutina(rs.getInt("id_rutina"));
                rutina.setIdUsuario(rs.getInt("id_usuario"));
                rutina.setNombre(rs.getString("nombre"));
                rutina.setDescripcion(rs.getString("descripcion"));
                rutina.setObjetivo(rs.getString("objetivo"));
                rutina.setFechaCreacion(rs.getDate("fecha_creacion").toLocalDate());
                list.add(rutina);
            }
        }
        return list;
    }
}
