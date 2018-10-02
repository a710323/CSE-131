package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
 *         {@link Sort#swapValuesAtIndicesInPlace(String[], int, int)}
 */
@RunWith(Parameterized.class)
public class SwapComprehensiveTest {
	private final String[] original;
	private final int aIndex;
	private final int bIndex;

	public SwapComprehensiveTest(List<String> strings, int aIndex, int bIndex) {
		this.original = StringTestUtils.toStringArray(strings);
		this.aIndex = aIndex;
		this.bIndex = bIndex;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] array = Arrays.copyOf(original, original.length);
		Sort.swapValuesAtIndicesInPlace(array, aIndex, bIndex);
		if (aIndex == bIndex) {
			assertArrayEquals(original, array);
		} else {
			assertEquals("the should-be-swapped value at array[" + aIndex + "] is incorrect. ", original[bIndex],
					array[aIndex]);
			assertEquals("the should-be-swapped value at array[" + bIndex + "] is incorrect. ", original[aIndex],
					array[bIndex]);

			for (int i = 0; i < array.length; i++) {
				if (i != aIndex && i != bIndex) {
					assertEquals("the should-be-unchanged value at array[" + i + "] is incorrect. ", original[i],
							array[i]);
				}
			}
		}
	}

	@Parameters(name = "strings: {0}; aIndex: {1}; bIndex: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), 0, 1 });

		List<String> strings = StringTestUtils.createStringList("A", "B", "C", "D", "E");
		for (int i = 0; i < strings.size(); i++) {
			for (int j = 0; j < strings.size(); j++) {
				result.add(new Object[] { strings, i, j });
			}
		}
		return result;
	}
}
