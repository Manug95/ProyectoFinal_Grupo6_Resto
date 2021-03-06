
package restog6.Vistas;

import data.Conexion;
import data.MesaData;
import data.ReservaData;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Reserva;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class ReservaView extends javax.swing.JInternalFrame {
    private MesaData mesaData;
    private ReservaData reservaData;
    private ArrayList<Reserva> listaReservas;
    private DefaultTableModel modeloTabla;
    
    private ReservaView_Reservar ventanaReservar = null;
    private ReservaView_Modificar ventanaModificar = null;
    
    private Comparator<Reserva> compaID;
    private Comparator<Reserva> compaNombre;
    private Comparator<Reserva> compaFecha;
    private Comparator<Reserva> compaMesa;
    
    /** Creates new form ReservaView */
    public ReservaView(Conexion conexion) {
        initComponents();
        
        this.setTitle("Reserva de Mesas");
        
        this.mesaData = new MesaData(conexion);
        this.reservaData = new ReservaData(conexion);
        this.modeloTabla = new DefaultTableModel();
        
        this.jdcFiltroFecha.setMinSelectableDate(new Date());
        this.jdcFiltroFecha.getDateEditor().setEnabled(false);
        
        armarTabla();
        
        compaID = new Comparator<Reserva>(){
            @Override
            public int compare(Reserva r, Reserva r1){
                if(r.getIdReserva() < r1.getIdReserva()){
                    return -1;
                }else{
                    if(r.getIdReserva() > r1.getIdReserva()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        };
        
        cargarReservasEnTabla(compaID);
        
        compaNombre = new Comparator<Reserva>(){
            @Override
            public int compare(Reserva r, Reserva r1){
                return r.getNombreCliente().compareTo(r1.getNombreCliente());
            }
        };
        compaFecha = new Comparator<Reserva>(){
            @Override
            public int compare(Reserva r, Reserva r1){
                if(r.getFechaReserva().isBefore(r1.getFechaReserva())){
                    return -1;
                }else{
                    if(r.getFechaReserva().isAfter(r1.getFechaReserva())){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        };
        compaMesa = new Comparator<Reserva>(){
            @Override
            public int compare(Reserva r, Reserva r1){
                if(r.getMesa().getIdMesa() < r1.getMesa().getIdMesa()){
                    return -1;
                }else{
                    if(r.getMesa().getIdMesa() > r1.getMesa().getIdMesa()){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            }
        };
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlReservaMesas = new javax.swing.JLabel();
        jbNuevaReserva = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReservasActivas = new javax.swing.JTable();
        jlFiltrarPor = new javax.swing.JLabel();
        jbCancelarReserva = new javax.swing.JButton();
        jbRefrescarTabla = new javax.swing.JButton();
        jbModificarReserva = new javax.swing.JButton();
        jbNombreCliente = new javax.swing.JButton();
        jbFechaReserva = new javax.swing.JButton();
        jlOrdenarPor = new javax.swing.JLabel();
        jbMesas = new javax.swing.JButton();
        jbFiltroNombre = new javax.swing.JButton();
        jbFiltroFecha = new javax.swing.JButton();
        jbFiltroMesa = new javax.swing.JButton();
        jdcFiltroFecha = new com.toedter.calendar.JDateChooser();

        setResizable(true);

        jlReservaMesas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlReservaMesas.setText("Reserva de Mesas");

        jbNuevaReserva.setText("Nueva Reserva");
        jbNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaReservaActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jtReservasActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtReservasActivas);

        jlFiltrarPor.setText("Filtrar Por");

        jbCancelarReserva.setText("Cancelar Reserva");
        jbCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarReservaActionPerformed(evt);
            }
        });

        jbRefrescarTabla.setText("Refrescar Tabla");
        jbRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarTabla(evt);
            }
        });

        jbModificarReserva.setText("Modificar Reserva");
        jbModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarReservaActionPerformed(evt);
            }
        });

        jbNombreCliente.setText("Nombre Cliente");
        jbNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNombreClienteActionPerformed(evt);
            }
        });

        jbFechaReserva.setText("Fecha Reserva");
        jbFechaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFechaReservaActionPerformed(evt);
            }
        });

        jlOrdenarPor.setText("Ordenar Por");

        jbMesas.setText("Mesa");
        jbMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMesasActionPerformed(evt);
            }
        });

        jbFiltroNombre.setText("Nombre");
        jbFiltroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltroNombreActionPerformed(evt);
            }
        });

        jbFiltroFecha.setText("Fecha");
        jbFiltroFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltroFechaActionPerformed(evt);
            }
        });

        jbFiltroMesa.setText("Mesa");
        jbFiltroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltroMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jbNuevaReserva)
                        .addGap(50, 50, 50)
                        .addComponent(jbCancelarReserva)
                        .addGap(65, 65, 65)
                        .addComponent(jbModificarReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlOrdenarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbNombreCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jbFechaReserva)
                                .addGap(18, 18, 18)
                                .addComponent(jbMesas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbRefrescarTabla))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlFiltrarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbFiltroNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbFiltroMesa)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jlReservaMesas)
                                        .addGap(223, 223, 223))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdcFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbFiltroFecha)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlReservaMesas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlFiltrarPor)
                        .addComponent(jbFiltroNombre)
                        .addComponent(jbFiltroMesa))
                    .addComponent(jbFiltroFecha)
                    .addComponent(jdcFiltroFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlOrdenarPor)
                    .addComponent(jbNombreCliente)
                    .addComponent(jbFechaReserva)
                    .addComponent(jbMesas)
                    .addComponent(jbRefrescarTabla))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevaReserva)
                    .addComponent(jbCancelarReserva)
                    .addComponent(jbModificarReserva)
                    .addComponent(jbCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaReservaActionPerformed
        if(ventanaReservar == null){
            ventanaReservar = new ReservaView_Reservar(mesaData, reservaData);
            
            if(ventanaModificar != null){
                ventanaModificar.dispose();
                ventanaModificar = null;
            }
        
            Menu.jDesktopPane1.add(ventanaReservar);
            ventanaReservar.toFront();
            ventanaReservar.setVisible(true);
        }else{
            ventanaReservar.dispose();
            
            if(ventanaModificar != null){
                ventanaModificar.dispose();
                ventanaModificar = null;
            }
            
            ventanaReservar = new ReservaView_Reservar(mesaData, reservaData);
        
            Menu.jDesktopPane1.add(ventanaReservar);
            ventanaReservar.toFront();
            ventanaReservar.setVisible(true);
        }
    }//GEN-LAST:event_jbNuevaReservaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarReservaActionPerformed
        //Reserva reservaSeleccionada;
        if(jtReservasActivas.getSelectedRow() != -1){
            int filaSelect = jtReservasActivas.getSelectedRow();
            
            int idReserva = (Integer)modeloTabla.getValueAt(filaSelect, 0);
            String nombre = (String)modeloTabla.getValueAt(filaSelect, 1);
            
            if(JOptionPane.showConfirmDialog(this, "Confirmar Cancelaci??n de la Reserva " + idReserva + "\nDel Cliente " + nombre) == 0){
                if(reservaData.borrarReserva(idReserva)){
                    JOptionPane.showMessageDialog(this, "Reserva Cancelada!");
                    borrarFilasTabla();
                    cargarReservasEnTabla(compaID);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una Reserva para Cancelarla!");
        }
        
    }//GEN-LAST:event_jbCancelarReservaActionPerformed

    private void refrescarTabla(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarTabla
        borrarFilasTabla();
        cargarReservasEnTabla(compaID);
        jdcFiltroFecha.setDate(null);
    }//GEN-LAST:event_refrescarTabla

    /**
     * Solo se puede modificar la mesa, la hora y el d??a
     * @param evt click
     */
    private void jbModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarReservaActionPerformed
        if(jtReservasActivas.getSelectedRow() != -1){
            int filaSelect = jtReservasActivas.getSelectedRow();
            
            int idReservaSeleccionada = (Integer)modeloTabla.getValueAt(filaSelect, 0);
            
            Reserva reservaSeleccionada = reservaData.getReservaPorId(idReservaSeleccionada);
            
            if(ventanaModificar == null){
                ventanaModificar = new ReservaView_Modificar(reservaData, mesaData, reservaSeleccionada);
                
                if(ventanaReservar != null){
                    ventanaReservar.dispose();
                    ventanaReservar = null;
                }
            
                Menu.jDesktopPane1.add(ventanaModificar);
                ventanaModificar.toFront();
                ventanaModificar.setVisible(true);
            }else{
                ventanaModificar.dispose();
                
                if(ventanaReservar != null){
                    ventanaReservar.dispose();
                    ventanaReservar = null;
                }
                
                ventanaModificar = new ReservaView_Modificar(reservaData, mesaData, reservaSeleccionada);
            
                Menu.jDesktopPane1.add(ventanaModificar);
                ventanaModificar.toFront();
                ventanaModificar.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una Reserva para Modificar!");
        }
        
    }//GEN-LAST:event_jbModificarReservaActionPerformed

    private void jbNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNombreClienteActionPerformed
        borrarFilasTabla();
        cargarReservasEnTabla(compaNombre);
        jdcFiltroFecha.setDate(null);
    }//GEN-LAST:event_jbNombreClienteActionPerformed

    private void jbFechaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFechaReservaActionPerformed
        borrarFilasTabla();
        cargarReservasEnTabla(compaFecha);
        jdcFiltroFecha.setDate(null);
    }//GEN-LAST:event_jbFechaReservaActionPerformed

    private void jbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMesasActionPerformed
        borrarFilasTabla();
        cargarReservasEnTabla(compaMesa);
        jdcFiltroFecha.setDate(null);
    }//GEN-LAST:event_jbMesasActionPerformed

    private void jbFiltroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltroNombreActionPerformed
        jdcFiltroFecha.setDate(null);
        
        String respuesta = JOptionPane.showInternalInputDialog(this, "Nombre: ");
        
        if(respuesta != null){
            listaReservas = reservaData.getReservasPorNombreCliente(respuesta);
        
            if(!listaReservas.isEmpty()){
                borrarFilasTabla();
                cargarReservasFiltradas(compaNombre);
            }else{
                JOptionPane.showMessageDialog(this, "No Hay Reservas con el Nombre " + respuesta);
            }
        }
    }//GEN-LAST:event_jbFiltroNombreActionPerformed

    private void jbFiltroFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltroFechaActionPerformed
        if(jdcFiltroFecha.getDate() != null){
            LocalDate ld = LocalDate.of(jdcFiltroFecha.getDate().getYear()+1900, jdcFiltroFecha.getDate().getMonth()+1, jdcFiltroFecha.getDate().getDate());
            
            listaReservas = (ArrayList<Reserva>)reservaData.getReservasPorFecha(ld);

            if(!listaReservas.isEmpty()){
                borrarFilasTabla();
                cargarReservasFiltradas(compaFecha);
                jdcFiltroFecha.setDate(null);
            }else{
                JOptionPane.showMessageDialog(this, "No Hay Reservas en la Fecha " + ld);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una Fecha para Poder Filtrar!");
        }
    }//GEN-LAST:event_jbFiltroFechaActionPerformed

    private void jbFiltroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltroMesaActionPerformed
        jdcFiltroFecha.setDate(null);
        
        String respuesta = JOptionPane.showInternalInputDialog(this, "Nro Mesa: ");
        
        if(respuesta != null){
            try{
                int id = Integer.parseInt(respuesta);

                if(id <= 0){
                    JOptionPane.showMessageDialog(this, "El Nro de Mesa Debe ser Positivo!");
                }else{
                    listaReservas = reservaData.getReservasPorMesa(id);

                    if(!listaReservas.isEmpty()){
                        borrarFilasTabla();
                        cargarReservasFiltradas(compaMesa);
                    }else{
                        JOptionPane.showMessageDialog(this, "No Hay Reservas con la Mesa " + respuesta);
                    }
                }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(this, respuesta + " No es un N??mero!");
            }
        }
    }//GEN-LAST:event_jbFiltroMesaActionPerformed

    /**
     * Arma el Modelo de la Tabla
     */
    private void armarTabla(){
        ArrayList<Object> columnas = new ArrayList<>();
        
        columnas.add("ID");
        columnas.add("Cliente");
        columnas.add("DNI");
        columnas.add("Fecha y Hora");
        columnas.add("Mesa");
        
        for(Object col : columnas){
            modeloTabla.addColumn(col);
        }
        
        jtReservasActivas.setModel(modeloTabla);
    }
    
    /**
     * Llena la Tabla con las Reservas Activas
     */
    private void cargarReservasEnTabla(Comparator compa){
        listaReservas = reservaData.getReservasActivas();
        
        if(!listaReservas.isEmpty()){
            Collections.sort(listaReservas, compa);
        
            for(Reserva r : listaReservas){
                if(reservaVigente(r)){
                    String horaYFecha = r.getFechaReserva().toString();
                    horaYFecha = horaYFecha.replace("T", " / ");
                    modeloTabla.addRow(new Object[]{
                        r.getIdReserva(), r.getNombreCliente(), r.getDniCliente(), horaYFecha, r.getMesa().getIdMesa()
                    });
                }else{
                    reservaData.borrarReserva(r.getIdReserva());
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "No Hay Reservas Activas!");
        }
        
    }
    
    private void cargarReservasFiltradas(Comparator<Reserva> compa){
        Collections.sort(listaReservas, compa);
        
        for(Reserva r : listaReservas){
            String horaYFecha = r.getFechaReserva().toString();
            horaYFecha = horaYFecha.replace("T", " / ");
            modeloTabla.addRow(new Object[]{
                r.getIdReserva(), r.getNombreCliente(), r.getDniCliente(), horaYFecha, r.getMesa().getIdMesa()
            });
        }
    }
    
    /**
     * Limpia la Tabla
     */
    private void borrarFilasTabla() {
        int a = modeloTabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    
    /**
     * Comprueba que la fecha y hora de una reserva no sean viejas
     * @param reserva de la que se verifica la fecha y hora
     * @return true si la reserva es vigente, si no, false
     */
    private boolean reservaVigente(Reserva reserva){//con compararlo con un LocalDateTime con la fecha y hora actuales bastaba!!!
        boolean esVigente;
        
        LocalDateTime fReser = reserva.getFechaReserva();
        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        
        if(fReser.toLocalDate().isBefore(hoy)){//si la fecha de reserva es anterior al la fecha actual
            esVigente = false;
        }else{
            if(!fReser.toLocalDate().isAfter(hoy)){//si la fecha de reserva NO es posterior a la fecha actual
                if(fReser.toLocalTime().isBefore(ahora)){//si la hora de reserva es anterior a la hora actual
                    esVigente = false;
                }else{
                    esVigente = true;
                }
            }else{
                esVigente = true;
            } 
        }
        
        return esVigente;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCancelarReserva;
    private javax.swing.JButton jbFechaReserva;
    private javax.swing.JButton jbFiltroFecha;
    private javax.swing.JButton jbFiltroMesa;
    private javax.swing.JButton jbFiltroNombre;
    private javax.swing.JButton jbMesas;
    private javax.swing.JButton jbModificarReserva;
    private javax.swing.JButton jbNombreCliente;
    private javax.swing.JButton jbNuevaReserva;
    private javax.swing.JButton jbRefrescarTabla;
    private com.toedter.calendar.JDateChooser jdcFiltroFecha;
    private javax.swing.JLabel jlFiltrarPor;
    private javax.swing.JLabel jlOrdenarPor;
    private javax.swing.JLabel jlReservaMesas;
    private javax.swing.JTable jtReservasActivas;
    // End of variables declaration//GEN-END:variables

}
