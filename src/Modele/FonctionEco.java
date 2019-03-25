package Modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FonctionEco implements Serializable{
	Map monomes;
	
	/**
	 * Construit un objet FonctionEco contenant une HashMap
	 */
	public FonctionEco() {
		monomes = new HashMap(); //changer en map
	}
	
	/**
	 * Construit un objet FonctionEco � partir d'un autre objet FonctionEco donn� en param�tre et copie son champs Map monomes
	 * dans le champs Map monomes du nouvel objet � construire
	 * @param FonctionEco fonctionEco
	 */
	public FonctionEco(FonctionEco fonctionEco) {
		monomes = new HashMap();
		for (Iterator i = fonctionEco.monomes.keySet().iterator(); i.hasNext(); ) {
			String cl� = (String) i.next();
			this.ajouterMonome(new Monome((Monome)fonctionEco.monomes.get(cl�)));;
		}
	}
	/**
	 * Ajoute un Monome � la Map de monome de this
	 * @param Monome m
	 */
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m); // transformer pour que �a s'adapte � la map
	}
	
	/**
	 * Renvoie une chaine de caract�re correspondant � la fonction �conomique
	 *@return String chaineFinale
	 */
	public String toString() {
		String chaineFinale = new String();
		chaineFinale +=  "z = ";
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String cl� = (String) i.next();
			chaineFinale+=((Monome) monomes.get(cl�)).toString();
		}
		
		while(i.hasNext()) {
			String cl� = (String) i.next();
			if(((Monome)monomes.get(cl�)).getCoefficient().getNumerateur()>0) {
				chaineFinale+=" +";
			}
			chaineFinale += " " + ((Monome) monomes.get(cl�)).toString();
		}
		return chaineFinale;

	}
	/**
	 * Echange la variable "inconnue" de la fonction �conomique avec une contrainte explicite, puis simplifie l'expression en additionnant
	 * les monomes de m�me inconnue.
	 * @param ContrainteExplicite ce
	 * @param String inconnue
	 */
	public void echanger(ContrainteExplicite ce, String inconnue) {
		Monome aEchanger = ((Monome)monomes.get(inconnue));
		Fraction coeff = aEchanger.getCoefficient(); //FRACTION
		monomes.remove(inconnue);
		
		for (Iterator i = ce.getMonomes().keySet().iterator(); i.hasNext();) {
			String cl� = (String) i.next();
			Monome temp = new Monome(((Monome) ce.getMonomes().get(cl�)).getCoefficient().FMultiplication(coeff), ((Monome) ce.getMonomes().get(cl�)).getInconnue());
			if(monomes.get(cl�)!=null) {
				((Monome)monomes.get(cl�)).additionner(temp);
			}
			else {
				Monome ajout = new Monome(coeff.FMultiplication(((Monome)ce.getMonomes().get(cl�)).getCoefficient()), cl�);
				monomes.put(cl�, ajout);
			}
			
		}
		
	}
	/**
	 * Renvoie le Monome de la fonction �conomique ayant la valeur de coefficient maximale 
	 * @return String res
	 */
	public String monomeCoeffMax() {
		Fraction max = new Fraction(0);
		String res=new String();
		
		for (Iterator i = monomes.keySet().iterator(); i.hasNext();) {
			String cl� = (String) i.next();
			if(((Monome)monomes.get(cl�)).getCoefficient().FSup(max) && !((Monome)monomes.get(cl�)).getInconnue().equals(" ")) {
				max=new Fraction(((Monome)monomes.get(cl�)).getCoefficient());
				res=((Monome)monomes.get(cl�)).getInconnue();
			}
			
		}
		return res;
		
	}
	/**
	 * Renvoie le champs monomes (Map) de this
	 * @return Map monomes
	 */
	public Map getMonomes() {
		return monomes;
	}
}
