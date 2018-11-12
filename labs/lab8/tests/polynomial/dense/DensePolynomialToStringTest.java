package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialToStringTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link DensePolynomial#toString()}
 */
@RunWith(Parameterized.class)
public class DensePolynomialToStringTest extends AbstractPolynomialToStringTest {
	public DensePolynomialToStringTest(String unusedDecription, String text) {
		super(DensePolynomial::new, text);
	}
}
