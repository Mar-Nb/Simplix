package Modele;

import java.util.List;
import java.util.Map;

public class Simplexe {
	List contraintes;
	FonctionEco fonctionEco;
	
	public Simplexe(List contraintes, FonctionEco fonctionEco) {
		this.contraintes=contraintes;
		this.fonctionEco=fonctionEco;
	}
	
	public void passageDico1() {
		for(int i = 0; i<contraintes.size();i++) {
			((ContrainteExplicite)contraintes.get(i)).passageDico1();
		}
	}
	
	public String toString() {
		String chaineFinale=new String();
		for(int i=0; i<contraintes.size(); i++) {
			chaineFinale += ((ContrainteExplicite) contraintes.get(i)).toString()+"\n";
			
		}
		chaineFinale+= fonctionEco.toString();
		return chaineFinale;
	}
}
