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

    private Connection conexion;

    private DetalleVenta detalleVenta;

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

        btAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btAgregar.setForeground(new java.awt.Color(0, 153, 153));
        btAgregar.setText("Insertar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Promocion");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Producto:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Cantidad:");

        cbPromocion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbPromocion.setEnabled(false);

        cbProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProductoItemStateChanged(evt);
            }
        });

        tfCantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        IdVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        IdVenta.setForeground(new java.awt.Color(0, 102, 153));
        IdVenta.setText("IdVenta:");

        cbVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btEliminarDetalle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btEliminarDetalle.setForeground(new java.awt.Color(0, 153, 153));
        btEliminarDetalle.setText("Eliminar");
        btEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarDetalleActionPerformed(evt);
            }
        });

        btModificarDetalle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btModificarDetalle.setForeground(new java.awt.Color(0, 153, 153));
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
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(IdVenta))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPromocion, 0, 170, Short.MAX_VALUE)
                            .addComponent(cbVentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btAgregar)
                        .addGap(84, 84, 84)
                        .addComponent(btModificarDetalle)
                        .addGap(72, 72, 72)
                        .addComponent(btEliminarDetalle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdVenta)
                    .addComponent(jLabel2)
                    .addComponent(cbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModificarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        int idVenta = Integer.parseInt(cbVentas.getSelectedItem().toString());
        int idEmpleado = Integer.parseInt(cbPromocion.getSelectedItem().toString());
        int idProducto = ((Item) cbProducto.getSelectedItem()).getId();
        int cantidad = Integer.parseInt(tfCantidad.getText());
        detalleVenta.agregaDetalleVenta(conexion,idVenta, idEmpleado, idProducto, cantidad);
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        resetControles();

    }//GEN-LAST:event_btAgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        detalleVenta = new DetalleVenta();
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        detalleVenta.seleccionaVentas(conexion, cbVentas);
        detalleVenta.seleccionaProductos(conexion, cbProducto);
        resetControles();
    }//GEN-LAST:event_formWindowOpened

    private void jtDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtDetallesMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        
        detalleVenta.setIdDetalleVenta(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));
        cbVentas.setSelectedItem(source.getModel().getValueAt(row, 1).toString());
        cbPromocion.setSelectedItem(source.getModel().getValueAt(row, 2).toString());
        cbProducto.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 3).toString())));
        tfCantidad.setText(source.getModel().getValueAt(row, 4).toString());
    }//GEN-LAST:event_jtDetallesMouseClicked

    private void cbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProductoItemStateChanged
        
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
           cbPromocion.setEnabled(true);
           int idProducto =  detalleVenta.seleccionaIdProducto(conexion, evt.getItem().toString());
           detalleVenta.seleccionaPromocion(conexion, cbPromocion, idProducto);   
        }
    }//GEN-LAST:event_cbProductoItemStateChanged

    private void btModificarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarDetalleActionPerformed
        int idVenta = Integer.parseInt(cbVentas.getSelectedItem().toString());
        int idEmpleado = Integer.parseInt(cbPromocion.getSelectedItem().toString());
        int idProducto = ((Item) cbProducto.getSelectedItem()).getId();
        int cantidad = Integer.parseInt(tfCantidad.getText());
        detalleVenta.modificaDetalleVenta(conexion, idVenta, idProducto, idProducto, cantidad);
        detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
        resetControles();
    }//GEN-LAST:event_btModificarDetalleActionPerformed

    private void btEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarDetalleActionPerformed
       detalleVenta.eliminaDetalleVenta(conexion);
       detalleVenta.seleccionaDetallesVenta(conexion, jtDetalles);
       resetControles();
    }//GEN-LAST:event_btEliminarDetalleActionPerformed

    public void asignaConexion(Connection connection) {
        this.conexion = connection;
    }

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
