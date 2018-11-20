package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialGetCoefficientAtDegreeTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialGetCoefficientAtDegreeTest extends AbstractPolynomialGetCoefficientAtDegreeTest {
	public SparsePolynomialGetCoefficientAtDegreeTest(String unusedDescription, String text) {
		super(SparsePolynomial::new, text);
	}
}
