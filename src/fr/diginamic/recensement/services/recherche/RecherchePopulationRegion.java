package fr.diginamic.recensement.services.recherche;

import java.util.Scanner;

import fr.diginamic.recensement.services.MenuService;

/**
 * Classe instanciable h�ritant de MenuService pour effectuer la recherche d'une
 * r�gion afin d'afficher sa population
 * 
 * @author anton
 *
 */

public class RecherchePopulationRegion extends MenuService {

	private int nbHabitantRegion;
	private String nomRegion;

	/**
	 * Methode de traitement pour la recherche d'une r�gion afin d'afficher sa
	 * population. L'utilisateur choisit une r�gion (ex: Occitanie) Parcours de la
	 * liste de ville, accumulation de la population si la ville fait partie de la
	 * r�gion choisit. Affichage de la population totale et de la region une fois le
	 * parcours termin�
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Scanner scanner) {
		// TODO Auto-generated method stub

		System.out.println("---------- Affichage de la population d'une région ----------\n");
		System.out.print("Veuillez choisir une région : ");
		nomRegion = scanner.nextLine();
		System.out.println();

		nbHabitantRegion = 0;

		System.out.println("La population de la région " + nomRegion + " est de : " + nbHabitantRegion + " habitants");

		System.out.println();
	}

}
