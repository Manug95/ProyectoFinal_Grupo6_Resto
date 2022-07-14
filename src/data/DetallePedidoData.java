package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.DetallePedido;
import modelos.Pedido;
import modelos.Producto;

/**
 *
 * @author Valentina
 */
public class DetallePedidoData {

    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private Connection con = null;
    private PedidoData pedidoD;
    private ProductoData productoD;

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public DetallePedidoData(Conexion con) {
        this.con = con.getConexion();
        pedidoD = new PedidoData(con);
        productoD = new ProductoData(con);
    }

    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    /**
     * agregar DETALLEPEDIDO
     *
     * @param dp DETALLEPEDIDO que se desea agregar
     * @return TRUE si se logro insertar el DETALLEPEDIDO o FALSE en caso
     * contrario
     */
    public boolean agregarDetallePedido(DetallePedido dp) {

        boolean insert = false;
        try {
            String sql = "INSERT INTO DetallePedido (idPedido, idProducto, cantidad, subtotal, activo)"
                    + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dp.getPedido().getIdPedido());
            Producto p = dp.getProducto();
            p.setStock(p.getStock() - dp.getCantidad());
            productoD.modificarProducto(p);
            ps.setInt(2, dp.getProducto().getIdProducto());
            ps.setInt(3, dp.getCantidad());
            ps.setDouble(4, dp.getCantidad() * dp.getProducto().getPrecio());
            ps.setBoolean(5, dp.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dp.setIdDetalle(rs.getInt("idDetalle"));
                insert = true;
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "El pedido ya existe!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return insert;
    }

    /**
     * eliminar -eliminado fisico- DETALLEPEDIDO en base a id
     *
     * @param id ID del DETALLEPEDIDO que se desea eliminar
     * @return TRUE si se logro eliminar el DETALLEPEDIDO o FALSE en caso
     * contrario
     */
    public boolean eliminarDetalleFisico(int id) {
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM detallePedido WHERE idDetalle = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "El pedido ya fue eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return eliminado;
    }

    /**
     * eliminar -eliminado logico- DETALLEPEDIDO en base a id
     *
     * @param id ID del DETALLEPEDIDO que se desea eliminar
     * @return TRUE si se logro eliminar el DETALLEPEDIDO o FALSE en caso
     * contrario
     */
    public boolean eliminarDetallePedido(int id) {
        boolean eliminado = false;
        try {
            String sql = "UPDATE detallePedido SET activo = false WHERE idDetalle = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "El pedido ya fue eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return eliminado;
    }

    /**
     * eliminar -eliminado logico- DETALLEPEDIDO en base al pedido y el producto
     *
     * @param pedido pedido del DETALLEPEDIDO que se desea elimianar
     * @param producto producto del DETALLEPEDIDO que se desea eliminar
     * @return TRUE si se logro eliminar el DETALLEPEDIDO o FALSE en caso
     * contrario
     */
    public boolean eliminarDetallePedido(Pedido pedido, Producto producto) {
        boolean eliminado = false;
        try {
            String sql = "UPDATE detallePedido SET activo = false WHERE idProducto = ? AND idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ps.setInt(2, pedido.getIdPedido());
            if (ps.executeUpdate() != 0) {
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "El pedido ya fue eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
            }
        }
        return eliminado;
    }

    /**
     * modifica idProducto, cantidad y subtotal de un DETALLEPEDIDO
     *
     * @param idDetalle ID del PEDIDO relacionado al DETALLEPEDIDO
     * @param producto PRODUCTO que se desea agregar
     * @param cantidad Cantidad del producto que se dea agregar
     * @return TRUE si se logro modificar el DETALLEPEDIDO o FALSE en caso
     * contrario
     */
    public boolean modificarProductoCantidad(int idDetalle, Producto producto, int cantidad) {
        boolean modificado = false;
        try {
            String sql = "UPDATE detallePedido SET idProducto = ?, cantidad = ?, subtotal = ? WHERE idDetalle = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ps.setInt(2, cantidad);
            ps.setDouble(3, producto.getPrecio() * cantidad);
            ps.setInt(4, idDetalle);
            if (ps.executeUpdate() != 0) {
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return modificado;
    }

    /**
     * obtener DETALLEPEDIDO
     *
     * @param idDetalle id del DETALLEPEDIDO que se desea obtener
     * @return DETALLEPEDIDO si se logro encontrar el DETALLEPEDIDO o NULL en
     * caso contrario
     */
    public DetallePedido obtenerDetallePedido(int idDetalle) {
        DetallePedido detallePedido = null;
        try {
            String sql = "SELECT * FROM detallePedido WHERE idDetalle = ? AND activo = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detallePedido = new DetallePedido();
                detallePedido.setActivo(rs.getBoolean("activo"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setIdDetalle(rs.getInt("idDetalle"));
                detallePedido.setPedido(pedidoD.obtenerPedido(rs.getInt("idPedido")));
                detallePedido.setProducto(productoD.obtenerProducto(rs.getInt("idProducto")));
                detallePedido.setSubtotal(detallePedido.getCantidad() * detallePedido.getProducto().getPrecio());

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return detallePedido;
    }

    /**
     * obtener DETALLESPEDIDOS
     *
     * @param pedido Pedido del cual se desea obtener lista de DETALLEPEDIDO
     * @return List con DETALLEPEDIDO encontrados o una list vacia en caso
     * contrario
     */
    public List<DetallePedido> obtenerDetallesPedidos(int pedido) {
        ArrayList<DetallePedido> lista = new ArrayList();
        try {
            String sql = "SELECT detallePedido.* "
                    + "FROM detallePedido, pedido "
                    + "WHERE detallePedido.idPedido = ? AND detallePedido.idPedido = pedido.idPedido AND detallePedido.activo = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(obtenerDetallePedido(rs.getInt("idDetalle")));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return lista;
    }

    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
