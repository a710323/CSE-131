package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab5.Sort;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#findIndexOfLexicographicallyEarliestValue(String[], int)}
 */
@RunWith(Parameterized.class)
public class FindComprehensiveTest {
	private final String[] original;
	private final int fromIndex;
	private final int expected;

	public FindComprehensiveTest(List<String> strings, int fromIndex, int expected) {
		this.original = StringTestUtils.toStringArray(strings);
		this.fromIndex = fromIndex;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] array = Arrays.copyOf(original, original.length);

		int actual = Sort.findIndexOfLexicographicallyEarliestValue(array, fromIndex);
		assertArrayEquals("mutation is neither allowed nor necessary for find", original, array);
		assertTrue(actual >= fromIndex);
		assertEquals(expected, actual);
	}

	@Parameters(name = "strings: {0}; fromIndex: {1}; expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { StringTestUtils.createStringList("A"), 0, 0 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), 0, 0 });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), 0, 1 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), 1, 1 });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), 1, 1 });

		List<String> stringsSorted = StringTestUtils.createStringList("A", "B", "C", "D", "E");
		for (int fromIndex = 0; fromIndex < stringsSorted.size(); fromIndex++) {
			int expected = fromIndex;
			result.add(new Object[] { stringsSorted, fromIndex, expected });
		}

		Random random = new Random();
		final int STRING_LENGTH = 3;
		for (int[] configs : new int[][] { { 5, 4 }, { 10, 7 } }) {
			int iterationCount = configs[0];
			int arrayLength = configs[1];

			for (int iteration = 0; iteration < iterationCount; iteration++) {
				List<String> strings = StringTestUtils.createUniqueStringList(
						() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
				for (int fromIndex = 0; fromIndex < strings.size(); fromIndex++) {
					result.add(new Object[] { strings, fromIndex, IntStream.range(fromIndex, strings.size())
							.reduce((i, j) -> strings.get(i).compareTo(strings.get(j)) < 0 ? i : j).getAsInt() });
				}
			}
		}
		return result;
	}

}
