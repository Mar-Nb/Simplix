package Modele;

import java.util.LinkedList;

import Modele.Simplexe;

public class Historique{
	
	private LinkedList <Simplexe> listeSimplexe;
	
	public LinkedList<Simplexe> getListeSimplexe() {
		return listeSimplexe;
	}
	
	public void add(Simplexe simplexe) {
		listeSimplexe.add(simplexe);
	}

	public void setListeSimplexe(LinkedList<Simplexe> listeSimplexe) {
		this.listeSimplexe = listeSimplexe;
	}

	public Historique(LinkedList<Simplexe> liste) {
		listeSimplexe = liste;
	}
	
}

