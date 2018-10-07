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
public class SelectionSortLargeArrayTest {
	private final String[] original;
	private final String[] expected;

	public SelectionSortLargeArrayTest(int arrayLength) {
		final int STRING_LENGTH = 5;
		Random random = new Random();
		List<String> strings = StringTestUtils
				.createUniqueStringList(() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
		this.original = StringTestUtils.toStringArray(strings);
		this.expected = Arrays.copyOf(original, original.length);
		Arrays.parallelSort(this.expected);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] array = Arrays.copyOf(original, original.length);
		Sort.selectionSortInPlace(array);
		assertArrayEquals(StringTestUtils.createMessage(expected, array), expected, array);
	}

	@Parameters(name = "arrayLength: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 131 });
		result.add(new Object[] { 1853 });
		return result;
	}

}
