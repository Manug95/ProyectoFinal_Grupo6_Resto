package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE horaFecha BETWEEN '" + f + " 00:00:00' AND '" + f + " 23:59:59' AND pagado = 1";        
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
            JOptionPane.showMessageDialog(null, "Error al obtener los productos" + sqle);
        }       
       return pedidos;
    }
    
    public List<Pedido> pedidosXFechaYMesero(Date fecha, int idMesero){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String f = formato.format(fecha);
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE horaFecha BETWEEN '" + f + " 00:00:00' AND '" + f + " 23:59:59' AND pagado = 1 AND idMesero = ?";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, idMesero);
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
            JOptionPane.showMessageDialog(null, "Error al obtener los productos" + sqle);
        }       
       return pedidos;
    }
    
    public List<Pedido> pedidosXFechaYMesa(Date fecha, int idMesa){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String f = formato.format(fecha);
        String sql = "SELECT * "
                   + "FROM pedido "
                   + "WHERE horaFecha BETWEEN '" + f + " 00:00:00' AND '" + f + " 23:59:59' AND pagado = 1 AND idMesa = ?";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, idMesa);
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
            JOptionPane.showMessageDialog(null, "Error al obtener los productos" + sqle);
        }       
       return pedidos;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
