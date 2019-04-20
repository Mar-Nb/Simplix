package Modele;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>Simplexe</i></h1>
 * <h2><code>public class Simplexe implements Serializable</code></h2>
 * <p> Cette classe imite le comportement mathématique d'un simplexe. Il est composé d'une liste de <code>ContrainteExplicite</code>
 * et d'une <code>FonctionEco</code>.</p>
 * 
 * @see ContrainteExplicite
 * @see FonctionEco
 */
@SuppressWarnings("serial")
public class Simplexe implements Serializable{
	
	List contraintes;
	FonctionEco fonctionEco;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Simplexe(List contraintes, FonctionEco fonctionEco)</code></h2>
	 * <p>Construit un objet <code>Simplexe</code> à partir d'une liste de contrainte et d'une fonction économique données en paramètre.</p>
	 * @param contraintes : (List)
	 * @param fonctionEco : (FonctionEco)
	 * 
	 * @see FonctionEco
	 */
	public Simplexe(List contraintes, FonctionEco fonctionEco) {
		this.contraintes=contraintes;
		this.fonctionEco=fonctionEco;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Simplexe()</code></h2>
	 * <p>Constructeur vide.</p>
	 */
	public Simplexe() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Simplexe(Simplexe simp)</code></h2>
	 * <p>Construit un objet <code>Simplexe</code> à partir du simplexe donné en paramètre.</p>
	 * @param simp : (Simplexe)
	 */
	public Simplexe(Simplexe simp) {
		List cont = new LinkedList<>();
		for(int i=0;i<simp.contraintes.size();i++) {
			ContrainteExplicite ce = (ContrainteExplicite) simp.contraintes.get(i);
			cont.add(new ContrainteExplicite(ce));
		}
		contraintes=cont;
		
		fonctionEco=new FonctionEco(simp.getFonctionEco());
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>passageDico1</i></h1>
	 * <h2><code>public void passageDico1()</code></h2>
	 * <p>Permet le passage au dictionnaire n°1 de <i><b>this</b></i>.</p>
	 */
	public void passageDico1() {
		for(int i = 0; i<contraintes.size();i++) {
			((ContrainteExplicite)contraintes.get(i)).passageDico1();
		}
	}
	
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Renvoie une chaîne de caractère contenant les <code>ContraintesExplicite</code> et la <code>FonctionEco</code>
	 * qui compose <i><b>this</b></i>.<br><br>La mise en forme de la chaine à retourner est faite en HTML.</p>
	 * @return chaineFinale : (String)
	 */
	public String toString() {
		String chaineFinale="";
		for(int i=0; i<contraintes.size(); i++) {
			chaineFinale += "<p>"+((ContrainteExplicite) contraintes.get(i)).toString()+"</p><br>";
		}
		chaineFinale+= "<p>"+fonctionEco.toString()+"</p><br><hr><br>";
		return chaineFinale;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>toString2</i></h1>
	 * <h2><code>public String toString2()</code></h2>
	 * <p>Renvoie une chaîne de caractère contenant les <code>ContraintesExplicite</code> et la <code>FonctionEco</code>
	 * qui compose <i><b>this</b></i>.</p>
	 * @return chaineFinale : (String)
	 */
	public String toString2() {
		String chaineFinale="";
		for(int i=0; i<contraintes.size(); i++) {
			chaineFinale += ((ContrainteExplicite) contraintes.get(i)).toString() + "\n";
			
		}
		chaineFinale+=fonctionEco.toString();
		return chaineFinale;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>echangeJudicieux</i></h1>
	 * <h2><code>public String echangeJudicieux()</code></h2>
	 * <p>Utilisée lors des indices qui sont demandés par l'utilisateur, cette fonction affiche quel est l'échange de variable dans la base
	 * et hors base qu'il est préférable d'effectuer afin de se rapprocher au plus près du bénéfice maximal.</p>
	 * @return "Echange à effectuer : " + <i>inconnueBase</i> + " & " + inconnueHorsBase : (String)
	 */
	public String echangeJudicieux() {
		String inconnueBase = fonctionEco.monomeCoeffMax();
		String inconnueHorsBase = "";
		
		double max=100000000000000.0;
		
		for(int i=0; i<contraintes.size(); i++) {
			
			if(((ContrainteExplicite)contraintes.get(i)).getMonomes().get(inconnueBase)!=null) {
				if(((ContrainteExplicite)contraintes.get(i)).majorant(inconnueBase)<max /*&& ((ContrainteExplicite)contraintes.get(i)*/){
				
				inconnueHorsBase = ((ContrainteExplicite)contraintes.get(i)).getNom();
				max=((ContrainteExplicite)contraintes.get(i)).majorant(inconnueBase);
				}
			}
			
		}
		if(inconnueHorsBase == "") {
			return "Vous avez atteint le bénéfice maximum";
		}
		return "Echange à effectuer : " + inconnueBase + " & " + inconnueHorsBase;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>echanger</i></h1>
	 * <h2><code>public void echanger(String inconnueHorsBase, String inconnueBase)</code></h2>
	 * <p>Permet l'échange d'une variable hors base et d'une variable dans la base dans <i><b>this</b></i>.</p>
	 * @param inconnueHorsBase : (String)
	 * @param inconnueBase : (String)
	 */
	public void echanger(String inconnueHorsBase, String inconnueBase) {
		int mem=-1;
		ContrainteExplicite memCE=new ContrainteExplicite(new Fraction(1,1), "");
		for(int i = 0; i<contraintes.size();i++) {
			if(((ContrainteExplicite) contraintes.get(i)).getNom().equals(inconnueHorsBase)) {
				memCE = ((ContrainteExplicite) contraintes.get(i));
				memCE.rentrerBase(inconnueBase);
				fonctionEco.echanger(memCE, inconnueBase);
				mem=i;
				
			}
		}
		for(int i=0;i<contraintes.size();i++) {
			if(i != mem) {
				((ContrainteExplicite) contraintes.get(i)).echanger(memCE, inconnueBase);
			}
		}
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getContraintes</i></h1>
	 * <h2><code>public List getContraintes()</code></h2>
	 * <p>Renvoie le champ <i>contraintes</i> de <i><b>>this</b></i>.</p>
	 * @return contraintes : (List)
	 */
	public List getContraintes() {
		return contraintes;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>setContraintes</i></h1>
	 * <h2><code>public void setContraintes(List contraintes)</code></h2>
	 * <p>Défini le champ <i>contraintes</i> de <i><b>this</b></i> avec la liste de contraintes donnée en paramètre.</p>
	 * @param contraintes : (List)
	 */
	public void setContraintes(List contraintes) {
		this.contraintes = contraintes;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getFonctionEco</i></h1>
	 * <h2><code>public FonctionEco getFonctionEco()</code></h2>
	 * <p>Renvoie le champ <i>fonctionEco</i> de <i><b>this</b></i>.</p>
	 * @return fonctionEco : (FonctionEco)
	 */
	public FonctionEco getFonctionEco() {
		return fonctionEco;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>setFonctionEco</i></h1>
	 * <h2><code>public void setFonctionEco(FonctionEco fonctionEco)</code></h2>
	 * <p>Défini le champ <i>fonctionEco</i> de <i><b>this</b></i> avec la fonction économique donnée en paramètre.</p>
	 * @param fonctionEco : (FonctionEco)
	 */
	public void setFonctionEco(FonctionEco fonctionEco) {
		this.fonctionEco = fonctionEco;
	}
	
	
}
