package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logic.entities.Bet;
import logic.entities.Player;
import logic.entities.Round;
import utils.Constants;
import view.AboutEnginners;
import view.Instructions;
import view.MainWindow;

public class ControllerView implements ActionListener {
	public MainWindow mainWindow;
	private ControllerLogic controllerLogic;
	public Player userPlayer;
	public AboutEnginners aboutEnginners;
	public Instructions help;
	
	public ControllerView() {
		this.mainWindow = new MainWindow(this);
		this.controllerLogic = new ControllerLogic(this);
		this.aboutEnginners = new AboutEnginners();
		this.help = new Instructions();
		this.openWindow();
	}

	private void openWindow() {
		this.mainWindow.setVisible(true);
	}

	private void startSimulation() {
		addPlayers();
		this.mainWindow.getPanelPlayers().getStartSimulationBtn().setEnabled(false);
	}

	public void addPlayers() {
		this.mainWindow.getPanelPlayers().fillPlayerList(this.controllerLogic.getPlayerAgents());
	}

	public void addRounds(ArrayList<Round> roundList) {
		this.mainWindow.getPanelResult().fillRoundList(roundList);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case Constants.START_SIMULATION:
			startSimulation();
			this.controllerLogic.getCrupierAgent().start();
			break;
		case Constants.ENTER_PLAYER:
			this.userPlayer = new Player(this.mainWindow.getPanelUser().getNameTxt().getText(),
					Integer.parseInt(this.mainWindow.getPanelUser().getInitialMoneyTxt().getText()),
					this.controllerLogic.getCrupierAgent().getCrupier());
			this.controllerLogic.addPlayer(this.userPlayer);
			this.mainWindow.getPanelUser().updateFields();
			addPlayers();
			break;
		case Constants.SEND_BET:
			this.controllerLogic.getCrupierAgent().getCrupier().receiveBet(
					new Bet(this.userPlayer, getTypeOfBet((String) this.mainWindow.getPanelUser().getBetTypeBox().getSelectedItem()),
							this.mainWindow.getPanelUser().getInformationBetTxt().getText(),
							Integer.parseInt(this.mainWindow.getPanelUser().getBetMoneyTxt().getText())));
			this.mainWindow.getPanelUser().clearBetFields();
			break;
		case Constants.PROGRAMMER:
			aboutEnginners.setVisible(true);
			break;
		case Constants.EXIT:
			this.mainWindow.close();
		case Constants.HELP:
            help.setVisible(true);
            break;
			
		default:
			break;
		}

	}

	private char getTypeOfBet(String selectedItem) {
		switch (selectedItem) {
		case "Color":
			return Constants.COLOR_BET;
		case "Par o Impar":
			return Constants.EVEN_OR_ODD_BET;
		case "Columna":
			return Constants.COLUMN_BET;
		case "Docena":
			return Constants.DOZEN_BET;
		case "Altos y Bajos":
			return Constants.HIGH_OR_LOW_BET;
		case "Apuesta Sencilla":
			return Constants.SIMPLE_BET;
		case "Apuesta Dividida":
			return Constants.DIVIDED_BET;
		case "Apuesta cuádruple":
			return Constants.QUADRUPLE_BET;
		case "Apuesta de línea":
			return Constants.LINE_BET;
		}
		return 0;
	}

	public ControllerLogic getControllerLogic() {
		return controllerLogic;
	}

	public void setControllerLogic(ControllerLogic controllerLogic) {
		this.controllerLogic = controllerLogic;
	}

}
