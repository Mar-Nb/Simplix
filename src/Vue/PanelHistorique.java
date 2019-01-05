package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Modele.Historique;
import Modele.Simplexe;

public class PanelHistorique extends JPanel {
	
	private Historique historique;
	
	
	public PanelHistorique(){
		JLabel vide = new JLabel("L'historique est vide.",JLabel.CENTER);
		this.add(vide);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2, true), "Historique"));
	}
	
	public PanelHistorique(Historique histo) {
		this.setLayout(new GridLayout(3, 1));
		historique = histo;
		
		JPanel contenu = new JPanel();
		contenu.setLayout(new GridBagLayout());

		GridBagConstraints contrainte = new GridBagConstraints() ;
		contrainte.gridx=0;
		contrainte.gridy=0;
		
		for(int i =0 ; i<histo.getListeSimplexe().size() ; i++) {
			contenu.add(new JLabel(histo.getListeSimplexe().get(i).toString()), contrainte);
			contrainte.gridy++;
		}

		JScrollPane scrollPane = new JScrollPane(contenu, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		this.add(scrollPane);
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