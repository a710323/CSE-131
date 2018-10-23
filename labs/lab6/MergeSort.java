package lab6;

import cse131.NotYetImplementedException;
import lab5.BinarySearch;
import lab5.Strings;
import studio5x.MergeCombiner;

public class MergeSort {
	/**
	 * The specification for this method is equivalent to
	 * {@link MergeCombiner#createMergeCombinedArray(String[], String[])}
	 * 
	 * @param a
	 *            a sorted array
	 * @param b
	 *            another sorted array
	 * @return a new array which contains the contents of both a and b, sorted.
	 */
	private static String[] mergeCombine(String[] a, String[] b) {
		// if you would prefer to use your implementation from the previous studio,
		// then change the line below to read:
		// final boolean IS_USE_OF_STUDIO_DESIRED = true;
		final boolean IS_USE_OF_STUDIO_DESIRED = false;
		if (IS_USE_OF_STUDIO_DESIRED) {
			return MergeCombiner.createMergeCombinedArray(a, b);
		} else {
			String[] result = new String[a.length + b.length];

			int aReadIndex = 0;
			int bReadIndex = 0;

			int writeIndex = 0;

			// go through both arrays, selecting from the array with the earlier
			// alphabetically string, updating the appropriate indices, of course.
			while (aReadIndex < a.length && bReadIndex < b.length) {
				if (Strings.isLessThan(a[aReadIndex], b[bReadIndex])) {
					result[writeIndex] = a[aReadIndex];
					aReadIndex++;
				} else {
					result[writeIndex] = b[bReadIndex];
					bReadIndex++;
				}
				writeIndex++;
			}

			// copy over the remaining items from a, if it was not the one that completed.
			while (aReadIndex < a.length) {
				result[writeIndex] = a[aReadIndex];
				aReadIndex++;
				writeIndex++;
			}

			// copy over the remaining items from b, if it was not the one that completed.
			while (bReadIndex < b.length) {
				result[writeIndex] = b[bReadIndex];
				bReadIndex++;
				writeIndex++;
			}

			return result;
		}
	}

	/**
	 * Creates a new array whose contents are a sorted in ascending lexicographical
	 * order version of the subrange [min, maxExclusive) in the specified array.
	 * 
	 * The specified min must be greater than or equal to 0 and less than
	 * maxExclusive. The specified maxExclusive must be less than or equal to the
	 * array length and greater than min. If any of these constraints are not met,
	 * the results are undefined.
	 * 
	 * For example, the array: { "H", "S", "C", "M", "I", "P" } with min: 1 and
	 * maxExclusive: 3 would process the indices [1,3) (that is: 1 and 2) to return
	 * a new array: { "C", "S" }.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * array, nor would it have any real reason to do so.
	 * 
	 * @param array
	 *            an array
	 * @param min
	 *            the minimum index of the range (inclusive)
	 * @param maxExclusive
	 *            the maximum index of the range (exclusive)
	 * @return a sorted array of the subrange of contents in the specified array
	 *         from [min, maxExclusive).
	 */
	//This method is the better solution, which doesn't create any array until reach the base case.
	public static String[] createSortedArrayInRange(String[] array, int min, int maxExclusive) {
		if(maxExclusive-min<2) {
			String[] copy = new String[1];
			copy[0] = array[min];
			return copy;
		}
		int mid = (min+maxExclusive)/2;
		String[] x = createSortedArrayInRange(array,min,mid);
		String[] y = createSortedArrayInRange(array,mid,maxExclusive);
		return mergeCombine(x,y);
	}
	//This is the method I'm playing with. Creating 2 new arrays at the time of dividing the input array into smaller ones.
	public static String[] createSortedArrayInRange3(String[] array, int min, int maxExclusive) {
		if((maxExclusive-min)<=1) {
			return array;
		}
		int mid = (min+maxExclusive)/2;
		String[] x = new String[mid-min];
		String[] y = new String[maxExclusive - mid];
		for(int i = min; i < mid; i++) {
			x[i-min] = array[i];
		}
		for(int j = mid; j < maxExclusive; j++) {
			y[j-mid] = array[j];
		}
		String[] w = createSortedArrayInRange3(x, 0, x.length);
		String[] z = createSortedArrayInRange3(y, 0, y.length);
		return mergeCombine(w,z);
	}

	//This is a method using selection sort, and this is my first intuitive answer, but it failed to past the large array test.
		public static String[] createSortedArrayInRange2(String[] array, int min, int maxExclusive) {
			if(maxExclusive-min < 2) {
				String[] copy = new String[1];
				copy[0] = array[min];
				return copy;
			}
			String[] copy = new String[maxExclusive-min];
			for(int i = min; i<maxExclusive-min;i++) {
				copy[i-min] = array[i];
			}
			for(int i = min; i<maxExclusive-min; i++) {
				String stored = copy[i];
				int k = i;
				for(int j=i;j<maxExclusive-min;j++) {
					if(copy[j].compareTo(stored)<0) {
						stored = copy[j];
						k=j;
					}
				}
				String temp = copy[i];
				copy[i] = stored;
				copy[k] = temp;
			}
			return copy;
		}


	/**
	 * Creates a new array whose contents are a sorted in ascending lexicographical
	 * order version of the specified array.
	 * 
	 * For example, the array: { "H", "S", "C", "M", "I", "P" } would return a new
	 * array: { "C", "H", "I", "M", "P", "S" }.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * array, nor would it have any real reason to do so.
	 * 
	 * @param array
	 *            an array
	 * @return a sorted copy of the array
	 */
	public static String[] createSortedArray(String[] array) {
		// handle the 0 array length case here, so the recursive
		// createSortedArrayInRange need not worry about it.
		if (array.length > 0) {
			return createSortedArrayInRange2(array, 0, array.length);
		} else {
			return new String[0];
		}
	}
}
