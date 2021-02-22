package fr.diginamic.recensement.services.recherche;

import java.util.Scanner;

import fr.diginamic.recensement.services.MenuService;

/**
 * Classe instanciable h�ritant de MenuService pour effectuer la recherche d'un
 * d�partement afin d'afficher sa population
 * 
 * @author anton
 *
 */

public class RecherchePopulationDepartement extends MenuService {

	private String numDepartement;
	private int nbHabitantDepartement;

	/**
	 * Methode de traitement pour la recherche d'un d�partement afin d'afficher sa
	 * population. L'utilisateur choisit un d�partement (ex: 64) Parcours de la
	 * liste de ville, accumulation de la population si la ville fait partie du
	 * d�partement choisit. Affichage de la population totale et du d�partement une
	 * fois le parcours termin�
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Scanner scanner) {

		// TODO Auto-generated method stub
		System.out.println("---------- Affichage de la population d'un département ----------\n");
		System.out.print("Veuillez choisir un département : ");
		numDepartement = scanner.nextLine();
		System.out.println();

		nbHabitantDepartement = 0;

		System.out.println(
				"La population du département " + numDepartement + " est de : " + nbHabitantDepartement + " habitants");

		System.out.println();
	}

}
