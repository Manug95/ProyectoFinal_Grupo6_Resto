
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Reserva;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class ReservaData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private Connection conexion = null;
    
    private MesaData mesaData;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public ReservaData(Conexion conexion){
        this.conexion = conexion.getConexion();
        this.mesaData = new MesaData(conexion);
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    
    /**
     * Registra una nueva Reserva en la Base de Datos
     * @param nuevaReserva es la reserva a registrar en la BD
     * @return true si se registró con éxito, si no, false
     */
    public boolean agregarReserva(Reserva nuevaReserva){
        boolean agregada = false;
        
        String sql = "INSERT INTO reserva(idMesa, fechaReserva, dniCliente, nombreCliente, activo)"
                   + "VALUES (?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, nuevaReserva.getMesa().getIdMesa());
            ps.setDate(2, Date.valueOf(nuevaReserva.getFechaReserva()));
            ps.setString(3, nuevaReserva.getDniCliente());
            ps.setString(4, nuevaReserva.getNombreCliente());
            ps.setBoolean(5, nuevaReserva.isActivo());
            
            ps.executeUpdate();
            
            ResultSet result = ps.getGeneratedKeys();
            
            if(result.next()){
                nuevaReserva.setIdReserva(result.getInt("idReserva"));
                agregada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Agregar la Reserva!");
        }
        
        return agregada;
    }
    
    /**
     * Obtiene la Reserva cuya id es pasada por parámetro
     * @param id de la Reserva a buscar
     * @return la Reserva con la id Especificada, o null si ocurre algún error o no se encuentra en la BD
     */
    public Reserva getReservaPorId(int id){
        Reserva reserva = null;
        
        String sql = "SELECT * FROM reserva WHERE idReserva = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet result = ps.executeQuery();
            
            if(result.next()){
                reserva = new Reserva();
                
                reserva.setIdReserva(result.getInt("idReserva"));
                reserva.setMesa(mesaData.getMesaPorId(result.getInt("idMesa")));
                reserva.setFechaReserva(result.getDate("fechaReserva").toLocalDate());
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener la Reserva!");
        }
        
        return reserva;
    }
    
    /**
     * Modifica los datos de una reserva en la BD
     * @param reserva es la reserva con los nuevos datos a guardar
     * @return true si se modificó con éxito, si no, false
     */
    public boolean modificarReserva(Reserva reserva){
        boolean modificada = false;
        
        String sql = "UPDATE reserva "
                   + "SET idMesa = ?, fechaReserva = ?, dniCliente = ?, nombreCliente = ?, activo = ? "
                   + "WHERE idReserva = ?;";
        
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, reserva.getMesa().getIdMesa());
            ps.setDate(2, Date.valueOf(reserva.getFechaReserva()));
            ps.setString(3, reserva.getDniCliente());
            ps.setString(4, reserva.getNombreCliente());
            ps.setBoolean(5, reserva.isActivo());
            ps.setInt(6, reserva.getIdReserva());
            
            if(ps.executeUpdate() != 0){
                modificada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Modificar la Reserva!");
        }
        
        return modificada;
    }
    
    /**
     * Borra (borrado lógico) una Reserva de la BD
     * @param id de la Reserva a borrar
     * @return true si la Reserva se Borró con éxito, si no, false
     */
    public boolean borrarReserva(int id){
        boolean borrada = false;
        
        String sql = "UPDATE reserva "
                   + "SET activo = 0 "
                   + "WHERE idReserva = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate() != 0){
                borrada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Borrar la Reserva!");
        }
        
        return borrada;
    }
    
    /**
     * Devuelve todas las Reservas Activas
     * @return un ArrayList con las Reservas Activas, o un ArrayList vacío
     */
    public ArrayList<Reserva> getReservasActivas(){
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        String sql = "SELECT * FROM reserva WHERE activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet result = ps.executeQuery();
            
            Reserva reserva;
            while(result.next()){
                reserva = new Reserva();
                
                reserva.setIdReserva(result.getInt("idReserva"));
                reserva.setMesa(mesaData.getMesaPorId(result.getInt("idMesa")));
                reserva.setFechaReserva(result.getDate("fechaReserva").toLocalDate());
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
                
                reservas.add(reserva);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Reservas!" + sqle);
        }
        
        return reservas;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
