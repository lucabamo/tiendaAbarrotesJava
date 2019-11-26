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
        //jdbc::postgres://localhost:5432/
        url = "jdbc:postgresql://localhost:5432/tiendaDeAbarratos";
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
        jBEntrega = new javax.swing.JButton();
        jBDevoluciones = new javax.swing.JButton();
        jBDetalleDevolucion = new javax.swing.JButton();

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

        jBEntrega.setText("Entregas");
        jBEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntregaActionPerformed(evt);
            }
        });

        jBDevoluciones.setText("Devoluciones");
        jBDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolucionesActionPerformed(evt);
            }
        });

        jBDetalleDevolucion.setText("Detalle Devolucion");
        jBDetalleDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalleDevolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVenta)
                            .addComponent(btProveedor)
                            .addComponent(btPromocion)
                            .addComponent(btDetalleVenta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jBEntrega)
                        .addGap(99, 99, 99)
                        .addComponent(jBDevoluciones)))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBDetalleDevolucion)
                .addGap(288, 288, 288))
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
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEntrega)
                    .addComponent(jBDevoluciones))
                .addGap(37, 37, 37)
                .addComponent(jBDetalleDevolucion)
                .addContainerGap(84, Short.MAX_VALUE))
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

    private void jBEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntregaActionPerformed
        // TODO add your handling code here:
        jfEntrega entregaFrame = new jfEntrega(conexion);
        entregaFrame.setVisible(true);
    }//GEN-LAST:event_jBEntregaActionPerformed

    private void jBDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolucionesActionPerformed
        // TODO add your handling code here:
        jfDevolucion devolucionFrame = new jfDevolucion();
        devolucionFrame.asignaConexion(conexion);
        devolucionFrame.setVisible(true);
    }//GEN-LAST:event_jBDevolucionesActionPerformed

    private void jBDetalleDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalleDevolucionActionPerformed
        // TODO add your handling code here:
        jfDetalleDevolucion detalleDevolucionFrame = new jfDetalleDevolucion();
        detalleDevolucionFrame.asignaConexion(conexion);
        detalleDevolucionFrame.setVisible(true);
    }//GEN-LAST:event_jBDetalleDevolucionActionPerformed

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
    private javax.swing.JButton jBDetalleDevolucion;
    private javax.swing.JButton jBDevoluciones;
    private javax.swing.JButton jBEntrega;
    // End of variables declaration//GEN-END:variables
}
