package lab6.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import lab6.MergeSort;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link MergeSort#createSortedArray(String[])}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MergeSortPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testAlreadySorted() {
		String[] original = { "A", "B", "C", "D" };

		String[] array = Arrays.copyOf(original, original.length);
		String[] actual = MergeSort.createSortedArray(array);
		assertArrayEquals(StringTestUtils.createMessage(original, actual), original, actual);
	}

	@Test
	public void testReversed() {
		String[] original = { "D", "C", "B", "A" };

		String[] array = Arrays.copyOf(original, original.length);
		String[] actual = MergeSort.createSortedArray(array);

		String[] expected = { "A", "B", "C", "D" };
		assertArrayEquals(StringTestUtils.createMessage(expected, actual), expected, actual);
	}
}
