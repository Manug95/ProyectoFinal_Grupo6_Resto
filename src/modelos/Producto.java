
package modelos;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class Producto {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private int idProducto;
    private String nombreProducto;
    private double precio;
    private int stock;
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Producto() {
    }

    public Producto(int idProducto, String nombre, double precio, int stock, boolean activo) {
        this.idProducto = idProducto;
        this.nombreProducto = nombre;
        this.precio = precio;
        this.stock = stock;
        this.activo = activo;
    }

    public Producto(String nombre, double precio, int stock, boolean activo) {
        this.nombreProducto = nombre;
        this.precio = precio;
        this.stock = stock;
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombre) {
        this.nombreProducto = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return nombreProducto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
