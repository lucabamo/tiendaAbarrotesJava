/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author Sonia Hernandez
 */
public class Empleado {
    
    public Connection conexion = null;
    private String Qry;
    private PreparedStatement pt;
    
    public Empleado(Connection con)
    {
        conexion = con;
    }
    
    public void InsertaEmpleado(String nombre, String domicilio, Date fecha, String edad, String usuario, String contraseña)
    {
        Qry = "INSERT INTO Empresa.Empleado (Nombre, Domicilio, FechaNac, Edad, Usuario, Contrasenia) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setString(1, nombre);
            pt.setString(2, domicilio);
            pt.setDate(3, fecha);
            pt.setInt(4, Integer.parseInt(edad));
            pt.setString(5, usuario);
            pt.setString(6, contraseña);
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void ModificaEmpleado(String nombre, String domicilio, Date fecha, String edad, String usuario, String contraseña, String IdEmpleado)
    {
        Qry = "UPDATE Empresa.Empleado SET Nombre = ?, Domicilio = ?, FechaNac = ?, Edad = ?, Usuario = ?, Contrasenia = ? WHERE IdEmpleado = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setString(1, nombre);
            pt.setString(2, domicilio);
            pt.setDate(3, fecha);
            pt.setInt(4, Integer.parseInt(edad));
            pt.setString(5, usuario);
            pt.setString(6, contraseña);
            pt.setInt(7, Integer.parseInt(IdEmpleado));
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
    public void EliminaEmpleado(String IdEmpleado)
    {
        Qry = "DELETE FROM Empresa.Empleado WHERE IdEmpleado = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, Integer.parseInt(IdEmpleado));
            int registro = pt.executeUpdate();
            if(registro > 0) {
                //JOptionPane.showMessageDialog(this, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
            
        }
    }
    
}
