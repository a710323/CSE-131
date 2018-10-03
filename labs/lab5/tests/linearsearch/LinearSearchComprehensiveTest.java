package lab5.tests.linearsearch;

import static org.junit.Assert.assertArrayEquals;
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

import lab5.LinearSearch;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link LinearSearch#findFirstIndexIn(String[], String)}
 */
@RunWith(Parameterized.class)
public class LinearSearchComprehensiveTest {
	private final String[] original;
	private final String key;
	private final int expectedIndex;

	public LinearSearchComprehensiveTest(List<String> strings, String key, int expectedIndex) {
		this.original = StringTestUtils.toStringArray(strings);
		this.key = key;
		this.expectedIndex = expectedIndex;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	private int search(String[] array) {
		return LinearSearch.findFirstIndexIn(array, key);
	}

	@Test
	public void test() {
		String[] array = Arrays.copyOf(original, original.length);
		int actual = search(array);
		assertEquals(expectedIndex, actual);
	}

	@Test
	public void testNoMutation() {
		String[] array = Arrays.copyOf(original, original.length);
		search(array);
		assertArrayEquals(original, array);
	}

	@Parameters(name = "strings: {0}; key: {1}; expectedIndex: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { StringTestUtils.createStringList(), "A", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("A"), "A", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("A"), "Z", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), "A", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), "B", 1 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), "Z", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), "A", 1 });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), "B", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), "Z", -1 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "A", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "B", 1 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "C", 2 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "D", 3 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "E", 4 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), "Z", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "A", 2 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "B", 4 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "C", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "D", 1 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "E", 3 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "E", "B"), "Z", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "A", "B", "A"), "A", 0 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "A", "B", "A"), "B", 1 });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "A", "B", "A"), "Z", -1 });

		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "B", "A", "B", "A"), "A", 2 });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D", "A", "B", "A", "B", "A"), "B", 3 });

		Random random = new Random();
		final int STRING_LENGTH = 3;
		for (int[] configs : new int[][] { { 5, 4 }, { 10, 7 } }) {
			int iterationCount = configs[0];
			int arrayLength = configs[1];
			for (int i = 0; i < iterationCount; i++) {
				List<String> strings = StringTestUtils.createUniqueStringList(
						() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
				String missingKey = strings.remove(strings.size() - 1);
				int expectedIndex = 0;
				for (String key : strings) {
					result.add(new Object[] { strings, key, expectedIndex });
					expectedIndex++;
				}
				result.add(new Object[] { strings, missingKey, -1 });
			}
		}

		return result;
	}
}
