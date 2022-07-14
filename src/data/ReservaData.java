
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
        
        String sql = "INSERT INTO reserva(idMesa, fechaReserva, horaReserva, dniCliente, nombreCliente, activo)"
                   + "VALUES (?, ?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, nuevaReserva.getMesa().getIdMesa());
            
            LocalDate ld = nuevaReserva.getFechaReserva().toLocalDate();
            LocalTime lt = nuevaReserva.getFechaReserva().toLocalTime();            
            ps.setDate(2, Date.valueOf(ld));
            ps.setTime(3, Time.valueOf(lt));
            
            ps.setString(4, nuevaReserva.getDniCliente());
            ps.setString(5, nuevaReserva.getNombreCliente());
            ps.setBoolean(6, nuevaReserva.isActivo());
            
            ps.executeUpdate();
            
            ResultSet result = ps.getGeneratedKeys();
            
            if(result.next()){
                nuevaReserva.setIdReserva(result.getInt("idReserva"));
                agregada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Agregar la Reserva! " + sqle);
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
                
                LocalDate ld = result.getDate("fechaReserva").toLocalDate();
                LocalTime lt = result.getTime("horaReserva").toLocalTime();
                reserva.setFechaReserva(LocalDateTime.of(ld, lt));
                
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener la Reserva! " + sqle);
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
                   + "SET idMesa = ?, fechaReserva = ?, horaReserva = ?, dniCliente = ?, nombreCliente = ?, activo = ? "
                   + "WHERE idReserva = ?;";
        
        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, reserva.getMesa().getIdMesa());
            
            LocalDate ld = reserva.getFechaReserva().toLocalDate();
            LocalTime lt = reserva.getFechaReserva().toLocalTime();            
            ps.setDate(2, Date.valueOf(ld));
            ps.setTime(3, Time.valueOf(lt));
            
            ps.setString(4, reserva.getDniCliente());
            ps.setString(5, reserva.getNombreCliente());
            ps.setBoolean(6, reserva.isActivo());
            ps.setInt(7, reserva.getIdReserva());
            
            if(ps.executeUpdate() != 0){
                modificada = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Modificar la Reserva! " + sqle);
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
            JOptionPane.showMessageDialog(null, "Error al Borrar la Reserva! " + sqle);
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
                
                LocalDate ld = result.getDate("fechaReserva").toLocalDate();
                LocalTime lt = result.getTime("horaReserva").toLocalTime();
                reserva.setFechaReserva(LocalDateTime.of(ld, lt));
                
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
                
                reservas.add(reserva);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Reservas! " + sqle);
        }
        
        return reservas;
    }
    
    /**
     * Comprueba si hay una Reserva de una mesa en Tal Día
     * @param idMesa id de la mesa
     * @param fecha de la reserva
     * @return true si hay una reserva en esa mesa en ese día, false si no hay ninguna reserva
     */
    public boolean verificarReservaDeMesaXFecha(int idMesa, LocalDateTime fecha){
        boolean hayReserva = false;
        
        String sql = "SELECT * "
                   + "FROM reserva "
                   + "WHERE idMesa = ? AND fechaReserva = ? AND horaReserva = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idMesa);
            ps.setDate(2, Date.valueOf(fecha.toLocalDate()));
            ps.setTime(3, Time.valueOf(fecha.toLocalTime()));
            
            ResultSet result = ps.executeQuery();
            
            if(result.next()){
                hayReserva = true;
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error! " + sqle);
        }
        
        return hayReserva;
    }
    
    public List<Reserva> getReservasPorFecha(LocalDate fecha){
        ArrayList<Reserva> reservas = new ArrayList();
        try {
            String sql = "SELECT * FROM reserva WHERE fechaReserva = ? AND activo = 1";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            Reserva r;
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                r = this.getReservaPorId(rs.getInt("idReserva"));
                reservas.add(r);
            }
            ps.close();
        } catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error!" + sqle);
        }
        return reservas;
    }
    
    /**
     * Trae las Reservas asociadas a un nombre de cliente
     * @param nombre del cliente del que se desea obtener las reservas
     * @return un ArrayList con las reservas del cliente
     */
    public ArrayList<Reserva> getReservasPorNombreCliente(String nombre){
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        String sql = "SELECT * "
                   + "FROM reserva "
                   + "WHERE nombreCliente = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, nombre);
            
            ResultSet result = ps.executeQuery();
            
            Reserva reserva;
            while(result.next()){
                reserva = new Reserva();
                
                reserva.setIdReserva(result.getInt("idReserva"));
                reserva.setMesa(mesaData.getMesaPorId(result.getInt("idMesa")));
                
                LocalDate ld = result.getDate("fechaReserva").toLocalDate();
                LocalTime lt = result.getTime("horaReserva").toLocalTime();
                reserva.setFechaReserva(LocalDateTime.of(ld, lt));
                
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
                
                reservas.add(reserva);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Reservas por Nombre del Cliente! " + sqle);
        }
        
        return reservas;
    }
    
//    /**
//     * Trae las Reservas asociadas a una fecha
//     * @param fecha de la que de quiere obtener las reservas
//     * @return un ArrayList con las reservas en esa Fecha
//     */
//    public ArrayList<Reserva> getReservasPorFecha(LocalDate fecha){
//        ArrayList<Reserva> reservas = new ArrayList<>();
//        
//        String sql = "SELECT * "
//                   + "FROM reserva "
//                   + "WHERE fechaReserva = ? AND activo = 1;";
//        
//        try{
//            PreparedStatement ps = conexion.prepareStatement(sql);
//            
//            ps.setDate(1, Date.valueOf(fecha));
//            
//            ResultSet result = ps.executeQuery();
//            
//            Reserva reserva;
//            while(result.next()){
//                reserva = new Reserva();
//                
//                reserva.setIdReserva(result.getInt("idReserva"));
//                reserva.setMesa(mesaData.getMesaPorId(result.getInt("idMesa")));
//                
//                LocalDate ld = result.getDate("fechaReserva").toLocalDate();
//                LocalTime lt = result.getTime("horaReserva").toLocalTime();
//                reserva.setFechaReserva(LocalDateTime.of(ld, lt));
//                
//                reserva.setDniCliente(result.getString("dniCliente"));
//                reserva.setNombreCliente(result.getString("nombreCliente"));
//                reserva.setActivo(result.getBoolean("activo"));
//                
//                reservas.add(reserva);
//            }
//            
//            ps.close();
//        }catch(SQLException sqle){
//            JOptionPane.showMessageDialog(null, "Error al Obtener las Reservas por Fecha! " + sqle);
//        }
//        
//        return reservas;
//    }
    
    /**
     * Trae las Reservas asociadas a una Mesa
     * @param idMesa de la Mesa de la que de quiere obtener las reservas
     * @return un ArrayList con las reservas en esa Mesa
     */
    public ArrayList<Reserva> getReservasPorMesa(int idMesa){
        ArrayList<Reserva> reservas = new ArrayList<>();
        
        String sql = "SELECT * "
                   + "FROM reserva "
                   + "WHERE idMesa = ? AND activo = 1;";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idMesa);
            
            ResultSet result = ps.executeQuery();
            
            Reserva reserva;
            while(result.next()){
                reserva = new Reserva();
                
                reserva.setIdReserva(result.getInt("idReserva"));
                reserva.setMesa(mesaData.getMesaPorId(result.getInt("idMesa")));
                
                LocalDate ld = result.getDate("fechaReserva").toLocalDate();
                LocalTime lt = result.getTime("horaReserva").toLocalTime();
                reserva.setFechaReserva(LocalDateTime.of(ld, lt));
                
                reserva.setDniCliente(result.getString("dniCliente"));
                reserva.setNombreCliente(result.getString("nombreCliente"));
                reserva.setActivo(result.getBoolean("activo"));
                
                reservas.add(reserva);
            }
            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Reservas por Mesa! " + sqle);
        }
        
        return reservas;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
