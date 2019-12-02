/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TiendaAbarrotes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXDatePicker;
import static org.postgresql.util.ByteConverter.float8;

/**
 *
 * @author Luis Bacasehua
 */
public class Entrega {

    /*
        Declaración de variables globales
     */
    private int idEntrega;
    private PreparedStatement preparedStatement;

    //Constructor de la clase
    public Entrega() {
        idEntrega = -1;
    }

    /*
        Consulta el nombre y id del empleado y los agrega al combo box
     */
    public void cargaNombreEmpleados(Connection conexion, JComboBox empleados) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT Nombre, idEmpleado FROM Empresa.Empleado";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//nombre
                auxiliar[1] = resultSet.getString(2);//id
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            empleados.setModel(modelo);
        } catch (SQLException ex) {
            //javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    /*
      Consulta el nombre y id del proveedor y los agrega al combo box
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
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            proveedores.setModel(modelo);
        } catch (SQLException ex) {
            // javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        carga las devoluciones que aun no han sido entregadas en el comboBox
    */
    public void cargaMotivoDevoluciones(Connection conexion, JComboBox devoluciones) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT detalle.IdDevolucion, producto.Nombre, devolucion.Motivo "
                    + "FROM Transaccion.DetalleDevolucion AS detalle "
                    + "INNER JOIN Inventario.Producto AS producto ON producto.IdProducto = detalle.IdProducto "
                    + "INNER JOIN Transaccion.Devolucion AS devolucion ON devolucion.IdDevolucion = detalle.IdDevolucion "
                    + "AND devolucion.Entregada = false";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[3];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//id
                auxiliar[1] = resultSet.getString(2);//nombre producto
                auxiliar[2] = resultSet.getString(3);//motivo
                modelo.addElement(new Item(Integer.parseInt(auxiliar[0]), auxiliar[1] + "_" + auxiliar[2]));
            }
            devoluciones.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        consulta las entregas y las agrega a la tabla
    */
    public void consultaEntregas(Connection conexion, JTable entregas) {
        //obtenUltimaEntrega(conexion);
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdEntrega");
        modelo.addColumn("IdProveedor");
        modelo.addColumn("IdEmpleado");
        modelo.addColumn("IdDevolucion");
        modelo.addColumn("FechaEntrega");

        try {
            String query = "SELECT * FROM Transaccion.Entrega ORDER BY IdEntrega";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[5];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1); //id entrega
                auxiliar[1] = resultSet.getString(2); // id proveedor
                auxiliar[2] = resultSet.getString(3); //id empleado
                auxiliar[3] = resultSet.getString(4); //id devolucion
                auxiliar[4] = resultSet.getString(5); //fecha entrega
                modelo.addRow(auxiliar);
            }
            entregas.setModel(modelo);
        } catch (SQLException ex) {
            // javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        Agrega una nueva entrega.
        Recibe la conexion, el id del proveedor, id devolucion, id del empleado y la fecha de entrega
    */
    public void insertaEntrega(Connection conexion, int idProveedor, int idDevolucion, int idEmpleado, LocalDate fechaEntrega) {
        String query = "INSERT INTO Transaccion.Entrega (idProveedor, idEmpleado, idDevolucion ,fechaEntrega) VALUES (?,?,?,?)";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idProveedor);
            preparedStatement.setInt(2, idEmpleado);
            preparedStatement.setInt(3, idDevolucion);
            preparedStatement.setDate(4, Date.valueOf(fechaEntrega));
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
                modificaInventario(conexion, obtenUltimaEntrega(conexion));
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al insertar el registro");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al insertar el registro");
        }
    }

    /*
        Obtiene la ultima entrega y regresa su id
    */
    private int obtenUltimaEntrega(Connection conexion) {
        String SQL = "SELECT IdEntrega FROM Transaccion.Entrega ORDER BY IdEntrega DESC";
        int idEntrega = 0;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            idEntrega = rs.getInt(1);
        } catch (SQLException ex) {
            //javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
        return idEntrega;
    }

    /*
        Modifica las existencias del inventario.
        Recibe la conexion y el id de la ultima entrega
    */
    private void modificaInventario(Connection conexion, int idUltimaEntrega) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdProducto");
        modelo.addColumn("Existencia");
        modelo.addColumn("Cantidad");
        modelo.addColumn("IdEntrega");

        try {
            String query = "SELECT producto.IdProducto, producto.Existencia, detalle.Cantidad, entrega.IdEntrega FROM Inventario.Producto AS producto "
                    + "INNER JOIN Transaccion.DetalleDevolucion AS detalle ON detalle.IdProducto = producto.IdProducto "
                    + "INNER JOIN Transaccion.Entrega AS entrega ON entrega.IdDevolucion = detalle.IdDevolucion "
                    + "AND entrega.IdEntrega = " + idUltimaEntrega;
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[4];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getInt(1);// id producto
                auxiliar[1] = resultSet.getInt(2);// existencia
                auxiliar[2] = resultSet.getInt(3);// cantidad
                auxiliar[3] = resultSet.getInt(4);// id de la entrega
                modelo.addRow(auxiliar);
            }
            int rows = modelo.getRowCount();
            for (int i = 0; i < rows; i++) {
                int idProducto = (int) modelo.getValueAt(i, 0);
                int existencia = (int) modelo.getValueAt(i, 1);
                int cantidad = (int) modelo.getValueAt(i, 2);
                int cantidadActual = existencia - cantidad;
                actualizaProducto(conexion, idProducto, cantidadActual);
            }
        } catch (SQLException ex) {
            // javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        actualiza un producto con su nueva exitencia
    */
    private void actualizaProducto(Connection conexion, int idProducto, int existencia) {

        String query = "UPDATE Inventario.Producto SET Existencia = ? WHERE idProducto = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, existencia);
            preparedStatement.setInt(2, idProducto);
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente existencias en productos");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar existencias en productos");
            }
        } catch (Exception ex) {
            //javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        Modifica una nueva entrega
        Recibe la conexion, el id del proveedor, el id de la devolucion, el id del empleado y la fecha de entrega
    */
    public void modificaEntrega(Connection conexion, int idProveedor, int idDevolucion, int idEmpleado, LocalDate fechaEntrega) {
        String query = "UPDATE Transaccion.Entrega SET idProveedor = ?, idDevolucion = ?, idEmpleado = ?, fechaEntrega = ? WHERE idEntrega = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idProveedor);
            preparedStatement.setInt(2, idDevolucion);
            preparedStatement.setInt(3, idEmpleado);
            preparedStatement.setDate(4, Date.valueOf(fechaEntrega));
            preparedStatement.setInt(5, getIdEntrega());
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al modificar");
        }
    }

    /*
        Elimina una entrega
    */
    public void eliminaEntrega(Connection conexion) {
        String query = "DELETE FROM Transaccion.Entrega WHERE IdEntrega = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdEntrega());
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");
        }
    }

    /*
        Getters y setters
    */
    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

}
