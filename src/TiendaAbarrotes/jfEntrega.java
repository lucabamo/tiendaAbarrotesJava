/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Luis Bacasehua
 */
public class jfEntrega extends javax.swing.JFrame {

    private Connection conexion = null;
    Entrega entrega;

    /**
     * Creates new form jfEntrega
     */
    public jfEntrega(Connection conexion) {
        initComponents();
        entrega = new Entrega();
        this.conexion = conexion;
    }

    
    public void limpiaFormulario(){
        jcEmpleadoEntrega.setSelectedItem(null);
        jcProveedorEntrega.setSelectedItem(null);
        jcMotivoDevEntrega.setSelectedItem(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcEmpleadoEntrega = new javax.swing.JComboBox<>();
        jcProveedorEntrega = new javax.swing.JComboBox<>();
        jLEmpleadoEntrega = new javax.swing.JLabel();
        jLProveedorEntrega = new javax.swing.JLabel();
        jLMotivoEntrega = new javax.swing.JLabel();
        jcMotivoDevEntrega = new javax.swing.JComboBox<>();
        jBAgregarEntrega = new javax.swing.JButton();
        jBEditarEntrega = new javax.swing.JButton();
        jBEliminarEntrega = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTEntregas = new javax.swing.JTable();
        jDtFechaEntrega = new org.jdesktop.swingx.JXDatePicker();
        jLProveedorEntrega1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLEmpleadoEntrega.setText("Empleado");

        jLProveedorEntrega.setText("Proveedor");

        jLMotivoEntrega.setText("Motivo devolución");

        jBAgregarEntrega.setText("Agregar");
        jBAgregarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarEntregaActionPerformed(evt);
            }
        });

        jBEditarEntrega.setText("Editar");
        jBEditarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarEntregaActionPerformed(evt);
            }
        });

        jBEliminarEntrega.setText("Eliminar");
        jBEliminarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarEntregaActionPerformed(evt);
            }
        });

        jTEntregas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEntregasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEntregas);

        jLProveedorEntrega1.setText("Fecha Entrega");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLMotivoEntrega)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLEmpleadoEntrega)
                                            .addComponent(jcEmpleadoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcProveedorEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLProveedorEntrega)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLProveedorEntrega1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jDtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcMotivoDevEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                        .addComponent(jBAgregarEntrega)
                                        .addGap(63, 63, 63)
                                        .addComponent(jBEditarEntrega)
                                        .addGap(13, 13, 13)))
                                .addGap(32, 32, 32)
                                .addComponent(jBEliminarEntrega))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmpleadoEntrega)
                    .addComponent(jLProveedorEntrega)
                    .addComponent(jDtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLProveedorEntrega1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcEmpleadoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcProveedorEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLMotivoEntrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcMotivoDevEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAgregarEntrega)
                    .addComponent(jBEditarEntrega)
                    .addComponent(jBEliminarEntrega))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Para cuando se cambia a esta ventana
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        entrega.consultaEntregas(conexion, jTEntregas);
        entrega.cargaNombreEmpleados(conexion, jcEmpleadoEntrega);
        entrega.cargaNombreProveedores(conexion, jcProveedorEntrega);
        entrega.cargaMotivoDevoluciones(conexion, jcMotivoDevEntrega);
        resetControles();
    }//GEN-LAST:event_formWindowOpened

    private void jBEliminarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarEntregaActionPerformed
        // TODO add your handling code here:
        entrega.eliminaEntrega(conexion);
        entrega.consultaEntregas(conexion, jTEntregas);
        resetControles();

    }//GEN-LAST:event_jBEliminarEntregaActionPerformed

    private void jBAgregarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarEntregaActionPerformed
        // TODO add your handling code here:
        int idProveedor = ((Item) jcProveedorEntrega.getSelectedItem()).getId();
        int idDevolucion = ((Item) jcMotivoDevEntrega.getSelectedItem()).getId();
        int idEmpleado = ((Item) jcEmpleadoEntrega.getSelectedItem()).getId();
        LocalDate fecha = jDtFechaEntrega.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        entrega.insertaEntrega(conexion, idProveedor, idDevolucion, idEmpleado, fecha);
        entrega.consultaEntregas(conexion, jTEntregas);
        resetControles();
    }//GEN-LAST:event_jBAgregarEntregaActionPerformed

    private void jBEditarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarEntregaActionPerformed
        // TODO add your handling code here:
        int idProveedor = ((Item) jcProveedorEntrega.getSelectedItem()).getId();
        int idDevolucion = ((Item) jcMotivoDevEntrega.getSelectedItem()).getId();
        int idEmpleado = ((Item) jcEmpleadoEntrega.getSelectedItem()).getId();
        LocalDate fecha = jDtFechaEntrega.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        entrega.modificaEntrega(conexion, idProveedor, idDevolucion, idEmpleado, fecha);
        entrega.consultaEntregas(conexion, jTEntregas);
        resetControles();

    }//GEN-LAST:event_jBEditarEntregaActionPerformed

    public void asignaConexion(Connection connection) {
        this.conexion = connection;
    }
    
    public void resetControles(){
        jcProveedorEntrega.setSelectedItem(null);
        jcMotivoDevEntrega.setSelectedItem(null);
        jcEmpleadoEntrega.setSelectedItem(null);
        jDtFechaEntrega.setDate(null);
    }
    
    private void jTEntregasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEntregasMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        entrega.setIdEntrega(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));
        jcProveedorEntrega.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 1).toString())));
        jcEmpleadoEntrega.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 2).toString())));
        jcMotivoDevEntrega.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 3).toString())));

        try {
            jDtFechaEntrega.setDate((java.util.Date) simpleDateFormat.parse(source.getModel().getValueAt(row, 4).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(jfVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTEntregasMouseClicked
    
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
            java.util.logging.Logger.getLogger(jfEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new jfEntrega().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarEntrega;
    private javax.swing.JButton jBEditarEntrega;
    private javax.swing.JButton jBEliminarEntrega;
    private org.jdesktop.swingx.JXDatePicker jDtFechaEntrega;
    private javax.swing.JLabel jLEmpleadoEntrega;
    private javax.swing.JLabel jLMotivoEntrega;
    private javax.swing.JLabel jLProveedorEntrega;
    private javax.swing.JLabel jLProveedorEntrega1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTEntregas;
    private javax.swing.JComboBox<String> jcEmpleadoEntrega;
    private javax.swing.JComboBox<String> jcMotivoDevEntrega;
    private javax.swing.JComboBox<String> jcProveedorEntrega;
    // End of variables declaration//GEN-END:variables
}
