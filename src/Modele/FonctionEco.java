package Modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>FonctionEco</i></h1>
 * <h2><code>public FonctionEco implements <span class='name'>Serializable</span></code></h2>
 * <p>Cette classe imite le comportement mathématique d'une fonction économique de simplexe.</p>
 *
 * @see Simplexe
 */
@SuppressWarnings("serial")
public class FonctionEco implements Serializable{
	
	Map monomes;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
   	 * <h1><i>Contructeur</i></h1>
 	 * <h2><code>public FonctionEco()</code></h2>
	 * <p>Construit un objet <code class='name'>FonctionEco</code> contenant une <code class='name'>HashMap</code> de monomes.</p>
	 */
	public FonctionEco() {
		monomes = new HashMap(); // changer en HashMap
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
  	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public FonctionEco(<span class='name'>FonctionEco</span> fonctionEco)</code></h2>
	 * <p>Construit un objet <code class='name'>FonctionEco</code> à partir d'un autre objet <code class='name'>FonctionEco</code> donné en paramètre 
	 * et copie son champ <code class='name'>Map</code> <i>monomes</i> dans le champ <code class='name'>Map</code> <i>monomes</i> du nouvel objet à construire.</p>
	 * 
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>ajouterMonome</i></h1>
 	 * <h2><code>public void ajouterMonome(<span class='name'>Monome</span> m)</code></h2>
	 * <p>Ajoute un <code class='name'>Monome</code> à la <code class='name'>Map</code> de <i>monome</i> de <i><b>this</b></i>.</p>
	 * 
	 * @param m : (Monome)
	 * 
	 * @see Monome
	 */
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m); // transformer pour que �a s'adapte � la map
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>toString</i></h1>
 	 * <h2><code>public String toString()</code></h2>
	 * <p>Renvoie une chaine de caractère correspondant à la fonction économique.</p>
	 * 
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>echanger</i></h1>
 	 * <h2><code>public void echanger(<span class='name'>ContrainteExplicite</span> ce, <span class='name'>String</span> inconnue)</code></h2>
	 * <p>Echange la variable "inconnue" de la fonction économique avec une contrainte explicite, puis simplifie l'expression en additionnant
	 * les monomes de même inconnue.</p>
	 * 
	 * @param ce : (ContrainteExplicite)
	 * @param inconnue : (String)
	 * 
	 * @see ContrainteExplicite
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>monomeCoeffMax</i></h1>
 	 * <h2><code>public String monomeCoeffMax()</code></h2>
	 * <p>Renvoie le <code class='name'>Monome</code> de la fonction économique ayant la valeur de coefficient maximale.</p>
	 * 
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
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
