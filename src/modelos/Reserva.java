
package modelos;

import java.time.LocalDate;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class Reserva {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private int idReserva;
    private Mesa mesa;
    private LocalDate fechaReserva;
    private String dniCliente;
    private String nombreCliente;
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Reserva() {
    }

    public Reserva(Mesa mesa, LocalDate fechaReserva, String dniCliente, String nombreCliente, boolean activo) {
        this.mesa = mesa;
        this.fechaReserva = fechaReserva;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.activo = activo;
    }

    public Reserva(int idReserva, Mesa mesa, LocalDate fechaReserva, String dniCliente, String nombreCliente, boolean activo) {
        this.idReserva = idReserva;
        this.mesa = mesa;
        this.fechaReserva = fechaReserva;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.activo = activo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
        return "Reserva{" + "idReserva=" + idReserva + ", mesa=" + mesa + ", fechaReserva=" + fechaReserva + ", dniCliente=" + dniCliente + ", nombreCliente=" + nombreCliente + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idReserva;
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
        final Reserva other = (Reserva) obj;
        if (this.idReserva != other.idReserva) {
            return false;
        }
        return true;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------

    
}
