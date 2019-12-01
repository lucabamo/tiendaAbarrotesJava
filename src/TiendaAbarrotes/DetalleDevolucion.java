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
 * @author Luis Bacasehua
 */
public class DetalleDevolucion {
    
    private int idDetalleDevolucion;
    private PreparedStatement preparedStatement;
    
    public int getIdDetalleDevolucion() {
        return idDetalleDevolucion;
    }

    public void setIdDetalleDevolucion(int idDetalleDevolucion) {
        this.idDetalleDevolucion = idDetalleDevolucion;
    }

    public DetalleDevolucion() {
        this.idDetalleDevolucion = -1;
    }
    
    
        public void consultaDetallesDevolucion(Connection conexion, JTable detallesDevolucion) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdDetalleDevolucion");
        modelo.addColumn("IdDevolucion");
        modelo.addColumn("IdProducto");
        modelo.addColumn("Cantidad");
        try {
            String query = "SELECT * FROM Transaccion.DetalleDevolucion";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[5];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                BigDecimal bd = new BigDecimal(Float.toString(resultSet.getFloat(4)));
                bd = bd.setScale(2, BigDecimal.ROUND_CEILING);
                auxiliar[3] = bd.floatValue();
                modelo.addRow(auxiliar);
            }
            detallesDevolucion.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
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
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]),auxiliar[1]+"_" +auxiliar[0]));
            }
           devoluciones.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
   
    
    public void cargaProductos(Connection conexion, JComboBox productos) {
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
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    
    /*
     "SELECT DISTINCT detalleventa.Cantidad " +
                "FROM Inventario.Producto AS producto " +
                "INNER JOIN Transaccion.DetalleVenta AS detalleventa ON detalleventa.IdProducto = producto.IdProducto " +
                "INNER JOIN Transaccion.Devolucion AS devolucion ON devolucion.IdVenta = detalleventa.IdVenta " +
                "WHERE devolucion.IdDevolucion = " + IdDevolucion + " AND " + "producto.IdProducto = " + IdProducto;
    */
    
       public void agregaDetalleDevolucion(Connection conexion, int idDevolucion , int idProducto, int cantidad) {
        String queryConsultaVendidos = "SELECT DISTINCT detalleventa.Cantidad FROM Inventario.Producto AS producto "
                + "INNER JOIN Transaccion.DetalleVenta AS detalleventa ON detalleventa.IdProducto = producto.IdProducto "
                + "INNER JOIN Transaccion.Devolucion AS devolucion ON devolucion.IdVenta = detalleventa.IdVenta "
                + "WHERE devolucion.IdDevolucion = ?  AND producto.IdProducto = ?" ;
           
         try {
            preparedStatement = conexion.prepareCall(queryConsultaVendidos);
            preparedStatement.setInt(1, idDevolucion);
            preparedStatement.setInt(2, idProducto);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            int[] auxiliar = new int[1];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getInt(1);
            }
            if(auxiliar[0] >= cantidad){
                String query = "INSERT INTO Transaccion.DetalleDevolucion (IdDevolucion, IdProducto,Cantidad) VALUES (?,?,?)";
                 try {
                     preparedStatement = conexion.prepareCall(query);
                     preparedStatement.setInt(1, idDevolucion);
                     preparedStatement.setInt(2, idProducto);
                     preparedStatement.setInt(3, cantidad);
                     int register = preparedStatement.executeUpdate();
                     if (register > 0) {
                         JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
                     }
                 } catch (Exception ex) {
                     JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
                 }            
            }
            else{
                                 JOptionPane.showMessageDialog(null, "No puedes devolver más productos de lo que compraste");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
        }       
        
        
 
    }
       
        public void modificaDetalleDevolucion(Connection conexion, int idDevolucion , int idProducto, int cantidad){
        String query = "UPDATE Transaccion.DetalleDevolucion SET idDevolucion = ?, idProducto = ?, cantidad = ? WHERE IdDetalleDevolucion = ?";

            try {
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idDevolucion);
            preparedStatement.setInt(2, idProducto);
            preparedStatement.setInt(3, cantidad);
            preparedStatement.setInt(4, getIdDetalleDevolucion());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar");            
            }
        }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar");            
        }
    }
            public void eliminaEntrega(Connection conexion)
    {
        String query ="DELETE FROM Transaccion.DetalleDevolucion WHERE IdDevolucion = ?";    
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdDetalleDevolucion());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");            
            }
        }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Hubo un error al eliminar");            
        }    
    }
}
