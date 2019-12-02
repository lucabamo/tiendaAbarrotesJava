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
 * @author Sonia Hernandez
 */
public class DetalleCompra {

    /*
        Declaración de variables globales
     */
    Connection conexion = null;
    private String Qry;
    private PreparedStatement pt;
    private int idDetalleCompra;

    //Constructor del detalle de compra
    public DetalleCompra(Connection con) {
        idDetalleCompra = -1;
    }

    /*
        Setters y getters
     */
    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    /*
        Método que rellena el comboBox con los ids de las compras.
        Recibe la conexión y el comboBox
    */
    public void seleccionaCompras(Connection conexion, JComboBox compras) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT IdCompra FROM Transaccion.Compra";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//id
                modelo.addElement(auxiliar[0]);
            }
            compras.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        Método que rellena el comboBox con los nombres de los productos.
        Recibe la conexión y el comboBox
    */
    public void seleccionaProductos(Connection conexion, JComboBox productos) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT Nombre, IdProducto FROM Inventario.Producto";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//nombre
                auxiliar[1] = resultSet.getString(2);//id
                //Convierte la información a un objeto Item para mostrar el nombre y el id del producto
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            productos.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    /*
        Método para insertar un detalle de compra.
        Recibe la conexión, el id de la compra, el id del producto, la cantidad y el subtota
    */
    public void InsertaDetalleCompra(Connection conexion, int IdCompra, int IdProducto, int cantidad, float subtotal) {
        Qry = "INSERT INTO Transaccion.DetalleCompra (IdCompra, IdProducto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, IdCompra);
            pt.setInt(2, IdProducto);
            pt.setInt(3, cantidad);
            pt.setFloat(4, subtotal);

            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");

        }
    }

    /*
        Método para modificar un detalle de compra.
        Recibe la conexión, el id de la compra, el id del producto, la cantidad y el subtota
    */
    public void ModificaDetalleCompra(Connection conexion, int IdCompra, int IdProducto, int cantidad, float subtotal) {
        Qry = "UPDATE Transaccion.DetalleCompra SET IdCompra = ?, IdProducto = ?, Cantidad = ?, Subtotal = ? WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, IdCompra);
            pt.setInt(2, IdProducto);
            pt.setInt(3, cantidad);
            pt.setFloat(4, subtotal);
            pt.setInt(5, getIdDetalleCompra());

            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se edito correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al editar");
        }
    }
    
    /*
        Método para eliminar un detalle de compra.
        Recibe la conexión       
    */
    public void EliminaDetalleCompra(Connection conexion) {
        Qry = "DELETE FROM Transaccion.DetalleCompra WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, getIdDetalleCompra());
            int registro = pt.executeUpdate();
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación");
        }
    }
}
