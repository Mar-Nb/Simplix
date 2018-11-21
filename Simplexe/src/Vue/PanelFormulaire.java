package Vue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Monome;

public class PanelFormulaire extends JPanel{
	
	JPanel center, sud;
	JComboBox <Integer> nbMonome = new JComboBox <Integer>();
	Integer [] box = new Integer[10];
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	JLabel labelNb = new JLabel("Nombre de monome : ", JLabel.CENTER);
	LinkedList <Monome> liste = new LinkedList <Monome>();
	LinkedList <ContrainteExplicite> contraintes = new LinkedList <ContrainteExplicite>();
	
	FonctionEco ec = new FonctionEco();
	
	public PanelFormulaire() {
		this.setLayout(new BorderLayout(5,50));
		
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,10,10,10);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		//On ajoute nbMonome, nbContrainte et leur label dans la partie Nord
		//du formulaire
		center = new JPanel();
		center.setLayout(new GridBagLayout());
		
		contrainte.gridx = 1; contrainte.gridy = 0;
		contrainte.gridwidth = 2; contrainte.gridheight = 1;
		center.add(labelNb,contrainte);
		for(int i=0; i<10; i++) {
			nbMonome.addItem(i+1);
			box[i]=i+1;
		}
		
		contrainte.gridx = 3; contrainte.gridy = 0;
		contrainte.gridheight = 1; contrainte.gridwidth = 2;
		center.add(nbMonome,contrainte);
		
		JButton ok = new JButton("Ok");
		contrainte.gridx = 2; contrainte.gridy = 1;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		center.add(ok, contrainte);
		
		this.add(center, BorderLayout.CENTER);
		
		//Une fois que l'utilisateur a choisi le nombre de monome et de contrainte,
		//on affiche le bon nombre de JComboBox
		
		sud = new JPanel();
		/*Partie à mettre en place dans le controleur ou l'actionPerformed
		
		int ligne = nbMonome.getItemAt(nbMonome.getSelectedIndex());
		int colonne = nbMonome.getItemAt(nbMonome.getSelectedIndex())+1;
		sud.setLayout(new GridBagLayout());
		for(int i=0;i<ligne;i++) {
			contrainte.gridx = 0; contrainte.gridy = i;
			contrainte.gridheight = 1; contrainte.gridwidth = 1;
			sud.add(new JLabel("Contrainte : ",JLabel.CENTER),contrainte);
			for(int j=0;j<colonne;j++) {
				contrainte.gridx = j+1; contrainte.gridy = i;
				contrainte.gridheight = 1; contrainte.gridwidth = 2;
				sud.add(new JComboBox<Integer>(box),contrainte);
			}
		}*/
		
		//Version temporaire
		int ligne=3,colonne=4;
		sud.setLayout(new GridBagLayout());
		for(int i=0;i<ligne;i++) {
			contrainte.gridx = 0; contrainte.gridy = i;
			contrainte.gridheight = 1; contrainte.gridwidth = 1;
			sud.add(new JLabel("Contrainte : ",JLabel.CENTER),contrainte);
			for(int j=0;j<colonne;j++) {
				contrainte.gridx = j+1; contrainte.gridy = i;
				contrainte.gridheight = 1; contrainte.gridwidth = 1;
				sud.add(new JComboBox<Integer>(box),contrainte);
			}
		}
		
		sud.add(new JButton("Créer"));
		this.add(sud, BorderLayout.SOUTH);
	}
	
	public static void main(String [] args) {
		JFrame f = new JFrame("test");
		PanelFormulaire p = new PanelFormulaire();
		f.add(p);
		f.setVisible(true);
		f.setSize(500, 500);
		f.setLocation(200, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}