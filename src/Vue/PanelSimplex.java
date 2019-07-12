package Vue;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ContrainteExplicite;
import Modele.Monome;
import Modele.Simplexe;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelSimplex</i></h1>
 * <h2><code>public class PanelSimplex extends <span class='name'>JPanel</span></code></h2>
 * <p>Cette classe permet de faire apparaître un simplexe avec lequel l'utilisateur peut interagir.</p>
 */
@SuppressWarnings("serial")
public class PanelSimplex extends JPanel {
	
	private Simplexe simplexe;
	public GridBagConstraints gridLim = new GridBagConstraints() ;
	public final Font police = new Font("Times New Roman", Font.PLAIN, 20);
	
	JButton b;
	JButton[][] tabBoutonsInconnues; // Tableau contenant tous les boutons du panel
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelSimplex()</code></h2>
	 * <p>Construit un <code class='name'>PanelSimplex</code> vide.</p>
	 */
	public PanelSimplex() {
		tabBoutonsInconnues=new JButton[0][0];
		this.add(new JLabel("Panel Simplexe"),JLabel.CENTER);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelSimplex(<span class='name'>Simplexe</span> simp)</code></h2>
	 * <p>Met en place un panel avec des <code class='name'>JLabel</code> en guise de contrainte et des <code class='name'>JButton</code> en guise de variable.</p>
	 * 
	 * @param simp : (Simplexe)
	 */
	public PanelSimplex(Simplexe simp) {
		
		simplexe = simp;
		
		int nbContraintes = 0;
		int nbBoutons = 0;
		int positionSigne = 0;
		
		Box [] lignes = new Box[simplexe.getContraintes().size()];
		
		// Nombre de bouton = Nombre_de_contraintes x Nombre_de_monomes
		tabBoutonsInconnues=new JButton[simplexe.getContraintes().size()][simplexe.getFonctionEco().getMonomes().size()];
		
		this.setLayout(new GridBagLayout());
		
		gridLim.gridwidth = 1;
		gridLim.gridheight = 1;
		gridLim.insets = new Insets(10,0,10,5);
		gridLim.gridy = 0;
		gridLim.gridx = 0;

		// On parcourt les contraintes
		for(Iterator j = simplexe.getContraintes().iterator(); j.hasNext();) {
			positionSigne = 0;
			ContrainteExplicite ce = (ContrainteExplicite) j.next();
			
			lignes[nbContraintes] = Box.createHorizontalBox();
			JLabel lab = new JLabel(ce.getNom()+" =",JLabel.LEFT);
			lab.setFont(police);
			lignes[nbContraintes].add(lab);
			lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
			
			positionSigne++;
			
			// On parcourt les monomes de la contrainte en cours
			for(Object obj : ce.getMonomes().values()) {
				Monome m = (Monome) obj;
				String textLabel = "";
				
				//SIGNES
				if(m.getCoefficient().getNumerateur()>0 && positionSigne!=1) {
					textLabel+="+";
				}
				
				//COEFF
				if(Double.compare(m.getCoefficient().FMath(), 1)!=0 || Double.compare(m.getCoefficient().FMath(), -1)!=0 || m.getCoefficient().getNumerateur()!=0) {
					textLabel+=m.getCoefficient().toString();
				}
				
				if(m.getCoefficient().getNumerateur()!=0) {
					lab = new JLabel(textLabel);
					lab.setFont(police);
					lignes[nbContraintes].add(lab);
					lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
					positionSigne++;
				}
				
				//BOUTON
				
				if(!m.getInconnue().equals(" ") && m.getCoefficient().getNumerateur()!=0) {
					tabBoutonsInconnues[nbContraintes][nbBoutons] = new JButton(m.getInconnue());
					tabBoutonsInconnues[nbContraintes][nbBoutons].setToolTipText("Une variable hors base à échanger");
					tabBoutonsInconnues[nbContraintes][nbBoutons].setFont(police);
					lignes[nbContraintes].add(tabBoutonsInconnues[nbContraintes][nbBoutons]);
					lignes[nbContraintes].add(Box.createRigidArea(new Dimension(5,0)));
					nbBoutons++;
				}
				
				positionSigne++;
			}
			gridLim.gridy++;
			positionSigne = 0;
			nbBoutons=0;
			this.add(lignes[nbContraintes],gridLim);
			nbContraintes++;
		}
		
		gridLim.gridy++;
		positionSigne = 0;
		
		JLabel lab = new JLabel(simplexe.getFonctionEco().toString());
		lab.setFont(police);
		this.add(lab,gridLim);
		
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getSimplexe</i></h1>
	 * <h2><code>public Simplexe getSimplexe()</code></h2>
	 * <p>Renvoie le champ <i>simplexe</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return simplexe : (Simplexe)
	 */
	public Simplexe getSimplexe() {
		return simplexe;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setSimplexe</i></h1>
	 * <h2><code>public void setSimplexe(<span class='name'>Simplexe</span> simplexe)</code></h2>
	 * <p>Remplace la valeur du champ <i>simplexe</i> par celle passée en paramètre.</p>
	 * 
	 * @param simplexe : (Simplexe)
	 */
	public void setSimplexe(Simplexe simplexe) {
		this.simplexe = simplexe;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>getTabBoutonsInconnues</i></h1>
	 * <h2><code>public JButton[][] getTabBoutonsInconnues()</code></h2>
	 * <p>Renvoie le champ <i>tabBoutonsInconnues</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return tabBoutonsInconnues : (JButton[][])
	 */
	public JButton[][] getTabBoutonsInconnues() {
		return tabBoutonsInconnues;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setTabBoutonsInconnues</i></h1>
	 * <h2><code>public void setTabBoutonsInconnues(<span class='name>'JButton</span>[][] tabBoutonsInconnues)</code></h2>
	 * <p>Remplace la valeur du champ <i>tabBoutonsInconnues</i> par celle donnée en paramètre.</p>
	 * 
	 * @param tabBoutonsInconnues : (JButton[][])
	 */
	public void setTabBoutonsInconnues(JButton[][] tabBoutonsInconnues) {
		this.tabBoutonsInconnues = tabBoutonsInconnues;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(<span class='name'>Controleur</span> controleur)</code></h2>
	 * <p>Met le controleur donné en paramètre à l'écoute de tous les boutons du panel.</p>
	 * 
	 * @param controleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur controleur) {
		for(int i = 0; i < tabBoutonsInconnues.length; i++){
			for(int j = 0; j < tabBoutonsInconnues[i].length; j++){
				if(tabBoutonsInconnues[i][j]!=null) {
					tabBoutonsInconnues[i][j].setActionCommand("monomes "+Integer.toString(i));
					tabBoutonsInconnues[i][j].addActionListener(controleur);
				}
			}
		}
	}
	
	
}
