package Vue;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;

public class FenetreMereSimplex extends JFrame implements ActionListener{
	
	/*PanelGeneralSimplex panGS = new PanelGeneralSimplex();
	JPanel contentPane = new JPanel();
	PanelFormulaire panF = new PanelFormulaire();
	Controleur controleur = new Controleur(panF,panGS);
	CardLayout gestionF = new CardLayout(5,5);
	*/
	
	PanelGeneralSimplex contentPane = new PanelGeneralSimplex();
	
	public FenetreMereSimplex() {
		super("API Simplexe");
		
		/*contentPane.setLayout(gestionF);
		contentPane.add(panGS, "general");
		contentPane.add(panF, "formulaire");*/
		
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
		JMenuItem save = new JMenuItem("Sauvegarder");
		JMenuItem charger = new JMenuItem("Charger un fichier");
		JMenu onglet = new JMenu("Onglet");
		JMenuItem gen = new JMenuItem("Vue général");
		JMenuItem formulaire = new JMenuItem("Formulaire Simplexe");
		JMenu aide = new JMenu("?");
		JMenuItem aPropos = new JMenuItem("A propos");
		JMenu fermer = new JMenu("Quitter");
		JMenuItem quitter = new JMenuItem("Fermer la fenêtre");
		
		save.setActionCommand("save");
		save.addActionListener(this);
		charger.setActionCommand("charger");
		charger.addActionListener(this);
		gen.setActionCommand("general");
		gen.addActionListener(this);
		formulaire.setActionCommand("formulaire");
		formulaire.addActionListener(this);
		aPropos.setActionCommand("aPropos");
		aPropos.addActionListener(this);
		quitter.setActionCommand("quitter");
		quitter.addActionListener(this);
		fermer.setMnemonic('Q');
		
		fichier.add(save);
		fichier.addSeparator();
		fichier.add(charger);
		onglet.add(gen);
		onglet.addSeparator();
		onglet.add(formulaire);
		aide.add(aPropos);
		fermer.add(quitter);
		menu.add(fichier);
		//menu.add(onglet);
		menu.add(aide);
		menu.add(fermer);
		
		this.setJMenuBar(menu);
		this.setSize(850,600); this.setVisible(true); this.setLocation(270,85);
		
		//gestionF.show(contentPane, "formulaire");
	}
	
	public void ecouteur(PanelGeneralSimplex pan) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new FenetreMereSimplex();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("quitter"))
			this.dispose();
		else if(e.getActionCommand().equals("aPropos")) {
			JOptionPane.showMessageDialog(contentPane, "Projet Simplexe version 1.0\nOn espère qu'il sera utile. Ici sera mis une"
					+ " notice d'utilisation du programme.", "A propos", JOptionPane.INFORMATION_MESSAGE);
		}
		/*else if(e.getActionCommand().equals("general")) {
			gestionF.show(contentPane, "general");
		}
		else if(e.getActionCommand().equals("formulaire")) {
			gestionF.show(contentPane, "formulaire");
		}*/
		
	}

}