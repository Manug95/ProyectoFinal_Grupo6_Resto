/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Objects;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class DetallePedido {
    
    private int idDetalle;
    private Producto producto;
    private Pedido pedido;
    private int cantidad;
    private double subtotal;
    private boolean activo;

    public DetallePedido() {
    }

    public DetallePedido(int idDetalle, Producto producto, Pedido pedido, int cantidad, double subtotal, boolean activo) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.activo = activo;
    }

    public DetallePedido(Producto producto, Pedido pedido, int cantidad, double subtotal, boolean activo) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.activo = activo;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetalle=" + idDetalle + ", producto=" + producto + ", pedido=" + pedido + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.producto);
        hash = 67 * hash + Objects.hashCode(this.pedido);
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
        final DetallePedido other = (DetallePedido) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }

    
    
}
