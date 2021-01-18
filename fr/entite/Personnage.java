package fr.entite;

import fr.factories.Combattant;

public class Personnage extends Combattant{
	
	public Personnage(String nom, int pointDeVie, int degat) {
		super(nom, pointDeVie, degat);
	}

	public Personnage(String nom) {
		super(nom);
	}

	@Override
	public String toString() {
		return "Personnage [" + super.toString() + "]";
	}
	
}
