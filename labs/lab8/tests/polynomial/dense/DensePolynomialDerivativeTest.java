package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialDerivativeTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialDerivativeTest extends AbstractPolynomialDerivativeTest {
	public DensePolynomialDerivativeTest(String text, String textPrime) {
		super(DensePolynomial::new, text, textPrime);
	}
}
