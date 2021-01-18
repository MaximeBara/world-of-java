package fr.factories;

import java.util.Scanner;

import fr.entite.Personnage;

public abstract class Monde {
	
	/**
	* Créer un personnage avec tous ses attributs. 
	* Demande à l'utilisateur d'entrer le nom du personnage.
	* @return Une instance de la classe Personnage correctement instanciée.
	**/
	public static Personnage personnageFactory() {
		Scanner clavier = new Scanner(System.in); 
		System.out.println("Saisir le nom du personnage :");
		Personnage res = new Personnage(clavier.nextLine());
		clavier.close();
		return res;
	}
	
	/**
	 * Afficher les informations du monde
	 */
	public static void afficherInformations() {
		System.out.println(personnageFactory());
	}
	
}
