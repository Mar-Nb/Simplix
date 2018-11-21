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
			String cl� = (String) i.next();
			((Monome)monomes.get(cl�)).setCoefficient(((Monome)monomes.get(cl�)).getCoefficient() * (-1));
		}
		Monome m = new Monome(inferieurA, " ");
		this.ajouterMonome(m);
	}
	
	/* toString pour le dictionnaire 0 (sans les "=", seulement les contraintes avec les "<=")*/
	
	public String toStringDico1() {
		String chaineFinale = new String();
		Iterator i = monomes.keySet().iterator(); 
		if(i.hasNext()) {
			String cl� = (String) i.next();
			chaineFinale+=((Monome) monomes.get(cl�)).toString();
		}
		
		while(i.hasNext()) {
			String cl� = (String) i.next();
			if(((Monome) monomes.get(cl�)).getCoefficient() >=0) {
				chaineFinale+=" + ";
			}
			chaineFinale += ((Monome) monomes.get(cl�)).toString();
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
			String cl� = (String) i.next();
			chaineFinale+=((Monome) monomes.get(cl�)).toString();
		}
		
		while(i.hasNext()) {
			String cl� = (String) i.next();
			if(((Monome) monomes.get(cl�)).getCoefficient() >=0) {
				chaineFinale+=" + ";
			}
			chaineFinale += ((Monome) monomes.get(cl�)).toString();
		}
		return chaineFinale;

	}
	
	/*Parcourt la HashMap <nom de l'inconnue, Monome> de this. Additionne chaque Monome � celui ayant la m�me cl� dans la HashMap de la 
	 * Contrainte explicite en param�tre
	 */
	
	public void additionnerLigne(ContrainteExplicite ce) {
		Iterator i = monomes.keySet().iterator(); 
		while(i.hasNext()) {
			String cl� = (String) i.next();
			((Monome) monomes.get(cl�)).additionner(((Monome)ce.getMonomes().get(cl�)));
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
