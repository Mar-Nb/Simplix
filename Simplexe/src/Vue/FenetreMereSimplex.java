package Vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FenetreMereSimplex extends JFrame{
	
	PanelGeneralSimplex contentPane = new PanelGeneralSimplex();
	
	public FenetreMereSimplex() {
		super("API Simplexe - Matrice");
		
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
		JMenuItem save = new JMenuItem("Sauvegarder");
		JMenuItem charger = new JMenuItem("Charger un fichier");
		JMenu onglet = new JMenu("Onglet");
		JMenu aPropos = new JMenu("A propos");
		JMenu quitter = new JMenu("Quitter");
		
		fichier.setActionCommand("fichier");
		save.setActionCommand("save");
		charger.setActionCommand("charger");
		onglet.setActionCommand("onglet");
		aPropos.setActionCommand("aPropos");
		quitter.setActionCommand("quitter");
		
		fichier.add(save);
		fichier.add(charger);
		menu.add(fichier);
		menu.add(onglet);
		menu.add(aPropos);
		menu.add(quitter);
		
		this.setJMenuBar(menu);
		this.setSize(800,400); this.setVisible(true); this.setLocation(200,300);
	}
	
	public void ecouteur(PanelGeneralSimplex pan) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new FenetreMereSimplex();

	}

}