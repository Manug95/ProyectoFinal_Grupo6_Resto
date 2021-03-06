/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Pedido;
import modelos.Producto;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class PedidoData {
    
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    
    private Connection con;
    private MesaData mesaD;
    private MeseroData meseroD;
    private ProductoData productoD;

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    
    public PedidoData(Conexion con) {
        this.con = con.getConexion();
        mesaD = new MesaData(con);
        meseroD = new MeseroData(con);
    }
    
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    
    /**
    * eliminar PEDIDO -eliminado fisico-
    * @param id ID del PEDIDO que se desea eliminar
    * @return TRUE si se logro eliminar el PEDIDO o FALSE en caso contrario
    */
    public boolean eliminarPedidoFisico(int id){
        boolean eliminado = false;
        try {
            String sql = "DELETE FROM pedido WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0){
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return eliminado;
    }    
    
    /**
    * eliminar PEDIDO -eliminado logico-
    * @param id ID del PEDIDO que se desea eliminar
    * @return TRUE si se logro eliminar el PEDIDO o FALSE en caso contrario
    */
    public boolean eliminarPedido(int id){
        boolean eliminado = false;
        try {
            String sql = "UPDATE pedido SET activo = false WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0){
                eliminado = true;
            }
            ps.close();
        } catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return eliminado;
    }
    
    /**
    * obtener PEDIDOS
    * @param estadoActivo Boolean del estado de los pedidos que se desea obtener
    * @return List con pedidos si se encontraron pedidos en el estadoActivo o list vacia en caso contrario
    */
    public List<Pedido> obtenerPedidos(boolean estadoActivo){
        ArrayList<Pedido> pedidos = new ArrayList();
        try {
            String sql = "SELECT * FROM pedido WHERE activo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, estadoActivo);
            ResultSet rs = ps.executeQuery();
            Pedido pedido;
            while (rs.next()){
                pedido = new Pedido();
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(mesaD.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(meseroD.obtenerMesero(rs.getInt("idMesero")));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setActivo(rs.getBoolean("activo"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return pedidos;
    }
    
    /**
    * obtener PEDIDO
    * @param id ID del PEDIDO que se desea obtener
    * @return PEDIDO si se logro encontrar el PEDIDO o NULL en caso contrario
    */
    public Pedido obtenerPedido(int id){
        Pedido pedido = null;
        try {
            String sql = "SELECT * FROM pedido WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setMesa(mesaD.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(meseroD.obtenerMesero(rs.getInt("idMesero")));
                pedido.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return pedido;
    }
    
    /**
    * modificar PEDIDO
    * @param pedido PEDIDO con el id del pedido que se desea modificar y con los atributos que se desean modificar
    * @return TRUE si se logro modificar el PEDIDO o FALSE en caso contrario
    */
    public boolean modificarPedido(Pedido pedido){
        boolean modificado = false;
        try {
            String sql = "UPDATE pedido " +
                         "SET idMesa, idMesero, fecha, hora, pagado, activo " +
                         "VALUES (?,?,?,?,?,?)  WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setDate(3, Date.valueOf(pedido.getFecha().toLocalDate()));
            ps.setTime(4, Time.valueOf(pedido.getFecha().toLocalTime()));
            ps.setBoolean(5, pedido.isPagado());
            ps.setBoolean(6, pedido.isActivo());
            ps.setInt(7, pedido.getIdPedido());
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex){ 
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return modificado;
    }
    
    /**
    * agregar PEDIDO
    * @param pedido PEDIDO que se desea agregar (solo es necesario el id de mesa, mesero y el estado de pagado, lo demas se setea desde bd)
    * @return TRUE si se logro agregar el PEDIDO o FALSE en caso contrario
    */
    public boolean agregarPedido(Pedido pedido){
        boolean agregado = true;
        try {
            String sql = "INSERT INTO pedido (idMesa, idMesero, pagado) " + 
                    "VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setBoolean(3, pedido.isPagado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                pedido.setIdPedido(rs.getInt("idPedido"));
            } else {
                agregado = false;
            }
            ps.close();
        } catch (SQLException ex){
            agregado = false;
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return agregado;
    }
    
    /**
    * modificar boolean Pagado de un PEDIDO
    * @param id ID del PEDIDO que se desea modificar el boolean pagado a true
    * @param estado boolean del estado al que se desea modificar Pagado
    * @return TRUE si se logro modificar el PEDIDO o FALSE en caso contrario
    */
    public boolean modificarPagadoPedido(int id, boolean estado){
        boolean modificado = false;
        try {
            String sql = "UPDATE pedido SET pagado = ? WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setInt(2, id);
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return modificado;
    }
    
    /**
    * modificar boolean activo de un PEDIDO
    * @param id ID del PEDIDO que se desea modificar el boolean pagado a true
    * @param activo Estado al que se desea setear el pedido
    * @return TRUE si se logro modificar el PEDIDO o FALSE en caso contrario
    */
    public boolean modificarActivoPedido(int id, boolean activo){
        boolean modificado = false;
        try {
            String sql = "UPDATE pedido SET activo = ? WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, activo);
            ps.setInt(2, id);
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return modificado;
    }
    
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
