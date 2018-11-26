package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Monome;
import Modele.Simplexe;
import Vue.FenetreMereSimplex;
import Vue.PanelContraintes;
import Vue.PanelFormulaire;

public class Controleur implements ActionListener {
	private PanelFormulaire panelFormulaire;
	
	public Controleur(PanelFormulaire panelFormulaire) {
		this.panelFormulaire=panelFormulaire;
		this.panelFormulaire.enregistreEcouteur(this);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getActionCommand().equals("Cr")) {
			
			JTextField[][] tabContraintes =panelFormulaire.getPanelC().getZonesEcrituresContraintes();
			JTextField[] tabLimites=panelFormulaire.getPanelC().getZonesEcrituresValeursMaxi();
			LinkedList contraintes=new LinkedList<ContrainteExplicite>();
			for(int i=0;i<tabContraintes.length;i++) {
				ContrainteExplicite ce = new ContrainteExplicite(Integer.parseInt(tabLimites[i].getText()), "x"+Integer.toString(i+panelFormulaire.getPanelCMC().getNombreMonome()));
				for(int j=0;j<tabContraintes[0].length;j++) {
					Monome m = new Monome(Integer.parseInt(tabContraintes[i][j].getText()), "x"+Integer.toString(j));
					ce.ajouterMonome(m);
				}
				contraintes.add(ce);
				
			}
			
			FonctionEco fonctionEco = new FonctionEco();
			JTextField[] tabMonomesFonctionEco = panelFormulaire.getPanelC().getZonesEcrituresFonctionEco();
			for(int i=0;i<tabMonomesFonctionEco.length;i++) {
				Monome m = new Monome(Integer.parseInt(tabMonomesFonctionEco[i].getText()), "x"+Integer.toString(i));
				fonctionEco.ajouterMonome(m);
			}
			
			Simplexe simplexe = new Simplexe(contraintes, fonctionEco);
			System.out.println(simplexe.toString());
			
		}
		
		if(evt.getActionCommand().equals("ok")) {

			PanelContraintes choixContraintesPanel = new PanelContraintes(panelFormulaire.getPanelCMC().getNbMonome().getItemAt(panelFormulaire.getPanelCMC().getNbMonome().getSelectedIndex()), panelFormulaire.getPanelCMC().getNbContraintes().getItemAt(panelFormulaire.getPanelCMC().getNbContraintes().getSelectedIndex()));
			panelFormulaire.enregistreEcouteur(this);
			panelFormulaire.add(choixContraintesPanel, "Contraintes");
			panelFormulaire.getGestionnaireDeCartes().show(panelFormulaire, "Contraintes");
		}
		
	}
	
}
