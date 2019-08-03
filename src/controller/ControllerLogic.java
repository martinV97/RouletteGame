package controller;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import logic.agent.CrupierAgent;
import logic.agent.PlayerAgent;
import logic.entities.Bet;
import logic.entities.Player;

public class ControllerLogic {
	private CrupierAgent crupierAgent;
	private ArrayList<Player> players;
	private ArrayList<PlayerAgent> playerAgents;
	private PlayerAgent playerAgentOne;
	private PlayerAgent playerAgentTwo;
	private PlayerAgent playerAgentThree;
	private ControllerView controllerView;

	public ControllerLogic(ControllerView controllerView) {
		this.controllerView = controllerView;
		this.crupierAgent = new CrupierAgent(this.controllerView);
		this.players = new ArrayList<Player>();
		this.playerAgents = new ArrayList<>();
		startPlayerAgents();
	}

	private void startPlayerAgents() {
		this.playerAgentOne = new PlayerAgent(new Player("Jugador 1", 250000, this.crupierAgent.getCrupier()));
		this.playerAgentTwo = new PlayerAgent(new Player("Jugador 2", 150000, this.crupierAgent.getCrupier()));
		this.playerAgentThree = new PlayerAgent(new Player("Jugador 3", 500000, this.crupierAgent.getCrupier()));
		this.playerAgents.add(this.playerAgentOne);
		this.playerAgents.add(this.playerAgentTwo);
		this.playerAgents.add(this.playerAgentThree);
		this.players.add(this.playerAgentOne.getPlayer());
		this.players.add(this.playerAgentTwo.getPlayer());
		this.players.add(this.playerAgentThree.getPlayer());
		this.crupierAgent.getCrupier().addPlayer(this.playerAgentOne.getPlayer());
		this.crupierAgent.getCrupier().addPlayer(this.playerAgentTwo.getPlayer());
		this.crupierAgent.getCrupier().addPlayer(this.playerAgentThree.getPlayer());
	}

	public void addPlayer(Player player) {
		if (!this.crupierAgent.isInRound()){
			this.players.add(player);
			this.crupierAgent.getCrupier().addPlayer(player);
		}
	}

	public void removePlayer() {
		if (!this.crupierAgent.isInRound())
			this.players.remove(this.players.size() - 1);
	}

	public void receivePlayerBet(char typeOfBet, String informationOfBet, int amountBet) {
		if (!this.crupierAgent.isInRound())
			this.crupierAgent.getCrupier().receiveBet(new Bet(this.players.get(this.players.size() - 1),
					typeOfBet, informationOfBet, amountBet));
	}
	
	public void agentsBet() {
		if(!this.crupierAgent.isInRound()) {			
			for (PlayerAgent playerAgent : playerAgents) {
				playerAgent.makeBet();
			}
		}
	}
	
	public void validateMoneyOfPlayers() {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getPlayerMoney() <= 0) {
				if(this.players.get(i) == this.controllerView.userPlayer) {
					this.players.remove(i);
					this.crupierAgent.getCrupier().getPlayersList().remove(i);
					JOptionPane.showMessageDialog(this.controllerView.mainWindow, "Has perdido :(");
				}
				else {
					this.players.remove(i);
					this.playerAgents.remove(i);
					this.crupierAgent.getCrupier().getPlayersList().remove(i);
				}
			}
		}
		
	}
	
	public CrupierAgent getCrupierAgent() {
		return crupierAgent;
	}

	public void setCrupierAgent(CrupierAgent crupierAgent) {
		this.crupierAgent = crupierAgent;
	}

	public ArrayList<Player> getPlayerAgents() {
		return players;
	}

	public void setPlayerAgents(ArrayList<Player> playerAgents) {
		this.players = playerAgents;
	}


}
