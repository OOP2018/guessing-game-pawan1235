import java.util.Random;

/**
 * GuessingGame that will random an int to be a secret number
 * 
 * @author Pawan Intawongsa
 *
 */
public class GuessingGame extends NumberGame{
	/** upper bound for secret number */
	private int upperBound;
	/**  the answer of the game*/
	private int secret;
	/** number of user's guess*/
	private int count;
	
	/**
	 * Initialize a new GuessingGame. 
	 * 
	 * @param upperBound upperbound for secret number.
	 */
	public GuessingGame(int upperBound) {
		this.count = 0;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound)+1;
		this.upperBound = upperBound;
		setMessage("I'm thinking of a number between 1 and "+this.upperBound);		
	}
	
	/**
	 * Evaluate a user's guess. 
     * @param number is the user's guess
     * @return true if guess is correct, false otherwise
	 * 
	 */
	public boolean guess(int number) {
		if(this.secret == number) {
			setMessage("Correct, the answer is "+this.secret);
			count++;
			return true;
		}else {
			if(number < this.secret) {
				setMessage("Wrong, The answer is too small");
				count++;
			}else {
				setMessage("Wrong, The answer is too large");
				count++;
			}
			return false;
		}
	}
	
	/**
	 * Get an upperBound
	 */
	public int getUpperBound() {
		return this.upperBound;
	}
	
	@Override
	/**
	 * Get how many times user guessed.
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * Return Game's description.
	 * 
	 */
	public String toString() {
		return "Guess a secret number between 1 and "+this.upperBound;
	}
	
	
	 
}
