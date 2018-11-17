package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Doctor1 extends JFrame {
	private JPanel contentPane;

	public Doctor1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 767, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 751, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Patient's list");
		JMenuItem A = new JMenuItem("affichage");
		mnNewMenu.add(A);
		menuBar.add(mnNewMenu);
		JButton modifier = new JButton("");
		modifier.setIcon(new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/param.png"));
		modifier.setBounds(300, 304, 137, 98);
		A.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AFFP frame = new AFFP();
				frame.setVisible(true);

			}
		});
		contentPane.add(modifier);
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Edit M = new Edit();
			}
		});
		JButton supprimer = new JButton("");
		supprimer
				.setIcon(new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/Zooicon.png"));
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AFFP2 frame = new AFFP2();
				frame.setVisible(true);
			}
		});
		supprimer.setBounds(89, 263, 137, 122);
		contentPane.add(supprimer);
		JButton ajouter = new JButton("");
		ajouter.setIcon(
				new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/Add_Folder.png"));
		ajouter.setBounds(51, 81, 137, 130);
		contentPane.add(ajouter);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddP2 frame = new AddP2();
				frame.setVisible(true);
			}
		});

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().open(new File("D:/HOPITALE DORSAF/Patient"));
				} catch (IOException f) { 
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\folder-documents-icon.png"));
		button.setBounds(583, 313, 129, 101);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 751, 445);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(
				"C:/Users/PROXIMEDIA/Desktop/img/ThinkstockPhotos-126930170-e1440532560232.jpg"));

	}

}
