/*
 * Created by JFormDesigner on Wed Jan 01 17:14:41 ICT 2014
 */

package dianindra;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.jgoodies.forms.factories.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import javax.swing.tree.DefaultMutableTreeNode;
import com.toedter.calendar.*;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.proteanit.sql.DbUtils;

/**
 * @author ibnu azis
 */
public class Master_barang_tambahdata extends JFrame {
    Connection con;
    Statement st;
     JDesktopPane jDesktopPane1  = new JDesktopPane();
    String name;
    static JScrollPane scrollPane3;
    static JTable table9;
     static Connection conn;
    static Statement stt;
    static ResultSet rss;
    public Master_barang_tambahdata() {
        initComponents();
    }

    private void tree1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }

    private void tree1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

      
      public void koneksi(){
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
   }
   
    private void back_button(ActionEvent e) {
       new Master_barang().setVisible(true);
            dispose();
    }

   
    private void checksatu(ActionEvent e) { 
         try{
     koneksi();
     String idpembelian = id_pembelian.getText();
     String hb = harga_beli.getText();
     String sql = "Select order_table.id_obat, obat.nama_obat, obat.limit_stock, obat.kategori_obat, order_table.harga_beli, stock.harga_jual, order_table.jumlah, order_table.done from order_table INNER JOIN obat on order_table.id_obat = obat.id_obat INNER JOIN stock on order_table.id_obat = stock.id_obat where (order_table.id_order ='"+idpembelian+"' AND status='1') ";
     //String sql = "Select * from obat where id_obat='"+id+"'";
     ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
             String cf = rs.getString("harga_beli");
             String dn = rs.getString("done");
             String hj = rs.getString("harga_jual");
            id_obat.setText(rs.getString("id_obat"));
            nama_obat.setText(rs.getString("nama_obat"));
            harga_beli.setText(rs.getString("harga_beli"));
            tambah_stok.setText(rs.getString("jumlah"));
            String kategoriobat = (String)comboBox1.getSelectedItem(); 
           String cd = rs.getString("kategori_obat");
           comboBox1.setSelectedItem(cd);
           limit_stock.setText(rs.getString("limit_stock"));
            String sql3 = "Select stock.stock, obat.limit_stock from stock join obat on stock.id_obat = obat.id_obat where harga_beli='"+cf+"' ";
            ResultSet rss = st.executeQuery(sql3);
            if(rss.next()){
            stok.setText(rss.getString("stock"));
            limit_stock.setText(rss.getString("limit_stock"));
            stok.setEnabled(false);
            }
            if(dn.equals("1")){
            JOptionPane.showMessageDialog(null, "Transaction Have been Added!");
            new Master_barang_tambahdata().setVisible(true);
            dispose();
            }
            }
           
            else{ JOptionPane.showMessageDialog(null, "Didn't Found !");
            }
        }         
   
   catch(Exception ex){
       JOptionPane.showMessageDialog(this, ex.getMessage());
   }
    }
    
     private static void obatdialg()  
    {  
        final JDialog dialog = new JDialog(new Frame(), "Obat", false);  
        scrollPane3 = new JScrollPane();
        table9 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                    stt = (Statement) conn.createStatement();
                  ResultSet rss = stt.executeQuery("Select id_obat, nama_obat from obat");
                  table9.setModel(DbUtils.resultSetToTableModel(rss));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        
         scrollPane3.setViewportView(table9);
         JButton send = new JButton("send text");  
        send.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                int selectedRow = table9.getSelectedRow();
                int selectedCOL = table9.getSelectedColumn();
                 Object xsx = table9.getValueAt(selectedRow, selectedCOL);
                String csc = xsx.toString();
                id_obat.setText(csc);  
                dialog.dispose();  
            }  
        });  
        JPanel south = new JPanel();  
        south.add(send);  
        dialog.getContentPane().add(scrollPane3, "North");  
        dialog.getContentPane().add(south, "South");  
        dialog.setSize(300,500);  
        dialog.setLocationRelativeTo(null);  
        dialog.setResizable(false);
        dialog.setVisible(true);  
    }   
     
    
    private void check(ActionEvent e) { 
         try{
     koneksi();
     String id = id_obat.getText();
     String sql = "Select stock.id_obat, obat.nama_obat, stock.harga_jual, stock.harga_beli, stock.stock, obat.limit_stock, stock.expired_stock from stock JOIN obat on stock.id_obat = obat.id_obat where stock.id_obat='"+id+"'";
     //String sql = "Select * from obat where id_obat='"+id+"'";
     ResultSet rs = st.executeQuery(sql);
         if(id.equals("")){
            obatdialg();
            }
         else if (rs.next()){
            nama_obat.setText(rs.getString("nama_obat"));
            String kategoriobat = (String)comboBox1.getSelectedItem(); 
            harga_jual.setText(rs.getString("harga_jual"));
            harga_beli.setText(rs.getString("harga_beli"));
           // reject_stok.setText(rs.getString("reject_stock"));
            stok.setText(rs.getString("stock"));
            limit_stock.setText(rs.getString("limit_stock"));
           
            
            }
            else{ JOptionPane.showMessageDialog(null, "Didn't Found !");
            }
        }         
   
   catch(Exception ex){
       JOptionPane.showMessageDialog(this, ex.getMessage());
   }
    }
    
 

    private void update(ActionEvent e) {
     button5.setEnabled(false);
     String id = id_obat.getText();
     id_obat.setEnabled(false);
     nama_obat.setEnabled(false);
     id_pembelian.setEnabled(true);
     
     
     
     
     String tmbstk = tambah_stok.getText();
     String namaobat = nama_obat.getText();
     String kategoriobat = (String)comboBox1.getSelectedItem();  
     String hargajual = harga_jual.getText();
     String hargabeli = harga_beli.getText();
     String rejectstok = reject_stok.getText();
     //Integer rejectstok = Integer.parseInt(reject_stok.getText());
    
     /*String tampilan ="yyyy-MM-dd" ; 
     SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
     String expireddate = String.valueOf(fm.format(expired.getDate()));*/
     String stokobat = stok.getText();
     
     Integer tmbhstkint = Integer.parseInt(tmbstk);
     Integer stkawl = Integer.parseInt(stokobat);
     
     Integer totalstok = tmbhstkint + stkawl ;
     
     String ttlstok = new Integer(totalstok).toString();
     Integer counter = 1;
        Integer count = 0;
        counter++;
     
     /* try {  
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                    st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
                    Statement stm2 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
                    String sql = "UPDATE obat SET nama_obat = '"+namaobat+"', kategori_obat = '"+kategoriobat+"', harga_jual = '"+hargajual+"', harga_beli = '"+hargabeli+"', expired_date = '"+expireddate+"', reject_stock = '"+rejectstok+"', stock = '"+ttlstok+"' WHERE id_obat = '"+id+"'";  
                    st.executeUpdate(sql);  
                   JOptionPane.showMessageDialog(null, "Database Updated", "ALERT", 1);  
                    new Master_barang_tambahdata().setVisible(true);
                    dispose();
                } catch(Exception ee) {  
                   
                }  
      try {
        
        ResultSet res = st.executeQuery("SELECT COUNT(*) FROM batch");
        while (res.next()){admin    
        count = res.getInt(1);
        Integer xdc = count+1;
        
        //id_obat.setText("B"+xdc);
        String xdcx = new String("B"+xdc);
        String sql2 ="Insert into batch values('"+(xdcx)+"','"+(id)+"','"+(expireddate)+"','"+(ttlstok)+"')";
        st.executeUpdate(sql2 ); 
        }}
         catch(Exception cd){}*/
    }

      private void save(ActionEvent e) {
       String idp = id_pembelian.getText();
       String ido = id_obat.getText();
       String namo = nama_obat.getText();
       String hj = harga_jual.getText();
       String hb = harga_beli.getText();
       String stk = stok.getText();
       String tmbstk = tambah_stok.getText();
       String rjtstk = reject_stok.getText();
       Integer istk = Integer.parseInt(stk);
       Integer itmbstk = Integer.parseInt(tmbstk);
       Integer rjbstk = Integer.parseInt(rjtstk);
       Integer countstck = istk+itmbstk-rjbstk ;
       String tampilan ="yyyy-MM-dd" ; 
       SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
       String expireddate = String.valueOf(fm.format(expired.getDate()));
       String lmtstck = limit_stock.getText();
       try{
      koneksi();
          String sql = "Select * from stock where (id_obat ='"+ido+"' AND harga_jual ='"+hj+"' AND harga_beli='"+hb+"') ";
       ResultSet rs = st.executeQuery(sql);
       if(rs.next()){
       String sfsfds = rs.getString("harga_beli");  
       if(hb.equals(sfsfds)){
        String sqql = "UPDATE stock SET stock = '"+countstck+"', expired_stock = '"+expireddate+"' where (id_obat ='"+ido+"' AND harga_beli='"+hb+"') ";
        st.executeUpdate(sqql); 
        String sqqql = "UPDATE order_table SET done = '1' where id_order='"+idp+"'";  
        st.executeUpdate(sqqql); 
         while(!rjtstk.equals("0")){
         Integer count = 0;
         ResultSet res = st.executeQuery("SELECT COUNT(*) FROM retur_pembelian");
        if(res.next()){
        count = res.getInt(1);
        Integer xdc = count+1;
        String xds = "tm"+xdc;
        String sqqqql = "Insert into retur_pembelian values('"+xds+"','"+idp+"','"+rjtstk+"', '0')";  
        st.executeUpdate(sqqqql); 
         JOptionPane.showMessageDialog(null, "Data sudah Masuk");
          new Master_barang_tambahdata().setVisible(true);
            dispose();
             }
       }if(rjtstk.equals("0")){
         Integer count = 0;
         ResultSet res = st.executeQuery("SELECT COUNT(*) FROM retur_pembelian");
        
         JOptionPane.showMessageDialog(null, "Data sudah Masuk");
          new Master_barang_tambahdata().setVisible(true);
            dispose();
             
       }
        }
       
       
        String sqll="Insert into stock values('"+(idp)+"','"+(ido)+"','"+(countstck)+"','"+(expireddate)+"','"+(hj)+"','"+(hb)+"')";
        st.executeUpdate(sqll); 
        String sqql = "UPDATE order_table SET done = '1'";  
        st.executeUpdate(sqql); 
        
        JOptionPane.showMessageDialog(null, " Inserted Sucessfully!");
         new Master_barang_tambahdata().setVisible(true);
            dispose();
       }
       else {
        String sqll="Insert into stock values('"+(idp)+"','"+(ido)+"','"+(countstck)+"','"+(expireddate)+"','"+(hj)+"','"+(hb)+"')";
        st.executeUpdate(sqll); 
        String sqql = "UPDATE order_table SET done = '1'";  
        st.executeUpdate(sqql); 
        if(!rjtstk.equals("0")){
         Integer count = 0;
         ResultSet res = st.executeQuery("SELECT COUNT(*) FROM retur_pembelian");
        while(res.next()){
        count = res.getInt(1);
        Integer xdc = count+1;
        String xds = "tm"+xdc;
        String sqqqql = "Insert into retur_pembelian values('"+xds+"','"+idp+"','"+rjtstk+"', '0')";  
        st.executeUpdate(sqqqql); 
         JOptionPane.showMessageDialog(null, "Data Has been Added");
          new Master_barang_tambahdata().setVisible(true);
            dispose();
             }
       }
        
       }
       
       }
       catch(Exception xe){}
       
     }
      
    private void tambah_obat(ActionEvent e) {
        new add_obat().setVisible(true);
            dispose();
    }

 
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ibnu azis
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menu3 = new JMenu();
        tree1 = new JTree();
        DefaultMutableTreeNode master = new DefaultMutableTreeNode("Master");
        DefaultMutableTreeNode a = new DefaultMutableTreeNode("Pengguna");
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("Obat");
        DefaultMutableTreeNode c = new DefaultMutableTreeNode("Supplier");
        master.add(a);
        master.add(b);
        master.add(c);

        DefaultMutableTreeNode transaksi = new DefaultMutableTreeNode("Transaksi");
        DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("Pembelian");
        DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("Penjualan");
        transaksi.add(a1);
        transaksi.add(b1);


        DefaultMutableTreeNode laporan = new DefaultMutableTreeNode("Laporan");
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("Data Obat");
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("Pembelian Obat");
        DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("Penjualan Obat");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Laporan Profit");
        laporan.add(a2);
        laporan.add(b2);
        laporan.add(b3);
        laporan.add(c2);

        DefaultMutableTreeNode nba = new DefaultMutableTreeNode("Sistem Inventori Apotek Dianindra");
        nba.add(master);
        nba.add(transaksi);
        nba.add(laporan);
        tree1 = new JTree(nba);

        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        label1 = new JLabel();
        panel5 = new JPanel();
        button2 = new JButton();
        button4 = new JButton();
        id_obat = new JTextField();
        nama_obat = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        harga_jual = new JTextField();
        label4 = new JLabel();
        harga_beli = new JTextField();
        label10 = new JLabel();
        stok = new JTextField();
        label11 = new JLabel();
        expired = new JDateChooser();
        expired.setDateFormatString("E MMM dd yyyy");
        button3 = new JButton();
        reject_stok = new JTextField();
        label12 = new JLabel();
        comboBox1 = new JComboBox();
        String sql="SELECT * FROM kategori";
            try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  

                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                   String id = rs.getString("kategori_obat");

                   comboBox1.addItem(id);

                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        button5 = new JButton();
        label14 = new JLabel();
        tambah_stok = new JTextField();
        id_pembelian = new JTextField();
        label13 = new JLabel();
        button9 = new JButton();
        button1 = new JButton();
        label15 = new JLabel();
        limit_stock = new JTextField();
        separator1 = compFactory.createSeparator("Please Fill Required Fields bellow");
        panel1 = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        button6 = new JButton();
        panel4 = new JPanel();
        about_button = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        back_button = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(1350, 771));
        setTitle("Dianindra - Master Barang [Tambah]");
        setBackground(new Color(223, 223, 241));
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Home");
                menu1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")));

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Menu");
                menu2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/master.png")));
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Logout");
                menu3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/x.png")));
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //---- tree1 ----
        tree1.setAlignmentY(1.5F);
        tree1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.lightGray, Color.lightGray));
        tree1.setBackground(new Color(219, 219, 246));
        tree1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                tree1AncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        tree1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tree1KeyPressed(e);
            }
        });

        //======== tabbedPane1 ========
        {
            tabbedPane1.setNextFocusableComponent(this);
            tabbedPane1.setPreferredSize(new Dimension(1936, 98));
            tabbedPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(219, 219, 246));
                panel2.setAutoscrolls(true);
                panel2.setPreferredSize(new Dimension(931, 70));

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label1 ----
                label1.setText("Welcome. Administrator & Operator");

                //======== panel5 ========
                {
                    panel5.setLayout(null);

                    //---- button2 ----
                    button2.setText("Back");
                    button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back_button(e);
                        }
                    });
                    panel5.add(button2);
                    button2.setBounds(270, 245, 91, 29);

                    //---- button4 ----
                    button4.setText("Save");
                    button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/save.png")));
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            save(e);
                        }
                    });
                    panel5.add(button4);
                    button4.setBounds(40, 245, 117, 29);
                    panel5.add(id_obat);
                    id_obat.setBounds(170, 65, 165, 29);
                    panel5.add(nama_obat);
                    nama_obat.setBounds(170, 100, 218, 29);

                    //---- label5 ----
                    label5.setText("ID Obat");
                    panel5.add(label5);
                    label5.setBounds(35, 70, 90, 14);

                    //---- label6 ----
                    label6.setText("Nama Obat");
                    panel5.add(label6);
                    label6.setBounds(35, 105, 110, 14);

                    //---- label7 ----
                    label7.setText("Kategori Obat");
                    panel5.add(label7);
                    label7.setBounds(35, 145, 100, 14);

                    //---- label8 ----
                    label8.setText("* These Fields are Required");
                    panel5.add(label8);
                    label8.setBounds(40, 285, 240, label8.getPreferredSize().height);

                    //---- label9 ----
                    label9.setText("Harga Jual");
                    panel5.add(label9);
                    label9.setBounds(35, 180, 100, 14);
                    panel5.add(harga_jual);
                    harga_jual.setBounds(170, 170, 218, 29);

                    //---- label4 ----
                    label4.setText("Harga Beli");
                    panel5.add(label4);
                    label4.setBounds(new Rectangle(new Point(460, 35), label4.getPreferredSize()));
                    panel5.add(harga_beli);
                    harga_beli.setBounds(560, 25, 215, 29);

                    //---- label10 ----
                    label10.setText("Stock");
                    panel5.add(label10);
                    label10.setBounds(new Rectangle(new Point(460, 65), label10.getPreferredSize()));
                    panel5.add(stok);
                    stok.setBounds(560, 60, 215, 29);

                    //---- label11 ----
                    label11.setText("Expired Date");
                    panel5.add(label11);
                    label11.setBounds(460, 150, 80, 14);
                    panel5.add(expired);
                    expired.setBounds(560, 140, 220, 30);

                    //---- button3 ----
                    button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            check(e);
                        }
                    });
                    panel5.add(button3);
                    button3.setBounds(340, 60, 49, 30);
                    panel5.add(reject_stok);
                    reject_stok.setBounds(700, 100, 75, 29);

                    //---- label12 ----
                    label12.setText("Reject");
                    panel5.add(label12);
                    label12.setBounds(660, 110, 40, label12.getPreferredSize().height);
                    panel5.add(comboBox1);
                    comboBox1.setBounds(170, 135, 220, 30);

                    //---- button5 ----
                    button5.setText("Update");
                    button5.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/upd.png")));
                    button5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            update(e);
                        }
                    });
                    panel5.add(button5);
                    button5.setBounds(165, 245, 95, 30);

                    //---- label14 ----
                    label14.setText("Add Stock");
                    panel5.add(label14);
                    label14.setBounds(460, 110, 70, label14.getPreferredSize().height);
                    panel5.add(tambah_stok);
                    tambah_stok.setBounds(560, 100, 85, 30);

                    //---- id_pembelian ----
                    id_pembelian.setEnabled(false);
                    panel5.add(id_pembelian);
                    id_pembelian.setBounds(170, 25, 165, 30);

                    //---- label13 ----
                    label13.setText("ID Pembelian");
                    panel5.add(label13);
                    label13.setBounds(35, 30, 90, label13.getPreferredSize().height);

                    //---- button9 ----
                    button9.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    button9.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            checksatu(e);
                        }
                    });
                    panel5.add(button9);
                    button9.setBounds(340, 25, 50, 30);

                    //---- button1 ----
                    button1.setText("Tambah Obat");
                    button1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/obttmb.png")));
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tambah_obat(e);
                        }
                    });
                    panel5.add(button1);
                    button1.setBounds(660, 245, button1.getPreferredSize().width, 30);

                    //---- label15 ----
                    label15.setText("Limit Stock");
                    panel5.add(label15);
                    label15.setBounds(460, 190, 80, label15.getPreferredSize().height);
                    panel5.add(limit_stock);
                    limit_stock.setBounds(560, 180, 220, 30);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel5.getComponentCount(); i++) {
                            Rectangle bounds = panel5.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel5.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel5.setMinimumSize(preferredSize);
                        panel5.setPreferredSize(preferredSize);
                    }
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 36, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addGap(15, 15, 15))
                );
            }
            tabbedPane1.addTab("Tambah Obat", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
            tabbedPane1.setBackgroundAt(0, Color.lightGray);
        }

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
        }

        //======== panel3 ========
        {
            panel3.setBorder(new EtchedBorder());
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("Administrator");
            label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            label2.setForeground(Color.blue);
            panel3.add(label2, new GridBagConstraints(2, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/admin.png")));
            panel3.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button6 ----
            button6.setText("Edit Profil");
            button6.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/edit.png")));
            panel3.add(button6, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        }

        //======== panel4 ========
        {
            panel4.setBackground(new Color(211, 211, 241));
            panel4.setBorder(new BevelBorder(BevelBorder.LOWERED));
            panel4.setLayout(null);

            //---- about_button ----
            about_button.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/about.png")));
            about_button.setToolTipText("About Sistem");
            panel4.add(about_button);
            about_button.setBounds(new Rectangle(new Point(30, 10), about_button.getPreferredSize()));

            //---- button7 ----
            button7.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/profil.png")));
            panel4.add(button7);
            button7.setBounds(new Rectangle(new Point(85, 10), button7.getPreferredSize()));

            //---- button8 ----
            button8.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/logout.png")));
            panel4.add(button8);
            button8.setBounds(new Rectangle(new Point(140, 10), button8.getPreferredSize()));

            //---- back_button ----
            back_button.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
            back_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    back_button(e);
                }
            });
            panel4.add(back_button);
            back_button.setBounds(new Rectangle(new Point(195, 10), back_button.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel4.getComponentCount(); i++) {
                    Rectangle bounds = panel4.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel4.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel4.setMinimumSize(preferredSize);
                panel4.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(tree1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 1400, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tree1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(39, Short.MAX_VALUE))))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ibnu azis
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenu menu3;
    public JTree tree1;
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel5;
    private JButton button2;
    private JButton button4;
    private static JTextField id_obat;
    private JTextField nama_obat;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField harga_jual;
    private JLabel label4;
    private JTextField harga_beli;
    private JLabel label10;
    private JTextField stok;
    private JLabel label11;
    private JDateChooser expired;
    private JButton button3;
    private JTextField reject_stok;
    private JLabel label12;
    private JComboBox comboBox1;
    private JButton button5;
    private JLabel label14;
    private JTextField tambah_stok;
    private JTextField id_pembelian;
    private JLabel label13;
    private JButton button9;
    private JButton button1;
    private JLabel label15;
    private JTextField limit_stock;
    private JComponent separator1;
    private JPanel panel1;
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;
    private JButton button6;
    private JPanel panel4;
    private JButton about_button;
    private JButton button7;
    private JButton button8;
    private JButton back_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
