package fr.factories;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import fr.entite.Monstre;
import fr.entite.Personnage;
import fr.interaction.Attaque;
import fr.interaction.BasicAttaque;
import fr.interaction.Classe;

public abstract class Monde {

	private static String[] debutNom = new String[] { "Chat", "Chien", "Chaton" };
	private static String[] finNom = new String[] { "m�chant", "de feu", "de la mort" };

	private static HashMap<String, Classe> classes;

	/**
	 * Cr�er un personnage avec tous ses attributs. Demande � l'utilisateur d'entrer
	 * le nom du personnage.
	 * 
	 * @return Une instance de la classe Personnage correctement instanci�e.
	 **/
	public static Personnage personnageFactory() {

		Scanner clavier = new Scanner(System.in);
		System.out.println("Saisir le nom du personnage :");
		Personnage res = new Personnage(clavier.nextLine());
		System.out.println("Saisir les points de vie du personnage :");
		res.setPointDeVie(clavier.nextInt());
		System.out.println("Saisir les d�g�ts du personnage :");
		res.setDegats(clavier.nextInt());
		classeFactory();
		Classe classe;
		do {
			System.out.println("Saisir la classe du personnage :");
			String nextLine = clavier.next();
			classe = getClasse(nextLine);
		} while (classe == null);
		res.setClasse(classe);
		clavier.close();
		return res;

	}

	/**
	 * Retourne une classe de la HashMap classes suivant le String nom pass� en
	 * param�tre Si la classe n'est pas trouv�e, retourne null et affiche une
	 * erreur.
	 * 
	 * @param nom
	 * @return la classe ayant comme nom nom.
	 */
	public static Classe getClasse(String nom) {
		if (classes.get(nom) != null)
			return classes.get(nom);
		System.out.println("La classe demand�e n'existe pas.");
		return null;
	}

	/**
	 * Cr�er une liste de diff�rentes classes
	 * 
	 * @return Une classe parmi cette liste
	 */
	public static void classeFactory() {

		classes = new HashMap<>();

		String[] sorts = { "col�re", "feu stellaire", "�clat solaire", "�clat lunaire", "m�t�ores" };
		double[] chanceToucherSorts = { 25, 25, 10, 10, 100 };
		Attaque[] listeAttaques = new Attaque[5];

		for (int i = 0; i < sorts.length; i++) {
			listeAttaques[i] = new BasicAttaque(sorts[i], chanceToucherSorts[i]);
		}

		Classe druide = new Classe("Druide", listeAttaques);
		classes.put("Druide", druide);

	}

	/**
	 * Cr�er un monstre avec tous ses attributs. Demande � l'utilisateur d'entrer le
	 * nom du monstre.
	 * 
	 * @return Une instance de la classe Monstre correctement instanci�e.
	 **/
	public static Monstre monstreFactory() {
		String nomMonstre = debutNom[new Random().nextInt(debutNom.length)] + " "
				+ finNom[new Random().nextInt(finNom.length)];
		Monstre monMonstre = new Monstre(nomMonstre, new Random().nextInt(20), new Random().nextInt(20));
		return monMonstre;
	}

	/**
	 * Fait combattre les deux combattants pass�s en param�tres.
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
