package fr.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import fr.entite.Groupe;
import fr.entite.Monstre;
import fr.entite.Personnage;
import fr.interaction.Attaque;
import fr.interaction.BasicAttaque;
import fr.interaction.Classe;

public abstract class Monde {
	
	private static Scanner clavier = new Scanner(System.in);

	private static String[] debutNom = new String[] { "Chat", "Chien", "Chaton" };
	private static String[] finNom = new String[] { "méchant", "de feu", "de la mort" };

	private static HashMap<String, Classe> classes;

	/**
	 * Créer un personnage avec tous ses attributs. Demande à l'utilisateur d'entrer
	 * le nom du personnage.
	 * 
	 * @return Une instance de la classe Personnage correctement instanciée.
	 **/
	public static Personnage personnageFactory() {

		System.out.println("Saisir le nom du personnage :");
		Personnage res = new Personnage(clavier.next());
		System.out.println("Saisir les points de vie du personnage :");
		res.setPointDeVie(clavier.nextInt());
		System.out.println("Saisir les dégâts du personnage :");
		res.setDegats(clavier.nextInt());
		Classe classe;
		do {
			System.out.println("Saisir la classe du personnage :");
			String next = clavier.next();
			classe = getClasse(next);
		} while (classe == null);
		res.setClasse(classe);
		clavier.close();
		return res;

	}

	/**
	 * Retourne une classe de la HashMap classes suivant le String nom passé en
	 * paramètre Si la classe n'est pas trouvée, retourne null et affiche une
	 * erreur.
	 * 
	 * @param nom
	 * @return la classe ayant comme nom nom.
	 */
	public static Classe getClasse(String nom) {
		if (classes.get(nom) != null)
			return classes.get(nom);
		System.out.println("La classe demandée n'existe pas.");
		return null;
	}

	/**
	 * Créer une liste de différentes classes
	 * 
	 * @return Une classe parmi cette liste
	 */
	public static void classeFactory() {

		classes = new HashMap<>();

		String[] sorts = { "colère", "feu stellaire", "éclat solaire", "éclat lunaire", "météores" };
		double[] chanceToucherSorts = { 25, 25, 10, 10, 100 };
		Attaque[] listeAttaques = new Attaque[5];

		for (int i = 0; i < sorts.length; i++) {
			listeAttaques[i] = new BasicAttaque(sorts[i], chanceToucherSorts[i]);
		}

		Classe druide = new Classe("Druide", listeAttaques);
		classes.put("Druide", druide);

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
	 * Créer un groupe de Monstres
	 * 
	 * @param nombreMonstre taille du groupe de Monstres
	 * @return le groupe de Monstres
	 */
	public static Groupe creationGroupeMonstres(int nombreMonstres) {
		Groupe grp = new Groupe(nombreMonstres);
		for (int i = 0; i < nombreMonstres; i++)
			grp.addCombattant(monstreFactory());
		return grp;
	}

	/**
	 * Créer un groupe de Personnages
	 * 
	 * @param nombreMonstre taille du groupe de Personnages
	 * @return le groupe de Personnages
	 */
	public static Groupe creationGroupePersonnages(int nombrePersonnages) {
		Groupe grp = new Groupe(nombrePersonnages);
		for (int i = 0; i < nombrePersonnages; i++)
			grp.addCombattant(personnageFactory());
		return grp;
	}

	/**
	 * Fait combattre les deux combattants passés en paramètres.
	 * 
	 * @param combattant1
	 * @param combattant2
	 */
	public static void combat(Combattant combattant1, Combattant combattant2) {
		int tour = 1;
		boolean turn = true;

		System.out.println("Combat entre " + combattant1.toString() + " et " + combattant2.toString());

		while (combattant1.getPointDeVie() > 0 && combattant2.getPointDeVie() > 0) {
			System.out.println("------- TOUR " + tour + " -------");
			if (turn) {
				combattant1.attaquer(combattant2);
				System.out.println("Il reste " + combattant2.getPointDeVie() + " points de vie à " + combattant2.getNom());
			} else {
				combattant2.attaquer(combattant1);
				System.out.println("Il reste " + combattant1.getPointDeVie() + " points de vie à " + combattant1.getNom());
			}
			turn = !turn;
			tour++;
		}
		if (combattant1.getPointDeVie() <= 0)
			System.out.println(combattant2.getNom() + " a vaincu " + combattant1.getNom());
		else
			System.out.println(combattant1.getNom() + " a vaincu " + combattant2.getNom());
	}
	
	public static void genese() {
		String choix;
		classeFactory();
		
		System.out.println("---***--- Bonjour ---***---");
		System.out.println("Choisir une option:");
		System.out.println("1: Lancer un combat 1v1");
		System.out.println("2: Lancer un combat de groupe");
		System.out.println("3: One vs World Hardcore Edition");
		System.out.println("4: Informations");
		System.out.println("----------------------------");
		System.out.println(">>>");
		
		choix = clavier.nextLine();
		
		if(choix.equals("1"))
			combat1v1();
		else if(choix.equals("2"))
			combatGroupe();
		else if(choix.equals("3"))
			combatSolo();
		else if(choix.equals("4"))
			afficherInformations();
		else 
			System.exit(0);
	}
	
	public static void combat1v1() {
		combat(personnageFactory(), monstreFactory());
	}
	
	public static void combatGroupe() {
		System.out.println("Quel est la taille du groupe du héro ?");
		Groupe personnages = creationGroupePersonnages(clavier.nextInt());
		
		System.out.println("Quel est la taille du groupe des monstres ?");
		Groupe monstres = creationGroupeMonstres(clavier.nextInt());
		
		combat(personnages, monstres);
	}
	
	public static void combatSolo() {
		System.out.println("Quel est la taille du groupe des monstres ?");
		Groupe monstres = creationGroupeMonstres(clavier.nextInt());
		
		combat(personnageFactory(), monstres);
	}
	
	public static void afficherInformations() {
		System.out.println("Les classes disponibles sont: ");
		for(Map.Entry<String, Classe> classe : classes.entrySet()) {
			System.out.println("La classe : " + classe.getKey());
			System.out.println("Ses attaques : ");
			for(Attaque attaque : classe.getValue().attaques) {
				System.out.println(attaque.getNom());
			}
		}
			
	}

}
