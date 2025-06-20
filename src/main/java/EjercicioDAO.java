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
        String sql = "INSERT INTO Ejercicios (nombre, grupo_muscular, descripcion, url_imagen, nombre_imagen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ejercicio.getNombre());
            stmt.setString(2, ejercicio.getGrupoMuscular());
            stmt.setString(3, ejercicio.getDescripcion());
            stmt.setString(4, ejercicio.getUrlImagen());
            stmt.setString(5, ejercicio.getNombreImagen());
            stmt.executeUpdate();
        }
    }

    public void update(Ejercicio ejercicio) throws SQLException {
        String sql = "UPDATE Ejercicios SET nombre=?, grupo_muscular=?, descripcion=?, url_imagen=?, nombre_imagen=? WHERE id_ejercicio=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ejercicio.getNombre());
            stmt.setString(2, ejercicio.getGrupoMuscular());
            stmt.setString(3, ejercicio.getDescripcion());
            stmt.setString(4, ejercicio.getUrlImagen());
            stmt.setString(5, ejercicio.getNombreImagen());
            stmt.setInt(6, ejercicio.getIdEjercicio());
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

    // Elimina en cascada desde Rutina_Ejercicios
    public void deleteCascade(int idEjercicio) throws SQLException {
        Connection conn = DatabaseManager.getInstance().getConnection();
        try {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Rutina_Ejercicios WHERE id_ejercicio=?");
                 PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Ejercicios WHERE id_ejercicio=?")) {

                stmt1.setInt(1, idEjercicio);
                stmt1.executeUpdate();

                stmt2.setInt(1, idEjercicio);
                stmt2.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public List<Ejercicio> selectAll() throws SQLException {
        List<Ejercicio> list = new ArrayList<>();
        String sql = "SELECT * FROM Ejercicios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ejercicio e = new Ejercicio(
                    rs.getInt("id_ejercicio"),
                    rs.getString("nombre"),
                    rs.getString("grupo_muscular"),
                    rs.getString("descripcion"),
                    rs.getString("url_imagen"),
                    rs.getString("nombre_imagen")
                );
                list.add(e);
            }
        }
        return list;
    }

    public Ejercicio selectById(int id) throws SQLException {
        String sql = "SELECT * FROM Ejercicios WHERE id_ejercicio = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ejercicio(
                        rs.getInt("id_ejercicio"),
                        rs.getString("nombre"),
                        rs.getString("grupo_muscular"),
                        rs.getString("descripcion"),
                        rs.getString("url_imagen"),
                        rs.getString("nombre_imagen")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
