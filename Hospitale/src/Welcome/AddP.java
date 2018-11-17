package Welcome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class AddP extends JFrame {
	private JLabel nomLabel, numele, prenoml, datel, poidsl , specialite1;
	private JFormattedTextField daten = new JFormattedTextField(DateFormat.getDateInstance());
	private JButton b01 = new JButton();
	private JButton b02 = new JButton();

	public AddP( ) {
		
			this.setVisible(true);
			this. setTitle( "Insert Patient") ;
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
			panNom. setPreferredSize( new Dimension( 420, 400) ) ;
			
			
			JTextField numdoctor  = new JTextField();
			numdoctor.setPreferredSize(new Dimension(150, 25));
			
		
			JTextField nom  = new JTextField();
			nom.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField prenom  = new JTextField();
			prenom.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField date  = new JTextField();
			date.setPreferredSize(new Dimension(150, 25));
			
			
			JTextField poids  = new JTextField();
			poids.setPreferredSize(new Dimension(150, 25));
			
			JTextArea specialite  = new JTextArea(6,20);
			specialite.setPreferredSize(new Dimension(150, 25));
		
		
		panNom.setBorder( BorderFactory. createTitledBorder( "Patient Information : ") ) ;
		numele = new JLabel( "Patient's number : ") ;
		numele.setPreferredSize(new Dimension( 150, 25));
		panNom.add(numele);
		panNom.add(numdoctor);
		nomLabel = new JLabel("Patient's name :    ") ;
		nomLabel.setPreferredSize(new Dimension( 150, 25));
		panNom. add( nomLabel) ;
		panNom. add( nom) ;
		prenoml = new JLabel("Patient's first name :  ");
		prenoml.setPreferredSize(new Dimension( 150, 25));
		panNom.add(prenoml);
		panNom.add(prenom);
		datel = new JLabel("Birth date :");
		datel.setPreferredSize(new Dimension( 150, 25));
		panNom.add(datel);
		panNom.add(date);
		poidsl = new JLabel("Disease : ");
		poidsl.setPreferredSize(new Dimension( 150, 25));
		panNom.add(poidsl);
		panNom.add(poids);
		specialite1 = new JLabel("Medical report : ");
		specialite1.setPreferredSize(new Dimension( 150, 25));
		panNom.add(specialite1);
		panNom.add(specialite);
		b01 = new JButton();
		b01.setText("Validate");
		b01.setBackground(Color.WHITE);
		b01.setPreferredSize(new Dimension( 100, 25));
		
		b01.addActionListener( new ActionListener( ) {
		public void actionPerformed( ActionEvent arg0) {
			
			String num = numdoctor.getText();
			String no = nom.getText() ;
			String preno = prenom.getText();
			String dn = date.getText();
			float poi = Float.valueOf(poids.getText());
			String spe = specialite.getText();
			
			String requete = "INSERT INTO Doctor VALUES ('"+num+"','"+no+"','"+preno+"','"+dn+"',"+poi+"',"+spe+")";
			 long start = System.currentTimeMillis();
		      Statement state;
			try {
				
				state = MyConnection.getInstance().createStatement();
			int res = state.executeUpdate(requete);
			if(res!=0){
				 //state.execute(requete);
					setVisible( false) ;
					JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
					}
				 //state.execute(requete);
					setVisible( false) ;
					//res.close();
					state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
				e.printStackTrace();
			}
		 //On exécute la requête
		     
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

}
