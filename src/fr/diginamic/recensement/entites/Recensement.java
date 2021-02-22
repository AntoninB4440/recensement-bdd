package fr.diginamic.recensement.entites;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Recensement instanciable afin de stocker uen liste de ville (ici
 * depuis un fichier csv)
 * 
 * @author anton
 *
 */
public class Recensement {

	private List<Ville> villes = new ArrayList<Ville>();

	/**
	 * Getter permettant de récuprer la liste de ville
	 * 
	 * @return Les villes
	 */
	public List<Ville> getVilles() {
		return villes;
	}

	/**
	 * Setter permettant de modifier une ville dans la liste
	 * 
	 * @param villes the villes to set
	 */
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	@Override
	public String toString() {
		return "Recensement [villes=" + villes + "]";
	}

}
