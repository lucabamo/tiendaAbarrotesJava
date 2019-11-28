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
    
    private int idEmpleado;
    private String Qry;
    private PreparedStatement pt;
    private PreparedStatement preparedStatement;

    public Empleado(Connection con)
    {
        idEmpleado = -1;
    }
    
    public void InsertaEmpleado(Connection conexion, String nombre, String domicilio, LocalDate fecha,String usuario, String contraseña)
    {
        //INSERT INTO Empresa.Empleado (Nombre, Domicilio, FechaNac, Edad, Usuario, Contrasenia) VALUES ('Luis', 'calle', '10-09-2019',NULL, 'yes', 'pass')
        String query = "INSERT INTO Empresa.Empleado (Nombre, Domicilio, FechaNac, Edad, Usuario, Contrasenia) VALUES (?, ?, ?,NULL, ?, ?)";
        try {
            pt = conexion.prepareCall(query);
            pt.setString(1, nombre);
            pt.setString(2, domicilio);
            pt.setDate(3, Date.valueOf(fecha));
            pt.setString(4, usuario);
            pt.setString(5, contraseña);   
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error en la inserción");
            }
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la inserción" + ex.getLocalizedMessage());
        }
    }
    
    public void ModificaEmpleado(Connection conexion, String nombre, String domicilio, LocalDate fecha,String usuario, String contraseña, String IdEmpleado)
    {
        String query = "UPDATE Empresa.Empleado SET Nombre = ?, Domicilio = ?, FechaNac = ?, Edad = ?, Usuario = ?, Contrasenia = ? WHERE IdEmpleado = ?";
        try {
            pt = conexion.prepareCall(query);
            pt.setString(1, nombre);
            pt.setString(2, domicilio);
            pt.setDate(3, Date.valueOf(fecha));
            pt.setString(5, usuario);
            pt.setString(6, contraseña);
            pt.setInt(7, getIdEmpleado());
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico correctamente.");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());            
        }
    }
    
    public void EliminaEmpleado(Connection conexion)
    {
        String query = "DELETE FROM Empresa.Empleado WHERE IdEmpleado = ?";
        try {
            pt = conexion.prepareCall(query);
            pt.setInt(1, getIdEmpleado());
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpledo) {
        this.idEmpleado = idEmpledo;
    }
    
}
