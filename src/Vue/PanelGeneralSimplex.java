package Vue;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.Historique;

/** 
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelGeneralSimplex</i></h1>
 * <h2><code>public class PanelGeneralSimplex extends <span class='name'>JPanel</span></code></h2>
 * <p>Cette classe est le 3e conteneur principal de l'application. C'est le panel que l'utilisateur verra le plus. <br>
 * Elle contient un <code class='name'>PanelSimplex</code>, un <code class='name'>PanelHistorique</code> et un <code class='name'>Panelndications</code>.</p>
 * 
 * @see PanelSimplex
 * @see PanelHistorique
 * @see PanelIndications
 */
@SuppressWarnings("serial")
public class PanelGeneralSimplex extends JPanel{
	
	PanelSimplex panelSimp;
	PanelHistorique panelH;
	PanelIndications panelIndi;
	Historique historique;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelGeneralSimplex(<span class='name'>Historique</span> historique)</code></h2>
	 * <p>Met en place un BorderLayout contenant un <code class='name'>PanelSimplex</code> au centre, un <code class='name'>PanelHistorique</code> à droite, et un <code class='name'>PanelIndications</code> en bas.</p>
	 * 
	 * @param historique : (Historique)
	 * 
	 * @see PanelIndications
	 * @see PanelHistorique
	 * @see PanelSimplex
	 */
	public PanelGeneralSimplex(Historique historique) {
		this.setLayout(new BorderLayout(20,5));
		this.historique=historique;
		
		
		panelH = new PanelHistorique(historique);
		panelIndi = new PanelIndications();
		
		if(historique.getListeSimplexe().size() == 0) {
			panelSimp = new PanelSimplex();
			
		}
		else {
			panelSimp = new PanelSimplex(historique.getListeSimplexe().get(historique.getListeSimplexe().size()-1));
		}
		

		this.add(panelSimp,BorderLayout.CENTER);

		this.add(panelH, BorderLayout.EAST);
		
		this.add(panelIndi,BorderLayout.SOUTH);

		
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>getPanelSimp</i></h1>
	 * <h2><code>public PanelSimplex getPanelSimp()</code></h2>
	 * <p>Renvoie le champ <i>panelSimp</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelSimp : (PanelSimplex)
	 */
	public PanelSimplex getPanelSimp() {
		return panelSimp;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>getPanelIndi</i></h1>
	 * <h2><code>public PanelIndications getPanelIndi()</code></h2>
	 * <p>Renvoie le champ <i>panelIndi</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelIndi : (PanelIndications)
	 */
	public PanelIndications getPanelIndi() {
		return panelIndi;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelIndi</i></h1>
	 * <h2><code>public void setPanelIndi(PanelIndication panelIndi)</code></h2>
	 * <p>Définit le champ <i>panelIndi</i> avec le <code class='name'>PanelIndications</i> donné en paramètre.</p>
	 * 
	 * @param panelIndi : (PanelIndications)
	 */
	public void setPanelIndi(PanelIndications panelIndi) {
		this.panelIndi = panelIndi;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelIndi</i></h1>
	 * <h2><code>public void setPanelIndi(<span class='name'>String</span> enonce)</code></h2>
	 * <p>Change le texte du <code class='name'>PanelIndications</code>.</p>
	 * 
	 * @param enonce : (String)
	 */
	public void setPanelIndi(String enonce) {
		this.remove(panelIndi);
		panelIndi=new PanelIndications(enonce);
		this.add(panelIndi, BorderLayout.SOUTH);
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelSimp</i></h1>
	 * <h2><code>public void setPanelSimp(<span class='name'>PanelSimplex</span> panelSimp)</code></h2>
	 * <p>Remplace la valeur du champ <i>panelSimp</i> par celle passée en paramètre.</p>
	 * 
	 * @param panelSimp : (PanelSimplex)
	 */
	public void setPanelSimp(PanelSimplex panelSimp) {
		this.panelSimp = panelSimp;
	}


	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getPanelH</i></h1>
	 * <h2><code>public PanelHistorique getPanelH()</code></h2>
	 * <p>Renvoie le champ <i>panelH</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelH : (PanelHistorique)
	 */
	public PanelHistorique getPanelH() {
		return panelH;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelH</i></h1>
	 * <h2><code>public void setPanelH(<span class='name'>PanelHistorique</span> panelH)</code></h2>
	 * <p>Remplace la valeur du champ <i>panelSimp</i> par celle passée en paramètre.</p>
	 * 
	 * @param panelH : (PanelHistorique)
	 */
	public void setPanelH(PanelHistorique panelH) {
		this.panelH = panelH;
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

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(<span class='name'>Controleur</span> controleur)</code></h2>
	 * <p>Met le controleur donné en paramètre à l'écoute du <code class='name'>PanelSimplex</code> et du <code class='name'>PanelIndications</code>.</p>
	 * 
	 * @param controleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur controleur) {
		panelSimp.enregistreEcouteur(controleur);
		panelIndi.enregistreEcouteur(controleur);
	}
	
}

