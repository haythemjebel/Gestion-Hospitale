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

public class ModifP1 extends JFrame {
	static Connection cnx;
	static Statement st;
	static ResultSet rst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_4;

	public ModifP1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 757, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Modiy Patient");
		lblNewLabel_1.setFont(new Font("Vladimir Script", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(230, 11, 276, 71);
		contentPane.add(lblNewLabel_1);

		JLabel lblMatricule = new JLabel("number :");
		lblMatricule.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblMatricule.setBounds(21, 93, 98, 24);
		contentPane.add(lblMatricule);

		JLabel lblDeseace = new JLabel("Disease :");
		lblDeseace.setForeground(Color.BLACK);
		lblDeseace.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblDeseace.setBounds(314, 93, 104, 24);
		contentPane.add(lblDeseace);

		JLabel lblRapport = new JLabel("Medical\r\n report:");
		lblRapport.setForeground(Color.BLACK);
		lblRapport.setFont(new Font("SimSun", Font.PLAIN, 20));
		lblRapport.setBounds(21, 159, 157, 35);
		contentPane.add(lblRapport);

		textField = new JTextField();
		textField.setBounds(159, 94, 145, 20);
		String Number = textField.getText();
		contentPane.add(textField);
		textField.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		String Disease = textField.getText();
		textField_4.setBounds(472, 94, 207, 50);
		contentPane.add(textField_4);

		TextArea textArea = new TextArea();
		String Rapport = textArea.getText();

		textArea.setBounds(215, 159, 464, 178);
		contentPane.add(textArea);

		JButton btnOk = new JButton("");
		btnOk.setIcon(
				new ImageIcon("C:/Users/PROXIMEDIA/Desktop/Project/Project/Hospital/src/Welcome/Accept_icon.png"));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "number required");
				} else {
				String query = "UPDATE patient SET Number=?, Disease=?, Rapport=? WHERE Number=?";
				try {
					cnx = connecterDB();
					PreparedStatement pre = cnx.prepareStatement(query);
					pre.setString(1, textField.getText().toString());
					pre.setString(2, textField_4.getText().toString());
					pre.setString(3, textArea.getText().toString());
					pre.setString(4, textField.getText().toString());
					pre.execute();
					JOptionPane.showMessageDialog(null, "patient successfully modified");
					
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
				"C:/Users/PROXIMEDIA/Desktop/Project/Project/Hospital/src/Welcome/Button_Close_icon.png"));
		btnNn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNn.setBounds(344, 357, 89, 50);
		contentPane.add(btnNn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(
				new ImageIcon("C:/Users/PROXIMEDIA/Desktop/Project/Project/Hospital/src/Welcome/backdoct.jpg"));
		lblNewLabel.setBounds(0, 0, 741, 440);
		contentPane.add(lblNewLabel);
	}

	/*public static void ModifierP(String Number,String Disease,String Rapport){
	       try{
	           String query="UPDATE patient SET Number="+Number+", Disease="+Disease+", Rapport='"+Rapport+" WHERE Number="+Number;
	           cnx=connecterDB();
	           st=cnx.createStatement();
	           st.executeUpdate(query);
	           System.out.println("Produit bien modifié");
	           
	       }catch(SQLException e){
	           System.out.println(e.getMessage());
	       }
	   }*/

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
