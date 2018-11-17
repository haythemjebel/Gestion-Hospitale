package Welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class RHM1 extends JFrame {

	private JPanel contentPane;

	public RHM1() {

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/per.jpg"));
		label.setBounds(0, 0, 753, 442);
		getContentPane().add(label);
		setTitle("human resource manager");
		setBounds(100, 100, 764, 483);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

		JMenu mnNewMenu = new JMenu("List");
		M.add(mnNewMenu);

		JMenuItem Md = new JMenuItem("Doctor");
		mnNewMenu.add(Md);
		Md.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AFFD frame = new AFFD();
				frame.setVisible(true);
			}
		});

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem Mn = new JMenuItem("Nurse");
		mnNewMenu.add(Mn);
		Mn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AFFN frame = new AFFN();
				frame.setVisible(true);
			}
		});
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
		Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Deldoc Do = new Deldoc();
			}
		});
		Deleten.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Delnur inf = new Delnur();
			}
		});
		ADD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertDoctor1 DD = new InsertDoctor1();
			}
		});
		ADDn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertNurse1 II = new InsertNurse1();
			}
		});
		MODIFYn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modNur frame = new modNur();
				frame.setVisible(true);

			}
		});
		MODIFY.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				modDoc frame = new modDoc();
				frame.setVisible(true);
			}
		});
	}

}
