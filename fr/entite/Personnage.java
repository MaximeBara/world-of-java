package fr.entite;

import fr.factories.ACombattant;

public class Personnage extends ACombattant{
	
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
