package Welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddP2 extends JFrame {
	static Connection cnx;
	static Statement st;
	static ResultSet rst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	String Sexe;
	private JTextField textField_5;

	public AddP2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 757, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Add Patient");
		lblNewLabel_1.setFont(new Font("Vladimir Script", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(215, 11, 256, 50);
		contentPane.add(lblNewLabel_1);

		JLabel lblNom = new JLabel("name :  ");
		lblNom.setForeground(new Color(0, 0, 0));
		lblNom.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblNom.setBounds(21, 138, 85, 24);
		contentPane.add(lblNom);

		JLabel lblMatricule = new JLabel("number :");
		lblMatricule.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblMatricule.setBounds(21, 93, 98, 24);
		contentPane.add(lblMatricule);

		JLabel lblDateNaiss = new JLabel("Birth date :");
		lblDateNaiss.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblDateNaiss.setBounds(21, 208, 128, 24);
		contentPane.add(lblDateNaiss);

		JLabel lblPrenom = new JLabel("first name : ");
		lblPrenom.setForeground(Color.BLACK);
		lblPrenom.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblPrenom.setBounds(21, 173, 138, 24);
		contentPane.add(lblPrenom);

		JLabel lblDeseace = new JLabel("Disease :");
		lblDeseace.setForeground(Color.BLACK);
		lblDeseace.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblDeseace.setBounds(314, 93, 104, 24);
		contentPane.add(lblDeseace);

		JLabel lblSexe = new JLabel("Sexe  :");
		lblSexe.setForeground(Color.BLACK);
		lblSexe.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblSexe.setBounds(21, 243, 85, 24);
		contentPane.add(lblSexe);

		JLabel lblRapport = new JLabel("Medical\r\n report:");
		lblRapport.setForeground(Color.BLACK);
		lblRapport.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblRapport.setBounds(314, 165, 157, 35);
		contentPane.add(lblRapport);

		textField = new JTextField();
		textField.setBounds(159, 94, 145, 20);
		String Number = textField.getText();
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		String Name = textField_1.getText();
		textField_1.setBounds(159, 139, 145, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		String Firstname = textField_2.getText();
		textField_2.setBounds(159, 174, 145, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		String Bdate = textField_3.getText();
		textField_3.setBounds(159, 209, 145, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		String Disease = textField_4.getText();
		textField_4.setBounds(472, 94, 207, 50);
		contentPane.add(textField_4);
	
		TextArea textArea = new TextArea();
		String Rapport = textArea.getText();
		textArea.setBounds(475, 173, 256, 165);
		contentPane.add(textArea);

		JButton btnOk = new JButton("");
		btnOk.setIcon(
				new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/Accept_icon.png"));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().toString().equals("") && textField_1.getText().toString().equals("") && textField_2.getText().toString().equals("") && textField_3.getText().toString().equals("") && textField_4.getText().toString().equals("") && textField_5.getText().toString().equals("")  && textArea.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "You must fill the forme ??");
				} else {
				String query = "INSERT INTO patient (Number,Name,Firstname,Bdate,Sexe,Disease,Rapport) VALUES(? , ? , ? , ? , ? , ? , ?)";
				try {
					cnx = connecterDB();
					PreparedStatement pre = cnx.prepareStatement(query);
					pre.setString(1, textField.getText().toString());
					pre.setString(2, textField_1.getText().toString());
					pre.setString(3, textField_2.getText().toString());
					pre.setString(4, textField_3.getText().toString());
					pre.setString(6, textField_4.getText().toString());
					pre.setString(5, textField_5.getText().toString());
					pre.setString(7, textArea.getText().toString());
					pre.execute();
					JOptionPane.showMessageDialog(null, "patient successfully added");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textArea.setText("");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			}
		});
		btnOk.setBounds(215, 357, 89, 50);
		contentPane.add(btnOk);

		JButton btnNn = new JButton("");
		btnNn.setIcon(new ImageIcon(
				"C:/Users/PROXIMEDIA/Desktop/img/Button_Close_icon.png"));
		btnNn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNn.setBounds(344, 357, 89, 50);
		contentPane.add(btnNn);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		String Sexe = textField_5.getText();
		textField_5.setBounds(159, 248, 145, 20);
		contentPane.add(textField_5);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setForeground(new Color(0, 0, 0));
				lblNewLabel.setIcon(
						new ImageIcon("C:/Users/PROXIMEDIA/Desktop/img/1257aee4976d960.jpg"));
				lblNewLabel.setBounds(0, 0, 741, 440);
				contentPane.add(lblNewLabel);
	}

	public static Connection connecterDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver oki");
			String url = "jdbc:mysql://localhost/gestionhop";
			String user = "root";
			String password = "";
			Connection cnx = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion bien établié");
			return cnx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
