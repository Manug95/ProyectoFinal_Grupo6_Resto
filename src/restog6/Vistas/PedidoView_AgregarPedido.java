/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restog6.Vistas;

import data.Conexion;
import data.DetallePedidoData;
import data.MesaData;
import data.MeseroData;
import data.PedidoData;
import data.ReservaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.DetallePedido;
import modelos.Mesa;
import modelos.Mesero;
import modelos.Pedido;
import modelos.Reserva;

/**
 * @author Grupo 6 Fernandez Valentina Romero Jorge Manuel Gutierrez
 */
public class PedidoView_AgregarPedido extends javax.swing.JInternalFrame {

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public PedidoView_AgregarPedido(Conexion con) {
        initComponents();
        this.con = con;
        detalleD = new DetallePedidoData(con);
        reservaD = new ReservaData(con);
        meseroD = new MeseroData(con);
        pedidoD = new PedidoData(con);
        mesaD = new MesaData(con);
        llenarReservaJCB((ArrayList<Reserva>) reservaD.getReservasPorFecha(LocalDate.now()));
        llenarMeseroJCB((ArrayList) meseroD.todosLosMeseros());
    }

    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbReserva = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbMesero = new javax.swing.JComboBox<>();
        jbNext = new javax.swing.JButton();
        jcbCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(37, 37, 45));
        setResizable(true);
        setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORDENAR");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jLabel1.setOpaque(true);

        jLabel2.setText("Reserva");

        jcbReserva.setBackground(new java.awt.Color(241, 217, 228));
        jcbReserva.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jcbReserva.setForeground(new java.awt.Color(157, 102, 130));
        jcbReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setText("Mesero");

        jcbMesero.setBackground(new java.awt.Color(241, 217, 228));
        jcbMesero.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jcbMesero.setForeground(new java.awt.Color(157, 102, 130));

        jbNext.setBackground(new java.awt.Color(102, 102, 102));
        jbNext.setForeground(new java.awt.Color(51, 51, 51));
        jbNext.setText("Siguiente");
        jbNext.setBorder(null);
        jbNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNextActionPerformed(evt);
            }
        });

        jcbCancel.setBackground(new java.awt.Color(102, 102, 102));
        jcbCancel.setText("Cancelar");
        jcbCancel.setBorder(null);
        jcbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jcbMesero, 0, 279, Short.MAX_VALUE)
                            .addComponent(jcbReserva, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jcbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--------------  [BOTON SIGUIENTE]  ---------------
    private void jbNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNextActionPerformed
        Menu.jDesktopPane1.removeAll();
        Menu.jDesktopPane1.repaint();
        Pedido pedido = new Pedido();
        pedido.setPagado(false);
        pedido.setMesero((Mesero) jcbMesero.getSelectedItem());
        pedido.setMesa(((Reserva) jcbReserva.getSelectedItem()).getMesa());
        if (pedidoD.agregarPedido(pedido)) {
            mesaD.modificarEstadoDeMesa(pedido.getMesa().getIdMesa(), 'A');
            PedidoView_AgregarDetalles pv = new PedidoView_AgregarDetalles(con, pedido);
            pv.setVisible(true);
            Menu.jDesktopPane1.add(pv);
            Menu.jDesktopPane1.moveToFront(pv);
        } else {
            JOptionPane.showMessageDialog(this, "No se logro agregar el pedido");
        }
    }//GEN-LAST:event_jbNextActionPerformed

    //--------------  [BOTON CANCELAR]  ----------------
    private void jcbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jcbCancelActionPerformed

    //--------------  [LLENAR COMBOBOX]  ---------------
    private void llenarReservaJCB(ArrayList<Reserva> lista) {
        for (Reserva r : lista) {
            this.jcbReserva.addItem(r);
        }
    }

    private void llenarMeseroJCB(ArrayList<Mesero> lista) {
        for (Mesero m : lista) {
            this.jcbMesero.addItem(m);
        }
    }

    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private PedidoData pedidoD;
    private MeseroData meseroD;
    private DetallePedidoData detalleD;
    private ReservaData reservaD;
    private MesaData mesaD;
    private Conexion con;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbNext;
    private javax.swing.JButton jcbCancel;
    private javax.swing.JComboBox<Mesero> jcbMesero;
    private javax.swing.JComboBox<Reserva> jcbReserva;
    // End of variables declaration//GEN-END:variables
}
