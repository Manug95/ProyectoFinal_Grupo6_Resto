
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
    private String nombre;
    private double precio;
    private int stock;
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Producto() {
    }

    public Producto(int idProducto, String nombre, double precio, int stock, boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.activo = activo;
    }

    public Producto(String nombre, double precio, int stock, boolean activo) {
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", activo=" + activo + '}';
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
