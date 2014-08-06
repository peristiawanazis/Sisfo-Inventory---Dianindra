/*
 * Created by JFormDesigner on Sat Jan 25 21:07:10 ICT 2014
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
public class List_kategori extends JFrame {
    Connection con;
    Statement st;
    String Username;
    public List_kategori() {
        initComponents();
    }
     
    public void setUserame(String Username) {
        this.Username = Username;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ibnu peristiawan
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
                   st = (Statement) con.createStatement();
                  ResultSet rs = st.executeQuery("SELECT * from kategori");
            table1.setModel(DbUtils.resultSetToTableModel(rs));


          }
                   catch(Exception e){
                       System.out.println("gagal");
                   }
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 545, 300);

        //---- button1 ----
        button1.setText("Select");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 315), button1.getPreferredSize()));

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
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
