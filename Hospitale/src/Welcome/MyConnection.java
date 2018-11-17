package Welcome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyConnection {
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=CEM;user=sa;password=sql";

	private static Connection connect;

	/*
	  M�thode qui va retourner notre instance et la cr�er si elle n'existe pas.
	 
	 */
	public static Connection getInstance() {
		if (connect == null) {

			try {
				connect = DriverManager.getConnection(url);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,
						"Erreur lors de l�tablissement de la connexion � la base de donn�es\n Code erreur: "
								+ e.getErrorCode(),
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
			System.out.println("connexion effective");

		}
		return connect;
	}
}
