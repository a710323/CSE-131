package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialAddSingleZeroCoefficientTermTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialAddSingleZeroCoefficientTermTest
		extends AbstractPolynomialAddSingleZeroCoefficientTermTest {
	public DensePolynomialAddSingleZeroCoefficientTermTest(int degree) {
		super(degree);
	}

	@Override
	public void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException {
		final double ZERO_EPSILON = 0.0;
		DensePolynomial polynomial = new DensePolynomial();

		double[] expecteds = new double[] { 0.0 };
		double[] actuals = CoefficientsAccessUtils.getCoefficients(polynomial);

		assertArrayEquals(expecteds, actuals, ZERO_EPSILON);

		int degree = getDegree();
		double coefficient = 0.0;
		Polynomial polynomialPrime = polynomial.addTerm(coefficient, degree);

		assertSame(DensePolynomial.class, polynomialPrime.getClass());

		double[] actualsPrime = CoefficientsAccessUtils.getCoefficients(polynomialPrime);

		if (degree != 0) {
			double[] notIgnoringZeroCoefficientResult = new double[degree + 1]; // note: filled with 0.0
			assertThat(toNotIgnorigingZeroCoefficientMessage(), actualsPrime,
					not(equalTo(notIgnoringZeroCoefficientResult)));
		}

		assertEquals(toLengthMessage(expecteds, actualsPrime), expecteds.length, actualsPrime.length);
		assertArrayEquals(expecteds, actualsPrime, ZERO_EPSILON);
	}

	private static String toNotIgnorigingZeroCoefficientMessage() {
		return "\nThis error is so common we created a custom test to ensure that you are NOT returning this result.\nWhen asked to add a 0.0 coefficient term you should simply return the \"this\" polynomial unchanged.\nNote: you are free to do this because your class is immutable.\nIn this case, the coefficient array should be: [<0.0>]";
	}

	private static String toLengthMessage(double[] expecteds, double[] actualsPrime) {
		return "array lengths to not match\narrays:\n\texpecteds: " + Arrays.toString(expecteds) + " but was "
				+ Arrays.toString(actualsPrime) + "\nlengths:\n\t";
	}
}
