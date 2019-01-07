package Vue;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controleur.Controleur;

public class FenetreMereSimplex extends JFrame {

	PanelGeneral contentPane;
	
	public FenetreMereSimplex() {
		super("API Simplexe");
		
		contentPane = new PanelGeneral();
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,600);
		this.setVisible(true);
		this.setLocation(100,100);
		
		//Mise en place de la JMenuBar
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		//JMenu Création
		JMenu menuCreation=new JMenu("Fichier");
		menuBar.add(menuCreation);
		
		String[] itemsCreation = {"Nouveau Simplexe", "Charger Simplexe", "Enregistrer", "Enregistrer sous"};
		JMenuItem[] menuItemsCreation = new JMenuItem[itemsCreation.length];
		
		for(int i=0; i<itemsCreation.length;i++) {
			menuItemsCreation[i]=new JMenuItem(itemsCreation[i]);
			menuCreation.add(menuItemsCreation[i]);
			menuItemsCreation[i].setActionCommand(itemsCreation[i]);
			menuItemsCreation[i].addActionListener((ActionListener)contentPane);
		}
		
		//Tableau de MenuItem
		String[] items = {"Affichage", "Annuler", "Quitter", "?"};
		JMenuItem[] menuItem = new JMenuItem[items.length];
		for(int i = 0; i<items.length;i++){
			menuItem[i] = new JMenuItem(items[i]);
			menuBar.add(menuItem[i]);
			menuItem[i].setActionCommand(items[i]);
			menuItem[i].addActionListener((ActionListener) contentPane);
		}
	}
	
	//Main
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FenetreMereSimplex();
	}

}