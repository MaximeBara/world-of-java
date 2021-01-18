package fr.run;

import fr.factories.Monde;

public class Main {
	
	public static void main(String[] args) {
		Monde.combat(Monde.personnageFactory(), Monde.monstreFactory());
	}
	
}