package Modele;

import java.io.Serializable;
import java.util.LinkedList;

import Modele.Simplexe;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>Historique</i></h1>
 * <h2><code>public class Historique implements <span class='name'>Serializable</span></code></h2>
 * <p>Cette classe contient les différents <i>dictionnaires</i> du simplexe en cours : <b>c'est une liste de <code class='name'>Simplexe</code></b>.</p>
 */
@SuppressWarnings("serial")
public class Historique implements Serializable{
	
	private LinkedList <Simplexe> listeSimplexe;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Historique(<span class='name'>LinkedList</span> liste)</code></h2>
	 * <p>Remplie le champ <i>listeSimplexe</i> de <i><b>this</b></i> à partir d'une liste de <code class='name'>Simplexe</code> donnée en paramètre.</p>
	 * 
	 * @param liste : (LinkedList)
	 */
	public Historique(LinkedList<Simplexe> liste) {
		listeSimplexe = liste;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Historique(<span class='name'>Historique</span> histo)</code></h2>
	 * <p>Met en place un historique à partir de l'<code class='name'>Historique</code> donné en paramètre.</p>
	 * 
	 * @param histo : (Historique)
	 */
	public Historique(Historique histo) {
		listeSimplexe=new LinkedList();
		
		for(int i=0;i<histo.listeSimplexe.size();i++) {
			listeSimplexe.add(new Simplexe(histo.listeSimplexe.get(i)));
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Historique()</code></h2>
	 */
	public Historique() {
		listeSimplexe = new LinkedList<Simplexe>();
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getListeSimplexe</i></h1>
 	 * <h2><code>public LinkedList getListeSimplexe()</code></h2>
	 * <p>Renvoie le champ <i>listeSimplexe</i> de <i><b>this</b></i>.</p>
	 * @return listeSimplexe : (LinkedList) Liste de Simplexe
	 *
	 * @see Simplexe
	 */
	public LinkedList<Simplexe> getListeSimplexe() {
		return listeSimplexe;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>add</i></h1>
	 * <h2><code>public void add(<span class='name'>Simplexe</span> simplexe)</code></h2>
	 * <p>Ajoute un <code class='name'>Simplexe</code> à la <i>listeSimplexe</i> de <i><b>this</b></i>.</p>
	 * 
	 * @param simplexe : (Simplexe)
	 */
	public void add(Simplexe simplexe) {
		listeSimplexe.add(simplexe);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>toString</i></h1>
	 * <h2><code>public String toString()</code></h2>
	 * <p>Parcourt la <i>listeSimplexe</i> de <i><b>this</b></i> et renvoie les <code class='name'>Simplexe</code> de la liste sous 
	 * forme de chaîne de caractère.</p>
	 * 
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>setListeSimplexe</i></h1>
	 * <h2><code>public void setListeSimplexe(<span class='name'>LinkedList</span> listeSimplexe)</code></h2>
	 * <p>Défini le champ <i>listeSimplexe</i> de <i><b>this</b></i> avec la <code class='name'>LinkedList</code> donnée en paramètre.</p>
	 * @param listeSimplexe : (LinkedList)
	 */
	public void setListeSimplexe(LinkedList<Simplexe> listeSimplexe) {
		this.listeSimplexe = listeSimplexe;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
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

