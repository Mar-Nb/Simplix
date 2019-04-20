package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
 * <h1><i>AfficheFraction</i></h1>
 * <h2><code>public class AfficheFraction extends JPanel</code></h2>
 * <p>Cette classe permet d'afficher un panel contenant une fraction écrite verticalement.<br><br><i>
 * Cette classe n'a pas été utilisé dans le projet.</i></p>
 */
@SuppressWarnings("serial")
public class AfficheFraction extends JPanel {
	
	JLabel frac;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } </style>
	 * <h1><i>Constructeur</i></h1>
	 * <h2><code>public AfficheFraction(int num, int denom)</code></h2>
	 * <p>Construit un objet <code>AfficheFraction</code> correspondant à un <code>BorderLayout</code> dans 
	 * lequel sera affiché une fraction.</p>
	 * @param num : (Integer)
	 * @param denom : (Integer)
	 */
	public AfficheFraction(int num,int denom) {
		this.setLayout(new BorderLayout());
		
		if (num < 0) {
			frac = new JLabel("<html><head></head><body>"
					+ "<table><td>-</td>"
					+ "<td><center>"+Integer.toString(-num)+"</center><hr>"
					+ "<center>"+Integer.toString(denom)+"</center></td></table>", JLabel.CENTER);
		}
		else if (denom < 0) {
			frac = new JLabel("<html><head></head><body>"
					+ "<table><td>-</td>"
					+ "<td><center>"+Integer.toString(num)+"</center><hr>"
					+ "<center>"+Integer.toString(-denom)+"</center></td></table>", JLabel.CENTER);
		}
		else {
			frac = new JLabel("<html><head></head><body>"
					+ "<table><tr><td><center>"+Integer.toString(num)+"</center></td></tr>"
					+ "<tr><<td><hr></td></tr>"
					+ "<tr><td><center>"+Integer.toString(denom)+"</center></td></tr></table>", JLabel.CENTER);
		}
		
		this.add(frac, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("Afficher une fraction");
		f.setContentPane(new AfficheFraction(-14,5));
		f.setSize(50,100); f.setVisible(true); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
