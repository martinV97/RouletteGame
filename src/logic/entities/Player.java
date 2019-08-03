package logic.entities;

import java.util.ArrayList;

public class Player {
	private String name;
	private int playerMoney;
	private ArrayList<Bet> listOfBets;
	private Crupier crupier;
	
	public Player(String name, int playerMoney, Crupier crupier) {
		super();
		this.name = name;
		this.playerMoney = playerMoney;
		this.crupier = crupier;
	}
	
	public void makeBet(int moneyBet, char typeOfBet, String informationOfBet) {
		crupier.receiveBet(new Bet(this, typeOfBet, informationOfBet, moneyBet));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public void setPlayerMoney(int playerMoney) {
		this.playerMoney = playerMoney;
	}

	public ArrayList<Bet> getListOfBets() {
		return listOfBets;
	}

	public void setListOfBets(ArrayList<Bet> listOfBets) {
		this.listOfBets = listOfBets;
	}	
	
	public Object[] toVector() {
		return new Object[]{this.name, this.playerMoney};
	}
}
