package fr.run;

import java.util.Scanner;

import fr.entite.Personnage;

public class Main {
	
	/**
	* Cr�er un personnage avec tous ses attributs. 
	* Demande � l'utilisateur d'entrer le nom du personnage.
	* @return Une instance de la classe Personnage correctement instanci�.
	**/
	public static Personnage personnageFactory() {
		Scanner clavier = new Scanner(System.in); 
		System.out.println("Saisir le nom du personnage :");
		Personnage res = new Personnage(clavier.nextLine());
		clavier.close();
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(personnageFactory().toString());
	}
	
}
