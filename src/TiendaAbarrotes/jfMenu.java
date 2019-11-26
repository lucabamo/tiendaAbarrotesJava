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
        btEmpleado = new javax.swing.JButton();
        btProducto = new javax.swing.JButton();
        btCompra = new javax.swing.JButton();
        btDetalleCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        btEmpleado.setText("Empleado");
        btEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpleadoActionPerformed(evt);
            }
        });

        btProducto.setText("Producto");
        btProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProductoActionPerformed(evt);
            }
        });

        btCompra.setText("Compra");
        btCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraActionPerformed(evt);
            }
        });

        btDetalleCompra.setText("Detalle Compra");
        btDetalleCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalleCompraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPromocion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDetalleVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDetalleCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(258, 258, 258))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(247, 247, 247))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDetalleCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

    private void btEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpleadoActionPerformed
        JFEmpleado empleado = new JFEmpleado();
        empleado.AsignaConexion(conexion);
        empleado.setVisible(true);
    }//GEN-LAST:event_btEmpleadoActionPerformed

    private void btProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProductoActionPerformed
        JFProducto producto = new JFProducto();
        producto.AsignaConexion(conexion);
        producto.setVisible(true);
    }//GEN-LAST:event_btProductoActionPerformed

    private void btCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraActionPerformed
        JFCompra compra = new JFCompra();
        compra.AsignaConexion(conexion);
        compra.setVisible(true);
    }//GEN-LAST:event_btCompraActionPerformed

    private void btDetalleCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalleCompraActionPerformed
        JFDetalleCompra detalleCompra = new JFDetalleCompra();
        detalleCompra.AsignaConexion(conexion);
        detalleCompra.setVisible(true);
    }//GEN-LAST:event_btDetalleCompraActionPerformed

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
    private javax.swing.JButton btCompra;
    private javax.swing.JButton btDetalleCompra;
    private javax.swing.JButton btDetalleVenta;
    private javax.swing.JButton btEmpleado;
    private javax.swing.JButton btProducto;
    private javax.swing.JButton btPromocion;
    private javax.swing.JButton btProveedor;
    private javax.swing.JButton btVenta;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
