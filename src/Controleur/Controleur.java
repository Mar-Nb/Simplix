package Controleur;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Fraction;
import Modele.Monome;
import Modele.Simplexe;
import Vue.PanelContraintes;
import Vue.PanelFormulaire;
import Vue.PanelGeneralSimplex;
import Vue.PanelHistorique;
import Vue.PanelSimplex;
import javax.swing.JButton;

public class Controleur implements ActionListener {
	private PanelFormulaire panelFormulaire;
	private PanelGeneralSimplex panelGS;
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	public Controleur(PanelFormulaire panelFormulaire, PanelGeneralSimplex panGS) {
		this.panelFormulaire=panelFormulaire;
		this.panelFormulaire.enregistreEcouteur(this);
		this.panelGS=panGS;
	}

	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getActionCommand().equals("Cr")) {
			
			JTextField[][] tabContraintes =panelFormulaire.getPanelC().getZonesEcrituresContraintes();
			JTextField[] tabLimites=panelFormulaire.getPanelC().getZonesEcrituresValeursMaxi();
			LinkedList contraintes=new LinkedList<ContrainteExplicite>();
			for(int i=0;i<tabContraintes.length;i++) {
				/*System.out.println(tabLimites[i].getText());
				System.out.println(panelFormulaire.getPanelC().getNombreMonome());*/
				ContrainteExplicite ce = new ContrainteExplicite(new Fraction(Integer.parseInt(tabLimites[i].getText()),1), "x"+Integer.toString(i+1+panelFormulaire.getPanelC().getNombreMonome()));
				for(int j=0;j<tabContraintes[0].length;j++) {
					Monome m = new Monome(new Fraction(Integer.parseInt(tabContraintes[i][j].getText()),1), "x"+Integer.toString(j+1));
					ce.ajouterMonome(m);
				}
				contraintes.add(ce);
			}
			
			
			FonctionEco fonctionEco = new FonctionEco();
			JTextField[] tabMonomesFonctionEco = panelFormulaire.getPanelC().getZonesEcrituresFonctionEco();
			for(int i=0;i<tabMonomesFonctionEco.length;i++) {
				Monome m = new Monome(new Fraction(Integer.parseInt(tabMonomesFonctionEco[i].getText()),1), "x"+Integer.toString(i+1));
				fonctionEco.ajouterMonome(m);
			}
			
			
			Simplexe simplexe = new Simplexe(contraintes, fonctionEco);
			simplexe.passageDico1();
			//System.out.println(simplexe.toString2());
			panelGS.getGeneral().remove(panelGS.getPanelSimp());
			panelGS.setPanelSimp(new PanelSimplex(simplexe));
			this.panelGS.enregistreEcouteur(this);
			
			/*contrainte.gridx = 0;
			contrainte.gridy = 0;
			contrainte.gridheight = 3;
			contrainte.gridwidth = 3;*/
			panelGS.getGeneral().add(panelGS.getPanelSimp(),BorderLayout.CENTER);
			panelGS.getHistorique().add(simplexe);
			panelGS.getGeneral().remove(panelGS.getPanelH());
			panelGS.setPanelH(new PanelHistorique(panelGS.getHistorique()));
			panelGS.getGeneral().add(panelGS.getPanelH(), BorderLayout.EAST);
			
			panelGS.getGestionnaire().show(panelGS, "Vue generale");
			
			//System.out.println(simplexe.toString());
			
		}
		
		if(evt.getActionCommand().equals("ok")) {

			PanelContraintes choixContraintesPanel = new PanelContraintes(panelFormulaire.getPanelCMC().getNbMonome().getItemAt(panelFormulaire.getPanelCMC().getNbMonome().getSelectedIndex()), panelFormulaire.getPanelCMC().getNbContraintes().getItemAt(panelFormulaire.getPanelCMC().getNbContraintes().getSelectedIndex()));
			panelFormulaire.setPanelC(choixContraintesPanel);
			panelFormulaire.enregistreEcouteurC(this);
			panelFormulaire.add(choixContraintesPanel, "Contraintes");
			panelFormulaire.getGestionnaireDeCartes().show(panelFormulaire, "Contraintes");
		}
		
		if(evt.getActionCommand().contains("monomes")){
			System.out.println("C'est un bouton.");
			JButton b = (JButton) evt.getSource();
			String variableBase = b.getText();
			String str = ""+b.getActionCommand().charAt(8);
			int indice = Integer.parseInt(str) ;
			JButton [][] temp = panelGS.getPanelSimp().getTabBoutonsInconnues();
		}
		
	}
	
}
