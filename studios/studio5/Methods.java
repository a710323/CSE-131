package studio5;

public class Methods {

	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}

	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return x*y;  // FIXME
	}
/**
 * 
 * @param x one integer
 * @param y another integer
 * @param z another integer
 * @return the average of the integers
 */
	public static double avg3 (int x, int y, int z) {
		double ans = (x+y+z) / 3.0;
		return ans;
	}
	/**
	 * 
	 * @param array input array
	 * @return the sum of the array
	 */
	public static double sumArray (double[] array) {
		double sum = 0;
		for (int i=0;i<array.length;i++) {
			sum = sum + array[i];
		}
		return sum;
	}
	/**
	 * 
	 * @param array input array
	 * @return the average of the array
	 */
	public static double average(double[] array) {
		double z = sumArray(array);
		double ans = z/array.length;
		return ans;
	}
/**
 * \
 * @param s input String
 * @return return the pigLatin of the String
 */
	public static String pig(String s) {
		String s1 = s.substring(1);
		String s2 = s.substring(0,1);
		String s3 = s1+s2 + "ay";
		return s3;
	}

	public static void main(String[] args) {
		String ans = pig("IhateComputerScience");
		System.out.println(ans);
	}
}