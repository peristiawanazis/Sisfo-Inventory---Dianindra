/*
 * Created by JFormDesigner on Sat Jan 04 12:53:09 ICT 2014
 */

package dianindra;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import com.toedter.calendar.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 * @author ibnu azis
 */
public class Transaksi_penjualan_tambahdata extends JFrame {
    Connection con;
    Statement st;
    private UserSession us;
      static JScrollPane scrollPane3;
    static JTable table9;
     static Connection conn;
    static Statement stt;
    static ResultSet rss;
    
    public Transaksi_penjualan_tambahdata() {
        initComponents();
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
    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void tree1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }

    private void tree1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void master_pengguna_tambahdata(ActionEvent e) {
        // TODO add your code here
    }

    private void backto_master(ActionEvent e) {
        // TODO add your code here
    }

    private void back_button(ActionEvent e) {
        // TODO add your code here
    }

    private void back(ActionEvent e) {
        new Transaksi_penjualan().setVisible(true);
            dispose();
    }

    private void add(ActionEvent e) {
        String udpenjuaan = id_penjualan.getText();
        id_penjualan.setEnabled(true);
        Date a = new Date();
        String tampilan ="ddMMyy" ; 
        SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
        String aa = fm.format(a);
        Integer counter = 1;
        Integer count = 0;
        counter++;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
       ResultSet res = st.executeQuery("SELECT COUNT(*) FROM transaksi_penjualan");
        while (res.next()){
        count = res.getInt(1);
        Integer xdc = count+1;
        id_penjualan.setText("tp"+aa+count+xdc);
        add.setEnabled(false);
        }
        //Integer df = table1.getRowCount();
       // Integer xdc = df++;
       // System.out.println(df);
       
        
        
        }
        catch(Exception Exc){
        }
    }

    private void jumlah(MouseEvent e) {
        
        String ido = id_obat.getText();
        String idp = id_transaksipembelianbarang.getText();
        String hargajual = harga_jual.getText();
        String jml = jumlah.getText();
        int hb = Integer.parseInt(hargajual);
        int j = Integer.parseInt(jml);
        try{
        String sqql = "Select * from stock where (id_obat ='"+ido+"' AND id_transaksipembelian = '"+idp+"') ";
        ResultSet rs = st.executeQuery(sqql);
        while(rs.next()){
        Integer xs = rs.getInt("stock");
        Integer ds = rs.getRow();
        if(j>xs){
        JOptionPane.showMessageDialog(null, "Stock " + ido + " " +"Hanya tersisa" +  " "+ xs + " ");
        }
        else {
        int totalharg = j*hb;
        String x = Integer.toString(totalharg);
        harga_total.setText(x);
        }
        }
        }
        catch(Exception sx){}
    
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
     String id = id_obat.getText();
     String idp = id_transaksipembelianbarang.getText();
     String hj = harga_jual.getText();
     Statement st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_READ_ONLY);
     String sql = "Select stock.id_transaksipembelian, stock.stock, stock.expired_stock, stock.harga_jual, stock.harga_beli, obat.nama_obat from stock join obat on stock.id_obat = obat.id_obat where (stock.id_obat ='"+id+"' AND stock.stock>'0') ";
     ResultSet rs = st.executeQuery(sql);
     if(id.equals("")){
            obatdialg();
         }
     else if(!id.equals("")){
     if(rs.next()){
      rs.first();
        id_transaksipembelianbarang.setText(rs.getString("id_transaksipembelian"));
            nama_obat.setText(rs.getString("nama_obat"));
            harga_jual.setText(rs.getString("harga_jual"));
             rs.next();
              
       } 
     else if(!id.equals(rs.getString("stock"))){
      JOptionPane.showMessageDialog(null, "Didn't Found !");
            
     }
     
     }
      
     
    
     
     
   }         
   
   catch(Exception ex){
       JOptionPane.showMessageDialog(null, "Data is Blank, Specific Action is Required");
   }
    }

    private void save(ActionEvent e) {
        try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   java.sql.Statement stmt = con.createStatement();
     String idp = id_penjualan.getText();
     String idpj = id_transaksipembelianbarang.getText();
     String op = id_operator.getText();
     String ido = id_obat.getText();
     
     String ukuran = comboBox1.getSelectedItem().toString();
     String tampilan ="yyyy-MM-dd" ; 
     SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
     String dt = String.valueOf(fm.format(date.getDate()));
   
     String jml = jumlah.getText();
     String hrg = harga_total.getText();
     
    
     String sql="Insert into transaksi_penjualan values('"+(idp)+"','"+(op)+"','"+(ido)+"','"+(ukuran)+"','"+(dt)+"','"+(jml)+"','"+(hrg)+"','0')";
     
     stmt.executeUpdate(sql);
     JOptionPane.showMessageDialog(null, "Inserted Successfully");
     new Transaksi_penjualan_tambahdata().setVisible(true);
     dispose();
     /*id_penjualan.setText("");
     id_operator.setText("");
     id_obat.setText("");
     nama_obat.setText("");
     harga_jual.setText("");
     jumlah.setText("");
     harga_total.setText("");*/
     
       }
      catch(Exception ex){
       JOptionPane.showMessageDialog(this, "Pastikan Field terisi benar");
   }
    }

    private void print(ActionEvent e) {
       
    String ido = id_obat.getText();
   
    String idp = id_transaksipembelianbarang.getText();
    try{
     int i = 0;
     Object x = table1.getValueAt(0, 1);
     Object xx = table1.getValueAt(0, table1.getColumn("id_obat").getModelIndex() );
     TableModel model = table1.getModel();
     int rowcount = model.getRowCount();
   
      String sqwl = "Select * from stock where (id_obat ='"+ido+"' AND id_transaksipembelian='"+idp+"') ";
       ResultSet rs = st.executeQuery(sqwl);
       
        
        Object xsx = table1.getValueAt(0, table1.getColumn("jumlah").getModelIndex() );
        Object xsxx = table1.getValueAt(0, table1.getColumn("stock").getModelIndex() );
        Object xsxxx = table1.getValueAt(0, table1.getColumn("id_transaksipembelian").getModelIndex() );
        Integer ds = (Integer) xsx;
        Integer dss = (Integer) xsxx;
        Integer dsss = (Integer) xsxx;
        Integer ct = dss - ds;
        String sql2 = "UPDATE stock SET stock = '"+ct+"' where (id_obat ='"+xx+"' AND id_transaksipembelian='"+xsxxx+"') ";
        st.executeUpdate(sql2);     
       
    
     int result = JOptionPane.showConfirmDialog(null, 
    "Are you sure you want to execute this transaction?",null, JOptionPane.YES_NO_OPTION);
    if(result == JOptionPane.YES_OPTION) {
        new Print().penjualan();
        String sql = "UPDATE transaksi_penjualan SET status = '1'";  
        st.executeUpdate(sql); 
        new Transaksi_penjualan_tambahdata().setVisible(true);
        dispose();
    } 
    
     
     }
     catch(Exception ex){}
    
    }

    private void idop(AncestorEvent e) {
         String xs = us.getUserLogin();
         String xss = us.getIdLogin();
         id_operator.setText(xss);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ibnu azis
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu4 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
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
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   st = (Statement) con.createStatement();
                 // ResultSet rs = st.executeQuery("Select transaksi_penjualan.id_tranksasikeluar, transaksi_penjualan.id_operator, transaksi_penjualan.id_obat, transaksi_penjualan.satuan, transaksi_penjualan.tanggal_transaksikeluar, transaksi_penjualan.jumlah, transaksi_penjualan.total_harga, stock.stock from transaksi_penjualan JOIN stock ON transaksi_penjualan.id_obat = stock.id_obat where status = '0'");
            ResultSet rs = st.executeQuery("Select transaksi_penjualan.id_tranksasikeluar, transaksi_penjualan.id_operator, transaksi_penjualan.id_obat, transaksi_penjualan.satuan, transaksi_penjualan.tanggal_transaksikeluar, transaksi_penjualan.jumlah, transaksi_penjualan.total_harga, transaksi_penjualan.total_harga, transaksi_penjualan.status, stock.stock, stock.id_transaksipembelian from transaksi_penjualan join stock on transaksi_penjualan.id_obat = stock.id_obat  where transaksi_penjualan.status = '0'  and stock.harga_jual = transaksi_penjualan.total_harga/transaksi_penjualan.jumlah ");
            table1.setModel(DbUtils.resultSetToTableModel(rs));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        panel5 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        id_penjualan = new JTextField();
        date = new JDateChooser();
        label6 = new JLabel();
        id_operator = new JTextField();
        panel6 = new JPanel();
        label7 = new JLabel();
        id_obat = new JTextField();
        button2 = new JButton();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        jumlah = new JTextField();
        harga_jual = new JTextField();
        nama_obat = new JTextField();
        comboBox1 = new JComboBox();
        comboBox1.addItem("PCS");
        comboBox1.addItem("Box");
        harga_total = new JTextField();
        id_transaksipembelianbarang = new JTextField();
        label14 = new JLabel();
        panel7 = new JPanel();
        add = new JButton();
        button1 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
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
        setTitle("Dianindra - Transaksi Penjualan [Tambah Data]");
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

            //======== menu4 ========
            {
                menu4.setText("Menu");
                menu4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/master.png")));

                //---- menuItem2 ----
                menuItem2.setText("Data Barang");
                menuItem2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem2ActionPerformed(e);
                    }
                });
                menu4.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("Pembelian");
                menu4.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("Penjualan");
                menu4.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("Supplier");
                menu4.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("Stock Barang");
                menu4.add(menuItem6);
            }
            menuBar1.add(menu4);

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

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //======== panel5 ========
                {
                    panel5.setBorder(new EtchedBorder());
                    panel5.setLayout(null);

                    //---- label4 ----
                    label4.setText("ID Penjualan");
                    panel5.add(label4);
                    label4.setBounds(10, 20, 85, label4.getPreferredSize().height);

                    //---- label5 ----
                    label5.setText("Tanggal Penjualan");
                    panel5.add(label5);
                    label5.setBounds(10, 50, 100, label5.getPreferredSize().height);

                    //---- id_penjualan ----
                    id_penjualan.setEnabled(false);
                    panel5.add(id_penjualan);
                    id_penjualan.setBounds(140, 10, 205, 25);
                    panel5.add(date);
                    date.setBounds(140, 45, 205, 30);

                    //---- label6 ----
                    label6.setText("ID Operator");
                    panel5.add(label6);
                    label6.setBounds(10, 90, 90, label6.getPreferredSize().height);

                    //---- id_operator ----
                    id_operator.setForeground(Color.darkGray);
                    id_operator.addAncestorListener(new AncestorListener() {
                        @Override
                        public void ancestorAdded(AncestorEvent e) {
                            idop(e);
                        }
                        @Override
                        public void ancestorMoved(AncestorEvent e) {}
                        @Override
                        public void ancestorRemoved(AncestorEvent e) {}
                    });
                    panel5.add(id_operator);
                    id_operator.setBounds(140, 85, 205, 30);

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

                //======== panel6 ========
                {
                    panel6.setBorder(new EtchedBorder());
                    panel6.setLayout(null);

                    //---- label7 ----
                    label7.setText("ID Obat");
                    panel6.add(label7);
                    label7.setBounds(15, 25, 90, label7.getPreferredSize().height);
                    panel6.add(id_obat);
                    id_obat.setBounds(125, 20, 65, 30);

                    //---- button2 ----
                    button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            check(e);
                        }
                    });
                    panel6.add(button2);
                    button2.setBounds(370, 20, 50, 30);

                    //---- label8 ----
                    label8.setText("Nama Obat");
                    panel6.add(label8);
                    label8.setBounds(15, 65, 85, label8.getPreferredSize().height);

                    //---- label9 ----
                    label9.setText("Satuan");
                    panel6.add(label9);
                    label9.setBounds(15, 100, 65, label9.getPreferredSize().height);

                    //---- label10 ----
                    label10.setText("Harga");
                    panel6.add(label10);
                    label10.setBounds(15, 140, 65, label10.getPreferredSize().height);

                    //---- label11 ----
                    label11.setText("Jumlah");
                    panel6.add(label11);
                    label11.setBounds(15, 180, 70, label11.getPreferredSize().height);

                    //---- label12 ----
                    label12.setText("Total");
                    panel6.add(label12);
                    label12.setBounds(15, 230, 75, label12.getPreferredSize().height);
                    panel6.add(jumlah);
                    jumlah.setBounds(125, 175, 295, 30);
                    panel6.add(harga_jual);
                    harga_jual.setBounds(125, 135, 295, 30);
                    panel6.add(nama_obat);
                    nama_obat.setBounds(125, 55, 295, 30);
                    panel6.add(comboBox1);
                    comboBox1.setBounds(125, 90, 295, 35);

                    //---- harga_total ----
                    harga_total.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jumlah(e);
                        }
                    });
                    panel6.add(harga_total);
                    harga_total.setBounds(125, 215, 295, 30);

                    //---- id_transaksipembelianbarang ----
                    id_transaksipembelianbarang.setEnabled(false);
                    panel6.add(id_transaksipembelianbarang);
                    id_transaksipembelianbarang.setBounds(210, 20, 155, 30);

                    //---- label14 ----
                    label14.setText("-");
                    panel6.add(label14);
                    label14.setBounds(195, 30, 9, label14.getPreferredSize().height);

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel6.getComponentCount(); i++) {
                            Rectangle bounds = panel6.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel6.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel6.setMinimumSize(preferredSize);
                        panel6.setPreferredSize(preferredSize);
                    }
                }

                //======== panel7 ========
                {
                    panel7.setBorder(new BevelBorder(BevelBorder.RAISED));
                    panel7.setLayout(null);

                    //---- add ----
                    add.setText("Add");
                    add.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/tambah.png")));
                    add.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            add(e);
                        }
                    });
                    panel7.add(add);
                    add.setBounds(new Rectangle(new Point(465, 5), add.getPreferredSize()));

                    //---- button1 ----
                    button1.setText("Save");
                    button1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/save.png")));
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            save(e);
                        }
                    });
                    panel7.add(button1);
                    button1.setBounds(new Rectangle(new Point(385, 5), button1.getPreferredSize()));

                    //---- button3 ----
                    button3.setText("Print");
                    button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            print(e);
                        }
                    });
                    panel7.add(button3);
                    button3.setBounds(new Rectangle(new Point(540, 5), button3.getPreferredSize()));

                    //---- button4 ----
                    button4.setText("Back");
                    button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            backto_master(e);
                            back(e);
                        }
                    });
                    panel7.add(button4);
                    button4.setBounds(new Rectangle(new Point(620, 5), button4.getPreferredSize()));

                    { // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel7.getComponentCount(); i++) {
                            Rectangle bounds = panel7.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel7.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel7.setMinimumSize(preferredSize);
                        panel7.setPreferredSize(preferredSize);
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
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(panel6, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 824, Short.MAX_VALUE))
                                .addComponent(panel7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1095, Short.MAX_VALUE))
                            .addContainerGap())
                        .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab(" Penjualan [Tambah Data]  ", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
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
                    back(e);
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
                            .addComponent(tree1, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 373, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)))
                            .addContainerGap())))
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
    private JMenu menu4;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    public JTree tree1;
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel5;
    private JLabel label4;
    private JLabel label5;
    private JTextField id_penjualan;
    private JDateChooser date;
    private JLabel label6;
    private JTextField id_operator;
    private JPanel panel6;
    private JLabel label7;
    private static JTextField id_obat;
    private JButton button2;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JTextField jumlah;
    private JTextField harga_jual;
    private JTextField nama_obat;
    private JComboBox comboBox1;
    private JTextField harga_total;
    private JTextField id_transaksipembelianbarang;
    private JLabel label14;
    private JPanel panel7;
    private JButton add;
    private JButton button1;
    private JButton button3;
    private JButton button4;
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
