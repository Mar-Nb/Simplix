package Vue;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controleur.Controleur;
import Modele.ContrainteExplicite;
import Modele.Monome;
import Modele.Simplexe;

public class PanelSimplex extends JPanel {
	
	private Simplexe simplexe;
	public GridBagConstraints gridLim = new GridBagConstraints() ;
	
	JButton b;
	JButton[][] tabBoutonsInconnues;
	
	public PanelSimplex() {
		this.add(new JLabel("Panel Simplexe"),JLabel.CENTER);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	public PanelSimplex(Simplexe simp) {
		// TODO Auto-generated constructor stub
		simplexe = simp;
		
		int nbContraintes = 0;
		int nbBoutons = 0;
		
		tabBoutonsInconnues=new JButton[simplexe.getContraintes().size()][simplexe.getFonctionEco().getMonomes().size()];
		this.setLayout(new GridBagLayout());
		
		gridLim.gridwidth = 1;
		gridLim.gridheight = 1;
		gridLim.insets = new Insets(10,5,10,5);
		gridLim.gridy = 0;
		gridLim.gridx = 0;
		
		System.out.println("Contraintes : "+simplexe.getContraintes().size()+"\nMonomes : "+simplexe.getFonctionEco().getMonomes().size());
		
		for(Iterator j = simplexe.getContraintes().iterator(); j.hasNext();) {
			System.out.println("nbContraintes : "+Integer.toString(nbContraintes)+"\nnbBoutons : "+Integer.toString(nbBoutons));
			ContrainteExplicite ce = (ContrainteExplicite) j.next();
			JLabel lab = new JLabel(ce.getNom()+" =",JLabel.LEFT);
			this.add(lab,gridLim);
			gridLim.gridx++;
			for(Object obj : ce.getMonomes().values()) {
				Monome m = (Monome) obj;
				if(m.getCoefficient().getNumerateur()>0){
					lab = new JLabel("+ "+m.getCoefficient().toString());
					this.add(lab,gridLim);
					gridLim.gridx++;
					if(!m.getInconnue().equals(" ")){
						b = new JButton(m.getInconnue());
						this.add(b,gridLim);
						tabBoutonsInconnues[nbContraintes][nbBoutons] = b;
						nbBoutons++;
					}						
				}
				else{
					lab = new JLabel(m.getCoefficient().toString());
					this.add(lab,gridLim);
					gridLim.gridx++;
					if(!m.getInconnue().equals(" ")){
						b = new JButton(m.getInconnue());
						this.add(b,gridLim);
						tabBoutonsInconnues[nbContraintes][nbBoutons] = b;
						nbBoutons++;
					}
					
				}
				
				gridLim.gridx++;
			}
			gridLim.gridy++;
			gridLim.gridx = 0;
			nbBoutons=0;
			nbContraintes++;
		}
		
		gridLim.gridy++;
		gridLim.gridx = 0;
		JLabel lab = new JLabel(simplexe.getFonctionEco().toString());
		this.add(lab,gridLim);
		
		//this.add(new JLabel(simp.toString()));
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	public Simplexe getSimplexe() {
		return simplexe;
	}

	public void setSimplexe(Simplexe simplexe) {
		this.simplexe = simplexe;
	}

	public JButton[][] getTabBoutonsInconnues() {
		return tabBoutonsInconnues;
	}

	public void setTabBoutonsInconnues(JButton[][] tabBoutonsInconnues) {
		this.tabBoutonsInconnues = tabBoutonsInconnues;
	}
	
	public void enregistreEcouteur(Controleur controleur) {
		/*for(JButton[] tabMonomes : tabBoutonsInconnues) {
			for(JButton monomes : tabMonomes) {
				System.out.println("Boutons : "+monomes.getText());
				monomes.setActionCommand("monomes");
				monomes.addActionListener(controleur);
			}
		}*/
		
		for(int i = 0; i < tabBoutonsInconnues.length; i++){
			for(int j = 0; j < tabBoutonsInconnues[i].length; j++){
				tabBoutonsInconnues[i][j].setActionCommand("monomes "+Integer.toString(i));
				tabBoutonsInconnues[i][j].addActionListener(controleur);
			}
		}
	}
	
}
