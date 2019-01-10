package Vue;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controleur.Controleur;

public class PanelIndications extends JPanel{

	JButton indice;
	public PanelIndications() {
		indice=new JButton("?");
		indice.setToolTipText("Quand vous ne savez pas quoi faire, on vous donne un indice");
		this.add(indice);
		this.add(new LabelIndications("Obtenir une Indication"));
	}
	
	public PanelIndications(String enonce) {
		removeAll();
		indice=new JButton("?");
		indice.setToolTipText("Quand vous ne savez pas quoi faire, on vous donne un indice");
		this.add(indice);
		this.add(new LabelIndications(enonce));
	}
	
	public void enregistreEcouteur(Controleur parControleur) {
		indice.setActionCommand("indice");
		indice.addActionListener(parControleur);
	}

}
