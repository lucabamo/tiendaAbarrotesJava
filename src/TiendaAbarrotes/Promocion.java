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
public class Promocion {
    
    private int idPromocion;
    private PreparedStatement preparedStatement;

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }
    
    public Promocion(){
        this.idPromocion = -1;
    }
    
    public void seleccionaPromociones(Connection conexion, JTable promociones){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IdPromocion");
        modelo.addColumn("IdProducto");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        modelo.addColumn("Descuento");
        
        try{
            String query = "SELECT * FROM Transaccion.Promocion ORDER BY IdPromocion";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Object auxiliar[] = new Object[5];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                auxiliar[2] = resultSet.getString(3);
                auxiliar[3] = resultSet.getString(4);
                BigDecimal bd = new BigDecimal(Float.toString(resultSet.getFloat(5)));
                bd = bd.setScale(2, BigDecimal.ROUND_CEILING);
                auxiliar[4] = bd.floatValue();
                modelo.addRow(auxiliar);
            }
           promociones.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    public void seleccionaProductos(Connection conexion, JComboBox productos){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String query = "SELECT Nombre, IdProducto FROM Inventario.Producto";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while(resultSet.next()){
                auxiliar[0] = resultSet.getString(1);
                auxiliar[1] = resultSet.getString(2);
                modelo.addElement(new Item(Integer.parseInt(auxiliar[1]),auxiliar[0]));
            }
           productos.setModel(modelo);
        }
        catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    public void agregaPromocion(Connection conexion,int idProducto, LocalDate fechaInicio, LocalDate fechaFinal, float descuento){
        String query ="INSERT INTO Transaccion.Promocion (IdProducto, FechaInicio, FechaFinal, Descuento) VALUES (?,?,?,?)";
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setDate(2, Date.valueOf(fechaInicio));
            preparedStatement.setDate(3, Date.valueOf(fechaFinal));
            preparedStatement.setFloat(4, descuento);
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se ingresó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
        }
    }
    
    public void modificaPromocion(Connection conexion,int idProducto, LocalDate fechaInicio, LocalDate fechaFinal, float descuento)
    {
        String query = "UPDATE Transaccion.Promocion SET IdProducto = ?, FechaInicio= ?, FechaFinal=?, Descuento=? WHERE IdPromocion = ?";
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, idProducto);
            preparedStatement.setDate(2, Date.valueOf(fechaInicio));
            preparedStatement.setDate(3, Date.valueOf(fechaFinal));
            preparedStatement.setFloat(4, descuento);
            preparedStatement.setInt(5, getIdPromocion());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Hubo un error en la modificación");
        }
    }
    
    public void eliminaPromocion(Connection conexion){
        String query = "DELETE FROM Transaccion.Promocion WHERE IdPromocion = ?";
        try{
            preparedStatement = conexion.prepareCall(query);
            preparedStatement.setInt(1, getIdPromocion());
            int register = preparedStatement.executeUpdate();
            if(register > 0){
                JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
    }
    
}
