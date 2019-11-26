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
    private int idEntrega;
    private PreparedStatement preparedStatement;
    
    public Entrega(){
        idEntrega = -1;
    }
    
    public void cargaNombreEmpleados(Connection conexion, JComboBox empleados){
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
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
        public void cargaNombreProveedores(Connection conexion, JComboBox proveedores){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String query = "SELECT Nombre, idProveedor FROM Empresa.Proveedor";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]),auxiliar[0]));
            }
           proveedores.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    public void cargaMotivoDevoluciones(Connection conexion, JComboBox devoluciones){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String query = "SELECT Motivo, idDevolucion FROM Transaccion.Devolucion";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]),auxiliar[0]));
            }
           devoluciones.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
        
    public void consultaEntregas(Connection conexion, JTable entregas){
            
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdEntrega");
        modelo.addColumn("IdProveedor");
        modelo.addColumn("IdEmpleado");
        modelo.addColumn("IdDevolucion");
        modelo.addColumn("FechaEntrega");
        
        try{
            String query = "SELECT * FROM Transaccion.Entrega ORDER BY IdEntrega";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[5];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                auxiliar[3] = resultSet.getString(4);
                auxiliar[4] = resultSet.getString(5);    
                modelo.addRow(auxiliar);
            }
           entregas.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void insertaEntrega(Connection conexion,int idProveedor, int idDevolucion, int idEmpleado, LocalDate fechaEntrega){
        String query ="INSERT INTO Transaccion.Entrega (idProveedor, idEmpleado, idDevolucion ,fechaEntrega) VALUES (?,?,?,?)";
            try{
                preparedStatement = conexion.prepareCall(query);
                preparedStatement.setInt(1, idProveedor);
                preparedStatement.setInt(2, idEmpleado);
                preparedStatement.setInt(3, idDevolucion);
                preparedStatement.setDate(4, Date.valueOf(fechaEntrega));
                int register = preparedStatement.executeUpdate();
                if(register > 0){
                    JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Hubo un error al insertar el registro");              
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    
    public void modificaEntrega(Connection conexion,int idProveedor, int idDevolucion, int idEmpleado, LocalDate fechaEntrega){
        String query = "UPDATE Transaccion.Entrega SET idProveedor = ?, idDevolucion = ?, idEmpleado = ?, fechaEntrega = ? WHERE idEntrega = ?";
         try{
            preparedStatement = conexion.prepareCall(query);
                preparedStatement.setInt(1, idProveedor);
                preparedStatement.setInt(2, idDevolucion);
                preparedStatement.setInt(3, idEmpleado);
                preparedStatement.setDate(4, Date.valueOf(fechaEntrega));
                preparedStatement.setInt(5, getIdEntrega());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar");            
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void eliminaEntrega(Connection conexion)
    {
        String query ="DELETE FROM Transaccion.Entrega WHERE IdEntrega = ?";    
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdEntrega());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");            
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }
    
    
    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    } 
    
}
