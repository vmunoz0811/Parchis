package Model;

import java.util.Date;
import java.util.Random;

public class Dice {
	private static Dice _instanceDice = null;
	Random random;

	private Dice() {
		random = new Random();
		random.setSeed(new Date().getTime());
	}

	public static Dice createDice() {
		if (_instanceDice == null) {
			_instanceDice = new Dice();
		}
		return _instanceDice;
	}

	public int rollDice() {
		int n = random.nextInt(6) + 1;
		GameInterface.diceResults(n);
		return n;
	}
}

