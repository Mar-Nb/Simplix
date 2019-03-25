package Vue;

import java.io.File;

import javax.swing.JFrame;

import Modele.Historique;
import Modele.LectureEcriture;

public class FenetreDemo extends JFrame{
	public FenetreDemo() {
		super("Démonstration");
		
		PanelDemo panelDemo = new PanelDemo();
		
		this.setContentPane(panelDemo);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setVisible(true);
		this.setLocation(100,100);
		
	}
}
