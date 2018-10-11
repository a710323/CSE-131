package studio5x;

import cse131.NotYetImplementedException;
import lab5.Strings;

public class MergeCombiner {
	/**
	 * Produces an array which is the sorted result of merging the two specified,
	 * sorted input arrays a and b.
	 * 
	 * For example, when the arrays { "E", "G", "N" } and {"B", "I", "S" } are
	 * passed to this method, the resulting array { "B", "E", "G", "I", "N", "S" }
	 * should be returned.
	 * 
	 * If either input array a or b is unsorted, then the results are undefined.
	 * 
	 * This method must not mutate (that is: change the contents of) the input
	 * arrays a or b, nor would it have any real reason to do so.
	 * 
	 * @param a
	 *            a sorted array
	 * @param b
	 *            another sorted array
	 * @return a new array which contains the contents of both a and b, sorted.
	 */
	public static String[] createMergeCombinedArray(String[] a, String[] b) {
		String[] input = new String[a.length+b.length];
		int i =0, j = 0, z=0;
		while(i<a.length && j<b.length) {

			if(Strings.isLessThan(a[i], b[j])) {
				input[z]=a[i];
				z++; i++;
			}
			else if(Strings.isLessThan(b[j], a[i])) {
				input[z]=b[j];
				z++; j++;
			}
			else {
				input[z] = a[i];
				z++;
				input[z] = b[j];
				z++;
				i++;
				j++;
			}
		}
		while(j<b.length) {
			input[z] = b[j];
			j++;
			z++;
		}
		while(i<a.length) {
			input[z] = a[i];
			i++;
			z++;
		}
		return input;
	}
}
