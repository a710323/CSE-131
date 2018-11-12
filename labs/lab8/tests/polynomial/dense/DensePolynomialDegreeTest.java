package lab8.tests.polynomial.dense;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.DensePolynomial;
import lab8.tests.polynomial.AbstractPolynomialDegreeTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialDegreeTest extends AbstractPolynomialDegreeTest {
	public DensePolynomialDegreeTest(String ignoredDescription, String text, int expectedDegree) {
		super(DensePolynomial::new, text, expectedDegree);
	}
}
