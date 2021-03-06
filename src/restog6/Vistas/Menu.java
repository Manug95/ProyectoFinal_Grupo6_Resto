
package restog6.Vistas;

import data.Conexion;

/**
 * @author Grupo 6
 * Fernandez Valentina
 * Romero Jorge
 * Manuel Gutierrez
 */
public class Menu extends javax.swing.JFrame {
    private Conexion conexion;
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.conexion = new Conexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem9 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jtmMesero = new javax.swing.JMenuItem();
        jmiMesa = new javax.swing.JMenuItem();
        jmiProducto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiOrdenar = new javax.swing.JMenuItem();
        jmiReservar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiStock = new javax.swing.JMenuItem();
        jmiConMesero = new javax.swing.JMenuItem();

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 102, 0));
        jMenuBar1.setBorder(null);
        jMenuBar1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N

        jMenu3.setBackground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Salir");
        jMenu3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N

        jmiSalir.setBackground(new java.awt.Color(255, 255, 255));
        jmiSalir.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restog6/resources/exitIcon11.png"))); // NOI18N
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jMenu3.add(jmiSalir);

        jMenuBar1.add(jMenu3);

        jMenu1.setBackground(new java.awt.Color(255, 102, 51));
        jMenu1.setText("Registrar");
        jMenu1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N

        jtmMesero.setBackground(new java.awt.Color(255, 255, 255));
        jtmMesero.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jtmMesero.setText("Mesero");
        jtmMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtmMeseroActionPerformed(evt);
            }
        });
        jMenu1.add(jtmMesero);

        jmiMesa.setBackground(new java.awt.Color(255, 255, 255));
        jmiMesa.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiMesa.setText("Mesa");
        jmiMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMesaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiMesa);

        jmiProducto.setBackground(new java.awt.Color(255, 255, 255));
        jmiProducto.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiProducto.setText("Producto");
        jmiProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductoActionPerformed(evt);
            }
        });
        jMenu1.add(jmiProducto);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(255, 102, 51));
        jMenu2.setText("Pedido");
        jMenu2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jmiOrdenar.setBackground(new java.awt.Color(255, 255, 255));
        jmiOrdenar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiOrdenar.setText("Ordenar");
        jmiOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOrdenarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiOrdenar);

        jmiReservar.setBackground(new java.awt.Color(255, 255, 255));
        jmiReservar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiReservar.setText("Reservar");
        jmiReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReservarActionPerformed(evt);
            }
        });
        jMenu2.add(jmiReservar);

        jMenuBar1.add(jMenu2);

        jMenu4.setBackground(new java.awt.Color(255, 102, 51));
        jMenu4.setText("Consultas");
        jMenu4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N

        jmiStock.setBackground(new java.awt.Color(255, 255, 255));
        jmiStock.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiStock.setText("Stock");
        jmiStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiStockActionPerformed(evt);
            }
        });
        jMenu4.add(jmiStock);

        jmiConMesero.setBackground(new java.awt.Color(255, 255, 255));
        jmiConMesero.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jmiConMesero.setText("Meseros");
        jmiConMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConMeseroActionPerformed(evt);
            }
        });
        jMenu4.add(jmiConMesero);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMesaActionPerformed
        MesaView mv = new MesaView(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(mv);
        jDesktopPane1.moveToFront(mv);
        jDesktopPane1.repaint();
        mv.setVisible(true);
    }//GEN-LAST:event_jmiMesaActionPerformed

    private void jmiStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiStockActionPerformed
        // TODO add your handling code here:
        ProductoViewStock pvs = new ProductoViewStock(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(pvs);
        jDesktopPane1.moveToFront(pvs);
        jDesktopPane1.repaint();
        pvs.setVisible(true);
    }//GEN-LAST:event_jmiStockActionPerformed

    private void jmiConMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConMeseroActionPerformed
        // TODO add your handling code here:
        MeseroConsulta mec = new MeseroConsulta(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(mec);
        jDesktopPane1.moveToFront(mec);
        jDesktopPane1.repaint();
        mec.setVisible(true);
    }//GEN-LAST:event_jmiConMeseroActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    //--------------Salir------
    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
       dispose();
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOrdenarActionPerformed
        PedidoView_AgregarPedido pv = new PedidoView_AgregarPedido(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(pv);
        jDesktopPane1.moveToFront(pv);
        jDesktopPane1.repaint();
        pv.setVisible(true);
    }//GEN-LAST:event_jmiOrdenarActionPerformed

    private void jmiReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReservarActionPerformed
        ReservaView rv = new ReservaView(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(rv);
        jDesktopPane1.moveToFront(rv);
        jDesktopPane1.repaint();
        rv.setVisible(true);
    }//GEN-LAST:event_jmiReservarActionPerformed

    private void jmiProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductoActionPerformed
        // TODO add your handling code here:
        ProductoView pv = new ProductoView(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(pv);
        jDesktopPane1.moveToFront(pv);
        jDesktopPane1.repaint();
        pv.setVisible(true);
    }//GEN-LAST:event_jmiProductoActionPerformed

    private void jtmMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtmMeseroActionPerformed
        // TODO add your handling code here:
        MeseroView mv = new MeseroView(conexion);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(mv);
        jDesktopPane1.moveToFront(mv);
        jDesktopPane1.repaint();
        mv.setVisible(true);
    }//GEN-LAST:event_jtmMeseroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jmiConMesero;
    private javax.swing.JMenuItem jmiMesa;
    private javax.swing.JMenuItem jmiOrdenar;
    private javax.swing.JMenuItem jmiProducto;
    private javax.swing.JMenuItem jmiReservar;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiStock;
    private javax.swing.JMenuItem jtmMesero;
    // End of variables declaration//GEN-END:variables
}
