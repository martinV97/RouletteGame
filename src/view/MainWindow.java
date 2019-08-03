package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.BorderUIResource;

import controller.ControllerView;

public class MainWindow extends JFrame{
	private PanelPlayers panelPlayers;
	private PanelUser panelUser;
	private PanelResult panelResult;
	private ControllerView  controllerView;
	private JLabel titleLbl;
	
	public MainWindow(ControllerView controllerView){
		this.controllerView = controllerView;
		init();
		addPanels();
	}

	private void init() {
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
	
	
	
}
