/*
 * Created by JFormDesigner on Tue Feb 04 18:32:55 ICT 2014
 */

package dianindra;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import net.proteanit.sql.DbUtils;

/**
 * @author ibnu azis
 */
public class retur_pembelian extends JFrame {
    Connection con;
    Statement cn;
    static JScrollPane scrollPane3;
    static JTable table9;
     static Connection conn;
    static Statement stt;
    static ResultSet rss;
    public retur_pembelian() {
        initComponents();
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menu3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void tree1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }

    private void tree1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void tree1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void jTree1ValueChanged(TreeSelectionEvent e) {
        // TODO add your code here
    }

    private void back(ActionEvent e) {
    
        new Home().setVisible(true);
            dispose();
    
    }

    private void logout(ActionEvent e) {
        // TODO add your code here
    }

    private void print(ActionEvent e) {           
     try{
     new Print().returpembelian();
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
     cn = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     Statement stm2 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     
     String sql = "UPDATE retur_pembelian SET status = '1'";  
     cn.executeUpdate(sql); 
     new retur_pembelian().setVisible(true);
     dispose();
     }
     catch(Exception ex){}
    
    }
  public void koneksi(){
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   cn = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
   }
    private void submit(ActionEvent e) {
        String sidtp = idtp.getText();
        String sido =  id_obat.getText();
        String sjml = jml.getText();
        
        Integer d = Integer.parseInt(sjml);
        
         try{
       koneksi();
       String sql = "Select * from stock where id_obat='"+sido+"' AND id_transaksipembelian ='"+sidtp+"'";
       ResultSet rs = cn.executeQuery(sql);
       if(rs.next()){
       String sfsfds = rs.getString("id_transaksipembelian");  
       String xxx = rs.getString("stock");  
       Integer xsxs = Integer.parseInt(xxx);
       Integer sdsd = xsxs-d;
       String sqql = "UPDATE stock SET stock = '"+sdsd+"' where (id_obat ='"+sido+"' AND id_transaksipembelian='"+sidtp+"') ";
       cn.executeUpdate(sqql);     
           
     
         Integer count = 0;
         ResultSet res = cn.executeQuery("SELECT COUNT(*) FROM retur_penjualan");
        while(res.next()){
       
        count = res.getInt(1);
        Integer xdc = count+1;
        String xds = "tm"+xdc;
        String sqqqql = "Insert into retur_penjualan values('"+xds+"','"+sidtp+"','"+d+"', '0')";  
        cn.executeUpdate(sqqqql); 
         JOptionPane.showMessageDialog(null, "Data sudah Masuk");
          new retur_pembelian().setVisible(true);
            dispose();
             }
       
        } 
    }catch(Exception ss){}
    }

    private void returpenjualan(ActionEvent e) {
        try{
     new Print().returpenjualan();
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
     cn = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     Statement stm2 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     
     String sql = "UPDATE retur_pembelian SET status = '1'";  
     cn.executeUpdate(sql); 
     new retur_pembelian().setVisible(true);
     dispose();
     }
     catch(Exception ex){}
    }

    private void check_supplier(ActionEvent e) {
        // TODO add your code here
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
        String id = id_obat.getText();
        if(id.equals("")){
            obatdialg();
            }        
    }

    private void getidobt(ActionEvent e) {
        String id = id_obat.getText();
         try{
     koneksi();
         if(id.equals("")){
            obatdialg();
            }     }
         catch(Exception asdsad){}
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ibnu azis
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
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
                   cn = (Statement) con.createStatement();
                  ResultSet rs = cn.executeQuery("Select retur_pembelian.id_retur, retur_pembelian.id_order, retur_pembelian.jumlah, order_table.id_obat from retur_pembelian join order_table on retur_pembelian.id_order = order_table.id_order where retur_pembelian.status = '0' ");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        panel5 = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   cn = (Statement) con.createStatement();
                  ResultSet rs = cn.executeQuery("Select * from retur_penjualan");
            table2.setModel(DbUtils.resultSetToTableModel(rs));
          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        label4 = new JLabel();
        panel7 = new JPanel();
        button4 = new JButton();
        button5 = new JButton();
        label5 = new JLabel();
        idtp = new JTextField();
        label6 = new JLabel();
        id_obat = new JTextField();
        label7 = new JLabel();
        jml = new JTextField();
        button1 = new JButton();
        button10 = new JButton();
        panel1 = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        button6 = new JButton();
        panel4 = new JPanel();
        about_button = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(1350, 771));
        setTitle("Dianindra - Retur");
        setBackground(new Color(223, 223, 241));
        Container contentPane = getContentPane();
         Toolkit tk = Toolkit.getDefaultToolkit(); 
                int xSize = ((int) tk.getScreenSize().getWidth());  
                int ySize = ((int) tk.getScreenSize().getHeight());
              contentPane.setSize(xSize,ySize);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Home");
                menu1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Menu");
                menu2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/master.png")));

                //---- menuItem2 ----
                menuItem2.setText("Data Barang");
                menuItem2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem2ActionPerformed(e);
                    }
                });
                menu2.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("Pembelian");
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("Penjualan");
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("Supplier");
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("Stock Barang");
                menu2.add(menuItem6);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Logout");
                menu3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/x.png")));
                menu3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menu3ActionPerformed(e);
                    }
                });
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
        tree1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tree1MouseClicked(e);
            }
        });
        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                jTree1ValueChanged(e);
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
                label1.setText("Welcome. Administrator & Opeartor");

                //======== scrollPane1 ========
                {
                    scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

                    //---- table1 ----
                    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane1.setViewportView(table1);
                }

                //======== panel5 ========
                {
                    panel5.setBorder(new EtchedBorder());
                    panel5.setLayout(null);

                    //---- button2 ----
                    button2.setText("Print");
                    button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            print(e);
                        }
                    });
                    panel5.add(button2);
                    button2.setBounds(new Rectangle(new Point(405, 5), button2.getPreferredSize()));

                    //---- button3 ----
                    button3.setText("Kembali");
                    button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back(e);
                        }
                    });
                    panel5.add(button3);
                    button3.setBounds(new Rectangle(new Point(490, 5), button3.getPreferredSize()));

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
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 1139, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1119, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addGap(13, 13, 13)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(46, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Retur Pembelian", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
            tabbedPane1.setBackgroundAt(0, Color.lightGray);

            //======== panel6 ========
            {
                panel6.setBackground(new Color(219, 219, 246));
                panel6.setLayout(null);

                //======== scrollPane2 ========
                {
                    scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

                    //---- table2 ----
                    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane2.setViewportView(table2);
                }
                panel6.add(scrollPane2);
                scrollPane2.setBounds(10, 115, 1104, 180);

                //---- label4 ----
                label4.setText("Welcome. Administrator & Opeartor");
                panel6.add(label4);
                label4.setBounds(15, 15, 193, 14);

                //======== panel7 ========
                {
                    panel7.setBorder(new EtchedBorder());
                    panel7.setLayout(null);

                    //---- button4 ----
                    button4.setText("Print");
                    button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            returpenjualan(e);
                        }
                    });
                    panel7.add(button4);
                    button4.setBounds(new Rectangle(new Point(405, 5), button4.getPreferredSize()));

                    //---- button5 ----
                    button5.setText("Kembali");
                    button5.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back(e);
                        }
                    });
                    panel7.add(button5);
                    button5.setBounds(new Rectangle(new Point(490, 5), button5.getPreferredSize()));

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
                panel6.add(panel7);
                panel7.setBounds(15, 315, 1124, 41);

                //---- label5 ----
                label5.setText("ID Transaksi Pembelian");
                panel6.add(label5);
                label5.setBounds(15, 40, 125, label5.getPreferredSize().height);
                panel6.add(idtp);
                idtp.setBounds(180, 35, 140, idtp.getPreferredSize().height);

                //---- label6 ----
                label6.setText("ID Obat");
                panel6.add(label6);
                label6.setBounds(20, 70, 65, label6.getPreferredSize().height);
                panel6.add(id_obat);
                id_obat.setBounds(180, 68, 85, id_obat.getPreferredSize().height);

                //---- label7 ----
                label7.setText("Jumlah Barang Yang Rusak");
                panel6.add(label7);
                label7.setBounds(370, 35, 155, label7.getPreferredSize().height);
                panel6.add(jml);
                jml.setBounds(520, 30, 160, jml.getPreferredSize().height);

                //---- button1 ----
                button1.setText("Submit");
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        submit(e);
                    }
                });
                panel6.add(button1);
                button1.setBounds(new Rectangle(new Point(370, 65), button1.getPreferredSize()));

                //---- button10 ----
                button10.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                button10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getidobt(e);
                    }
                });
                panel6.add(button10);
                button10.setBounds(new Rectangle(new Point(270, 65), button10.getPreferredSize()));

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
            tabbedPane1.addTab("Retur Penjualan [Barang Rusak]", panel6);
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
            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logout(e);
                }
            });
            panel4.add(button8);
            button8.setBounds(new Rectangle(new Point(140, 10), button8.getPreferredSize()));

            //---- button9 ----
            button9.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
            button9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    back(e);
                }
            });
            panel4.add(button9);
            button9.setBounds(new Rectangle(new Point(195, 10), button9.getPreferredSize()));

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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                            .addGap(11, 11, 11)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tree1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 260, Short.MAX_VALUE)))
                            .addGap(23, 23, 23))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(42, Short.MAX_VALUE))))
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
    private JButton button2;
    private JButton button3;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label4;
    private JPanel panel7;
    private JButton button4;
    private JButton button5;
    private JLabel label5;
    private JTextField idtp;
    private JLabel label6;
    private static JTextField id_obat;
    private JLabel label7;
    private JTextField jml;
    private JButton button1;
    private JButton button10;
    private JPanel panel1;
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;
    private JButton button6;
    private JPanel panel4;
    private JButton about_button;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
