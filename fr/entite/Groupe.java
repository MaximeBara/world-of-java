package fr.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.factories.Combattant;

public class Groupe implements Combattant {

	private List<Combattant> listeMonstres;
	private String nomGroupe = "Groupe de monstres";
	private int degats;
	private int pointDeVie;
	
	public Groupe(int nbMonstres) {
		listeMonstres = new ArrayList<>(nbMonstres);
	}
	
	public void addCombattant(Combattant combattant) {
		this.listeMonstres.add(combattant);
	}
	
	public boolean estMort() {
		for(Combattant combattant : listeMonstres)
			if(combattant.getPointDeVie() > 0)
				return false;
		return true;
	}

	@Override
	public void attaquer(Combattant adversaire) {
		Random rand = new Random();
	    Combattant rndCombattant = listeMonstres.get(rand.nextInt(listeMonstres.size()));
	    this.setDegats(rndCombattant.getDegats());
	    rndCombattant.attaquer(adversaire);
	}

	@Override
	public void defendre(int degats) {
		Random rand = new Random();
	    Combattant rndCombattant = listeMonstres.get(rand.nextInt(listeMonstres.size()));
	    this.setPointDeVie(rndCombattant.getPointDeVie());
	    rndCombattant.defendre(degats);
	}

	@Override
	public String getNom() {
		return nomGroupe;
	}

	@Override
	public int getDegats() {
		return this.degats;
	}

	@Override
	public int getPointDeVie() {
		return this.pointDeVie;
	}

	@Override
	public void setNom(String nom) {
		this.nomGroupe = nom;
	}

	@Override
	public void setDegats(int degats) {
		this.degats = degats;
	}

	@Override
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	@Override
	public String toString() {
		return "Groupe [listeMonstres=" + listeMonstres + ", nomGroupe=" + nomGroupe + "]";
	}

}
