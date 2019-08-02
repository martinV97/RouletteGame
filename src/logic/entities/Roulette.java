package logic.entities;

public class Roulette {
	private int amountOfNumbers;

	public Roulette(int amountOfNumbers) {
		super();
		this.amountOfNumbers = amountOfNumbers;
	}

	public char getColor() {
		return 'q';
	}
	
	public int getNumber() {
		return 0;
	}

	public int getAmountOfNumbers() {
		return amountOfNumbers;
	}

	public void setAmountOfNumbers(int amountOfNumbers) {
		this.amountOfNumbers = amountOfNumbers;
	}
}
