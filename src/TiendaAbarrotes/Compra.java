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
public class Compra {
    
    Connection conexion = null;
    private String Qry;
    private PreparedStatement pt;
    
    public Compra(Connection con)
    {
        conexion = con;
    }
    
    public void InsertaCompra(String idProveedor, String idEmpleado, Date fecha, String total)
    {
        Qry = "INSERT INTO Transaccion.Compra (IdProveedor, IdEmpleado, Fecha, Total) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(idProveedor));
            pt.setInt(2, Integer.parseInt(idEmpleado));
            pt.setDate(3, fecha);
            pt.setFloat(4, Float.parseFloat(total));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void ModificaCompra(String idProveedor, String idEmpleado, Date fecha, String total, String IdCompra)
    {
        Qry = "UPDATE Transaccion.Compra SET IdProveedor = ?, IdEmpleado = ?, Fecha = ?, Total = ? WHERE IdCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(idProveedor));
            pt.setInt(2, Integer.parseInt(idEmpleado));
            pt.setDate(3, fecha);
            pt.setFloat(4, Float.parseFloat(total));
            pt.setInt(5, Integer.parseInt(IdCompra));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void EliminarCompra(String IdCompra)
    {
        Qry = "DELETE FROM Empresa.Empleado WHERE IdCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdCompra));
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
}
