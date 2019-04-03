package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import Modele.Historique;
import Modele.Simplexe;

public class PanelHistorique extends JPanel {
	
	private Historique historique;
	public final Font police = new Font("Times New Roman", Font.PLAIN, 17);
	
	/**
	 * Constructeur pour un historique vide
	 */
	public PanelHistorique(){
		JLabel vide = new JLabel("L'historique est vide.",JLabel.CENTER);
		this.add(vide);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2, true), "Historique"));
	}
	
	/**
	 * Constructeur affichant les simplexes de l'historique passé en paramètre dans le panel. La mise en forme est faite en HTM%L.
	 * @param histo : Historique contenant les dictionnaires du simplexe en cours
	 */
	public PanelHistorique(Historique histo) {
		this.setLayout(new GridLayout(3, 1));
		historique = histo;
		
		JPanel contenu = new JPanel();
		contenu.setLayout(new GridBagLayout());

		GridBagConstraints contrainte = new GridBagConstraints() ;
		contrainte.gridx=0;
		contrainte.gridy=0;
		contrainte.insets = new Insets(5,25,5,25);
		
		// On parcourt les dictionnaires de l'historique
		for(int i =0 ; i<histo.getListeSimplexe().size() ; i++) {
			JLabel simp = new JLabel("<html><head></head><body><p> Dictionnaire n�"+Integer.toString(i)+":</p>"
			+histo.getListeSimplexe().get(i).toString()+"</body></html>");
			
			simp.setFont(police);
			contenu.add(simp, contrainte);
			contrainte.gridy++;
		}

		JScrollPane scrollPane = new JScrollPane(contenu, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
	}

	/**
	 * Getter qui renvoie l'historique du panel
	 * @return historique
	 */
	public Historique getHistorique() {
		return historique;
	}

	/**
	 * Setter qui remplace l'historique du panelHistorique par celui passé en paramètre
	 * @param historique
	 */
	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
	
}