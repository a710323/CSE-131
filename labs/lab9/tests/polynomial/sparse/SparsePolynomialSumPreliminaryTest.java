package lab9.tests.polynomial.sparse;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialSumPreliminaryTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialSumPreliminaryTest extends AbstractPolynomialSumPreliminaryTest {
	@Override
	protected Polynomial createZeroPolynomial() {
		return new SparsePolynomial();
	}
}
