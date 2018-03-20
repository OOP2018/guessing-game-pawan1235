package game;
/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new PawanGame(upperBound);
		GameSolver solve = new GameSolver();
		GameConsole game2 = new GameConsole((PawanGame) game);
		game2.play(game);
//		int solution = solve.play(game);
//		System.out.println("The answer is "+solution +". You have guessed "+game.getCount()+" times");
	}
}
