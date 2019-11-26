/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import javax.swing.JTable;
/**
 *
 * @author Luis Bacasehua
 */
public class jfDetalleDevolucion extends javax.swing.JFrame {

    private Connection conexion;

    private DetalleDevolucion detalleDevolucion;
    /**
     * Creates new form jfDetalleDevolucion
     */
    public jfDetalleDevolucion() {
        initComponents();
    }

    
        public void asignaConexion(Connection connection) {
        this.conexion = connection;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMotivoDevEntrega = new javax.swing.JLabel();
        jLProductoDetalleDev = new javax.swing.JLabel();
        jCMotivoDevolucionDetalle = new javax.swing.JComboBox<>();
        jCProductoDetalle = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDetallesDevoluciones = new javax.swing.JTable();
        jBAgregarDetalleDev = new javax.swing.JButton();
        jBEditarDetalleDev = new javax.swing.JButton();
        jBEliminarDetalleDev = new javax.swing.JButton();
        jLCantidad = new javax.swing.JLabel();
        jTCantidadDetalleDev = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jMotivoDevEntrega.setText("Motivo devolución");

        jLProductoDetalleDev.setText("Producto");

        jScrollPane1.setViewportView(jTDetallesDevoluciones);

        jBAgregarDetalleDev.setText("Agregar");

        jBEditarDetalleDev.setText("Editar");

        jBEliminarDetalleDev.setText("Eliminar");

        jLCantidad.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLProductoDetalleDev)
                            .addComponent(jCProductoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAgregarDetalleDev)
                        .addGap(18, 18, 18)
                        .addComponent(jBEditarDetalleDev)
                        .addGap(18, 18, 18)
                        .addComponent(jBEliminarDetalleDev)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jMotivoDevEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLCantidad)
                        .addGap(261, 261, 261))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCMotivoDevolucionDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(jTCantidadDetalleDev, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMotivoDevEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCMotivoDevolucionDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCantidadDetalleDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLProductoDetalleDev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCProductoDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBAgregarDetalleDev)
                            .addComponent(jBEditarDetalleDev)
                            .addComponent(jBEliminarDetalleDev))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        detalleDevolucion = new DetalleDevolucion();
        detalleDevolucion.consultaDetallesDevolucion(conexion, jTDetallesDevoluciones);
        detalleDevolucion.cargaMotivoDevoluciones(conexion, jCMotivoDevolucionDetalle);
        detalleDevolucion.cargaProductos(conexion, jCProductoDetalle);
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
            java.util.logging.Logger.getLogger(jfDetalleDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfDetalleDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfDetalleDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfDetalleDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfDetalleDevolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarDetalleDev;
    private javax.swing.JButton jBEditarDetalleDev;
    private javax.swing.JButton jBEliminarDetalleDev;
    private javax.swing.JComboBox<String> jCMotivoDevolucionDetalle;
    private javax.swing.JComboBox<String> jCProductoDetalle;
    private javax.swing.JLabel jLCantidad;
    private javax.swing.JLabel jLProductoDetalleDev;
    private javax.swing.JLabel jMotivoDevEntrega;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCantidadDetalleDev;
    private javax.swing.JTable jTDetallesDevoluciones;
    // End of variables declaration//GEN-END:variables
}