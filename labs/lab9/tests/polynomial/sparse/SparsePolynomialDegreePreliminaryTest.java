package lab9.tests.polynomial.sparse;

import lab9.SparsePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialDegreePreliminaryTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialDegreePreliminaryTest extends AbstractPolynomialDegreePreliminaryTest {
	@Override
	protected Polynomial createZeroPolynomial() {
		return new SparsePolynomial();
	}
}
