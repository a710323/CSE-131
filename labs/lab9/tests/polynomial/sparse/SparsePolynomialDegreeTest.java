package lab9.tests.polynomial.sparse;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.tests.polynomial.AbstractPolynomialDegreeTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialDegreeTest extends AbstractPolynomialDegreeTest {
	public SparsePolynomialDegreeTest(String ignoredDescription, String text, int expectedDegree) {
		super(SparsePolynomial::new, text, expectedDegree);
	}
}
