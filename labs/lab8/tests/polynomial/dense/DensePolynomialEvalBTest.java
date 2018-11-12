package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialEvalBTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialEvalBTest extends AbstractPolynomialEvalBTest {
	public DensePolynomialEvalBTest(double coeff, double x) {
		super(coeff, x);
	}

	@Override
	protected Polynomial createZeroPolynomial() {
		return new DensePolynomial();
	}
}
