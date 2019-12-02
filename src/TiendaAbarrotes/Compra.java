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
public class Compra {

    /*
        Declaración de variables globales
     */
    private String Qry;
    private PreparedStatement pt;
    private int idCompra; //Id del registro de compra

    /*
        Constructor de la clase Compra
     */
    public Compra(Connection con) {
        idCompra = -1;
    }

    /*
        Método para Insertar una compra.
        Recibe la conexión, el id del provedor, el id del empleado, la fecha y el total
     */
    public void InsertaCompra(Connection conexion, int idProveedor, int idEmpleado, LocalDate fecha, float total) {
        Qry = "INSERT INTO Transaccion.Compra (IdProveedor, IdEmpleado, Fecha, Total) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, idProveedor);
            pt.setInt(2, idEmpleado);
            pt.setDate(3, Date.valueOf(fecha));
            pt.setFloat(4, total);
            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
        }
    }

    /*
        Método para Modificar una compra.
        Recibe la conexión, el id del proveedor, el id del empleado, la fecha, el total y el id de la compra
     */
    public void ModificaCompra(Connection conexion, int idProveedor, int idEmpleado, LocalDate fecha, float total, String IdCompra) {
        Qry = "UPDATE Transaccion.Compra SET IdProveedor = ?, IdEmpleado = ?, Fecha = ?, Total = ? WHERE IdCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, idProveedor);
            pt.setInt(2, idEmpleado);
            pt.setDate(3, Date.valueOf(fecha));
            pt.setFloat(4, total);
            pt.setInt(5, getIdCompra());

            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación.");
        }
    }

    /*
        Método para eliminar la compra.
        Recibe la conexion y el id de la compra
     */
    public void EliminarCompra(Connection conexion, String IdCompra) {
        String query = "DELETE FROM Transaccion.Compra WHERE IdCompra = ?";
        try {
            pt = conexion.prepareCall(query);
            pt.setInt(1, getIdCompra());
            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar.");
        }
    }

    /*
        Carga el ComboBox con el nombre del empleado y el id del mismo.
        Recibe la conexión y el comboBox a llenar.
    */
    public void cargaNombreEmpleados(Connection conexion, JComboBox empleados) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT Nombre, idEmpleado FROM Empresa.Empleado";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1); //nombre
                auxiliar[1] = resultSet.getString(2); //id
                //Convierte el resultado a un Objeto de la clase Item
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            empleados.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    /*
        Carga el ComboBox con el nombre del proveedor y el id del mismo.
        Recibe la conexión y el comboBox a llenar.
    */
    public void cargaNombreProveedores(Connection conexion, JComboBox proveedores) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT Nombre, idProveedor FROM Empresa.Proveedor";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//nombre
                auxiliar[1] = resultSet.getString(2);//id
                //Convierte el resultado a un Objeto de la clase Item
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            proveedores.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    /*
        Setters y Getters
    */
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
}
