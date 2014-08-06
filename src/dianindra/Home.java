/*
 * Created by JFormDesigner on Thu Dec 26 12:54:01 ICT 2013
 */

package dianindra;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.jgoodies.forms.factories.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.tree.DefaultMutableTreeNode;
import net.proteanit.sql.DbUtils;



/**
 * @author unknown
 */
public class Home extends JFrame {
    Connection con;
    Statement st;
    private UserSession us;
   
    public Home() {
        initComponents();
    }

    private void tree1AncestorAdded(AncestorEvent e) {
        
        
    }

    private void tree1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void button1KeyPressed(KeyEvent e) {
         new Master_barang().setVisible(true);
            dispose();
    }

    private void button1ActionPerformed(ActionEvent e) {
        new Master_barang().setVisible(true);
            dispose();
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
       new Master_barang().setVisible(true);
            dispose();
    }

    private void logout(ActionEvent e) {
    int response = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      System.out.println("No button clicked");
    } else if (response == JOptionPane.YES_OPTION) {
       new NewJFrame().setVisible(true);
            dispose();
    } else if (response == JOptionPane.CLOSED_OPTION) {
      System.out.println("JOptionPane closed");
    }
    }
    
    public void jTree1ValueChanged( TreeSelectionEvent tse ) {
     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
    if( node.equals("Pengguna") ) {
        new master_pengguna().setVisible(true);
            dispose(); 
    } else if(node.equals("Obat")) {
        new Master_barang().setVisible(true);
            dispose();
    }
    else if(node.equals("Supplier")) {
        new Master_supplier().setVisible(true);
            dispose();
    }
    else if(node.equals("Pembelian")) {
        new Transaksi_pembelian().setVisible(true);
            dispose();
    }
    else if(node.equals("Penjualan")) {
        new Transaksi_penjualan().setVisible(true);
            dispose();
    }
     else if(node.equals("Data Obat")) {
        new Master_barang().setVisible(true);
            dispose();
    }
      else if(node.equals("Pembelian Barang")) {
        new Master_barang().setVisible(true);
            dispose();
    }
        else if(node.equals("Pembelian Obat")) {
        JOptionPane.showMessageDialog(null, "Are You sure want to Pirnt?");
        new Print().pembelianall();
            
    }
        else if(node.equals("Penjualan Obat")) {
        JOptionPane.showMessageDialog(null, "Are You sure want to Pirnt?");
        new Print().penjualanall();
            
    }
     else if(node.equals("Laporan Profit")) {
        new Laporan_profit().setVisible(true);
            
    }
}

    private void menuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void menu3ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ogout(ActionEvent e) {
        // TODO add your code here
    }

    private void tree1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void supplier(ActionEvent e) {
     new Master_supplier().setVisible(true);
            dispose();
    }

    private void stok(ActionEvent e) {
     new Report().setVisible(true);
            dispose();
    }

    private void transaksi_pembelian(ActionEvent e) {
        new Transaksi_pembelian().setVisible(true);
            dispose();
    }

    private void penjualan(ActionEvent e) {
        new Transaksi_penjualan().setVisible(true);
            dispose();
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
   private void check(ActionEvent e) { 
        
    }

  

    private void off(AncestorEvent e) {
        try{
        //String df = textField1.getText();
        String xs = us.getUserLogin();
            if(xs.equals("admin") ){
            button5.setEnabled(true);  
            button4.setEnabled(true);
            }
            else if(xs.equals("owner") ){
             button1.setEnabled(false); 
             button2.setEnabled(false); 
             button3.setEnabled(false); 
             button4.setEnabled(false); 
             button5.setEnabled(true); 
             button10.setEnabled(true); 
             }
            
            else {
            button5.setEnabled(false);  
            button4.setEnabled(false);
            }
             
            
        } catch(Exception cdf){}
    }

    private void offs(AncestorEvent e) {
        // TODO add your code here
    }

    private void label4AncestorAdded(AncestorEvent e) {
         String xs = us.getUserLogin();
         label4.setText(xs);
    }

    private void retur(ActionEvent e) {
          
        new retur_pembelian().setVisible(true);
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
        label1.setText(UserSession.getUserLogin());
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label4 = new JLabel();
        label4.setText(UserSession.getUserLogin()); 
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
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
         try{
                 koneksi();
                  ResultSet rs = st.executeQuery("Select stock.id_transaksipembelian, stock.id_obat, stock.stock, obat.nama_obat, obat.kategori_obat, obat.limit_stock  from stock join obat on stock.id_obat = obat.id_obat where stock <= limit_stock ");
            table1.setModel(DbUtils.resultSetToTableModel(rs));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
            st = (Statement) con.createStatement();
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

                  ResultSet rs = st.executeQuery("SELECT * from stock where expired_stock ='"+timeStamp+"' ");
          	table2.setModel(DbUtils.resultSetToTableModel(rs));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        separator1 = compFactory.createSeparator("Reminder");
        title1 = compFactory.createTitle("Stok");
        title2 = compFactory.createTitle("Expired Obat");

        //======== this ========
        setMinimumSize(new Dimension(1350, 771));
        setTitle("Dianindra - Home");
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

                panel2.setLayout(null);

                //---- label1 ----
                label1.setText("Welcome....");
                panel2.add(label1);
                label1.setBounds(10, 11, 85, label1.getPreferredSize().height);

                //---- button1 ----
                button1.setText("Data Obat");
                button1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/db.png")));
                button1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        button1KeyPressed(e);
                    }
                });
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItem2ActionPerformed(e);
                    }
                });
                panel2.add(button1);
                button1.setBounds(30, 80, 155, 58);

                //---- button2 ----
                button2.setText("Pembelian");
                button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/pembelian.png")));
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        transaksi_pembelian(e);
                    }
                });
                panel2.add(button2);
                button2.setBounds(195, 80, 150, 58);

                //---- button3 ----
                button3.setText("Penjualan");
                button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/penjualan.png")));
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        penjualan(e);
                    }
                });
                panel2.add(button3);
                button3.setBounds(355, 80, 155, 58);

                //---- button4 ----
                button4.setText("Supplier");
                button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/supplier.png")));
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        supplier(e);
                    }
                });
                panel2.add(button4);
                button4.setBounds(525, 80, 160, 58);

                //---- button5 ----
                button5.setText("Report");
                button5.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/stok.png")));
                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        stok(e);
                    }
                });
                button5.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent e) {
                        off(e);
                    }
                    @Override
                    public void ancestorMoved(AncestorEvent e) {}
                    @Override
                    public void ancestorRemoved(AncestorEvent e) {}
                });
                panel2.add(button5);
                button5.setBounds(700, 80, 165, 58);

                //---- label4 ----
                label4.setText("text");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() & ~Font.BOLD));
                label4.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent e) {
                        label4AncestorAdded(e);
                    }
                    @Override
                    public void ancestorMoved(AncestorEvent e) {}
                    @Override
                    public void ancestorRemoved(AncestorEvent e) {}
                });
                panel2.add(label4);
                label4.setBounds(70, 10, 60, label4.getPreferredSize().height);

                //---- button10 ----
                button10.setText("Retur");
                button10.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/rtr.png")));
                button10.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent e) {
                        off(e);
                    }
                    @Override
                    public void ancestorMoved(AncestorEvent e) {}
                    @Override
                    public void ancestorRemoved(AncestorEvent e) {}
                });
                button10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        retur(e);
                    }
                });
                panel2.add(button10);
                button10.setBounds(880, 80, 165, 58);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab(" Home", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
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

        //======== panel5 ========
        {
            panel5.setBorder(new EtchedBorder());
            panel5.setLayout(null);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table1);
            }
            panel5.add(scrollPane2);
            scrollPane2.setBounds(45, 55, 490, 180);

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(table2);
            }
            panel5.add(scrollPane3);
            scrollPane3.setBounds(550, 55, 528, 180);
            panel5.add(separator1);
            separator1.setBounds(40, 10, 1025, 15);

            //---- title1 ----
            title1.setFont(title1.getFont().deriveFont(title1.getFont().getStyle() | Font.BOLD));
            panel5.add(title1);
            title1.setBounds(50, 30, 45, title1.getPreferredSize().height);

            //---- title2 ----
            title2.setFont(title2.getFont().deriveFont(title2.getFont().getStyle() | Font.BOLD));
            panel5.add(title2);
            title2.setBounds(550, 30, 105, title2.getPreferredSize().height);

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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 1120, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 1090, GroupLayout.PREFERRED_SIZE)))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 1400, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tree1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                    .addGap(40, 40, 40))
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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label4;
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
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JComponent separator1;
    private JLabel title1;
    private JLabel title2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
