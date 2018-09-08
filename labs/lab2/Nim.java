package lab2;

import cse131.ArgsProcessor;

public class Nim {
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		int whichMoves = ap.nextInt("First move or Second move? Enter 1 or 2");

		while (whichMoves != 2 && whichMoves != 1) {
			whichMoves = ap.nextInt("First move or Second move? Enter 1 or 2");
		}
		int numSticks = ap.nextInt("Enter the number of sticks at the start of the game");
		int i = 0;
		if (whichMoves == 1) {
			int humanMoves = ap.nextInt("Enter the number of sticks you want to move out, 1 or 2");
			while (humanMoves > 2 || humanMoves <= 0 || humanMoves > numSticks) {
				humanMoves = ap.nextInt("Enter the number of sticks you want to move out, 1 or 2");
			}
			System.out.println("Human starts");
			System.out.println("Round "+ i + " " + numSticks + " sticks at start, human took " + humanMoves + ", so " + (numSticks-humanMoves) + " sticks remain.");

			numSticks = numSticks - humanMoves;
			if (numSticks == 0 ) {
				System.out.println("human wins");
			}
			i = i + 1;
		}
		else {
			System.out.println("Computer starts");
		}
		while(numSticks > 0){
			int compMoves = (int)(Math.random()*2 + 1);
			while (compMoves > numSticks) {
				compMoves = (int)(Math.random()*2 + 1);
			}
			System.out.println("Round "+ i + " " + numSticks + " sticks at start, computer took " + compMoves + ", so " + (numSticks-compMoves) + " sticks remain.") ;
			numSticks = numSticks - compMoves;
			if (numSticks == 0) {
				System.out.println("Computer wins");
			}
			i = i + 1;
			if (numSticks > 0) {
				int humanMoves = ap.nextInt("Enter the number of sticks you want to move out, 1 or 2");
				while (humanMoves > 2 || humanMoves <= 0 || humanMoves > numSticks) {
					humanMoves = ap.nextInt("Enter the number of sticks you want to move out, 1 or 2");
				}
				System.out.println("Round "+ i + " " + numSticks + " sticks at start, human took " + humanMoves + ", so " + (numSticks-humanMoves) + " sticks remain.");

				numSticks = numSticks - humanMoves;
				if(numSticks == 0) {
					System.out.println("Human wins");
				}
				i = i + 1;
			}
		}

	} 

}
