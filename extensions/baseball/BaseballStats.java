package baseball;
import cse131.ArgsProcessor;

public class BaseballStats {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("What's your name?");
		int at_bats = ap.nextInt("How many attempts?");
		int hits = ap.nextInt("How many hits?");
		
		System.out.printf("%s  %.3f", name, ((double)hits/at_bats));
		System.out.println();
		boolean allStar = ((double)hits/at_bats) >= 0.270;
		System.out.println("All star worthy? " + allStar);
	}

}
