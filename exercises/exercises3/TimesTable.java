package exercises3;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
				//  Table should include rows and columns for 0...N  
		//     mkaing N+1 rows and columns
		int[][] table = new int[N+1][N+1];
		System.out.print("     ");
		for (int i=0; i<N+1;i++) {
			System.out.print(i+ "  ");
		}
		System.out.println();
		System.out.println("------------------------------------");
		for (int i=0; i < N+1; i++) {
			System.out.print(i + " | ");
			for (int j=0; j < N+1; j++) {
				table[i][j] = i * j;
				int entry = table[i][j];
				if (entry < 10) {
					System.out.print(" " + table[i][j]+" ");
				}
				else {
					System.out.print(table[i][j]+ " ");
				}
			
			}
			System.out.println();
		}	
	}
}