package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialEvalBTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialEvalBTest extends AbstractPolynomialEvalBTest {
	public SparsePolynomialEvalBTest(double coeff, double x) {
		super(coeff, x);
	}

	@Override
	protected Polynomial createZeroPolynomial() {
		return new SparsePolynomial();
	}
}
