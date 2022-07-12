

package restog6.Vistas;

import data.Conexion;
import data.MesaData;
import data.ReservaData;
import java.util.ArrayList;
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
    
    /** Creates new form ReservaView */
    public ReservaView(Conexion conexion) {
        initComponents();
        
        this.setTitle("Reserva de Mesas");
        
        this.mesaData = new MesaData(conexion);
        this.reservaData = new ReservaData(conexion);
        this.modeloTabla = new DefaultTableModel();
        
        armarTabla();
        cargarReservasEnTabla();
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
        jlReservasActivas = new javax.swing.JLabel();
        jbCancelarReserva = new javax.swing.JButton();
        jbRefrescarTabla = new javax.swing.JButton();
        jbModificarReserva = new javax.swing.JButton();

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

        jlReservasActivas.setText("Reservas Activas");

        jbCancelarReserva.setText("Cancelar Reserva");
        jbCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarReservaActionPerformed(evt);
            }
        });

        jbRefrescarTabla.setText("Refrescar Tabla");
        jbRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefrescarTablaActionPerformed(evt);
            }
        });

        jbModificarReserva.setText("Modificar Reserva");
        jbModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jlReservasActivas)
                        .addGap(33, 33, 33)
                        .addComponent(jbRefrescarTabla))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jlReservaMesas)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbNuevaReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelarReserva)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificarReserva)
                        .addGap(27, 27, 27)
                        .addComponent(jbCancelar)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlReservaMesas)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlReservasActivas)
                    .addComponent(jbRefrescarTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevaReserva)
                    .addComponent(jbCancelar)
                    .addComponent(jbCancelarReserva)
                    .addComponent(jbModificarReserva))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaReservaActionPerformed
        ReservaView_Reservar ventanaReservar = new ReservaView_Reservar(mesaData, reservaData);
        
        Menu.jDesktopPane1.add(ventanaReservar);
        ventanaReservar.toFront();
        ventanaReservar.setVisible(true);

    }//GEN-LAST:event_jbNuevaReservaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarReservaActionPerformed
        Reserva reservaSeleccionada;
        if(jtReservasActivas.getSelectedRow() != -1){
            int filaSelect = jtReservasActivas.getSelectedRow();
            
            int idReserva = (Integer)modeloTabla.getValueAt(filaSelect, 0);
            String nombre = (String)modeloTabla.getValueAt(filaSelect, 1);
            
            if(JOptionPane.showConfirmDialog(this, "Confirmar Cancelación de la Reserva " + idReserva + "\nDel Cliente " + nombre) == 0){
                if(reservaData.borrarReserva(idReserva)){
                    JOptionPane.showMessageDialog(this, "Reserva Cancelada!");
                    borrarFilasTabla();
                    cargarReservasEnTabla();
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione una Reserva para Cancelarla!");
        }
        
    }//GEN-LAST:event_jbCancelarReservaActionPerformed

    private void jbRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefrescarTablaActionPerformed
        borrarFilasTabla();
        cargarReservasEnTabla();
    }//GEN-LAST:event_jbRefrescarTablaActionPerformed

    /**
     * Solo se puede modificar la mesa, la hora y el día
     * @param evt click
     */
    private void jbModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarReservaActionPerformed
        if(jtReservasActivas.getSelectedRow() != -1){
            int filaSelect = jtReservasActivas.getSelectedRow();
            
            int idReservaSeleccionada = (Integer)modeloTabla.getValueAt(filaSelect, 0);
            
            Reserva reservaSeleccionada = reservaData.getReservaPorId(idReservaSeleccionada);
            
            //CREAR LA VISTA MODIFICAR
            ReservaView_Modificar ventanaModificar = new ReservaView_Modificar(reservaData, mesaData, reservaSeleccionada);
            
            Menu.jDesktopPane1.add(ventanaModificar);
            ventanaModificar.toFront();
            ventanaModificar.setVisible(true);
        }
        
    }//GEN-LAST:event_jbModificarReservaActionPerformed

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
    private void cargarReservasEnTabla(){
        listaReservas = reservaData.getReservasActivas();
        
        for(Reserva r : listaReservas){
            String horaYFecha = r.getFechaReserva().toString();
            horaYFecha = horaYFecha.replace("T", " ");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbCancelarReserva;
    private javax.swing.JButton jbModificarReserva;
    private javax.swing.JButton jbNuevaReserva;
    private javax.swing.JButton jbRefrescarTabla;
    private javax.swing.JLabel jlReservaMesas;
    private javax.swing.JLabel jlReservasActivas;
    private javax.swing.JTable jtReservasActivas;
    // End of variables declaration//GEN-END:variables

}
