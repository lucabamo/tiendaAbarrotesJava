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
import javax.swing.DefaultCellEditor;
import javax.swing.JPasswordField;
import javax.swing.JTable;

/**
 *
 * @author Sonia Hernandez
 */
public class JFEmpleado extends javax.swing.JFrame {

    /*
        Declaracion de variables globales
    */
    private Connection conexion = null;
    private Empleado empleado;
    private DefaultTableModel modelo;
    private Statement st;
    private ResultSet rs;
    private String Qry;
    private String idRow;
    
    //Constructor de la clase
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
        dpFechaNacEmpleado = new org.jdesktop.swingx.JXDatePicker();
        tfContrasenaEmpleado = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbNombreEmpleado.setText("Nombre:");

        lbDomicilioEmpleado.setText("Domicilio:");

        lbFechaNacEmpleado.setText("Fecha nacimiento:");

        btInsertarEmpleado.setText("Insertar");
        btInsertarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarEmpleadoActionPerformed(evt);
            }
        });

        btModificarEmpleado.setText("Modificar");
        btModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarEmpleadoActionPerformed(evt);
            }
        });

        btEliminarEmpleado.setText("Eliminar");
        btEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarEmpleadoActionPerformed(evt);
            }
        });

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

        lbUsuarioEmpleado.setText("Usuario:");

        lbContrasenaEmpleado.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNombreEmpleado, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbFechaNacEmpleado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDomicilioEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfDomicilioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbUsuarioEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbContrasenaEmpleado)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsuarioEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(tfContrasenaEmpleado)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btInsertarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btModificarEmpleado)
                        .addGap(81, 81, 81)
                        .addComponent(btEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombreEmpleado)
                            .addComponent(tfNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaNacEmpleado)
                            .addComponent(dpFechaNacEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUsuarioEmpleado)
                            .addComponent(tfUsuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbContrasenaEmpleado)
                            .addComponent(tfContrasenaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDomicilioEmpleado)
                    .addComponent(tfDomicilioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btInsertarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btModificarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        Metodo del boton insertar.
        Recupera la informacion de los controles y manda a llamar al metodo insertarEmpleado.
        Actualiza la tabla
    */
    private void btInsertarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarEmpleadoActionPerformed
        LocalDate fecha = dpFechaNacEmpleado.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        empleado.InsertaEmpleado(conexion, tfNombreEmpleado.getText(), tfDomicilioEmpleado.getText(), fecha, tfUsuarioEmpleado.getText(), new String(tfContrasenaEmpleado.getPassword()));
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btInsertarEmpleadoActionPerformed

    /*
        Metodo del boton modificar.
        Recupera la informacion de los controles y manda a llamar al metodo modificaEmpleado.
        Actualiza la tabla
    */
    private void btModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarEmpleadoActionPerformed
        LocalDate fecha = dpFechaNacEmpleado.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        empleado.ModificaEmpleado(conexion, tfNombreEmpleado.getText(), tfDomicilioEmpleado.getText(), fecha, tfUsuarioEmpleado.getText(), new String(tfContrasenaEmpleado.getPassword()), idRow);
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btModificarEmpleadoActionPerformed

    /*
        Metodo del boton Eliminar.
        manda a llamar al metodo eliminaEmpleado.
        Actualiza la tabla
    */
    private void btEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarEmpleadoActionPerformed
        empleado.EliminaEmpleado(conexion);
        ActualizaTablaEmpleado();
        resetControles();
    }//GEN-LAST:event_btEliminarEmpleadoActionPerformed

    /*
        Metodo que se activa cuando das click en la tabla.
        Recupera la informacion del registro y la carga en los controles
    */
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

    /*
        Resetea los controles
    */
    public void resetControles(){

        tfNombreEmpleado.setText("");
        tfDomicilioEmpleado.setText("");
        tfUsuarioEmpleado.setText("");
        tfContrasenaEmpleado.setText("");
        dpFechaNacEmpleado.setDate(null);

    }
    
    /*
        Metodo que se activa al abrir la venta.
        Actualiza la tabla.
    */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Date fecha = new Date(2000, 01, 01);
        dpFechaNacEmpleado.setDate(fecha);
        ActualizaTablaEmpleado();
    }//GEN-LAST:event_formWindowOpened

    //Asigna la conexion
    public void AsignaConexion(Connection con)
    {
        conexion = con;
    }
    
    //Actualiza la tabla 
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
    private javax.swing.JPasswordField tfContrasenaEmpleado;
    private javax.swing.JTextField tfDomicilioEmpleado;
    private javax.swing.JTextField tfNombreEmpleado;
    private javax.swing.JTextField tfUsuarioEmpleado;
    // End of variables declaration//GEN-END:variables
}
