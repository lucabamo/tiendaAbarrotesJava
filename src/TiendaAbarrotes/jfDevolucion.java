/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.text.DateFormat;
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
public class jfDevolucion extends javax.swing.JFrame {

    /**
     * Creates new form jfDevolucion
     */
     private Connection conexion = null;
     private float monto = 0.0f;
    Devolucion devolucion;


    
    public jfDevolucion() {
        initComponents();
        devolucion = new Devolucion();
    }

    public void asignaConexion(Connection connection){
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

        jCEmpleadoDevolucion = new javax.swing.JComboBox<>();
        jCVentaDevolucion = new javax.swing.JComboBox<>();
        jtfMotivoDevolucionDev = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBAgregarDevolucion = new javax.swing.JButton();
        jBEditarDevolucion = new javax.swing.JButton();
        jBEliminarDevolucion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDevoluciones = new javax.swing.JTable();
        jDtFechaDevolucionDev = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Empleado");

        jLabel2.setText("Venta");

        jLabel3.setText("Motivo Devolución");

        jBAgregarDevolucion.setText("Agregar");
        jBAgregarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarDevolucionActionPerformed(evt);
            }
        });

        jBEditarDevolucion.setText("Editar");
        jBEditarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarDevolucionActionPerformed(evt);
            }
        });

        jBEliminarDevolucion.setText("Eliminar");
        jBEliminarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarDevolucionActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha devolución");

        jTDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDevolucionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDevoluciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfMotivoDevolucionDev, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jBAgregarDevolucion)
                        .addGap(26, 26, 26)
                        .addComponent(jBEditarDevolucion)
                        .addGap(18, 18, 18)
                        .addComponent(jBEliminarDevolucion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCEmpleadoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jCVentaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDtFechaDevolucionDev, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCEmpleadoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCVentaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDtFechaDevolucionDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMotivoDevolucionDev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAgregarDevolucion)
                    .addComponent(jBEditarDevolucion)
                    .addComponent(jBEliminarDevolucion))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento cuando se abre la ventana
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        devolucion.consultaDevoluciones(conexion, jTDevoluciones);
        devolucion.cargaNombreEmpleados(conexion, jCEmpleadoDevolucion);
        devolucion.cargaIdVentasVentas(conexion, jCVentaDevolucion);
        resetControles();
    }//GEN-LAST:event_formWindowOpened

    private void jBAgregarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarDevolucionActionPerformed
        // TODO add your handling code here:
        int idVenta = Integer.parseInt(jCVentaDevolucion.getSelectedItem().toString());
        int idEmpleado = ((Item) jCEmpleadoDevolucion.getSelectedItem()).getId();
        LocalDate fecha = jDtFechaDevolucionDev.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        float monto = 0.0f;
        devolucion.agregaDevolucion(conexion, idEmpleado, idVenta, fecha, jtfMotivoDevolucionDev.getText(), monto);
        devolucion.consultaDevoluciones(conexion, jTDevoluciones);
        resetControles();
        //resetControles();
    }//GEN-LAST:event_jBAgregarDevolucionActionPerformed

    private void jTDevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDevolucionesMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        devolucion.setIdDevolucion(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));

        jCEmpleadoDevolucion.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 1).toString())));
        jCVentaDevolucion.setSelectedItem(source.getModel().getValueAt(row, 2).toString());
        try {
            jDtFechaDevolucionDev.setDate((java.util.Date) simpleDateFormat.parse(source.getModel().getValueAt(row, 3).toString()));
        } 
        catch (ParseException ex) {
            Logger.getLogger(jfVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtfMotivoDevolucionDev.setText(source.getModel().getValueAt(row, 4).toString());
        monto = Float.parseFloat(source.getModel().getValueAt(row, 5).toString());
    }//GEN-LAST:event_jTDevolucionesMouseClicked

    //Eliminar una devolución
    private void jBEliminarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarDevolucionActionPerformed
        // TODO add your handling code here:
        devolucion.eliminaDevolucion(conexion);
        devolucion.consultaDevoluciones(conexion, jTDevoluciones);
    }//GEN-LAST:event_jBEliminarDevolucionActionPerformed

    private void jBEditarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarDevolucionActionPerformed
        // TODO add your handling code here:
        int idVenta = Integer.parseInt(jCVentaDevolucion.getSelectedItem().toString());
        int idEmpleado = ((Item) jCEmpleadoDevolucion.getSelectedItem()).getId();
        LocalDate fecha = jDtFechaDevolucionDev.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        devolucion.modificaDevolucion(conexion, idEmpleado, idVenta, fecha, jtfMotivoDevolucionDev.getText(), monto);
        devolucion.consultaDevoluciones(conexion, jTDevoluciones);
        resetControles();
    }//GEN-LAST:event_jBEditarDevolucionActionPerformed

    
    
    public void resetControles() {
        jCEmpleadoDevolucion.setSelectedItem(null);
        jCVentaDevolucion.setSelectedItem(null);
        jDtFechaDevolucionDev.setDate(null);
        jtfMotivoDevolucionDev.setText("");
    }

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
            java.util.logging.Logger.getLogger(jfDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfDevolucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregarDevolucion;
    private javax.swing.JButton jBEditarDevolucion;
    private javax.swing.JButton jBEliminarDevolucion;
    private javax.swing.JComboBox<String> jCEmpleadoDevolucion;
    private javax.swing.JComboBox<String> jCVentaDevolucion;
    private org.jdesktop.swingx.JXDatePicker jDtFechaDevolucionDev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDevoluciones;
    private javax.swing.JTextField jtfMotivoDevolucionDev;
    // End of variables declaration//GEN-END:variables
}
