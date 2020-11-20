/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapifood.vistas.menu.mesa;

import javax.swing.JOptionPane;
import rapifood.entidades.Mesa;
import rapifood.entidades.Producto;
import rapifood.modelo.*;

/**
 *
 * @author joni
 */
public class MesaGuardar extends javax.swing.JInternalFrame {

    Conexion c = new Conexion();
    Mesa mesa;
    MesaData md;
    public MesaGuardar() {
        initComponents();
        md = new MesaData(c);
        this.setLocation(450, 100);
        Conexion c = new Conexion();
        this.setResizable(false);
        cargarComboBox();
        
    }

    public void cargarComboBox(){
     int i;
        for(i=1;i<13;i++){
            String numero = String.valueOf(i);
            jComboBoxCantidadPersonas.addItem(numero);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabelCapacidadMesa = new javax.swing.JLabel();
        jComboBoxCantidadPersonas = new javax.swing.JComboBox<>();
        jCheckBoxActivo = new javax.swing.JCheckBox();
        jLabelEstado = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Mesa");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelCapacidadMesa.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelCapacidadMesa.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCapacidadMesa.setText("Capacidad Mesa:");

        jComboBoxCantidadPersonas.setBackground(new java.awt.Color(240, 240, 240));
        jComboBoxCantidadPersonas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxCantidadPersonas.setToolTipText("");
        jComboBoxCantidadPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCantidadPersonasActionPerformed(evt);
            }
        });

        jCheckBoxActivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBoxActivo.setText("Activo");
        jCheckBoxActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxActivoActionPerformed(evt);
            }
        });

        jLabelEstado.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(0, 0, 204));
        jLabelEstado.setText("Estado:");

        jButtonGuardar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonGuardar.setForeground(new java.awt.Color(0, 0, 204));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(0, 0, 204));
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 0));
        jButtonSalir.setBorderPainted(false);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCapacidadMesa)
                            .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxActivo)
                            .addComponent(jComboBoxCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jButtonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCapacidadMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCantidadPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        int x =JOptionPane.showConfirmDialog(this, "Desea Guardar la Mesa?","ATENCION!!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(x== JOptionPane.YES_OPTION){
                int cantidadPersonas = Integer.valueOf(jComboBoxCantidadPersonas.getSelectedItem().toString());
                boolean estado=jCheckBoxActivo.isSelected();
                Mesa m= new Mesa(estado,cantidadPersonas);
                md.guardarMesa(m);
            }
        JOptionPane.showMessageDialog(null,"Mesa Registrada");
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jComboBoxCantidadPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCantidadPersonasActionPerformed
       
        
    }//GEN-LAST:event_jComboBoxCantidadPersonasActionPerformed

    private void jCheckBoxActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxActivoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCheckBoxActivo;
    private javax.swing.JComboBox<String> jComboBoxCantidadPersonas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCapacidadMesa;
    private javax.swing.JLabel jLabelEstado;
    // End of variables declaration//GEN-END:variables
}
