package exercises2;

import cse131.ArgsProcessor;

public class RandomAverages {

	public static void main(String[] args) {

		//
		// Write a loop that computes the average
		//     of 1, 2, ... 1000 doubles
		// In each iteration of that loop, print
		//     the average of the doubles generated
		//     thus far.
		//
		// Your code goes below here.
		
		double sum = 0;
		int i = 0;
		while (i<1000) {
			sum = sum + Math.random();
			i = i + 1;
			System.out.println("Average of sum is: " + sum / i);

		}
		
		
		
		
		
		
		//
		//  Some questions:
		//    1) How does the average change as your loop progresses?
		//       Answer:
		//       The average starts with some random number, as the i increases, the average tends to close to 0.5.
		//    2) Can you write code in your loop that prints out the average only
		//         every 100 iterations, instead of each iteration?
		//       Answer:
		//       I could put the System.out.println("Average of sum is: " + sum /i); outside the loop
	
		
		//Another way I'd try is:
		//double sum = 0;
		//ArgsProcessor ap = new ArgsProcessor(args);
		//int input = ap.nextInt();
		//for (int i=0; i < input; i++) {
		//	sum = sum + Math.random();			
		//}		
		//double average = sum / input;
		//System.out.println(average);
		//       
		//
		
	}

}
