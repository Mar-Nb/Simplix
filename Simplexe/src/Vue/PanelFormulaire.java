package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Controleur;
import Modele.ContrainteExplicite;
import Modele.FonctionEco;
import Modele.Monome;

public class PanelFormulaire extends JPanel{
	

	private CardLayout gestionnaireDeCartes ;
	PanelContraintes panelC;
	PanelChoixNombresMonomesContraintes panelCMC;
	
	public PanelFormulaire() {
		/*LAYOUT*/
		gestionnaireDeCartes = new CardLayout(5,5);
		this.setLayout(gestionnaireDeCartes);
		
		panelCMC = new PanelChoixNombresMonomesContraintes();
		panelC=new PanelContraintes(1, 1);
		this.add(panelCMC, "ChoixMonomesContraintes");
		
	
	}

	public void enregistreEcouteur(Controleur controleur) {
		// TODO Auto-generated method stub
		
		panelC.enregistreEcouteur(controleur);
		panelCMC.enregistreEcouteur(controleur);
		
	}

	public CardLayout getGestionnaireDeCartes() {
		return gestionnaireDeCartes;
	}

	public PanelContraintes getPanelC() {
		return panelC;
	}

	public PanelChoixNombresMonomesContraintes getPanelCMC() {
		return panelCMC;
	}

}