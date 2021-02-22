package fr.diginamic.recensement.services.classement;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.MenuService;
import fr.diginamic.recensement.services.comparateur.ComparatorHabitantDecroissant;

/**
 * Classe instanciable h�ritant de MenuService pour afficher les 10 villes les
 * plus peupl�s de France
 * 
 * @author anton
 *
 */
public class ClassementVillePopulationFrance extends MenuService {

	/**
	 * M�thode pour afficher les 10 villes les plus peupl�es de France. La liste de
	 * ville est tri�e via un Comparator dans l'ordre d�croissant puis L'affichage
	 * s'effectue avec un forEach des 10 premiers �l�ments parcouru via un stream
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Recensement recensement, Scanner scanner) {

		// TODO Auto-generated method stub
		ArrayList<Ville> villesFrance = new ArrayList<Ville>(recensement.getVilles());

		System.out.println("---------- Affichage des 10 villes les plus peuplées de France ----------");

		villesFrance.sort(new ComparatorHabitantDecroissant());

		System.out.println();

		System.out.println("Les 10 villes les plus peuplées de France sont : \n");

		villesFrance.stream().limit(10).forEach(ville -> System.out
				.println(ville.getNomCommune() + " avec " + ville.getPopulationTotale() + " habitants"));
		System.out.println();

	}

}
