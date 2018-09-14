package studio3;

import cse131.ArgsProcessor;

public class Arraytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		int input = ap.nextInt("Max number?");
		int[] array = new int[input];
		for (int i=2;i<input;i=i+1) {
			array[i] = i;
			for (int j=4;j<input;j=j+2) {
				array[j] = 0;
			}
			for (int k=10;k<input;k=k+5) {
				array[k] = 0;
			}
			for (int l=9;l<input;l=l+12) {
				array[l] = 0;
			}
			for (int a=20;a<input;a=a+29) {
				array[a] = 0;
			}
			for (int b=27;b<input;b=b+12) {
				array[b] = 0;
			}
			for (int c=22;c<input;c=c+11) {
				array[c] = 0;
			}
			for (int c=91;c<input;c=c+28) {
				array[c] = 0;
			}
			if (array[i]>0) {
				System.out.print(array[i] + " ");
			}
		}

	}

}

