package fr.factories;

import java.util.Random;
import java.util.Scanner;

import fr.entite.Monstre;
import fr.entite.Personnage;

public abstract class Monde {

	public static String[] debutNom = new String[] { "chat", "chien", "chaton" };

	public static String[] finNom = new String[] { "m�chant", "de feu", "de la mort" };

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
		res.setDegat(clavier.nextInt());
		clavier.close();
		return res;
	}

	/**
	 * Cr�er un monstre avec tous ses attributs. Demande � l'utilisateur d'entrer le
	 * nom du monstre.
	 * 
	 * @return Une instance de la classe Monstre correctement instanci�e.
	 **/
	public static Monstre monstreFactory() {
		String nomMonstre = debutNom[new Random().nextInt(debutNom.length)] + " " + finNom[new Random().nextInt(finNom.length)];
		Monstre monMonstre = new Monstre(nomMonstre, new Random().nextInt(20), new Random().nextInt(20));
		return monMonstre;
	}
	
	public static void combat(Personnage personnage, Monstre monstre) {
		boolean turn = true;
		
		System.out.println("Combat entre " + personnage.toString() + " et " + monstre.toString());
		
		while(personnage.getPointDeVie() > 0 && monstre.getPointDeVie() > 0) {
		    if (turn) {
		        personnage.setPointDeVie(personnage.getPointDeVie() - monstre.getDegat());
		    }
		    else {
		    	monstre.setPointDeVie(monstre.getPointDeVie() - personnage.getDegat());
		    }
		    turn = !turn;
		}
		if(personnage.getPointDeVie() <= 0)
			System.out.println(monstre.getNom() + " a vaincu " + personnage.getNom());
		else
			System.out.println(personnage.getNom() + " a vaincu " + monstre.getNom());
	}

	/**
	 * Afficher les informations du monde
	 */
	public static void afficherInformations() {
		System.out.println(monstreFactory());
	}

}
