package Modele;

import java.util.LinkedList;

public class TestSimplexe {

	public static void main(String[] args) {
		/*Monome m1 = new Monome(new Fraction(2,1), "x1");
		Monome m2 = new Monome(new Fraction(4,1), "x2");
		Monome m3 = new Monome(new Fraction(5,1), "x3");
		Monome m4 = new Monome(new Fraction(7,1), "x4");
		
		Monome m5 = new Monome(new Fraction(1,1), "x1");
		Monome m6 = new Monome(new Fraction(1,1), "x2");
		Monome m7 = new Monome(new Fraction(2,1), "x3");
		Monome m8 = new Monome(new Fraction(2,1), "x4");
		
		
		Monome m9 = new Monome(new Fraction(1,1), "x1");
		Monome m10 = new Monome(new Fraction(2,1), "x2");
		Monome m11= new Monome(new Fraction(3,1), "x3");
		Monome m12 = new Monome(new Fraction(3,1), "x1");
		
		Monome m13 = new Monome(new Fraction(7,1), "x1");
		Monome m14 = new Monome(new Fraction(9,1), "x2");
		Monome m15 = new Monome(new Fraction(18,1), "x3");
		Monome m16 = new Monome(new Fraction(17,1), "x4");
		
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m13);
		ec.ajouterMonome(m14);
		ec.ajouterMonome(m15);
		ec.ajouterMonome(m16);
		
		ContrainteExplicite x5 = new ContrainteExplicite(new Fraction(42,1), "x5");
		x5.ajouterMonome(m1);
		x5.ajouterMonome(m2);
		x5.ajouterMonome(m3);
		x5.ajouterMonome(m4);
		

		ContrainteExplicite x6 = new ContrainteExplicite(new Fraction(28,1), "x6");
		x6.ajouterMonome(m5);
		x6.ajouterMonome(m6);
		x6.ajouterMonome(m7);
		x6.ajouterMonome(m8);
		
		
		ContrainteExplicite x7 = new ContrainteExplicite(new Fraction(24,1), "x7");
		x7.ajouterMonome(m9);
		x7.ajouterMonome(m10);
		x7.ajouterMonome(m11);
		x7.ajouterMonome(m12);
		
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x5);
		contraintes.add(x6);
		contraintes.add(x7);
		*/
		
		Monome m1 = new Monome(new Fraction(2,1), "x1");
		Monome m2 = new Monome(new Fraction(4,1), "x2");
		
		Monome m3 = new Monome(new Fraction(1,1), "x1");
		Monome m4 = new Monome(new Fraction(6,1), "x2");
		
		ContrainteExplicite x5 = new ContrainteExplicite(new Fraction(64,1), "x5");
		ContrainteExplicite x6 = new ContrainteExplicite(new Fraction(32,1), "x6");
		
		x5.ajouterMonome(m1);
		x5.ajouterMonome(m2);
		
		x6.ajouterMonome(m3);
		x6.ajouterMonome(m4);
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x5);
		contraintes.add(x6);
		
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m1);
		ec.ajouterMonome(m2);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		System.out.println(simp + "\n");
		simp.passageDico1();
		System.out.println(" ******* Passage Dico 1 *******\n");
		System.out.println(simp + "\n");
		simp.echanger("x5", "x2");
		//x5.echanger(m1);
		System.out.println(simp + "\n");

	}

}
