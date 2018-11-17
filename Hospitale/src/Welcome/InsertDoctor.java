package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class InsertDoctor extends JFrame {
	private JLabel nomLabel, numele, prenoml, datel, poidsl , specialite1 ,salaire1, password1;
	// private JTextField numdoctor,nome,prenome, dateT, poids;
	private JFormattedTextField daten = new JFormattedTextField(DateFormat.getDateInstance());
	private JButton b01 = new JButton();
	private JButton b02 = new JButton();
	static Connection cnx;
	public InsertDoctor( ) {
		
			this.setVisible(true);
			this. setTitle( "Insert Doctor") ;
			this.setAlwaysOnTop(true);
			this. setSize( 500, 350) ;
			this.setResizable(false);
			this. setLocationRelativeTo( null) ;
			this. getContentPane( ).setLayout( new FlowLayout( )) ;
			JPanel pan = new JPanel( ) ;
			pan. setBackground( Color. white) ;
			pan. setLayout( new BorderLayout( ) ) ;
			this.add(pan);
			JPanel panNom = new JPanel( ) ;
			panNom. setBackground( Color. white) ;
			panNom. setPreferredSize( new Dimension( 420, 380) ) ;
			
			
			JTextField numdoctor  = new JTextField();
			numdoctor.setPreferredSize(new Dimension(150, 25));
			
		
			JTextField nom  = new JTextField();
			nom.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField prenom  = new JTextField();
			prenom.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField date  = new JTextField();
			date.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField dateh  = new JTextField();
			dateh.setPreferredSize(new Dimension(150, 25));
			
			JTextField specialite  = new JTextField();
			specialite.setPreferredSize(new Dimension(150, 25));
			
			JTextField salaire= new JTextField();
			salaire.setPreferredSize(new Dimension(150, 25)); 
			
			JTextField password  = new JTextField();
			password.setPreferredSize(new Dimension(150, 25));
		
		
		panNom.setBorder( BorderFactory. createTitledBorder( "Doctor Information : ") ) ;
		numele = new JLabel( "Doctor's number : ") ;
		numele.setPreferredSize(new Dimension( 150, 25));
		panNom.add(numele);
		panNom.add(numdoctor);
		nomLabel = new JLabel("Doctor's name :    ") ;
		nomLabel.setPreferredSize(new Dimension( 150, 25));
		panNom. add( nomLabel) ;
		panNom. add( nom) ;
		prenoml = new JLabel("Doctor's first name :  ");
		prenoml.setPreferredSize(new Dimension( 150, 25));
		panNom.add(prenoml);
		panNom.add(prenom);
		datel = new JLabel("Birth date :");
		datel.setPreferredSize(new Dimension( 150, 25));
		panNom.add(datel);
		panNom.add(date);
		poidsl = new JLabel("Hiring date : ");
		poidsl.setPreferredSize(new Dimension( 150, 25));
		panNom.add(poidsl);
		panNom.add(dateh);
		specialite1 = new JLabel("specialty : ");
		specialite1.setPreferredSize(new Dimension( 150, 25));
		panNom.add(specialite1);
		panNom.add(specialite);
		salaire1 = new JLabel("salaire : ");
		salaire1.setPreferredSize(new Dimension( 150, 25));
		panNom.add(salaire1);
		panNom.add(salaire);
		password1 = new JLabel("password : ");
		password1.setPreferredSize(new Dimension( 150, 25));
		panNom.add(password1);
		panNom.add(password);
		b01 = new JButton();
		b01.setText("Validate");
		b01.setBackground(Color.WHITE);
		b01.setPreferredSize(new Dimension( 100, 25));
		
		b01.addActionListener( new ActionListener( ) {
		public void actionPerformed( ActionEvent arg0) {
			String query = "INSERT INTO doctor (Number,Name,Firstname,Bdate,Hdate,Speciality,salaire,Password) VALUES(? , ? , ? , ? , ? , ? , ? , ? )";
			String query1 = "INSERT INTO conx (name,password) VALUES(? , ? )";
			try {
				cnx = connecterDB();
				PreparedStatement pre = cnx.prepareStatement(query);
				pre.setString(1, numdoctor.getText().toString());
				pre.setString(2, nom.getText().toString());
				pre.setString(3, prenom.getText().toString());
				pre.setString(4, date.getText().toString());
				pre.setString(5, dateh.getText().toString());
				pre.setString(6, specialite.getText().toString());
				pre.setString(7, salaire.getText().toString());
				pre.setString(8, password.getText().toString());
				pre.execute();
				PreparedStatement pre1 = cnx.prepareStatement(query1);
				pre1.setString(1, nom.getText().toString());
				pre1.setString(2, password.getText().toString());
				pre1.execute();
				System.out.println("good add");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		     
		}});
		b02 = new JButton();
		b02.setText("Cancel");
		b02.setPreferredSize(new Dimension( 100, 25));
		b02.setBackground(Color.WHITE);
		b02.addActionListener( new ActionListener( ) {
		public void actionPerformed( ActionEvent arg0) {
			 setVisible(false);
		     
		}});
		panNom.add(b01);
		panNom.add(b02);
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
