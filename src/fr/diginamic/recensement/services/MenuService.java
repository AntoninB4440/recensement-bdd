package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;

/**
 * Classe abstraite avec m�thode static g�rant l'affichage des options et
 * m�thode abstraite pour signature
 * 
 * @author anton
 *
 */
public abstract class MenuService {

	/**
	 * M�thode static g�rant l'affichage et retournant le choix de l'utilisateur ex
	 * : (1 - pour la population d'une ville choisie)
	 * 
	 * @param scanner
	 * @return L'affichage des options et l'option choisit par l'utilisateur
	 */
	public static String affichage(Scanner scanner) {
		System.out.println("Choix d'option :");
		System.out.println("1 - Population d'une ville selectionnée");
		System.out.println("2 - Population d'un département selectionnée");
		System.out.println("3 - Population d'une région selectionnée");
		System.out.println("4 - Affichage des 10 régions les plus peuplées");
		System.out.println("5 - Affichage des 10 département les plus peuplées");
		System.out.println("6 - Affichage des 10 villes les plus peuplées d'un département");
		System.out.println("7 - Affichage des 10 villes les plus peuplées d'une région");
		System.out.println("8 - Affichage des 10 villes les plus peuplées de France");
		System.out.println("9 - Sortir");
		return scanner.nextLine();
	}

	/**
	 * M�thode abstraite servant de signature pour les classes filles de MenuService
	 * pour le traitement du choix de l'utilisateur
	 * 
	 * @param recensement
	 * @param scanner
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner);
}
