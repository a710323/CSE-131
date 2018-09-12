package exercises3;

import java.util.Arrays;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");

		//  Table should include rows and columns for 0...N  
		//     mkaing N+1 rows and columns



		int[][] table = new int[N+1][N+1];//initialize a int table
		System.out.print("     ");//print space for the first row.
		for (int i=0; i<N+1;i++) {//a for loop to print 0 to the number that user enters at the first row
			System.out.print(i+ "  ");
		}
		System.out.println();//switch to the next line
		for(int i=0; i <= N+1; i++) {//print the dash according to the number entered by user
			System.out.print("---");
		}
		System.out.println();//Starting from third row, starting to print the table we want
		for (int i=0; i < N+1; i++) {
			System.out.print(i + " | ");//print number at the first column
			for (int j=0; j < N+1; j++) {//a for loop calculate the times table in each column of the i row
				table[i][j] = i * j;
				int entry = table[i][j];
				if (entry < 10) {//for the clarity, if the product less than 2 digit, put a space before and after the product
					System.out.print(" " + table[i][j]+" ");
				}
				else {//for the clarity, if the product is 2 digit, put a space after the product.
					System.out.print(table[i][j]+ " ");
				}

			}
			System.out.println();//switch line
		}

	}
}