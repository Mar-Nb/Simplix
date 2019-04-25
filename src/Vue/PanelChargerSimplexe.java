package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelChargerSimplexe</i></h1>
 * <h2><code>public class PanelChargerSimplexe extends <span class='name'>JPanel</span></code></h2>
 * <p>Cette classe permet à l'utilisateur de charger un Simplexe déjà existant.</p>
 */
@SuppressWarnings("serial")
public class PanelChargerSimplexe extends JPanel{
	private JButton parcourir;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelChargerSimplexe()</code></h2>
	 * <p>Ce constructeur ajoute au panel un bouton qui ouvre un <code class='name'>JFileChooser</code> 
	 * pour que l'utilisateur puisse sélectionner son fichier.</p>
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
	 * Met le controleur en paramètre à l'écoute du bouton Charger 
	 * @param parControleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur parControleur){
		parcourir.addActionListener(parControleur);
	}
}
