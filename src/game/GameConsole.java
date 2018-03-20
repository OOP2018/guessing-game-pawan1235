package game;
import java.util.Observable;
import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole implements java.util.Observer{

	private PawanGame game;
	
	public GameConsole(PawanGame game) {
		this.game = game;
	}
	
	/** play the game. */
	public int play(NumberGame game) {
		
		// describe the game
		System.out.println(game.toString());

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

	@Override
	public void update(Observable o, Object arg) {
		System.out.printf("You have guessed %d times\n",this.game.getCount());
	}

}
