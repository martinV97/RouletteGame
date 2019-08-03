package logic.entities;

import java.util.Random;

import utils.Numero;
import utils.Tablero;

public class Roulette {
	private Random random;
	int [] columnOne = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
	int [] columnTwo = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};
	int [] columnThree = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
	private Tablero tablero;
	
	public Roulette(int amountOfNumbers) {
		super();
		this.random = new Random();
		this.tablero = new Tablero();
	}
	public Numero getNumber() {
		return this.tablero.getTablero().get(this.random.nextInt(37));
	}

	public int[] getColumnOne() {
		return columnOne;
	}

	public void setColumnOne(int[] columnOne) {
		this.columnOne = columnOne;
	}

	public int[] getColumnTwo() {
		return columnTwo;
	}

	public void setColumnTwo(int[] columnTwo) {
		this.columnTwo = columnTwo;
	}

	public int[] getColumnThree() {
		return columnThree;
	}

	public void setColumnThree(int[] columnThree) {
		this.columnThree = columnThree;
	}
	
	
}
