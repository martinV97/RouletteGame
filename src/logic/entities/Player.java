package logic.entities;

import java.util.ArrayList;

public class Player {
	private String name;
	private double playerMoney;
	private ArrayList<Bet> listOfBets;
	private Crupier crupier;
	
	public Player(String name, double playerMoney, Crupier crupier) {
		super();
		this.name = name;
		this.playerMoney = playerMoney;
		this.crupier = crupier;
	}
	
	public void makeBets(double moneyBet, char typeOfBet, String informationOfBet) {
		crupier.receiveBet(new Bet(this, typeOfBet, informationOfBet, moneyBet));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(double playerMoney) {
		this.playerMoney = playerMoney;
	}

	public ArrayList<Bet> getListOfBets() {
		return listOfBets;
	}

	public void setListOfBets(ArrayList<Bet> listOfBets) {
		this.listOfBets = listOfBets;
	}	
}
