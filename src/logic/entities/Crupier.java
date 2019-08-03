package logic.entities;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.agent.CrupierAgent;
import utils.Constants;
import utils.Numero;

public class Crupier {
	private Roulette roulette;
	private ArrayList<Bet> betListGame;
	private ArrayList<Bet> betListPerRound;
	private ArrayList<Player> playersList;
	private ArrayList<Round> roundList;
	private CrupierAgent crupierAgent;
	
	public Crupier(Roulette roulette, CrupierAgent crupierAgent) {
		super();
		this.roulette = roulette;
		this.crupierAgent = crupierAgent;
		this.betListGame = new ArrayList<>();
		this.betListPerRound = new ArrayList<>();
		this.playersList = new ArrayList<>();
		this.roundList = new ArrayList<>();
	}
	
	public void addPlayer(Player player) {
		this.playersList.add(player);
	}
	
	public void removePlayer(Player player) {
		this.playersList.remove(player);
	}
	
	public void receiveBet(Bet bet) {
		this.betListPerRound.add(bet);
	}
	
	public void startRound() {
		this.crupierAgent.setInRound(true);
		this.roundList.add(new Round(this.betListPerRound));
		Numero numero = roulette.getNumber();
		payToWinners(numero.getNumero(), numero.getColor());
		this.roundList.get(this.roundList.size() - 1).setResultRound(numero.getNumero());
		this.crupierAgent.showMessageResult(this.roundList.get(this.roundList.size() - 1).getNumeroResult());
		this.roundList.get(this.roundList.size() - 1).getNumeroResult();
		this.crupierAgent.setInRound(false);
		updateListGame();
	}	

	private void payToWinners(int numberResult, char colorResult) {
		for (Bet bet : this.roundList.get(0).getListOfBets()) {
			validateWinnerBet(bet, numberResult, colorResult);
		}
	}

	private void validateWinnerBet(Bet bet, int numberResult, char colorResult) {
		String [] listOfNumbers;
		switch (bet.getTypeOfBet()) {
		case Constants.SIMPLE_BET:
			if(Integer.parseInt(bet.getInformationOfBet()) == numberResult)
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
			else 
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.DIVIDED_BET:
			listOfNumbers = bet.getInformationOfBet().split(",");
			for (String number : listOfNumbers) {
				if(Integer.parseInt(number) == numberResult) {					
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
					break;
				}
			}
			bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.QUADRUPLE_BET:
			listOfNumbers = bet.getInformationOfBet().split(",");
			for (String number : listOfNumbers) {
				if(Integer.parseInt(number) == numberResult) {
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
					break;
				}
			}
			bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.LINE_BET:
			listOfNumbers = bet.getInformationOfBet().split(",");
			for (String number : listOfNumbers) {
				if(Integer.parseInt(number) == numberResult) {
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
					break;
				}
			} 
			bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.COLOR_BET:
			if(bet.getInformationOfBet().charAt(0) == colorResult)
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
			else 
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.EVEN_OR_ODD_BET:
			if(bet.getInformationOfBet().equals(Constants.PAIR))
				if(numberResult % 2 == 0)
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
				else 
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			if(bet.getInformationOfBet().equals(Constants.ODD))
				if(numberResult % 2 != 0)
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
				else 
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		case Constants.COLUMN_BET:
			switch (bet.getInformationOfBet().charAt(0)) {
			case 1:
				for (int numberColumn : roulette.getColumnOne())
					if(numberResult == numberColumn) {
						bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
						break;
					}
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			case 2:
				for (int numberColumn : roulette.getColumnTwo())
					if(numberResult == numberColumn) {
						bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
						break;
					}
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			case 3:
				for (int numberColumn : roulette.getColumnThree())
					if(numberResult == numberColumn) {
						bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
						break;
					}
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			default:
				break;
			}
			break;
		case Constants.DOZEN_BET:
			switch (bet.getInformationOfBet().charAt(0)) {
			case 1:
				if(numberResult <= 12)
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
				else
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			case 2:
				if(numberResult > 12 && numberResult <= 24)
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
				else
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			case 3:
				if(numberResult > 24 && numberResult <= 36)
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
				else
					bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
				break;
			default:
				break;
			}
			break;
		case Constants.HIGH_OR_LOW_BET:
			if(bet.getInformationOfBet().charAt(0) == Constants.L && numberResult <= 18)
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
			else
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			if(bet.getInformationOfBet().charAt(0) == Constants.H && numberResult > 18 && numberResult <= 36)
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() + bet.getPossibleProfit());
			else
				bet.getPlayer().setPlayerMoney(bet.getPlayer().getPlayerMoney() - bet.getAmountBet());
			break;
		default:
			break;
		}
	}

	private void updateListGame() {
		for (Bet bet : betListPerRound) {
			this.betListGame.add(bet);
		}
		this.betListPerRound.clear();
	}

	public ArrayList<Bet> getBetListPerRound() {
		return betListPerRound;
	}

	public void setBetListPerRound(ArrayList<Bet> betListPerRound) {
		this.betListPerRound = betListPerRound;
	}

	public ArrayList<Player> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(ArrayList<Player> playersList) {
		this.playersList = playersList;
	}

	public Roulette getRoulette() {
		return roulette;
	}

	public void setRoulette(Roulette roulette) {
		this.roulette = roulette;
	}

	public ArrayList<Bet> getBetListGame() {
		return betListGame;
	}

	public void setBetListGame(ArrayList<Bet> betListGame) {
		this.betListGame = betListGame;
	}

	public ArrayList<Round> getRoundList() {
		return roundList;
	}

	public void setRoundList(ArrayList<Round> roundList) {
		this.roundList = roundList;
	}

	public CrupierAgent getCrupierAgent() {
		return crupierAgent;
	}

	public void setCrupierAgent(CrupierAgent crupierAgent) {
		this.crupierAgent = crupierAgent;
	}
	
	
	
}
