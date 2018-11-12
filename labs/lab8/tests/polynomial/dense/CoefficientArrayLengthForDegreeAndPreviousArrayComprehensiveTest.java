package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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
public class CoefficientArrayLengthForDegreeAndPreviousArrayComprehensiveTest {
	private final int degree;
	private final int prevCoefficientsLength;
	private final int expected;

	public CoefficientArrayLengthForDegreeAndPreviousArrayComprehensiveTest(int degree, int prevCoefficientsLength,
			int expected) {
		this.degree = degree;
		this.prevCoefficientsLength = prevCoefficientsLength;
		this.expected = expected;
	}

	@Test
	public void test() {
		double[] prevCoeffients = new double[prevCoefficientsLength];
		Arrays.fill(prevCoeffients, 1.0);

		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree, prevCoeffients);
		assertEquals(expected, actual);
	}

	@Parameters(name = "degree: {0}, prevCoefficientsLength: {1}, expected: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		final int N = 10;
		for (int degree = 0; degree < N; ++degree) {
			for (int prevArrayLength = 1; prevArrayLength < N + 1; ++prevArrayLength) {
				result.add(new Object[] { degree, prevArrayLength, Math.max(degree + 1, prevArrayLength) });
			}
		}

		Random random = new Random();
		for (int i = 0; i < 3; ++i) {
			int degree = random.nextInt(1_000);
			int prevArrayLength = 1 + random.nextInt(1_000);
			result.add(new Object[] { degree, prevArrayLength, Math.max(degree + 1, prevArrayLength) });
		}

		return result;
	}
}
