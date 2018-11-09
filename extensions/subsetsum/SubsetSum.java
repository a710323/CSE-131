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
		int[] copy = new int[allnums.length];
		for(int i = 0; i < allnums.length; i++) {
			copy[i] = allnums[i];
		}
		while (sumSol(solution) != sum) {


			for (int i = 0; i < 7; i++) {
				int a = (int)(Math.random() * (copy.length - i));
				solution[i] = copy[a];
				swapValue(copy, a, copy.length - (i+1));
			}
		}
//		while (sumSol(solution) != sum) {
//			int a = (int) (Math.random()*copy.length);
//			solution[0] = copy[a];
//			swapValue(copy, a, copy.length-1);
//			int b = (int) (Math.random()*(copy.length-1));
//			solution[1] = copy[b];
//			swapValue(copy, b, copy.length-2);
//			int c = (int) (Math.random()*(copy.length-2));
//			solution[2] = copy[c];
//			swapValue(copy, c, copy.length-3);
//			int d = (int) (Math.random()*(copy.length-3));
//			solution[3] = copy[d];
//			swapValue(copy, d, copy.length-4);
//			int e = (int) (Math.random()*(copy.length-4));
//			solution[4] = copy[e];
//			swapValue(copy, e, copy.length-5);
//			int f = (int) (Math.random()*(copy.length-5));
//			solution[5] = copy[f];
//			swapValue(copy, f, copy.length-6);
//			int g = (int) (Math.random()*(copy.length-6));
//			solution[6] = copy[g];
//			swapValue(copy, g, copy.length-7);
//		}

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