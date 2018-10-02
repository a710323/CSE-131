package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.Sort;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#findIndexOfLexicographicallyEarliestValue(String[], int)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FindPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testFromIndex0() {
		String[] original = { "A", "B", "C" };
		String[] array = Arrays.copyOf(original, original.length);

		int actual0 = Sort.findIndexOfLexicographicallyEarliestValue(array, 0);
		assertArrayEquals("mutation is neither allowed nor necessary for find", original, array);
		assertEquals(0, actual0);
	}

	@Test
	public void testFromIndex1() {
		String[] original = { "A", "B", "C" };
		String[] array = Arrays.copyOf(original, original.length);

		int actual1 = Sort.findIndexOfLexicographicallyEarliestValue(array, 1);
		assertArrayEquals("mutation is neither allowed nor necessary for find", original, array);
		assertNotEquals("should never find an index less than fromIndex.  start at fromIndex. ", 0, actual1);
		assertEquals(1, actual1);
	}

	@Test
	public void testLocatedInCenterPosition() {
		String[] original = { "B", "A", "C" };
		String[] array = Arrays.copyOf(original, original.length);

		int actual = Sort.findIndexOfLexicographicallyEarliestValue(array, 0);
		assertArrayEquals("mutation is neither allowed nor necessary for find", original, array);
		assertEquals(1, actual);
	}

	@Test
	public void testLocatedInLastPosition() {
		String[] original = { "B", "C", "A" };
		String[] array = Arrays.copyOf(original, original.length);

		int actual = Sort.findIndexOfLexicographicallyEarliestValue(array, 0);
		assertArrayEquals("mutation is neither allowed nor necessary for find", original, array);
		assertEquals(2, actual);
	}
}
