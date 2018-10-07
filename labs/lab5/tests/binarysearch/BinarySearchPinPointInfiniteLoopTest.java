package lab5.tests.binarysearch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
public class BinarySearchPinPointInfiniteLoopTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		// for some attempted solutions this simple case can trigger an infinite loop
		// which can exhibit as a TestTimedOutException
		String[] original = { "A", "B", "D", "E" };
		String[] array = Arrays.copyOf(original, original.length);
		int actual = BinarySearch.findIndexInSorted(array, "C");
		assertEquals(-1, actual);
		assertArrayEquals(original, array);
	}
}
