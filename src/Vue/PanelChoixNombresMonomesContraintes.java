package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>PanelChoixNombresMonomesContraintes</i></h1>
 * <h2><code>public class PanelChoixNombresMonomesContraintes etends JPanel</code></h2>
 * <p>Cette classe permet à l'utilisateur de choisir le nombre de contraintes et de monomes souhaité dans le Simplexe.</p>
 */
@SuppressWarnings("serial")
public class PanelChoixNombresMonomesContraintes extends JPanel {

	JComboBox <Integer> nbMonome = new JComboBox <Integer>();
	JComboBox <Integer> nbContraintes = new JComboBox <Integer>();
	Integer [] box = new Integer[10];
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	private Integer nombreMonome;
	private Integer nombreContraintes;
	JButton ok;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelChoixMonomesContraintes()</code></h2>
	 * <p> Ce constructeur met en place un formulaire contenant deux <code>JComboBox</code> pour désigner 
	 * le nombre de monome et de contrainte.</p>
	 */
	public PanelChoixNombresMonomesContraintes() {
		//On ajoute nbMonome, nbContrainte et leur label dans la partie Nord
		//du formulaire
		
		this.setLayout(new GridBagLayout());
		
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(20,10,20,10);
		
		JLabel labelTitre = new JLabel("Formulaire de création du Simplexe",JLabel.CENTER);
		contrainte.gridx = 0; contrainte.gridy = 0;
		contrainte.gridwidth = 1; contrainte.gridheight = 1;
		this.add(labelTitre, contrainte);
		
		JLabel labelNb = new JLabel("Nombre de monomes : ", JLabel.CENTER);
		contrainte.gridy = 1;
		this.add(labelNb, contrainte);
		
		for(int i=0; i<10; i++) {
			nbMonome.addItem(i+1);
			nbContraintes.addItem(i+1);
			box[i]=i+1;
		}

		contrainte.gridx = 1; contrainte.gridwidth = 2;
		this.add(nbMonome,contrainte);
		
		JLabel labelNbContraintes = new JLabel("Nombre de contraintes : ", JLabel.CENTER);
		contrainte.gridx = 0; contrainte.gridy = 2;
		contrainte.gridwidth = 1;
		this.add(labelNbContraintes,contrainte);
		
		contrainte.gridx = 1; contrainte.gridwidth = 2;
		this.add(nbContraintes,contrainte);
		
		ok = new JButton("Ok");
		contrainte.gridx = 0; contrainte.gridwidth = 3;
		contrainte.gridy = 3;
		contrainte.anchor = GridBagConstraints.CENTER;
		this.add(ok,contrainte);
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(Controleur parControleur)</code></h2>
	 * <p>Met l'objet <code>Controleur</code> donné en paramètre à l'écoute du bouton ok.</p>
	 * @param parControleur
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		ok.setActionCommand("ok");
		ok.addActionListener(parControleur);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getBouton</i></h1>
	 * <h2><code>public JButton getBouton()</code></h2>
	 * <p>Renvoie le champ <i>ok<i> de <i><b>this</b></i>.</p>
	 * @return ok : (JButton)
	 */
	public JButton getBouton() {
		return ok;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>viderFormulaire</i></h1>
	 * <h2><code>public void viderFormulaire()</code></h2>
	 * <p>Remet les <code>JComboBox</code> de ce panel à 0.</p>
	 */
	public void viderFormulaire() {
		nbMonome.setSelectedIndex(0);
		nbContraintes.setSelectedIndex(0);
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getNbMonome</i></h1>
	 * <h2><code>public JComboBox getNbMonome()</code></h2>
	 * <p>Renvoie la <code>JComboBox</code> <i>nbMonome</i>.</p>
	 * @return nbMonome : (JComboBox)
	 */
	public JComboBox<Integer> getNbMonome() {
		return nbMonome;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getNbContraintes</i></h1>
	 * <h2><code>public JComboBox getNbContraintes()</code></h2>
	 * <p>Renvoie la <code>JComboBox</code> <i>nbContraintes</i>.</p>
	 * @return nbContraintes : (JComboBox)
	 */
	public JComboBox<Integer> getNbContraintes() {
		return nbContraintes;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getNombreMonme</i></h1>
	 * <h2><code>public Integer getNombreMonome()</code></h2>
	 * <p>Renvoie le champ <i>nombreMonome</i> de <i><b>this</b></i>.</p>
	 * @return nombreMonome : (Integer)
	 */
	public Integer getNombreMonome() {
		return nombreMonome;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getNombreContraintes</i></h1>
	 * <h2><code>public Integer getNombreContraintes()</code></h2>
	 * <p>Renvoie le champ <i>nombreContraintes</i> de <i><b>this</b></i>.</p>
	 * @return nombreContraintes : (Integer)
	 */
	public Integer getNombreContraintes() {
		return nombreContraintes;
	}
	
}
