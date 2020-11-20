/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapifood.vistas.menu.mesa;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rapifood.entidades.*;
import rapifood.modelo.*;

/**
 *
 * @author joni
 */
public class MesaModificar extends javax.swing.JInternalFrame {

    Conexion c = new Conexion();
    private DefaultTableModel modelo=new DefaultTableModel();
    Mesa mesa;
    MesaData md;
    
    public MesaModificar() {
        initComponents();
        md = new MesaData(c);
        this.setLocation(450, 100);
        Conexion c = new Conexion();
        armaCabeceraTabla();
        modelo.isCellEditable(0, 1);
        this.cargaDatosMesa();
        this.setResizable(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();
        jButtonGuardarCambios = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Modificar Mesa");

        jTable = new javax.swing.JTable(){
            @Override
            public Class<?> getColumnClass(int columna) {
                if(columna==2){
                    return Boolean.class;
                }
                return String.class;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==1 || column ==2){
                    return true;}
                return false;
            }
        };
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);

        jButtonSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(0, 0, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorder(null);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonGuardarCambios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonGuardarCambios.setForeground(new java.awt.Color(0, 0, 204));
        jButtonGuardarCambios.setText("Guardar Cambios");
        jButtonGuardarCambios.setBorder(null);
        jButtonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarCambiosActionPerformed(evt);
            }
        });

        jButtonActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 204));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setBorder(null);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(jButtonGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarCambiosActionPerformed
        int filaSelec=jTable.getSelectedRow();
        if(filaSelec!=-1){
            
            String val="[0-9]*";
            
            if(modelo.getValueAt(filaSelec, 1).toString().matches(val)){

            int id = Integer.parseInt(modelo.getValueAt(filaSelec,0).toString());        
            int cantidadPersona = Integer.parseInt(modelo.getValueAt(filaSelec, 1).toString());
            boolean estado = Boolean.parseBoolean(modelo.getValueAt(filaSelec, 2).toString());
                if(cantidadPersona>0 && cantidadPersona<13){
                
                    int x =JOptionPane.showConfirmDialog(this, "Desea Modificar la Mesa?","ATENCION!!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

                    if(x== JOptionPane.YES_OPTION){
                        Mesa m;
                        m=md.buscarMesa(id);
                        m.setCapacidadMaxima(cantidadPersona);
                        m.setEstadoMesa(estado);
                        md.actualizarMesa(m);
                        borraFilasTabla();
                        cargaDatosMesa();
                    }
                }else{
                    JOptionPane.showInternalMessageDialog(this, "Ingrese numeros entre 1 y 12.");
                }
            }else{
                JOptionPane.showInternalMessageDialog(this, "Ingrese numeros entre 1 y 12.");
            }
        }
    }//GEN-LAST:event_jButtonGuardarCambiosActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        cargaDatosMesa();
    }//GEN-LAST:event_jButtonActualizarActionPerformed
    
    private void armaCabeceraTabla(){
           //Titulos de Columnas
        ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Cantidad Personas");
        columnas.add("Estado");
        
        for(Object it:columnas){
        
            modelo.addColumn(it);
        }
        jTable.setModel(modelo);
    }
    private void borraFilasTabla(){

        int a =modelo.getRowCount()-1;

           for(int i=a;i>=0;i--){
   
                modelo.removeRow(i);
           }
    }
    private void cargaDatosMesa(){
    
        borraFilasTabla();
           //Llenar filas
        
        List<Mesa> lista = md.obtenerMesas();
        
        for(Mesa m:lista){
        
            modelo.addRow(new Object[]{m.getIdMesa(),m.getCapacidadMaxima(),m.isEstadoMesa()});
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonGuardarCambios;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
