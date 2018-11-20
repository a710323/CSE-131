package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialExtremelyHighDegreeTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		double coefficient = 2.0;
		int degree = Integer.MAX_VALUE;
		double x = 1.0;
		double expected = coefficient;
		Polynomial polynomial = new SparsePolynomial().addTerm(coefficient, degree);
		double actual = polynomial.evaluate(x);
		assertEquals(expected, actual, UnitTestUtils.reasonableEpsilon());
	}
}
