package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab8.CoefficientArrayUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class CoefficientArrayCreateNextCoefficientsComprehensiveTest {
	private final double[] originalPrevCoefficients;
	private final double coefficient;
	private final int degree;
	private final double[] expected;

	public CoefficientArrayCreateNextCoefficientsComprehensiveTest(List<Double> prevCoefficients, double coefficient,
			int degree, List<Double> expected) {
		this.originalPrevCoefficients = prevCoefficients.stream().mapToDouble(Double::doubleValue).toArray();
		this.coefficient = coefficient;
		this.degree = degree;
		this.expected = expected.stream().mapToDouble(Double::doubleValue).toArray();
	}

	@Test
	public void test() {
		double[] passedInPrevCoefficients = Arrays.copyOf(originalPrevCoefficients, originalPrevCoefficients.length);
		double[] nextCoefficients = CoefficientArrayUtils.createNextCoefficients(coefficient, degree,
				passedInPrevCoefficients);
		assertArrayEquals(expected, nextCoefficients, 0.0);

		final String NO_MUTATION_MESSAGE = "\ncreateNextCoefficients should not mutate (that is: change the contents of) its previousCoefficients parameter.";
		assertArrayEquals(NO_MUTATION_MESSAGE, originalPrevCoefficients, passedInPrevCoefficients, 0.0);
	}

	@Parameters(name = "prevCoefficients: {0}; coefficient: {1}; degree: {2}; expected: {3}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { Arrays.asList(2.0), 7.0, 0, Arrays.asList(9.0) });
		result.add(new Object[] { Arrays.asList(2.0), 7.0, 1, Arrays.asList(2.0, 7.0) });
		result.add(new Object[] { Arrays.asList(2.0), 7.0, 2, Arrays.asList(2.0, 0.0, 7.0) });
		result.add(new Object[] { Arrays.asList(2.0), 7.0, 3, Arrays.asList(2.0, 0.0, 0.0, 7.0) });

		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 0, Arrays.asList(9.0, 3.0, 4.0) });
		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 1, Arrays.asList(2.0, 10.0, 4.0) });
		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 2, Arrays.asList(2.0, 3.0, 11.0) });
		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 3, Arrays.asList(2.0, 3.0, 4.0, 7.0) });
		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 4, Arrays.asList(2.0, 3.0, 4.0, 0.0, 7.0) });
		result.add(new Object[] { Arrays.asList(2.0, 3.0, 4.0), 7.0, 5, Arrays.asList(2.0, 3.0, 4.0, 0.0, 0.0, 7.0) });
		return result;
	}
}
