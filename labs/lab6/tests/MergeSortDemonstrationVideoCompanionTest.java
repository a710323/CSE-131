package lab6.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import lab6.MergeSort;

/**
 * <A HREF="https://youtu.be/Pr2Jf83_kG0">demonstration video</A>.
 * 
 * tests {@link MergeSort#createSortedArray(String[])}
 * 
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MergeSortDemonstrationVideoCompanionTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		// we prepend spaces to support reasonable string based sorting
		String[] array = { "108", " 15", " 50", "  4", "  8", " 42", " 23", " 16" };
		String[] expected = { "  4", "  8", " 15", " 16", " 23", " 42", " 50", "108" };
		String[] actual = MergeSort.createSortedArray(array);
		assertArrayEquals(StringTestUtils.createMessage(expected, actual), expected, actual);
	}
}
