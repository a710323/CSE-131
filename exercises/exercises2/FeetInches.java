package exercises2;

import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		//
		// Prompt the user for a number of inches
		//
		// Convert that into feet and inches
		//   BUT
		// Be sure to use the singular "foot" or "inch"
		//   where appropriate, as discussed in
		//   the introductory video
		//
		// For example, 61 inches would produce
		//    the output
		//   5 feet and 1 inch
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int input = ap.nextInt("Enter number of inches");
		int foot = input / 12;
		int inch = input % 12;
		if (input == 1) {
			System.out.println(input + " inch equals to:");
		}
		else {
			System.out.println(input + " inches equals to:");
		}
		
		if (foot == 1) {
			System.out.println(foot + " foot");
		}
		else {
			System.out.println(foot + " feet");
		}
		if (inch == 1) {
			System.out.println(inch + " inch");
		}
		else {
			System.out.println(inch + " inches");
		}
	}
}

	
