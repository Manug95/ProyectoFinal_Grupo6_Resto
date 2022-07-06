
package modelos;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class Mesa {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private int idMesa;
    private int capacidad;
    private char estado; //ocuapda(O) - libre(L) - atendida(A)
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, char estado, boolean activo) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.activo = activo;
    }

    public Mesa(int capacidad, char estado, boolean activo) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.activo = activo;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
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
        return "idMesa=" + idMesa + ", estado=" + estado + "capacidad: " + capacidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idMesa;
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
        final Mesa other = (Mesa) obj;
        if (this.idMesa != other.idMesa) {
            return false;
        }
        return true;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
