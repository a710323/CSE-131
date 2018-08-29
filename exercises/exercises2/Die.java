package exercises2;

public class Die {

	public static void main(String[] args) {
        
		//My though is random would generate 0 (inclusive) to 1 (exclusive)
		//So what I need to do is to * 6
		//now the range of random would be 0 to 6 (exclusive)
		//And I add 1 to the random, range becomes 1 to 7 (exclusive)
		//Then I only want the integer part. Casting. use (int)
		
		int dice = ((int) ((Math.random() * 6) + 1));
		System.out.println(dice);
		
		// I use for statement to check if there's anything wrong.		
		//		for( int i=0; i<10000; i++) {
		//			
		//			
		//			int dice = ((int) ((Math.random() * 6) + 1));
		//
		//			System.out.println(dice);
		//			}
		
		//
		// Use the random number generator
		//    (Math.random())
		// so that this program prints out one of
		// the following integers:
		//   1 2 3 4 5 6
		// with equal probability
		//
		// Note this program does not prompt the user
		//  for input, it just produces one of the
		//  above integers as output, as if by 
		//  throw of a die
		//

	}

}
