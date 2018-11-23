package lab8.tests.polynomial.dense;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialEvalPreliminaryTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialEvalPreliminaryTest extends AbstractPolynomialEvalPreliminaryTest {
	@Override
	protected Polynomial createZeroPolynomial() {
		return new DensePolynomial();
	}
}
