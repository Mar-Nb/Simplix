package Vue;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class LabelIndications extends JLabel {
	
	/**
	 * Construit un objet LabelIndication (qui extends JLabel) permettant l'affichage d'indices sur les �changes � effectuer pour l'utilisateur
	 * @param String str
	 * 
	 */
	public LabelIndications(String str) {
		super(str);
		this.setHorizontalAlignment(CENTER);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

}