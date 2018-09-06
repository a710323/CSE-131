package exercises3;

import java.util.Arrays;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include rows and columns for 0...N  
		//     mkaing N+1 rows and columns
		int[][] index = new int[N+1][N+1];
		for(int i=0; i < N+1; i++) {
			for(int j=0; j< N+1; j++) {
				index[i][j] = i * j;
			}
		}
		
		for (int i=0; i < N+1; i++) {
			for (int j=0; j < N+1; j++) {
				System.out.print(index[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
