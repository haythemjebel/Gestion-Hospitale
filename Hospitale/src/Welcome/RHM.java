package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class RHM extends JFrame {
	public RHM() {
		setTitle("human resource manager");
		setBounds(300, 300, 200, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// setLayout(new FlowLayout());
		JMenuBar M = new JMenuBar();
		setJMenuBar(M);
		JMenu DOC = new JMenu("Doctor");
		JMenu Nurse = new JMenu("Nurse");
		JMenu aide = new JMenu("Help");
		JMenuItem quite = new JMenuItem("Quit");
		JMenuItem apropo = new JMenuItem("About-us");
		JMenuItem ADD = new JMenuItem("ADD");
		JMenuItem MODIFY = new JMenuItem("MODIFY");
		JMenuItem Delete = new JMenuItem("Delete");
		JMenuItem ADDn = new JMenuItem("ADD");
		JMenuItem MODIFYn = new JMenuItem("MODIFY");
		JMenuItem Deleten = new JMenuItem("Delete");
		DOC.add(ADD);
		DOC.addSeparator();
		DOC.add(MODIFY);
		DOC.addSeparator();
		DOC.add(Delete);
		Nurse.add(ADDn);
		Nurse.addSeparator();
		Nurse.add(MODIFYn);
		Nurse.addSeparator();
		Nurse.add(Deleten);
		aide.add(quite);
		aide.addSeparator();
		aide.add(apropo);
	    M.add(DOC);
		M.add(Nurse);
		M.add(aide);
		apropo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				About apro = new About();

			}
		});
		quite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/*Ldoctor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				initTable(requete1);
			}
		});
		Linfer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				initTable(requete2);
			}
		});*/
		Delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Deldoc  Do =new Deldoc ();
			}
		});
		Deleten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Delnur inf= new Delnur();
			}
		});
		ADD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					InsertDoctor DD= new InsertDoctor();
			}
		});
		ADDn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertNurse II= new InsertNurse();
			}
		});
	}
}
