package fr.interaction;

import java.util.Random;

import fr.factories.Combattant;

public class BasicAttaque implements Attaque {

	private String nom;
	private String description;
	private double chanceToucher;

	public BasicAttaque(String nom, double chanceToucher, String description) {
		this.nom = nom;
		this.chanceToucher = chanceToucher;
		this.description = description;
	}

	public BasicAttaque(String nom, double chanceToucher) {
		this(nom, chanceToucher, "");
	}

	/**
	 * Permet à un combattant de lancer une attaque
	 * @return les dégats du lanceur si l'attaque a réussi, retourne 0 sinon 
	 */
	@Override
	public int LancerAttaque(Combattant lanceur, Combattant cible) {
		Random r = new Random();
		double random = 100 * r.nextDouble();
		if(random < this.chanceToucher)
			return lanceur.getDegats();
		System.out.println("Echec de l'attaque.");
		return 0;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getChanceToucher() {
		return this.chanceToucher;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setChanceToucher(double chanceToucher) {
		if(chanceToucher >= 0 && chanceToucher <= 100)
			this.chanceToucher = chanceToucher;
		else
			System.out.println("Chance de toucher doit être compris entre 0 et 100.");
	}

}
