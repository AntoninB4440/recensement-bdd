package fr.diginamic.recensement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.diginamic.recensement.dao.ConnectionMgr;

public class IntegrationRecensement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Connection connection = ConnectionMgr.getConnection();

		List<String> linesFile;

		// Lecture du fichier recensement.csv
		Path pathRecensement = Paths.get(
				"C:\\Users\\anton\\OneDrive\\Desktop\\COURS_DIGINAMIC\\Java\\Cours\\Java_approche_objet\\J7&J8_TP\\recensement.csv");

		try {
			Statement statement = connection.createStatement();
			linesFile = Files.readAllLines(pathRecensement);

			linesFile.remove(0);
			for (String lineFile : linesFile) {
				String[] villeInfo = lineFile.split(";");
				String codeRegion = villeInfo[0];
				String codeDepartement = villeInfo[2];
				String nomCommune = villeInfo[6].replaceAll("'", "''");
				int populationTotale = Integer.parseInt(villeInfo[9].replace(" ", "").trim());
				System.out.println("ok ca fonctionne");

				statement.executeUpdate(
						"INSERT INTO ville(code_region,code_departement,nom_ville,population_ville) VALUES('"
								+ codeRegion + "','" + codeDepartement + "','" + nomCommune + "'," + populationTotale
								+ ")");

			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problème de requete" + e.getMessage());
		}

	}

}
