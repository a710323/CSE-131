package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab8.CoefficientArrayUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class CoefficientArrayLengthForDegreeComprehensiveTest {
	private final int degree;
	private final int expected;

	public CoefficientArrayLengthForDegreeComprehensiveTest(int degree, int expected) {
		this.degree = degree;
		this.expected = expected;
	}

	@Test
	public void test() {
		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree);
		assertEquals(expected, actual);
	}

	@Parameters(name = "degree: {0}, expected: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		final int N = 10;
		for (int degree = 0; degree < N; ++degree) {
			result.add(new Object[] { degree, degree + 1 });
		}

		Random random = new Random();
		for (int i = 0; i < 3; ++i) {
			int degree = N + 1 + random.nextInt(1_000);
			result.add(new Object[] { degree, degree + 1 });
		}

		return result;
	}

}
