package fr.diginamic.recensement.services.comparateur;

import java.util.Comparator;

import fr.diginamic.recensement.entites.Ville;

/**
 * Classe instanciable impl�mentant un Comparator de type Ville
 * 
 * @author anton
 *
 */
public class ComparatorHabitantDecroissant implements Comparator<Ville> {

	/**
	 * M�thode pour effectuer le tri d'une liste de ville dans l'ordre d�croissant
	 * suivant la populationTotale
	 */
	@Override
	public int compare(Ville o1, Ville o2) {
		// TODO Auto-generated method stub
		if (o1.getPopulationTotale() < o2.getPopulationTotale()) {
			return 1;
		} else if (o1.getPopulationTotale() > o2.getPopulationTotale()) {
			return -1;
		} else {
			return 0;
		}
	}

}
