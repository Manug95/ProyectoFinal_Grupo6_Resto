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
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                LocalDateTime fecha = rs.getDate("horaFecha").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                pedido.setFecha(fecha);
                pedido.setMesa(mesaD.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(meseroD.obtenerMesero(rs.getInt("idMesero")));
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
                         "SET idMesa, idMesero, horaFecha, pagado " +
                         "VALUES (?,?,?,?)  WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            
            ps.setDate(3, Date.valueOf(pedido.getFecha().toLocalDate()));
            ps.setBoolean(4, pedido.isPagado());
            ps.setInt(5, pedido.getIdPedido());
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
    * @param pedido PEDIDO que se desea agregar
    * @return TRUE si se logro agregar el PEDIDO o FALSE en caso contrario
    */
    public boolean agregarPedido(Pedido pedido){
        boolean agregado = true;
        try {
            String sql = "INSERT INTO pedido (idMesa, idMesero, horaFecha, pagado) " + 
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setDate(3, Date.valueOf(pedido.getFecha().toLocalDate()));
            ps.setBoolean(4, pedido.isPagado());
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
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return modificado;
    }
    
    /**
    * obtener List de Productos de un PEDIDO
    * @param pedido pedido del cual se desean obtener los Productos
    * @return List con productos del pedido o un List vacio
    */
    public List<Producto> obtenerProductosDePedido(Pedido pedido){
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto " + 
                    "WHERE idProducto IN (SELECT detallePedido.idProducto FROM detallePedido, pedido WHERE detallePedido.idPedido = pedido.idPedido AND pedido.idPedido = ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ResultSet rs = ps.executeQuery();
            Producto producto;
            while (rs.next()){
                //producto = productoD.getProductoPorID(rs.getInt("idProducto"));
                //productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return productos;
    }
    
    /**
    * obtener List de Productos que no se encuentran en un PEDIDO
    * @param pedido pedido del cual se desean obtener los Productos no pedidos
    * @return List con productos que no se han pedido o un List vacio
    */
    public List<Producto> obtenerProductosNoPedidos(Pedido pedido){
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto " + 
                    "WHERE activo = true AND idProducto NOT IN (SELECT detallePedido.idProducto FROM detallePedido, pedido WHERE detallePedido.idPedido = pedido.idPedido AND pedido.idPedido = ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ResultSet rs = ps.executeQuery();
            Producto producto;
            while (rs.next()){
                //producto = productoD.getProductoPorID(rs.getInt("idProducto"));
                //productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex + ", statement: " + ex.getSQLState());
        }
        return productos;
    }
    
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
