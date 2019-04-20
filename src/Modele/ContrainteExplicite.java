package Modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>ContrainteExplicite</i></h1>
 * <h2><code>public class ContrainteExplicite implements Serializable</code></h2>
 * <p> Cette classe adopte le comportement mathématique d'une contrainte explicite.</p>
 *
 */
@SuppressWarnings("serial")
public class ContrainteExplicite implements Serializable{
	String nom;
	Map monomes;
	Fraction inferieurA;
	int nombreInconnues;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public ContrainteExplicite(Fraction limite, String nom)</code></h2>
	 * <p>Construit un objet <code>ContrainteExplicite</code> et remplit les champs <code>Fraction</code> <i>inferieurA</i> et <code>String</code> <i>nom</i> avec les variables
	 * données en paramètre ( les autres champs sont une <code>HashMap</code> vide et un nombre d'inconnues initialisé à 0)</p>
	 * @param limite : (Fraction)
	 * @param nom : (String)
	 * 
	 * @see Fraction
	 */
	public ContrainteExplicite(Fraction limite, String nom){
		this.monomes = new HashMap();
		inferieurA=limite;
		nombreInconnues=0;
		this.nom=nom;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public ContrainteExplicite(ContrainteExplicite ce)</code></h2>
	 * <p>Construit un objet <code>ContrainteExplicite</code> à partir d'un autre objet <code>ContrainteExplicite</code> donné en paramètre et copie 
	 * tous les champs de la <code>ContrainteExplicite</code> en paramètre dans le nouvel objet qui sera construit.</p>
	 * @param ce : (ContrainteExplicite)
	 */
	public ContrainteExplicite(ContrainteExplicite ce) {
		// TODO Auto-generated constructor stub
		this.nom = ce.nom;
		this.inferieurA = new Fraction(ce.inferieurA);
		this.nombreInconnues = ce.nombreInconnues;
		monomes = new HashMap();
		for (Iterator i = ce.monomes.keySet().iterator(); i.hasNext(); ) {
			String cle = (String) i.next();
			this.ajouterMonome(new Monome((Monome)ce.monomes.get(cle)));;
		}
	}
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>ajouterMonome</i></h1>
	 * <h2><code>public void ajouterMonome(Monome m)</code></h2>
	 * <p>Permet l'ajout d'un monome dans le champ <i>monome</i>, qui est un champ de type <code>Map</code>.</p>
	 * @param m : (Monome) Monome à ajouter
	 * 
	 * @see Monome
	 */
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>passageDico1</i></h1>
	 * <h2><code>public void passageDico1()</code></h2>
	 * <p>Permet de former le dictionnaire n°1 : on rentre les limites dans chaque contrainte.</p>
	 */
	public void passageDico1() {
		for (Iterator i = monomes.keySet().iterator(); i.hasNext(); ) {
			String cle = (String) i.next();
			((Monome)monomes.get(cle)).setCoefficient((((Monome)monomes.get(cle)).getCoefficient().FMultiplication(new Fraction(-1,1))));
		}
		Monome m = new Monome(inferieurA, " ");
		this.ajouterMonome(m);
	}
	
	/* toString pour le dictionnaire 0 (sans les "=", seulement les contraintes avec les "<=")*/
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>toStringDico1</i></h1>
	 * <h2><code>public String toStringDico1</code></h2>
	 * <p>Affiche le premier dictionnaire, qui correspond au dictionnaire où chaque contrainte doit être inférieure à une limite.</p>
	 * @return chaineFinale : (String) 
	 */
	
	public String toStringDico1() {
		String chaineFinale = new String();
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String cle = (String) i.next();
			chaineFinale+=((Monome) monomes.get(cle)).toString();
		}
		
		while(i.hasNext()) {
			String cle = (String) i.next();
			if(((Monome)monomes.get(cle)).getCoefficient().getNumerateur()>0) {
				chaineFinale+=" + ";
			}
			chaineFinale += ((Monome) monomes.get(cle)).toString();
		}
		chaineFinale+= " <= "+ this.inferieurA;
		return chaineFinale;
	}
	
	/* toString pour les autres dictionnaires (avec les "=")*/
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Permet l'affichage des autres dictionnaires (autre que le dictionnaire n°1).</p>
	 * @return chaineFinale: (String) Renvoie une chaine de caractères correspondant à un dictionnaire ( autre que le dictionnaire n°1)
	 */
	public String toString() {
		String chaineFinale = new String();
		chaineFinale +=  this.nom + " = ";
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
	
	/*Parcourt la HashMap de this. Additionne chaque Monome à celui ayant la même clé dans la HashMap de la 
	 * Contrainte explicite en paramètre
	 */
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>additionnerLigne</i></h1>
	 * <h2><code>public void additionnerLigne(ContrainteExplicite ce)</code></h2>
	 * <p>Parcourt la <code>HashMap</code> de <i><b>this</b></i> et additionne chaque <code>Monome</code> à celui ayant la même clé dans la <code>HashMap</code>
	 * de ContrainteExplicite donnée en paramètre.</p>
	 * @param ce: (ContrainteExplicite) Renvoie une contrainte explicite
	 */
	public void additionnerLigne(ContrainteExplicite ce) {
		Iterator i = monomes.keySet().iterator(); 
		while(i.hasNext()) {
			String cle = (String) i.next();
			((Monome) monomes.get(cle)).additionner(((Monome)ce.getMonomes().get(cle)));
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>rentrerBase</i></h1>
	 * <h2><code>public void rentrerBase(String inconnue)</code></h2>
	 * <p>Permet de trouver la variable inconnue à sortir de la contrainte. Puis sort cette variable de la contrainte. Puis 
	 * ajoute la variable de la contrainte dans la contrainte.<br><hr>Ex : (x1 = 4 - 2x3 - 8x2 -> rentrerBase(x3) -> x3 = 2 - 4x2 - (1/2) x1 ).</p>
	 * @param inconnue : (String) L'inconnue ("x1" par exemple) à sortir de la base
	 * 
	 */
	public void rentrerBase(String inconnue) {
		Iterator i = monomes.keySet().iterator();
		while(i.hasNext()) { // On parcours notre contrainte
			String cle = (String) i.next();
			if (cle.equals(inconnue)) { // on tombe sur le bon Xi
				Fraction coeff = ((Monome)monomes.get(cle)).getCoefficient(); // on récupère le coefficient du monome à switch
				//String tmp = this.nom;
				Monome switched = new Monome(new Fraction(-1,1),this.nom); // on met -1 car on le switch donc son coeff devient négatif. Il va ensuite être divisé par le coeff de m
				this.nom = ((Monome)monomes.get(cle)).getInconnue(); // On remplace le nom de la contrainte par l'inconnue de m
				monomes.remove(cle);
				monomes.put(switched.getInconnue(),switched);
				division(coeff); //ADD FRACTION
				break;
			}
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>echanger</i></h1>
	 * <h2><code>public void echanger(ContrainteExplicite ce, String inconnue)</code></h2>
	 * <p>Permet de remplacer une inconnue par une contrainte explicite, puis d'additionner les monomes de même inconnue.</p>
	 * @param ce : (ContrainteExplicite) Une autre contrainte explicite
	 * @param inconnue : (String) L'inconnue à échanger avec <b>ce</b>
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
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>majorant</i></h1>
	 * <h2><code>public double majorant</code></h2>
	 * <p>Calcul le majorant à partir de la constante et du coefficient de l'inconnue fourni en paramètre.</p>
	 * @param inconnue : (String)
	 * @return (double) Valeur absolue de "<code>constante / coeffInconnue</code>".
	 * 
	 * @see Math#abs(double)
	 */
	public double majorant(String inconnue) {
		double constante = ((Monome)monomes.get(" ")).getCoefficient().FMath();
		double coeffInconnue = ((Monome)monomes.get(inconnue)).getCoefficient().FMath();
		return Math.abs(constante/coeffInconnue);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>division</i></h1>
	 * <h2><code>public void division(Fraction coeff)</code></h2>
	 * <p>Divise tous les monomes de la contrainte <i><b>this</b></i> par <i>coeff</i>.</p>
	 * @param coeff : (Fraction)
	 * 
	 * @see Fraction
	 */
	public void division(Fraction coeff) { //ADD FRACTION
		Iterator i = monomes.keySet().iterator();
		coeff.setNumerateur(-coeff.getNumerateur());
		while(i.hasNext()) {
			String cle = (String) i.next();
			((Monome) monomes.get(cle)).setCoefficient(((Monome) monomes.get(cle)).getCoefficient().FDivision(coeff)); 
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>getNom</i></h1>
	 * <h2><code>public String getNom</code></h2>
	 * <p>Renvoie le champ <i>nom</i> de <i><b>this</b></i>.</p>
	 * @return nom : (String)
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>setNom</i></h1>
	 * <h2><code>public void setNom(String nom)</code></h2>
	 * <p>Définie le champ <i>nom</i> de <i><b>this</b></i> avec la String <i>nom</i> fournit en paramètre</p>
	 * @param nom : (String)
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>getMonomes</i></h1>
	 * <h2><code>public Map getMonomes()</code></h2>
	 * <p>Renvoie le champ <i>monomes</i> de <i><b>this</b></i>, qui est une <code>Map</code> de <code>Monome</code>.</p>
	 * @return monomes : (Map)
	 * 
	 * @see Monome
	 */

	public Map getMonomes() {
		return monomes;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>setMonomes</i></h1>
	 * <h2><code>public void setMonomes(Map monomes)</code></h2>
	 * <p>Définie le champ <i>monomes</i> de <i><b>this</b></i> avec la <code>Map</code> fournit en paramètre.</p>
	 */
	public void setMonomes(Map monomes) {
		this.monomes = monomes;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>getInferieurA</i></h1>
	 * <h2><code>public Fraction getInferieurA()</code></h2>
	 * <p>Renvoie le champ <i>inferieurA</i> de <i><b>this</b></i>, qui est une <code>Fraction</code>.</p>
	 * @return inferieurA : (Fraction)
	 * 
	 * @see Fraction
	 */
	public Fraction getInferieurA() {
		return inferieurA;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>setInferieurA</i></h1>
	 * <h2><code>public void setInferieurA(Fraction inferieurA)</code></h2>
	 * <p>Définie le champ <i>inferieurA</i> de <i><b>this</b></i> avec la <code>Fraction</code> fournit en paramètre.</p>
	 * @param inferieurA : (Fraction)
	 * 
	 * @see Fraction
	 */
	public void setInferieurA(Fraction inferieurA) {
		this.inferieurA = inferieurA;
	}
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>getNombreInconnues</i></h1>
	 * <h2><code>public int getNombreinconnues()</code></h2>
	 * <p>Renvoie le champ <i>nombreInconnues</i> de <i><b>this</b></i>.</p>
	 * @return nombreInconnues : (Integer)
	 */
	public int getNombreInconnues() {
		return nombreInconnues;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px;} </style>
	 * <h1><i>setNombreInconnues</i></h1>
	 * <h2><code>public void setNombreInconnues</code></h2>
	 * <p>Définie le champ <i>nombreInconnues</i> de <i><b>this</b></i> avec l'<code>Integer</code> fournit en paramètre.</p>
	 * @param nombreInconnues : (Integer)
	 */
	public void setNombreInconnues(int nombreInconnues) {
		this.nombreInconnues = nombreInconnues;
	}
	
}
