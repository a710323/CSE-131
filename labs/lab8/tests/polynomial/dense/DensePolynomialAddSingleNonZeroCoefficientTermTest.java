package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialAddSingleNonZeroCoefficientTermTest;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialAddSingleNonZeroCoefficientTermTest extends AbstractPolynomialAddSingleNonZeroCoefficientTermTest {
	public DensePolynomialAddSingleNonZeroCoefficientTermTest(Term term) {
		super(term);
	}

	@Override
	public void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException {
		final double EPSILON = 0.0;
		DensePolynomial polynomial = new DensePolynomial();

		double[] expecteds = new double[] { 0.0 };
		double[] actuals = CoefficientsAccessUtils.getCoefficients(polynomial);

		assertEquals(expecteds.length, actuals.length);
		assertArrayEquals(expecteds, actuals, EPSILON);

		int degree = getDegree();
		double coefficient = getCoefficient();
		Polynomial polynomialPrime = polynomial.addTerm(coefficient, degree);

		assertSame(DensePolynomial.class, polynomialPrime.getClass());

		double[] expectedsPrime = new double[degree + 1];
		expectedsPrime[degree] = coefficient;
		double[] actualsPrime = CoefficientsAccessUtils.getCoefficients(polynomialPrime);

		assertEquals(expectedsPrime.length, actualsPrime.length);
		assertArrayEquals(expectedsPrime, actualsPrime, EPSILON);
	}
}
