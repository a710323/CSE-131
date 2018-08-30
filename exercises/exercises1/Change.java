package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int initialPennies = ap.nextInt("How many pennies?");
		//System.out.println("The pennies you have is: " + initialPennies);
		int dollar = initialPennies / 100;
		int penniesAfterDollar = initialPennies % 100;
		//System.out.println("You have " + dollar + " dollars");
		int quarter = penniesAfterDollar / 25;
		int penniesAfterQuarter = penniesAfterDollar % 25;
		//System.out.println("And " + quarter + " quarters");
		int dime = penniesAfterQuarter / 10;
		int penniesAfterDime = penniesAfterQuarter % 10;
		//System.out.println("And " + dime + " dimes");
		int pickle = penniesAfterDime / 5;
		int penniesAfterPickle = penniesAfterDime % 5;
		//System.out.println("And " + pickle + " pickles");
		//System.out.println("And " + penniesAfterPickle);
		
		int check = penniesAfterPickle + pickle * 5 + dime * 10 + quarter * 25 + dollar * 100;
		boolean isEqual = check == initialPennies;
		System.out.println("Does the exchange work properly? " + isEqual );
		System.out.println("In the end, you possess: \n" + dollar + " dollars\n" + quarter + " quarter\n" + dime + " dimes\n" + pickle + " pickles");
		System.out.println(penniesAfterPickle + " pennies");
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
	
	}
}