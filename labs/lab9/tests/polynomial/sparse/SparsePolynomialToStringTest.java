package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialToStringTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link SparsePolynomial#toString()}
 */
@RunWith(Parameterized.class)
public class SparsePolynomialToStringTest extends AbstractPolynomialToStringTest {
	public SparsePolynomialToStringTest(String unusedDecription, String text) {
		super(SparsePolynomial::new, text);
	}
}
