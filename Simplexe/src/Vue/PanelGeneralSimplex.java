package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Historique;
import Modele.Monome;
import Modele.Simplexe;

public class PanelGeneralSimplex extends JPanel{
	
	PanelSimplex panelSimp;
	LabelIndications labelIndi;
	PanelHistorique panelH;
	Historique historique;
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	public PanelGeneralSimplex() {
		this.setLayout(new GridBagLayout());
		
		panelSimp = new PanelSimplex(InitializeSimplexe());
		labelIndi = new LabelIndications("Indications");
		LinkedList<Simplexe> listeS = new LinkedList<Simplexe>();
		listeS.add(InitializeSimplexe());
		listeS.add(InitializeSimplexe());
		listeS.add(InitializeSimplexe());
		historique = new Historique(listeS);
		panelH = new PanelHistorique(historique);
		
		/*panelSimp = panSp;
		labelIndi = labInd;
		panelH = panH;
		historique = histo;*/
		
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,30,10,30);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridheight = 3;
		contrainte.gridwidth = 3;
		this.add(panelSimp,contrainte);
		
		contrainte.gridx = 6;
		contrainte.gridy = 0;
		contrainte.gridheight = 5;
		contrainte.gridwidth = 2;
		this.add(panelH, contrainte);
		
		contrainte.gridx = 0;
		contrainte.gridy = 4;
		contrainte.gridheight = 2;
		contrainte.gridwidth = 3;
		this.add(labelIndi, contrainte);
	}
	
	public static Simplexe InitializeSimplexe() {
		Monome m1 = new Monome(2, "x1");
		Monome m2 = new Monome(3, "x2");
		Monome m3 = new Monome(-2, "x3");
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m1);
		ec.ajouterMonome(m2);
		ec.ajouterMonome(m3);
		LinkedList l = new LinkedList();
		l.add(m1);l.add(m2);l.add(m3);
		
		ContrainteExplicite x4 = new ContrainteExplicite(23, "x4");
		((Monome) l.get(0)).setCoefficient(8);
		
		LinkedList l2 = new LinkedList();
		l2.add(m1);l2.add(m2);l2.add(m3);
		ContrainteExplicite x5 = new ContrainteExplicite(28, "x5");
		ContrainteExplicite x6 = new ContrainteExplicite(23, "x6");
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x4);contraintes.add(x5);contraintes.add(x6);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		return simp;
	}

}

