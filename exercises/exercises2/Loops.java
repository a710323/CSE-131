package exercises2;

public class Loops {

	public static void main(String[] args) {
		//
		// Some helpful information:
		//    System.out.print(i);
		// will print the value of i but not skip to a new line
		// in the output
		//
		//    System.out.println(i + "  ");
		// will print the value of i with a few spaces after it, also
		// not skipping to a new line
		//
		//    System.out.println();
		// skips to the next line
		//
		//
		
		//
		// Below each of the following comments,
		//   write code using a while loop
		//   that produces the specified sequence
		// Each loop will be preceded by a statement
		//   that initializes an int variable
		// Each loop's predicate will control how long it
		//   executes
		// Each loop will contain a statement to bump (change)
		//   the int variable
		//
		// To get the most out of this exercise:
		//
		// Move from one loop to the next by 
		//   * changing the starting value
		//   * changing the loop predicate, for example, from <= to <
		//   * changing the loop bump, for example, from i=i+1 to i=i+2
		//
		// Do the best you can here, and then view the solution video
		//
		
		
		
		// 0 to 9 inclusively
		//    produces  0 1 2 3 4 5 6 7 8 9
		int i = 0;
		while (i<10) {
			System.out.print(i + " ");
			i = i +1;
		}
		
		
		
		// 1 to 10 inclusively
		//    produces 1 2 3 4 5 6 7 8 9 10
		int j = 1;
		System.out.println();//print the second loop at the next line

		while (j<=10) {
			System.out.print(j + " ");
			j = j+1;
		}
		
		
		// 0 to 10, including 0, excluding 10
		//    produces 0 1 2 3 4 5 6 7 8 9
	    int k = 0;
	    System.out.println();
	    while (k<10) {
	    	System.out.print(k + " ");
	    	k = k+1;
	    }
		
		System.out.println();
		int l = 0;
		// like the one above, but jumping by 2
		//    produces 0 2 4 6 8
	    while (l<10) {
	    	System.out.print(l + " ");
	    	l = l+2;
	    }
	}

}
