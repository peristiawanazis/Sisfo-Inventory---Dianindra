/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dianindra;

/**
 *
 * @author user
 */
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
 
/**
 *
 * @author Hans Kristanto
 */
public class Print {
 
    Connection con = null;
    Statement st ;
 
   public void pembelian(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/pembelian.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
   public void returpembelian(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/returpembelian.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
    public void returpenjualan(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/returpembelian.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
   public void stock(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/stock.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
   public void pembelianall(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/report_pembelian.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
   public void penjualanall(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/report_penjualan.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
   
   public void penjualan(){
           
   try{
   Class.forName("com.mysql.jdbc.Driver");
   con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dianindra","root","");
   st = (Statement) con.createStatement();}
   catch(Exception e){
       System.out.println("gagal");
   }
         
        String reportName = "report/penjualan.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
 
        try {
     JasperPrint jp = JasperFillManager.fillReport(is, null, con);
     JRViewer jv = new JRViewer(jp);
     
     JFrame jf = new JFrame();
     jf.getContentPane().add(jv);
     jf.validate();
     jf.setVisible(true);
     jf.setSize(new Dimension(800,600));
     jf.setLocation(300,100);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
 
   
}