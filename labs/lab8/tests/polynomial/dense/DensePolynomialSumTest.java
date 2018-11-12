package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialSumTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialSumTest extends AbstractPolynomialSumTest {
	public DensePolynomialSumTest(String aText, String bText, String expectedText) {
		super(DensePolynomial::new, aText, bText, expectedText);
	}
}
