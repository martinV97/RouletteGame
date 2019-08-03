package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author John Jimenez
 *
 */
public class AboutEnginners extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel jLTitle,jLAboutRobin,jLCodeRobin;

	public AboutEnginners() {
		
		setSize(520, 420);
		getContentPane().setBackground(Color.decode("#F5F5F5"));
		setLocationRelativeTo(null);
		setLayout(null);
		setModal(true);
		setResizable(false);
		((JPanel) getContentPane()).setOpaque(false);
//		ImageIcon imageFound = new ImageIcon(getClass().getResource("/" + "images/fondoIng.png"));
//		JLabel found = new JLabel();
//		found.setIcon(imageFound);
//		getLayeredPane().add(found, JLayeredPane.FRAME_CONTENT_LAYER);
//		found.setBounds(0, 0, imageFound.getIconWidth(), imageFound.getIconHeight());
		initComponents();
	}

	private void initComponents() {

		jLTitle = new JLabel("Programadores");
		jLTitle.setForeground(Color.BLACK);
		jLTitle.setFont(new Font("Consolas", 1, 26));
		jLTitle.setBounds(180, 20, 300, 50);
		this.add(jLTitle);

		
		jLAboutRobin= new JLabel("Robinson  Rodriguez");
		jLAboutRobin.setForeground(Color.BLACK);
		jLAboutRobin.setFont(new Font("Consolas", 1, 20));
		jLAboutRobin.setBounds(40, 80, 300, 120);
		this.add(jLAboutRobin);

		
		jLCodeRobin= new JLabel("201412852");
		jLCodeRobin.setForeground(Color.BLACK);
		jLCodeRobin.setFont(new Font("Consolas", 1, 20));
		jLCodeRobin.setBounds(330, 80, 300, 120);
		this.add(jLCodeRobin);


		jLAboutRobin= new JLabel("Martin  Vivanco");
		jLAboutRobin.setForeground(Color.BLACK);
		jLAboutRobin.setFont(new Font("Consolas", 1, 20));
		jLAboutRobin.setBounds(40, 120, 300, 120);
		this.add(jLAboutRobin);

		
		jLCodeRobin= new JLabel("201414022");
		jLCodeRobin.setForeground(Color.BLACK);
		jLCodeRobin.setFont(new Font("Consolas", 1, 20));
		jLCodeRobin.setBounds(330, 120, 300, 120);
		this.add(jLCodeRobin);


		jLAboutRobin= new JLabel("Harold   Parra");
		jLAboutRobin.setForeground(Color.BLACK);
		jLAboutRobin.setFont(new Font("Consolas", 1, 20));
		jLAboutRobin.setBounds(40, 160, 300, 120);
		this.add(jLAboutRobin);

		
		jLCodeRobin= new JLabel("201211070");
		jLCodeRobin.setForeground(Color.BLACK);
		jLCodeRobin.setFont(new Font("Consolas", 1, 20));
		jLCodeRobin.setBounds(330, 160, 300, 120);
		this.add(jLCodeRobin);


		jLAboutRobin= new JLabel("David  Uriza");
		jLAboutRobin.setForeground(Color.BLACK);
		jLAboutRobin.setFont(new Font("Consolas", 1, 20));
		jLAboutRobin.setBounds(40, 200, 300, 120);
		this.add(jLAboutRobin);

		
		jLCodeRobin= new JLabel("201412852");
		jLCodeRobin.setForeground(Color.BLACK);
		jLCodeRobin.setFont(new Font("Consolas", 1, 20));
		jLCodeRobin.setBounds(330, 200, 300, 120);
		this.add(jLCodeRobin);

	}

}
