package Welcome;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AFFD extends JFrame {
	 static Connection cnx;
	 static Statement st;
	 static ResultSet rst;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	public AFFD() {
		setTitle("Doctor's List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 466);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 633, 405);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		 cnx=connecterDB(); 
		 String sql = "SELECT * FROM doctor ";
         try {
			
			PreparedStatement pre = cnx.prepareStatement(sql);
			rst = pre.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PROXIMEDIA\\Desktop\\img\\ThinkstockPhotos-126930170-e1440532560232.jpg"));
			lblNewLabel.setBounds(0, 0, 700, 427);
			contentPane.add(lblNewLabel);
		} catch (SQLException e) {
			e.printStackTrace();
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
