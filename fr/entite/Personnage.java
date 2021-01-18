package fr.entite;

import fr.factories.ACombattant;
import fr.factories.Combattant;
import fr.interaction.Classe;

public class Personnage extends ACombattant{
	
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
		int currentAttaque = this.classe.getAttaque().LancerAttaque(this, adversaire);
		adversaire.defendre(currentAttaque);
		System.out.println(super.getNom() + " a effectué une attaque de " + currentAttaque + " à " + adversaire.getNom());
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
