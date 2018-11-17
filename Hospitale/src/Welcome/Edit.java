package Welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Edit extends JFrame implements ActionListener {
	 static Connection cnx;
	 static Statement st;
	 static ResultSet rst;
	JLabel JL_id;
	public JTextField JT_id;
	JButton btn_search;
	String id;

	public Edit () {
		super("Search");
		JL_id = new JLabel("Enter ID:");
		JL_id.setBounds(40, 40, 200, 40);
		JT_id = new JTextField(20);
		JT_id.setBounds(130, 40, 150, 40);
		btn_search = new JButton("Search");
		btn_search.setBounds(300, 40, 80, 40);
		btn_search.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400, 200);
		setLayout(null);
		add(btn_search);
		add(JL_id);
		add(JT_id);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (JT_id.getText().toString().equals("")) {
			JOptionPane.showMessageDialog(null, "number required");
		} else {
		ModifP1 frame = new ModifP1();
		frame.setVisible(true);
		String id = JT_id.getText();
		recherchePparNumber(id);
		JT_id.setText("");
		}
	}
    public static void recherchePparNumber(String id){
        try{
           String query="SELECT * FROM patient WHERE Number='"+id+"'"; 
           cnx=connecterDB();
           st=cnx.createStatement();
           rst= st.executeQuery(query);
           rst.last();
           int nbrRow = rst.getRow();
           if(nbrRow!=0){
              JOptionPane.showMessageDialog(null, "Patient trouve");
           }else{
        	   JOptionPane.showMessageDialog(null, "Patient non trouve");
               
           }
           
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }

	public static Connection  connecterDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            String url="jdbc:mysql://localhost/gestionhop";
            String user="root";
            String password="";
           Connection cnx=DriverManager.getConnection(url,user,password);
            System.out.println("Connexion bien établié");
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
