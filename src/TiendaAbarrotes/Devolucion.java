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
public class Devolucion {

    /*
        Declaración de variables globales
     */
    private int idDevolucion;
    private PreparedStatement preparedStatement;

    //Constructor de la clase
    public Devolucion() {
        idDevolucion = -1;
    }
    
    /*
        Consulta las devoluciones existentes y actualiza la tabla
    */
    public void consultaDevoluciones(Connection conexion, JTable devoluciones) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdDevolucion");
        modelo.addColumn("IdEmpleado");
        modelo.addColumn("IdVenta");
        modelo.addColumn("Fecha");
        modelo.addColumn("Motivo");
        modelo.addColumn("Monto");

        try {
            String query = "SELECT * FROM Transaccion.Devolucion ORDER BY IdDevolucion";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[6];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1); //IdDevolucion
                auxiliar[1] = resultSet.getString(2); //IdEmpleado
                auxiliar[2] = resultSet.getString(3); //IdVenta
                auxiliar[3] = resultSet.getString(4); //Fecha
                auxiliar[4] = resultSet.getString(5); //Motivo
                BigDecimal bd = new BigDecimal(Float.toString(resultSet.getFloat(6)));
                bd = bd.setScale(2, BigDecimal.ROUND_CEILING);
                auxiliar[5] = bd.floatValue();
                modelo.addRow(auxiliar);
            }
            devoluciones.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        Consulta los nombres y ids de los empleados y carga el comboBox
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
                auxiliar[1] = resultSet.getString(2);//ID
                //Convierte el id y el nombre a un objeto Item para guardarlo en el comboBox
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]), auxiliar[0]));
            }
            empleados.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        Consulta las ventas y las carga en un combo box
    */    
    public void cargaIdVentasVentas(Connection conexion, JComboBox ventas) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT IdVenta FROM Transaccion.Venta";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);//id
                modelo.addElement(auxiliar[0]);
            }
            ventas.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        agtrega una nueva devolucion, recibe la conexion, el id de la venta, la fecha y el motivo
    */
    public void agregaDevolucion(Connection conexion, int idEmpleado, int idVenta, LocalDate fechaDevolucion, String motivo, float monto) {
        String query = "INSERT INTO Transaccion.Devolucion (idEmpleado, idVenta, fecha, motivo,  monto, entregada) VALUES (?,?,?,?,?,false)";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setInt(2, idVenta);
            preparedStatement.setDate(3, Date.valueOf(fechaDevolucion));
            preparedStatement.setString(4, motivo);
            preparedStatement.setFloat(5, monto);
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    /*
        modifica una devolucion, recibe la conexion, el id del empleado, el id de la venta, la fecha y el motivo
    */
    public void modificaDevolucion(Connection conexion, int idEmpleado, int idVenta, LocalDate fechaDevolucion, String motivo, float monto) {
        String query = "UPDATE Transaccion.Devolucion SET idEmpleado = ?, idVenta = ?, fecha = ?, Motivo = ? WHERE IdDevolucion = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setInt(2, idVenta);
            preparedStatement.setDate(3, Date.valueOf(fechaDevolucion));
            preparedStatement.setString(4, motivo);
            //preparedStatement.setFloat(5, monto);
            preparedStatement.setFloat(5, getIdDevolucion());

            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error en la modificación");
        }
    }
    
    /*
       elimina una devolución
    */
    public void eliminaDevolucion(Connection conexion) {
        String query = "DELETE FROM Transaccion.Devolucion WHERE IdDevolucion = ?";
        try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdDevolucion());
            int register = preparedStatement.executeUpdate();
            if (register > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación");
        }
    }

    /*
        Getters y setters
    */
    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

}
