package dianindra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class List_supplier extends JFrame
{
JLabel label;
String word;
 private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    Transaksi_pembelian_tambahdata tpb;

    /*public List_supplier() {
        
        initComponents();
        
    }*/
    public List_supplier(final Frame2Listener fl){
    jButton1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
      fl.theButtonWasClicked(jTextField1.getText());
    }
  });
}
 private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jLabel1.setText("Confirm/Change then FInalize");

        jButton1.setText("FInalize");
        /*jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });*/

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(jTextField1)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>  
 
 /*       
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {  
      
       /*
        String xs = jTextField1.getText();
        tpb=new Transaksi_pembelian_tambahdata();
        tpb.writeLabel(xs);
        String info = new String();
        info = jTextField1.getText();
        Transaksi_pembelian_tambahdata page=new Transaksi_pembelian_tambahdata();
        page.test(info);
        page.repaint();
        dispose();
    }    */
}