package exercises2;

import cse131.ArgsProcessor;

public class BadSwap {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int x = ap.nextInt("Enter x");
		int y = ap.nextInt("Enter y");
		
		if (x > y) {
			x = y;     // Bad
			y = x;     // swap!!
		}
		
		System.out.println("x and y are now"
				+ x + " and " + y);
		
		//
		// Student fill in with comments below this line:
		//   Why does the code above *not* swap the values of
		//      x and y?
		//   Note that the bad swap executes only if x>y
		//
		// Your answer: 
		// if x > y, then the statement inside if would execute.
		// First step: assign y to x, which changes the original value of x to y. 
		// Second step: assign x to y, which changes the original value of y to x.
		// In the first step, x value has already changed to y.
		// That means, at the second step, x assign to y is actually assign the value of x, that is y, to y.
		// Leave the values of x and y are both the value of y.

	}

}
