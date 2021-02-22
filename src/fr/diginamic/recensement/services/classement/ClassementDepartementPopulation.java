package fr.diginamic.recensement.services.classement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.MenuService;

/**
 * Classe instanciable h�ritant de MenuService pour afficher les 10 d�partements
 * les plus peupl�s de France
 * 
 * @author anton
 *
 */
public class ClassementDepartementPopulation extends MenuService {

	/**
	 * M�thode pour afficher les 10 d�partements les plus peupl�s. Parcours la liste
	 * de ville du recensement, accumule la population d'un d�partement au fur et �
	 * mesure. Par ligne les informations sont stock�es dans une HashMap via des cl�
	 * valeur (key : departement, valeur: PopulationTotale) L'affichage s'effectue
	 * avec un forEach de 10 entr�es retourn�es par un Set sorted dans l'ordre
	 * inverse
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Recensement recensement, Scanner scanner) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> classementDepartement = new HashMap<String, Integer>();

		for (Ville ville : recensement.getVilles()) {
			String departementVille = ville.getCodeDepartement();

			Integer populationDepartement = classementDepartement.get(departementVille);

			if (populationDepartement == null) {
				populationDepartement = ville.getPopulationTotale();
			} else {
				populationDepartement += ville.getPopulationTotale();
			}

			classementDepartement.put(departementVille, populationDepartement);
		}

		System.out.println("---------- Affichage des 10 départements les plus peuplés de France ----------\n");
		classementDepartement.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(10).forEach(entry -> {
					System.out.println("Département : " + entry.getKey() + " | Habitants : " + entry.getValue());
				});
	}

}
