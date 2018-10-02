package lab5.tests.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
 *         {@link Sort#isSorted(String[])}
 */
@RunWith(Parameterized.class)
public class IsSortedTest {
	private final String[] original;
	private final boolean expected;

	public IsSortedTest(List<String> strings, boolean expected) {
		this.original = StringTestUtils.toStringArray(strings);
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		String[] array = Arrays.copyOf(original, original.length);
		boolean actual = Sort.isSorted(array);
		if (expected) {
			assertTrue(actual);
		} else {
			assertFalse(actual);
		}
	}

	@Test
	public void testNoMutation() {
		String[] array = Arrays.copyOf(original, original.length);
		Sort.isSorted(array);
		assertArrayEquals(original, array);
	}

	@Parameters(name = "strings: {0}; expected: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { StringTestUtils.createStringList(), true });
		result.add(new Object[] { StringTestUtils.createStringList("A"), true });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"), true });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A"), false });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "D", "E"), true });
		result.add(new Object[] { StringTestUtils.createStringList("B", "A", "C", "D", "E"), false });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "D", "C", "E"), false });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B", "C", "E", "D"), false });
		return result;
	}
}
