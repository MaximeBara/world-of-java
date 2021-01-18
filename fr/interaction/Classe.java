package fr.interaction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Classe {

	public String nom;
	public List<Attaque> attaques;
	
	public Classe(String nom, Attaque[] attaques) {
		this.nom = nom;
		this.attaques = Arrays.asList(attaques);
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the attaques
	 */
	public List<Attaque> getAttaques() {
		return attaques;
	}

	/**
	 * @param attaques the attaques to set
	 */
	public void setAttaques(List<Attaque> attaques) {
		this.attaques = attaques;
	}

	public Attaque getAttaque() {
		return this.attaques.get(new Random().nextInt(attaques.size()));
	}
	
}
