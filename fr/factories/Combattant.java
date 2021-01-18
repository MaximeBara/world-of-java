package fr.factories;

public abstract class Combattant{
	
	private String nom;
	private int pointDeVie;
	private int degat;
	
	public Combattant(String nom, int pointDeVie, int degat) {
		this.pointDeVie = pointDeVie;
		this.degat = degat;
		this.nom = nom;
	}

	public Combattant(String nom) {
		this(nom, 0, 0);
	}
	
	@Override
	public String toString() {
		return "nom=" + nom + ", pointDeVie=" + pointDeVie + ", degat=" + degat + "";
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
	public int getDegat() {
		return degat;
	}

	/**
	 * @param degat the degat to set
	 */
	public void setDegat(int degat) {
		this.degat = degat;
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
