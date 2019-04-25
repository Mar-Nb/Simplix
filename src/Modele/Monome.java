package Modele;

import java.io.Serializable;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>Monome</i></h1>
 * <h2><code>public class Monome implements <span class='name'>Serializable</span></code></h2>
 * <p> Cette classe compose les contrainte explicites et la fonction économique. Elle imite le comportement
 * mathématiques d'un monome et est composée d'une coefficient, qui est une <code class='name'>Fraction</code>, et d'une <code class='name'>String</code>
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Monome(<span class='name'>Fraction</span> coeff, <span class='name'>String</span> inconnue</code></h2>
	 * <p>Construit un objet <code class='name'>Monome</code> à partir d'une <code class='name'>Fraction</code> et d'une <code class='name'>String</code> données
	 * en paramètre.</p>
	 * 
	 * @param coeff : (Fraction)
	 * @param inconnue : (String)
	 */
	public Monome(Fraction coeff, String inconnue) {
		coefficient=coeff;
		this.inconnue=inconnue;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Monome(<span class='name'>Monome</span> monome)</code></h2>
	 * <p>Construit un objet <code class='name'>Monome</code> à partir de celui donné en paramètre.</p>
	 * 
	 * @param monome : (Monome)
	 */
	public Monome(Monome monome) {
		coefficient=new Fraction(monome.getCoefficient());
		inconnue=monome.getInconnue();
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Affiche le monome sous forme de chaîne de caractère.</p>
	 * 
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>additionner</i></h1>
	 * <h2><code>public void additionner(<span class='name'>Monome</span> m)</code></h2>
	 * <p>Ajoute <i>m</i> à <i><b>this</b></i>.</p>
	 * 
	 * @param m : (Monome)
	 */
	public void additionner(Monome m) {
		this.coefficient = this.coefficient.FAddition(m.getCoefficient());
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>multiplier</i></h1>
	 * <h2><code>public void multiplier(<span class='name'>Fraction</span> constante)</code></h2>
	 * <p>Multiplie <i><b>this</b></i> par <i>constante</i>.</p>
	 * 
	 * @param constante : (Fraction)
	 */
	public void multiplier(Fraction constante) { // ADD FRACTION
		this.coefficient.FMultiplication(constante);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>getCoefficient</i></h1>
	 * <h2><code>public Fraction getCoefficient()</code></h2>
	 * <p>Renvoie le champ <i>coefficient</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return coefficient : (Fraction)
	 */
	public Fraction getCoefficient() {
		return coefficient;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>setCoefficient</i></h1>
	 * <h2><code>public void setCoefficient(<span class='name'>Fraction</span> coefficient)</code></h2>
	 * <p>Définie le champ <i>coefficient</i> de <i><b>this</b></i> avec la <code class='name'>Fraction</code> donnée en paramètre.</p>
	 * 
	 * @param coefficient : (Fraction)
	 */
	public void setCoefficient(Fraction coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>getInconnue</i></h1>
	 * <h2><code>public String getInconnue()</code></h2>
	 * <p>Renvoie le champ <i>>inconnue</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return inconnue : (String)
	 */
	public String getInconnue() {
		return inconnue;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>setInconnue</i></h1>
	 * <h2><code>public void setInconnue(<span class='name'>String</span> inconnue)</code></h2>
	 * <p>Définie le champ <i>inconnue</i> de <i><b>this</b></i> avec la <code class='name'>String</code> donnée en paramètre.</p>
	 * 
	 * @param inconnue : (String)
	 */
	public void setInconnue(String inconnue) {
		this.inconnue = inconnue;
	}
}
