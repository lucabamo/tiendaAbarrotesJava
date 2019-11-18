/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karla Rosas
 */
public class Proveedor {
    
    private int idProveedor;
    
    public Proveedor(){
        this.idProveedor = -1;
    }
    
    public void seleccionaProveedores(Connection conexion, JTable proveedores){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdProveedor");     
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Email");
        modelo.addColumn("RFC");
        modelo.addColumn("Domicilio Fiscal");
       
        
        try{
            String query = "SELECT * FROM Transaccion.DetalleVenta";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[6];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                auxiliar[3] = resultSet.getString(4);
                auxiliar[4] = resultSet.getString(5);
                auxiliar[5] = resultSet.getString(6);
                modelo.addRow(auxiliar);
            }
           proveedores.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
}
