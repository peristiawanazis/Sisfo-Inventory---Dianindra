/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dianindra;

/**
 *
 * @author user
 */
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Dianindra {

    /**
     * @param args the command line arguments
     */
    JButton a;
     
    public static void main(String[] args) {
        // TODO code applicatsyion logic here
       
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                   new NewJFrame().show();
                   
                }
            });
    }
}
