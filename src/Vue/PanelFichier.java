package Vue;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>PanelFichier</i></h1>
 * <h2><code>public class PanelFichier extends JPanel</code></h2>
 * <p>Ce panel est le 2e conteneur principal de l'application. Il contient tous les panels ayant un rapport avec la création ou
 * le chargement d'un simplexe.</p>
 * 
 * @see PanelFormulaire
 * @see PanelChargerSimplexe
 */
@SuppressWarnings("serial")
public class PanelFichier extends JPanel{
	private PanelFormulaire panelFormulaire;
	private PanelChargerSimplexe panelCharger;
	private CardLayout gestionnaireDeCartes;

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelChoixMonomesContraintes()</code></h2>
	 * <p>Met en place un diaporama de 2 panels : <code>PanelFormulaire</code> et <code>PanelChargerSimplexe</code>.</p>
	 */
	public PanelFichier(){
		
		//Création des panel fils
		
		panelFormulaire =new PanelFormulaire();
		panelCharger=new PanelChargerSimplexe();
		
		//Layout
		
		gestionnaireDeCartes = new CardLayout(3,3);
		this.setLayout(gestionnaireDeCartes);
		
		//Ajout des Layout
		
		this.add(panelFormulaire, "Nouveau Simplexe");
		this.add(panelCharger, "Charger Simplexe");

	}
	

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getGestionnaireDeCartes</i></h1>
	 * <h2><code>public Cardlayout getGestionnaireDeCartes()</code></h2>
	 * <p>Renvoie le champ <i>gestionnaireDeCartes</i> de <i><b>this</b></i>.</p>
	 * @return gestionnaireDeCartes : (CardLayout)
	 */
	public CardLayout getGestionnaireDeCartes() {
		return gestionnaireDeCartes;
	}
	
	//EnregistreEcouteur qui appelle les enregistreEcouteurs des panelFils
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(Controleur parControleur)</code></h2>
	 * <p>Permet de mettre <i>parControleur</i> à l'écoute de tous les panels fils.</p>
	 * @param parControleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur parControleur){
		panelFormulaire.enregistreEcouteur(parControleur);
		panelCharger.enregistreEcouteur(parControleur);
		
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getPanelFormulaire</i></h1>
	 * <h2><code>public PanelFormulaire getPanelFormulaire()</code></h2>
	 * <p>Renvoie le champ <i>panelFormulaire</i> de <i><b>this</b></i>.</p>
	 * @return panelFormulaire : (PanelFormulaire)
	 */
	public PanelFormulaire getPanelFormulaire() {
		return panelFormulaire;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getPanelCharger</i></h1>
	 * <h2><code>public PanelChargerSimplexe getPanelCharger()</code></h2>
	 * <p>Renvoie le champ <i>panelCharger</i> de <i><b>this</b></i>.</p>
	 * @return panelCharger : (PanelChargerSimplexe)
	 */
	public PanelChargerSimplexe getPanelCharger() {
		return panelCharger;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>setPanelCharger</i></h1>
	 * <h2><code>public void setPanelCharger(PanelChargerSimplexe panelCharger)</code></h2>
	 * <p>Définit le champ <i>panelCharger</i> de <i><b>this</b></i> avec le <code>PanelChargerSimplexe</code> donné en paramètre.</p>
	 * @param panelCharger : (PanelChargerSimplexe)
	 */
	public void setPanelCharger(PanelChargerSimplexe panelCharger) {
		this.panelCharger = panelCharger;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>setPanelFormulaire</i></h1>
	 * <h2><code>public void setPanelFormulaire(PanelFormulaire panelFormulaire)</code></h2>
	 * <p>Défini le champ <i>panelFormulaire</i> de <i><b>this</b></i> avec le <code>PanelFormulaire</code> donné en paramètre.</p>
	 * @param panelFormulaire : (PanelFormulaire)
	 */
	public void setPanelFormulaire(PanelFormulaire panelFormulaire) {
		this.panelFormulaire = panelFormulaire;
	}
}
