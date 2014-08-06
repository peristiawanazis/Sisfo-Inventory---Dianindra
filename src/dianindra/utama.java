package dianindra;

import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class utama extends JFrame
{
JButton b1;
JLabel l1;

  public utama() {
    try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
             component();
        }
    }
} catch (Exception e) {
}
       
           }
	public void component()
	{
	setTitle("Background Color for JFrame");
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
        JLabel lbl = new JLabel();  
        lbl.setBackground(new Color(255, 255, 153, 108));
        lbl.setOpaque(true);
	setContentPane(lbl);
        
        
	setLayout(new FlowLayout());
	l1=new JLabel("Here is a button");
	b1=new JButton("I am a button");
        JLabel header = new JLabel("hahahaah");
        header.setBackground(Color.red);
        add(header, BorderLayout.EAST);
	add(l1);
	add(b1);
	// Just for refresh :) Not optional!
	Toolkit tk = Toolkit.getDefaultToolkit(); 
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());
        setSize(xSize,ySize);
        setLocationRelativeTo(null);
	}
	
}