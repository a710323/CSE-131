package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import lab8.CoefficientArrayUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CoefficientArrayCreateNextCoefficientsPreliminaryTest {
	private static final String NO_MUTATION_MESSAGE = "\ncreateNextCoefficients should not mutate (that is: change the contents of) its prevCoefficients parameter.";

	@Test
	public void testLower() {
		double coefficient = 747.0;
		int degree = 2;
		double[] originalPrevCoefficients = { 10.0, 20.0, 30.0, 40.0, 50.0 };
		double[] passedInPrevCoefficients = Arrays.copyOf(originalPrevCoefficients, originalPrevCoefficients.length);
		double[] expectedCoefficients = { 10.0, 20.0, 777.0, 40.0, 50.0 };
		double[] nextCoefficients = CoefficientArrayUtils.createNextCoefficients(coefficient, degree,
				passedInPrevCoefficients);
		assertArrayEquals(expectedCoefficients, nextCoefficients, 0.0);
		assertArrayEquals(NO_MUTATION_MESSAGE, originalPrevCoefficients, passedInPrevCoefficients, 0.0);
	}

	@Test
	public void testHigher() {
		double coefficient = 777.0;
		int degree = 6;
		double[] originalPrevCoefficients = { 10.0, 20.0, 30.0, 40.0, 50.0 };
		double[] passedInPrevCoefficients = Arrays.copyOf(originalPrevCoefficients, originalPrevCoefficients.length);
		double[] expectedCoefficients = { 10.0, 20.0, 30.0, 40.0, 50.0, 0.0, 777.0 };
		double[] nextCoefficients = CoefficientArrayUtils.createNextCoefficients(coefficient, degree,
				passedInPrevCoefficients);
		assertArrayEquals(expectedCoefficients, nextCoefficients, 0.0);
		assertArrayEquals(NO_MUTATION_MESSAGE, originalPrevCoefficients, passedInPrevCoefficients, 0.0);
	}

	@Test
	public void testDegreeSameAsPrevCoefficientsLength() {
		double coefficient = 777.0;
		int degree = 2;
		double[] originalPrevCoefficients = { 10.0, 20.0 };
		double[] passedInPrevCoefficients = Arrays.copyOf(originalPrevCoefficients, originalPrevCoefficients.length);
		double[] expectedCoefficients = { 10.0, 20.0, 777.0 };
		double[] nextCoefficients = CoefficientArrayUtils.createNextCoefficients(coefficient, degree,
				passedInPrevCoefficients);
		assertArrayEquals(expectedCoefficients, nextCoefficients, 0.0);
		assertArrayEquals(NO_MUTATION_MESSAGE, originalPrevCoefficients, passedInPrevCoefficients, 0.0);
	}
}
