
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelos.Mesa;
import modelos.Mesero;
import modelos.Pedido;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class MeseroData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    
    private Connection conexion = null;
    private MesaData unaMesa;
    
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    
    public MeseroData(Conexion conexion){
        this.conexion = conexion.getConexion();
        this.unaMesa = new MesaData(conexion);
    }
    
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    
    /**
     * Agrega un mesero en la tabla mesero de la Base de Datos
     * @param unMesero es el mesero que va a ser agregado
     * @return true si se agrego correctamente, si no, false
     */
    public boolean agregarMesero(Mesero unMesero){
        boolean agregado = false;        
        String sql = "INSERT INTO mesero (nombreMesero, apellido, dni, telefono, activo)" 
                   + "VALUES (?, ?, ?, ?, ?);";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, unMesero.getNombreMesero());
            ps.setString(2, unMesero.getApellido());
            ps.setString(3, unMesero.getDni());
            ps.setString(4, unMesero.getTelefono());
            ps.setBoolean(5, unMesero.isActivo());            
            ps.executeUpdate();            
            ResultSet result = ps.getGeneratedKeys();            
            if(result.next()){
                unMesero.setIdMesero(result.getInt("idMesero"));
                agregado = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al agregar un mesero");
        }        
        return agregado;
    }
    
     /**
     * Borrado lógico de un mesero cuya id es pasada por parámetro
     * @param id es el id del mesero a borrar
     * @return true si se borro con éxito, si no, false
     */
    public boolean borrarMesero(int id){
        boolean borrar = false;        
        String sql = "UPDATE mesero "
                   + "SET activo = 0 "
                   + "WHERE idMesero = ?;";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setInt(1, id);            
            if(ps.executeUpdate() != 0){
                borrar = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al borrar el mesero");
        }        
        return borrar;
    }
    
    /**
     * Modifica los datos de un mesero en la Base de Datos
     * @param unMesero es el producto que se desea modificar
     * @return true si se modifico con éxito, si no, false
     */
    public boolean modificarMesero(Mesero unMesero){
        boolean modificado = false;        
        String sql = "UPDATE mesero "
                   + "SET nombreMesero = ?, apellido = ?, dni = ?, telefono = ?, estado = ? "
                   + "WHERE idMesero = ?";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setString(1, unMesero.getNombreMesero());
            ps.setString(2, unMesero.getApellido());
            ps.setString(3, unMesero.getDni());
            ps.setString(4, unMesero.getTelefono());
            ps.setBoolean(5, unMesero.isActivo());
            ps.setInt(6, unMesero.getIdMesero());            
            if(ps.executeUpdate() != 0){
                modificado = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del mesero");
        }        
        return modificado;
    }
    
    /**
     * Devuelve todos los meseros
     * @return un ArrayList con todos los meseros, o un ArrayList vacío
     */
    public List<Mesero> todosLosMeseros(){
        ArrayList<Mesero> meseros = new ArrayList<>();        
        String sql = "SELECT * FROM mesero WHERE activo = 1";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ResultSet result = ps.executeQuery();            
            Mesero unMesero;
            while(result.next()){
                unMesero = new Mesero();
                unMesero.setIdMesero(result.getInt("idMesero"));
                unMesero.setNombreMesero(result.getString("nombreMesero"));
                unMesero.setApellido(result.getString("apellido"));
                unMesero.setDni(result.getString("dni"));
                unMesero.setTelefono(result.getString("telefono"));
                unMesero.setActivo(result.getBoolean("activo"));                
                meseros.add(unMesero);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de meseros");
        }        
        return meseros;
    }
    
    public Mesero obtenerMesero(int id){
        Mesero unMesero = null;        
        String sql = "SELECT * "
                   + "FROM mesero "
                   + "WHERE idMesero = ? AND activo = 1;";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setInt(1, id);            
            ResultSet result = ps.executeQuery();            
            if(result.next()){
                unMesero = new Mesero();
                unMesero.setIdMesero(result.getInt("idMesero"));
                unMesero.setNombreMesero(result.getString("nombreMesero"));
                unMesero.setApellido(result.getString("apellido"));
                unMesero.setDni(result.getString("dni"));
                unMesero.setTelefono(result.getString("telefono"));
                unMesero.setActivo(result.getBoolean("activo"));
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener un mesero con ID = " + id + "!");
        }        
        return unMesero;
    }
    
    public List<Pedido> pedidosCobradosXFecha(Date fecha){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String f = formato.format(fecha);
        String sql = "SELECT * FROM pedido WHERE fecha = ? AND activo = 1;";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, f);
            ResultSet rs = ps.executeQuery();
            Pedido pedido;
            while(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setMesa(unaMesa.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(obtenerMesero(rs.getInt("idMesero")));                
                pedidos.add(pedido);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos" + sqle);
        }       
       return pedidos;
    }
    
    public List<Pedido> pedidosXFechaYMesero(Date fecha, int id){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String f = formato.format(fecha);
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE fecha = ? AND idMesero = ? AND activo = 1";                      
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1,f);
            ps.setInt(2,id);
            ResultSet rs = ps.executeQuery();
            Pedido pedido;
            while(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setMesa(this.unaMesa.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(obtenerMesero(rs.getInt("idMesero")));                
                pedidos.add(pedido);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos" + sqle);
        }       
       return pedidos;
    }
    
    public List<Pedido> pedidosXFechaYMesa(Date fecha, int idMesa){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String f = formato.format(fecha);
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE fecha = ? AND idMesa = ? AND activo = 1";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, f);
            ps.setInt(2, idMesa);
            ResultSet rs = ps.executeQuery();
            Pedido pedido;
            while(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setMesa(unaMesa.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(obtenerMesero(rs.getInt("idMesero")));                
                pedidos.add(pedido);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos" + sqle);
        }       
       return pedidos;
    }
    
    public List<Pedido>pedidosImpagos(){
        ArrayList<Pedido> pedidos = new ArrayList<>();        
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE pagado = 0 AND activo = 1";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Pedido pedido;
            while(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setFecha(rs.getTime("hora").toLocalTime().atDate(rs.getDate("fecha").toLocalDate()));
                pedido.setMesa(unaMesa.getMesaPorId(rs.getInt("idMesa")));
                pedido.setMesero(obtenerMesero(rs.getInt("idMesero")));                
                pedidos.add(pedido);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los pedidos" + sqle);
        }       
       return pedidos;
    }
    
    public boolean PagarPedido(int id){
        boolean modificado = false;
        try {
            String sql = "UPDATE pedido SET pagado = 1 WHERE idPedido = ? AND activo = 1";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo realizar el pago");
        }
        return modificado;
    }
    
    public boolean anularPedido(int id){
        boolean modificado = false;
        try {
            String sql = "UPDATE detallepedido,pedido SET detallepedido.activo = 0, pedido.activo = 0 WHERE pedido.idPedido = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo realizar el pago");
        }
        return modificado;
    }
    
    public boolean liberarMesa(Mesa mesa){
        boolean modificado = false;
        try {
            String sql = "UPDATE mesa SET estado = 'L' WHERE mesa.idMesa = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            if (ps.executeUpdate() != 0){
                modificado = true;
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo realizar el pago");
        }
        return modificado;
    }
    
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}