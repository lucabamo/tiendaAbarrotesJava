/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Karla Rosas
 */
public class jfMenu extends javax.swing.JFrame {

    private Connection conexion;

    public jfMenu() {
        initComponents();

    }

    public void conectaBD() {
        String url, nombre, password;
        url = "jdbc:postgresql://localhost:5432/TiendaAbarrotes";
        nombre = "postgres";
        password = "postgres";

        try {
            conexion = DriverManager.getConnection(url, nombre, password);
            if (conexion != null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Conexión exitosa");

            }
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btVenta = new javax.swing.JButton();
        btDetalleVenta = new javax.swing.JButton();
        btPromocion = new javax.swing.JButton();
        btProveedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btVenta.setText("Venta");
        btVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVentaActionPerformed(evt);
            }
        });

        btDetalleVenta.setText("Detalle Venta");
        btDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalleVentaActionPerformed(evt);
            }
        });

        btPromocion.setText("Promocion");
        btPromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPromocionActionPerformed(evt);
            }
        });

        btProveedor.setText("Proveedor");
        btProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVenta)
                    .addComponent(btProveedor)
                    .addComponent(btPromocion)
                    .addComponent(btDetalleVenta))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btVenta)
                .addGap(28, 28, 28)
                .addComponent(btPromocion)
                .addGap(27, 27, 27)
                .addComponent(btDetalleVenta)
                .addGap(28, 28, 28)
                .addComponent(btProveedor)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conexion = null;
        conectaBD();
    }//GEN-LAST:event_formWindowOpened

    private void btVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVentaActionPerformed
        jfVenta ventaFrame = new jfVenta();
        ventaFrame.asignaConexion(conexion);
        ventaFrame.setVisible(true);
    }//GEN-LAST:event_btVentaActionPerformed

    private void btPromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPromocionActionPerformed
        jfPromocion promocionFrame = new jfPromocion();
        promocionFrame.asignaConexion(conexion);
        promocionFrame.setVisible(true);
    }//GEN-LAST:event_btPromocionActionPerformed

    private void btDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalleVentaActionPerformed
        jfDetalleVenta detalleFrame = new jfDetalleVenta();
        detalleFrame.asignaConexion(conexion);
        detalleFrame.setVisible(true);
    }//GEN-LAST:event_btDetalleVentaActionPerformed

    private void btProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProveedorActionPerformed
        jfProveedor proveedorFrame = new jfProveedor();
        proveedorFrame.asignaConexion(conexion);
        proveedorFrame.setVisible(true);
    }//GEN-LAST:event_btProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(jfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDetalleVenta;
    private javax.swing.JButton btPromocion;
    private javax.swing.JButton btProveedor;
    private javax.swing.JButton btVenta;
    // End of variables declaration//GEN-END:variables
}
