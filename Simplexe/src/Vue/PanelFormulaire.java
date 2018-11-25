package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Monome;

public class PanelFormulaire extends JPanel implements ActionListener{
	
	JPanel choixNbMonomePanel;
	PanelContraintes choixContraintesPanel;
	JComboBox <Integer> nbMonome = new JComboBox <Integer>();
	JComboBox <Integer> nbContraintes = new JComboBox <Integer>();
	Integer [] box = new Integer[10];
	private CardLayout gestionnaireDeCartes ;
	
	private Integer nombreMonome;
	private Integer nombreContraintes;
	
	public PanelFormulaire() {
		
		/*LAYOUT*/
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		//On ajoute nbMonome, nbContrainte et leur label dans la partie Nord
		//du formulaire
		choixNbMonomePanel = new JPanel();
		choixNbMonomePanel.setLayout(new GridBagLayout());

		
		JLabel labelNb = new JLabel("Nombre de monomes : ", JLabel.CENTER);
		choixNbMonomePanel.add(labelNb);
		for(int i=0; i<10; i++) {
			nbMonome.addItem(i+1);
			nbContraintes.addItem(i+1);
			box[i]=i+1;
		}
		

		choixNbMonomePanel.add(nbMonome);
		JLabel labelNbContraintes = new JLabel("Nombre de contraintes : ", JLabel.CENTER);
		choixNbMonomePanel.add(nbContraintes);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		choixNbMonomePanel.add(ok);
		
		this.add(choixNbMonomePanel, "NombresDeMonomes");
		
	
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

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		// TODO Auto-generated method stub
		if(parEvt.getActionCommand().equals("ok")) {
			nombreMonome = nbMonome.getItemAt(nbMonome.getSelectedIndex());
			nombreContraintes=nbContraintes.getItemAt(nbContraintes.getSelectedIndex());
			choixContraintesPanel = new PanelContraintes(nombreMonome, nombreContraintes);
			this.add(choixContraintesPanel, "Contraintes");
			gestionnaireDeCartes.show(this, "Contraintes");
		}
	}
	
	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		choixContraintesPanel.enregistreEcouteur(controleur);
		
	}

	

}