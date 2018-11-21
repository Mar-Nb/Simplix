package Vue;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Modele.Simplexe;

public class PanelSimplex extends JPanel {
	
	private Simplexe simplexe;
	JLabel label = new JLabel("Panel de simplexe");

	public PanelSimplex(Simplexe simp) {
		// TODO Auto-generated constructor stub
		simplexe = simp;
		
		this.add(label);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	public Simplexe getSimplexe() {
		return simplexe;
	}

	public void setSimplexe(Simplexe simplexe) {
		this.simplexe = simplexe;
	}

	
}
