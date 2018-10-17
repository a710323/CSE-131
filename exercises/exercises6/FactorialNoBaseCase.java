package exercises6;

public class FactorialNoBaseCase {
	
	public static int factorial(int n) {
		return n * factorial(n-1);
	}
	//Since factorial method does not have a base case, 
	//factorial(2) will not produce the correct answer.

	public static void main(String[] args) {
		int ans = factorial(2);
		System.out.println("Answer is " + ans);
	}
}
