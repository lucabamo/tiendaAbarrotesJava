/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import javax.swing.JTable;
import java.awt.event.ItemEvent;

/**
 *
 * @author Karla Rosas
 */
public class jfDetalleVenta extends javax.swing.JFrame {

    /*
    declaracion de variables
    */
    private Connection conexion;

    private DetalleVenta detalleVenta;

    //constructor
    public jfDetalleVenta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtDetalles = new javax.swing.JTable();
        btAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbPromocion = new javax.swing.JComboBox<>();
        cbProducto = new javax.swing.JComboBox<>();
        tfCantidad = new javax.swing.JTextField();
        IdVenta = new javax.swing.JLabel();
        cbVentas = new javax.swing.JComboBox<>();
        btEliminarDetalle = new javax.swing.JButton();
        btModificarDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtDetallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtDetalles);

        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Promocion");

        jLabel2.setText("Producto");

        jLabel3.setText("Cantidad");

        cbPromocion.setEnabled(false);

        cbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProductoItemStateChanged(evt);
            }
        });

        IdVenta.setText("IdVenta");

        btEliminarDetalle.setText("Eliminar");
        btEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarDetalleActionPerformed(evt);
            }
        });

        btModificarDetalle.setText("Modificar");
        btModificarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IdVenta)
                                        .addGap(115, 115, 115)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPromocion, javax.swing.GroupLayout.Alignment.LEADING, 0, 114, Short.MAX_VALUE)
                            .addComponent(cbProducto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(165, 165, 165)
                        .addComponent(btAgregar)
                        .addGap(43, 43, 43)
                        .addComponent(btModificarDetalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEliminarDetalle)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdVenta)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregar)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModificarDetalle)
                    .addComponent(btEliminarDetalle))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
    metodo del boton agregar
    recupera la informacion de los controles y manda a llamar agregadetalleventa
    actualiza la tabla
    */
    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        int idVenta = Integer.parseInt(cbVentas.getSelectedItem().toString());
        int idEmpleado = Integer.parseInt(cbPromocion.getSelectedItem().toString());
        int idProducto = ((Item) cbProducto.getSelectedItem()).getId();
        int cantidad = Integer.parseInt(tfCantidad.getText());
        detalleVenta.agregaDetalleVenta(conexion,idVenta, idEmpleado, idProducto, cantidad);
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        resetControles();

    }//GEN-LAST:event_btAgregarActionPerformed

    /*
    metodo que se activa al abrir la ventana
    actualiza los combo box y la tabla
    */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        detalleVenta = new DetalleVenta();
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        detalleVenta.seleccionaVentas(conexion, cbVentas);
        detalleVenta.seleccionaProductos(conexion, cbProducto);
        resetControles();
    }//GEN-LAST:event_formWindowOpened

    /*
    metodo que se activa al darle click a la tabla
    recupera la informacion del registro y la carga en los controles
    */
    private void jtDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDetallesMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        
        detalleVenta.setIdDetalleVenta(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));
        cbVentas.setSelectedItem(source.getModel().getValueAt(row, 1).toString());
        cbPromocion.setSelectedItem(source.getModel().getValueAt(row, 2).toString());
        cbProducto.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 3).toString())));
        tfCantidad.setText(source.getModel().getValueAt(row, 4).toString());
    }//GEN-LAST:event_jtDetallesMouseClicked

    /*
    metodo que se activa cuando seleccionas un item del combo box
    manda a llamar al evento seleciona id producto para seleccionar las promociones
    */
    private void cbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProductoItemStateChanged
        
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
           cbPromocion.setEnabled(true);
           int idProducto =  detalleVenta.seleccionaIdProducto(conexion, evt.getItem().toString());
           detalleVenta.seleccionaPromocion(conexion, cbPromocion, idProducto);   
        }
    }//GEN-LAST:event_cbProductoItemStateChanged

    /*
    metodo del boton modificar
    recupera la informacion de los controles y manda a llamar modificardetalleventa
    actualiza la tabla
    */

    private void btModificarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarDetalleActionPerformed
        int idVenta = Integer.parseInt(cbVentas.getSelectedItem().toString());
        int idEmpleado = Integer.parseInt(cbPromocion.getSelectedItem().toString());
        int idProducto = ((Item) cbProducto.getSelectedItem()).getId();
        int cantidad = Integer.parseInt(tfCantidad.getText());
        detalleVenta.modificaDetalleVenta(conexion, idVenta, idProducto, idProducto, cantidad);
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        resetControles();
    }//GEN-LAST:event_btModificarDetalleActionPerformed

    /*
    metodo del boton eliminar
    elmina la venta y actualiza la tabla
    */
    private void btEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarDetalleActionPerformed
       detalleVenta.eliminaDetalleVenta(conexion);
       detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
       resetControles();
    }//GEN-LAST:event_btEliminarDetalleActionPerformed

    //asigna conexion
    public void asignaConexion(Connection connection) {
        this.conexion = connection;
    }

    //reseta controles
    public void resetControles() {
        cbVentas.setSelectedItem(null);
        cbPromocion.setSelectedItem(null);
        cbPromocion.setEnabled(false);
        cbProducto.setSelectedItem(null);
        tfCantidad.setText("");
    }

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
            java.util.logging.Logger.getLogger(jfDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfDetalleVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdVenta;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btEliminarDetalle;
    private javax.swing.JButton btModificarDetalle;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JComboBox<String> cbPromocion;
    private javax.swing.JComboBox<String> cbVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtDetalles;
    private javax.swing.JTextField tfCantidad;
    // End of variables declaration//GEN-END:variables
}
