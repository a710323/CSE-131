package lab5.tests.binarysearch;

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

import lab5.BinarySearch;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link BinarySearch#findIndexInSorted(String[], String)}
 */
@RunWith(Parameterized.class)
public class BinarySearchLargeArrayTest {
	private static final int STRING_LENGTH = 5;
	private final String[] original;

	public BinarySearchLargeArrayTest(int arrayLength) {
		Random random = new Random();
		List<String> strings = StringTestUtils
				.createUniqueStringList(() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
		this.original = StringTestUtils.toStringArray(strings);
		Arrays.parallelSort(this.original);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testKeysAt1000RandomIndices() {
		String[] array = Arrays.copyOf(original, original.length);
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {

			int expectedIndex = random.nextInt(array.length);
			String key = array[expectedIndex];
			int actualIndex = BinarySearch.findIndexInSorted(array, key);
			assertEquals(expectedIndex, actualIndex);
		}
	}

	@Test
	public void test10000RandomKeys() {
		String[] array = Arrays.copyOf(original, original.length);
		Random random = new Random();
		for (int i = 0; i < 1_000; i++) {

			String key = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			int expectedIndex = Arrays.binarySearch(original, key);
			if (expectedIndex < 0) {
				expectedIndex = -1;
			}
			int actualIndex = BinarySearch.findIndexInSorted(array, key);
			assertEquals(expectedIndex, actualIndex);
		}
	}

	@Parameters(name = "arrayLength: {0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 131 });
		result.add(new Object[] { 1000 });
		result.add(new Object[] { 1024 });
		result.add(new Object[] { 1853 });
		result.add(new Object[] { 112358 });
		return result;
	}

}
