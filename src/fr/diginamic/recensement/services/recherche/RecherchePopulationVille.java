package fr.diginamic.recensement.services.recherche;

import java.util.Scanner;

import fr.diginamic.recensement.dao.VilleDao;
import fr.diginamic.recensement.services.MenuService;

/**
 * Classe instanciable h�ritant de MenuService pour effectuer la recherche d'une
 * ville afin d'afficher sa population
 * 
 * @author anton
 *
 */
public class RecherchePopulationVille extends MenuService {

	private String nomVille;
	private String nomVilleTable;

	/**
	 * Methode de traitement pour la recherche d'une ville afin d'afficher sa
	 * population L'utilisateur choisit une ville (ex: Montpellier) Parcours de la
	 * liste de ville puis affichage de la ville et de sa population si la ville
	 * correspond au choix de l'utilisateur
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Scanner scanner) {
		// TODO Auto-generated method stub

		System.out.println("---------- Affichage de la population d'une ville ----------\n");
		System.out.print("Veuillez choisir une ville : ");
		nomVille = scanner.nextLine();

		System.out.println(nomVille);

		VilleDao.recherchePopVille(nomVille);

	}

}
