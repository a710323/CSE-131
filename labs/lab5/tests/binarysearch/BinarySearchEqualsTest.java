package lab5.tests.binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.BinarySearch;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link BinarySearch#findIndexInSorted(String[], String)}
 */
public class BinarySearchEqualsTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testEquals() {
		String a = new String("A");
		String equalsButNotSameA = new String("A");

		String[] original = { a };
		String[] array = Arrays.copyOf(original, original.length);

		// assertTrue(a.equals(equalsButNotSameA));
		// assertTrue(a != equalsButNotSameA);

		// normal test of BinarySearch.findIndexInSorted(array, key)
		int resultSearchingForSameInstance = BinarySearch.findIndexInSorted(array, a);
		assertEquals(0, resultSearchingForSameInstance);

		// specific test to catch inappropriate use of ==
		// do NOT use == to compare Strings
		int resultSearchingForDifferentInstanceWhichEquals = BinarySearch.findIndexInSorted(array, equalsButNotSameA);
		assertNotEquals(
				"\nBinarySearch.findIndexInSorted(array,key) should find instances of Strings which are equal to each other even if they are not the exact same instance.\nBinarySearch.findIndexInSorted(array,key) must prefer the use Strings.equals(a,b) method over a==b.\nDo NOT use == for Strings when you want to check if they are equal to each other.\nUse Strings.equals(a,b) or a similar library method.\n",
				-1, resultSearchingForDifferentInstanceWhichEquals);
		assertEquals(
				"\nBinarySearch.findIndexInSorted(array,key) should find instances of Strings which are equal to each other even if they are not the exact same instance.\nBinarySearch.findIndexInSorted(array,key) must prefer the use Strings.equals(a,b) method over a==b.\nDo NOT use == for Strings when you want to check if they are equal to each other.\nUse Strings.equals(a,b) or a similar library method.\n",
				0, resultSearchingForDifferentInstanceWhichEquals);
	}
}
