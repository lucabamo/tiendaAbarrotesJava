/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
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
 * @author Sonia Hernandez
 */
public class JFEmpleado extends javax.swing.JFrame {

    private Connection conexion = null;
    private Empleado empleado;
    private DefaultTableModel modelo;
    private Statement st;
    private ResultSet rs;
    private String Qry;
    private String idRow;
    
    public JFEmpleado() {
        initComponents();
        empleado = new Empleado(conexion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNombreEmpleado = new javax.swing.JLabel();
        tfNombreEmpleado = new javax.swing.JTextField();
        lbDomicilioEmpleado = new javax.swing.JLabel();
        tfDomicilioEmpleado = new javax.swing.JTextField();
        lbFechaNacEmpleado = new javax.swing.JLabel();
        btInsertarEmpleado = new javax.swing.JButton();
        btModificarEmpleado = new javax.swing.JButton();
        btEliminarEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleado = new javax.swing.JTable();
        lbUsuarioEmpleado = new javax.swing.JLabel();
        tfUsuarioEmpleado = new javax.swing.JTextField();
        lbContrasenaEmpleado = new javax.swing.JLabel();
        tfContrasenaEmpleado = new javax.swing.JTextField();
        dpFechaNacEmpleado = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbNombreEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbNombreEmpleado.setForeground(new java.awt.Color(0, 102, 153));
        lbNombreEmpleado.setText("Nombre:");

        tfNombreEmpleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbDomicilioEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbDomicilioEmpleado.setForeground(new java.awt.Color(0, 102, 153));
        lbDomicilioEmpleado.setText("Domicilio:");

        tfDomicilioEmpleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbFechaNacEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbFechaNacEmpleado.setForeground(new java.awt.Color(0, 102, 153));
        lbFechaNacEmpleado.setText("Fecha nacimiento:");

        btInsertarEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btInsertarEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        btInsertarEmpleado.setText("Insertar");
        btInsertarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarEmpleadoActionPerformed(evt);
            }
        });

        btModificarEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btModificarEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        btModificarEmpleado.setText("Modificar");
        btModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarEmpleadoActionPerformed(evt);
            }
        });

        btEliminarEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btEliminarEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        btEliminarEmpleado.setText("Eliminar");
        btEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarEmpleadoActionPerformed(evt);
            }
        });

        tableEmpleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmpleado);

        lbUsuarioEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbUsuarioEmpleado.setForeground(new java.awt.Color(0, 102, 153));
        lbUsuarioEmpleado.setText("Usuario:");

        tfUsuarioEmpleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lbContrasenaEmpleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbContrasenaEmpleado.setForeground(new java.awt.Color(0, 102, 153));
        lbContrasenaEmpleado.setText("Contraseña:");

        tfContrasenaEmpleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfDomicilioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbDomicilioEmpleado)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbNombreEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbFechaNacEmpleado)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbUsuarioEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbContrasenaEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfContrasenaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btInsertarEmpleado)
                        .addGap(83, 83, 83)
                        .addComponent(btModificarEmpleado)
                        .addGap(81, 81, 81)
                        .addComponent(btEliminarEmpleado)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreEmpleado)
                    .addComponent(tfNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuarioEmpleado)
                    .addComponent(tfUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaNacEmpleado)
                    .addComponent(dpFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContrasenaEmpleado)
                    .addComponent(tfContrasenaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDomicilioEmpleado)
                    .addComponent(tfDomicilioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btInsertarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btModificarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInsertarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarEmpleadoActionPerformed
        LocalDate fecha = dpFechaNacEmpleado.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        empleado.InsertaEmpleado(conexion, tfNombreEmpleado.getText(), tfDomicilioEmpleado.getText(), fecha, tfUsuarioEmpleado.getText(), tfContrasenaEmpleado.getText());
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btInsertarEmpleadoActionPerformed

    private void btModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarEmpleadoActionPerformed
        LocalDate fecha = dpFechaNacEmpleado.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        empleado.ModificaEmpleado(conexion, tfNombreEmpleado.getText(), tfDomicilioEmpleado.getText(), fecha, tfUsuarioEmpleado.getText(), tfContrasenaEmpleado.getText(), idRow);
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btModificarEmpleadoActionPerformed

    private void btEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarEmpleadoActionPerformed
        empleado.EliminaEmpleado(conexion);
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btEliminarEmpleadoActionPerformed

    
    private void tableEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpleadoMouseClicked
        
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        empleado.setIdEmpleado(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));
        
        tfNombreEmpleado.setText(source.getModel().getValueAt(row, 1).toString());
        tfDomicilioEmpleado.setText(source.getModel().getValueAt(row, 2).toString());
           try {
            dpFechaNacEmpleado.setDate((java.util.Date) simpleDateFormat.parse(source.getModel().getValueAt(row, 3).toString()));
        } 
        catch (ParseException ex) {
            Logger.getLogger(jfVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfUsuarioEmpleado.setText(source.getModel().getValueAt(row, 5).toString());
        tfContrasenaEmpleado.setText(source.getModel().getValueAt(row, 6).toString()); 
    }//GEN-LAST:event_tableEmpleadoMouseClicked

    
    public void resetControles(){

        tfNombreEmpleado.setText("");
        tfDomicilioEmpleado.setText("");
        tfUsuarioEmpleado.setText("");
        tfContrasenaEmpleado.setText("");
        dpFechaNacEmpleado.setDate(null);

    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Date fecha = new Date(2000, 01, 01);
        dpFechaNacEmpleado.setDate(fecha);
        ActualizaTablaEmpleado();
    }//GEN-LAST:event_formWindowOpened

    public void AsignaConexion(Connection con)
    {
        conexion = con;
    }
    
    public void ActualizaTablaEmpleado()
    {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Edad");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        
        try {
            Qry = "SELECT * FROM Empresa.Empleado";
            st = conexion.createStatement();
            rs = st.executeQuery(Qry);
            String Aux[] = new String[7];
            while(rs.next()) {
                Aux[0] = rs.getString(1);
                Aux[1] = rs.getString(2);
                Aux[2] = rs.getString(3);
                Aux[3] = rs.getString(4);
                Aux[4] = rs.getString(5);
                Aux[5] = rs.getString(6);
                Aux[6] = rs.getString(7);
                modelo.addRow(Aux);
            }
            tableEmpleado.setModel(modelo);
        }
        catch(Exception e) {
            
        }
        
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
            java.util.logging.Logger.getLogger(JFEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarEmpleado;
    private javax.swing.JButton btInsertarEmpleado;
    private javax.swing.JButton btModificarEmpleado;
    private org.jdesktop.swingx.JXDatePicker dpFechaNacEmpleado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbContrasenaEmpleado;
    private javax.swing.JLabel lbDomicilioEmpleado;
    private javax.swing.JLabel lbFechaNacEmpleado;
    private javax.swing.JLabel lbNombreEmpleado;
    private javax.swing.JLabel lbUsuarioEmpleado;
    private javax.swing.JTable tableEmpleado;
    private javax.swing.JTextField tfContrasenaEmpleado;
    private javax.swing.JTextField tfDomicilioEmpleado;
    private javax.swing.JTextField tfNombreEmpleado;
    private javax.swing.JTextField tfUsuarioEmpleado;
    // End of variables declaration//GEN-END:variables
}
