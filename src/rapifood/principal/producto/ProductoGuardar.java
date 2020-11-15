/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapifood.principal.producto;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import rapifood.entidades.Producto;
import rapifood.modelo.*;

/**
 *
 * @author Hyouka
 */
public class ProductoGuardar extends javax.swing.JInternalFrame {

  ProductoData pd;
    public ProductoGuardar() {
        initComponents();
        Conexion c=new Conexion();
        pd=new ProductoData(c);
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
        jtxtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jcbEstado = new javax.swing.JCheckBox();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setText("Nombre:");

        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Precio:");

        jLabel3.setText("Guardar Productos");

        jtxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtPrecioKeyTyped(evt);
            }
        });

        jcbEstado.setText("Estado del Producto");
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstado)
                    .addComponent(jbGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jbSalir))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addComponent(jbSalir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jcbEstado)
                .addGap(38, 38, 38)
                .addComponent(jbGuardar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
         int x =JOptionPane.showConfirmDialog(this, "Esta seguro?","ATENCION!!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(x== JOptionPane.YES_OPTION){
        String nombre=jtxtNombre.getText();
        double precio=Double.valueOf(jtxtPrecio.getText());
        boolean estado=jcbEstado.isEnabled();
        Producto p= new Producto(nombre,precio,estado);
        pd.guardarProducto(p);
            }
            
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPrecioKeyTyped
        // TODO add your handling code here:
        
         char caracter = evt.getKeyChar();

      
// Verificar si la tecla pulsada no es un digito      
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/)
          && (caracter == '.' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
            
    }//GEN-LAST:event_jtxtPrecioKeyTyped

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        // TODO add your handling code here:// esto hace que solo se pueda escribir letras y espacios
        if(!(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE) && !Character.isLetter(evt.getKeyChar())&& !(evt.getKeyChar()==KeyEvent.VK_SPACE)){
            
          evt.consume();
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrecio;
    // End of variables declaration//GEN-END:variables
}