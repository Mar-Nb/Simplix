package Vue;

import javax.swing.JFrame;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>FenetreDemo</i></h1>
 * <h2><code>public class FenetreDemo extends JFrame</code></h2>
 * <p>Cette classe montre à l'utilisateur comment se servir de l'application.</p>
 */
@SuppressWarnings("serial")
public class FenetreDemo extends JFrame{
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public FenetreDemo()</code></h2>
	 * <p>Cette fenêtre contient le panelDemo.</p>
	 */
	public FenetreDemo() {
		super("Démonstration");
		
		PanelDemo panelDemo = new PanelDemo();
		
		this.setContentPane(panelDemo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLocation(5,25);
		
	}
	
	public static void main(String [] args) {
		new FenetreDemo();
	}
}
