package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelRoulette extends JPanel{
	public PanelRoulette() {
		this.setLayout(null);
		this.setBackground(new Color(34,139,34));
		JLabel ruleta = new JLabel();
		ImageIcon imageIcon = new ImageIcon("imgs/rouletteGif.gif");
		ruleta.setIcon(imageIcon);
		ruleta.setBounds(195,-250, 1100, 1100);
		this.add(ruleta);
		JLabel tablero = new JLabel();
		tablero.setIcon(new ImageIcon("imgs/tablero.PNG"));
		tablero.setBounds(125,150, 1100, 1100);
		this.add(tablero);
	}

}
