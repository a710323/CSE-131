package studio5x.tests;

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
import studio5x.MergeCombiner;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Sort#selectionSortInPlace(String[])}
 */
@RunWith(Parameterized.class)
public class MergeCombinerLargeArrayTest {
	private final String[] aOriginal;
	private final String[] bOriginal;
	private final String[] expected;

	public MergeCombinerLargeArrayTest(int aArrayLength, int bArrayLength) {
		final int STRING_LENGTH = 5;
		Random random = new Random();
		this.aOriginal = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
				() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), aArrayLength));
		this.bOriginal = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
				() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), bArrayLength));
		this.expected = StringTestUtils.createUninspiringlyCombinedArray(aOriginal, bOriginal);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] a = Arrays.copyOf(aOriginal, aOriginal.length);
		String[] b = Arrays.copyOf(bOriginal, bOriginal.length);
		String[] actual = MergeCombiner.createMergeCombinedArray(a, b);
		assertArrayEquals(StringTestUtils.createMessage(expected, actual), expected, actual);
	}

	@Parameters(name = "aArrayLength: {0}; bArrayLength: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 131, 131 });
		result.add(new Object[] { 131, 1853 });
		result.add(new Object[] { 1853, 131 });
		result.add(new Object[] { 1853, 1853 });
		result.add(new Object[] { 112358, 131 });
		result.add(new Object[] { 1853, 112358 });
		result.add(new Object[] { 112358, 112358 });
		return result;
	}

}
