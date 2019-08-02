package logic.entities;

import utils.Constants;

public class Bet {
	
	private Player player;
	private char typeOfBet;
	private String informationOfBet;
	private double amountBet;
	private double possibleProfit;
	
	public Bet(Player player, char typeOfBet, String informationOfBet, double amountBet) {
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

	public double getAmountBet() {
		return amountBet;
	}

	public void setAmountBet(double amountBet) {
		this.amountBet = amountBet;
	}

	public double getPossibleProfit() {
		return possibleProfit;
	}

	public void setPossibleProfit(double possibleProfit) {
		this.possibleProfit = possibleProfit;
	}
	
}
