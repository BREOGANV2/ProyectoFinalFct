import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RutinaEjecucionDAO {
    private static RutinaEjecucionDAO instance;
    private final Connection connection;

    private RutinaEjecucionDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    public static RutinaEjecucionDAO getInstance() {
        if (instance == null) {
            instance = new RutinaEjecucionDAO();
        }
        return instance;
    }

    public void insert(RutinaEjecucion re) throws SQLException {
        String sql = "INSERT INTO Rutina_Ejecuciones (id_rutina, fecha_ejecucion, duracion_minutos, notas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, re.getIdRutina());
            stmt.setTimestamp(2, Timestamp.valueOf(re.getFechaEjecucion()));
            if (re.getDuracionMinutos() != null) {
                stmt.setInt(3, re.getDuracionMinutos());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.setString(4, re.getNotas());
            stmt.executeUpdate();
        }
    }

    public void update(RutinaEjecucion re) throws SQLException {
        String sql = "UPDATE Rutina_Ejecuciones SET id_rutina=?, fecha_ejecucion=?, duracion_minutos=?, notas=? WHERE id_ejecucion=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, re.getIdRutina());
            stmt.setTimestamp(2, Timestamp.valueOf(re.getFechaEjecucion()));
            if (re.getDuracionMinutos() != null) {
                stmt.setInt(3, re.getDuracionMinutos());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.setString(4, re.getNotas());
            stmt.setInt(5, re.getIdEjecucion());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Rutina_Ejecuciones WHERE id_ejecucion=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<RutinaEjecucion> selectAll() throws SQLException {
        List<RutinaEjecucion> list = new ArrayList<>();
        String sql = "SELECT * FROM Rutina_Ejecuciones";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RutinaEjecucion re = new RutinaEjecucion();
                re.setIdEjecucion(rs.getInt("id_ejecucion"));
                re.setIdRutina(rs.getInt("id_rutina"));
                re.setFechaEjecucion(rs.getTimestamp("fecha_ejecucion").toLocalDateTime());
                int duracion = rs.getInt("duracion_minutos");
                if (!rs.wasNull()) {
                    re.setDuracionMinutos(duracion);
                }
                re.setNotas(rs.getString("notas"));
                list.add(re);
            }
        }
        return list;
    }
}
