package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lab8.Polynomial;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialIsAPolynomialTest {
	@Test
	public void test() {
		assertTrue(Polynomial.class.isAssignableFrom(SparsePolynomial.class));
	}
}
