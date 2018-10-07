package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;

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

import lab5.Sort;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#selectionSortInPlace(String[])}
 */
@RunWith(Parameterized.class)
public class SelectionSortComprehensiveTest {
	private final String[] original;

	public SelectionSortComprehensiveTest(List<String> strings) {
		this.original = StringTestUtils.toStringArray(strings);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] expected = Arrays.copyOf(original, original.length);
		Arrays.sort(expected);

		String[] array = Arrays.copyOf(original, original.length);
		Sort.selectionSortInPlace(array);
		assertArrayEquals(StringTestUtils.createMessage(expected, array), expected, array);
	}

	@Parameters(name = "strings: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
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
