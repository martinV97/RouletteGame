package logic.entities;

import java.util.ArrayList;

import utils.Numero;
import utils.Tablero;

public class Round {
	private ArrayList<Bet> listOfBets;
	private int resultRound;
	private Tablero tablero;
	
	public Round(ArrayList<Bet> listOfBets) {
		super();
		this.listOfBets = listOfBets;
		this.tablero = new Tablero();
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

	public Object[] toVector() {
		Numero numero = this.tablero.getTablero().get(this.resultRound);
		if(numero.getColor() == 'r')
			return new Object[]{numero.getNumero(), "Rojo"};
		else
			return new Object[]{numero.getNumero(), "Negro"};
	}
	
	public Numero getNumeroResult() {
		return this.tablero.getTablero().get(this.resultRound);
	}
}
