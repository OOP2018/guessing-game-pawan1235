/**
 * Automatically find the secret to any NumberGame.
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution. The NumberGame object must provide
	 * messages (getMessage) containing the phrase "too small" if a guess is too
	 * small and "too large" if a guess is too large, for efficient solution.
	 *
	 * @param game
	 *            is the NumberGame to solve
	 * @return solution of the game
	 */
	public int play(NumberGame game) {

		int max = game.getUpperBound();
		int min = 1;
		int guessNum = min + (max - min)/2;
		while (!game.guess(guessNum)) {
			if (game.getMessage().contains("too small")) {
				min = guessNum + 1;
				guessNum = min + (max - min)/2;
				
			} else if (game.getMessage().contains("too large")) {
				max = guessNum - 1;
				guessNum = min + (max - min)/2;
			}
			System.out.println(game.getMessage());
			System.out.println("Your answer ? "+guessNum);
		}
		System.out.println(game.getMessage());
		return guessNum;
	}
}
