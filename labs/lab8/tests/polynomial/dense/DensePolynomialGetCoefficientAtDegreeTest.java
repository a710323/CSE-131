package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialGetCoefficientAtDegreeTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialGetCoefficientAtDegreeTest extends AbstractPolynomialGetCoefficientAtDegreeTest {
	public DensePolynomialGetCoefficientAtDegreeTest(String unusedDecription, String text) {
		super(DensePolynomial::new, text);
	}
}
