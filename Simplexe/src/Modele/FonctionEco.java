package Modele;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FonctionEco {
	List monomes;
	
	public FonctionEco() {
		monomes = new LinkedList(); //changer en map
	}
	public void ajouterMonome(Monome m) {
		monomes.add(m); // transformer pour que ça s'adapte à la map
	}
	
	public String toString() {
		String chaineFinale = new String();
		chaineFinale += "z = ";
		for(int i=0; i<monomes.size(); i++) {
			chaineFinale += ((Monome) monomes.get(i)).getCoefficient() + ((Monome) monomes.get(i)).getInconnue();
			if(i <= (monomes.size()-2) && ((Monome) monomes.get(i+1)).getCoefficient()> 0) {
				chaineFinale+="+";
			}
		}
		
		return chaineFinale;
	}
}
