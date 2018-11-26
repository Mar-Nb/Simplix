package Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FenetreMereSimplex extends JFrame implements ActionListener{
	
	PanelGeneralSimplex contentPane = new PanelGeneralSimplex();
	
	public FenetreMereSimplex() {
		super("API Simplexe");
		
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
		save.addActionListener(this);
		charger.setActionCommand("charger");
		charger.addActionListener(this);
		onglet.setActionCommand("onglet");
		aPropos.setActionCommand("aPropos");
		aPropos.addActionListener(this);
		quitter.setActionCommand("quitter");
		quitter.addActionListener(this);
		quitter.setMnemonic('Q');
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("quitter"))
			dispose();
		else if(e.getActionCommand().equals("aPropos"))
			JOptionPane.showMessageDialog(null, "Projet Simplexe version 1.0\n On espère qu'il sera utile. Ici sera mis une"
					+ "notice d'utilisation du programme.", "A propos", JOptionPane.INFORMATION_MESSAGE);
		
	}

}