/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karla Rosas
 */
public class Proveedor {

    private int idProveedor;
    private PreparedStatement preparedStatement;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor() {
        this.idProveedor = -1;
    }

    public void seleccionaProveedores(Connection conexion, JTable proveedores) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdProveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Email");
        modelo.addColumn("RFC");
        modelo.addColumn("Domicilio Fiscal");

        try {
            String query = "SELECT * FROM Empresa.Proveedor ORDER BY IdProveedor";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[6];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                auxiliar[3] = resultSet.getString(4);
                auxiliar[4] = resultSet.getString(5);
                auxiliar[5] = resultSet.getString(6);
                modelo.addRow(auxiliar);
            }
            proveedores.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    public void agregaProveedor(Connection conexion, String nombre, String telefono, String email, String rfc, String domicilioFiscal) {
        String query = "INSERT INTO Empresa.Proveedor(Nombre, Telefono, Email, RFC, DomicilioFiscal) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, rfc);
            preparedStatement.setString(5, domicilioFiscal);
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
        }
    }

    public void modificaProveedor(Connection conexion, String nombre, String telefono, String email, String rfc, String domicilioFiscal) {
        String query = "UPDATE Empresa.Proveedor SET Nombre = ?, Telefono = ?, Email = ?, RFC = ?, DomicilioFiscal = ? WHERE IdProveedor = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, rfc);
            preparedStatement.setString(5, domicilioFiscal);
            preparedStatement.setInt(6, getIdProveedor());
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación");
        }
    }

    public void eliminaProveedor(Connection conexion) {
        String query = "DELETE FROM Empresa.Proveedor WHERE IdProveedor = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdProveedor());
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
    }

}
