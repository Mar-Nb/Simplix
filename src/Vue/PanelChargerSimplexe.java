package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Controleur.Controleur;

public class PanelChargerSimplexe extends JPanel{
	private JButton parcourir;
	
	/**
	 * Construit un objet PanelChargerSimplexe permettant � l'utilisateur de charger un Simplexe d�j� existant
	 */
	public PanelChargerSimplexe() {
		
		//GridBagLayout
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainteEvenement = new GridBagConstraints();
		contrainteEvenement.insets = new Insets(3,3,3,3);
		
		//Cr�ation d'une etiquette
	
		JLabel nomDuFichier=new JLabel("Choisissez un fichier :");
		
		

		
		//Bouton et ActionCommand
		parcourir=new JButton("Parcourir");	
		parcourir.setActionCommand("Charger");
		

		
		
		//Ajout des �l�ments dans le GridBagLayout
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=0;
		this.add(nomDuFichier,contrainteEvenement);
		

		
		contrainteEvenement.gridx=0;
		contrainteEvenement.gridy=1;
		contrainteEvenement.insets = new Insets(20,3,3,3);
		this.add(parcourir,contrainteEvenement);
		
	}
	
	
	
	
	//ActionListener sur le bouton ajouter
	/**
	 * Met le controleur en param�tre � l'�coute du bouton Charger 
	 * @param parControleur
	 */
	public void enregistreEcouteur(Controleur parControleur){
		parcourir.addActionListener(parControleur);
	}
}
