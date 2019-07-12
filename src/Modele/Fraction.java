package Modele;

import java.io.Serializable;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>Fraction</i></h1>
 * <h2><code>public class Fraction implements <span class='name'>Serializable</span></code></h2>
 * <p> Cette classe imite le comportement mathématique d'une fraction. Elle contient toutes les opérations nécessaires à la gestion des fractions par les monomes.</p>
 */
@SuppressWarnings("serial")
public class Fraction implements Serializable{
	
	private int numerateur;
	private int denominateur;
	
	//FRACTION
	//une fraction composee d'une numerateur et d'un denominateur
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public Fraction(<span class='name'>int</span> parNum, <span class='name'>int</span> parDen)</code></h2>
	 * <p>Construit un objet <code class='name'>Fraction</code> à partir des deux valeurs passées en paramètre qui lui serviront respectivement de numérateur et 
	 * de dénominateur.</p>
	 * 
	 * @param parNum : (Integer) Le numérateur
	 * @param parDen : (Integer) Le dénominateur
	 */
	public Fraction(int parNum, int parDen) {
	
		if(parDen == 0) {
			throw new RuntimeException("Division par zero");
		}
		
		numerateur = parNum;
		denominateur = parDen;
		reduire();   //A voir si on veut que la fraction soit reduite directement ou non

	}
	
	//si la fraction est un nombre entier
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public Fraction(<span class='name'>int</span> parVal)</code></h2>
	 * <p>Construit un objet <code class='name'>Fraction</code> à partir de la valeur passée en paramètre. Le dénominateur est mis à 1 pour simuler un entier.</p>
	 * 
	 * @param parVal : (Integer)
	 */
	public Fraction(int parVal) {
	
		numerateur = parVal;
		denominateur = 1;
		reduire();
		
	}
	
	//copie d'une fraction
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public Fraction(<span class='name'>Fraction</span> parFac)</code></h2>
	 * <p>Construit <i><b>this</b></i> à partir d'un objet <code class='name'>Fraction</code> donné en paramètre.</p>
	 * 
	 * @param parFac : (Fraction)
	 */
	public Fraction(Fraction parFac) {
		numerateur = parFac.getNumerateur();
		denominateur = parFac.getDenominateur();
		reduire();
	}
	
	/**
	 * Autre constructeur par défaut de la classe Fraction Change un string en
	 * fraction (3/5 devient Fraction(3,5))
	 * 
	 * @param parFrac
	 *            une fraction
	 * @throws ExceptEntreFraction
	 * @throws ExceptZeroDivision
	 * @throws ExceptNegatifMalPlace
	 * @throws ExceptCaseVide
	 */
	public Fraction(String parFrac)
			throws ExceptEntreFraction, ExceptZeroDivision, ExceptNegatifMalPlace, ExceptCaseVide {
		int slash = 0; // si il y a un slash dans le String
		int rencontre = 0; // savoir quand on a passé le slash
		String numerateurString = "";
		String denominateurString = "";
		for (char ch : parFrac.toCharArray()) { // Test s'il y a un slash dans le String
			if (ch == '/') {
				slash = 1;
			}
		}

		if (slash == 1) { // si c'est une fraction
			for (char ch : parFrac.toCharArray()) {
				if (ch == '/')
					rencontre = 1;
				else if (ch != '/' && rencontre == 0) {
					if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6'
							&& ch != '7' && ch != '8' && ch != '9' && ch != '-') {
						throw new ExceptEntreFraction(); // s'il y a une lettre ou un caractere spécial dans la fraction
					} else
						numerateurString += ch;
				} else {
					if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6'
							&& ch != '7' && ch != '8' && ch != '9' && ch != '-') {
						System.out.println("la");
						throw new ExceptEntreFraction(); // s'il y a une lettre ou un caractere spécial dans la fraction
					} else
						denominateurString += ch;
				}
			}
			if (numerateurString == "")
				throw new ExceptCaseVide();
			if (denominateurString == "")
				throw new ExceptCaseVide();
			if (numerateurString.equals("-"))
				throw new ExceptCaseVide();
			if (denominateurString.equals("-"))
				throw new ExceptCaseVide();
			if (Integer.parseInt(denominateurString) == 0)
				throw new ExceptZeroDivision();
			for (int i = 1; i < numerateurString.length(); i++) {
				if (numerateurString.charAt(i) == '-') {
					throw new ExceptNegatifMalPlace();
				}
			}
			for (int i = 1; i < denominateurString.length(); i++) {
				if (denominateurString.charAt(i) == '-') {
					throw new ExceptNegatifMalPlace();
				}
			}
			numerateur = Integer.parseInt(numerateurString);
			denominateur = Integer.parseInt(denominateurString);
		} else {// si c'est un entier
			for (char ch : parFrac.toCharArray()) {
				if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6' && ch != '7'
						&& ch != '8' && ch != '9' && ch != '-') {
					System.out.println("ici");
					throw new ExceptEntreFraction(); // s'il y a une lettre ou un caractere spécial dans la case
				} else
					numerateurString += ch;
			}
			if (numerateurString == "")
				throw new ExceptCaseVide();
			if (numerateurString.equals("-"))
				throw new ExceptCaseVide();
			for (int i = 1; i < numerateurString.length(); i++) {
				if (numerateurString.charAt(i) == '-') {
					throw new ExceptNegatifMalPlace();
				}
			}
			numerateur = Integer.parseInt(numerateurString);
			denominateur = 1;
		}
		reduire();
	}

	/**
	 * Renvoie vrai si la string est une fraction
	 * 
	 * @param parFrac une fraction
	 * @return vrai si la string est une fraction, sinon faux.
	 */
	public static boolean isFraction(String parFrac) {
		int slash = 0; // s'il y a un slash dans le String
		int rencontre = 0; // savoir quand on a passé le slash
		String numerateurString = "";
		String denominateurString = "";
		for (char ch : parFrac.toCharArray()) { // Test si il y a un slash dans le String
			if (ch == '/') {
				slash = 1;
			}
		}
		if (slash == 1) {
			for (char ch : parFrac.toCharArray()) {
				if (ch == '/') {
					rencontre = 1;
				} else if (ch != '/' && rencontre == 0) {
					if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6'
							&& ch != '7' && ch != '8' && ch != '9' && ch != '/') {
						return false;
					} else
						numerateurString += ch;
				} else {
					if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6'
							&& ch != '7' && ch != '8' && ch != '9' && ch != '/') {
						return false;
					} else
						denominateurString += ch;
				}
			}
			if (numerateurString == "" || denominateurString == "")
				return false;
			if (Integer.parseInt(denominateurString) == 0)
				return false;
		} else {
			for (char ch : parFrac.toCharArray()) {
				if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6' && ch != '7'
						&& ch != '8' && ch != '9') {
					return false;
				} else
					numerateurString += ch;
			}
			if (numerateurString == "")
				return false;
		}
		return true;
	}
	
	//GETTER
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>getNumerateur</i></h1>
 	 * <h2><code>public int getNumerateur()</code></h2>
	 * <p>Renvoie le champ <i>numerateur</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return numerateur : (Integer)
	 */
	public int getNumerateur() {
		return numerateur;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>getDenominateur</i></h1>
 	 * <h2><code>public int getDenominateur()</code></h2>
	 * <p>Renvoie le champ <i>denominateur</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return denominateur : (Integer)
	 */
	public int getDenominateur() {
		return denominateur;
	}
	
	//SETTER (ne pas oublier de recreer la fraction apres pour qu'elle soit r�duite)
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>setNumerateur</i></h1>
	 * <h2><code>public setNumerateur(<span class='name'>int</span> parNum)</code></h2>
	 * <p>D�fini le champ <i>numerateur</i> de <i><b>this</b></i> avec la valeur donnée en paramètre.</p>
	 * 
	 * @param parNum : (Integer)
	 */
	public void setNumerateur(int parNum) {
		this.numerateur = parNum;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>setDenominateur</i></h1>
 	 * <h2><code>public setDenominateur(<span class='name'>int</span> parDen)</code></h2>	
	 * <p>Défini le champ <i>dénominateur</i> de <i><b>this</b></i> avec la valeur donnée en paramètre.</p>
	 * 
	 * @param parDen : (Integer)
	 */
	public void setDenominateur(int parDen) {
		this.denominateur = parDen;
	}
	
	//CALCUL PGCD
	//calcul le pgcd entre deux nombres ; utilise pour reduire une fraction
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>CalculPGCD</i></h1>
 	 * <h2><code>public int CalculPGCD(<span class='name'>int</span> Num, <span class='name'>int</span> Den)</code></h2>
	 * <p>Renvoie le PGCD (<i>plus grand diviseur commun</i>) des valeurs fournit en paramètre.</p>
	 * 
	 * @param Num : (Integer)
	 * @param Den : (Integer)
	 *
	 * @return CalculPGCD(Den, Num % Den) : (Integer)
	 */
	public int CalculPGCD(int Num, int Den) {
		if(Num % Den == 0) {
			return Den;
		}
		return CalculPGCD(Den, Num % Den);
	}
	
	//REDUIRE reduit de facon definitive
	//reduit la fraction jusqu'a ce qu'elle soit irreductible
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>reduire</i></h1>
 	 * <h2><code>void reduire()</code></h2>
	 * <p>Réduit une fraction à partir de la méthode <code class='name'>CalculPGCD</code> jusqu'à la rendre irréductible.</p>
	 */
	void reduire() {
		if(denominateur < 0) { //pour mettre le - devant
			numerateur *= -1;
			denominateur *= -1;
		}
		int pgcd = Math.abs(CalculPGCD(numerateur,denominateur));
		this.setNumerateur(numerateur/pgcd);
		this.setDenominateur(denominateur/pgcd);
	}
	
	//REDUIREV2 reduit juste pour l'affichage
	//reduit la fraction jusqu'a ce qu'elle soit irreductible -- ne sert a rien si "reduire()" est activé dans les constructeurs "Fraction"
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>reduireV2</i></h1>
 	 * <h2><code>public Fraction reduireV2(<span class='name'>Fraction</span> frac)</code></h2>
	 * <p>Reduit une <span class='name'>Fraction</span> dans l'affichage.</p>
	 * 
	 * @param frac : (Fraction)
	 *
	 * @return new Fraction
	 * 
	 * @deprecated
	 */
	public Fraction reduireV2(Fraction frac) {
		int pgcd = CalculPGCD(frac.getNumerateur(),frac.getDenominateur());
		frac.setNumerateur(frac.getNumerateur()/pgcd);
		frac.setDenominateur(frac.getDenominateur()/pgcd);
		return new Fraction(frac.getNumerateur(), frac.getDenominateur());
	}
	
	//ECRITURE NON FRACTIONNELLE (voir si utilise float ou double)
	//ecrit une fraction sous le format a virgule (float : 7 chiffres apres la virgule || double = 15 chiffres apres la virgule)
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FMath()</i></h1>
 	 * <h2><code>public double FMath()</code></h2>
	 * <p>Renvoie une <code class='name'>Fraction</code> sous forme de nombre à virgule.</p>
	 *
	 * @return resultat : (double)
	 */
	public double FMath() {
		double nume = this.getNumerateur();
		double deno = this.getDenominateur();
		double resultat = nume / deno;
		return resultat;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
 	 * <h1><i>swap</i></h1>
 	 * <h2><code>public Fraction swap()</code></h2>
	 * <p>Echange le numérateur et le dénominateur d'une fonction.</p>
	 *
	 * @return new Fraction
	 */
	public Fraction swap() {
		int denominateur = this.denominateur;
		int numerateur = this.numerateur;
		return new Fraction(denominateur,numerateur);
	}
	
	//COMPARE
	//compare deux fractions entre elles
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FCompare</i></h1>
 	 * <h2><code>public boolean FCompare(<span class='name'>Fraction</span> f)</code></h2>
	 * <p>Compare la <code class='name'>Fraction</code> passée en paramètre avec <i><b>this</b></i>. Si elles sont identiques, renvoie <code>true</code>, sinon <code>false</code>.</p>
	 * 
	 * @param f : (Fraction)
	 * 
	 * @return (boolean)
	 */
	public boolean FCompare(Fraction f) {
		if((this.getNumerateur() == f.getNumerateur()) && (this.getDenominateur() == f.getDenominateur())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//donne l'ordre de deux fractions ( < ou > )  true si sup
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FSup</i></h1>
 	 * <h2><code>public boolean FSup(<span class='name'>Fraction</span> f)</code></h2>
	 * <p>Compare la <code class='name'>Fraction</code> passée en paramètre avec <i><b>this</b></i>, renvoie <code>true</code> si <i><b>this>/b></i> est supérieure, 
	 * <code>false</code> sinon.</p>
	 * 
	 * @param f : (Fraction)
	 *
	 * @return (boolean)
	 */
	public boolean FSup(Fraction f) {
		if(this.FMath() > f.FMath()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//ADDITION
	//addition deux fractions entre elles
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FAddition</i></h1>
 	 * <h2><code>public Fraction FAddition(<span class='name'>Fraction</span> frac)</code></h2>
	 * <p>Additionne <i>frac</i> avec <i><b>this</b></i> et retourne le résultat.</p>
	 * 
	 * @param frac : (Fraction)
	 *
	 * @return new Fraction
	 */
	public Fraction FAddition(Fraction frac) {
		int num = ( (numerateur * frac.getDenominateur()) + (frac.getNumerateur() * denominateur) );
		int den = denominateur * frac.getDenominateur();
		return new Fraction(num, den);
	}
	
	//SOUSTRACTION
	//soustrait deux fractions entre elles
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FSoustraction</i></h1>
 	 * <h2><code>public Fraction FSoustraction(<span class='name'>Fraction</span> frac)</code></h2>
	 * <p>Soustrait <i>frac</i> de <i><b>this</b></i> et retourne le résultat.</p>
	 * 
	 * @param frac : (Fraction)
	 * @return new Fraction
	 */
	public Fraction FSoustraction(Fraction frac) {
		int num = ( (numerateur * frac.denominateur) - (frac.numerateur * denominateur) );
		int den = denominateur * frac.denominateur;
		return new Fraction(num, den);
	}
	
	//MULTIPLICATION
	//multiplie deux fractions entre elles
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FMultiplication</i></h1>
 	 * <h2><code>public Fraction FMultiplication(<span class='name'Fraction</span> frac)</code></h2>
	 * <p>Multiplie <i>frac</i> et <i><b>this</b></i>.</p>
	 * 
	 * @param frac : (Fraction)
	 *
	 * @return new Fraction
	 */
	public Fraction FMultiplication(Fraction frac) {
		int num = numerateur * frac.getNumerateur();
		int den = denominateur * frac.getDenominateur();
		return new Fraction(num, den);
	}
	
	//DIVISION
	//divise deux fractions entre elles
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>FDivision</i></h1>
 	 * <h2><code>public Fraction FDivision(<span class='name'>Fraction</span> frac)</code></h2>
	 * <p>Divise <i><b>this</b></i> par <i>frac</i>.</p>
	 * 
	 * @param frac : (Fraction)
	 * @return new Fraction
	 */
	public Fraction FDivision(Fraction frac) {
		int num = numerateur * frac.getDenominateur();
		int den = denominateur * frac.getNumerateur();
		return new Fraction(num, den);
	}
	
	//TOSTRING
	//ecrit une fraction
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>toString</i></h1>
 	 * <h2><code>public String toString()</code></h2>
	 * <p>Affiche une fraction sous la forme d'une chaîne de caractère.</p>
	 *
	 * @return numerateur + "/" + denominateur : (String)
	 */
	public String toString() {
		if(denominateur == 1) {
			return Integer.toString(numerateur);
		}
		return numerateur + "/" + denominateur ;
	}
	
	//TEST_MAIN
	/*
	public static void main(String[] args) {
		
		//FRACTION
		System.out.println();
		System.out.println("Fractions utilis�es dans la suite du programme");
		Fraction f1 = new Fraction(30,1);
		System.out.println("f1 = 30/(1) = " + f1.toString());
		Fraction f2 = new Fraction(-2,26);
		System.out.println("f2 = (-2)/26 = " + f2.toString());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//OPERATION
		System.out.println("PREMICE : f3 repr�sentera le resultat de l'op�ration entre f1 et f2");
		System.out.println();
		
		//ADDITION
		System.out.println("Addition de deux fractions :");
		System.out.println("f3 = f1 + f2");
		System.out.println("f3 = (" + f1.toString() + ") + (" + f2.toString() + ")");
		Fraction f3 = f1.FAddition(f2);
		System.out.println("f3 = " + f3.toString());
		System.out.println();
		
		//SOUSTRACTION
		System.out.println("Soustraction de deux fractions :");
		System.out.println("f3 = f1 - f2");
		System.out.println("f3 = (" + f1.toString() + ") - (" + f2.toString() + ")");
		f3 = f1.FSoustraction(f2);
		System.out.println("f3 = " + f3.toString());
		System.out.println();
		
		//MULTIPLICATION
		System.out.println("Multiplication de deux fractions :");
		System.out.println("f3 = f1 * f2");
		System.out.println("f3 = (" + f1.toString() + ") * (" + f2.toString() + ")");
		f3 = f1.FMultiplication(f2);
		System.out.println("f3 = " + f3.toString());
		System.out.println();
		
		//DIVISION
		System.out.println("Division de deux fractions :");
		System.out.println("f3 = f1 / f2");
		System.out.println("f3 = (" + f1.toString() + ") / (" + f2.toString() + ")");
		f3 = f1.FDivision(f2);
		System.out.println("f3 = " + f3.toString());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//REDUCTION
		System.out.println("Test de r�duction d'une fraction :");
		Fraction f4 = new Fraction(30,10);
		System.out.println("f4 = 30/10");
		System.out.println("f4 = " + f4.toString());
		Fraction f4bis = new Fraction(2051280,915750);
		System.out.println("f4bis = 2051280 / 915750");
		System.out.println("f4bis = " + f4bis.toString());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//ECRITURE NON FRACTIONNELLE (MATH)
		System.out.println("Test �criture d�cimale d'une fraction :");
		System.out.println("Ecriture d�cimale de f1 = "+ f1.toString() + " = " + f1.FMath());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//COMPARE
		System.out.println("Test de comparaison de deux fractions ( 'true' si oui, 'false' sinon ) :");
		System.out.println("f1 et f2 sont-elles �gales ? r�sultat = " + f1.FCompare(f2));
		System.out.println("f1 et -30/13 sont-elles �gales ? r�sultat = " + f1.FCompare(new Fraction(-30,13)));
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//ORDRE
		System.out.println("Test de l'ordre de deux fractions ( > ou <= ):");
		Fraction f5 = new Fraction(10/2);
		Fraction f6 = new Fraction(10/3);
		System.out.println("f5 = 10/2 = " + f5.toString() + " et f6 = 10/3 = " + f6.toString());
		System.out.println("f5 > f6 ? ( 'true' si oui, 'false' sinon ) : r�sultat = " + f5.FSup(f6));
		System.out.println("f6 > f5 ? ( 'true' si oui, 'false' sinon ) : r�sultat = " + f6.FSup(f5));
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		//AUTRE
		System.out.println("Test getter de fraction :");
		System.out.println("f1 = 30/(-13) = " + f1.toString());
		System.out.println("f2 = (-2)/26 = " + f2.toString());
		System.out.println("Num�rateur de f1 = "+ f1.getNumerateur() + " et d�nominateur de f1 = " + f1.getDenominateur());
		System.out.println("Num�rateur de f2 = "+ f2.getNumerateur() + " et d�nominateur de f2 = " + f2.getDenominateur());
		System.out.println();
		
		System.out.println("Test setter de fraction :");
		Fraction f7 = new Fraction(325,235);
		System.out.println("f7 = 325/235 = " + f7.toString());
		System.out.println("On remplace le num�rateur de f7 par 282");
		f7.setNumerateur(282);
		f7 = new Fraction(f7);
		System.out.println("Maintenant f7 = 282/47 = " + f7.toString());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println();
		
		System.out.println("Test calcul PGCD d'une fraction :");
		Fraction ex = new Fraction(0);
		int pgcd = Math.abs(ex.CalculPGCD(125,475));
		System.out.println("PGCD de 125 et 475 = " + pgcd);
		System.out.println();
		System.out.println("-----------------------------");
	}*/

}