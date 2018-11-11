package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import lab8.CoefficientArrayUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CoefficientArrayLengthForDegreeAndPreviousArrayPreliminaryTest {
	@Test
	public void testLower() {
		int degree = 3;

		int prevCoefficientsLength = 5;
		double[] prevCoeffients = new double[prevCoefficientsLength];
		Arrays.fill(prevCoeffients, 1.0);

		int expected = prevCoefficientsLength;
		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree, prevCoeffients);
		assertEquals(expected, actual);
	}

	@Test
	public void testHigher() {
		int degree = 10;

		int prevCoefficientsLength = 7;
		double[] prevCoeffients = new double[prevCoefficientsLength];
		Arrays.fill(prevCoeffients, 1.0);

		int expected = degree + 1;
		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree, prevCoeffients);
		assertEquals(expected, actual);
	}

	@Test
	public void testDegreeSameAsPrevCoefficientsLength() {
		int degree = 6;

		int prevCoefficientsLength = degree;
		double[] prevCoeffients = new double[prevCoefficientsLength];
		Arrays.fill(prevCoeffients, 1.0);

		int expected = degree + 1;
		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree, prevCoeffients);
		assertEquals(expected, actual);
	}
}
