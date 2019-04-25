package Vue;

import java.awt.CardLayout;
import javax.swing.JPanel;

import Controleur.Controleur;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelFormulaire</i></h1>
 * <h2><code>public class PanelFormulaire extends <span class='name'>JPanel</span></code></h2>
 * <p>Ce panel contient les deux formulaires de création de simplexe de l'application : <code class='name'>PanelChoixNombresMonomesContraintes</code> et
 * <code class='name'>PanelContraintes</code>.<br><br> Il est contenu par la classe <code class='name'>PanelFichier</code>.</p>
 * 
 * @see PanelFichier
 */
@SuppressWarnings("serial")
public class PanelFormulaire extends JPanel{

	private CardLayout gestionnaireDeCartes ;
	PanelContraintes panelC;
	PanelChoixNombresMonomesContraintes panelCMC;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelFormulaire()</code></h2>
	 * <p>Met en place un CardLayout contenant un <code class='name'>PanelChoixNombresMonomesContraintes</code>.</p>
	 */
	public PanelFormulaire() {
		/*LAYOUT*/
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		panelCMC = new PanelChoixNombresMonomesContraintes();
		this.add(panelCMC, "ChoixMonomesContraintes");
	
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(Controleur controleur)</code></h2>
	 * <p>Met le paramètre <code class='name'>controleur</code> à l'écoute du champ <i>panelCMC</i> de <i><b>this</b></i>.</p>
	 * 
	 * @param controleur : (Controleur)
	 */
	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub

		panelCMC.enregistreEcouteur(controleur);
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>viderFormulaire</i></h1>
	 * <h2><code>public void viderFormulaire()</code></h2>
	 * <p>Appelle les méthodes viderFormulaire des champs <i>panelC</i> et <i>panelCMC</i> de <i><b>this</b></i>.</p>
	 */
	public void viderFormulaire() {
		panelC.viderFormulaire();
		panelCMC.viderFormulaire();
		gestionnaireDeCartes.show(this, "ChoixMonomesContraintes");
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>enregistreEcouteur</i></h1>
	 * <h2><code>public void enregistreEcouteur(Controleur controleur)</code></h2>
	 * <p>Met le paramètre <code class='name'>controleur</code> à l'écoute du champ <i>panelC</i> de <i><b>this</b></i>.</p>
	 * 
	 * @param controleur : (Controleur)
	 */
	public void enregistreEcouteurC(Controleur controleur) {
		panelC.enregistreEcouteur(controleur);
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getGestionnaireDeCartes</i></h1>
	 * <h2><code>public CardLayout getGestionnaireDeCartes()</code></h2>
	 * <p>Renvoie le champ <i>gestionnaireDeCartes</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return gestionnaireDeCartes : (CardLayout)
	 */
	public CardLayout getGestionnaireDeCartes() {
		return gestionnaireDeCartes;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getPanelC</i></h1>
	 * <h2><code>public PanelContraintes getPanelC()</code></h2>
	 * <p>Renvoie le champ <i>panelC</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelC : (PanelContraintes)
	 */
	public PanelContraintes getPanelC() {
		return panelC;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>setPanelC</i></h1>
 	 * <h2><code>public void setPanelC(PanelContraintes panC)</code></h2>
	 * <p>Définit le champ <i>panelC</i> de <i><b>this</b></i> avec le <code class='name'>PanelContraintes</code> donné en param�tre.</p>
	 * 
	 * @param panC : (PanelContraintes)
	 */
	public void setPanelC(PanelContraintes panC) {
		this.panelC = panC;
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>getPanelCMC</i></h1>
	 * <h2><code>public PanelChoixNombresMonomesContraintes getPanelCMC()</code></h2>
	 * <p>Renvoie le champ <i>panelCMC</i> de <i><b>this</b></i>.</p>
	 * 
	 * @return panelCMC : (PanelChoixNombresMonomesContraintes)
	 */
	public PanelChoixNombresMonomesContraintes getPanelCMC() {
		return panelCMC;
	}

}