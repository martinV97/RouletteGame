package logic.agent;

import java.util.Random;

import logic.entities.Player;
import model.Montecarlo;
import utils.Constants;
import utils.Numero;
import utils.Tablero;

public class PlayerAgent {
	private Player player;
	private Montecarlo montecarlo;
	private Random random;
	private Tablero tablero;
	
	public PlayerAgent(Player player) {
		this.player = player;
		this.montecarlo = new Montecarlo();
		this.random = new Random();
		this.tablero = new Tablero();
	}

	public void makeBet() {
		char typeBet = montecarlo.typeBet();
		switch (typeBet) {
		case Constants.SIMPLE_BET:
			this.player.makeBet(calculateBetAmount(), typeBet, this.random.nextInt(37) + "");
			break;
		case Constants.DIVIDED_BET:
			this.player.makeBet(calculateBetAmount(), typeBet, getNumberDividedBet());
			break;
		case Constants.QUADRUPLE_BET:
			this.player.makeBet(calculateBetAmount(), typeBet, getNumberQuadrupleBet());
			break;
		case Constants.LINE_BET:
			this.player.makeBet(calculateBetAmount(), typeBet, getLine());
			break;
		case Constants.COLOR_BET:
			if(this.random.nextInt(2) == 0)
				this.player.makeBet(calculateBetAmount(), typeBet, "r");
			else
				this.player.makeBet(calculateBetAmount(), typeBet, "n");
			break;
		case Constants.EVEN_OR_ODD_BET:
			if(this.random.nextInt(2) == 0)
				this.player.makeBet(calculateBetAmount(), typeBet, Constants.PAIR);
			else
				this.player.makeBet(calculateBetAmount(), typeBet, Constants.ODD);
			break;
		case Constants.COLUMN_BET:
			switch (this.random.nextInt(3)) {
			case 0:
				this.player.makeBet(calculateBetAmount(), typeBet, "1");
				break;
			case 1:
				this.player.makeBet(calculateBetAmount(), typeBet, "2");
				break;
			case 2:
				this.player.makeBet(calculateBetAmount(), typeBet, "3");
				break;
			default:
				break;
			}
			break;
		case Constants.DOZEN_BET:
			switch (this.random.nextInt(3)) {
			case 0:
				this.player.makeBet(calculateBetAmount(), typeBet, "1");
				break;
			case 1:
				this.player.makeBet(calculateBetAmount(), typeBet, "2");
				break;
			case 2:
				this.player.makeBet(calculateBetAmount(), typeBet, "3");
				break;
			default:
				break;
			}
			break;
		case Constants.HIGH_OR_LOW_BET:
			if(this.random.nextInt(2) == 0)
				this.player.makeBet(calculateBetAmount(), typeBet, Constants.H + "");
			else
				this.player.makeBet(calculateBetAmount(), typeBet, Constants.L + "");
			break;
		default:
			break;
		}
	}


	private String getNumberDividedBet() {
		int number = this.random.nextInt(37);
		String[] aux = this.tablero.getTablero().get(number).getVecinosDoble().split(",");
		int numberCouple = 0;
			if(this.tablero.getTablero().get(number).getNumero() == number)
				numberCouple = this.random.nextInt(aux.length - 1);
		return number + "," + aux[numberCouple];
	}
	
	private String getNumberQuadrupleBet() {
		int number = this.random.nextInt(37);
		String result = "";
		if(this.tablero.tablero.get(number).getNumero() == number)
			result = this.tablero.tablero.get(number).getVecinosCuadruple() + "," + number;
		return result;
	}

	private String getLine() {
		int number = this.random.nextInt(37);
		String result = "";
		if(this.tablero.tablero.get(number).getNumero() == number)
			result = this.tablero.tablero.get(number).getLinea() + "," + number;
		return result;
	}
	
	private int calculateBetAmount() {
		if (this.player.getPlayerMoney() > 0)
			return this.random.nextInt(this.player.getPlayerMoney()) + 1;
		else
			return 0;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
