package Vue;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.Controleur;

public class PanelIndications extends JPanel{

	JButton indice;
	public PanelIndications() {
		indice=new JButton("?");
		this.add(indice);
		this.add(new LabelIndications("Obtenir une Indication"));
	}
	public PanelIndications(String enonce) {
		removeAll();
		this.add(new LabelIndications(enonce));
	}
	public void enregistreEcouteur(Controleur parControleur) {
		indice.setActionCommand("indice");
		indice.addActionListener(parControleur);
	}

}
