package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialEvalATest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialEvalATest extends AbstractPolynomialEvalATest {
	public DensePolynomialEvalATest(String unusedDecription, String text) {
		super(DensePolynomial::new, text);
	}
}
