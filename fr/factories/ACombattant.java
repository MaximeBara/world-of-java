package fr.factories;

public abstract class ACombattant implements Combattant{
	
	private String nom;
	private int pointDeVie;
	private int degats;
	
	public ACombattant(String nom, int pointDeVie, int degats) {
		this.pointDeVie = pointDeVie;
		this.degats = degats;
		this.nom = nom;
	}

	public ACombattant(String nom) {
		this(nom, 0, 0);
	}
	
	public void attaquer(Combattant adversaire) {
		adversaire.defendre(this.degats);
		System.out.println(this.nom + " a effectué une attaque de " + this.degats + " à " + adversaire.getNom());
	}
	
	public void defendre(int degats) {
		this.pointDeVie -= degats;
	}
	
	@Override
	public String toString() {
		return "nom=" + nom + ", pointDeVie=" + pointDeVie + ", degats=" + degats + "";
	}

	/**
	 * @return the pointDeVie
	 */
	public int getPointDeVie() {
		return pointDeVie;
	}

	/**
	 * @param pointDeVie the pointDeVie to set
	 */
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	/**
	 * @return the degat
	 */
	public int getDegats() {
		return degats;
	}

	/**
	 * @param degat the degat to set
	 */
	public void setDegats(int degats) {
		this.degats = degats;
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
	
}
