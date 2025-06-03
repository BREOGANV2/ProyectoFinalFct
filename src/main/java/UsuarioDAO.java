import java.sql.*;
import java.time.LocalDate;
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
}
