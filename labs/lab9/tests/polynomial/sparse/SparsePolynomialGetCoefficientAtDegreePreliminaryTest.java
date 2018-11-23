package lab9.tests.polynomial.sparse;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialGetCoefficientAtDegreePreliminaryTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialGetCoefficientAtDegreePreliminaryTest
		extends AbstractPolynomialGetCoefficientAtDegreePreliminaryTest {
	@Override
	protected Polynomial createZeroPolynomial() {
		return new SparsePolynomial();
	}
}
