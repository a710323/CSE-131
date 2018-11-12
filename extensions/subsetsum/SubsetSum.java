package subsetsum;

import java.math.BigInteger;

public class SubsetSum {

	/**
	 * This static method will find a subset of the array that adds up to the sum provided
	 * @param copy the set from which to find the numbers that add up to the provided sum
	 * @param sum the provided sum
	 * @return the subset of allnums that add up to sum
	 */
	public static int[] findSubset2(int[] allnums, int sum) {
		int[] solution = new int[7];	
		while (sumSol(solution) != sum) {
			for (int i = 0; i < 7; i++) {
				int a = (int)(Math.random() * (allnums.length - i));
				solution[i] = allnums[a];
				swapValue(allnums, a, allnums.length - (i+1));
			}
		}
		return solution;
	}

	public static BigInteger factorial(BigInteger a) {
		BigInteger q = new BigInteger("1");
		for(int i = 1; a.compareTo(BigInteger.valueOf(i)) >= 0; i++) {
			q = q.multiply(new BigInteger(i + ""));
		}
		return q;
	}

	
	public static int[] findSubset(int[] allnums, int sum) {
		int[] solution = new int[0];
		for(int i = 1; i < allnums.length; i++) {
			BigInteger count = new BigInteger("0");
			BigInteger totalCount = factorial(new BigInteger(allnums.length+"")).
					divide(factorial(new BigInteger(i +""))).
					divide(factorial(new BigInteger(allnums.length +"")).
							subtract(new BigInteger(i+"")));
			solution = new int[i];
			while (sumSol(solution) != sum && count.compareTo(totalCount) <= 0) {
				for (int j = 0; j < i; j++) {
					int a = (int)(Math.random() * (allnums.length - j));
					solution[j] = allnums[a];
					swapValue(allnums, a, allnums.length - (j+1));
				}
				count.add(BigInteger.ONE);
			}
			if (sumSol(solution) == sum) {
				return solution;
			}
		}
		return null;
	}

	public static int sumSol(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}
	public static void swapValue(int[] array, int index, int index2) {
		int temp = array[index];
		array[index] = array[index2];
		array[index2] = temp;
	}
	public static void main(String[] args) {
		BigInteger a = new BigInteger("70000");
		BigInteger w = factorial(a);
		System.out.println(w);
	}
}