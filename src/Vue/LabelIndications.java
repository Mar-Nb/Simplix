package Vue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>LabelIndications</i></h1>
 * <h2><code>public class LabelIndications extends <span class='name'>JLabel</span></code></h2>
 */
@SuppressWarnings("serial")
public class LabelIndications extends JLabel {
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public LabelIndications(<span class='name'>String</span> str)</code></h2>
	 * <p>Construit un objet <code class='name'>LabelIndication</code> permettant l'affichage d'indice sur les échanges à effectuer pour l'utilisateur.</p>
	 * 
	 * @param str : (String)
	 */
	public LabelIndications(String str) {
		super(str);
		this.setHorizontalAlignment(CENTER);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

}