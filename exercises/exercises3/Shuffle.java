package exercises3;

import java.util.Arrays;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		System.out.println();
		String[] shuffled = new String[original.length];
		for(int i=original.length - 1; i>=0; i--) {
			int randomPick = (int)(Math.random() * (i+1));
			shuffled[i] = original[randomPick];
			for(int j=randomPick; j < shuffled.length - 1; j++) {
				original[j] = original[j+1];
			}
			System.out.println("Shuffled at " + i + " is " + shuffled[i]);
		}
		System.out.println(Arrays.toString(shuffled));
	}
	
}