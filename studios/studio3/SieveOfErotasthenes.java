package studio3;

import cse131.ArgsProcessor;

public class SieveOfErotasthenes {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int input = ap.nextInt("Enter an integer that you want to find its prime factors");
		int[] primeArray = new int[input-1];	
		for (int i=2; i <= input; i++ ) {
			primeArray[i-2] = i;
		}
		int multiple = 2;	
		while (multiple <= input) {			
			for(int j = 2; j * multiple <= input; j++) {
				primeArray[multiple*j-2]=0;
			}
			multiple++;
		}
		for(int l=0; l<primeArray.length; l++) {	
			if(primeArray[l] != 0) {
				System.out.print(primeArray[l] + " ");
			}
		}
	}
}