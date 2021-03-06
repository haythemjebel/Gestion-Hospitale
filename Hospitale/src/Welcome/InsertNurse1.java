package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import java.awt.Font;

public class InsertNurse1 extends JFrame {
	private JFormattedTextField daten = new JFormattedTextField(DateFormat.getDateInstance());
	private JButton b01 = new JButton();
	private JButton b02 = new JButton();
	static Connection cnx;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel labimg;
	private String s;

	public InsertNurse1() {

		this.setVisible(true);
		this.setTitle("Insert Nurse");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setSize(580, 437);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNursesNumber = new JLabel("Nurse's number : ");
		lblNursesNumber.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNursesNumber.setPreferredSize(new Dimension(150, 25));
		lblNursesNumber.setBounds(115, 46, 150, 25);
		getContentPane().add(lblNursesNumber);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, 25));
		textField.setBounds(343, 48, 150, 25);
		getContentPane().add(textField);

		JLabel lblNursesName = new JLabel("Nurse's name :    ");
		lblNursesName.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNursesName.setPreferredSize(new Dimension(150, 25));
		lblNursesName.setBounds(115, 76, 150, 25);
		getContentPane().add(lblNursesName);

		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(150, 25));
		textField_1.setBounds(343, 78, 150, 25);
		getContentPane().add(textField_1);

		JLabel lblSFirstName = new JLabel("Nurse's first name :  ");
		lblSFirstName.setFont(new Font("Verdana", Font.BOLD, 13));
		lblSFirstName.setPreferredSize(new Dimension(150, 25));
		lblSFirstName.setBounds(115, 106, 168, 25);
		getContentPane().add(lblSFirstName);

		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(150, 25));
		textField_2.setBounds(343, 108, 150, 25);
		getContentPane().add(textField_2);

		JLabel label_3 = new JLabel("Birth date :");
		label_3.setFont(new Font("Verdana", Font.BOLD, 13));
		label_3.setPreferredSize(new Dimension(150, 25));
		label_3.setBounds(115, 136, 150, 25);
		getContentPane().add(label_3);

		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(150, 25));
		textField_3.setBounds(343, 138, 150, 25);
		getContentPane().add(textField_3);

		JLabel label_4 = new JLabel("Hiring date : ");
		label_4.setFont(new Font("Verdana", Font.BOLD, 13));
		label_4.setPreferredSize(new Dimension(150, 25));
		label_4.setBounds(115, 172, 150, 25);
		getContentPane().add(label_4);

		textField_4 = new JTextField();
		textField_4.setPreferredSize(new Dimension(150, 25));
		textField_4.setBounds(343, 172, 150, 25);
		getContentPane().add(textField_4);

		JLabel label_6 = new JLabel("salaire : ");
		label_6.setFont(new Font("Verdana", Font.BOLD, 13));
		label_6.setPreferredSize(new Dimension(150, 25));
		label_6.setBounds(115, 202, 150, 25);
		getContentPane().add(label_6);

		textField_6 = new JTextField();
		textField_6.setPreferredSize(new Dimension(150, 25));
		textField_6.setBounds(343, 204, 150, 25);
		getContentPane().add(textField_6);

		JLabel label_7 = new JLabel("password : ");
		label_7.setFont(new Font("Verdana", Font.BOLD, 13));
		label_7.setPreferredSize(new Dimension(150, 25));
		label_7.setBounds(115, 238, 150, 25);
		getContentPane().add(label_7);

		textField_7 = new JTextField();
		textField_7.setPreferredSize(new Dimension(150, 25));
		textField_7.setBounds(343, 240, 150, 25);
		getContentPane().add(textField_7);

		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_7.getText().toString().equals("") && textField_1.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "name and password required");
				} else {
					String query = "INSERT INTO nurse (Number,Name,Firstname,Bdate,Hdate,salaire,Password,image) VALUES(? , ? , ? , ? , ? , ? , ? , ?)";
					String query1 = "INSERT INTO conx (name,password) VALUES(? , ? )";
					try {
						InputStream img = new FileInputStream(new File(s));
						cnx = connecterDB();
						PreparedStatement pre = cnx.prepareStatement(query);
						pre.setString(1, textField.getText().toString());
						pre.setString(2, textField_1.getText().toString());
						pre.setString(3, textField_2.getText().toString());
						pre.setString(4, textField_3.getText().toString());
						pre.setString(5, textField_4.getText().toString());
						pre.setString(6, textField_6.getText().toString());
						pre.setString(7, textField_7.getText().toString());
						pre.setBlob(8, img);
						pre.execute();
						PreparedStatement pre1 = cnx.prepareStatement(query1);
						pre1.setString(1, textField_1.getText().toString());
						pre1.setString(2, textField_7.getText().toString());
						pre1.execute();
					
						Runnable th = new Runnable() {

							@Override
							public void run() {
								try {
									textField.setText("");
									textField_1.setText("");
									textField_2.setText("");
									textField_3.setText("");
									textField_4.setText("");
									textField_6.setText("");
									textField_7.setText("");
									labimg.setText("");
								} catch (Exception e) {

								}
							}
						};
						Thread thre = new Thread(th);
						thre.start();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		button.setText("Validate");
		button.setPreferredSize(new Dimension(100, 25));
		button.setBackground(Color.WHITE);
		button.setBounds(163, 372, 100, 25);
		getContentPane().add(button);

		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button_1.setText("Cancel");
		button_1.setPreferredSize(new Dimension(100, 25));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(270, 372, 100, 25);
		getContentPane().add(button_1);

		JLabel lblNewLabel_1 = new JLabel("Image  :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel_1.setBounds(115, 274, 89, 25);
		getContentPane().add(lblNewLabel_1);

		JLabel labimg = new JLabel("");
		labimg.setForeground(Color.PINK);
		labimg.setBackground(Color.WHITE);
		labimg.setBounds(239, 292, 131, 59);
		getContentPane().add(labimg);

		JButton btnParcourir = new JButton("Parcourir");
		btnParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File("C:/Users/PROXIMEDIA/Desktop"));
				FileNameExtensionFilter filtre = new FileNameExtensionFilter("IMAGE", "jpg", "png", "gif");
				file.addChoosableFileFilter(filtre);
				int res = file.showSaveDialog(btnParcourir);
				if (res == JFileChooser.APPROVE_OPTION) {
					File selctf = file.getSelectedFile();
					String path = selctf.getAbsolutePath();
					ImageIcon myimg = new ImageIcon(path);
					java.awt.Image img = myimg.getImage();
					java.awt.Image newimg = img.getScaledInstance(labimg.getWidth(), labimg.getHeight(),
							java.awt.Image.SCALE_SMOOTH);
					ImageIcon finalim = new ImageIcon(newimg);
					labimg.setIcon(finalim);
					s = path;

				} else {
					if (res == JFileChooser.CANCEL_OPTION)
						JOptionPane.showMessageDialog(null, "nothing is chosen");
				}
			}
		});
		btnParcourir.setBounds(404, 311, 89, 23);
		getContentPane().add(btnParcourir);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\llld4.jpg"));
				lblNewLabel.setBounds(0, 0, 574, 408);
				getContentPane().add(lblNewLabel);

	}

	public static Connection connecterDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver oki");
			String url = "jdbc:mysql://localhost/gestionhop";
			String user = "root";
			String password = "";
			Connection cnx = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion bien �tabli�");
			return cnx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
