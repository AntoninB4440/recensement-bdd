package fr.diginamic.recensement;

import java.io.IOException;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
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
 * Classe de d�marrage de l'application pour la recherche et l'affichage des
 * populations suivant les villes/regions/d�partement
 * 
 * @author anton
 *
 */
public class Application {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Recensement recensement = new Recensement();

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
