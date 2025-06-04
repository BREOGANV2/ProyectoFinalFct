
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

    public int insertAndReturnId(Rutina rutina) throws SQLException {
        String sql = "INSERT INTO Rutinas (id_usuario, nombre, descripcion, objetivo, fecha_creacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, rutina.getIdUsuario());
            stmt.setString(2, rutina.getNombre());
            stmt.setString(3, rutina.getDescripcion());
            stmt.setString(4, rutina.getObjetivo());
            stmt.setDate(5, Date.valueOf(rutina.getFechaCreacion()));
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID generado de la rutina.");
                }
            }
        }
    }

    public Rutina selectById(int id) throws SQLException {
        String sql = "SELECT * FROM Rutinas WHERE id_rutina = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Rutina(
                            rs.getInt("id_rutina"),
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("objetivo"),
                            rs.getDate("fecha_creacion").toLocalDate()
                    );
                } else {
                    return null;
                }
            }
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

    // NUEVO: Eliminación completa en cascada con transacción
    public void deleteCascade(int idRutina) throws SQLException {
        Connection conn = DatabaseManager.getInstance().getConnection();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Rutina_Ejecuciones WHERE id_rutina=?"); PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Rutina_Ejercicios WHERE id_rutina=?"); PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM Rutinas WHERE id_rutina=?")) {

                stmt1.setInt(1, idRutina);
                stmt1.executeUpdate();

                stmt2.setInt(1, idRutina);
                stmt2.executeUpdate();

                stmt3.setInt(1, idRutina);
                stmt3.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public List<Rutina> selectAll() throws SQLException {
        List<Rutina> list = new ArrayList<>();
        String sql = "SELECT * FROM Rutinas";
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
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
