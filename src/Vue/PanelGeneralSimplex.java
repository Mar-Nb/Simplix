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
	
	public PanelGeneralSimplex(Historique historique) {
		this.setLayout(new BorderLayout());
		this.historique=historique;
		
		labelIndi = new LabelIndications("Indications");
		
		panelH = new PanelHistorique(historique);
		
		if(historique.getListeSimplexe().size() == 0) {
			panelSimp = new PanelSimplex();
			
		}
		else {
			panelSimp = new PanelSimplex(historique.getListeSimplexe().get(historique.getListeSimplexe().size()-1));
		}
		

		this.add(panelSimp,BorderLayout.CENTER);

		this.add(panelH, BorderLayout.EAST);
		
		this.add(labelIndi,BorderLayout.SOUTH);

		
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

	public void enregistreEcouteur(Controleur controleur) {
		panelSimp.enregistreEcouteur(controleur);
	}
	
}

