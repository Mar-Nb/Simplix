package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controleur.Controleur;
import Modele.GenerePdf;
import Modele.Historique;
import Modele.LectureEcriture;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelGeneral</i></h1>
 * <h2><code>public class PanelGeneral extends JPanel implements ActionListener</code></h2>
 * <p>Cette classe est le conteneur principal de l'application.<br> Il contient les conteneurs principaux <code class='name'>PanelFichier</code>
 * et <code class='name'>PanelGeneralSimplex</code>.</p>
 * 
 * @see PanelGeneralSimplex
 * @see PanelFichier
 */
@SuppressWarnings("serial")
public class PanelGeneral extends JPanel implements ActionListener {
	
	String[] intitulesPanneaux = {"Fichier","Affichage", "Annuler", "Quitter", "?"};
	String[] itemsCreation = {"Nouveau Simplexe", "Charger Simplexe", "Enregistrer", "Enregistrer sous", "Mode Demo"};
	private CardLayout gestionnaireCartes;
	Controleur controleur;
	private Historique historique;
	private File fichierEnregistrement;
	private PanelGeneralSimplex panelSimplex;
	private PanelFichier panelFichier;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelGeneral()</code></h2>
	 * <p>Met en place un CardLayout contenant un <code class='name'>PanelFichier</code> et un <code class='name'>PanelGeneralSimplex</code>. Instancie un controleur à l'écoute
	 * du <code class='name'>PanelFichier</code> et de <i><b>this</b></i>.</p>
	 */
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

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>getPanelSimplex</i></h1>
	 * <h2><code>public PanelGeneralSimplex getPanelSimplex()</code></h2>
	 * <p>Renvoie le champ <i>panelSimplex</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelSimplex : (PanelGeneralSimplex)
	 */
	public PanelGeneralSimplex getPanelSimplex() {
		return panelSimplex;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelSimplex</i></h1>
	 * <h2><code>public void setPanelSimplex(<span class='name'>PanelGeneralSimplex</span> panelSimplex)</code></h2>
	 * <p>Remplace le <i>panelGeneralSimplex</i> du champ <i>panelSimplex</i> par un nouveau panel passé en paramètre.</p>
	 * 
	 * @param panelSimplex : (PanelGeneralSimplex)
	 */
	public void setPanelSimplex(PanelGeneralSimplex panelSimplex) {
		this.panelSimplex = panelSimplex;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getPanelFichier</i></h1>
	 * <h2><code>public PanelFichier getPanelFichier()</code></h2>
	 * <p>Renvoie le champ <i>panelFichier</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelFichier : (PanelFichier)
	 */
	public PanelFichier getPanelFichier() {
		return panelFichier;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelFichier</i></h1>
	 * <h2><code>public void setPanelFichier(<span class='name'>PanelFichier</span> panelFichier)</code></h2>
	 * <p>Remplace la valeur du champ <i>panelFichier</i> par celle donnée en paramètre.</p>
	 * 
	 * @param panelFichier : (PanelFichier)
	 */
	public void setPanelFichier(PanelFichier panelFichier) {
		this.panelFichier = panelFichier;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>getHistorique</i></h1>
	 * <h2><code>public Historique getHistorique()</code></h2>
	 * <p>Renvoie le champ <i>historique</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return historique : (Historique)
	 */
	public Historique getHistorique() {
		return historique;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>miseAJourIndication</i></h1>
	 * <h2><code>public void miseAjourIndication(<span class='name'>String</span> message)</code></h2>
	 * <p>Change le message que contient le <code class='name'>PanelIndication</code> du <code class='name'>PanelGeneralSimplex</code>.</p>
	 * 
	 * @param message : (String)
	 */
	public void miseAJourIndication(String message) {
		panelSimplex.setPanelIndi(message);
		panelSimplex.getPanelIndi().enregistreEcouteur(controleur);
		this.add(panelSimplex, intitulesPanneaux[1]);
		gestionnaireCartes.show(this, intitulesPanneaux[1]);
		
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setHistorique</i></h1>
	 * <h2><code>public void setHistorique(<span class='name'>Historique</span> historique)</code></h2>
	 * <p>Remplace la valeur du champ <i>historique</i> par passée en paramètre. Met ensuite à jour le <code class='name'>PanelGeneralSimplex</code>.</p>
	 * 
	 * @param historique : (Historique)
	 */
	public void setHistorique(Historique historique) {
		
		this.historique=historique;
		panelSimplex=new PanelGeneralSimplex(historique);
		panelSimplex.enregistreEcouteur(controleur);
		this.add(panelSimplex, intitulesPanneaux[1]);
		gestionnaireCartes.show(this, intitulesPanneaux[1]);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>miseAJourEnregistrement</i></h1>
	 * <h2><code>public void miseAJourEnregistrement()</code></h2>
	 * <p>Recharge un nouveau panelFichier.</p>
	 */
	
	public void miseAJourEnregistrement() {
		panelFichier=new PanelFichier();
		panelFichier.enregistreEcouteur(controleur);
		this.add(panelFichier, intitulesPanneaux[0]);
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>actionPerformed</i></h1>
	 * <h2><code>public void actionPerformed(<span class='name'>ActionEvent</span> evt)</code></h2>
	 * <p>Permet d'être à l'écoute de tous les boutons de la barre de menu.</p>
	 */
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getActionCommand() == "Nouveau Simplexe"){
			// Montre d'abord le panelCreation puis get son cardLayout pour afficher le bon panel fils de panelCreation
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelFichier.getGestionnaireDeCartes().show(panelFichier, itemsCreation[0]);
		}
		
		if(evt.getActionCommand() == "Charger Simplexe"){
			// Montre d'abord le panelCreation puis get son cardLayout pour afficher le bon panel fils de panelCreation
			gestionnaireCartes.show(this, intitulesPanneaux[0]);
			panelFichier.getGestionnaireDeCartes().show(panelFichier, itemsCreation[1]);
		}
	
		else if(evt.getActionCommand() == "Annuler") {
			historique.etapePrecedente();
			this.setHistorique(historique);
		}
		
		else if(evt.getActionCommand() == "Enregistrer") {
			if(fichierEnregistrement == null) {
				enregistrement(false);
			} else {
				LectureEcriture.ecriture(fichierEnregistrement, historique);
			}
		}
		
		else if(evt.getActionCommand() == "Enregistrer sous") {
			enregistrement(false);
		}
		
		else if(evt.getActionCommand() == "Mode Demo") {
			new FenetreDemo();
		}
		
		else if(evt.getActionCommand() == "Affichage"){
			gestionnaireCartes.show(this, intitulesPanneaux[1]);
		}
		
		else if(evt.getActionCommand() == "PDF") {
			if (historique != null) {
				enregistrement(true);
			} else {
				JOptionPane.showMessageDialog(null, "Aucun simplexe défini", "Action impossible", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else if(evt.getActionCommand() == "Quitter"){
			
			int code= JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ?","Arrêt du programme",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(code== JOptionPane.OK_OPTION) {
				SwingUtilities.getWindowAncestor(this).dispose();
			} // Pop up avec confirmation du choix
			
		}
		
		else if(evt.getActionCommand() == "?") {
			JOptionPane.showMessageDialog(null, "Cette application vous permet de manipuler des Simplexes.\n"
					+ "Pour créer ou charger un simplexe, déroulez le menu Fichier et sélectionnez une option.\n"
					+ "Pour effectuer des échanges de variables, cliquez sur les boutons dans votre simplexe.\n"
					+ "Pour obtenir des indications quant à l'échange le plus judicieux, appuyez sur le bouton ? dans l'Affichage", "Aide", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public File getFichierEnregistrement() {
		return fichierEnregistrement;
	}
	
	public void setFichierEnregistrement(File fichierEnregistrement) {
		this.fichierEnregistrement = fichierEnregistrement;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>enregistrement</i></h1>
	 * <h2><code>private void enregistrement(<span class='name'>boolean</span> isPDF)</code></h2>
	 * <p>Effectue les enregistrements de fichiers PDF ou .ser.</p>
	 * @param isPDF
	 */
	private void enregistrement (boolean isPDF) {
		JFileChooser fichier = new JFileChooser(); // Pour que l'utilisateur choisisse là où il veut crée son fichier
		fichier.setAcceptAllFileFilterUsed(false);
		fichier.setFileHidingEnabled(true);
		fichier.setCurrentDirectory(new File(System.getProperty("user.home"))); // Par défaut on se place dans le répertoire utilisateur
		FileNameExtensionFilter filtre = null;
		
		if (isPDF) {
			filtre = new FileNameExtensionFilter("Format PDF","pdf"); // On ne montre que les fichiers au format PDF
		} else {
			filtre = new FileNameExtensionFilter("Format Simplexe", "ser"); // On veut que le fichier soit uniquement au format pdf
		}
		
		fichier.setFileFilter(filtre);
		
		// On regarde si l'utilisateur a bien choisi un fichier
		int resultat = fichier.showSaveDialog(null);
		
		if(resultat == JFileChooser.APPROVE_OPTION) { // Si c'est bon
			String nomFichier = fichier.getSelectedFile().getName();
			if (isPDF) {
				// On vérifie que le fichier possède l'extension .pdf à la fin
				if (nomFichier.endsWith(".pdf")) {
					new GenerePdf(this.historique, fichier.getSelectedFile());
				} else {
					// Pas d'extension ? On l'ajoute !
					new GenerePdf(this.historique, new File(fichier.getSelectedFile().getAbsolutePath().concat(".pdf")));
				}
			} else {
				// On vérifie que le fichier possède l'extension .ser à la fin
				if (nomFichier.endsWith(".ser")) {
					LectureEcriture.ecriture(fichier.getSelectedFile(), this.historique);
					fichierEnregistrement = fichier.getSelectedFile();
				} else {
					// Pas d'extension ? On l'ajoute !
					LectureEcriture.ecriture(new File(fichier.getSelectedFile().getAbsolutePath().concat(".ser")), this.historique);
					fichierEnregistrement = new File(fichier.getSelectedFile().getAbsolutePath().concat(".ser"));
				}
			}
		} else if(resultat == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(null, "Erreur, mauvais fichier sélectionné","Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}
}
