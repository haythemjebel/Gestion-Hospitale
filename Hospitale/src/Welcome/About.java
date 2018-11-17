package Welcome;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class About extends JDialog{
	private JOptionPane jop = new JOptionPane();
	private String str;
	JOptionPane jop1 = new JOptionPane(),
	jop2 = new JOptionPane();
	
	
	
	public About(){
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		str = "Mini-Project realizes by : \n";
		str += "\t \t \t \t \t \t \t \t \t \t \t \t \t \t"+"Jebel haythem\n\n\n";
		str += "Master of Mini-Project : \n";
		str += "\t \t \t \t \t \t \t"+"BEN AHMED Sofiene\n";
		jop.showMessageDialog( null, str,"About-us", JOptionPane. INFORMATION_MESSAGE); 
		
		
	}
	
}
