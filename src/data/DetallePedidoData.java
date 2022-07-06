
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelos.DetallePedido;
import modelos.Pedido;
import modelos.Producto;

/**
 *
 * @author Valentina
 */
public class DetallePedidoData {
    
    private Connection con = null;
    
    public DetallePedidoData(Conexion con){
        this.con = con.getConexion();
    }
    
    /**
    * agregar DETALLEPEDIDO
    * @param dp DETALLEPEDIDO que se desea agregar
    * @return TRUE si se logro insertar el DETALLEPEDIDO o FALSE en caso contrario
    */
    public boolean agregarDetallePedido(DetallePedido dp){
        
        boolean insert = true;
        try {
            String sql = "INSERT INTO DetallePedido (idProducto, idPedido, cantidad, subtotal)"
                    + " VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dp.getProducto().getIdProducto());
            ps.setInt(2, dp.getPedido().getIdPedido());
            ps.setInt(3, dp.getCantidad());
            ps.setDouble(4, dp.getCantidad()*dp.getProducto().getPrecio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                dp.setIdDetalle(rs.getInt("idDetalle"));
            } else {
                insert = false;
            }
            ps.close();
        } catch (SQLException ex){
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "El pedido ya existe!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return insert;
    }
    
    /**
    * eliminar DETALLEPEDIDO en base a id
    * @param id ID del DETALLEPEDIDO que se desea eliminar
    * @return TRUE si se logro eliminar el DETALLEPEDIDO o FALSE en caso contrario
    */
    public boolean eliminarDetallePedido(int id){
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM detallePedido WHERE idDetalle = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0){
                eliminado = true;
            }
            ps.close();        
        } catch (SQLException ex){
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "El pedido ya fue eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return eliminado;
    }
    
    /**
    * eliminar DETALLEPEDIDO en base al pedido y el producto
    * @param pedido pedido del DETALLEPEDIDO que se desea elimianar
    * @param producto producto del DETALLEPEDIDO que se desea eliminar
    * @return TRUE si se logro eliminar el DETALLEPEDIDO o FALSE en caso contrario
    */
    public boolean eliminarDetallePedido(Pedido pedido, Producto producto){
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM detallePedido WHERE idProducto = ? AND idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ps.setInt(2, pedido.getIdPedido());
            if (ps.executeUpdate() != 0){
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex){
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "El pedido ya fue eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return eliminado;
    }
    
}


