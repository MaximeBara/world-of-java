package fr.entite;

import fr.factories.ACombattant;
import fr.factories.Combattant;
import fr.interaction.Attaque;
import fr.interaction.Classe;


public class Personnage extends ACombattant {

	private Classe classe;

	public Personnage(String nom, int pointDeVie, int degats, Classe classe) {
		super(nom, pointDeVie, degats);
		this.classe = classe;
	}

	public Personnage(String nom) {
		super(nom);
	}
	
	@Override
	public void attaquer(Combattant adversaire) {
		Attaque currentAttaque = this.classe.getAttaque();
		int degatsCurrentAttaque = currentAttaque.lancerAttaque(this, adversaire);
		
		adversaire.defendre(degatsCurrentAttaque);
		System.out.println(super.getNom() + " a effectué une attaque(" + currentAttaque.getNom() + ") de " + degatsCurrentAttaque + " à " + adversaire.getNom());
	}
	
	/**
	 * @return the classe
	 */
	public Classe getClasse() {
		return classe;
	}

	/**
	 * @param classe the classe to set
	 */
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Personnage [" + this.classe.getNom() + " " + super.toString() + "]";
	}

}
