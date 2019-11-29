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
    
    Connection conexion = null;
    private String Qry;
    private PreparedStatement pt;
    private int idDetalleCompra;
    
    public DetalleCompra(Connection con)
    {
        idDetalleCompra = -1;
    }
    
    public int getIdDetalleCompra(){
        return idDetalleCompra;
    }
    
    public void setIdDetalleCompra(int idDetalleCompra){
        this.idDetalleCompra = idDetalleCompra;
    }
    
        public void seleccionaCompras(Connection conexion, JComboBox compras) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            String query = "SELECT IdCompra FROM Transaccion.Compra";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String[] auxiliar = new String[2];
            while (resultSet.next()) {
                auxiliar[0] = resultSet.getString(1);
                modelo.addElement(auxiliar[0]);
            }
            compras.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
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
            javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }
    
    public void InsertaDetalleCompra(Connection conexion, int IdCompra, int IdProducto, int cantidad, float subtotal)
    {
        Qry = "INSERT INTO Transaccion.DetalleCompra (IdCompra, IdProducto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, IdCompra);
            pt.setInt(2, IdProducto);
            pt.setInt(3, cantidad);
            pt.setFloat(4,subtotal);
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se ingreso correctamente.");
            }
        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error en la inserción");
 
        }
    }
    
    public void ModificaDetalleCompra(Connection conexion, int IdCompra, int IdProducto, int cantidad, float subtotal)
    {
        Qry = "UPDATE Transaccion.DetalleCompra SET IdCompra = ?, IdProducto = ?, Cantidad = ?, Subtotal = ? WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, IdCompra);
            pt.setInt(2,IdProducto);
            pt.setInt(3, cantidad);
            pt.setFloat(4,subtotal);
            pt.setInt(5, getIdDetalleCompra());
            
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se edito correctamente.");
            }
        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al editar");            
        }
    }
    
    public void EliminaDetalleCompra(Connection conexion)
    {
        Qry = "DELETE FROM Transaccion.DetalleCompra WHERE IdDetalleCompra = ?";
        try {
            pt = conexion.prepareCall(Qry);
            pt.setInt(1, getIdDetalleCompra());
            int registro = pt.executeUpdate();
            if(registro > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
            }
        }
        catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación");            
        }
    }
}
