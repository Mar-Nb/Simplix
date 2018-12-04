package Modele;

import java.util.LinkedList;

public class TestSimplexe {

	public static void main(String[] args) {
		Monome m1 = new Monome(2, "x1");
		Monome m2 = new Monome(4, "x2");
		Monome m3 = new Monome(12, "x3");
		Monome m4 = new Monome(10, "x1");
		Monome m5 = new Monome(2, "x2");
		Monome m6 = new Monome(8, "x3");
		Monome m7 = new Monome(6, "x1");
		Monome m8 = new Monome(18, "x2");
		Monome m9 = new Monome(8, "x3");
		Monome m10 = new Monome(2, "x1");
		Monome m11 = new Monome(4, "x2");
		Monome m12 = new Monome(16, "x3");
		
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m1);
		ec.ajouterMonome(m2);
		ec.ajouterMonome(m3);
		
		ContrainteExplicite x4 = new ContrainteExplicite(23, "x4");
		x4.ajouterMonome(m7);
		x4.ajouterMonome(m8);
		x4.ajouterMonome(m9);
		

		ContrainteExplicite x5 = new ContrainteExplicite(28, "x5");
		x5.ajouterMonome(m4);
		x5.ajouterMonome(m5);
		x5.ajouterMonome(m6);
		
		
		ContrainteExplicite x6 = new ContrainteExplicite(23, "x6");
		x6.ajouterMonome(m10);
		x6.ajouterMonome(m11);
		x6.ajouterMonome(m12);
		
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x4);
		contraintes.add(x5);
		contraintes.add(x6);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		System.out.println(simp + "\n");
		simp.passageDico1();
		System.out.println(simp + "\n");
		simp.echanger("x5", "x2");
		//x5.echanger(m1);
		System.out.println(simp + "\n");

	}

}
