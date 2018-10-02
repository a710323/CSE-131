package lab5.tests.linearsearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.LinearSearch;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link LinearSearch#findFirstIndexIn(String[], String)}
 */
public class LinearSearchEqualsTest {
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

		// normal test of LinearSearch.findFirstIndexIn(array, key)
		int resultSearchingForSameInstance = LinearSearch.findFirstIndexIn(array, a);
		assertEquals(0, resultSearchingForSameInstance);

		// specific test to catch inappropriate use of ==
		// do NOT use == to compare Strings
		int resultSearchingForDifferentInstanceWhichEquals = LinearSearch.findFirstIndexIn(array, equalsButNotSameA);
		assertNotEquals(
				"\nLinearSearch.findFirstIndexIn(array,key) should find instances of Strings which are equal to each other even if they are not the exact same instance.\nLinearSearch.findFirstIndexIn(array,key) must prefer the use Strings.equals(a,b) method over a==b.\nDo NOT use == for Strings when you want to check if they are equal to each other.\nUse Strings.equals(a,b) or a similar library method.\n",
				-1, resultSearchingForDifferentInstanceWhichEquals);
		assertEquals(
				"\nLinearSearch.findFirstIndexIn(array,key) should find instances of Strings which are equal to each other even if they are not the exact same instance.\nLinearSearch.findFirstIndexIn(array,key) must prefer the use Strings.equals(a,b) method over a==b.\nDo NOT use == for Strings when you want to check if they are equal to each other.\nUse Strings.equals(a,b) or a similar library method.\n",
				0, resultSearchingForDifferentInstanceWhichEquals);
	}
}
