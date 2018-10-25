package studio7;

public class Die {
	private int numSides;

	public Die(int numSides) {
		this.numSides = numSides;
	}
	public int random() {
		return (int) (Math.random()*(numSides+1)) ;
	}
	public static void main(String[] args) {
		Die die1 = new Die(6);
		System.out.println(die1.random());
	}


}
