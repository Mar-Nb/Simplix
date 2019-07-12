package Controleur;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Fraction;
import Modele.Historique;
import Modele.LectureEcriture;
import Modele.Monome;
import Modele.Simplexe;
import Vue.PanelContraintes;
import Vue.PanelFichier;
import Vue.PanelGeneral;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>Controleur</i></h1>
 * <h2><code>public class Controleur implements <span class='name'>ActionListener</span></code></h2>
 * <p>Cette classe permet de mettre à l'écoute les deux principaux conteneurs de l'application : <i class='name'><code>PanelFichier</code></i>
 * et <i class='name'><code>PanelGeneral</code></i>.</p>
 * 
 * @see PanelFichier
 * @see PanelGeneral
 */
public class Controleur implements ActionListener {
	private PanelGeneral panelG;
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	private PanelFichier panelFichier;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public Controleur(<span class='name'>PanelFichier</span> panelFichier, <span class='name'>PanelGeneral</span> panelSimplex)</code></h2>
	 * <p>Ce controleur est à l'écoute de tous les objets d'interaction des panels contenues par <span class='name'>PanelFichier</span> et <span class='name'>PanelGeneral</span> 
	 * sauf ceux possédant leur propre <i>actionPerformed()</i>.</p>
	 * 
	 * @param panelFichier : (PanelFichier)
	 * @param panelSimplex : (PanelGeneral)
	 */
	public Controleur(PanelFichier panelFichier, PanelGeneral panelSimplex) {
		// TODO Auto-generated constructor stub
		this.panelFichier=panelFichier;
		this.panelFichier.enregistreEcouteur(this);
		this.panelG=panelSimplex;
		
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>actionPerformed</i></h1>
	 * <h2><code>public Controleur(<span class='name'>ActionEvent</span> evt)</code></h2>
	 * <p>Permet de gérer les choix de l'utilisateur lors de son utilisation du programme Simplexe à partir du démarrage du programme.</p>
	 * 
	 * @param evt : (ActionEvent) Un événement correspondant au choix de l'utilisateur
	 */
	public void actionPerformed(ActionEvent evt) {
		
		// Bouton se situant dans le panelContrainte
		if(evt.getActionCommand().equals("Cr")) {
			
			JTextField[][] tabContraintes =panelFichier.getPanelFormulaire().getPanelC().getZonesEcrituresContraintes();
			JTextField[] tabLimites=panelFichier.getPanelFormulaire().getPanelC().getZonesEcrituresValeursMaxi();
			LinkedList<ContrainteExplicite> contraintes=new LinkedList<ContrainteExplicite>();
			
			// Boucle qui parcourt le formulaire pour récupérer les monomes du simplexe entré par l'utilisateur
			for(int i=0;i<tabContraintes.length;i++) {
				if(tabLimites[i].getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuillez entrer des coefficients valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				ContrainteExplicite ce = new ContrainteExplicite(new Fraction(Integer.parseInt(tabLimites[i].getText()),1), "x"+Integer.toString(i+1+panelFichier.getPanelFormulaire().getPanelC().getNombreMonome()));
				for(int j=0;j<tabContraintes[0].length;j++) {
					if(tabContraintes[i][j].getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer des coefficients valides", "Erreur", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Monome m = new Monome(new Fraction(Integer.parseInt(tabContraintes[i][j].getText()),1), "x"+Integer.toString(j+1));
					ce.ajouterMonome(m);
				}
				contraintes.add(ce);
			}
			
			// Boucle qui parcourt le formulaire pour récupérer les monomes de la fonction éco entrés par l'utilisateur
			FonctionEco fonctionEco = new FonctionEco();
			JTextField[] tabMonomesFonctionEco = panelFichier.getPanelFormulaire().getPanelC().getZonesEcrituresFonctionEco();
			for(int i=0;i<tabMonomesFonctionEco.length;i++) {
				if(tabMonomesFonctionEco[i].getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Veuillez entrer des coefficients valides", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Monome m = new Monome(new Fraction(Integer.parseInt(tabMonomesFonctionEco[i].getText()),1), "x"+Integer.toString(i+1));
				fonctionEco.ajouterMonome(m);
			}
			
			// Définition du simplexe + ajout du premier dico dans l'historique
			Simplexe simplexe = new Simplexe(contraintes, fonctionEco);
			simplexe.passageDico1();
			Historique histo = new Historique();
			histo.add(simplexe);
			panelG.setHistorique(histo);
			panelG.setFichierEnregistrement(null);
			panelFichier.getPanelFormulaire().viderFormulaire();
			
			
		}
		
		// Bouton se situant dans le panelChoixMonomesContraintes
		if(evt.getActionCommand().equals("ok")) {

			// Création du formulaire panelContrainte à partir des valeurs de ce panel
			PanelContraintes choixContraintesPanel = new PanelContraintes(panelFichier.getPanelFormulaire().getPanelCMC().getNbMonome().getItemAt(panelFichier.getPanelFormulaire().getPanelCMC().getNbMonome().getSelectedIndex()), panelFichier.getPanelFormulaire().getPanelCMC().getNbContraintes().getItemAt(panelFichier.getPanelFormulaire().getPanelCMC().getNbContraintes().getSelectedIndex()));
			panelFichier.getPanelFormulaire().setPanelC(choixContraintesPanel);
			panelFichier.getPanelFormulaire().enregistreEcouteurC(this);
			panelFichier.getPanelFormulaire().add(choixContraintesPanel, "Contraintes");
			panelFichier.getPanelFormulaire().getGestionnaireDeCartes().show(panelFichier.getPanelFormulaire(), "Contraintes");
			
			this.panelFichier.requestFocusInWindow();
		}
		
		// Bouton du panelSimplexe
		if(evt.getActionCommand().contains("monomes")){
			JButton b = (JButton) evt.getSource();
			String str = ""+b.getActionCommand().charAt(8); // On récupère le n° du bouton
			int indice = Integer.parseInt(str) ; // Le n° est l'indice du bouton, sa position
			String horsBaseindice= ((ContrainteExplicite)panelG.getPanelSimplex().getPanelSimp().getSimplexe().getContraintes().get(indice)).getNom();
			Simplexe temp = new Simplexe(panelG.getPanelSimplex().getPanelSimp().getSimplexe());
			temp.echanger(horsBaseindice, b.getText());
			Historique tempHisto = new Historique(panelG.getHistorique());
			tempHisto.add(temp);
			panelG.setHistorique(tempHisto);
			
		}
		
		// Bouton se situant dans le panelChargerSimplexe
		if(evt.getActionCommand().equals("Charger")) {
			
			JFileChooser fichier = new JFileChooser(); // Pour que l'utilisateur choisisse là  où il veut créer son fichier
			fichier.setCurrentDirectory(new File(System.getProperty("user.home"))); // Par défaut on se place dans le répertoire utilisateur
			FileNameExtensionFilter filtre = new FileNameExtensionFilter("Format Simplexe", "ser");// On veut que le fichier soit uniquement au format pdf
			fichier.setFileFilter(filtre);
			fichier.setAcceptAllFileFilterUsed(false);
			fichier.setFileHidingEnabled(true);
			
			// On regarde si l'utilisateur a bien choisi un fichier
			int resultat = fichier.showSaveDialog(null);
			
			if(resultat == JFileChooser.APPROVE_OPTION && fichier.getSelectedFile().getName().contains(".ser")) {// Si c'est bon
				
				panelG.getPanelSimplex().remove(panelG.getPanelSimplex().getPanelH());
				panelG.setHistorique((Historique) LectureEcriture.lecture(fichier.getSelectedFile()));
				panelG.getPanelSimplex().getPanelH().setHistorique(panelG.getHistorique());
				
				panelG.getPanelSimplex().add(panelG.getPanelSimplex().getPanelH(),BorderLayout.EAST);
				panelG.setFichierEnregistrement(fichier.getSelectedFile());
				
				
			} else if(resultat == JFileChooser.ERROR_OPTION) {
				fichier.cancelSelection();
				fichier.setVisible(false);
				JOptionPane.showMessageDialog(null, "Erreur, mauvais fichier sélectionné","Erreur",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// Bouton se situant dans le panelIndications
		if(evt.getActionCommand().equals("indice") && panelG.getPanelSimplex().getPanelSimp().getSimplexe() != null) {
			panelG.miseAJourIndication(panelG.getPanelSimplex().getPanelSimp().getSimplexe().echangeJudicieux());
		} else if (evt.getActionCommand().equals("indice")) {
			// Pas de simplexe, pas d'indice
			JOptionPane.showMessageDialog(null, "Aucun simplexe défini", "Action impossible", JOptionPane.ERROR_MESSAGE);
		}

	}
	
}
