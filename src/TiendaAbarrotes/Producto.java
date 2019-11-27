/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Sonia Hernandez
 */
public class Producto {
    
    private String Qry;
    private PreparedStatement pt;
    private int idProducto;
    
    public Producto(Connection con)
    {
        idProducto = -1;
    }
    
    public int getIdProducto(){
        return idProducto;
    }
    
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }
    
    public void InsertaProducto(Connection conexion, String nombre, String existencia, String costoProv, String costoVenta)
    {
        Qry = "INSERT INTO Inventario.Producto (Nombre, Existencia, CostoProveedor, CostoVenta) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setString(1, nombre);
            pt.setInt(2, Integer.parseInt(existencia));
            pt.setFloat(3, Float.parseFloat(costoProv));
            pt.setFloat(4, Float.parseFloat(costoVenta));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void ModificaProducto(Connection conexion, String nombre, String existencia, String costoProv, String costoVenta, String IdProducto)
    {
        Qry = "UPDATE Inventario.Producto SET Nombre = ?, Existencia = ?, CostoProveedor = ?, CostoVenta = ? WHERE IdProducto = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setString(1, nombre);
            pt.setInt(2, Integer.parseInt(existencia));
            pt.setFloat(3, Float.parseFloat(costoProv));
            pt.setFloat(4, Float.parseFloat(costoVenta));
            pt.setInt(5, getIdProducto());
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se edito correctamente.");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la edición");
        }
    }
    
    public void EliminaProducto(Connection conexion, String IdProducto)
    {
        Qry = "DELETE FROM Inventario.Producto WHERE IdProducto = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, getIdProducto());
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
                 JOptionPane.showMessageDialog(null, "Error al eliminar.");           
        }
    }
    
}
