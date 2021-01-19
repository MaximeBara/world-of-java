package fr.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.factories.Combattant;

public class Groupe implements Combattant {

	List<Combattant> listeMonstres;
	
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
	    rndCombattant.attaquer(adversaire);
	}

	@Override
	public void defendre(int degats) {
		Random rand = new Random();
	    Combattant rndCombattant = listeMonstres.get(rand.nextInt(listeMonstres.size()));
	    rndCombattant.defendre(degats);
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDegats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPointDeVie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDegats(int degats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPointDeVie(int pointDeVie) {
		// TODO Auto-generated method stub
		
	}

}
