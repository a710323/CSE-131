package lab8.tests.polynomial.dense;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialSumPreliminaryTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialSumPreliminaryTest extends AbstractPolynomialSumPreliminaryTest {
	@Override
	protected Polynomial createZeroPolynomial() {
		return new DensePolynomial();
	}
}
