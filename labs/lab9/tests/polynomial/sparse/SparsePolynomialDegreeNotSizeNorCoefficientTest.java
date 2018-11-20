package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import lab8.Polynomial;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialDegreeNotSizeNorCoefficientTest {
	@Test
	public void testDegreeNotSizeNorCoefficient() {
		Polynomial zeroPolynomial = new SparsePolynomial();
		assertEquals(0, zeroPolynomial.degree());

		double coefficient = 131.0;
		int degree = 3;
		Polynomial oneTermPolynomial = zeroPolynomial.addTerm(coefficient, degree);
		assertNotEquals(notSizeMessage(coefficient, degree), 1, oneTermPolynomial.degree());
		assertNotEquals(notValueMessage(coefficient, degree), (int) coefficient, oneTermPolynomial.degree());
		assertEquals(degree, oneTermPolynomial.degree());
	}

	private static String notSizeMessage(double coefficient, int degree) {
		return "\nReturning .size()???  Do NOT return .size().\nFor polynomial: " + coefficient + " x " + degree
				+ "\nExpected: " + degree;
	}

	private static String notValueMessage(double coefficient, int degree) {
		return "\nReturning value instead of key???  Do NOT return the value.  Return the key.\nFor polynomial: "
				+ coefficient + " x " + degree + "\nExpected: " + degree;
	}
}
