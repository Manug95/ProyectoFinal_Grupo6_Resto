
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Producto;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class ProductoData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    
    private Connection conexion = null;
    
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    
    public ProductoData(Conexion conexion){
        this.conexion = conexion.getConexion();
    }
    
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    
    /**
     * Agrega un producto en la tabla producto de la Base de Datos
     * @param unProducto es el producto que va a ser agregado
     * @return true si se agrego correctamente, si no, false
     */
    public boolean agregarProducto(Producto unProducto){
        boolean agregado = false;        
        String sql = "INSERT INTO producto(nombreProducto, precio, stock, activo)" 
                   + " VALUES (?, ?, ?, ?)";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, unProducto.getNombreProducto());
            ps.setDouble(2, unProducto.getPrecio());
            ps.setInt(3, unProducto.getStock());
            ps.setBoolean(4, unProducto.isActivo());            
            ps.executeUpdate();            
            ResultSet result = ps.getGeneratedKeys();            
            if(result.next()){
                unProducto.setIdProducto(result.getInt("idProducto"));
                agregado = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al agregar un producto");
        }        
        return agregado;
    }
    
     /**
     * Borrado lógico de un producto cuya id es pasada por parámetro
     * @param id es el id del producto a borrar
     * @return true si se borro con éxito, si no, false
     */
    public boolean borrarProducto(int id){
        boolean borrar = false;        
        String sql = "UPDATE producto "
                   + "SET activo = 0 "
                   + "WHERE idProducto = ?;";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setInt(1, id);            
            if(ps.executeUpdate() != 0){
                borrar = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al borrar el producto");
        }        
        return borrar;
    }
    
    /**
     * Modifica los datos de un producto en la Base de Datos
     * @param unProducto es el producto que se desea modificar
     * @return true si se modifico con éxito, si no, false
     */
    public boolean modificarProducto(Producto unProducto){
        boolean modificado = false;        
        String sql = "UPDATE producto "
                   + "SET nombreProducto = ?, precio = ?, stock = ?, activo = ? "
                   + "WHERE idProducto = ?";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setString(1, unProducto.getNombreProducto());
            ps.setDouble(2, unProducto.getPrecio());
            ps.setInt(3, unProducto.getStock());
            ps.setBoolean(4, unProducto.isActivo());
            ps.setInt(5, unProducto.getIdProducto());            
            if(ps.executeUpdate() != 0){
                modificado = true;
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al modificar el producto");
        }        
        return modificado;
    }
    
    /**
     * Devuelve todos los productos
     * @return un ArrayList con todos los productos, o un ArrayList vacío
     */
    public List<Producto> todosLosProductos(){
        ArrayList<Producto> productos = new ArrayList<>();        
        String sql = "SELECT * FROM producto WHERE activo = 1";        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ResultSet result = ps.executeQuery();            
            Producto unProducto;
            while(result.next()){
                unProducto = new Producto();
                unProducto.setIdProducto(result.getInt("idProducto"));
                unProducto.setNombreProducto(result.getString("nombreProducto"));
                unProducto.setPrecio(result.getDouble("precio"));
                unProducto.setStock(result.getInt("stock"));
                unProducto.setActivo(result.getBoolean("activo"));                
                productos.add(unProducto);
            }            
            ps.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al obtener los productos");
        }        
        return productos;
    }
    
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
