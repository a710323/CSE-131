package lab6.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import lab6.MergeSort;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link MergeSort#createSortedArrayInRange(String[], int, int)}
 */
@RunWith(Parameterized.class)
public class MergeSortRange1Test {
	private final String[] original;

	public MergeSortRange1Test(List<String> strings) {
		this.original = StringTestUtils.toStringArray(strings);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] expected = Arrays.copyOf(original, original.length);
		Arrays.sort(expected);

		String[] array = Arrays.copyOf(original, original.length);

		for (int min = 0; min < array.length; min++) {
			int maxExclusive = min + 1;
			String[] actual = MergeSort.createSortedArrayInRange(array, min, maxExclusive);
			assertEquals(1, actual.length);
			assertEquals(array[min], actual[0]);
		}
	}

	@Parameters(name = "strings: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();

		result.add(new Object[] { Arrays.asList("A", "B", "C", "D") });
		result.add(new Object[] { Arrays.asList("C", "A", "D", "B") });

		result.add(new Object[] { Arrays.asList("A", "B", "C", "D", "E", "F", "G") });
		result.add(new Object[] { Arrays.asList("E", "D", "G", "A", "F", "B", "C") });

		Random random = new Random();

		final int STRING_LENGTH = 3;
		for (int[] configs : new int[][] { { 5, 4 }, { 10, 7 } }) {
			int iterationCount = configs[0];
			int arrayLength = configs[1];
			for (int i = 0; i < iterationCount; i++) {
				List<String> strings = StringTestUtils.createUniqueStringList(
						() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
				result.add(new Object[] { strings });
			}
		}
		return result;
	}

}
