package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VilleDao {

	public static void recherchePopVille(String nomVille) {

		Connection connection = ConnectionMgr.getConnection();

		try {
			Statement statement = connection.createStatement();

			ResultSet curser = statement
					.executeQuery("select * from ville where nom_ville ='" + nomVille.replaceAll("'", "''") + "'");

			if (curser.next()) {
				Integer pop = curser.getInt("population_ville");

				System.out.println(nomVille + " : " + pop + " habitants");
			}

			curser.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème de requete");
		}
	}
}
