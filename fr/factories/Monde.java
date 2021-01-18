package fr.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.entite.Monstre;
import fr.entite.Personnage;
import fr.interaction.Attaque;
import fr.interaction.BasicAttaque;
import fr.interaction.Classe;

public abstract class Monde {

	public static String[] debutNom = new String[] { "Chat", "Chien", "Chaton" };

	public static String[] finNom = new String[] { "méchant", "de feu", "de la mort" };

	/**
	 * Créer un personnage avec tous ses attributs. Demande à l'utilisateur d'entrer
	 * le nom du personnage.
	 * 
	 * @return Une instance de la classe Personnage correctement instanciée.
	 **/
	public static Personnage personnageFactory() {

		Scanner clavier = new Scanner(System.in);
		System.out.println("Saisir le nom du personnage :");
		Personnage res = new Personnage(clavier.nextLine());
		System.out.println("Saisir les points de vie du personnage :");
		res.setPointDeVie(clavier.nextInt());
		System.out.println("Saisir les dégâts du personnage :");
		res.setDegats(clavier.nextInt());
		res.setClasse(classeFactory());
		clavier.close();
		return res;
	}

	/**
	 * Créer une liste de différentes classes
	 * 
	 * @return Une classe parmi cette liste
	 */
	public static Classe classeFactory() {

		List<Classe> listClasses = new ArrayList<>();

		String[] sorts = { "colère", "feu stellaire", "éclat solaire", "éclat lunaire", "météores" };
		double[] chanceToucherSorts = { 25, 25, 10, 10, 100 };
		Attaque[] listeAttaques = new Attaque[5];

		for (int i = 0; i < sorts.length; i++) {
			listeAttaques[i] = new BasicAttaque(sorts[i], chanceToucherSorts[i]);
		}

		Classe druide = new Classe("Druide", listeAttaques);
		listClasses.add(druide);

		return listClasses.get(new Random().nextInt(listClasses.size()));

	}

	/**
	 * Créer un monstre avec tous ses attributs. Demande à l'utilisateur d'entrer le
	 * nom du monstre.
	 * 
	 * @return Une instance de la classe Monstre correctement instanciée.
	 **/
	public static Monstre monstreFactory() {
		String nomMonstre = debutNom[new Random().nextInt(debutNom.length)] + " "
				+ finNom[new Random().nextInt(finNom.length)];
		Monstre monMonstre = new Monstre(nomMonstre, new Random().nextInt(20), new Random().nextInt(20));
		return monMonstre;
	}

	/**
	 * Fait combattre les deux combattants passés en paramètres.
	 * 
	 * @param combattant1
	 * @param combattant2
	 */
	public static void combat(Combattant combattant1, Combattant combattant2) {
		boolean turn = true;

		System.out.println("Combat entre " + combattant1.toString() + " et " + combattant2.toString());

		while (combattant1.getPointDeVie() > 0 && combattant2.getPointDeVie() > 0) {
			if (turn) {
				combattant1.attaquer(combattant2);
			} else {
				combattant2.attaquer(combattant1);
			}
			turn = !turn;
		}
		if (combattant1.getPointDeVie() <= 0)
			System.out.println(combattant2.getNom() + " a vaincu " + combattant1.getNom());
		else
			System.out.println(combattant1.getNom() + " a vaincu " + combattant2.getNom());
	}

	/**
	 * Afficher les informations du monde
	 */
	public static void afficherInformations() {
		System.out.println(monstreFactory());
	}

}
