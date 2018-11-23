package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.DensePolynomial;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialAddZeroCoefficientTermPreliminaryTest {
	private static String arrayMessage(double[] expecteds, double[] actuals) {
		return "expecteds: " + Arrays.toString(expecteds) + "\nactuals: " + Arrays.toString(actuals) + "\n";
	}

	private static final double EPSILON = 0.0;

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testZeroCoefficient() throws IllegalArgumentException, IllegalAccessException {
		DensePolynomial poly0 = new DensePolynomial(); // 0.0 * x ^ 0
		Polynomial poly5xCubed = poly0.addTerm(5.0, 3); // 5.0 * x ^ 3

		assertSame(DensePolynomial.class, poly5xCubed.getClass());

		double[] expecteds5xCubed = { 0.0, 0.0, 0.0, 5.0 };
		double[] actuals5xCubed = CoefficientsAccessUtils.getCoefficients(poly5xCubed);
		assertNotNull(actuals5xCubed);
		assertArrayEquals(arrayMessage(expecteds5xCubed, actuals5xCubed), expecteds5xCubed, actuals5xCubed, EPSILON);

		Polynomial also5xCubed = poly5xCubed.addTerm(0.0, 9);

		double[] actualsAlso5xCubed = CoefficientsAccessUtils.getCoefficients(also5xCubed);
		assertNotNull(actualsAlso5xCubed);
		String message = "\nThere is no reason that adding 0.0 coefficient terms should result in a different polynomial in any way.\n"
				+ "Therefore, do NOT allocate extra space for added 0.0 coefficient terms.\n"
				+ arrayMessage(expecteds5xCubed, actualsAlso5xCubed);
		assertArrayEquals(message, expecteds5xCubed, actualsAlso5xCubed, EPSILON);

	}
}
