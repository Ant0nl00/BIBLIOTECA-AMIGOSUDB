
package bibliotecaamigosdonbosco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class SolicitarDevolucion extends javax.swing.JFrame {

    public SolicitarDevolucion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTipoEjemplar = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinnerFechaDevolucion = new javax.swing.JSpinner();
        btnConfirmarDevolucion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cbPrestamosPendientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("REALIZAR DEVOLUCION");

        jLabel2.setText("TIPO DE EJEMPLAR");

        cbTipoEjemplar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Revista", "Tesis", "Obra", "CD" }));
        cbTipoEjemplar.setToolTipText("Libro, Revista, Tesis, Obra, CD");
        cbTipoEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoEjemplarActionPerformed(evt);
            }
        });

        jLabel3.setText("SELECIONAR EJEMPLAR");

        jLabel4.setText("FECHA DE DEVOLUCION");

        spinnerFechaDevolucion.setModel(new javax.swing.SpinnerDateModel());

        btnConfirmarDevolucion.setText("CONFIRMAR DEVOLUCION");
        btnConfirmarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarDevolucionActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbPrestamosPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrestamosPendientesActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(cbPrestamosPendientes);

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
                                    .addComponent(btnConfirmarDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmarDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoEjemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoEjemplarActionPerformed
         String tipoEjemplar = cbTipoEjemplar.getSelectedItem().toString();
         cargarPrestamosPendientes(tipoEjemplar);
    }//GEN-LAST:event_cbTipoEjemplarActionPerformed

        private void cargarPrestamosPendientes(String tipoEjemplar) {
    // Mapa de tipo de ejemplar a tabla
    String tabla = "";
    switch (tipoEjemplar) {
        case "Libro":
            tabla = "libros";
            break;
        case "Revista":
            tabla = "revistas";
            break;
        case "Tesis":
            tabla = "tesis";
            break;
        case "Obra":
            tabla = "Obras";
            break;
        case "CD":
            tabla = "CDs";
            break;
        default:
            JOptionPane.showMessageDialog(this, "Tipo de ejemplar no reconocido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
    }

    // Ahora usamos la tabla correcta
    String sql = "SELECT prestamos.id, prestamos.fecha_prestamo, " +
                 "ejemplares.titulo FROM prestamos " +
                 "JOIN " + tabla + " AS ejemplares ON prestamos.id_ejemplar = ejemplares.id " +
                 "WHERE prestamos.fecha_devolucion IS NULL";
    
    cbPrestamosPendientes.removeAllItems();
    
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            cbPrestamosPendientes.addItem(rs.getInt("id") + " - " + rs.getString("titulo"));
        }
    } catch (SQLException e) {
        System.out.println("Error al cargar los préstamos pendientes: " + e.getMessage());
    }
}

    
    private void btnConfirmarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDevolucionActionPerformed
     String selectedPrestamo = (String) cbPrestamosPendientes.getSelectedItem();
    if (selectedPrestamo == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un préstamo pendiente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    int prestamoId = Integer.parseInt(selectedPrestamo.split(" - ")[0]);
    Date fechaDevolucion = (Date) spinnerFechaDevolucion.getValue();

    // Actualizar la fecha de devolución en la base de datos
    String sql = "UPDATE prestamos SET fecha_devolucion = ? WHERE id = ?";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setDate(1, new java.sql.Date(fechaDevolucion.getTime()));
        pst.setInt(2, prestamoId);
        
        int filasActualizadas = pst.executeUpdate();
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(this, "Devolución registrada exitosamente.");
            actualizarCantidadPrestados(prestamoId);  // Si el préstamo es de tipo CD, actualizamos la cantidad prestada
        }
    } catch (SQLException e) {
        System.out.println("Error al confirmar la devolución: " + e.getMessage());
    }        
    }//GEN-LAST:event_btnConfirmarDevolucionActionPerformed
    
    private void actualizarCantidadPrestados(int prestamoId) {
    // Aquí actualizamos la cantidad de ejemplares prestados para el tipo CD
    String tipoEjemplar = cbTipoEjemplar.getSelectedItem().toString();
    
    if (tipoEjemplar.equals("CD")) {
        String sql = "UPDATE CDs SET cantidad_prestados = cantidad_prestados - 1 " +
                     "WHERE id IN (SELECT id_ejemplar FROM prestamos WHERE id = ?)";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, prestamoId);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la cantidad de CDs prestados: " + e.getMessage());
        }
    }
}

    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbPrestamosPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrestamosPendientesActionPerformed
        
    }//GEN-LAST:event_cbPrestamosPendientesActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitarDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitarDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitarDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitarDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitarDevolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmarDevolucion;
    private javax.swing.JComboBox<String> cbPrestamosPendientes;
    private javax.swing.JComboBox<String> cbTipoEjemplar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerFechaDevolucion;
    // End of variables declaration//GEN-END:variables
}
