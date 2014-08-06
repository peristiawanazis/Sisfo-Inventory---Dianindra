/*
 * Created by JFormDesigner on Mon Jan 27 05:26:36 ICT 2014
 */

package dianindra;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 * @author ibnu peristiawan
 */
public class Laporan_profit extends JFrame {
    Connection con;
    Statement cn;
    public Laporan_profit() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ibnu peristiawan
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   cn = (Statement) con.createStatement();
                  ResultSet rs = cn.executeQuery("Select order_table.id_order, order_table.id_obat, order_table.jumlah, order_table.total  from order_table where  tanggal_order > '2013-12-30' ");
            table1.setModel(DbUtils.resultSetToTableModel(rs));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        textField1 = new JTextField();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 55, 850, 395);

        //---- textField1 ----
        textField1.setText("Total Pembelian = ");
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(40, 465), textField1.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(140, 465, 125, textField2.getPreferredSize().height);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ibnu peristiawan
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
