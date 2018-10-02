package lab5.tests.strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

import lab5.Strings;
import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Strings#isLessThan(String, String)}
 *         {@link Strings#equals(String, String)}
 *         {@link Strings#isGreaterThan(String, String)}
 */
@RunWith(Parameterized.class)
public class StringComparisonTest {
	private final String a;
	private final String b;
	private final CompareResult expected;

	public StringComparisonTest(String a, String b, CompareResult expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testAlphabeticallyLessThan() {
		boolean actual = Strings.isLessThan(a, b);
		if (expected.isExpectedLessThan()) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Test
	public void testEquals() {
		boolean actual = Strings.equals(a, b);
		if (expected.isExpectedEquals()) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Test
	public void testAlphabeticallyGreaterThan() {
		boolean actual = Strings.isGreaterThan(a, b);
		if (expected.isExpectedGreaterThan()) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Parameters(name = "{0}; {1}; expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "", "", CompareResult.EQUALS });

		result.add(new Object[] { "A", "B", CompareResult.LESS_THAN });
		result.add(new Object[] { "A", "A", CompareResult.EQUALS });
		result.add(new Object[] { "B", "A", CompareResult.GREATER_THAN });

		result.add(new Object[] { "AAA", "AAB", CompareResult.LESS_THAN });
		result.add(new Object[] { "AAA", "AAA", CompareResult.EQUALS });
		result.add(new Object[] { "AAB", "AAA", CompareResult.GREATER_THAN });

		result.add(new Object[] { "AAAAA", "AABAA", CompareResult.LESS_THAN });
		result.add(new Object[] { "AAAAA", "AAAAA", CompareResult.EQUALS });
		result.add(new Object[] { "AABAA", "AAAAA", CompareResult.GREATER_THAN });

		Random random = new Random();
		for (int len = 1; len < 5; len++) {
			for (int lcv = 0; lcv < 4; lcv++) {
				String s = StringTestUtils.nextRandomString(random, len);
				result.add(new Object[] { s, s, CompareResult.EQUALS });
			}
		}

		for (int i = 0; i < 8; i++) {
			String a = StringTestUtils.nextRandomString(random, random.nextInt(3) + 2);
			String b = StringTestUtils.nextRandomString(random, random.nextInt(3) + 2);

			result.add(new Object[] { a, b, CompareResult.valueOf(a, b) });

		}
		return result;
	}

	private static enum CompareResult {
		LESS_THAN(true, false, false), EQUALS(false, true, false), GREATER_THAN(false, false, true);
		private final boolean isExpectedLessThan;
		private final boolean isExpectedEquals;
		private final boolean isExpectedGreaterThan;

		private CompareResult(boolean isExpectedLessThan, boolean isExpectedEquals, boolean isExpectedGreaterThan) {
			this.isExpectedLessThan = isExpectedLessThan;
			this.isExpectedEquals = isExpectedEquals;
			this.isExpectedGreaterThan = isExpectedGreaterThan;
		}

		public boolean isExpectedLessThan() {
			return isExpectedLessThan;
		}

		public boolean isExpectedEquals() {
			return isExpectedEquals;
		}

		public boolean isExpectedGreaterThan() {
			return isExpectedGreaterThan;
		}

		public static CompareResult valueOf(String a, String b) {
			int v = a.compareTo(b);
			return v < 0 ? LESS_THAN : (v == 0) ? EQUALS : GREATER_THAN;
		}
	}
}
