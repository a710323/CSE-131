package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialEvalATest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialEvalATest extends AbstractPolynomialEvalATest {
	public SparsePolynomialEvalATest(String unusedDescription, String text) {
		super(SparsePolynomial::new, text);
	}
}
