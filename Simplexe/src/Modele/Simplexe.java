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
	
	public void echanger(String inconnueHorsBase, String inconnueBase) {
		int mem=-1;
		ContrainteExplicite memCE=new ContrainteExplicite(0, "");
		for(int i = 0; i<contraintes.size();i++) {
			if(((ContrainteExplicite) contraintes.get(i)).getNom().equals(inconnueHorsBase)) {
				memCE = ((ContrainteExplicite) contraintes.get(i));
				memCE.rentrerBase(inconnueBase);
				System.out.println("AVANT UPDATE DE LA FONCTION ECO : \n" + this.toString());
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
}
