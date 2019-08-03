package logic.agent;

import java.awt.Color;

import javax.swing.JOptionPane;

import controller.ControllerView;
import logic.entities.Crupier;
import logic.entities.Roulette;
import utils.Numero;

public class CrupierAgent extends Thread{
	private Crupier crupier;
	private boolean inRound;
	private boolean inGame;
	private ControllerView controllerView;
	
	public CrupierAgent(ControllerView controllerView) {
		this.crupier = new Crupier(new Roulette(36), this);
		this.inRound = false;
		this.inGame = true;
		this.controllerView = controllerView;
	}
	
	@Override
	public void run() {
		while(this.inGame) {
			this.controllerView.getControllerLogic().validateMoneyOfPlayers();
			if(this.controllerView.userPlayer != null && this.controllerView.userPlayer.getPlayerMoney() > 0)
				this.controllerView.mainWindow.getPanelUser().getSendBet().setEnabled(true);
			this.controllerView.mainWindow.getTitleLbl().setText("En Espera");
			this.controllerView.mainWindow.getTitleLbl().setForeground(Color.GREEN);
			this.controllerView.mainWindow.getPanelUser().getEnterRouletteBtn().setEnabled(true);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(this.crupier.getBetListPerRound().size() < this.crupier.getPlayersList().size() - 1)
					this.controllerView.getControllerLogic().agentsBet();
			if(this.crupier.getBetListPerRound().size() == this.crupier.getPlayersList().size())
				this.inRound = true;
			if (inRound) {
				this.crupier.startRound();
				this.controllerView.addPlayers();
				this.controllerView.addRounds(this.crupier.getRoundList());
				this.controllerView.mainWindow.getPanelUser().getEnterRouletteBtn().setEnabled(false);
				this.controllerView.mainWindow.getTitleLbl().setText("En juego");
				this.controllerView.mainWindow.getTitleLbl().setForeground(Color.RED);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Crupier getCrupier() {
		return crupier;
	}

	public void setCrupier(Crupier crupier) {
		this.crupier = crupier;
	}

	public boolean isInRound() {
		return inRound;
	}

	public void setInRound(boolean inRound) {
		this.inRound = inRound;
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public void showMessageResult(Numero numeroResult) {
		if(numeroResult.getColor() == 'r')
			JOptionPane.showMessageDialog(this.controllerView.mainWindow, "El resultado de la ruleta es: " + numeroResult.getNumero() + " Rojo.");
		else
			JOptionPane.showMessageDialog(this.controllerView.mainWindow, "El resultado de la ruleta es: " + numeroResult.getNumero() + " Negro.");
	}

	
}
