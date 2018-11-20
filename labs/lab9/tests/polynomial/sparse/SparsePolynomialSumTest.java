package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialSumTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialSumTest extends AbstractPolynomialSumTest {
	public SparsePolynomialSumTest(String aText, String bText, String expectedText) {
		super(SparsePolynomial::new, aText, bText, expectedText);
	}
}
