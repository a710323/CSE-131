package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialDerivativeTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialDerivativeTest extends AbstractPolynomialDerivativeTest {
	public SparsePolynomialDerivativeTest(String text, String textPrime) {
		super(SparsePolynomial::new, text, textPrime);
	}
}
