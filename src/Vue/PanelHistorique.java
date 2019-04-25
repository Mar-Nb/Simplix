package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Modele.Historique;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelHistorique</i></h1>
 * <h2><code>public class PanelHistorique extends <span class='name'>JPanel</span></code></h2>
 * <p>Cette classe permet d'afficher à l'utilisateur tous les dictionnaires qu'il effectuera sous la forme suivante : </p><br>
 * <ul><li>Dictionnaire 0</li><hr>
 * <li>Dictionnaire 1</li><hr>
 * <li>Dictionnaire 2</li></ul>
 */
@SuppressWarnings("serial")
public class PanelHistorique extends JPanel {
	
	private Historique historique;
	public final Font police = new Font("Times New Roman", Font.PLAIN, 17);
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelHistorique()</code></h2>
	 * <p>Constructeur vide.</p>
	 */
	public PanelHistorique(){
		JLabel vide = new JLabel("L'historique est vide.",JLabel.CENTER);
		this.add(vide);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2, true), "Historique"));
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>PanelHistorique</i></h1>
	 * <h2><code>public PanelHistorique(<span class='name'>Historique</span> histo)</code></h2>
	 * <p>Met en place un GridLayout contenant un <code class='name'>JScrollPane</code> faisant défiler l'ensemble des <code class='name'>Simplexe</code> contenus dans 
	 * l'<code class='name'>Historique</code> passé en paramètre.</p>
	 * 
	 * @param histo : (Historique) Contient les dictionnaires du simplexe en cours
	 */
	public PanelHistorique(Historique histo) {
		this.setLayout(new GridLayout(6, 1));
		historique = histo;
		
		JPanel contenu = new JPanel();
		contenu.setLayout(new GridBagLayout());

		GridBagConstraints contrainte = new GridBagConstraints() ;
		contrainte.gridx=0;
		contrainte.gridy=0;
		contrainte.insets = new Insets(5,25,5,25);
		
		// On parcourt les dictionnaires de l'historique
		for(int i =0 ; i<histo.getListeSimplexe().size() ; i++) {
			JLabel simp = new JLabel("<html><head></head><body><p> Dictionnaire n°"+Integer.toString(i)+":</p>"
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
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getHistorique</i></h1>
	 * <h2><code>public Historique getHistorique()</code></h2>
	 * <p>Renvoie le champ <i>historique</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return historique : (Historique)
	 */
	public Historique getHistorique() {
		return historique;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setHistorique</i></h1>
	 * <h2><code>public void setHistorique(<span class='name'>Historique</span> historique)</code></h2>
	 * <p>Remplace la valeur du champ <i>historique</i> par celle passée en paramètre.</p>
	 * 
	 * @param historique : (Historique)
	 */
	public void setHistorique(Historique historique) {
		this.historique = historique;
	}
	
}