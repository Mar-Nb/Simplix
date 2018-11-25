package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.PanelFormulaire;

public class Controleur implements ActionListener {
	private PanelFormulaire panelFormulaire;
	
	public Controleur(PanelFormulaire panelFormulaire) {
		this.panelFormulaire=panelFormulaire;
		this.panelFormulaire.enregistreEcouteur(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
