package fr.diginamic.recensement.services.classement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.MenuService;

/**
 * Classe instanciable h�ritant de MenuService pour afficher les 10 r�gions les
 * plus peupl�s de France
 * 
 * @author anton
 *
 */
public class ClassementRegionPopulation extends MenuService {

	/**
	 * M�thode pour afficher les 10 r�gions les plus peupl�s. Parcours la liste de
	 * ville du recensement, accumule la population d'une r�gion au fur et � mesure.
	 * Par ligne les informations sont stock�es dans une HashMap via des cl� valeur
	 * (key : region, valeur: PopulationTotale) L'affichage s'effectue avec un
	 * forEach de 10 entr�es retourn�es par un Set sorted dans l'ordre inverse
	 * 
	 * @param recensement
	 * @param scanner
	 */
	@Override
	public void traiter(Scanner scanner) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> classementRegion = new HashMap<String, Integer>();

		for (Ville ville : recensement.getVilles()) {
			String regionVille = ville.getNomRegion();

			Integer populationRegion = classementRegion.get(regionVille);

			if (populationRegion == null) {
				populationRegion = ville.getPopulationTotale();
			} else {
				populationRegion += ville.getPopulationTotale();
			}

			classementRegion.put(regionVille, populationRegion);
		}

		// System.out.println(classementRegion.values());

		System.out.println("---------- Affichage des 10 régions les plus peuplées de France ----------\n");
		classementRegion.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
				.forEach(entry -> {
					System.out.println("Région : " + entry.getKey() + " | Habitants : " + entry.getValue());
				});

	}

}
