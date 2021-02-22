package fr.diginamic.recensement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.MenuService;
import fr.diginamic.recensement.services.classement.ClassementDepartementPopulation;
import fr.diginamic.recensement.services.classement.ClassementRegionPopulation;
import fr.diginamic.recensement.services.classement.ClassementVillePopulationDepartement;
import fr.diginamic.recensement.services.classement.ClassementVillePopulationFrance;
import fr.diginamic.recensement.services.classement.ClassementVillePopulationRegion;
import fr.diginamic.recensement.services.recherche.RecherchePopulationDepartement;
import fr.diginamic.recensement.services.recherche.RecherchePopulationRegion;
import fr.diginamic.recensement.services.recherche.RecherchePopulationVille;

/**
 * Classe de démarrage de l'application pour la recherche et l'affichage des
 * populations suivant les villes/regions/département
 * 
 * @author anton
 *
 */
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Recensement recensement = new Recensement();

		// Lecture du fichier recensement.csv
		Path pathRecensement = Paths.get(
				"C:\\Users\\anton\\OneDrive\\Desktop\\COURS_DIGINAMIC\\Java\\Cours\\Java_approche_objet\\J7&J8_TP\\recensement.csv");

		List<String> linesFile = Files.readAllLines(pathRecensement);

		linesFile.remove(0);
		for (String lineFile : linesFile) {
			String[] villeInfo = lineFile.split(";");
			String codeRegion = villeInfo[0];
			String nomRegion = villeInfo[1];
			String codeDepartement = villeInfo[2];
			String codeCommune = villeInfo[5];
			String nomCommune = villeInfo[6];
			int populationTotale = Integer.parseInt(villeInfo[9].replace(" ", "").trim());

			Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);

			recensement.getVilles().add(ville);
		}

		System.out.println(recensement.getVilles().size());

		Scanner scanner = new Scanner(System.in);
		int userChoice = 0;

		while (userChoice != 9) {
			System.out.println("-----------------");
			userChoice = Integer.parseInt(MenuService.affichage(scanner));
			switch (userChoice) {
			case 1:
				RecherchePopulationVille recherche = new RecherchePopulationVille();
				recherche.traiter(recensement, scanner);
				break;
			case 2:
				RecherchePopulationDepartement recherche1 = new RecherchePopulationDepartement();
				recherche1.traiter(recensement, scanner);
				break;
			case 3:
				RecherchePopulationRegion recherche2 = new RecherchePopulationRegion();
				recherche2.traiter(recensement, scanner);
				break;
			case 4:
				ClassementRegionPopulation recherche3 = new ClassementRegionPopulation();
				recherche3.traiter(recensement, scanner);
				break;
			case 5:
				ClassementDepartementPopulation recherche4 = new ClassementDepartementPopulation();
				recherche4.traiter(recensement, scanner);
				break;
			case 6:
				ClassementVillePopulationDepartement recherche5 = new ClassementVillePopulationDepartement();
				recherche5.traiter(recensement, scanner);
				break;
			case 7:
				ClassementVillePopulationRegion recherche6 = new ClassementVillePopulationRegion();
				recherche6.traiter(recensement, scanner);
				break;
			case 8:
				ClassementVillePopulationFrance recherche7 = new ClassementVillePopulationFrance();
				recherche7.traiter(recensement, scanner);
				break;
			case 9:
				System.out.println("Vous allez sortir du programme\n");
				break;
			default:
				System.out.println("Veuillez choisir une option valable ou sortir du programme");
				break;
			}

		}

		System.out.println("Fermeture du programme, Au revoir");
		scanner.close();

	}

}
