package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.Sort;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#swapValuesAtIndicesInPlace(String[], int, int)}
 */
public class SwapPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] original = { "A", "B" };
		String[] missingTemp0 = { original[0], original[0] };
		String[] missingTemp1 = { original[1], original[1] };
		String[] expected = { original[1], original[0] };

		String[] array = Arrays.copyOf(original, original.length);
		Sort.swapValuesAtIndicesInPlace(array, 0, 1);

		assertFalse("swap should mutate (that is: change) the array.", Arrays.equals(original, array));
		assertFalse("swap should utilize a temp variable. expected: <" + Arrays.toString(expected) + ">; actual:<"
				+ Arrays.toString(array) + ">", Arrays.equals(missingTemp0, array));
		assertFalse("swap should utilize a temp variable. expected: <" + Arrays.toString(expected) + ">; actual:<"
				+ Arrays.toString(array) + ">", Arrays.equals(missingTemp1, array));

		assertArrayEquals(expected, array);
	}
}
