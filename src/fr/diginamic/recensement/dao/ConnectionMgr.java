package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionMgr {

	static {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverClass = monFichierConf.getString("database.driver");

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de charger le Driver");
		}

	}

	public static Connection getConnection() {
		try {

			String password = System.getProperty("password");
			// Run as configuration -> Arguments -> VMArguments -Dpassword=password

			ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
			String driverClass = monFichierConf.getString("database.driver");
			String databaseUrl = monFichierConf.getString("database.url");
			String databaseUser = monFichierConf.getString("database.user");

			Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Impossible de se connecter à l'application");
			return null;
		}

	}

}
