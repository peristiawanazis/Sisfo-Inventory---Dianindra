/*
 * Created by JFormDesigner on Wed Jan 01 03:04:18 ICT 2014
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
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author ibnu azis
 */
public class Master_pengguna_tambahdata extends JFrame {
    Connection con;
    Statement st;
    public Master_pengguna_tambahdata() {
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
   
    private void tree1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }

    private void tree1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void master_pengguna_tambahdata(ActionEvent e) {
        // TODO add your code here
    }

    private void back_button(ActionEvent e) {
        // TODO add your code here
    }

    private void backto_master(ActionEvent e) {
        new master_pengguna().setVisible(true);
            dispose();
    }

    private void add_todb(ActionEvent e) {
        try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   java.sql.Statement stmt = con.createStatement();
     String id = id_operator.getText();
     String user = username.getText();
     String pass = password.getText();
     String fullname = nama_lengkap.getText();
     String status = new String("asdsa");
     String sql="Insert into operator values('"+(id)+"','"+(user)+"','"+(pass)+"','"+(fullname)+"','"+(status)+"')";
     stmt.executeUpdate(sql);
      JOptionPane.showMessageDialog(null, "Inserted Successfully");
        }
   
   catch(Exception ex){
       JOptionPane.showMessageDialog(this, ex.getMessage());
   }
    }

    private void check(ActionEvent e) {
        try{
     koneksi();
     String id = id_operator.getText();
         
     String sql = "Select * from operator where id_operator='"+id+"'";
     ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
            username.setText(rs.getString("username_operator"));
            password.setText(rs.getString("password_operator"));
            nama_lengkap.setText(rs.getString("nama_operator"));
           
            }
            else{ JOptionPane.showMessageDialog(null, "Didn't Found !");
            }
        }         
   
   catch(Exception ex){
       JOptionPane.showMessageDialog(this, ex.getMessage());
   }
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
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        id_operator = new JTextField();
        username = new JTextField();
        password = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        nama_lengkap = new JTextField();
        button3 = new JButton();
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
        setTitle("Dianindra - Master Pengguna [Tambah]");
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

                    //---- button1 ----
                    button1.setText(" Add");
                    button1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/tambah.png")));
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            add_todb(e);
                        }
                    });
                    panel5.add(button1);
                    button1.setBounds(175, 215, 117, 29);

                    //---- button2 ----
                    button2.setText("Back");
                    button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            backto_master(e);
                        }
                    });
                    panel5.add(button2);
                    button2.setBounds(300, 215, 91, 29);

                    //---- button4 ----
                    button4.setText("Save");
                    button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/save.png")));
                    button4.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            master_pengguna_tambahdata(e);
                        }
                    });
                    panel5.add(button4);
                    button4.setBounds(40, 215, 117, 29);
                    panel5.add(id_operator);
                    id_operator.setBounds(170, 25, 155, 28);
                    panel5.add(username);
                    username.setBounds(170, 65, 218, 28);
                    panel5.add(password);
                    password.setBounds(170, 105, 218, 28);

                    //---- label5 ----
                    label5.setText("ID Operator");
                    panel5.add(label5);
                    label5.setBounds(40, 30, 90, 14);

                    //---- label6 ----
                    label6.setText("Username");
                    panel5.add(label6);
                    label6.setBounds(40, 75, 110, 14);

                    //---- label7 ----
                    label7.setText("Password");
                    panel5.add(label7);
                    label7.setBounds(40, 115, 100, 14);

                    //---- label8 ----
                    label8.setText("* These Fields are Required");
                    panel5.add(label8);
                    label8.setBounds(45, 255, 240, label8.getPreferredSize().height);

                    //---- label9 ----
                    label9.setText("Nama Lengkap");
                    panel5.add(label9);
                    label9.setBounds(40, 155, 100, 14);
                    panel5.add(nama_lengkap);
                    nama_lengkap.setBounds(170, 145, 218, 28);

                    //---- button3 ----
                    button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            check(e);
                        }
                    });
                    panel5.add(button3);
                    button3.setBounds(330, 25, 55, 30);

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
                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE)))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addGap(17, 17, 17)
                            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel5, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab(" Pengguna", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
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
                    backto_master(e);
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
                                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(50, Short.MAX_VALUE))))
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
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JTextField id_operator;
    private JTextField username;
    private JTextField password;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField nama_lengkap;
    private JButton button3;
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
