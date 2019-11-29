/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

//import java.awt.List;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;
import static org.postgresql.util.ByteConverter.float8;

/**
 *
 * @author Sonia Hernandez
 */
public class JFCompra extends javax.swing.JFrame {

    private Connection conexion = null;
    private Compra compra;
    private DefaultTableModel modelo;
    private Statement st;
    private ResultSet rs;
    private String Qry;
    private String idRow;

    
    
    public JFCompra() {
        initComponents();
        compra = new Compra(conexion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbProveedorCompra = new javax.swing.JLabel();
        lbEmpleadoCompra = new javax.swing.JLabel();
        lbFechaCompra = new javax.swing.JLabel();
        lbTotalCompra = new javax.swing.JLabel();
        tfTotalCompra = new javax.swing.JTextField();
        btInsertarCompra = new javax.swing.JButton();
        btModificarCompra = new javax.swing.JButton();
        btEliminarCompra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompra = new javax.swing.JTable();
        cbProveedorCompra = new javax.swing.JComboBox<>();
        cbEmpleadoCompra = new javax.swing.JComboBox<>();
        dpFechaCompra = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbProveedorCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbProveedorCompra.setForeground(new java.awt.Color(0, 102, 153));
        lbProveedorCompra.setText("Proveedor:");

        lbEmpleadoCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbEmpleadoCompra.setForeground(new java.awt.Color(0, 102, 153));
        lbEmpleadoCompra.setText("Empleado:");

        lbFechaCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbFechaCompra.setForeground(new java.awt.Color(0, 102, 153));
        lbFechaCompra.setText("Fecha:");

        lbTotalCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbTotalCompra.setForeground(new java.awt.Color(0, 102, 153));
        lbTotalCompra.setText("Total:");

        tfTotalCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btInsertarCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btInsertarCompra.setForeground(new java.awt.Color(0, 153, 153));
        btInsertarCompra.setText("Insertar");
        btInsertarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertarCompraActionPerformed(evt);
            }
        });

        btModificarCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btModificarCompra.setForeground(new java.awt.Color(0, 153, 153));
        btModificarCompra.setText("Modificar");
        btModificarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarCompraActionPerformed(evt);
            }
        });

        btEliminarCompra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btEliminarCompra.setForeground(new java.awt.Color(0, 153, 153));
        btEliminarCompra.setText("Eliminar");
        btEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarCompraActionPerformed(evt);
            }
        });

        tableCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCompra);

        cbProveedorCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cbEmpleadoCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btInsertarCompra)
                        .addGap(55, 55, 55)
                        .addComponent(btModificarCompra)
                        .addGap(59, 59, 59)
                        .addComponent(btEliminarCompra))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbProveedorCompra)
                            .addComponent(lbFechaCompra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(lbEmpleadoCompra))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dpFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTotalCompra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProveedorCompra)
                    .addComponent(lbEmpleadoCompra)
                    .addComponent(cbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaCompra)
                    .addComponent(lbTotalCompra)
                    .addComponent(tfTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsertarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btModificarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInsertarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertarCompraActionPerformed
        int idProveedor = ((Item) cbProveedorCompra.getSelectedItem()).getId();
        int idEmpleado = ((Item) cbEmpleadoCompra.getSelectedItem()).getId();
        float total = Float.parseFloat(tfTotalCompra.getText());
        LocalDate fecha = dpFechaCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        compra.InsertaCompra(conexion, idProveedor, idEmpleado, fecha, total);
        resetControles();
        ActualizaTablaCompra();
    }//GEN-LAST:event_btInsertarCompraActionPerformed

    private void btModificarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarCompraActionPerformed
        int idProveedor = ((Item) cbProveedorCompra.getSelectedItem()).getId();
        int idEmpleado = ((Item) cbEmpleadoCompra.getSelectedItem()).getId();
        float total = Float.parseFloat(tfTotalCompra.getText());
        LocalDate fecha = dpFechaCompra.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        compra.ModificaCompra(conexion, idProveedor, idEmpleado, fecha, total, idRow);
        
        resetControles();
        ActualizaTablaCompra();
    }//GEN-LAST:event_btModificarCompraActionPerformed

    private void btEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarCompraActionPerformed
        compra.EliminarCompra(conexion,idRow);
        resetControles();
        ActualizaTablaCompra();
    }//GEN-LAST:event_btEliminarCompraActionPerformed

    private void tableCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCompraMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        compra.setIdCompra(Integer.parseInt(source.getModel().getValueAt(row, 0).toString()));
        cbProveedorCompra.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 1).toString())));

        cbEmpleadoCompra.setSelectedItem(new Item(Integer.parseInt(source.getModel().getValueAt(row, 2).toString())));
        try {
            dpFechaCompra.setDate((java.util.Date) simpleDateFormat.parse(source.getModel().getValueAt(row, 3).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(jfVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        tfTotalCompra.setText(source.getModel().getValueAt(row, 4).toString());
    }//GEN-LAST:event_tableCompraMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        compra.cargaNombreEmpleados(conexion, cbEmpleadoCompra);
        compra.cargaNombreProveedores(conexion, cbProveedorCompra);
        ActualizaTablaCompra();
        java.util.Date date;
        date = new java.util.Date();
        dpFechaCompra.setDate(date);
        dpFechaCompra.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

      public void resetControles(){
        cbProveedorCompra.setSelectedItem(null);
        cbEmpleadoCompra.setSelectedItem(null);
        tfTotalCompra.setText("");
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

        
   
    
    public void AsignaConexion(Connection con)
    {
        conexion = con;
    }
    
    public void ActualizaTablaCompra()
    {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Compra");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Empleado");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");
        
        try {
            Qry = "SELECT * FROM Transaccion.Compra";
            st = conexion.createStatement();
            rs = st.executeQuery(Qry);
            String Aux[] = new String[5];
            while(rs.next()) {
                Aux[0] = rs.getString(1);
                Aux[1] = rs.getString(2);
                Aux[2] = rs.getString(3);
                Aux[3] = rs.getString(4);
                Aux[4] = rs.getString(5);
                modelo.addRow(Aux);
            }
            tableCompra.setModel(modelo);
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
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEliminarCompra;
    private javax.swing.JButton btInsertarCompra;
    private javax.swing.JButton btModificarCompra;
    private javax.swing.JComboBox<String> cbEmpleadoCompra;
    private javax.swing.JComboBox<String> cbProveedorCompra;
    private org.jdesktop.swingx.JXDatePicker dpFechaCompra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEmpleadoCompra;
    private javax.swing.JLabel lbFechaCompra;
    private javax.swing.JLabel lbProveedorCompra;
    private javax.swing.JLabel lbTotalCompra;
    private javax.swing.JTable tableCompra;
    private javax.swing.JTextField tfTotalCompra;
    // End of variables declaration//GEN-END:variables
}
