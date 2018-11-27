package Vue;

import java.awt.CardLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;

public class PanelChoixNombresMonomesContraintes extends JPanel {

	JComboBox <Integer> nbMonome = new JComboBox <Integer>();
	JComboBox <Integer> nbContraintes = new JComboBox <Integer>();
	Integer [] box = new Integer[10];
	
	private Integer nombreMonome;
	private Integer nombreContraintes;
	JButton ok;
	
	public PanelChoixNombresMonomesContraintes() {

		
		//On ajoute nbMonome, nbContrainte et leur label dans la partie Nord
		//du formulaire
	
		JLabel labelNb = new JLabel("Nombre de monomes : ", JLabel.CENTER);
		this.add(labelNb);
		for(int i=0; i<10; i++) {
			nbMonome.addItem(i+1);
			nbContraintes.addItem(i+1);
			box[i]=i+1;
		}
		

		this.add(nbMonome);
		JLabel labelNbContraintes = new JLabel("Nombre de contraintes : ", JLabel.CENTER);
		this.add(labelNbContraintes);
		this.add(nbContraintes);
		
		ok = new JButton("Ok");
		this.add(ok);
		
		
	}
	
	public void enregistreEcouteur(Controleur parControleur) {
		ok.setActionCommand("ok");
		ok.addActionListener(parControleur);
	}

	public JComboBox<Integer> getNbMonome() {
		return nbMonome;
	}

	public JComboBox<Integer> getNbContraintes() {
		return nbContraintes;
	}

	public Integer getNombreMonome() {
		return nombreMonome;
	}

	public Integer getNombreContraintes() {
		return nombreContraintes;
	}
	
}
