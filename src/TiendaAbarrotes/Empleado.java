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
    
    /*
        Declaración de variables
    */
    private int idEmpleado;
    private String Qry;
    private PreparedStatement pt;
    private PreparedStatement preparedStatement;

    //Constructor de la clase
    public Empleado(Connection con)
    {
        idEmpleado = -1;
    }
    
    /*
        Inserta un nuevo empleado.
        Recibe la conexion, el nombre, domicilio, la fecha, usuario y contraseña
    */
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
            JOptionPane.showMessageDialog(null, "Error en la inserción" + ex.getLocalizedMessage());
        }
    }
    
    /*
        Modifica empleado.
        Recibe la conexion, el nombre, domicilio, la fecha, usuario y contraseña
    */
    public void ModificaEmpleado(Connection conexion, String nombre, String domicilio, LocalDate fecha,String usuario, String contraseña, String IdEmpleado)
    {
        String query = "UPDATE Empresa.Empleado SET Nombre = ?, Domicilio = ?, FechaNac = ?, Usuario = ?, Contrasenia = ? WHERE IdEmpleado = ?";
        try {
            pt = conexion.prepareCall(query);
            pt.setString(1, nombre);
            pt.setString(2, domicilio);
            pt.setDate(3, Date.valueOf(fecha));
            pt.setString(4, usuario);
            pt.setString(5, contraseña);
            pt.setInt(6, getIdEmpleado());
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico correctamente.");
            }
        }
        catch(Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error en la modificación");
        }
    }
    
    /*
       Elimina un empleado
    */
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
            javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación");
        }
    }

    /*
        Getters y setters
    */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpledo) {
        this.idEmpleado = idEmpledo;
    }
    
}
