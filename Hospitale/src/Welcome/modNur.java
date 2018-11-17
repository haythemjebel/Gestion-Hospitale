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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class modNur extends JFrame {
	static Connection cnx;
	static Statement st;
	static ResultSet rst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public modNur() {
		setTitle("Modify Nurse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 753, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSalaire = new JLabel("Salaire :");
		lblSalaire.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSalaire.setBounds(72, 97, 112, 32);
		contentPane.add(lblSalaire);

		textField = new JTextField();
		textField.setBounds(196, 101, 222, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( textField_1.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "number required");
				} else {
				String query = "UPDATE nurse SET salaire = ?  WHERE Number=?";
				try {
					cnx = connecterDB();
					PreparedStatement pre = cnx.prepareStatement(query);
					pre.setString(2, textField_1.getText().toString());
					pre.setString(1, textField.getText().toString());
					pre.execute();
					JOptionPane.showMessageDialog(null, "Modified nurse");
					textField_1.setText("");
					textField.setText("");

				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}}

			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\Accept_icon.png"));
		button.setBounds(421, 180, 89, 52);
		contentPane.add(button);
		
		JLabel lblNumber = new JLabel("Number :");
		lblNumber.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNumber.setBounds(72, 58, 112, 32);
		contentPane.add(lblNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 58, 222, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
				
				JButton button_1 = new JButton("");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				button_1.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\Button_Close_icon.png"));
				button_1.setBounds(276, 180, 89, 52);
				contentPane.add(button_1);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\fa8242f02bd1ba59cee213df.jpg"));
				lblNewLabel.setBounds(0, 0, 737, 403);
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
