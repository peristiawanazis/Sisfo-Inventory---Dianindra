/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dianindra;

/**
 *
 * @author user
 */
import javax.swing.JButton;
import java.sql.*;
        

public class koneksi {
 /**
     * @param args the command line arguments
     */
    public koneksi() throws ClassNotFoundException{
        // TODO code application logic here
       Connection conn = null;
        
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/iia"; // sesuaikan dengan nama database anda
            String user = "root"; // user mysql anda
            String pass = ""; // passowrd mysql
 
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
            System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
        }
    
    }
  
}
