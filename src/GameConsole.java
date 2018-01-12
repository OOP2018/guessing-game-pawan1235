import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		
		// describe the game
		System.out.println(game.toString());

		// This is just an example.
		while(true) {
		Scanner console = new Scanner(System.in);
		System.out.println(game.getMessage());
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			if(correct) {
			System.out.println(game.getMessage());
			return guess;
			}
		}
	}

}
