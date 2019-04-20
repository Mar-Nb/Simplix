package Modele;

import java.io.Serializable;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>Monome</i></h1>
 * <h2><code>public class Monome implements Serializable</code></h2>
 * <p> Cette classe compose les contrainte explicites et la fonction économique. Elle imite le comportement
 * mathématiques d'un monome et est composée d'une coefficient, qui est une <code>Fraction</code>, et d'une <code>String</code>
 * pour l'inconnue.</p>
 * 
 * @see ContrainteExplicite
 * @see FonctionEco
 * @see Fraction
 */
@SuppressWarnings("serial")
public class Monome implements Serializable{
	
	Fraction coefficient;
	String inconnue;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Monome(Fraction coeff, String inconnue</code></h2>
	 * <p>Construit un objet <code>Monome</code> à partir d'une <code>Fraction</code> et d'une <code>String</code> données
	 * en paramètre.</p>
	 * @param coeff : (Fraction)
	 * @param inconnue : (String)
	 */
	public Monome(Fraction coeff, String inconnue) {
		coefficient=coeff;
		this.inconnue=inconnue;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Monome(Monome monome)</code></h2>
	 * <p>Construit un objet <code>Monome</code> à partir du monome donné en paramètre.</p>
	 * @param monome : (Monome)
	 */
	public Monome(Monome monome) {
		coefficient=new Fraction(monome.getCoefficient());
		inconnue=monome.getInconnue();
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Affiche le monome sous forme de chaîne de caractère.</p>
	 *@return String 
	 */
	public String toString() {
		if(coefficient.toString().equals("1") && inconnue.equals(" ")==false) {
			return inconnue;
		}
		
		if(coefficient.toString().equals("-1") && inconnue.equals(" ")==false) {
			return "-"+inconnue;
		}
		
		else if(coefficient.toString().equals("0")) {
			return "";
		}
		else {
			return coefficient + inconnue;
		}
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>additionner</i></h1>
	 * <h2><code>public void additionner(Monome m)</code></h2>
	 * <p>Ajoute <i>m</i> à <i><b>this</b></i>.</p>
	 * @param Monome m
	 */
	public void additionner(Monome m) {
		this.coefficient = this.coefficient.FAddition(m.getCoefficient());
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>multiplier</i></h1>
	 * <h2><code>public void multiplier(Fraction constante)</code></h2>
	 * <p>Multiplie <i><b>this</b></i> par <i>constante</i>.</p>
	 * @param constante : (Fraction)
	 */
	public void multiplier(Fraction constante) { // ADD FRACTION
		this.coefficient.FMultiplication(constante);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>getCoefficient</i></h1>
	 * <h2><code>public Fraction getCoefficient()</code></h2>
	 * <p>Renvoie le champ <i>coefficient</i> de <i><b>this</b></i>.</p>
	 * @return coefficient : (Fraction)
	 */
	public Fraction getCoefficient() {
		return coefficient;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>setCoefficient</i></h1>
	 * <h2><code>public void setCoefficient(Fraction coefficient)</code></h2>
	 * <p>Définie le champ <i>coefficient</i> de <i><b>this</b></i> avec la <code>Fraction</code> donnée en paramètre.</p>
	 * @param coefficient : (Fraction)
	 */
	public void setCoefficient(Fraction coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>getInconnue</i></h1>
	 * <h2><code>public String getInconnue()</code></h2>
	 * <p>Renvoie le champ <i>>inconnue</i> de <i><b>this</b></i>.</p>
	 * @return inconnue : (String)
	 */
	public String getInconnue() {
		return inconnue;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>setInconnue</i></h1>
	 * <h2><code>public void setInconnue(String inconnue)</code></h2>
	 * <p>Définie le champ <i>inconnue</i> de <i><b>this</b></i> avec la <code>String</code> donnée en paramètre.</p>
	 * @param inconnue : (String)
	 */
	public void setInconnue(String inconnue) {
		this.inconnue = inconnue;
	}
}
