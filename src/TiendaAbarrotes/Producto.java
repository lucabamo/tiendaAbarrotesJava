/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Sonia Hernandez
 */
public class Producto {
    
    Connection conexion;
    private String Qry;
    private PreparedStatement pt;
    
    public Producto(Connection con)
    {
        conexion = con;
    }
    
    public void InsertaProducto(String nombre, String existencia, String costoProv, String costoVenta)
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
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void ModificaProducto(String nombre, String existencia, String costoProv, String costoVenta, String IdProducto)
    {
        Qry = "UPDATE Inventario.Producto SET Nombre = ?, Existencia = ?, CostoProveedor = ?, CostoVenta = ? WHERE IdProducto = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setString(1, nombre);
            pt.setInt(2, Integer.parseInt(existencia));
            pt.setFloat(3, Float.parseFloat(costoProv));
            pt.setFloat(4, Float.parseFloat(costoVenta));
            pt.setInt(5, Integer.parseInt(IdProducto));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void EliminaProducto(String IdProducto)
    {
        Qry = "DELETE FROM Inventario.Producto WHERE IdProducto = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdProducto));
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
}
