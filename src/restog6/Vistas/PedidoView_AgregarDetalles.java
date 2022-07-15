/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restog6.Vistas;

import data.Conexion;
import data.DetallePedidoData;
import data.MesaData;
import data.PedidoData;
import data.ProductoData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.DetallePedido;
import modelos.Pedido;
import modelos.Producto;

/**
 * @author Grupo 6 Fernandez Valentina Romero Jorge Manuel Gutierrez
 */
public class PedidoView_AgregarDetalles extends javax.swing.JInternalFrame {

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public PedidoView_AgregarDetalles(Conexion con, Pedido pedido) {
        initComponents();
        model = new DefaultTableModel();
        detalleD = new DetallePedidoData(con);
        pedidoD = new PedidoData(con);
        productoD = new ProductoData(con);
        mesaD = new MesaData(con);
        llenarCabeceraTable();
        this.pedido = pedido;
        llenarProductoJCB();
        llenarCantidadJCB();
        calcularTotal();
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
        jbCancelar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();

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
        setBorder(null);
        setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto");

        jcbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");

        jtfSubtotal.setEditable(false);
        jtfSubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtfSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        jtfSubtotal.setBorder(null);
        jtfSubtotal.setOpaque(false);

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
        jbFinalizar.setText("Finalizar Pedido");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(102, 102, 102));
        jbEliminar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbEliminar.setText("Eliminar");
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPedido.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jtPedido.setShowHorizontalLines(false);
        jtPedido.getTableHeader().setReorderingAllowed(false);
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
        jbAgregar.setPreferredSize(new java.awt.Dimension(93, 37));
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(102, 102, 102));
        jbCancelar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setText("Cancelar Pedido");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbModificar.setBackground(new java.awt.Color(102, 102, 102));
        jbModificar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jbModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbModificar.setText("Modificar");
        jbModificar.setPreferredSize(new java.awt.Dimension(105, 37));
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbFinalizar))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(28, 28, 28)
                                        .addComponent(jtfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(226, 226, 226)))))))
                .addContainerGap(72, Short.MAX_VALUE))
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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //-------------  [BOTON ELIMINAR]  ----------------
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (jtPedido.getSelectedRow() != -1) {
            int id = (int) jtPedido.getValueAt(jtPedido.getSelectedRow(), 0);
            DetallePedido detallePedido = detalleD.obtenerDetallePedido(id);
            if (detalleD.eliminarDetallePedido(detallePedido.getIdDetalle())) {
                Producto p = detallePedido.getProducto();
                p.setStock(p.getStock()+ detallePedido.getCantidad());
                if (productoD.modificarProducto(p)){
                    JOptionPane.showMessageDialog(this, "Se ha eliminado el pedido correctamente");
                }
                this.llenarProductoJCB();
                this.llenarCantidadJCB();
                llenarTable();
                calcularTotal();
            } else {
                JOptionPane.showMessageDialog(this, "No se logro agregar el pedido...");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar uno de los pedidos de la lista");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    //-------------  [BOTON AGREGAR]  -----------------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        DetallePedido dp = new DetallePedido();
        dp.setPedido(this.pedido);
        dp.setActivo(true);
        dp.setProducto((Producto) jcbProducto.getSelectedItem());
        dp.setCantidad((int) jcbCantidad.getSelectedItem());
        if (detalleD.agregarDetallePedido(dp)) {
            JOptionPane.showMessageDialog(this, "Se agrego su orden con exito!");
            llenarTable();
            llenarProductoJCB();
            llenarCantidadJCB();
            calcularTotal();
        } else {
            JOptionPane.showMessageDialog(this, "No se logro agregar su orden");
        }

    }//GEN-LAST:event_jbAgregarActionPerformed

    //-------------  [BOTON FINALIZAR]  ---------------
    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        if (this.jtPedido.getRowCount() != 0) {
            JOptionPane.showMessageDialog(this, "Su pedido ha sido guardado! /n Subtotal: $" + this.jtfSubtotal.getText());
        } else {
            if (pedidoD.eliminarPedido(pedido.getIdPedido())) {
                JOptionPane.showMessageDialog(this, "Su pedido se ha eliminado ya que no contenia ninguna orden!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error, no se logro eliminar el pedido");
            }
        }
        dispose();
    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void jtPedidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPedidoFocusGained

    }//GEN-LAST:event_jtPedidoFocusGained

    //-------------  [BOTON CANCELAR]  ---------------
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        int a = this.jtPedido.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            DetallePedido detallePedido = detalleD.obtenerDetallePedido((int) jtPedido.getValueAt(i, 0));
            if (detalleD.eliminarDetallePedido(detallePedido.getIdDetalle())) {
                Producto p = detallePedido.getProducto();
                p.setStock(p.getStock()+ detallePedido.getCantidad());
                if (productoD.modificarProducto(p)){
                 detalleD.eliminarDetallePedido((int) this.jtPedido.getValueAt(i, 0));
                }
            }
        }
        mesaD.modificarEstadoDeMesa(pedido.getMesa().getIdMesa(), 'O');
        if (pedidoD.eliminarPedido(pedido.getIdPedido())) {
            JOptionPane.showMessageDialog(this, "Se ha eliminado su pedido!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el pedido...");
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    //-------------  [COMBOBOX PRODUCTO]  ---------------
    private void jcbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductoActionPerformed
        if (this.jcbProducto.getSelectedIndex() != -1){
            this.llenarCantidadJCB();
        }
    }//GEN-LAST:event_jcbProductoActionPerformed

    //-------------  [BOTON MODIFICAR]  ---------------
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (this.jtPedido.getSelectedRow() != -1) {
            //tomar el producto original y su cantidad, si el productoOriginal es igual al producto Nuevo: a) si la cantNueva es mayor, debo restar del stock; o b) debo aumentar el stock en caso contrario
            //si el producto es distinto, debo aumentarle la cantidad original al stock del producto original
            //Y disminuir el stock del producto nuevo;
            //(Notas de mi para mi jaja)
            DetallePedido p = detalleD.obtenerDetallePedido((int) this.jtPedido.getValueAt(jtPedido.getSelectedRow(), 0));
            
            Producto pO = productoD.obtenerProducto(p.getProducto().getIdProducto());
            int cantO = (int) this.jtPedido.getValueAt(jtPedido.getSelectedRow(), 2);
            Producto pN = (Producto) this.jcbProducto.getSelectedItem();
            int cantN = (int) this.jcbCantidad.getSelectedItem();            
            
            if (detalleD.modificarProductoCantidad(p.getIdDetalle(), pN, cantN)) {
                JOptionPane.showMessageDialog(this, "Se modifico su pedido.");
                
                if (pO.getIdProducto() == pN.getIdProducto()){
                    if (cantN >= cantO){
                        pO.setStock(pO.getStock() - (cantN-cantO));
                    } else {
                        pO.setStock(pO.getStock() + (cantO - cantN));
                    }
                } else {
                    pO.setStock(pO.getStock() + cantO);
                    pN.setStock(pN.getStock() - cantN);
                }
                
                productoD.modificarProducto(pO);
                productoD.modificarProducto(pN);
                
                this.llenarProductoJCB();
                this.llenarCantidadJCB();
                llenarTable();
                calcularTotal();
            } else {
                JOptionPane.showMessageDialog(this, "No se logro modificar su pedido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el pedido que desea modificar.");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    //-------------  [CALCULAR TOTAL]  ---------------
    private void calcularTotal() {
        this.jtfSubtotal.setText("");
        int a = this.jtPedido.getRowCount() - 1;
        double subtotal = 0;
        for (int i = a; i >= 0; i--) {
            subtotal += (double) this.jtPedido.getValueAt(i, 3);
        }
        this.jtfSubtotal.setText("$" + (subtotal));
    }

    //-----------------  [TABLA]  ---------------------
    private void llenarTable() {
        borrarFilasTable();
        for (DetallePedido o : detalleD.obtenerDetallesPedidos(pedido.getIdPedido())) {
            model.addRow(new Object[]{
                o.getIdDetalle(),
                o.getProducto().getNombreProducto(),
                o.getCantidad(),
                o.getSubtotal()
            });
        }
    }

    private void borrarFilasTable() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void llenarCabeceraTable() {
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
    private void llenarProductoJCB() {
        this.jcbProducto.removeAllItems();
        
        for (Producto o : productoD.todosLosProductosStock()) {
            this.jcbProducto.addItem(o);
        }
    }

    private void llenarCantidadJCB() {
        this.jcbCantidad.removeAllItems();
        Producto p = (Producto) jcbProducto.getSelectedItem();
        int c = p.getStock();
        for (int i = 0; i < c; i++) {
            this.jcbCantidad.addItem(i + 1);
        }
    }

    //                                          ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private MesaData mesaD;
    private ProductoData productoD;
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
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbFinalizar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<Integer> jcbCantidad;
    private javax.swing.JComboBox<Producto> jcbProducto;
    private javax.swing.JTable jtPedido;
    private javax.swing.JTextField jtfSubtotal;
    // End of variables declaration//GEN-END:variables
}
