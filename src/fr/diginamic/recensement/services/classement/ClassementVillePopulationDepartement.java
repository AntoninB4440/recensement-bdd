package fr.diginamic.recensement.services.classement;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.MenuService;
import fr.diginamic.recensement.services.comparateur.ComparatorHabitantDecroissant;

/**
 * Classe instanciable h�ritant de MenuService pour afficher les 10 villes les
 * plus peupl�s d'un d�partement choisit
 * 
 * @author anton
 *
 */
public class ClassementVillePopulationDepartement extends MenuService {

	private String numDepartement;

	/**
	 * M�thode pour afficher les 10 villes les plus peupl�es d'un d�partement.
	 * Parcours la liste de ville du recensement, si le d�partement de la ville
	 * correspond au d�partement choisit, la ville est stock� dans une liste.La
	 * liste de ville du d�partement est ensuite tri� via un Comparator dans l'ordre
	 * d�croissant puis L'affichage s'effectue avec un forEach des 10 premiers
	 * �l�ments parcouru via un stream
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Scanner scanner) {
		// TODO Auto-generated method stub

		ArrayList<Ville> villesDepartement = new ArrayList<Ville>();

		System.out.println("---------- Affichage des 10 villes les plus peuplées d'un département ----------");
		System.out.print("Veuillez choisir un département : ");
		numDepartement = scanner.nextLine();
		System.out.println();

		for (Ville ville : recensement.getVilles()) {
			if (ville.getCodeDepartement().equals(numDepartement)) {

				villesDepartement.add(ville);
			}
		}

		villesDepartement.sort(new ComparatorHabitantDecroissant());

		System.out.println("Les 10 villes les plus peuplées du " + numDepartement + " sont : \n");

		villesDepartement.stream().limit(10).forEach(ville -> System.out
				.println(ville.getNomCommune() + " avec " + ville.getPopulationTotale() + " habitants"));
		System.out.println();

	}

}
