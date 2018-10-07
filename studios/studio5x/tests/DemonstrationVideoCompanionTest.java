package studio5x.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import studio5x.MergeCombiner;

/**
 * <A HREF="https://www.youtube.com/watch?v=YgXWDGZai4s">demonstration
 * video</A>.
 * 
 * tests {@link MergeCombiner#createMergeCombinedArray(String[], String[])}
 * 
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DemonstrationVideoCompanionTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] a = { "E", "G", "N" };
		String[] b = { "B", "I", "S" };
		String[] actual = MergeCombiner.createMergeCombinedArray(a, b);
		String[] expected = { "B", "E", "G", "I", "N", "S" };
		assertArrayEquals(StringTestUtils.createMessage(expected, actual), expected, actual);
	}
}
