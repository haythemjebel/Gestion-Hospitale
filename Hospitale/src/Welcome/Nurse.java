package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nurse extends JFrame {
	String p;
	String n;
	static Connection cnx;
	static Statement st;
	static ResultSet rst;
	JLabel JL_Mat, JL_No;
	JTextField JT_Mat, JT_No;
	JButton btn_connexion , btn_annuler;

	public Nurse() {
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Nurse");
		this.setAlwaysOnTop(true);
		this.setSize(450, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		JPanel pan = new JPanel();
		pan.setBackground(Color.white);
		pan.setLayout(new BorderLayout());
		this.add(pan);
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(420, 250));

		JTextField numinfer = new JTextField();
		numinfer.setPreferredSize(new Dimension(150, 25));

		JTextField nom = new JTextField();
		nom.setPreferredSize(new Dimension(150, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nurse : "));
		JL_Mat = new JLabel("Nurse's number : ");
		JL_Mat.setPreferredSize(new Dimension(150, 25));
		panNom.add(JL_Mat);
		panNom.add(numinfer);
		JL_No = new JLabel("Nurse's name :    ");
		JL_No.setPreferredSize(new Dimension(150, 25));
		panNom.add(JL_No);
		panNom.add(nom);
		btn_connexion = new JButton();
		btn_connexion.setText("Connection");
		btn_connexion.setBackground(Color.WHITE);
		btn_connexion.setPreferredSize(new Dimension(100, 25));
		btn_connexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cnx = connecterDB();
				String sql = "SELECT * FROM conx WHERE password= ?";
				try {

					PreparedStatement pre = cnx.prepareStatement(sql);
					pre.setString(1, numinfer.getText().toString());
					rst = pre.executeQuery();
					while (rst.next()) {
						System.out.println(rst.getString("name"));
						System.out.println(rst.getString("password"));
						String n = rst.getString("name");
						String p = rst.getString("password");
						if (numinfer.getText().toString().equals(p)){
							NUR1 d = new NUR1();
							d.setVisible(true);
							d.setTitle("Welcome Nurse "+ n);
						}else {
							JT_Mat.setText("");
							JT_No.setText("");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_annuler = new JButton();
		btn_annuler.setText("Cancel");
		btn_annuler.setPreferredSize(new Dimension( 100, 25));
		btn_annuler.setBackground(Color.WHITE);
		btn_annuler.addActionListener( new ActionListener( ) {
		public void actionPerformed( ActionEvent arg0) {
			 setVisible(false);
		     
		}});
		panNom.add(btn_connexion);
		panNom.add(btn_annuler);
		pan.add(panNom);
		
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

