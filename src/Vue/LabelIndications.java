package Vue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>LabelIndications</i></h1>
 * <h2><code>public class LabelIndications extends JLabel</code></h2>
 */
@SuppressWarnings("serial")
public class LabelIndications extends JLabel {
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public LabelIndications(String str)</code></h2>
	 * <p>Construit un objet <code>LabelIndication</code> permettant l'affichage d'indice sur les échanges à effectuer pour l'utilisateur.</p>
	 * @param str : (String)
	 */
	public LabelIndications(String str) {
		super(str);
		this.setHorizontalAlignment(CENTER);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

}