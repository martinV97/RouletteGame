package logic.entities;

import utils.Constants;

public class Bet {
	
	private Player player;
	private char typeOfBet;
	private String informationOfBet;
	private int amountBet;
	private int possibleProfit;
	
	public Bet(Player player, char typeOfBet, String informationOfBet, int amountBet) {
		super();
		this.player = player;
		this.typeOfBet = typeOfBet;
		this.informationOfBet = informationOfBet;
		this.amountBet = amountBet;
		calculatePossibleProfit();
	}
	
	private void calculatePossibleProfit() {
		switch (typeOfBet) {
		case Constants.SIMPLE_BET:
			this.possibleProfit = amountBet * 35;  
			break;
		case Constants.DIVIDED_BET:
			this.possibleProfit = amountBet * 17;
			break;
		case Constants.QUADRUPLE_BET:
			this.possibleProfit = amountBet * 8;
			break;
		case Constants.LINE_BET:
			this.possibleProfit = amountBet * 5;
			break;
		case Constants.COLOR_BET:
			this.possibleProfit = amountBet * 2;
			break;
		case Constants.EVEN_OR_ODD_BET:
			this.possibleProfit = amountBet * 2;
			break;
		case Constants.COLUMN_BET:
			this.possibleProfit = amountBet * 3;
			break;
		case Constants.DOZEN_BET:
			this.possibleProfit = amountBet * 3;
			break;
		case Constants.HIGH_OR_LOW_BET:
			this.possibleProfit = amountBet * 2;
			break;
		default:
			break;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public char getTypeOfBet() {
		return typeOfBet;
	}

	public void setTypeOfBet(char typeOfBet) {
		this.typeOfBet = typeOfBet;
	}

	public String getInformationOfBet() {
		return informationOfBet;
	}

	public void setInformationOfBet(String informationOfBet) {
		this.informationOfBet = informationOfBet;
	}

	public int getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(int amountBet) {
		this.amountBet = amountBet;
	}

	public int getPossibleProfit() {
		return possibleProfit;
	}

	public void setPossibleProfit(int possibleProfit) {
		this.possibleProfit = possibleProfit;
	}
	
}
