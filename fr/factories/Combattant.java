package fr.factories;

public interface Combattant {

	public void attaquer(Combattant adversaire);
    public void defendre(int degats);
    
    public String getNom();
    public int getDegats();
    public int getPointDeVie();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPointDeVie(int pointDeVie);
	
}
