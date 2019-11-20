/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.math.BigDecimal;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Karla Rosas
 */
public class DetalleVenta {

    private int idDetalleVenta;
    private PreparedStatement preparedStatement;

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public DetalleVenta() {
        this.idDetalleVenta = -1;
    }

    public void seleccionaDetallesVenta(Connection conexion, JTable detallesVenta) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdVenta");
        modelo.addColumn("IdPromocion");
        modelo.addColumn("IdProducto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("SubTotal");

        try {
            String query = "SELECT * FROM Transaccion.DetalleVenta";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[5];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                auxiliar[3] = resultSet.getString(4);
                BigDecimal bd = new BigDecimal(Float.toString(resultSet.getFloat(4)));
                bd = bd.setScale(2, BigDecimal.ROUND_CEILING);
                auxiliar[4] = bd.floatValue();
                modelo.addRow(auxiliar);
            }
            detallesVenta.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void seleccionaVentas(Connection conexion, JComboBox ventas) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT IdVenta FROM Transaccion.Venta";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                modelo.addElement(auxiliar[0]);
            }
            ventas.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void seleccionaProductos(Connection conexion, JComboBox productos) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT Nombre, IdProducto FROM Inventario.Producto";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            productos.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void seleccionaPromocion(Connection conexion, JComboBox empleados) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT IdPromocion FROM Transaccion.Promocion";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                modelo.addElement(auxiliar[0]);
            }
            empleados.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void agregaDetalleVenta(Connection conexion, int idVenta, int idPromocion, int idProducto, int cantidad, float subtotal) {
        String query = "INSERT INTO Transaccion.DetalleVenta (IdVenta, IdPromocion,IdProducto,Cantidad, SubTotal) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idVenta);
            preparedStatement.setInt(2, idPromocion);
            preparedStatement.setInt(3, idProducto);
            preparedStatement.setInt(4, cantidad);
            preparedStatement.setFloat(5, subtotal);
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
