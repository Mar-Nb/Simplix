package Modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>FonctionEco</i></h1>
 * <h2><code>public FonctionEco</code></h2>
 * <p>Cette classe imite le comportement mathématique d'une fonction économique de simplexe.</p>
 *
 * @see Simplexe
 */
public class FonctionEco implements Serializable{
	Map monomes;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
   	 * <h1><i>FonctionEco</i></h1>
 	 * <h2><code>public FonctionEco()</code></h2>
	 * <p>Construit un objet <code>FonctionEco</code> contenant une <code>HashMap</code>.</p>
	 */
	public FonctionEco() {
		monomes = new HashMap(); //changer en map
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
  	 * <h1><i>FonctionEco</i></h1>
 	 * <h2><code>public FonctionEco(FonctionEco fonctionEco)</code></h2>
	 * <p>Construit un objet <code>FonctionEco</code> à partir d'un autre objet <code>FonctionEco</code> donné en paramètre et copie son champ <code>Map</code> <i>monomes</i>
	 * dans le champ <code>Map</code> <i>monomes</i> du nouvel objet à construire.</p>
	 * @param fonctionEco : (FonctionEco)
	 */
	public FonctionEco(FonctionEco fonctionEco) {
		monomes = new HashMap();
		for (Iterator i = fonctionEco.monomes.keySet().iterator(); i.hasNext(); ) {
			String cle = (String) i.next();
			this.ajouterMonome(new Monome((Monome)fonctionEco.monomes.get(cle)));;
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>ajouterMonome</i></h1>
 	 * <h2><code>public void ajouterMonome(Monome m)</code></h2>
	 * <p>Ajoute un <code>Monome</code> à la <code>Map</code> de <i>monome</i> de <i><b>this</b></i>.</p>
	 * @param m : (Monome)
	 * 
	 * @see Monome
	 */
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m); // transformer pour que �a s'adapte � la map
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>toString</i></h1>
 	 * <h2><code>public String toString()</code></h2>
	 * <p>Renvoie une chaine de caractère correspondant à la fonction économique.</p>
	 * @return chaineFinale : (String)
	 */
	public String toString() {
		String chaineFinale = new String();
		chaineFinale +=  "z = ";
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String cle = (String) i.next();
			chaineFinale+=((Monome) monomes.get(cle)).toString();
		}
		
		while(i.hasNext()) {
			String cle = (String) i.next();
			if(((Monome)monomes.get(cle)).getCoefficient().getNumerateur()>0) {
				chaineFinale+=" +";
			}
			chaineFinale += " " + ((Monome) monomes.get(cle)).toString();
		}
		return chaineFinale;

	}
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>echanger</i></h1>
 	 * <h2><code>public void echanger(ContrainteExplicite ce, String inconnue)</code></h2>
	 * <p>Echange la variable "inconnue" de la fonction économique avec une contrainte explicite, puis simplifie l'expression en additionnant
	 * les monomes de même inconnue.</p>
	 * @param ce : (ContrainteExplicite)
	 * @param inconnue : (String)
	 * 
	 * @see ContrainteExplicite
	 * @see Monome#getCoefficient()
	 * @see Fraction#FMultiplication(Fraction)
	 */
	public void echanger(ContrainteExplicite ce, String inconnue) {
		Monome aEchanger = ((Monome)monomes.get(inconnue));
		Fraction coeff = aEchanger.getCoefficient(); //FRACTION
		monomes.remove(inconnue);
		
		for (Iterator i = ce.getMonomes().keySet().iterator(); i.hasNext();) {
			String cle = (String) i.next();
			Monome temp = new Monome(((Monome) ce.getMonomes().get(cle)).getCoefficient().FMultiplication(coeff), ((Monome) ce.getMonomes().get(cle)).getInconnue());
			if(monomes.get(cle)!=null) {
				((Monome)monomes.get(cle)).additionner(temp);
			}
			else {
				Monome ajout = new Monome(coeff.FMultiplication(((Monome)ce.getMonomes().get(cle)).getCoefficient()), cle);
				monomes.put(cle, ajout);
			}
			
		}
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>monomeCoeffMax</i></h1>
 	 * <h2><code>public String monomeCoeffMax()</code></h2>
	 * <p>Renvoie le <code>Monome</code> de la fonction économique ayant la valeur de coefficient maximale.</p>
	 * @return res : (String)
	 * 
	 * @see Monome#getCoefficient()
	 */
	public String monomeCoeffMax() {
		Fraction max = new Fraction(0);
		String res=new String();
		
		for (Iterator i = monomes.keySet().iterator(); i.hasNext();) {
			String cle = (String) i.next();
			if(((Monome)monomes.get(cle)).getCoefficient().FSup(max) && !((Monome)monomes.get(cle)).getInconnue().equals(" ")) {
				max=new Fraction(((Monome)monomes.get(cle)).getCoefficient());
				res=((Monome)monomes.get(cle)).getInconnue();
			}
			
		}
		return res;
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>getMonomes</i></h1>
 	 * <h2><code>public Map getMonomes()</code></h2>
	 * <p>Renvoie le champ <i>monomes</i> de <i><b>this</b></i>.</p>
	 * @return monomes : (Map)
	 * 
	 * @see Monome
	 */
	public Map getMonomes() {
		return monomes;
	}
}
