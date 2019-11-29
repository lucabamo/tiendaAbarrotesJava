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
 * @author Karla Rosas
 */
public class Venta {
    
    private int idVenta;
    private PreparedStatement preparedStatement;
    
    public Venta(){
        idVenta= -1;
    }
    
    public void seleccionaVentas(Connection conexion, JTable ventas){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdVenta");
        modelo.addColumn("IdEmpleado");
        modelo.addColumn("Fecha Venta");
        modelo.addColumn("Total");
        
        try{
            String query = "SELECT * FROM Transaccion.Venta ORDER BY IdVenta";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[4];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                BigDecimal bd = new BigDecimal(Float.toString(resultSet.getFloat(4)));
                bd = bd.setScale(2, BigDecimal.ROUND_CEILING);
                auxiliar[3] = bd.floatValue();
                modelo.addRow(auxiliar);
            }
           ventas.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    public void seleccionaEmpleados(Connection conexion, JComboBox empleados){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String query = "SELECT Nombre, idEmpleado FROM Empresa.Empleado";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]),auxiliar[0]));
            }
           empleados.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    public void agregaVenta(Connection conexion,int idEmpleado, LocalDate fechaVenta){
        String query ="INSERT INTO Transaccion.Venta (idEmpleado, FechaVenta, Total) VALUES (?,?,?)";
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setDate(2, Date.valueOf(fechaVenta));
            preparedStatement.setFloat(3, 0);
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
        }
    }
    
    public void modificaVenta(Connection conexion,int idEmpleado, LocalDate fechaVenta){
        String query = "UPDATE Transaccion.Venta SET idEmpleado = ?, FechaVenta = ? WHERE IdVenta = ?";
         try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.setDate(2, Date.valueOf(fechaVenta));
            preparedStatement.setInt(3,getIdVenta());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación");
        }
    }
    
    public void eliminaVenta(Connection conexion)
    {
        String query ="DELETE FROM Transaccion.Venta WHERE IdVenta = ?";    
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdVenta());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }    
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
}
