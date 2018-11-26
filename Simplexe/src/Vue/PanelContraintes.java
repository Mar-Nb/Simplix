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
	
	public PanelContraintes(Integer nombreMonome, Integer nombreContraintes) {
		
		int ligne = nombreContraintes;
		int colonne = nombreMonome;
		
		zonesEcrituresContraintes = new JTextField[ligne][colonne];
		zonesEcrituresFonctionEco=new JTextField[ligne];
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
		contrainte.gridy++;
		boutonCreer = new JButton("Creer");
		this.add(boutonCreer, contrainte);

	}
	
	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		for(int i =0;i<=zonesEcrituresContraintes.length;i++){
			for(int j=0;j<=zonesEcrituresContraintes[0].length;j++) {
				zonesEcrituresContraintes[i][j].addActionListener(controleur);
				zonesEcrituresContraintes[i][j].setActionCommand(Integer.toString(i)+"j"+Integer.toString(j));
			}
		}
		
		for(int i=0;i<=zonesEcrituresFonctionEco.length;i++) {
			zonesEcrituresFonctionEco[i].addActionListener(controleur);
			zonesEcrituresFonctionEco[i].setActionCommand("e"+Integer.toString(i));
		}
		
		for(int i=0;i<=zonesEcrituresValeursMaxi.length;i++) {
			zonesEcrituresValeursMaxi[i].addActionListener(controleur);
			zonesEcrituresValeursMaxi[i].setActionCommand("v"+Integer.toString(i));
		}
		
		boutonCreer.setActionCommand("Creer");
		boutonCreer.addActionListener(controleur);
		
	}

}
