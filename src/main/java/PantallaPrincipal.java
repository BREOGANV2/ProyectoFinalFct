
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author HREF DIGITAL
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnModificarUsuario = new javax.swing.JMenuItem();
        btnModificarEjercicio = new javax.swing.JMenuItem();
        btnModificarRutina = new javax.swing.JMenuItem();
        btnModificarEntrenamiento = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnEliminarUsuario = new javax.swing.JMenuItem();
        btnEliminarEjercicio = new javax.swing.JMenuItem();
        btnEliminarRutina = new javax.swing.JMenuItem();
        btnEliminarEntrenamiento = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        btnVerUsuarios = new javax.swing.JMenuItem();
        btnVerEjercicios = new javax.swing.JMenuItem();
        btnVerRutina = new javax.swing.JMenuItem();
        btnVerEntrenamiento = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GymTracker");
        setMinimumSize(new java.awt.Dimension(500, 250));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jMenu1.setText("Help");

        jMenuItem1.setText("Ayuda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Añadir");

        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Ejercicios");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Rutinas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Entrenamientos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Modificar");

        btnModificarUsuario.setText("Usuario");
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(btnModificarUsuario);

        btnModificarEjercicio.setText("Ejercicio");
        btnModificarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEjercicioActionPerformed(evt);
            }
        });
        jMenu3.add(btnModificarEjercicio);

        btnModificarRutina.setText("Rutina");
        btnModificarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRutinaActionPerformed(evt);
            }
        });
        jMenu3.add(btnModificarRutina);

        btnModificarEntrenamiento.setText("Entrenamiento");
        btnModificarEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEntrenamientoActionPerformed(evt);
            }
        });
        jMenu3.add(btnModificarEntrenamiento);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Eliminar");

        btnEliminarUsuario.setText("Usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(btnEliminarUsuario);

        btnEliminarEjercicio.setText("Ejercicio");
        btnEliminarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEjercicioActionPerformed(evt);
            }
        });
        jMenu4.add(btnEliminarEjercicio);

        btnEliminarRutina.setText("Rutina");
        btnEliminarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRutinaActionPerformed(evt);
            }
        });
        jMenu4.add(btnEliminarRutina);

        btnEliminarEntrenamiento.setText("Entrenamiento");
        btnEliminarEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntrenamientoActionPerformed(evt);
            }
        });
        jMenu4.add(btnEliminarEntrenamiento);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ver");

        btnVerUsuarios.setText("Usuarios");
        btnVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerUsuariosActionPerformed(evt);
            }
        });
        jMenu5.add(btnVerUsuarios);

        btnVerEjercicios.setText("Ejercicios");
        btnVerEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEjerciciosActionPerformed(evt);
            }
        });
        jMenu5.add(btnVerEjercicios);

        btnVerRutina.setText("Rutina");
        btnVerRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRutinaActionPerformed(evt);
            }
        });
        jMenu5.add(btnVerRutina);

        btnVerEntrenamiento.setText("Entrenamiento");
        btnVerEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEntrenamientoActionPerformed(evt);
            }
        });
        jMenu5.add(btnVerEntrenamiento);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         try {
        // Cargar el archivo helpset.hs desde la carpeta de recursos
        ClassLoader cl = getClass().getClassLoader();
        java.net.URL hsURL = HelpSet.findHelpSet(cl, "JavaHelp/helpset.hs");
        HelpSet hs = new HelpSet(cl, hsURL);
        HelpBroker hb = hs.createHelpBroker();

        // Mostrar ayuda en una ventana independiente
        hb.setDisplayed(true);

        // O, si quieres mostrar ayuda contextual sobre un componente específico:
        // hb.enableHelp(yourComponent, "uso", hs);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "No se pudo cargar la ayuda.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerUsuariosActionPerformed
        // TODO add your handling code here:
        VerUsuarios ver= new VerUsuarios();
        ver.setVisible(true);
    }//GEN-LAST:event_btnVerUsuariosActionPerformed

    private void btnVerEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEjerciciosActionPerformed
        // TODO add your handling code here:
        VerEjercicios ver=new VerEjercicios();
        ver.setVisible(true);
    }//GEN-LAST:event_btnVerEjerciciosActionPerformed

    private void btnVerRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRutinaActionPerformed
        // TODO add your handling code here:
        VerRutinas ver=new VerRutinas();
        ver.setVisible(true);
    }//GEN-LAST:event_btnVerRutinaActionPerformed

    private void btnVerEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEntrenamientoActionPerformed
        // TODO add your handling code here:
        VerRutinasEjecucion ver=new VerRutinasEjecucion();
        ver.setVisible(true);
    }//GEN-LAST:event_btnVerEntrenamientoActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        EliminacionUsuario eliminacion = new EliminacionUsuario();
        eliminacion.setVisible(true);
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnEliminarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEjercicioActionPerformed
        // TODO add your handling code here:
        EliminacionEjercicio eliminacion=new EliminacionEjercicio();
        eliminacion.setVisible(true);
    }//GEN-LAST:event_btnEliminarEjercicioActionPerformed

    private void btnEliminarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRutinaActionPerformed
        // TODO add your handling code here:
        EliminacionRutina eliminacion=new EliminacionRutina();
        eliminacion.setVisible(true);
    }//GEN-LAST:event_btnEliminarRutinaActionPerformed

    private void btnEliminarEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntrenamientoActionPerformed
        // TODO add your handling code here:
        EliminacionRutinaEjecucion eliminacion=new EliminacionRutinaEjecucion();
        eliminacion.setVisible(true);
    }//GEN-LAST:event_btnEliminarEntrenamientoActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        // TODO add your handling code here:
        ModificarUsuario ver=new ModificarUsuario();
        ver.setVisible(true);
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnModificarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEjercicioActionPerformed
        // TODO add your handling code here:
        ModificarEjercicio ver=new ModificarEjercicio();
        ver.setVisible(true);
    }//GEN-LAST:event_btnModificarEjercicioActionPerformed

    private void btnModificarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRutinaActionPerformed
        // TODO add your handling code here:
        ModificarRutinas ver=new ModificarRutinas();
        ver.setVisible(true);
    }//GEN-LAST:event_btnModificarRutinaActionPerformed

    private void btnModificarEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEntrenamientoActionPerformed
        // TODO add your handling code here:
        ModificarRutinaEjecucion ver=new ModificarRutinaEjecucion();
        ver.setVisible(true);
    }//GEN-LAST:event_btnModificarEntrenamientoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        AñadirUsuario ver=new AñadirUsuario();
        ver.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        AñadirEjercicio ver=new AñadirEjercicio();
        ver.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        AñadirRutina ver=new AñadirRutina();
        ver.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        AñadirRutinaEjecuciones ver=new AñadirRutinaEjecuciones();
        ver.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new PantallaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnEliminarEjercicio;
    private javax.swing.JMenuItem btnEliminarEntrenamiento;
    private javax.swing.JMenuItem btnEliminarRutina;
    private javax.swing.JMenuItem btnEliminarUsuario;
    private javax.swing.JMenuItem btnModificarEjercicio;
    private javax.swing.JMenuItem btnModificarEntrenamiento;
    private javax.swing.JMenuItem btnModificarRutina;
    private javax.swing.JMenuItem btnModificarUsuario;
    private javax.swing.JMenuItem btnVerEjercicios;
    private javax.swing.JMenuItem btnVerEntrenamiento;
    private javax.swing.JMenuItem btnVerRutina;
    private javax.swing.JMenuItem btnVerUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
