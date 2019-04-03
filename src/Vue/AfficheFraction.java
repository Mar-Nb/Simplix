package Vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficheFraction extends JPanel {
	
	JLabel frac;
	
	/**
	 * Construit un objet AfficheFraction correspondant à un BorderLayout dans lequel sera afficher une fraction
	 * @param int num
	 * @param int denom
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
