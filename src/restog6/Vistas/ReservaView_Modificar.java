
package restog6.Vistas;

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
import modelos.Mesa;
import modelos.Reserva;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class ReservaView_Modificar extends javax.swing.JInternalFrame {
    private ReservaData reservaData = null;
    private MesaData mesaData = null;
    private Reserva reserva = null;
    
//    private boolean horaOk;
//    private boolean mesaOk;
    
    /**
     * Creates new form ReservaView_Modificar
     */
    public ReservaView_Modificar(ReservaData reservaData, MesaData mesaData, Reserva reserva) {
        initComponents();
        this.setTitle("Modificar Reserva");
        this.reservaData = reservaData;
        this.mesaData = mesaData;
        this.reserva = reserva;
        jdcFecha.setMinSelectableDate(new Date());
        
        llenarComboBoxMesas();
        
        int anio = reserva.getFechaReserva().getYear();
        int mes = reserva.getFechaReserva().getMonthValue();
        int dia = reserva.getFechaReserva().getDayOfMonth();
        int hora = reserva.getFechaReserva().getHour();
        Date date = new Date(anio-1900, mes-1, dia, hora, 0, 0);
        jdcFecha.setDate(date);//JOptionPane.showMessageDialog(this, jdcFecha.getDate());
        jtfHora.setText(hora+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlModificarReserva = new javax.swing.JLabel();
        jlNumeroMesa = new javax.swing.JLabel();
        jlFecha = new javax.swing.JLabel();
        jlHora = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jtfHora = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jbGuardarCambios = new javax.swing.JButton();
        jcbMesas = new javax.swing.JComboBox<>();

        jlModificarReserva.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlModificarReserva.setText("Modificar Reserva");

        jlNumeroMesa.setText("Nro Mesa");

        jlFecha.setText("Fecha");

        jlHora.setText("Hora");

        jdcFecha.setDateFormatString("yyyy-MM-dd");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGuardarCambios.setText("Guardar Cambios");
        jbGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlModificarReserva)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardarCambios)
                        .addGap(73, 73, 73)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNumeroMesa)
                            .addComponent(jlFecha)
                            .addComponent(jlHora))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbMesas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlModificarReserva)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroMesa)
                    .addComponent(jcbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFecha)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHora)
                    .addComponent(jtfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardarCambios))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarCambiosActionPerformed
        if(!hayCamposVacios()){
            if(validarHora()){
                //obtengo la hora nueva y la guardo en un LocalTime
                int horaNueva = Integer.parseInt(jtfHora.getText());
                LocalTime tiempo = LocalTime.of(horaNueva, 0, 0);
                
                //obtengo la fecha Nueva y la guardo en un LocalDate
                Date jDate = jdcFecha.getDate();
                LocalDate fecha = LocalDate.of(jDate.getYear()+1900, jDate.getMonth()+1, jDate.getDate());
                
                //guardo la fecha y hora nueva en un LocalDateTime
                LocalDateTime FechaCambiada = LocalDateTime.of(fecha, tiempo);
                
                reserva.setFechaReserva(FechaCambiada);
                reserva.setMesa((Mesa)jcbMesas.getSelectedItem());
                
                if(reservaData.modificarReserva(reserva)){
                    JOptionPane.showMessageDialog(this, "Reserva Modificada!");
                    this.dispose();
                }//MOSTRAR CARTEL DE CONFIRMACION
                
                //JOptionPane.showMessageDialog(this, cambios);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Hay Campos Vacíos!");
        }
    }//GEN-LAST:event_jbGuardarCambiosActionPerformed
    
    /**
     * Valida lo Ingresado en el JTextField Nro Mesa
     * @return true si está todo Bien, si no, false
     */
//    private boolean validarMesa(){
//        boolean correcto;
//        
//        try{
//            int n = Integer.parseInt(jtfNumeroMesa.getText());
//            
//            ArrayList<Integer> nroMesas = mesaData.getIdDeLasMesas();
//            
//            if(nroMesas.contains(n)){
//                correcto = true;
//            }else{
//                JOptionPane.showMessageDialog(this, "No Existe esa Mesa!");
//                correcto = false;
//                //jtfNumeroMesa.requestFocus();
//            }
//        }catch(NumberFormatException nfe){
//            JOptionPane.showMessageDialog(this, "Número de Mesa Incorrecto! Debe ser un Número!");
//            correcto = false;
//            //jtfNumeroMesa.requestFocus();
//        }
//        
//        return correcto;
//    }
    
    private void llenarComboBoxMesas(){
        ArrayList<Mesa> mesas = mesaData.getMesasActivas();
        
        Collections.sort(mesas, new Comparator<Mesa>(){
            @Override
            public int compare(Mesa t, Mesa t1) {
                if(t.getIdMesa() > t1.getIdMesa()){
                    return 1;
                }else{
                    if(t.getIdMesa() < t1.getIdMesa()){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        
        for(Mesa m : mesas){
            jcbMesas.addItem(m);
        }
    }
    
    /**
     * Valida lo Ingresado en el JTextField Hora
     * @return true si está todo Bien, si no, false
     */
    private boolean validarHora(){
        boolean correcto;
        
        try{
            int n = Integer.parseInt(jtfHora.getText());
            
            if(n < 19 || n > 23){//horarios de atencion
                JOptionPane.showMessageDialog(this, "Horario Incorrecto!");
                correcto = false;
                //jtfHora.requestFocus();
            }else{
                correcto = true;
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "La Hora Debe ser un Número!");
            correcto = false;
            //jtfHora.requestFocus();
        }
        
        return correcto;
    }
    
    /**
     * Comprueba que no haya campos vacios
     * @return true si hay algun campo vacio, de lo contrario retorna false
     */
    private boolean hayCamposVacios(){
        return jtfHora.getText().isEmpty() || jdcFecha.getDate() == null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardarCambios;
    private javax.swing.JComboBox<Mesa> jcbMesas;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHora;
    private javax.swing.JLabel jlModificarReserva;
    private javax.swing.JLabel jlNumeroMesa;
    private javax.swing.JTextField jtfHora;
    // End of variables declaration//GEN-END:variables
}