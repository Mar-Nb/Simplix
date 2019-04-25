package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>PanelDemo</i></h1>
 * <h2><code>public class PanelDemo extends JPanel implements <span class='name'>ActionListener</span></code></h2>
 * <p> Cette classe est un panel qui fait la démonstration de l'utilisation que l'on peut faire de
 * notre projet.</p>
 */
@SuppressWarnings("serial")
public class PanelDemo extends JPanel implements ActionListener{
	
	JPanel diapositives;
	JLabel instructions;
	CardLayout gestionnaireDeCartes;
	int indice=0;
	
	String[] titres= {"Affichage", "Charger un Simplexe (Fichier > Charger Simplexe"
			,"Création d'un Simplexe (Fichier > Nouveau Simplexe)","Création d'un Simplexe (partie 2) (Fichier > Nouveau Simplexe)"};
	
	JLabel titre;

	JButton retour;
	JButton suivant;

	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public PanelDemo()</code></h2>
	 * <p>Génère un panel contenant un diaporama d'images du dossier <code>"images"</code>.</p>
	 */
	public PanelDemo() {

		gestionnaireDeCartes=new CardLayout(5,5);
		
		diapositives=new JPanel();
		diapositives.setLayout(gestionnaireDeCartes);
		
		retour = new JButton("<");
		retour.setFont(new Font("Comic Sans MS", Font.BOLD, 90));
		retour.setFocusPainted(false);
		retour.setBorderPainted(false);
		retour.setContentAreaFilled(false);
		retour.addActionListener(this);
		retour.setActionCommand("retour");
		
		suivant = new JButton(">");
		suivant.setFont(new Font("Comic Sans MS",Font.BOLD, 90));
		suivant.setFocusPainted(false);
		suivant.setBorderPainted(false);
		suivant.setContentAreaFilled(false);
		suivant.addActionListener(this);
		suivant.setActionCommand("suivant");
		
		instructions = new JLabel("Cliquez sur les flèches de défilement pour parcourir le mode d'emploi",JLabel.CENTER);
		instructions.setFont(new Font("Default", Font.BOLD, 30));
		JPanel container =new JPanel();
		container.setLayout(new BorderLayout(45,25));
		
		
		ImageIcon image = new ImageIcon("images"+File.separator+"Simplexe.png");
		ImageIcon iconScaled = new ImageIcon(scaleImage(image.getImage(),900));
		JLabel affichage=new JLabel(iconScaled);
		diapositives.add(affichage, "Affichage");
		
		ImageIcon image3 = new ImageIcon("images"+File.separator+"chargerSimplexe.png");
		iconScaled = new ImageIcon(scaleImage(image3.getImage(),900));
		JLabel affichage3=new JLabel(iconScaled);
		diapositives.add(affichage3, "Charger un Simplexe (Fichier > Charger Simplexe)");

		ImageIcon image2 = new ImageIcon("images"+File.separator+"creerSimplexe.png");
		iconScaled = new ImageIcon(scaleImage(image2.getImage(),900));
		JLabel affichage2=new JLabel(iconScaled);
		diapositives.add(affichage2, "Création d'un Simplexe (Fichier > Nouveau Simplexe)");
		
		ImageIcon image4 = new ImageIcon("images"+File.separator+"creerSimplexe2.png");
		iconScaled = new ImageIcon(scaleImage(image4.getImage(),900));
		JLabel affichage4=new JLabel(iconScaled);
		diapositives.add(affichage4, "Création d'un Simplexe (partie 2) (Fichier > Nouveau Simplexe)");
		
		
		titre=new JLabel("Affichage",JLabel.CENTER);
		container.add(diapositives, BorderLayout.CENTER);
		container.add(titre, BorderLayout.SOUTH);
		container.add(instructions, BorderLayout.NORTH);
		
		
		this.add(retour);
		this.add(container);
		this.add(suivant);
		
		gestionnaireDeCartes.show(diapositives, "Affichage");
		
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>scaleImage</i></h1>
	 * <h2><code>public static Image scaleImage(<span class='name'>Image</span> source, <span class='name'>int</span> width, <span class='name'>int</span> height)</code></h2>
	 * 
	 * @param source : (Image)
	 * @param width : (Integer)
	 * @param height : (Integer)
	 * @return img : (Image)
	 */
	public static Image scaleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>scaleImage</i></h1>
	 * <h2><code>public static Image scaleImage(<span class='name'>Image</span> source, <span class='name'>int</span> size)</code></h2>
	 * <p>Permet de calculer la taille adéquate pour la redimension de l'image et renvoie l'image redimensionnée.</p>
	 * 
	 * @param source : (Image)
	 * @param size : (Integer)
	 * @return scaleImage(source, width, height) : (Image)
	 */
	public static Image scaleImage(Image source, int size) {
	    int width = source.getWidth(null);
	    int height = source.getHeight(null);
	    double f = 0;
	    if (width < height) { 
	    	// Portrait
	        f = (double) height / (double) width;
	        width = (int) (size / f);
	        height = size;
	    } else { 
	    	// Paysage
	        f = (double) width / (double) height;
	        width = size;
	        height = (int) (size / f);
	    }
	    return scaleImage(source, width, height);
	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>actionPerformed</i></h1>
	 * <h2><code>public void actionPerformed(<span class='name'>ActionEvent</span> evt)</code></h2>
	 * <p>Permet le défilement du diaporama.</p>
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("retour")) {
			gestionnaireDeCartes.previous(diapositives);
			indice--;
			if(indice==-1) {
				indice=titres.length -1;
			}
		}
		
		if(evt.getActionCommand().equals("suivant")) {
			gestionnaireDeCartes.next(diapositives);
			indice++;
			if(indice==titres.length) {
				indice=0;
			}
			titre.setText(titres[indice]);
			titre.setText(titres[indice]);
			
		}
		
	}
}
