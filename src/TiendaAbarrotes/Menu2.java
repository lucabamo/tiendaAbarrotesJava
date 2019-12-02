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
 * @author Luis Bacasehua
 */
public class Menu2 extends javax.swing.JFrame {

    //declaracion de variables globales
    private Connection conexion;

    /**
     * Creates new form Menu2
     */
    public Menu2(Connection conexion) {
        initComponents();
        this.conexion = conexion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbEmpleadoMenu = new javax.swing.JButton();
        jBProveedorMenu = new javax.swing.JButton();
        jBProductoMenu = new javax.swing.JButton();
        jBPromocionMenu = new javax.swing.JButton();
        jBVentaMenu = new javax.swing.JButton();
        jBDetalleVentaMenu = new javax.swing.JButton();
        jBCompraMenu = new javax.swing.JButton();
        jBDetalleCompraMEnu = new javax.swing.JButton();
        jBDevolucion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jBEntregaMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JbEmpleadoMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JbEmpleadoMenu.setForeground(new java.awt.Color(0, 102, 153));
        JbEmpleadoMenu.setText("Empleado");
        JbEmpleadoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbEmpleadoMenuActionPerformed(evt);
            }
        });

        jBProveedorMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBProveedorMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBProveedorMenu.setText("Proveedor");
        jBProveedorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProveedorMenuActionPerformed(evt);
            }
        });

        jBProductoMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBProductoMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBProductoMenu.setText("Producto");
        jBProductoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProductoMenuActionPerformed(evt);
            }
        });

        jBPromocionMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBPromocionMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBPromocionMenu.setText("Promoción");
        jBPromocionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPromocionMenuActionPerformed(evt);
            }
        });

        jBVentaMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBVentaMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBVentaMenu.setText("Venta");
        jBVentaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVentaMenuActionPerformed(evt);
            }
        });

        jBDetalleVentaMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBDetalleVentaMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBDetalleVentaMenu.setText("Detalle Venta");
        jBDetalleVentaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalleVentaMenuActionPerformed(evt);
            }
        });

        jBCompraMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBCompraMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBCompraMenu.setText("Compra");
        jBCompraMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCompraMenuActionPerformed(evt);
            }
        });

        jBDetalleCompraMEnu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBDetalleCompraMEnu.setForeground(new java.awt.Color(0, 102, 153));
        jBDetalleCompraMEnu.setText("Detalle Compra");
        jBDetalleCompraMEnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalleCompraMEnuActionPerformed(evt);
            }
        });

        jBDevolucion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBDevolucion.setForeground(new java.awt.Color(0, 102, 153));
        jBDevolucion.setText("Devolución");
        jBDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolucionActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("Detalle Devolución");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBEntregaMenu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jBEntregaMenu.setForeground(new java.awt.Color(0, 102, 153));
        jBEntregaMenu.setText("Entrega");
        jBEntregaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntregaMenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("MENÚ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBCompraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBVentaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBEntregaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBDetalleCompraMEnu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBDetalleVentaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBPromocionMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jBProductoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(JbEmpleadoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jBProveedorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel1)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBProductoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbEmpleadoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBProveedorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDetalleVentaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVentaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDetalleCompraMEnu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCompraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEntregaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPromocionMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        metodo del boton empleado, pasa la conexion a empleado y abre una nueva ventana
     */
    private void JbEmpleadoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbEmpleadoMenuActionPerformed
        // TODO add your handling code here:
        JFEmpleado empleado = new JFEmpleado();
        empleado.AsignaConexion(conexion);
        empleado.setVisible(true);
    }//GEN-LAST:event_JbEmpleadoMenuActionPerformed
    /*
        metodo del boton roveedor, pasa la conexion a proveedor y abre una nueva ventana
     */
    private void jBProveedorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProveedorMenuActionPerformed
        // TODO add your handling code here:
        jfProveedor proveedorFrame = new jfProveedor();
        proveedorFrame.asignaConexion(conexion);
        proveedorFrame.setVisible(true);
    }//GEN-LAST:event_jBProveedorMenuActionPerformed
    /*
        metodo del boton producto, pasa la conexion a producto y abre una nueva ventana
     */
    private void jBProductoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProductoMenuActionPerformed
        // TODO add your handling code here:
        JFProducto producto = new JFProducto();
        producto.AsignaConexion(conexion);
        producto.setVisible(true);
    }//GEN-LAST:event_jBProductoMenuActionPerformed
    /*
        metodo del boton promocion, pasa la conexion a promocion y abre una nueva ventana
     */
    private void jBPromocionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPromocionMenuActionPerformed
        // TODO add your handling code here:
        jfPromocion promocionFrame = new jfPromocion();
        promocionFrame.asignaConexion(conexion);
        promocionFrame.setVisible(true);
    }//GEN-LAST:event_jBPromocionMenuActionPerformed
    /*
        metodo del boton venta, pasa la conexion a venta y abre una nueva ventana
     */
    private void jBVentaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVentaMenuActionPerformed
        // TODO add your handling code here:
        jfVenta ventaFrame = new jfVenta();
        ventaFrame.asignaConexion(conexion);
        ventaFrame.setVisible(true);
    }//GEN-LAST:event_jBVentaMenuActionPerformed
    /*
        metodo del boton detalleVenta, pasa la conexion a detalleVenta y abre una nueva ventana
     */
    private void jBDetalleVentaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalleVentaMenuActionPerformed
        // TODO add your handling code here:
        jfDetalleVenta detalleFrame = new jfDetalleVenta();
        detalleFrame.asignaConexion(conexion);
        detalleFrame.setVisible(true);
    }//GEN-LAST:event_jBDetalleVentaMenuActionPerformed
    /*
        metodo del boton compra, pasa la conexion a compra y abre una nueva ventana
     */
    private void jBCompraMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCompraMenuActionPerformed
        // TODO add your handling code here:
        JFCompra compra = new JFCompra();
        compra.AsignaConexion(conexion);
        compra.setVisible(true);
    }//GEN-LAST:event_jBCompraMenuActionPerformed
    /*
        metodo del boton detalleCompra, pasa la conexion a detalleCompra y abre una nueva ventana
     */
    private void jBDetalleCompraMEnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalleCompraMEnuActionPerformed
        // TODO add your handling code here:
        JFDetalleCompra detalleCompra = new JFDetalleCompra();
        detalleCompra.AsignaConexion(conexion);
        detalleCompra.setVisible(true);
    }//GEN-LAST:event_jBDetalleCompraMEnuActionPerformed
    /*
        metodo del boton devolucion, pasa la conexion a devoluciony abre una nueva ventana
     */
    private void jBDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolucionActionPerformed
        // TODO add your handling code here:
        jfDevolucion devolucionFrame = new jfDevolucion();
        devolucionFrame.asignaConexion(conexion);
        devolucionFrame.setVisible(true);
    }//GEN-LAST:event_jBDevolucionActionPerformed
    /*
        metodo del boton detalledevolucion, pasa la conexion a detalledevolucion y abre una nueva ventana
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jfDetalleDevolucion detalleDevolucionFrame = new jfDetalleDevolucion();
        detalleDevolucionFrame.asignaConexion(conexion);
        detalleDevolucionFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    /*
        metodo del boton entrega, pasa la conexion a entrega y abre una nueva ventana
     */
    private void jBEntregaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntregaMenuActionPerformed
        // TODO add your handling code here:
        jfEntrega entregaFrame = new jfEntrega(conexion);
        entregaFrame.asignaConexion(conexion);
        entregaFrame.setVisible(true);
    }//GEN-LAST:event_jBEntregaMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        /*conexion = null;
        conectaBD();*/
    }//GEN-LAST:event_formWindowOpened

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Menu2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbEmpleadoMenu;
    private javax.swing.JButton jBCompraMenu;
    private javax.swing.JButton jBDetalleCompraMEnu;
    private javax.swing.JButton jBDetalleVentaMenu;
    private javax.swing.JButton jBDevolucion;
    private javax.swing.JButton jBEntregaMenu;
    private javax.swing.JButton jBProductoMenu;
    private javax.swing.JButton jBPromocionMenu;
    private javax.swing.JButton jBProveedorMenu;
    private javax.swing.JButton jBVentaMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
