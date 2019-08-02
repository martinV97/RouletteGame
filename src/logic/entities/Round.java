package logic.entities;

import java.util.ArrayList;

public class Round {
	private ArrayList<Bet> listOfBets;
	private int resultRound;
	
	public Round(ArrayList<Bet> listOfBets) {
		super();
		this.listOfBets = listOfBets;
	}

	public int getResultRound() {
		return resultRound;
	}

	public void setResultRound(int resultRound) {
		this.resultRound = resultRound;
	}

	public ArrayList<Bet> getListOfBets() {
		return listOfBets;
	}
}
