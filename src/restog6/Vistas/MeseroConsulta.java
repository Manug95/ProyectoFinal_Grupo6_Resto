/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restog6.Vistas;

import data.Conexion;
import data.MesaData;
import data.MeseroData;
import data.PedidoData;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Mesa;
import modelos.Mesero;
import modelos.Pedido;

/**
 * @author Grupo 6 Fernandez Valentina Romero Jorge Manuel Gutierrez
 */
public class MeseroConsulta extends javax.swing.JInternalFrame {

    private MeseroData med;
    private MesaData md;
    private PedidoData pd;
    private DefaultTableModel model;

    /**
     * Creates new form MesroConsulta
     */
    public MeseroConsulta(Conexion conexion) {
        this.md = new MesaData(conexion);
        this.med = new MeseroData(conexion);
        this.pd = new PedidoData(conexion);
        model = new DefaultTableModel();
        initComponents();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        jDCFecha.setDate(Date.from(LocalDate.now().atStartOfDay(defaultZoneId).toInstant()));
        llenarComboBoxMesero();
        llenarComboBoxMesa();
        llenarCabeceraTable();
        jCBMesa.setEnabled(false);
        jCBMesero.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListar = new javax.swing.JTable();
        jCBConsulta = new javax.swing.JComboBox<>();
        jDCFecha = new com.toedter.calendar.JDateChooser();
        jBCobrar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jCBMesero = new javax.swing.JComboBox<>();
        jBAnular = new javax.swing.JButton();
        jCBMesa = new javax.swing.JComboBox<>();
        jLConsulta = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jLMesero = new javax.swing.JLabel();
        jLMesa = new javax.swing.JLabel();
        jBConsulta = new javax.swing.JButton();

        jLTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLTitulo.setText("Informacion de Mesero");

        jTListar.setModel(new javax.swing.table.DefaultTableModel(
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
        jTListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTListar);

        jCBConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedidos cobrados en el dia", "Listar pedidos por mesero", "Listar los pedidos por mesa", "Pedidos pendientes" }));
        jCBConsulta.setToolTipText("");
        jCBConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBConsultaActionPerformed(evt);
            }
        });

        jBCobrar.setText("Cobrar");
        jBCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCobrarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBAnular.setText("Anular");
        jBAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularActionPerformed(evt);
            }
        });

        jCBMesa.setToolTipText("");

        jLConsulta.setText("Consulta");

        jLFecha.setText("Fecha");

        jLMesero.setText("Mesero");

        jLMesa.setText("Mesa");

        jBConsulta.setText("Consultar");
        jBConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLTitulo)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jBCobrar)
                .addGap(78, 78, 78)
                .addComponent(jBAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalir)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLMesero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(jLFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBConsulta, 0, 240, Short.MAX_VALUE)
                    .addComponent(jCBMesero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBMesa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBConsulta)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCBConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLConsulta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLMesero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBConsulta)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMesa, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCobrar)
                    .addComponent(jBSalir)
                    .addComponent(jBAnular))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTListarMouseClicked

    private void jBConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultaActionPerformed
        // TODO add your handling code here:
        int op = jCBConsulta.getSelectedIndex();
        switch (op) {
            case 0://Pedidos cobrados en el dia
                borrarFilasTable();
                for (Pedido p : med.pedidosCobradosXFecha(jDCFecha.getDate())) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
                break;
            case 1://Listar pedidos por mesero
                borrarFilasTable();
                Mesero unMesero = (Mesero)jCBMesero.getSelectedItem();
                for (Pedido p : med.pedidosXFechaYMesero(jDCFecha.getDate(), unMesero.getIdMesero())) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
                break;
            case 2://Listar los pedidos por mesa
                borrarFilasTable();
                Mesa unaMesa = (Mesa)jCBMesa.getSelectedItem();
                for (Pedido p : med.pedidosXFechaYMesa(jDCFecha.getDate(), unaMesa.getIdMesa())) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
                break;
            case 3://Pedidos Impagos
                borrarFilasTable();                
                for (Pedido p : med.pedidosImpagos()) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
                break;
        }
    }//GEN-LAST:event_jBConsultaActionPerformed

    private void jCBConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBConsultaActionPerformed
        // TODO add your handling code here:
        int op = jCBConsulta.getSelectedIndex();
        switch (op) {
            case 0://Pedidos cobrados en el dia
                jDCFecha.setEnabled(true);
                jCBMesa.setEnabled(false);
                jCBMesero.setEnabled(false);
                break;
            case 1://Listar pedidos por mesero
                jDCFecha.setEnabled(true);
                jCBMesa.setEnabled(false);
                jCBMesero.setEnabled(true);
                break;
            case 2://Listar los pedidos por mesa
                jDCFecha.setEnabled(false);
                jCBMesa.setEnabled(true);
                jCBMesero.setEnabled(false);
                break;
            case 3://Pedidos Impagos
                jDCFecha.setEnabled(false);
                jCBMesa.setEnabled(false);
                jCBMesero.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_jCBConsultaActionPerformed

    private void jBCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCobrarActionPerformed
        // TODO add your handling code here:
        if (this.jTListar.getSelectedRow() != -1){
            int id = (int) this.jTListar.getValueAt(jTListar.getSelectedRow(), 0);
            Pedido unPedido = pd.obtenerPedido(id);
            med.liberarMesa(unPedido.getMesa());
            if (med.PagarPedido(id)){
                JOptionPane.showMessageDialog(this, "Se pago su pedido.");
                borrarFilasTable();
                //med.liberarMesa(idMesa);
                for (Pedido p : med.pedidosImpagos()) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se logro pagar su pedido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el pedido que desea pagar.");
        }
    }//GEN-LAST:event_jBCobrarActionPerformed

    private void jBAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularActionPerformed
        // TODO add your handling code here:
        if (this.jTListar.getSelectedRow() != -1){
            int id = (int) this.jTListar.getValueAt(jTListar.getSelectedRow(), 0);
            if (med.anularPedido(id)){
                JOptionPane.showMessageDialog(this, "Se anulo su pedido.");
                borrarFilasTable();
                for (Pedido p : med.pedidosImpagos()) {
                    model.addRow(new Object[]{
                        p.getIdPedido(),
                        p.getFecha(),
                        p.getMesa(),
                        p.getMesero()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se logro anular su pedido");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el pedido que desea anular.");
        }
    }//GEN-LAST:event_jBAnularActionPerformed

    private void llenarComboBoxMesero() {
        ArrayList<Mesero> meseros = (ArrayList<Mesero>) med.todosLosMeseros();
        for (Mesero m : meseros) {
            jCBMesero.addItem(m);
        }
    }

    private void llenarComboBoxMesa() {
        ArrayList<Mesa> productos = (ArrayList<Mesa>) md.getMesasActivas();
        for (Mesa m : productos) {
            jCBMesa.addItem(m);
        }
    }

    private void llenarCabeceraTable() {
        ArrayList<Object> c = new ArrayList<>();
        c.add("Id");
        c.add("Fecha");
        c.add("Mesa");
        c.add("Mesero");
        for (Object o : c) {
            model.addColumn(o);
        }
        this.jTListar.setModel(model);
    }
    
    private void llenarCabeceraTable2() {
        ArrayList<Object> c = new ArrayList<>();
        c.add("Identidad");
        c.add("Fechacompra");
        c.add("Mesadeunamesa");
        c.add("Meserocobrador");
        c.add("Otracosa");
        for (Object o : c) {
            model.addColumn(o);
        }
        this.jTListar.setModel(model);
    }

    private void borrarFilasTable() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAnular;
    private javax.swing.JButton jBCobrar;
    private javax.swing.JButton jBConsulta;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBConsulta;
    private javax.swing.JComboBox<Mesa> jCBMesa;
    private javax.swing.JComboBox<Mesero> jCBMesero;
    private com.toedter.calendar.JDateChooser jDCFecha;
    private javax.swing.JLabel jLConsulta;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLMesa;
    private javax.swing.JLabel jLMesero;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTListar;
    // End of variables declaration//GEN-END:variables
}
