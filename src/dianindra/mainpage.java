package dianindra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager.LookAndFeelInfo;

public class mainpage extends JFrame {
     private int B_WIDTH;
    private int B_HEIGHT;
    public static boolean RIGHT_TO_LEFT = false;
    JFrame guiFrame = new JFrame();
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean s = false;
    JPanel contentPane = new JPanel();
    
    public mainpage() {
    try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
             initComponents();
        }
    }
} catch (Exception e) {
}
       
           }

    public void addComponentsToPane(Container pane) {
        if (s) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
       
        JButton button;
	pane.setLayout(new GridBagLayout());
        pane.add(new JLabel(new ImageIcon("D:/Project/Skripsi Nesa/aplikasi/dianindra/src/dianindra/gambar/gudang.png")));
	GridBagConstraints c = new GridBagConstraints();
	if (shouldFill) {
	//natural height, maximum width
	c.fill = GridBagConstraints.HORIZONTAL;
	}

	        
      JMenuBar menubar = new JMenuBar();
      
      JMenu home = new JMenu("Home");
      JMenu master = new JMenu("Master");
      
      JMenuItem eMenuItem = new JMenuItem("Exit");
      JMenuItem mastersub1 = new JMenuItem("Pengguna");
      JMenuItem mastersub2 = new JMenuItem("Barang");
      home.add(eMenuItem);
      master.add(mastersub1);
      master.add(mastersub2);
      menubar.add(home);
      menubar.add(master);
      setJMenuBar(menubar);
      
     
	c.fill = GridBagConstraints.HORIZONTAL;
	c.ipady = 10;      //make this component tall
	c.weightx = 10;
	c.gridwidth = 2;
	c.gridx = 0;
	c.gridy = 0;
	pane.add(menubar, c);

	JLabel l = new JLabel("Sistem Inventori Dianindra - Nessa");
	c.fill = GridBagConstraints.HORIZONTAL;
	c.ipady = 2;       //reset to default
	c.weighty = 10;   //request any extra vertical space
	c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	c.insets = new Insets(10,0,0,0);  //top padding
	c.gridx = 1;       //aligned with button 2
	c.gridwidth = 2;
	c.gridy = 1;       //third row
	pane.add(l, c);

     
    }
  
   

   public void initComponents(){
       
    JFrame frame = new JFrame("Home Page");
    addComponentsToPane(frame.getContentPane());
    //frame.getContentPane().add(new JPanelWithBackground("sample.jpeg"));
        JLabel background1 = new JLabel(new ImageIcon("D:/Project/Skripsi Nesa/aplikasi/dianindra/src/dianindra/gambar/gudang.png"));
      //  background1.setPreferredSize(new Dimension(600, 300));
        setContentPane(new JLabel(new ImageIcon("D:/Project/Skripsi Nesa/aplikasi/dianindra/src/dianindra/gambar/gudang.png")));
        frame.pack();
        frame.setVisible(true);
         Toolkit tk = Toolkit.getDefaultToolkit(); 
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setSize(xSize,ySize);
        frame.setLocationRelativeTo(null);
        
                
}}
