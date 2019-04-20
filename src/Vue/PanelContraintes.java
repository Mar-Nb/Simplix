package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>PanelContraintes</i></h1>
 * <h2><code>public class PanelContraintes extends JPanel</code></h2>
 * <p> Cette classe dépend de la classe <i>PanelChoixMonomesContraintes</i> pour se construire. Elle sert 
 * de formulaire dans lequel l'utilisateur rentre toutes les valeurs des monomes de chaque contrainte et de 
 * la fonction économique.</p>
 */
@SuppressWarnings("serial")
public class PanelContraintes extends JPanel {
	
	
	JButton boutonCreer;
	Integer [] box = new Integer[10];
	JTextField[][]zonesEcrituresContraintes;
	JTextField[] zonesEcrituresFonctionEco;
	JTextField[] zonesEcrituresValeursMaxi;
	int nombreMonome;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelContraintes(Integer nombreMonome, Integer nombreContraintes)</code></h2>
	 * <p>Met en place un formulaire de <i>nombreContraintes</i> lignes et de <i>nombreMonome</i> colonnes.<br>
	 * Ce panel permet à l'utilisateur de choisir les valeurs des coefficients de chaque monome et de la fonction économique.</p>
	 * @param nombreMonome : (Integer)
	 * @param nombreContraintes : (Integer)
	 */
	public PanelContraintes(Integer nombreMonome, Integer nombreContraintes) {
		this.nombreMonome=nombreMonome;
		int ligne = nombreContraintes;
		int colonne = nombreMonome;

		zonesEcrituresContraintes = new JTextField[ligne][colonne];
		zonesEcrituresFonctionEco=new JTextField[colonne];
		zonesEcrituresValeursMaxi=new JTextField[ligne];
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainte=new GridBagConstraints();
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,20,10,20);
		
		for(int i=0; i<10; i++) {
			box[i]=i+1;
		}
		
		for(int i=0;i<ligne;i++) {
			contrainte.gridx = 0; contrainte.gridy = i;
			contrainte.gridheight = 1; contrainte.gridwidth = 1;
			
			this.add(new JLabel("x"+Integer.toString(colonne+1+i)+" = ",JLabel.CENTER),contrainte);
			for(int j=0;j<colonne;j++) {
				contrainte.gridx++; contrainte.gridy = i;
				zonesEcrituresContraintes[i][j]=new JTextField(2);
				this.add(zonesEcrituresContraintes[i][j],contrainte);
				contrainte.gridx++;
				if(j==colonne-1) {
					this.add(new JLabel("x"+Integer.toString(j+1)), contrainte);
				}
				else {
					this.add(new JLabel("x"+Integer.toString(j+1)+ "  +  "), contrainte);
				}
				
				
			}
			contrainte.gridx++;
			this.add(new JLabel("<="), contrainte);
			contrainte.gridx++;
			zonesEcrituresValeursMaxi[i]=new JTextField(5);
			this.add(zonesEcrituresValeursMaxi[i], contrainte);
		}
		
		contrainte.gridx =0;
		contrainte.gridy++;
		
		/*FONCTION ECO*/
		this.add(new JLabel("z = "), contrainte);
		contrainte.gridx++;
		for(int k=0;k<colonne;k++) {
			zonesEcrituresFonctionEco[k]=new JTextField(4);
			this.add(zonesEcrituresFonctionEco[k], contrainte);
			
			contrainte.gridx++;
			if(k==colonne-1) {
				this.add(new JLabel("x"+Integer.toString(k+1)), contrainte);
			}
			else {
				this.add(new JLabel("x"+Integer.toString(k+1)+ "  +  "), contrainte);
			}
			contrainte.gridx++;
		}
		
		contrainte.gridx =1;
		contrainte.gridy+=3;
		contrainte.anchor = GridBagConstraints.CENTER;
		boutonCreer = new JButton("Cr�er");
		this.add(boutonCreer, contrainte);

	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>viderFormulaire</i></h1>
	 * <h2><code>public void viderFormulaire()</code></h2>
	 * <p>Met tout les <code>JTextField</code> à <code><b>null</b></code>.</p>
	 */
	public void viderFormulaire() {
		
		for(int i=0; i<zonesEcrituresContraintes.length; i++) {
			for(int j=0; j<zonesEcrituresContraintes[0].length;j++){
				zonesEcrituresContraintes[i][j].setText("");
			}
		}
		
		for(int i=0;i<zonesEcrituresFonctionEco.length;i++) {
			zonesEcrituresFonctionEco[i].setText("");
		}
		for(int i=0;i<zonesEcrituresValeursMaxi.length;i++) {
			zonesEcrituresValeursMaxi[i].setText("");
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getNombreMonome</i></h1>
	 * <h2><code>public int getNombreMonome()</code></h2>
	 * </p>Renvoie le champ <i>nombreMonome</i> de <i><b>this</b></i>.</p>
	 * @return nombreMonome : (Integer)
	 */
	public int getNombreMonome() {
		return nombreMonome;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>setNombreMonome</i></h1>
	 * <h2><code>public void setNombreMonome(int nombreMonome)</code></h2>
	 * <p>Définit le champ <i>nombreMonome</i> avec la valeur fournit en paramètre.</p>
	 * @param nombreMonome : (Integer)
	 */
	public void setNombreMonome(int nombreMonome) {
		this.nombreMonome = nombreMonome;
	}

	/**
	 * Met le Controleur en param�tre � l'�coute du bouton boutonCreer
	 * @param Controleur parControleur
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		boutonCreer.setActionCommand("Cr");
		boutonCreer.addActionListener(parControleur);
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>desenregistreEcouteur</i></h1>
	 * <h2><code>public void desenregistreEcouteur()</code></h2>
	 * <p>Enlève l'objet <code>Controleur</code> fourni en paramètre des objets à l'écoute du bouton <i>boutonCreer</i>.</p>
	 * @param parControleur : (Controleur)
	 */
	public void desenregistreEcouteur(Controleur parControleur) {
		boutonCreer.removeActionListener(parControleur);
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getZonesEcrituresContraintes</i></h1>
	 * <h2><code>public JTextField[][] getZonesEcrituresContraintes()</code></h2>
	 * <p>Renvoie le champ <i>zonesEcrituresContraintes</i> de <i><b>this</b></i>.</p>
	 * @return zonesEcrituresContraintes : (JTextField [][])
	 */
	public JTextField[][] getZonesEcrituresContraintes() {
		return zonesEcrituresContraintes;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getZonesEcrituresFonctionEco</i></h1>
	 * <h2><code>public JTextField[] getZonesEcrituresFonctionEco()</code></h2>
	 * <p>Renvoie le champ <i>zonesEcrituresFonctionEco</i> de <i><b>this</b></i>.</p>
	 * @return zonesEcrituresFonctionEco : (JTextField [])
	 */
	public JTextField[] getZonesEcrituresFonctionEco() {
		return zonesEcrituresFonctionEco;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getZonesEcrituresValeursMaxi</i></h1>
	 * <h2><code>public JTextField[] getZonesEcrituresValeursMaxi()</code></h2>
	 * <p>Renvoie le champ <i>zonesEcrituresValeursMaxi</i> de <i><b>this</b></i>.</p>
	 * @return zoneEcrituresValeursMaxi : (JTextField [])
	 */
	public JTextField[] getZonesEcrituresValeursMaxi() {
		return zonesEcrituresValeursMaxi;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>getBouton</i></h1>
	 * <h2><code>public JButton getBouton()</code></h2>
	 * <p>Renvoie le champ <i>boutonCreer</i> de <i><b>this</b></i>.</p>
	 * @return JButton boutonCreer
	 */
	public JButton getBouton() {
		return boutonCreer;
	}

}
