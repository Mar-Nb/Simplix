package Vue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.Controleur;

public class PanelContraintes extends JPanel {
	
	
	JButton boutonCreer;
	Integer [] box = new Integer[10];
	JTextField[][]zonesEcrituresContraintes;
	JTextField[] zonesEcrituresFonctionEco;
	JTextField[] zonesEcrituresValeursMaxi;
	int nombreMonome;
	
	public PanelContraintes(Integer nombreMonome, Integer nombreContraintes) {
		this.nombreMonome=nombreMonome;
		int ligne = nombreContraintes;
		int colonne = nombreMonome;

		zonesEcrituresContraintes = new JTextField[ligne][colonne];
		zonesEcrituresFonctionEco=new JTextField[colonne];
		zonesEcrituresValeursMaxi=new JTextField[ligne];
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contrainte=new GridBagConstraints();
		
		for(int i=0; i<10; i++) {
			box[i]=i+1;
		}
		
		for(int i=0;i<ligne;i++) {
			contrainte.gridx = 0; contrainte.gridy = i;
			contrainte.gridheight = 1; contrainte.gridwidth = 1;
			
			this.add(new JLabel("Contrainte : ",JLabel.CENTER),contrainte);
			for(int j=0;j<colonne;j++) {
				contrainte.gridx = j+1; contrainte.gridy = i;
				zonesEcrituresContraintes[i][j]=new JTextField(Integer.toString(j+1),2);
				this.add(zonesEcrituresContraintes[i][j],contrainte);
				
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
		for(int k=0;k<colonne;k++) {
			zonesEcrituresFonctionEco[k]=new JTextField("eco"+Integer.toString(k),4);
			this.add(zonesEcrituresFonctionEco[k], contrainte);
			contrainte.gridx++;
		}
		
		contrainte.gridx =1;
		contrainte.gridy+=3;
		boutonCreer = new JButton("Créer");
		this.add(boutonCreer, contrainte);

	}
	
	public int getNombreMonome() {
		return nombreMonome;
	}

	public void setNombreMonome(int nombreMonome) {
		this.nombreMonome = nombreMonome;
	}

	public void enregistreEcouteur(Controleur parControleur) {
		boutonCreer.setActionCommand("Cr");
		boutonCreer.addActionListener(parControleur);
	}
	
	public void desenregistreEcouteur(Controleur parControleur) {
		boutonCreer.removeActionListener(parControleur);
	}

	public JTextField[][] getZonesEcrituresContraintes() {
		return zonesEcrituresContraintes;
	}

	public JTextField[] getZonesEcrituresFonctionEco() {
		return zonesEcrituresFonctionEco;
	}

	public JTextField[] getZonesEcrituresValeursMaxi() {
		return zonesEcrituresValeursMaxi;
	}

}
