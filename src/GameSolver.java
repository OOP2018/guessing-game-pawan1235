/**
 * Automatically find the secret to any NumberGame.
 */
public class GameSolver {
	
	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide messages (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 *
	 * @param game is the NumberGame to solve
	 * @return solution of the game
	 */
	public int play(NumberGame game) {

		int guess = game.getUpperBound()/2;
		int half = game.getUpperBound()/2;
		int divide = 2;
		System.out.println(game.getMessage());
		while (!game.guess(guess)) {
			if (game.getMessage().contains("too small")) {
				if(half/divide > 1) {
					divide *= 2;
				}
				guess = guess + (half/divide);
				
			} else if (game.getMessage().contains("too large")) {
				if(half/divide > 1) {
					guess = guess - (half/divide);
				}
				divide *= 2;
			} 
		}
		return guess;

	}

}
