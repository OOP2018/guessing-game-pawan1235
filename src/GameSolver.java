import java.util.Random;

public class GameSolver {
	public int play(NumberGame game) {

		int guess = game.getUpperBound()/2;
		int half = game.getUpperBound()/2;
		int divide = 2;
		System.out.println(game.getMessage());
		while (true) {
			if (!game.guess(guess) && game.getMessage().contains("too small")) {
				if(half/divide > 1) {
					divide *= 2;
				}
				guess = guess + (half/divide);
				
			} else if (!game.guess(guess) && game.getMessage().contains("too large")) {
				if(half/divide > 1) {
					guess = guess - (half/divide);
				}
				divide *= 2;
			} else {
				return guess;
			}
		}

	}

}
