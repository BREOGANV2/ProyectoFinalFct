
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GymTrackerApp extends JFrame {
    public GymTrackerApp() {
        setTitle("GymTracker - Panel Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        String[] panels = {"Usuarios", "Ejercicios", "Rutinas", "RutinaEjercicios", "RutinaEjecuciones"};

        for (int i = 0; i < panels.length; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createTitledBorder(panels[i]));
            panel.setLayout(new GridLayout(2, 2, 5, 5));

            JButton btnCreate = new JButton("Crear");
            JButton btnRead = new JButton("Consultar");
            JButton btnUpdate = new JButton("Modificar");
            JButton btnDelete = new JButton("Eliminar");

            String entity = panels[i];
            btnCreate.addActionListener(e -> abrirVentana(entity, "create"));
            btnRead.addActionListener(e -> abrirVentana(entity, "read"));
            btnUpdate.addActionListener(e -> abrirVentana(entity, "update"));
            btnDelete.addActionListener(e -> abrirVentana(entity, "delete"));

            panel.add(btnCreate);
            panel.add(btnRead);
            panel.add(btnUpdate);
            panel.add(btnDelete);

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            add(panel, gbc);
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirVentana(String entidad, String accion) {
        JOptionPane.showMessageDialog(this, "Abrir " + accion + " para " + entidad);
        // Aquí se llamaría a la clase correspondiente
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GymTrackerApp::new);
    }
}
