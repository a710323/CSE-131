package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lab8.DensePolynomial;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialIsAPolynomialTest {
	@Test
	public void test() {
		assertTrue(Polynomial.class.isAssignableFrom(DensePolynomial.class));
	}
}
