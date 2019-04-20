package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>PanelIndications</i></h1>
 * <h2><code>public class PanelIndications extends JPanel</code></h2>
 * <p>Cette classe permet de fournir des indices sur la résolution du simplexe.<br><br>
 * <i>Il faut noter que les indications ne sont pas toujours exactes, pour des raisons pédagogiques.</i></p>
 */
@SuppressWarnings("serial")
public class PanelIndications extends JPanel{

	JButton indice;
	GridBagConstraints contrainte = new GridBagConstraints();
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelIndications()</code></h2>
	 * <p>Constructeur de base du <code>PanelIndications</code>.</p>
	 */
	public PanelIndications() {
		this.setLayout(new GridBagLayout());
		contrainte.insets = new Insets(15,5,15,5);
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		indice=new JButton("?");
		indice.setToolTipText("Quand vous ne savez pas quoi faire, on vous donne un indice");
		this.add(indice,contrainte);
		contrainte.gridx++;
		this.add(new LabelIndications("Obtenir une Indication"),contrainte);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelIndications(String enonce)</code></h2>
	 * <p>Met en place un <i><b>this</b></i> avec pour texte <code>enonce</code>.</p>
	 * @param enonce : (String)
	 */
	public PanelIndications(String enonce) {
		this.setLayout(new GridBagLayout());
		removeAll();
		contrainte.insets = new Insets(15,5,15,5);
		contrainte.gridx = 0;
		contrainte.gridy = 0;
		indice=new JButton("?");
		indice.setToolTipText("Quand vous ne savez pas quoi faire, on vous donne un indice");
		this.add(indice,contrainte);
		contrainte.gridx++;
		this.add(new LabelIndications(enonce),contrainte);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(Controleur parControleur)</code></h2>
	 * <p>Met le controleur donné en paramètre à l'écoute du bouton de ce panel.</p>
	 * @param parControleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		indice.setActionCommand("indice");
		indice.addActionListener(parControleur);
	}

}
