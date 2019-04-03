package Vue;

import java.io.File;

import javax.swing.JFrame;

import Modele.Historique;
import Modele.LectureEcriture;

public class FenetreDemo extends JFrame{
	
	/**
	 * Construction d'une nouvelle fenêtre qui peut être fermée sans terminer le programme.
	 * Cette fenêtre contient le panelDemo.
	 */
	
	public FenetreDemo() {
		super("Démonstration");
		
		PanelDemo panelDemo = new PanelDemo();
		
		this.setContentPane(panelDemo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1500,1000);
		this.setVisible(true);
		this.setLocation(100,100);
		
	}
}
