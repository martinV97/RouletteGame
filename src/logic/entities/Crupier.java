package logic.entities;

import java.util.ArrayList;

import utils.Constants;

public class Crupier {
	private Roulette roulette;
	private ArrayList<Bet> betListGame;
	private ArrayList<Bet> betListPerRound;
	private ArrayList<Player> playersList;
	private ArrayList<Round> roundList;
	
	public Crupier(Roulette roulette) {
		super();
		this.roulette = roulette;
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
		this.roundList.add(new Round(this.betListPerRound));
		int numberResult = roulette.getNumber();
		char colorResult = roulette.getColor();
		payToWinners(numberResult, colorResult);
		updateListGame();
	}	

	private void payToWinners(int numberResult, char colorResult) {
		for (Bet bet : this.roundList.get(0).getListOfBets()) {
			validateWinnerBet(bet);
		}
	}

	private void validateWinnerBet(Bet bet) {
		switch (bet.getTypeOfBet()) {
		case Constants.SIMPLE_BET:
			break;
		case Constants.DIVIDED_BET:
			break;
		case Constants.QUADRUPLE_BET:
			break;
		case Constants.LINE_BET:
			break;
		case Constants.COLOR_BET:
			break;
		case Constants.EVEN_OR_ODD_BET:
			break;
		case Constants.COLUMN_BET:
			break;
		case Constants.DOZEN_BET:
			break;
		case Constants.HIGH_OR_LOW_BET:
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
}
