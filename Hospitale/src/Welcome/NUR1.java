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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NUR1 extends JFrame {

	private JPanel contentPane;

	public NUR1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 763, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 759, 21);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Patient's List");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAffichage = new JMenuItem("Affichage");
		mnNewMenu.add(mntmAffichage);
		mntmAffichage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AFFP frame = new AFFP();
				frame.setVisible(true);
			}
		});
		JButton modifier = new JButton("");
		modifier.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\search-b-icon.png"));
		modifier.setBounds(223, 279, 137, 127);
		contentPane.add(modifier);
		modifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AFFP2 frame = new AFFP2();
				frame.setVisible(true);
			}
		});
		JButton ajouter = new JButton("");
		ajouter.setIcon(
				new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\Actions-contact-new-icon.png"));
		ajouter.setBounds(47, 215, 137, 119);
		contentPane.add(ajouter);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddP3 frame = new AddP3();
				frame.setVisible(true);
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("D:/HOPITALE DORSAF/Patient"));
				} catch (IOException f) { 
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\folder-documents-icon.png"));
		button.setBounds(482, 279, 137, 110);
		contentPane.add(button);
				
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setBounds(0, 0, 749, 463);
						contentPane.add(lblNewLabel);
						lblNewLabel.setIcon(new ImageIcon(
								"C:/Users/PROXIMEDIA/Desktop/img/fa8242f02bd1ba59cee213df.jpg"));
	}

}
