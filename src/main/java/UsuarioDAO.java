
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static UsuarioDAO instance;
    private final Connection connection;

    private UsuarioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    public void insert(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (nombre, edad, genero, fecha_registro, contraseña) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getGenero());
            stmt.setDate(4, Date.valueOf(usuario.getFechaRegistro()));
            stmt.setString(5, usuario.getContraseña());
            stmt.executeUpdate();
        }
    }

    public void update(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET nombre=?, edad=?, genero=?, fecha_registro=?, contraseña=? WHERE id_usuario=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getGenero());
            stmt.setDate(4, Date.valueOf(usuario.getFechaRegistro()));
            stmt.setString(5, usuario.getContraseña());
            stmt.setInt(6, usuario.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id_usuario=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // NUEVO: Eliminación completa en cascada con transacción
    public void deleteCascade(int idUsuario) throws SQLException {
        Connection conn = DatabaseManager.getInstance().getConnection();
        try {
            conn.setAutoCommit(false);

            // Obtener rutinas del usuario
            List<Integer> idRutinas = new ArrayList<>();
            String sqlRutinas = "SELECT id_rutina FROM Rutinas WHERE id_usuario = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sqlRutinas)) {
                stmt.setInt(1, idUsuario);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        idRutinas.add(rs.getInt("id_rutina"));
                    }
                }
            }

            // Eliminar ejecuciones, ejercicios y rutinas
            for (int idRutina : idRutinas) {
                try (PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Rutina_Ejecuciones WHERE id_rutina=?");
                     PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Rutina_Ejercicios WHERE id_rutina=?");
                     PreparedStatement stmt3 = conn.prepareStatement("DELETE FROM Rutinas WHERE id_rutina=?")) {

                    stmt1.setInt(1, idRutina);
                    stmt1.executeUpdate();

                    stmt2.setInt(1, idRutina);
                    stmt2.executeUpdate();

                    stmt3.setInt(1, idRutina);
                    stmt3.executeUpdate();
                }
            }

            // Eliminar usuario
            try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM Usuarios WHERE id_usuario=?")) {
                stmt.setInt(1, idUsuario);
                stmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public List<Usuario> selectAll() throws SQLException {
        List<Usuario> list = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEdad(rs.getInt("edad"));
                u.setGenero(rs.getString("genero"));
                u.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
                u.setContraseña(rs.getString("contraseña"));
                list.add(u);
            }
        }
        return list;
    }
    
    public Usuario selectById(int id) throws SQLException {
    String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEdad(rs.getInt("edad"));
                u.setGenero(rs.getString("genero"));
                u.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
                u.setContraseña(rs.getString("contraseña"));
                return u;
            } else {
                return null;
            }
        }
    }
}

}
