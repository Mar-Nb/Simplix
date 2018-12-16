package Vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.Historique;
import Modele.Simplexe;

public class PanelHistorique extends JPanel {
	
	private Historique historique;
	JLabel vide = new JLabel("L'historique est vide.",JLabel.CENTER);
	
	public PanelHistorique(){
		this.add(vide);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2, true), "Historique"));
	}
	
	public PanelHistorique(Historique histo) {
		this.setLayout(new GridLayout(3, 1));
		historique = histo;
		
		for(int i =0 ; i<historique.getListeSimplexe().size() ; i++) {
			this.add(this.labelSimplex(historique.getListeSimplexe().get(i)));
		}
		//this.setBorder(BorderFactory.createLineBorder(Color.RED,2, true));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2, true), "Historique"));
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
	
	public JLabel labelSimplex(Simplexe s) {
		JLabel lab = new JLabel(s.toString());
		return lab;
	}

}