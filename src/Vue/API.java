package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>API</i></h1>
 * <h2><code>public class API extends JFrame implements <span class='name'>ActionListener</span></code></h2>
 * <p>Cette classe constitue le point d'entrée de notre application et de l'application <i>Matrice</i>.</p>
 */
@SuppressWarnings("serial")
public class API extends JFrame implements ActionListener{

	JButton simp = new JButton("Simplexe");
	JButton mat = new JButton("Matrice");
	
	public GridBagConstraints contrainte = new GridBagConstraints() ;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public API()</code></h2>
	 * <p>Met en place le point d'entrée de l'application.</p>
	 */
	public API() {
		super("Accueil de l'API");
		JPanel pan = new JPanel();
		pan.setLayout(new GridBagLayout());
		
		contrainte.fill = GridBagConstraints.BOTH; contrainte.insets = new Insets(10,10,10,10);
		contrainte.ipady = contrainte.anchor = GridBagConstraints.CENTER;
		
		simp.addActionListener(this);
		simp.setActionCommand("simplexe");
		
		mat.addActionListener(this);
		mat.setActionCommand("matrice");
		
		contrainte.gridx = 0; contrainte.gridy = 0;
		contrainte.gridheight = 2; contrainte.gridwidth = 2;
		pan.add(new JLabel("Bienvenue dans l'API Simplexe-Matrice",JLabel.CENTER),
				contrainte);
		
		contrainte.gridx = 0; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(simp,contrainte);
		
		contrainte.gridx = 1; contrainte.gridy = 2;
		contrainte.gridheight = 1; contrainte.gridwidth = 1;
		pan.add(mat,contrainte);
		
		this.add(pan);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,400);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new API();

	}

	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
	 * <h1><i>actionPerformed</i></h1>
	 * <h2><code>public void actionPerformed(<span class='name'>ActionEvent</span> ev)</code></h2>
	 * <p>L'utilisateur peut, grâce à cette méthode, faire le choix d'utiliser l'application dédiée aux Matrices ou au Simplexe.</p>
	 * 
	 * @param ActionEvent ev
	 */
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		
		if(ev.getActionCommand().equals("simplexe"))
			new FenetreMereSimplex();
		
	}

}