package Modele;

import java.util.LinkedList;

public class TestSimplexe {

	public static void main(String[] args) {
		Monome m1 = new Monome(2, "x1");
		Monome m2 = new Monome(3, "x2");
		Monome m3 = new Monome(-2, "x3");
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m1);
		ec.ajouterMonome(m2);
		ec.ajouterMonome(m3);
		
		ContrainteExplicite x4 = new ContrainteExplicite(23, "x4");
		x4.ajouterMonome(m1);
		x4.ajouterMonome(m2);
		x4.ajouterMonome(m3);
		

		ContrainteExplicite x5 = new ContrainteExplicite(28, "x5");
		x5.ajouterMonome(m1);
		x5.ajouterMonome(m2);
		x5.ajouterMonome(m3);
		ContrainteExplicite x6 = new ContrainteExplicite(23, "x6");
		x6.ajouterMonome(m1);
		x6.ajouterMonome(m2);
		x6.ajouterMonome(m3);
		
		x6.additionnerLigne(x5);
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x4);contraintes.add(x5);contraintes.add(x6);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		System.out.println(simp);
		simp.passageDico1();
		System.out.println(simp);
		

	}

}
