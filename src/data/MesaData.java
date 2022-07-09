
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Mesa;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class MesaData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private Connection conexion = null;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public MesaData(Conexion conexion){
        this.conexion = conexion.getConexion();
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    
    /**
     * Agrega una Mesa en la tabla mesa de la Base de Datos
     * @param nuevaMesa es la Mesa nueva que va a ser agregada
     * @return true si se agrego correctamente, si no, false
     */
    public boolean agregarMesa(Mesa nuevaMesa){
        boolean agregada = false;
        
        String sql = "INSERT INTO mesa(capacidad, estado, activo)" 
                   + "VALUES (?, ?, ?);";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, nuevaMesa.getCapacidad());
            ps.setString(2, Character.toString(nuevaMesa.getEstado()));
            ps.setBoolean(3, nuevaMesa.isActivo());
            
            ps.executeUpdate();
            
            ResultSet result = ps.getGeneratedKeys();
            
            if(result.next()){
                nuevaMesa.setIdMesa(result.getInt("idMesa"));
                agregada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Agregar la Nueva Mesa!");
        }
        
        return agregada;
    }
    
    /**
     * obtiene la Mesa cuya id es pasada por parametro
     * @param id de la Mesa a buscar
     * @return la Mesa con la id especificada, o null si ocurre algún error o no esta en la BD
     */
    public Mesa getMesaPorId(int id){
        Mesa mesa = null;
        
        String sql = "SELECT * "
                   + "FROM mesa "
                   + "WHERE idMesa = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet result = ps.executeQuery();
            
            if(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener la Mesa con ID = " + id + "!");
        }
        
        return mesa;
    }
    
    /**
     * Modifica los detos de una Mesa en la Base de Datos
     * @param mesa de la cual se desean modificar sus datos en la BD
     * @return true si se modifico con éxito, si no, false
     */
    public boolean modificarMesa(Mesa mesa){
        boolean modificada = false;
        
        String sql = "UPDATE mesa "
                   + "SET capacidad = ?, estado = ?, activo = ? "
                   + "WHERE idMesa = ?;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, mesa.getCapacidad());
            ps.setString(2, Character.toString(mesa.getEstado()));
            ps.setBoolean(3, mesa.isActivo());
            ps.setInt(4, mesa.getIdMesa());
            
            if(ps.executeUpdate() != 0){
                modificada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Modificar la Mesa!");
        }
        
        return modificada;
    }
    
    /**
     * Deshabilita (borrado lógico) la Mesa cuya id es pasada por parámetro
     * @param id de la Mesa a Deshabilitar
     * @return true si se Deshabilitó con éxito, si no, false
     */
    public boolean deshabilitarMesa(int id){
        boolean deshabilitada = false;
        
        String sql = "UPDATE mesa "
                   + "SET activo = 0 "
                   + "WHERE idMesa = ?;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate() != 0){
                deshabilitada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Deshabilitar la Mesa con ID = " + id + "!");
        }
        
        return deshabilitada;
    }
    
    /**
     * Habilita la Mesa cuya id es pasada por parámetro
     * @param id de la Mesa a Habilitar
     * @return true si se Habilitó con éxito, si no, false
     */
    public boolean habilitarMesa(int id){
        boolean habilitada = false;
        
        String sql = "UPDATE mesa "
                   + "SET activo = 1 "
                   + "WHERE idMesa = ?;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate() != 0){
                habilitada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Habilitar la Mesa con ID = " + id + "!");
        }
        
        return habilitada;
    }
    
    /**
     * Devuelve las Mesas que estan Activas
     * @return un ArrayList con las Mesas Activas, o un ArrayList vacío
     */
    public ArrayList<Mesa> getMesasActivas(){
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE activo = 1";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                mesas.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas!");
        }
        
        return mesas;
    }
    
    /**
     * Devuelve las Mesas que NO estan Activas
     * @return un ArrayList con las Mesas NO Activas, o un ArrayList vacío
     */
    public ArrayList<Mesa> getMesasInactivas(){
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE activo = 0";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                mesas.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas!");
        }
        
        return mesas;
    }
    
    /**
     * Obtiene las Mesas con el Estado que le es pasado por parámetro
     * @param estado de las mesas que se quieren obtener
     * @return un ArrayList con las mesas cuyo estado es el deseado
     */
    public ArrayList<Mesa> getMesasSegunEstado(char estado){
        ArrayList<Mesa> libres = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE estado = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, Character.toString(estado).toUpperCase());
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                libres.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas Libres!" + sqle);
        }
        
        return libres;
    }
    
    /**
     * Obtiene las Mesas con la Capacidad que le es pasada por parámetro
     * @param capacidad de las mesas que se quieren obtener
     * @return un ArrayList con las mesas cuya capacidad es la deseada
     */
    public ArrayList<Mesa> getMesasSegunCapacidad(int capacidad){
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        String sql = "SELECT * FROM mesa WHERE capacidad = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, capacidad);
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                mesas.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas Libres!" + sqle);
        }
        
        return mesas;
    }
    
    /**
     * @return un ArrayList con las mesas que estan Reservadas
     */
    public ArrayList<Mesa> getMesasReservadas(){
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        String sql = "SELECT mesa.* FROM mesa, reserva WHERE mesa.idMesa = reserva.idMesa AND reserva.activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                mesas.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas Reservadas!" + sqle);
        }
        
        return mesas;
    }
    
    /**
     * @return un ArrayList con las mesas que NO estan Reservadas
     */
    public ArrayList<Mesa> getMesasNoReservadas(){
        ArrayList<Mesa> mesas = new ArrayList<>();
        
        String sql = "SELECT * "
                   + "FROM mesa "
                   + "WHERE idMesa NOT IN (SELECT idMesa FROM reserva WHERE activo = 1);";
        
//        String sql2 = "SELECT * "
//                    + "FROM mesa "
//                    + "WHERE activo = 1 AND idMesa NOT IN (SELECT idMEsa FROM reserva WHERE idMesa = ? AND activo = 1;)";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            Mesa mesa;
            while(result.next()){
                mesa = new Mesa();
                
                mesa.setIdMesa(result.getInt("idMesa"));
                mesa.setCapacidad(result.getInt("capacidad"));
                mesa.setEstado(result.getString("estado").charAt(0));
                mesa.setActivo(result.getBoolean("activo"));
                
                mesas.add(mesa);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Mesas NO Reservadas!" + sqle);
        }

        return mesas;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
