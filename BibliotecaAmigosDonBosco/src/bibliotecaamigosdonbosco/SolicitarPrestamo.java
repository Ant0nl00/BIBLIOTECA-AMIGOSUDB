
package bibliotecaamigosdonbosco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class SolicitarPrestamo extends javax.swing.JFrame {

    public SolicitarPrestamo() {
        initComponents();
    }
    
    private void actualizarEjemplaresDisponibles(String tipoEjemplar) {
    cbEjemplaresDisponibles.removeAllItems();
    
    String query = "";
    switch (tipoEjemplar) {
        case "Libro":
            query = "SELECT id, titulo FROM libros WHERE cantidad_total > 0";
            break;
        case "Revista":
            query = "SELECT id, titulo FROM revistas WHERE cantidad_total > 0";
            break;
        case "Tesis":
            query = "SELECT id, titulo FROM tesis WHERE cantidad_total > 0";
            break;
        case "Obra":
            query = "SELECT id, titulo FROM Obras WHERE cantidad_total > 0";
            break;
        case "CD":
            query = "SELECT id, titulo FROM CDs WHERE cantidad_total > 0";
            break;
        default:
            return;
    }
    
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            cbEjemplaresDisponibles.addItem(rs.getString("titulo"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
    private int obtenerIdEjemplar(String tipoEjemplar, String ejemplarSeleccionado) {
    String query = "";
    switch (tipoEjemplar) {
        case "Libro":
            query = "SELECT id FROM libros WHERE titulo = ?";
            break;
        case "Revista":
            query = "SELECT id FROM revistas WHERE titulo = ?";
            break;
        case "Tesis":
            query = "SELECT id FROM tesis WHERE titulo = ?";
            break;
        case "Obra":
            query = "SELECT id FROM Obras WHERE titulo = ?";
            break;
        case "CD":
            query = "SELECT id FROM CDs WHERE titulo = ?";
            break;
        default:
            return -1;
    }

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, ejemplarSeleccionado);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return rs.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
}


    private void realizarPrestamo(int ejemplarId, Date fechaPrestamo, String tipoEjemplar) {
    String query = "INSERT INTO prestamos (id_ejemplar, fecha_prestamo, tipo_ejemplar, id_usuario) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        int idUsuario = obtenerIdUsuario(); // Este valor lo puedes obtener de tu sesión o el usuario logueado

        ps.setInt(1, ejemplarId);
        ps.setDate(2, new java.sql.Date(fechaPrestamo.getTime()));
        ps.setString(3, tipoEjemplar);
        ps.setInt(4, idUsuario);

        ps.executeUpdate();

        actualizarCantidadEjemplar(ejemplarId, tipoEjemplar);

        JOptionPane.showMessageDialog(this, "Préstamo realizado con éxito");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    

    private int obtenerIdUsuario() {
        return 1;  // Cambiar por la ID del usuario logueado en el sistema
    }

    private void actualizarCantidadEjemplar(int ejemplarId, String tipoEjemplar) {
    String query = "";
    switch (tipoEjemplar) {
        case "Libro":
            query = "UPDATE libros SET cantidad_total = cantidad_total - 1 WHERE id = ?";
            break;
        case "Revista":
            query = "UPDATE revistas SET cantidad_total = cantidad_total - 1 WHERE id = ?";
            break;
        case "Tesis":
            query = "UPDATE tesis SET cantidad_total = cantidad_total - 1 WHERE id = ?";
            break;
        case "Obra":
            query = "UPDATE Obras SET cantidad_total = cantidad_total - 1 WHERE id = ?";
            break;
        case "CD":
            query = "UPDATE CDs SET cantidad_total = cantidad_total - 1 WHERE id = ?";
            break;
        default:
            return;
    }

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1, ejemplarId);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipoEjemplar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinnerFechaPrestamo = new javax.swing.JSpinner();
        btnConfirmarPrestamo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cbEjemplaresDisponibles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("REALIZAR PRESTAMOS");

        jLabel2.setText("TIPO DE EJEMPLAR");

        cbTipoEjemplar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Revista", "Tesis", "Obra", "CD" }));
        cbTipoEjemplar.setToolTipText("Libro, Revista, Tesis, Obra, CD");
        cbTipoEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoEjemplarActionPerformed(evt);
            }
        });

        jLabel3.setText("SELECIONAR EJEMPLAR");

        jLabel4.setText("FECHA DE PRESTAMO");

        spinnerFechaPrestamo.setModel(new javax.swing.SpinnerDateModel());

        btnConfirmarPrestamo.setText("CONFIRMAR PRESTAMO");
        btnConfirmarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPrestamoActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbEjemplaresDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEjemplaresDisponiblesActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(cbEjemplaresDisponibles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnConfirmarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTipoEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmarPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoEjemplarActionPerformed
        String tipoEjemplar = cbTipoEjemplar.getSelectedItem().toString();
        actualizarEjemplaresDisponibles(tipoEjemplar);
    }//GEN-LAST:event_cbTipoEjemplarActionPerformed

    private void cbEjemplaresDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEjemplaresDisponiblesActionPerformed
        String ejemplarSeleccionado = cbEjemplaresDisponibles.getSelectedItem() != null
                ? cbEjemplaresDisponibles.getSelectedItem().toString()
                : "Ninguno";
        System.out.println("Ejemplar seleccionado: " + ejemplarSeleccionado);
    }//GEN-LAST:event_cbEjemplaresDisponiblesActionPerformed

    private void btnConfirmarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPrestamoActionPerformed
          Date fechaPrestamo = (Date) spinnerFechaPrestamo.getValue();
    String ejemplarSeleccionado = cbEjemplaresDisponibles.getSelectedItem().toString();
    String tipoEjemplar = cbTipoEjemplar.getSelectedItem().toString();
    
    int ejemplarId = obtenerIdEjemplar(tipoEjemplar, ejemplarSeleccionado);
    
    if (ejemplarId != -1) {
        realizarPrestamo(ejemplarId, fechaPrestamo, tipoEjemplar);
    } else {
        JOptionPane.showMessageDialog(this, "Ejemplar no disponible", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnConfirmarPrestamoActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SolicitarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitarPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmarPrestamo;
    private javax.swing.JComboBox<String> cbEjemplaresDisponibles;
    private javax.swing.JComboBox<String> cbTipoEjemplar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerFechaPrestamo;
    // End of variables declaration//GEN-END:variables
}
