package Welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AFFP2 extends JFrame {
	static Connection cnx;
	static Statement st;
	static ResultSet rst;
	private JTable table;
	String id;
	private JPanel contentPane;
	private JTextField textField;

	public AFFP2() {
		setTitle("LIST Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPatientsList = new JLabel("Patient 's List");
		lblPatientsList.setFont(new Font("SansSerif", Font.PLAIN, 29));
		lblPatientsList.setBounds(240, 11, 239, 25);
		contentPane.add(lblPatientsList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 47, 549, 387);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		textField = new JTextField();
		textField.setBounds(22, 71, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNumber = new JLabel("Number :");
		lblNumber.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNumber.setBounds(22, 29, 77, 33);
		contentPane.add(lblNumber);

		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\search_b_icon1.png"));
		btnOk.setBounds(22, 102, 89, 69);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( textField.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "number required");
				} else {
				cnx = connecterDB();
				String sql = "SELECT * FROM patient WHERE Number= ?"; 
		         try {
					
					PreparedStatement pre = cnx.prepareStatement(sql);
					pre.setString(1, textField.getText().toString());
					rst = pre.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rst));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\slides-mobilier-bureau.png"));
		lblNewLabel.setBounds(0, 0, 749, 445);
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
