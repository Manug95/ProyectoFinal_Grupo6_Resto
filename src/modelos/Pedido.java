
package modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class Pedido {
    private int idPedido;
    private LocalDateTime fecha;
    private boolean pagado;
    private Mesa mesa; 
    private Mesero mesero;

    public Pedido() {
    }

    public Pedido(LocalDateTime fecha, boolean pagado, Mesa mesa, Mesero mesero) {
        this.fecha = fecha;
        this.pagado = pagado;
        this.mesa = mesa;
        this.mesero = mesero;
    }

    public Pedido(int idPedido, LocalDateTime fecha, boolean pagado, Mesa mesa, Mesero mesero) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.pagado = pagado;
        this.mesa = mesa;
        this.mesero = mesero;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", pagado=" + pagado + ", mesa=" + mesa + ", mesero=" + mesero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idPedido;
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
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }
    
    
    
}
