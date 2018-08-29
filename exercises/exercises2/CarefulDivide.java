package exercises2;

import cse131.ArgsProcessor;

public class CarefulDivide {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numerator   = ap.nextInt("Enter numerator");
		int denominator = ap.nextInt("Enter denominator");

		// Compute numerator / denominator
		//  as an int result
		// BUT if the division has the denominator
		//   as zero, print some error message
		//   instead of the quotient
		// Otherwise, print the quotient
		//
		if (denominator == 0 ) {
			System.out.println("Please enter a denominator other than 0");
		}
		
		
		else {
			int ans = numerator / denominator;
			System.out.println("The quotient is: " + ans);
		}

	}

}
