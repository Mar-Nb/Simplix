package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Fraction;
import Modele.Historique;
import Modele.Monome;
import Modele.Simplexe;

public class PanelGeneralSimplex extends JPanel{
	
	PanelSimplex panelSimp;
	LabelIndications labelIndi;
	PanelHistorique panelH;
	Historique historique;
	
	private CardLayout cardL = new CardLayout(5,5);
	PanelFormulaire panF;
	Controleur controleur;
	//JPanel general = new JPanel(new GridBagLayout());
	JPanel general = new JPanel(new BorderLayout(5,5));
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	public PanelGeneralSimplex() {
		this.setLayout(cardL);
		
		panelSimp = new PanelSimplex();
		labelIndi = new LabelIndications("Indications");
		panF = new PanelFormulaire();
		LinkedList<Simplexe> listeS = new LinkedList<Simplexe>();
		/*listeS.add(InitializeSimplexe());
		listeS.add(InitializeSimplexe());
		listeS.add(InitializeSimplexe());*/
		historique = new Historique(listeS);
		panelH = new PanelHistorique();
		
		/*panelSimp = panSp;
		labelIndi = labInd;
		panelH = panH;
		historique = histo;*/
		
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,30,10,30);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		contrainte.gridheight = 2;
		contrainte.gridwidth = 3;
		general.add(panelSimp,BorderLayout.CENTER);
		
		contrainte.gridx = 4;
		contrainte.gridy = 0;
		contrainte.gridheight = 3;
		contrainte.gridwidth = 2;
		general.add(panelH, BorderLayout.EAST);
		
		contrainte.gridx = 1;
		contrainte.gridy = 3;
		contrainte.gridheight = 2;
		contrainte.gridwidth = 3;
		general.add(labelIndi,BorderLayout.SOUTH);
		
		this.add(general,"Vue generale");
		this.add(panF, "formulaire");
		
		cardL.show(this, "formulaire");
		controleur = new Controleur(panF,this);
		
	}
	
	public PanelSimplex getPanelSimp() {
		return panelSimp;
	}

	public void setPanelSimp(PanelSimplex panelSimp) {
		this.panelSimp = panelSimp;
	}

	public LabelIndications getLabelIndi() {
		return labelIndi;
	}

	public void setLabelIndi(LabelIndications labelIndi) {
		this.labelIndi = labelIndi;
	}

	public PanelHistorique getPanelH() {
		return panelH;
	}

	public void setPanelH(PanelHistorique panelH) {
		this.panelH = panelH;
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public GridBagConstraints getContrainte() {
		return contrainte;
	}

	public void setContrainte(GridBagConstraints contrainte) {
		this.contrainte = contrainte;
	}
	
	public void enregistreEcouteur(Controleur controleur) {
		panelSimp.enregistreEcouteur(controleur);
	}
	
	public CardLayout getGestionnaire() {
		return cardL;
	}
	
	public JPanel getGeneral() {
		return general;
	}

	public static Simplexe InitializeSimplexe() {
		Monome m1 = new Monome(new Fraction(2,1), "x1");
		Monome m2 = new Monome(new Fraction(3,1), "x2");
		Monome m3 = new Monome(new Fraction(-2,1), "x3");
		FonctionEco ec = new FonctionEco();
		ec.ajouterMonome(m1);
		ec.ajouterMonome(m2);
		ec.ajouterMonome(m3);
		LinkedList l = new LinkedList();
		l.add(m1);l.add(m2);l.add(m3);
		
		ContrainteExplicite x4 = new ContrainteExplicite(new Fraction(23,1), "x4");
		((Monome) l.get(0)).setCoefficient(new Fraction(8,1));
		
		LinkedList l2 = new LinkedList();
		l2.add(m1);l2.add(m2);l2.add(m3);
		ContrainteExplicite x5 = new ContrainteExplicite(new Fraction(28,1), "x5");
		ContrainteExplicite x6 = new ContrainteExplicite(new Fraction(23,1), "x6");
		
		LinkedList contraintes= new LinkedList();
		contraintes.add(x4);contraintes.add(x5);contraintes.add(x6);
		
		Simplexe simp = new Simplexe(contraintes,ec);
		return simp;
	}

}

