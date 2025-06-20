/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.io.File;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;

/**
 *
 * @author HREF DIGITAL
 */
public class ModificarEjercicio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ModificarEjercicio.class.getName());

    /**
     * Creates new form ModificarEjercicio
     */
    public ModificarEjercicio() {

        initComponents();
        comboGrupoMuscular.addItem("Pecho");
comboGrupoMuscular.addItem("Espalda");
comboGrupoMuscular.addItem("Piernas");
comboGrupoMuscular.addItem("Hombros");
comboGrupoMuscular.addItem("Bíceps");
comboGrupoMuscular.addItem("Tríceps");
comboGrupoMuscular.addItem("Abdomen");
comboGrupoMuscular.addItem("Glúteos");
comboGrupoMuscular.setSelectedIndex(1);
        modeloTabla = table.getModel();
        try {
            cargarTabla();
        } catch (SQLException ex) {
            System.getLogger(ModificarEjercicio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void cargarTabla() throws SQLException {
        EjercicioDAO dao = EjercicioDAO.getInstance();
        java.util.List<Ejercicio> ejercicios = dao.selectAll();

        // Columnas completas
        String[] columnas = {"ID", "Nombre", "Descripción", "Grupo Muscular", "URL Imagen","Nombre de la imagen"};
        Object[][] datos = new Object[ejercicios.size()][5];

        for (int i = 0; i < ejercicios.size(); i++) {
            Ejercicio e = ejercicios.get(i);
            datos[i][0] = e.getIdEjercicio();
            datos[i][1] = e.getNombre();
            datos[i][2] = e.getDescripcion();
            datos[i][3] = e.getGrupoMuscular();
            datos[i][4] = e.getUrlImagen();
        }

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Para que no se puedan editar las celdas directamente
            }
        };

        table.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        file_button = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nombreImagenTxT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        comboGrupoMuscular = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar un Ejercicio");
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Ejercicio"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Grupo", "Url_imagen"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        jPanel1.add(jTextField1, gridBagConstraints);

        jLabel2.setText("Descripción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel2, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jLabel3.setText("url_imagen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel3, gridBagConstraints);

        file_button.setText("Seleccionar");
        file_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_buttonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        jPanel1.add(file_button, gridBagConstraints);

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jButton2, gridBagConstraints);

        jLabel4.setText("Nombre de la Imagen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(nombreImagenTxT, gridBagConstraints);

        jLabel5.setText("grupo muscular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel5, gridBagConstraints);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.25;
        jPanel1.add(comboGrupoMuscular, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_buttonActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            rutaArchivoSeleccionado = selectedFile.getAbsolutePath();  // guarda la ruta globalmente

            System.out.println("Ruta seleccionada: " + rutaArchivoSeleccionado);
        }
    }//GEN-LAST:event_file_buttonActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int fila = table.getSelectedRow();
        if (fila >= 0) {
            jTextField1.setText(table.getValueAt(fila, 1).toString());  // Nombre
            jTextArea1.setText(table.getValueAt(fila, 2).toString());   // Descripción
            comboGrupoMuscular.setSelectedItem(table.getValueAt(fila, 3).toString());
            nombreImagenTxT.setText(table.getValueAt(fila, 5).toString());

        }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = table.getSelectedRow();
    if (fila >= 0) {
        try {
            int id = Integer.parseInt(table.getValueAt(fila, 0).toString());
            String nuevoNombre = jTextField1.getText().trim();
            String nuevaDescripcion = jTextArea1.getText().trim();
            String nuevaUrlImagen = rutaArchivoSeleccionado;
            String nuevoGrupoMuscular = (String) comboGrupoMuscular.getSelectedItem();
            String nuevoNombreImagen = nombreImagenTxT.getText().trim();

            if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || nuevoNombreImagen.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                return;
            }
            if (nuevoGrupoMuscular == null || nuevoGrupoMuscular.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un grupo muscular válido.");
    return;
}


            EjercicioDAO dao = EjercicioDAO.getInstance();
            Ejercicio anterior = dao.selectById(id);
            if (anterior == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el ejercicio en la base de datos.");
                return;
            }

            Ejercicio ejercicioActualizado = new Ejercicio(
                id,
                nuevoNombre,
                nuevoGrupoMuscular,
                nuevaDescripcion,
                nuevaUrlImagen != null ? nuevaUrlImagen : anterior.getUrlImagen(),
                nuevoNombreImagen
            );

            dao.update(ejercicioActualizado);
            cargarTabla();

            javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio actualizado correctamente.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage());
            ex.printStackTrace();
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         int fila = table.getSelectedRow();
    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un ejercicio para eliminar", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int idEjercicio = Integer.parseInt(table.getValueAt(fila, 0).toString());

    Ejercicio ejercicio;
    try {
        ejercicio = EjercicioDAO.getInstance().selectById(idEjercicio);
        if (ejercicio == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio no encontrado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al obtener datos del ejercicio", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "¿Seguro que deseas eliminar el ejercicio '" + ejercicio.getNombre() + "'?",
        "Confirmación",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    java.sql.Connection conn = null;

    try {
        conn = DatabaseManager.getInstance().getConnection();
        conn.setAutoCommit(false);  // Iniciar transacción

        // 1. Eliminar de Rutina_Ejercicios
        try (java.sql.PreparedStatement stmt1 = conn.prepareStatement(
                "DELETE FROM Rutina_Ejercicios WHERE id_ejercicio = ?")) {
            stmt1.setInt(1, ejercicio.getIdEjercicio());
            stmt1.executeUpdate();
        }

        // 2. Eliminar de Ejercicios
        try (java.sql.PreparedStatement stmt2 = conn.prepareStatement(
                "DELETE FROM Ejercicios WHERE id_ejercicio = ?")) {
            stmt2.setInt(1, ejercicio.getIdEjercicio());
            stmt2.executeUpdate();
        }

        conn.commit();
        javax.swing.JOptionPane.showMessageDialog(this, "Ejercicio eliminado correctamente.");
        cargarTabla();  // refrescar la tabla

    } catch (java.sql.SQLException ex) {
        ex.printStackTrace();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (java.sql.SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar ejercicio", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ModificarEjercicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboGrupoMuscular;
    private javax.swing.JButton file_button;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nombreImagenTxT;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private String rutaArchivoSeleccionado;
    private TableModel modeloTabla;
}
