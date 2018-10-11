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
	public static String[] createSortedArrayInRange(String[] array, int min, int maxExclusive) {
		throw new NotYetImplementedException("delete this line of code and implement this method.");
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
			return createSortedArrayInRange(array, 0, array.length);
		} else {
			return new String[0];
		}
	}
}
