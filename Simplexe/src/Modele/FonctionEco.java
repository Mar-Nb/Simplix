package Modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FonctionEco {
	Map monomes;
	
	public FonctionEco() {
		monomes = new HashMap(); //changer en map
	}
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m); // transformer pour que ça s'adapte à la map
	}
	
	public String toString() {
		String chaineFinale = new String();
		chaineFinale += "z = ";
		for(Iterator i = monomes.keySet().iterator(); i.hasNext(); ) {
			String inconnue = (String) i.next();
			chaineFinale += " " + ((Monome) monomes.get(inconnue)).getCoefficient() + ((Monome) monomes.get(inconnue)).getInconnue();
			if(i.hasNext() && ((Monome) monomes.get(inconnue)).getCoefficient().getNumerateur() > ((Monome) monomes.get(inconnue)).getCoefficient().getDenominateur()) {
				chaineFinale+=" + ";
			}
		}
		
		return chaineFinale;
	}
	
	public void echanger(ContrainteExplicite ce, String inconnue) {
		Monome aEchanger = ((Monome)monomes.get(inconnue));
		Fraction coeff = aEchanger.getCoefficient(); //FRACTION
		monomes.remove(inconnue);
		
		for (Iterator i = ce.getMonomes().keySet().iterator(); i.hasNext();) {
			String clé = (String) i.next();
			Monome temp = new Monome(((Monome) ce.getMonomes().get(clé)).getCoefficient(), ((Monome) ce.getMonomes().get(clé)).getInconnue());
			temp.multiplier(coeff); //FRACTION
			if(monomes.get(clé)!=null) {
				((Monome)monomes.get(clé)).additionner(temp);
			}
			else {
				Monome ajout = new Monome(coeff.FMultiplication(((Monome)ce.getMonomes().get(clé)).getCoefficient()), clé);
				monomes.put(clé, ajout);
			}
			
		}
		
	}
}
