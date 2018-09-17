package exercises4;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");

		//
		//  Read in the data from the opened file, computing the
		//     sum, average, count, max, and min
		//  of the data
		//
		//  count is the number of doubles read from the file
		//  The other statistics should be clear from their names
		//
		int count = 0;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		double sum = 0;


		while(!StdIn.isEmpty()) {
			double d = StdIn.readDouble();
			sum = sum + d;
			count++;
			if (d > max) {
				max = d;
			}
			if (d < min) {
				min = d;
			}

		}
		System.out.println("Sum is: " + sum);
		System.out.println("Count is: " + count);
		System.out.println("Average is: " + (sum/count));
		System.out.println("Max value is: " + max);
		System.out.println("Min value is: " + min);

	}

}
