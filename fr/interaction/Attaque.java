package fr.interaction;

import fr.factories.Combattant;

public interface Attaque {

	public int LancerAttaque(Combattant lanceur, Combattant cible);

	public String getNom();

	public String getDescription();

	public double getChanceToucher();

	public void setNom(String nom);

	public void setDescription(String description);

	public void setChanceToucher(double chanceToucher);

}
