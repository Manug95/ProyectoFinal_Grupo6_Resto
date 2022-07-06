
package modelos;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class Mesero {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private int idMesero;
    private String nombreMesero;
    private String apellido;
    private String dni;
    private String telefono;
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Mesero() {
    }

    public Mesero(int idMesero, String nombre, String apellido, String dni, String telefono, boolean activo) {
        this.idMesero = idMesero;
        this.nombreMesero = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Mesero(String nombre, String apellido, String dni, String telefono, boolean activo) {
        this.nombreMesero = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombre) {
        this.nombreMesero = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return "NombreMesero=" + nombreMesero + ", apellido=" + apellido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idMesero;
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
        final Mesero other = (Mesero) obj;
        if (this.idMesero != other.idMesero) {
            return false;
        }
        return true;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
