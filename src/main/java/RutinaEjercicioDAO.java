
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutinaEjercicioDAO {
    private static RutinaEjercicioDAO instance;
    private final Connection connection;

    private RutinaEjercicioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }

    public static RutinaEjercicioDAO getInstance() {
        if (instance == null) {
            instance = new RutinaEjercicioDAO();
        }
        return instance;
    }

    public void insert(RutinaEjercicio re) throws SQLException {
        String sql = "INSERT INTO Rutina_Ejercicios (id_rutina, id_ejercicio, orden, series, repeticiones) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, re.getIdRutina());
            stmt.setInt(2, re.getIdEjercicio());
            stmt.setInt(3, re.getOrden());
            stmt.setInt(4, re.getSeries());
            stmt.setString(5, re.getRepeticiones());
            stmt.executeUpdate();
        }
    }

    public void update(RutinaEjercicio re) throws SQLException {
        String sql = "UPDATE Rutina_Ejercicios SET id_rutina=?, id_ejercicio=?, orden=?, series=?, repeticiones=? WHERE id_rutina_ejercicio=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, re.getIdRutina());
            stmt.setInt(2, re.getIdEjercicio());
            stmt.setInt(3, re.getOrden());
            stmt.setInt(4, re.getSeries());
            stmt.setString(5, re.getRepeticiones());
            stmt.setInt(6, re.getIdRutinaEjercicio()); // Solo si el ID ya existe
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Rutina_Ejercicios WHERE id_rutina_ejercicio=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<RutinaEjercicio> selectAll() throws SQLException {
        List<RutinaEjercicio> list = new ArrayList<>();
        String sql = "SELECT * FROM Rutina_Ejercicios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RutinaEjercicio re = new RutinaEjercicio();
                re.setIdRutinaEjercicio(rs.getInt("id_rutina_ejercicio"));
                re.setIdRutina(rs.getInt("id_rutina"));
                re.setIdEjercicio(rs.getInt("id_ejercicio"));
                re.setOrden(rs.getInt("orden"));
                re.setSeries(rs.getInt("series"));
                re.setRepeticiones(rs.getString("repeticiones"));
                list.add(re);
            }
        }
        return list;
    }

   public void deleteByRutina(int idRutina) throws SQLException {
    String sql = "DELETE FROM Rutina_Ejercicios WHERE id_rutina = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idRutina);
        stmt.executeUpdate();
    }
}
   
   public List<RutinaEjercicio> selectByRutina(int idRutina) throws SQLException {
    List<RutinaEjercicio> lista = new ArrayList<>();

    String sql = "SELECT * FROM Rutina_Ejercicios WHERE id_rutina = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idRutina);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RutinaEjercicio re = new RutinaEjercicio(
                    rs.getInt("id_rutina"),
                    rs.getInt("id_ejercicio"),
                    rs.getInt("orden"),
                    rs.getInt("series"),
                    rs.getString("repeticiones")
                );
                lista.add(re);
            }
        }
    }

    return lista;
}

}
