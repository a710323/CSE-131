package subsetsum;

public class SubsetSum {

	/**
	 * This static method will find a subset of the array that adds up to the sum provided
	 * @param copy the set from which to find the numbers that add up to the provided sum
	 * @param sum the provided sum
	 * @return the subset of allnums that add up to sum
	 */
	public static int[] findSubset(int[] allnums, int sum) {
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

}