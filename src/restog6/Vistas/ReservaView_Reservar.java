
package restog6.Vistas;

import data.MesaData;
import data.ReservaData;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
public class ReservaView_Reservar extends javax.swing.JInternalFrame {
    private MesaData mesaData = null;
    private ReservaData reservaData = null;
    
//    private boolean horaCorrecta;
    
    /**
     * Creates new form ReservaView_Reservar
     */
    public ReservaView_Reservar(MesaData mesaData, ReservaData reservaData) {
        initComponents();
        this.setTitle("Reservar Mesa");
        this.mesaData = mesaData;
        this.reservaData = reservaData;
        llenarComboBoxMesas();
        jdcFechaReserva.setMinSelectableDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlMesas = new javax.swing.JLabel();
        jcbMesas = new javax.swing.JComboBox<>();
        jlFechaReserva = new javax.swing.JLabel();
        jdcFechaReserva = new com.toedter.calendar.JDateChooser();
        jlHoraReserva = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jtfHoraReserva = new javax.swing.JTextField();
        jbGuardarReserva = new javax.swing.JButton();
        jlNombreCliente = new javax.swing.JLabel();
        jtfNombreCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDniCliente = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Reservar Mesa");

        jlMesas.setText("Mesas");

        jlFechaReserva.setText("Fecha de Reserva");

        jdcFechaReserva.setDateFormatString("yyyy-MM-dd");

        jlHoraReserva.setText("Hora de Reserva");

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGuardarReserva.setText("Guardar Reserva");
        jbGuardarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarReservaActionPerformed(evt);
            }
        });

        jlNombreCliente.setText("Nombre Cliente");

        jLabel2.setText("DNI Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jbGuardarReserva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jtfDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlNombreCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlHoraReserva)
                                .addGap(18, 18, 18)
                                .addComponent(jtfHoraReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlMesas)
                                .addGap(18, 18, 18)
                                .addComponent(jcbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlFechaReserva)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMesas)
                    .addComponent(jcbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFechaReserva))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHoraReserva)
                    .addComponent(jtfHoraReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombreCliente)
                    .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardarReserva))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarReservaActionPerformed
        //si no hay campos vacíos y ademas el dni y la hora son correctas, procede con la reserva
        if(validarCamposVacios()){
            
            if(validarCadenaNumerica(jtfHoraReserva.getText())){
                
                int horaReserva = Integer.parseInt(jtfHoraReserva.getText());
                
                if(validarNombre(jtfNombreCliente.getText())){
                    
                    if(validarCadenaNumerica(jtfDniCliente.getText()) && jtfDniCliente.getText().length() == 8){
                        //una vez pasado el filtro, se procede con la reserva
                        Mesa mesaSeleccionada = (Mesa)jcbMesas.getSelectedItem();
            
                        //obtener la fecha del JCalendar
                        Date d = jdcFechaReserva.getDate();
                        d.setHours(horaReserva);
                        d.setMinutes(0);
                        d.setSeconds(0);
                        LocalDateTime fechaReserva = LocalDateTime.of(d.getYear()+1900, d.getMonth()+1, d.getDate(), d.getHours(), 0, 0);
                        
                        if(validarHorario(fechaReserva)){
                            //hace la reserva si no hay ninguna hecha para esa mesa y ese dia
                            if(!reservaData.verificarReservaDeMesaXFecha(mesaSeleccionada.getIdMesa(), fechaReserva)){
                                Reserva reserva = new Reserva(mesaSeleccionada, fechaReserva, jtfDniCliente.getText(), jtfNombreCliente.getText(), true);

                                if(reservaData.agregarReserva(reserva)){
                                    JOptionPane.showMessageDialog(this, "Reserva Guardada!");
                                    this.dispose();
                                }
                            }else{
                                JOptionPane.showMessageDialog(this, "La Mesa Ya Esta Reservada para esa Fecha!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "Hora Incorrecta! Está Fuera del Horario de Atención!");
                        }
                    }else{
                        if(jtfDniCliente.getText().length() != 8){
                            JOptionPane.showMessageDialog(this, "DNI incorrecto!");
                        }else{
                            JOptionPane.showMessageDialog(this, "El DNI Debe ser un Número!");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Nombre del Cliente Invalido!");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Hora Incorrecta! No es un Número!");
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Hay Campos Vacíos!");
        }
        
        
    }//GEN-LAST:event_jbGuardarReservaActionPerformed

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
     * Comprueba que un String sea Numerico
     * @param cadena que se desea comprobar
     * @return true si el String es numerico, si no, false
     */
    private boolean validarCadenaNumerica(String cadena){
        boolean correcto;
        
        try{
            long n = Long.parseLong(cadena);
            correcto = true;
        }catch(NumberFormatException nfe){
            correcto = false;
        }
        
        return correcto;
    }
    
    private boolean validarNombre(String nombre){
        boolean correcto = true;
        
        int i = 0;
        while(correcto && i < nombre.length()){
            if(!Character.isAlphabetic(nombre.charAt(i))){
                correcto = false;
            }
            i++;
        }
        
        return correcto;
    }
    
    /**
     * comprueba si la hora seleccionada es correcta
     * @param ldt fecha con la hora a comprobar
     * @return true la Hora es correcta, si no, false
     */
    private boolean validarHorario(LocalDateTime ldt){
        boolean correcto;
        
//        LocalTime lt = ldt.toLocalTime();
        LocalDate ld = ldt.toLocalDate();
        
        LocalTime ahora = LocalTime.now();
        LocalDate hoy = LocalDate.now();
        
//        LocalDateTime tiempo = LocalDateTime.now();
        
        if(ld.isAfter(hoy)){
            correcto = (ldt.getHour() >= 20 && ldt.getHour() <= 23);
        }else{
            correcto = ldt.getHour() > ahora.getHour();
        }
        
        return correcto;
    }
    
    /**
     * Revisa que no haya campos vacíos
     * @return true si no hay ningún campo vacío
     */
    private boolean validarCamposVacios(){
        boolean ningunVacio = true;
        
        ningunVacio &= jdcFechaReserva.getDate() != null;
        ningunVacio &= !jtfHoraReserva.getText().equals("");
        ningunVacio &= !jtfNombreCliente.getText().equals("");
        ningunVacio &= !jtfDniCliente.getText().equals("");
        
        return ningunVacio;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGuardarReserva;
    private javax.swing.JComboBox<Mesa> jcbMesas;
    private com.toedter.calendar.JDateChooser jdcFechaReserva;
    private javax.swing.JLabel jlFechaReserva;
    private javax.swing.JLabel jlHoraReserva;
    private javax.swing.JLabel jlMesas;
    private javax.swing.JLabel jlNombreCliente;
    private javax.swing.JTextField jtfDniCliente;
    private javax.swing.JTextField jtfHoraReserva;
    private javax.swing.JTextField jtfNombreCliente;
    // End of variables declaration//GEN-END:variables
}
