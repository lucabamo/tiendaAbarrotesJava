/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Sonia Hernandez
 */
public class DetalleCompra {
    
    Connection conexion = null;
    private String Qry;
    private PreparedStatement pt;
    
    public DetalleCompra(Connection con)
    {
        conexion = con;
    }
    
    public void InsertaDetalleCompra(String IdCompra, String IdProducto, String cantidad, String subtotal)
    {
        Qry = "INSERT INTO Transaccion.DetalleCompra (IdCompra, IdProducto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdCompra));
            pt.setInt(2, Integer.parseInt(IdProducto));
            pt.setInt(3, Integer.parseInt(cantidad));
            pt.setFloat(4, Float.parseFloat(subtotal));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void ModificaDetalleCompra(String IdCompra, String IdProducto, String cantidad, String subtotal, String IdDetalleCompra)
    {
        Qry = "UPDATE Transaccion.DetalleCompra SET IdCompra = ?, IdProducto = ?, Cantidad = ?, Subtotal = ? WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdCompra));
            pt.setInt(2, Integer.parseInt(IdProducto));
            pt.setInt(3, Integer.parseInt(cantidad));
            pt.setFloat(4, Float.parseFloat(subtotal));
            pt.setInt(5, Integer.parseInt(IdDetalleCompra));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void EliminaDetalleCompra(String IdDetalleCompra)
    {
        Qry = "DELETE FROM Transaccion.DetalleCompra WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdDetalleCompra));
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
}
