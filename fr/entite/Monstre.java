package fr.entite;

import fr.factories.Combattant;

public class Monstre extends Combattant{

	public Monstre(String nom) {
		super(nom);
	}
	
	public Monstre(String nom, int pointDeVie, int degat) {
		super(nom, pointDeVie, degat);
	}
	
	@Override
	public String toString() {
		return "Monstre [" + super.toString() + "]";
	}

}
