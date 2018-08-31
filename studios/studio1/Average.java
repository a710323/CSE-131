package studio1;
import cse131.ArgsProcessor;

public class Average {
	public static void main(String[] args) {
		ArgsProcessor input1 = new ArgsProcessor(args);
		int n1 = input1.nextInt("Enter the first of two integer you want to calculate the average.");
		int n2 = input1.nextInt("Enter the second of two integer you want to calculate the average.");
		double average = ((double) n1 + n2) / 2;
		System.out.println("The average of the two integer is: " + average);
	}
}
