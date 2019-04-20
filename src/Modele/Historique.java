package Modele;

import java.io.Serializable;
import java.util.LinkedList;

import Modele.Simplexe;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>Historique</i></h1>
 * <h2><code>public class Historique implements Serializable</code></h2>
 * <p>Cette classe contient les différents <i>dictionnaires</i> du simplexe en cours : <b>c'est une liste de <code>Simplexe</code></b>.</p>
 */
@SuppressWarnings("serial")
public class Historique implements Serializable{
	
	private LinkedList <Simplexe> listeSimplexe;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>Historique(LinkedList\<Simplexe\> liste)</i></h1>
	 * <h2><code>public Historique(LinkedList\<Simplexe\> liste)</code></h2>
	 * <p>Construit un objet <code>Historique</code> à partir d'une liste de <code>Simplexe</code> donnée en paramètre.</p>
	 * @param liste : (LinkedList\<Simplexe\>)
	 */
	public Historique(LinkedList<Simplexe> liste) {
		listeSimplexe = liste;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>Historique</i></h1>
	 * <h2><code>public Historique(Historique histo)</code></h2>
	 * </p>Construit un objet <code>Historique</code> à partir d'un autre objet <code>Historique</code> donné en paramètre.
	 * @param histo : (Historique)
	 */
	public Historique(Historique histo) {
		listeSimplexe=new LinkedList();
		
		for(int i=0;i<histo.listeSimplexe.size();i++) {
			listeSimplexe.add(new Simplexe(histo.listeSimplexe.get(i)));
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>Historique</i></h1>
	 * <h2><code>public Historique()</code></h2>
	 * <p>Construit un objet <code>Historique</code> contenant une liste de <code>Simplexe</code> vide.</p>
	 */
	public Historique() {
		listeSimplexe = new LinkedList<Simplexe>();
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getListeSimplexe</i></h1>
 	 * <h2><code>public LinkedList\<Simplexe\> getListeSimplexe()</code></h2>
	 * <p>Renvoie le champ <i>listeSimplexe</i> de <i><b>this</b></i>, qui est une liste de Simplexe.</p>
	 * @return listeSimplexe : (LinkedList)
	 *
	 * @see Simplexe
	 */
	public LinkedList<Simplexe> getListeSimplexe() {
		return listeSimplexe;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>add</i></h1>
	 * <h2><code>public void add(Simplexe simplexe)</code></h2>
	 * <p>Ajoute un <code>Simplexe</code> à la <i>listeSimplexe</i> de <i><b>this</b></i>.</p>
	 * @param simplexe : (Simplexe)
	 */
	public void add(Simplexe simplexe) {
		listeSimplexe.add(simplexe);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Parcourt la <i>listeSimplexe</i> de <i><b>this</b></i> et renvoie les <code>Simplexe</code> de la liste sous 
	 * forme de chaîne de caractère.</p>
	 * @return chaineFinale : (String)
	 * 
	 * @see Simplexe#toString2()
	 */
	public String toString() {
		String chaineFinale= new String();
		for(int i=0;i<listeSimplexe.size();i++) {
			chaineFinale+=listeSimplexe.get(i).toString2() +"\n";
		}
		return chaineFinale;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>setListeSimplexe(LinkedList\<Simplexe\> listeSimplexe)</i></h1>
	 * <h2><code>public void add(Simplexe simplexe)</code></h2>
	 * <p>Défini le champ <i>listeSimplexe</i> de <i><b>this</b></i> avec la <code>LinkedList</code> donnée en paramètre.</p>
	 * @param listeSimplexe : (LinkedList)
	 */
	public void setListeSimplexe(LinkedList<Simplexe> listeSimplexe) {
		this.listeSimplexe = listeSimplexe;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 	 * <h1><i>etapePrecedente()</i></h1>
	 * <h2><code>public void void etapePrecedente()</code></h2>
	 * <p>Supprime le dernier simplexe de la <i>listeSimplexe</i> de <i><b>this</b></i> (si il y a plus d'un simplexe).</p>
	 *
	 * @see Simplexe
	 */
	public void etapePrecedente() {
		if(listeSimplexe.size()>1) {
			listeSimplexe.removeLast();
		}
	}
	
}

