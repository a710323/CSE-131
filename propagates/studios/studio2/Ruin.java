package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor (args);

		double startAmount = ap.nextDouble("What is the starting amount?");
		double winChance = ap.nextDouble("What is the chance of winning?");
		double winAmount = ap.nextDouble("What is the win amount?");
		double totalPlays = ap.nextDouble("How many times do you want to simulate this?");
		double lossChance = 1.0 - winChance;
		double ruin = 0.0;


		if(lossChance != winChance) {
			ruin = (Math.pow((lossChance/winChance),startAmount) - Math.pow(lossChance/winChance, winAmount))/(1 - Math.pow(lossChance/winChance, winAmount));
		}
		else {
			ruin = 1 - (startAmount/winAmount);
		}


		double playAmount = startAmount;
		String outcome = "";
		int rounds= 0 ;

		for (int i = 0; i < totalPlays; i++ ) {


			while(playAmount > 0 && playAmount < winAmount) {

				if (Math.random() <= winChance) {
					playAmount++;
				}
				else {
					playAmount--;
				}
				rounds++;				


			}


			if (playAmount >= winAmount) {
				outcome = "WIN";


			}
			else {
				outcome = "LOSE";


			}
			System.out.println("Simulation " + (i+1) + ": " + rounds + " " + outcome) ;

		}

	}

}
