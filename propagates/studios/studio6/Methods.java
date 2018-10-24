package studio6;

public class Methods {

	public static int fact (int n) {
		if (n==0) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static int fib (int n) {
		if (n<=1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	public static boolean isOdd(int n) {
		if(n<=0) {
			return false;
		}
		return !isOdd(n-1);
	}
	public static int sum(int a, int b) {
		if(b<=0) {
			return a;
		}
		return sum(a+1,b-1);
	}
	public static int sumDownBy2(int n) {
		if (n==1) {
			return 1;
		}
		if (n==0) {
			return 0;
		}
		return n + sumDownBy2(n-2);
	}
	public static double harmonicSum(double n) {
		if (n==1) {
			return 1;
		}
		return  (1/n) + harmonicSum(n-1);
	}
	public static int mult(int a, int b) {
		if (b==0) {
			return 0;
		}
		return a+ mult(a,b-1);
	}
}
