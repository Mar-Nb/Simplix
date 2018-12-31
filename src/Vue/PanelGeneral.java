package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Historique;
import Modele.Simplexe;

public class PanelGeneral extends JPanel implements ActionListener {
	String[] intitulesPanneaux = {"Fichier","Affichage", "Annuler", "Quitter", "?"};
	String[] itemsCreation = {"Nouveau Simplexe", "Charger Simplexe", "Enregistrer Simplexe"};
	private CardLayout gestionnaireCartes;
	Controleur controleur;
	private Historique historique;
	private PanelGeneralSimplex panelSimplex;
	private PanelFichier panelFichier;
	
	public PanelGeneral(){
		
		//Instantiation de la chronologie
		historique=new Historique(); 
		
		//Layout : Empilement de tous les panels
		gestionnaireCartes=new CardLayout(2,2);
		this.setLayout(gestionnaireCartes);
		
		//Ajout des deux panels empilés
		
		panelFichier=new PanelFichier();
		this.add(panelFichier, intitulesPanneaux[0]);
		panelSimplex = new PanelGeneralSimplex(historique);
		controleur= new Controleur(panelFichier, this);
		panelSimplex.enregistreEcouteur(controleur);
		this.add(panelSimplex, intitulesPanneaux[1]);
		
		
	}



	public PanelGeneralSimplex getPanelSimplex() {
		return panelSimplex;
	}



	public void setPanelSimplex(PanelGeneralSimplex panelSimplex) {
		this.panelSimplex = panelSimplex;
	}



	public PanelFichier getPanelFichier() {
		return panelFichier;
	}



	public void setPanelFichier(PanelFichier panelFichier) {
		this.panelFichier = panelFichier;
	}



	public Historique getHistorique() {
		return historique;
	}



	public void setHistorique(Historique historique) {
		
		this.historique=historique;
		panelSimplex=new PanelGeneralSimplex(historique);
		panelSimplex.enregistreEcouteur(controleur);
		this.add(panelSimplex, intitulesPanneaux[1]);
		gestionnaireCartes.show(this, intitulesPanneaux[1]);
	}



	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getActionCommand() == "Nouveau Simplexe"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelFichier.getGestionnaireDeCartes().show(panelFichier, itemsCreation[0]);
			//Montre d'abord le panelCreation puis get son cardLayout pour afficher le bon panel fils de panelCreation
		}
		
		if(evt.getActionCommand() == "Charger Simplexe"){
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelFichier.getGestionnaireDeCartes().show(panelFichier, itemsCreation[1]);
			//Montre d'abord le panelCreation puis get son cardLayout pour afficher le bon panel fils de panelCreation
		}
	
		else if(evt.getActionCommand() == "Annuler") {
			historique.etapePrecedente();
			this.setHistorique(historique);
		}
		
		else if(evt.getActionCommand() == "Affichage"){
			gestionnaireCartes.show(this, intitulesPanneaux[1]);
		}
		else if(evt.getActionCommand() == "Quitter"){
			
			JOptionPane confirmation=new JOptionPane();
		
			int code= confirmation.showConfirmDialog(null, "Voulez vous vraiment quitter?","Arret du programme",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(code== JOptionPane.OK_OPTION) {
			System.exit(code);
			} // Pop up avec confirmation du choix
			
		}
	}
}
