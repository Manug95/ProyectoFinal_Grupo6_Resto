/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restog6.Vistas;

import data.Conexion;
import data.DetallePedidoData;
import data.PedidoData;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.DetallePedido;
import modelos.Mesa;
import modelos.Mesero;
import modelos.Pedido;
import modelos.Producto;
import modelos.Reserva;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class PedidoView2 extends javax.swing.JInternalFrame {

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    
    public PedidoView2(Conexion con, Pedido pedido) {
        initComponents();
        model = new DefaultTableModel();
        detalleD = new DetallePedidoData(con);
        pedidoD = new PedidoData(con);
        llenarCabeceraTable();
        this.pedido = pedido;
        this.jbEliminar.setEnabled(false);
        this.jbAgregar.setEnabled(false);
        //llenarProductoJCB();
        //llenarCantidadJCB();
        //calcularTotal();
    }

    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcbProducto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfSubtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbFinalizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jcbCantidad = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPedido = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(37, 37, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");

        jtfSubtotal.setEditable(false);

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ORDENAR");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jLabel4.setOpaque(true);

        jbFinalizar.setBackground(new java.awt.Color(102, 102, 102));
        jbFinalizar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        jbFinalizar.setText("Finalizar");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(102, 102, 102));
        jbEliminar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbEliminar.setText("Cancelar Pedido");
        jbEliminar.setBorder(null);
        jbEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jtPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtPedidoFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(jtPedido);

        jbAgregar.setBackground(new java.awt.Color(102, 102, 102));
        jbAgregar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbAgregar.setText("Agregar");
        jbAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(jtfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jbFinalizar)
                                .addGap(27, 27, 27)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //-------------  [BOTON ELIMINAR]  ----------------
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jtPedido.getSelectedRow() != -1){
            int id = (int) jtPedido.getValueAt(jtPedido.getSelectedRow(), 0);
            DetallePedido detallePedido = detalleD.obtenerDetallePedido(id);
            if (detalleD.eliminarDetallePedido(detallePedido.getPedido(), detallePedido.getProducto())){
                JOptionPane.showMessageDialog(this, "Se ha eliminado el pedido correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar uno de los pedidos de la lista");
        }
        llenarTable();
        //calcularTotal();
    }//GEN-LAST:event_jbEliminarActionPerformed

    //-------------  [BOTON AGREGAR]  -----------------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        DetallePedido dp = new DetallePedido();
        dp.setPedido(pedido);
        dp.setActivo(true);
//        dp.setProducto((Producto)jcbProducto.getSelectedItem());
//        dp.setCantidad((int)jcbCantidad.getSelectedItem());
//        if (detalleD.agregarDetallePedido(dp)){
//            JOptionPane.showMessageDialog(this, "Se agrego el pedido con exito!");
//        } else {
//            JOptionPane.showMessageDialog(this, "No se logro agregar el pedido");
//        }
        llenarTable();
        //calcularTotal();
    }//GEN-LAST:event_jbAgregarActionPerformed

    //-------------  [BOTON FINALIZAR]  ---------------
    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        if (pedidoD.agregarPedido(pedido)){
            JOptionPane.showMessageDialog(this, "Se agrego su pedido con exito!");
        } else {
            JOptionPane.showMessageDialog(this, "No se logro agregar el pedido");
        }
        dispose();
    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void jtPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPedidoFocusGained
        this.jbEliminar.setEnabled(true);
        this.jbAgregar.setEnabled(true);
    }//GEN-LAST:event_jtPedidoFocusGained

    private void calcularTotal(){
        int a = this.jtPedido.getRowCount();
        double subtotal = 0;
        for (int i = a; i >= 0; i--) {
            subtotal += (double)this.jtPedido.getValueAt(i, 3);
        }
        this.jtfSubtotal.setText(subtotal+"");
    }
    
    //-----------------  [TABLA]  ---------------------
    private void llenarTable(){
        borrarFilasTable();
        for (DetallePedido o : detalleD.obtenerDetallesPedidos(pedido.getIdPedido())) {
            model.addRow(new Object[]{
                o.getIdDetalle(), o.getProducto(), o.getCantidad(), o.getSubtotal()
            });
        }        
    }
    
    private void borrarFilasTable(){
        int a = model.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    private void llenarCabeceraTable(){
        ArrayList<Object> c = new ArrayList<>();
        c.add("Codigo");
        c.add("PRODUCTO");
        c.add("CANT.");
        c.add("SUBTOTAL");
        for (Object o : c) {
            model.addColumn(o);
        }
        this.jtPedido.setModel(model);
    }
    
    //------------------  [COMBOBOX]  -------------------
    private void llenarProductoJCB(){
        for (Producto o : pedidoD.obtenerProductosNoPedidos(pedido)) {
            this.jcbProducto.addItem(o);
            //Don't forget to check pedidoD 'cause you got some code commented
        }
    }
    private void llenarCantidadJCB(){
        Producto p = (Producto)jcbProducto.getSelectedItem();
        int c = p.getStock();
        for (int i = 0; i < c; i++) {
            this.jcbCantidad.addItem(i);
        }
    }

    //                                          ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    
    private PedidoData pedidoD;
    private Pedido pedido;
    private DetallePedidoData detalleD;
    private DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbFinalizar;
    private javax.swing.JComboBox<Integer> jcbCantidad;
    private javax.swing.JComboBox<Producto> jcbProducto;
    private javax.swing.JTable jtPedido;
    private javax.swing.JTextField jtfSubtotal;
    // End of variables declaration//GEN-END:variables
}
