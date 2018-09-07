package studio2;

import cse131.ArgsProcessor;

public class Ruin {
	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);

		int startAmount = ap.nextInt("Enter the amount of money at the start");
		double winChance = ap.nextDouble("Enter the win rate for each game");
		double winAmount = ap.nextDouble("Enter the amount of money you would get if win");
		int totalPlays = ap.nextInt("Total number of play");
		double lossChance = 1 - winChance;

		for(int i=0; i<totalPlays; i++) {
			double playAmount = startAmount;
			int rounds = 0;
			String outcome = "";
			while(playAmount > 0 && playAmount < winAmount) {
				if(Math.random() < winChance) {
					playAmount ++ ;

				}
				else {
					playAmount --;

				}
				rounds++;
			}
			if(playAmount == 0) {
				outcome = "Lose";
			}
			else {
				outcome = "Win";
			}
			if(i+1>9) {
				System.out.println("Simulation " + (i+1) + " : " + rounds + "  rounds  " + " " + outcome);
			}
			else {
				System.out.println("Simulation " + (i+1) + "  : " + rounds + "  rounds  " + " " + outcome);
			}
		}

	}
}
