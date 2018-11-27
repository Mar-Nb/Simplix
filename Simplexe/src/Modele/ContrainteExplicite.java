package Modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContrainteExplicite {
	String nom;
	Map monomes;
	int inferieurA;
	int nombreInconnues;
	
	public ContrainteExplicite(int limite, String nom){
		this.monomes = new HashMap();
		inferieurA=limite;
		nombreInconnues=0;
		this.nom=nom;
	}
	
	public void ajouterMonome(Monome m) {
		monomes.put(m.getInconnue(), m);
	}
	
	public void passageDico1() {
		for (Iterator i = monomes.keySet().iterator(); i.hasNext(); ) {
			String clé = (String) i.next();
			((Monome)monomes.get(clé)).multiplier(-1);
		}
		Monome m = new Monome(inferieurA, " ");
		this.ajouterMonome(m);
	}
	
	/* toString pour le dictionnaire 0 (sans les "=", seulement les contraintes avec les "<=")*/
	
	public String toStringDico1() {
		String chaineFinale = new String();
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String clé = (String) i.next();
			chaineFinale+=((Monome) monomes.get(clé)).toString();
		}
		
		while(i.hasNext()) {
			String clé = (String) i.next();
			if(((Monome) monomes.get(clé)).getCoefficient() >=0) {
				chaineFinale+=" + ";
			}
			chaineFinale += ((Monome) monomes.get(clé)).toString();
		}
		chaineFinale+= " <= "+ this.inferieurA;
		return chaineFinale;
	}
	
	/* toString pour les autres dictionnaires (avec les "=")*/
	
	public String toString() {
		String chaineFinale = new String();
		chaineFinale +=  this.nom + " = ";
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String clé = (String) i.next();
			chaineFinale+=((Monome) monomes.get(clé)).toString();
		}
		
		while(i.hasNext()) {
			String clé = (String) i.next();
			if(((Monome) monomes.get(clé)).getCoefficient() >=0) {
				chaineFinale+=" + ";
			}
			chaineFinale += ((Monome) monomes.get(clé)).toString();
		}
		return chaineFinale;

	}
	
	/*Parcourt la HashMap <nom de l'inconnue, Monome> de this. Additionne chaque Monome à celui ayant la même clé dans la HashMap de la 
	 * Contrainte explicite en paramètre
	 */
	
	public void additionnerLigne(ContrainteExplicite ce) {
		Iterator i = monomes.keySet().iterator(); 
		while(i.hasNext()) {
			String clé = (String) i.next();
			((Monome) monomes.get(clé)).additionner(((Monome)ce.getMonomes().get(clé)));
		}
	}
	
	public void echanger(Monome m) {
		Iterator i = monomes.keySet().iterator();
		while(i.hasNext()) { // On parcours notre contrainte
			String clé = (String) i.next();
			if (clé.equals(m.getInconnue())) { // on tombe sur le bon Xi
				int coeff = ((Monome)monomes.get(clé)).getCoefficient(); // on récupère le coefficient du monome à switch
				String tmp = this.nom;
				Monome switched = new Monome(-1,this.nom); // on met -1 car on le switch donc son coeff devient négatif. Il va ensuite être divisé par le coeff de m
				this.nom = ((Monome)monomes.get(clé)).getInconnue(); // On remplace le nom de la contrainte par l'inconnue de m
				monomes.remove(clé);
				monomes.put(switched.getInconnue(),switched);
				division((float)coeff * -1); //ADD FRACTION
				break;
			}
		}
	}
	
	public void division(float coeff) { //ADD FRACTION
		Iterator i = monomes.keySet().iterator();
		while(i.hasNext()) {
			String clé = (String) i.next();
			((Monome) monomes.get(clé)).multiplier(1 / coeff); //revient a diviser par le coeff --> pour les non matheux
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Map getMonomes() {
		return monomes;
	}

	public void setMonomes(Map monomes) {
		this.monomes = monomes;
	}

	public int getInferieurA() {
		return inferieurA;
	}

	public void setInferieurA(int inferieurA) {
		this.inferieurA = inferieurA;
	}

	public int getNombreInconnues() {
		return nombreInconnues;
	}

	public void setNombreInconnues(int nombreInconnues) {
		this.nombreInconnues = nombreInconnues;
	}
	
}
