package studio5;

public class BonusMethods {

	public static int sumDownBy2(int n) {
		int sum = 0;
		for(int i=n; i>0; i = i-2) {
			sum = sum + i;
		}
		return sum;
	}

	public static double harmonicSum(int n) {
		double  sum = 0;
		for (double i = 1; i<= n ;i++) {
			sum = sum + 1/i;
		}
		return sum;
	}

	public static double geometricSum(double k) {
		double sum=0;
		for (double i=0; i<=k; i++) {
			sum = sum+ 1/(Math.pow(2, i));
		}
		return sum;

	}
	public static int multPos (int j, int k) {
		int sum = 0;
		if (k==0) {
			return 0;
		}
		else if(k==1) {
			return j;
		}
		for (int i = 0; i<k; i++) {
			sum = sum + j;
		}
		return sum;
	}

	public static int mult(int j, int k) {
		int ans = multPos(Math.abs(j), Math.abs(k));
		if (j < 0 || k<0) {
			if(j<0&& k<0) {
				return ans;
			}
			else {
				ans = -ans;
			}
		}
		return ans;
	}
	public static int expt(int n, int k ) {
		int ans =1;
		if(k==0) {
			return 1;
		}
		else if(k==1) {
			return n;
		}
		else {
			ans = n;

			for (int i=2; i<=k; i++) {
				ans = ans * n ;
			}

		}
		return (int)ans;
	}

}
