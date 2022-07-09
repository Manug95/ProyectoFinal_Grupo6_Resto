
package restog6;

import data.Conexion;
import data.MesaData;
import data.ReservaData;
import java.util.ArrayList;
import modelos.Mesa;
import modelos.Reserva;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class resto {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        MesaData mesaData = new MesaData(conexion);
        ReservaData reservaData = new ReservaData(conexion);
        
        ArrayList<Mesa> mesas;
        ArrayList<Reserva> reservas;
 
        //pruebas metodos CRUD de MesaData
        //---------------------------------------------------------------------------------------------------
        //-----agregamos una mesa a la bd-----
//        Mesa m = new Mesa(2, 'a', true);
//        if(mesaData.agregarMesa(m)){
//            System.out.println("se agrego la mesa!");
//        }

        //-----borrar mesa-----
//        if(mesaData.borrarMesa(1)){
//            System.out.println("se borro la mesa!");
//        }


        //-----obtener mesa-----
        //Mesa m = mesaData.getMesaPorId(2);
//        System.out.println(m);
        
        
        //-----modificar mesa-----
//        m.setCapacidad(4);
//        m.setEstado('O');
//        if(mesaData.modificarMesa(m)){
//            System.out.println("se modifico la mesa!");
//        }else{
//            System.out.println("no se modifico!");
//        }
//        System.out.println(m);

        //-----obtener las mesas activas-----
//        mesas = mesaData.getMesasActivas();
//        mesas.forEach(m -> {System.out.println(m);});

        //-----obtener las mesas segun estado-----
//        mesas = mesaData.getMesasSegunEstado('A');
//        mesas.forEach(m -> {System.out.println(m);});

        //obtener las mesas segun capacidad
//        mesas = mesaData.getMesasSegunCapacidad(4);
//        mesas.forEach(m -> {System.out.println(m);});

        //obtener las mesas reservadas
//        mesas = mesaData.getMesasReservadas();
//        mesas.forEach(m -> {System.out.println(m);});

        //obtener mesas no reservadas
        mesas = mesaData.getMesasNoReservadas();
        mesas.forEach(m -> {System.out.println(m);});
        
        //--------------------------------------------------------------------------------------------------
        //pruebas metodos CRUD ReservaData
        
        //agregar una reserva
//        Reserva r = new Reserva(m, LocalDate.now(), "97654321", "Robertito", true);
//        if(reservaData.agregarReserva(r)){
//            System.out.println("se agrego la reserva!");
//        }

        //obtener y modificar una reserva
//        Reserva r = reservaData.obtenerReservaPorId(6);
//        System.out.println(r);
//        
//        r.setDniCliente("11111111");
//        if(reservaData.modificarReserva(r)){
//            System.out.println("se modifico la reserva!");
//        }else{
//            System.out.println("no se modifico!");
//        }

        //borrar una reserva
//        if(reservaData.borrarReserva(6)){
//            System.out.println("se borro la reserva!");
//        }else{
//            System.out.println("no se borro!");
//        }

        //obtener reservas activas
//        reservas = reservaData.obtenerReservasActivas();
//        reservas.forEach(r -> {System.out.println(r);});
    }

}
