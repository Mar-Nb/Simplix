package Modele;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestSimplexe {

	public static void main(String[] args) {
		
		
		Monome m1 = new Monome(new Fraction(2,1), "x1");
		Monome m2 = new Monome(new Fraction(4,1), "x2");
		Monome m3 = new Monome(new Fraction(5,1), "x3");
		Monome m4 = new Monome(new Fraction(7,1), "x4");
		
		Monome m5 = new Monome(new Fraction(1,1), "x1");
		Monome m6 = new Monome(new Fraction(1,1), "x2");
		Monome m7 = new Monome(new Fraction(2,1), "x3");
		Monome m8 = new Monome(new Fraction(2,1), "x4");
		
		Monome m9 = new Monome(new Fraction(1,1), "x1");
		Monome m10 = new Monome(new Fraction(2,1), "x2");
		Monome m11 = new Monome(new Fraction(3,1), "x3");
		Monome m12 = new Monome(new Fraction(3,1), "x4");
		
		Monome m13 = new Monome(new Fraction(7,1), "x1");
		Monome m14 = new Monome(new Fraction(9,1), "x2");
		Monome m15= new Monome(new Fraction(18,1), "x3");
		Monome m16= new Monome(new Fraction(17,1), "x4");
		
		ContrainteExplicite x5 = new ContrainteExplicite(new Fraction(42,1), "x5");
		ContrainteExplicite x6 = new ContrainteExplicite(new Fraction(17,1), "x6");
		ContrainteExplicite x7 = new ContrainteExplicite(new Fraction(24,1), "x7");
		
		x5.ajouterMonome(m1);
		x5.ajouterMonome(m2);
		x5.ajouterMonome(m3);
		x5.ajouterMonome(m4);
		
		x6.ajouterMonome(m5);
		x6.ajouterMonome(m6);
		x6.ajouterMonome(m7);
		x6.ajouterMonome(m8);
		
		x7.ajouterMonome(m9);
		x7.ajouterMonome(m10);
		x7.ajouterMonome(m11);
		x7.ajouterMonome(m12);
	
		LinkedList contraintes= new LinkedList();
		contraintes.add(x5);
		contraintes.add(x6);
		contraintes.add(x7);
		
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m13);
		ec.ajouterMonome(m14);
		ec.ajouterMonome(m15);
		ec.ajouterMonome(m16);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		simp.passageDico1();
		/*System.out.println(" ******* FIRST SIMPLEX ******* \n");
		System.out.println(simp.toString2() + "\n");
		System.out.println(" ******* EXCHANGING OF X1 AND X6 *******\n");
		simp.echanger("x7", "x3");
		System.out.println(simp.toString2() + "\n");
		System.out.println(simp.echangeJudicieux());*/
		
		JFrame f = new JFrame("essai");
		f.setSize(500, 500);
		
		GridBagConstraints g = new GridBagConstraints();
		g.gridy = 0;
		g.ipady = 10;
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		
		Box [] lignes = new Box[simp.getContraintes().size()];
		
		// Nombre de bouton = Nombre_de_contraintes x Nombre_de_monomes
		JButton [][] tabBoutonsInconnues = new JButton[simp.getContraintes().size()][simp.getFonctionEco().getMonomes().size()];
		int nbContraintes = 0;
		int nbBoutons = 0;
		
		for(Object o : simp.getContraintes()) {
			ContrainteExplicite ce = (ContrainteExplicite) o;
			
			lignes[nbContraintes] = Box.createHorizontalBox();
			JLabel lab = new JLabel(ce.getNom()+" =", JLabel.LEFT);
			lignes[nbContraintes].add(lab);
			lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
			
			for(Object obj : ce.getMonomes().values()) {
				Monome m = (Monome) obj;
				String texte = "";
				
				if (m.getCoefficient().getNumerateur() > 0) {
					texte += "+";
				}
				
				//COEFF
				if(Double.compare(m.getCoefficient().FMath(), 1)!=0 || Double.compare(m.getCoefficient().FMath(), -1)!=0 || m.getCoefficient().getNumerateur()!=0) {
					texte += m.getCoefficient().toString();
				}
				
				if(m.getCoefficient().getNumerateur()!=0) {
					lab = new JLabel(texte);
					lignes[nbContraintes].add(lab);
					lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
				}
				
				if(!m.getInconnue().equals(" ") && m.getCoefficient().getNumerateur()!=0) {
					tabBoutonsInconnues[nbContraintes][nbBoutons] = new JButton(m.getInconnue());
					tabBoutonsInconnues[nbContraintes][nbBoutons].setToolTipText("Une variable hors base ?? ??changer");
					lignes[nbContraintes].add(tabBoutonsInconnues[nbContraintes][nbBoutons]);
					lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
					nbBoutons++;
				}
			}
			
			nbBoutons=0;
			pan.add(lignes[nbContraintes], g);
			//panneau.add(lignes[nbContraintes]);
			nbContraintes++;
			g.gridy++;
		}
		
		
		//pan.add(panneau);
		f.add(pan);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
