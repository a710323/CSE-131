package studio5x.tests;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import studio5x.MergeCombiner;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link MergeCombiner#createMergeCombinedArray(String[], String[])}
 */
@RunWith(Parameterized.class)
public class NonNullTest {
	private final String[] aOriginal;
	private final String[] bOriginal;

	public NonNullTest(List<String> aStrings, List<String> bStrings) {
		this.aOriginal = StringTestUtils.toStringArray(aStrings);
		this.bOriginal = StringTestUtils.toStringArray(bStrings);
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] a = Arrays.copyOf(aOriginal, aOriginal.length);
		String[] b = Arrays.copyOf(bOriginal, bOriginal.length);
		String[] actual = MergeCombiner.createMergeCombinedArray(a, b);
		assertNotNull(actual);
	}

	@Parameters(name = "a: {0}; b: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return StringTestUtils.createDefaultConstructorArguments();
	}
}
