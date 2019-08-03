package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.plaf.BorderUIResource;

import utils.Constants;
import controller.ControllerView;

public class MainWindow extends JFrame{
	private PanelPlayers panelPlayers;
	private PanelUser panelUser;
	private PanelResult panelResult;
	private PanelRoulette panelRoulette;
	private ControllerView  controllerView;
	private JLabel titleLbl;
	private JMenuBar menuBar;
	private JMenu options;
	private JMenuItem exit, about, help;
	private AboutEnginners aboutEnginners;
	
	public MainWindow(ControllerView controllerView){
		this.controllerView = controllerView;
		init();
		addPanels();
		
	}

	private void init() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		Image image = Toolkit.getDefaultToolkit().getImage("img/icon.png");

		options = new JMenu("Menu");
		exit = new JMenuItem("Salir");
		exit.setIcon(new ImageIcon("imgs/icon_exit3.png"));
		exit.setBackground(Color.white);
		exit.setToolTipText("Borra todos los numeros generados");
		exit.setActionCommand(Constants.EXIT);
		exit.addActionListener(controllerView);
		
		about = new JMenuItem("Programadores");
		about.setIcon(new ImageIcon("imgs/programmer.png"));
		about.setBackground(Color.white);
		about.setToolTipText("Borra todos los numeros generados");
		about.setActionCommand(Constants.PROGRAMMER);
		about.addActionListener(controllerView);
		
		help = new JMenuItem("Instrucciones");
        help.setIcon(new ImageIcon("imgs/Help-icon.png"));
        help.setBackground(Color.white);
        help.setActionCommand(Constants.HELP);
        help.addActionListener(controllerView);

        options.add(exit);
        options.add(about);
        options.add(help);
        menuBar.add(options);
		
		setIconImage(image);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Roulette");
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
	}
	
	private void addPanels(){
		this.panelPlayers = new PanelPlayers(this.controllerView);
		this.add(this.panelPlayers, BorderLayout.EAST);
		this.panelUser = new PanelUser(this.controllerView);
		this.add(this.panelUser, BorderLayout.SOUTH);
		this.panelResult = new PanelResult(this.controllerView);
		this.add(this.panelResult, BorderLayout.WEST);
		this.titleLbl = new JLabel("En espera");
		this.titleLbl.setForeground(Color.GREEN);
		this.add(this.titleLbl, BorderLayout.NORTH);
		this.panelRoulette = new PanelRoulette();
		this.add(this.panelRoulette, BorderLayout.CENTER);
	}

	public PanelPlayers getPanelPlayers() {
		return panelPlayers;
	}

	public void setPanelPlayers(PanelPlayers panelPlayers) {
		this.panelPlayers = panelPlayers;
	}

	public PanelUser getPanelUser() {
		return panelUser;
	}

	public void setPanelUser(PanelUser panelUser) {
		this.panelUser = panelUser;
	}

	public PanelResult getPanelResult() {
		return panelResult;
	}

	public void setPanelResult(PanelResult panelResult) {
		this.panelResult = panelResult;
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}
	
	public void close() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion;
		eleccion = JOptionPane.showOptionDialog(rootPane, "Esta seguro de cerrar la aplicacion",
				"Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones,
				"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
			this.dispose();
		} else {
		}
	}
	
}
