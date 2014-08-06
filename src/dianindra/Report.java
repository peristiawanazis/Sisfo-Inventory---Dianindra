/*
 * Created by JFormDesigner on Wed Jan 01 20:24:12 ICT 2014
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
import com.toedter.calendar.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author ibnu azis
 */
public class Report extends JFrame {
    Connection con;
    Statement cn;
    private UserSession us;
    
    public Report() {
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

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void supplier(ActionEvent e) {
        // TODO add your code here
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

    private void back(ActionEvent e) {
          new Home().setVisible(true);
            dispose();
    }

    private void print(ActionEvent e) {
    if (radioButton4.isSelected() == true){
    try{
    new Print().penjualanall();
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
     cn = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     Statement stm2 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     
     }
     catch(Exception ex){}
    }if(!awal2.equals("")){
       String tampilan ="yyyy-MM-dd" ; 
       SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
       String awaldate = String.valueOf(fm.format(awal2.getDate()));
       String akhirdate = String.valueOf(fm.format(akhir2.getDate()));
       
       System.out.println(awaldate);
       
        String reportName = "report/penjualanbydate.jasper";
       InputStream iis = this.getClass().getClassLoader().getResourceAsStream(reportName);
       try{
      HashMap mapp = new HashMap();
      mapp.put("tglawal",awaldate);
      mapp.put("tglakhir",akhirdate);
     JasperPrint jp = JasperFillManager.fillReport(iis, mapp, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            }catch(Exception ex){ ex.printStackTrace();}
     }
    
       }

    private void off(AncestorEvent e) {
         try{
      
        String xs = us.getUserLogin();
            if(xs.equals("owner") ){
             button9.setEnabled(false); 
             button13.setEnabled(false); 
             button10.setEnabled(false); 
             button3.setEnabled(false); 
            }else {
           
            }
        } catch(Exception cdf){}
    }

    private void mati(AncestorEvent e) {
         
         try{
      
        String xs = us.getUserLogin();
            if(xs.equals("owner") ){
            
             button9.setEnabled(false); 
             button13.setEnabled(false); 
             button10.setEnabled(false); 
             button3.setEnabled(false); 
           
             }else {
           
            }
          
        } catch(Exception cdf){}
    
    }

    private void print2(ActionEvent e) {
        if(!awal.equals("")){
       String tampilan ="yyyy-MM-dd" ; 
       SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
       String awaldate = String.valueOf(fm.format(awal.getDate()));
       String akhirdate = String.valueOf(fm.format(akhir.getDate()));
       
       System.out.println(awaldate);
       
        String reportName = "report/pembelianbydate.jasper";
       InputStream iis = this.getClass().getClassLoader().getResourceAsStream(reportName);
       try{
      HashMap mapp = new HashMap();
      mapp.put("tglawal",awaldate);
      mapp.put("tglakhir",akhirdate);
     JasperPrint jp = JasperFillManager.fillReport(iis, mapp, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            }catch(Exception ex){ ex.printStackTrace();}
     }
    
    }

    private void printobat(ActionEvent e) {
        
          
    String kodeobat = textField1.getText();
    if (radioButton1.isSelected() == true){
    try{    
    new Print().stock();
   }
     catch(Exception ex){}
    }if(!kodeobat.equals("")){
    
       String reportName = "report/stokbyid.jasper";
       InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
       try{
      HashMap map = new HashMap();
      map.put("idobat",textField1.getText());        
     JasperPrint jp = JasperFillManager.fillReport(is, map, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            }catch(Exception ex){ ex.printStackTrace();}
   
        
    }
    }

    private void printpembelian(ActionEvent e) {
        if (radioButton3.isSelected() == true){
    try{
    new Print().pembelianall();
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
     con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
     cn = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     Statement stm2 = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);  
     }
     catch(Exception ex){}
    }
    if(!awal.equals("")){
       String tampilan ="yyyy-MM-dd" ; 
       SimpleDateFormat fm = new SimpleDateFormat(tampilan); 
       String awaldate = String.valueOf(fm.format(awal.getDate()));
       String akhirdate = String.valueOf(fm.format(akhir.getDate()));
       
       System.out.println(awaldate);
       
        String reportName = "report/pembelianbydate.jasper";
       InputStream iis = this.getClass().getClassLoader().getResourceAsStream(reportName);
       try{
      HashMap mapp = new HashMap();
      mapp.put("tglawal",awaldate);
      mapp.put("tglakhir",akhirdate);
     JasperPrint jp = JasperFillManager.fillReport(iis, mapp, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            }catch(Exception ex){ ex.printStackTrace();}
     }
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
        DefaultMutableTreeNode b = new DefaultMutableTreeNode("Barang");
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
        DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("Data Barang");
        DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("Pembelian Barang");
        DefaultMutableTreeNode c2 = new DefaultMutableTreeNode("Laporan Profit");
        laporan.add(a2);
        laporan.add(b2);
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
                  ResultSet rs = cn.executeQuery("Select * from stock");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        textField1 = new JTextField();
        panel5 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        panel8 = new JPanel();
        panel6 = new JPanel();
        button4 = new JButton();
        button5 = new JButton();
        button10 = new JButton();
        radioButton3 = new JRadioButton();
        label4 = new JLabel();
        label6 = new JLabel();
        awal = new JDateChooser();
        label7 = new JLabel();
        akhir = new JDateChooser();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   cn = (Statement) con.createStatement();
                  ResultSet rs = cn.executeQuery("Select * from order_table where done = '1' ");
            table2.setModel(DbUtils.resultSetToTableModel(rs));
          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        panel9 = new JPanel();
        panel7 = new JPanel();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        radioButton4 = new JRadioButton();
        label5 = new JLabel();
        label8 = new JLabel();
        awal2 = new JDateChooser();
        label9 = new JLabel();
        akhir2 = new JDateChooser();
        scrollPane4 = new JScrollPane();
        table3 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   cn = (Statement) con.createStatement();
                  ResultSet rs = cn.executeQuery("Select * from transaksi_penjualan ");
            table3.setModel(DbUtils.resultSetToTableModel(rs));
          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
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

                //---- radioButton1 ----
                radioButton1.setText("Semua Obat");
                radioButton1.setSelected(true);

                //---- radioButton2 ----
                radioButton2.setText("Kode Stok");

                //======== panel5 ========
                {
                    panel5.setBorder(new EtchedBorder());
                    panel5.setLayout(null);

                    //---- button1 ----
                    button1.setText("Cari");
                    button1.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    panel5.add(button1);
                    button1.setBounds(new Rectangle(new Point(345, 5), button1.getPreferredSize()));

                    //---- button2 ----
                    button2.setText("Cetak");
                    button2.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            printobat(e);
                        }
                    });
                    panel5.add(button2);
                    button2.setBounds(new Rectangle(new Point(425, 5), button2.getPreferredSize()));

                    //---- button3 ----
                    button3.setText("Kembali");
                    button3.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back(e);
                        }
                    });
                    button3.addAncestorListener(new AncestorListener() {
                        @Override
                        public void ancestorAdded(AncestorEvent e) {
                            mati(e);
                        }
                        @Override
                        public void ancestorMoved(AncestorEvent e) {}
                        @Override
                        public void ancestorRemoved(AncestorEvent e) {}
                    });
                    panel5.add(button3);
                    button3.setBounds(new Rectangle(new Point(515, 5), button3.getPreferredSize()));

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
                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(panel2Layout.createSequentialGroup()
                                            .addComponent(radioButton2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(radioButton1)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1119, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioButton2)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(40, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Stok Obat ", new ImageIcon(getClass().getResource("/dianindra/gambar/home.png")), panel2);
            tabbedPane1.setBackgroundAt(0, Color.lightGray);

            //======== panel8 ========
            {
                panel8.setBackground(new Color(219, 219, 246));
                panel8.setLayout(null);

                //======== panel6 ========
                {
                    panel6.setBorder(new EtchedBorder());
                    panel6.setLayout(null);

                    //---- button4 ----
                    button4.setText("Cari");
                    button4.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    panel6.add(button4);
                    button4.setBounds(new Rectangle(new Point(345, 5), button4.getPreferredSize()));

                    //---- button5 ----
                    button5.setText("Cetak");
                    button5.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button5.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            printpembelian(e);
                        }
                    });
                    panel6.add(button5);
                    button5.setBounds(new Rectangle(new Point(425, 5), button5.getPreferredSize()));

                    //---- button10 ----
                    button10.setText("Kembali");
                    button10.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button10.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back(e);
                        }
                    });
                    button10.addAncestorListener(new AncestorListener() {
                        @Override
                        public void ancestorAdded(AncestorEvent e) {
                            mati(e);
                        }
                        @Override
                        public void ancestorMoved(AncestorEvent e) {}
                        @Override
                        public void ancestorRemoved(AncestorEvent e) {}
                    });
                    panel6.add(button10);
                    button10.setBounds(new Rectangle(new Point(515, 5), button10.getPreferredSize()));

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
                panel8.add(panel6);
                panel6.setBounds(5, 110, 1139, 41);

                //---- radioButton3 ----
                radioButton3.setText("Semua Pembelian");
                panel8.add(radioButton3);
                radioButton3.setBounds(25, 35, 145, radioButton3.getPreferredSize().height);

                //---- label4 ----
                label4.setText("Welcome. Administrator & Opeartor");
                panel8.add(label4);
                label4.setBounds(20, 10, 193, 14);

                //---- label6 ----
                label6.setText("Start Date");
                panel8.add(label6);
                label6.setBounds(25, 73, 60, label6.getPreferredSize().height);

                //---- awal ----
                awal.setDateFormatString("yyyy-MM-dd");
                panel8.add(awal);
                awal.setBounds(80, 70, 135, awal.getPreferredSize().height);

                //---- label7 ----
                label7.setText("End Date");
                panel8.add(label7);
                label7.setBounds(230, 73, 55, label7.getPreferredSize().height);

                //---- akhir ----
                akhir.setDateFormatString("yyyy-MM-dd");
                panel8.add(akhir);
                akhir.setBounds(285, 70, 135, akhir.getPreferredSize().height);

                //======== scrollPane3 ========
                {

                    //---- table2 ----
                    table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane3.setViewportView(table2);
                }
                panel8.add(scrollPane3);
                scrollPane3.setBounds(10, 160, 1135, 225);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Pembelian", panel8);

            //======== panel9 ========
            {
                panel9.setBackground(new Color(219, 219, 246));
                panel9.setLayout(null);

                //======== panel7 ========
                {
                    panel7.setBorder(new EtchedBorder());
                    panel7.setLayout(null);

                    //---- button11 ----
                    button11.setText("Cari");
                    button11.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/cari.png")));
                    panel7.add(button11);
                    button11.setBounds(new Rectangle(new Point(345, 5), button11.getPreferredSize()));

                    //---- button12 ----
                    button12.setText("Cetak");
                    button12.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/print.png")));
                    button12.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            print(e);
                        }
                    });
                    panel7.add(button12);
                    button12.setBounds(new Rectangle(new Point(425, 5), button12.getPreferredSize()));

                    //---- button13 ----
                    button13.setText("Kembali");
                    button13.setIcon(new ImageIcon(getClass().getResource("/dianindra/gambar/back.png")));
                    button13.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            back(e);
                        }
                    });
                    button13.addAncestorListener(new AncestorListener() {
                        @Override
                        public void ancestorAdded(AncestorEvent e) {
                            mati(e);
                        }
                        @Override
                        public void ancestorMoved(AncestorEvent e) {}
                        @Override
                        public void ancestorRemoved(AncestorEvent e) {}
                    });
                    panel7.add(button13);
                    button13.setBounds(new Rectangle(new Point(515, 5), button13.getPreferredSize()));

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
                panel9.add(panel7);
                panel7.setBounds(5, 110, 1139, 41);

                //---- radioButton4 ----
                radioButton4.setText("Semua Penjualan");
                panel9.add(radioButton4);
                radioButton4.setBounds(25, 35, 145, radioButton4.getPreferredSize().height);

                //---- label5 ----
                label5.setText("Welcome. Administrator & Opeartor");
                panel9.add(label5);
                label5.setBounds(20, 10, 193, 14);

                //---- label8 ----
                label8.setText("Start Date");
                panel9.add(label8);
                label8.setBounds(25, 73, 60, label8.getPreferredSize().height);

                //---- awal2 ----
                awal2.setDateFormatString("yyyy-MM-dd");
                panel9.add(awal2);
                awal2.setBounds(80, 70, 135, awal2.getPreferredSize().height);

                //---- label9 ----
                label9.setText("End Date");
                panel9.add(label9);
                label9.setBounds(230, 73, 55, label9.getPreferredSize().height);

                //---- akhir2 ----
                akhir2.setDateFormatString("yyyy-MM-dd");
                panel9.add(akhir2);
                akhir2.setBounds(285, 70, 135, akhir2.getPreferredSize().height);

                //======== scrollPane4 ========
                {

                    //---- table3 ----
                    table3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    scrollPane4.setViewportView(table3);
                }
                panel9.add(scrollPane4);
                scrollPane4.setBounds(10, 160, 1135, 225);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel9.getComponentCount(); i++) {
                        Rectangle bounds = panel9.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel9.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel9.setMinimumSize(preferredSize);
                    panel9.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("Penjualan", panel9);
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
            button9.addAncestorListener(new AncestorListener() {
                @Override
                public void ancestorAdded(AncestorEvent e) {
                    off(e);
                }
                @Override
                public void ancestorMoved(AncestorEvent e) {}
                @Override
                public void ancestorRemoved(AncestorEvent e) {}
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
                                    .addGap(0, 260, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)))
                    .addGap(23, 23, 23))
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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextField textField1;
    private JPanel panel5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel8;
    private JPanel panel6;
    private JButton button4;
    private JButton button5;
    private JButton button10;
    private JRadioButton radioButton3;
    private JLabel label4;
    private JLabel label6;
    private JDateChooser awal;
    private JLabel label7;
    private JDateChooser akhir;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel panel9;
    private JPanel panel7;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JRadioButton radioButton4;
    private JLabel label5;
    private JLabel label8;
    private JDateChooser awal2;
    private JLabel label9;
    private JDateChooser akhir2;
    private JScrollPane scrollPane4;
    private JTable table3;
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
