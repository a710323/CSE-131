package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.Sort;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#selectionSortInPlace(String[])}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelectionSortPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testAlreadySorted() {
		String[] original = { "A", "B", "C", "D" };

		String[] array = Arrays.copyOf(original, original.length);
		Sort.selectionSortInPlace(array);
		assertArrayEquals(
				"\n\nexpected:\n\t\t" + Arrays.toString(original) + "\nactual:\n\t\t" + Arrays.toString(array) + "\n",
				original, array);
	}

	@Test
	public void testReversed() {
		String[] original = { "D", "C", "B", "A" };

		String[] array = Arrays.copyOf(original, original.length);
		Sort.selectionSortInPlace(array);

		String[] expected = { "A", "B", "C", "D" };
		assertArrayEquals(StringTestUtils.createMessage(expected, array), expected, array);
	}
}
