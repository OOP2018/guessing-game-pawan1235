import java.util.Random;

public class GuessingGame extends NumberGame{
	
	private int upperBound;
	private int secret;
	private int count;
	
	public GuessingGame(int upperBound) {
		this.count = 1;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperBound)+1;
		this.upperBound = upperBound;
		setMessage("I'm thinking of a number between 1 and "+this.upperBound);
		
	}
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
	
	public int getUpperBound() {
		return this.upperBound;
	}
	@Override
	public int getCoung() {
		return this.count;
	}
	
	public String toString() {
		return "Guess a secret number between 1 and "+this.upperBound;
	}
	
	
	 
}
