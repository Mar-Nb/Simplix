package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficheFraction extends JPanel {
	
	public AfficheFraction(int num,int denom) {
		this.setLayout(new BorderLayout());
		JLabel frac = new JLabel("<html><head></head><body>"
				+ "<center><p>"+Integer.toString(num)+"</p></center><hr>"
				+ "<center><p>"+Integer.toString(denom)+"</center></p></body></html>", JLabel.CENTER);
		
		this.add(frac, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("Afficher une fraction");
		f.setContentPane(new AfficheFraction(14,5));
		f.setSize(50,100); f.setVisible(true); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
