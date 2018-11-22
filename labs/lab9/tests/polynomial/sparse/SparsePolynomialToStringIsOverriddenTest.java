package lab9.tests.polynomial.sparse;

import java.lang.reflect.Method;

import org.junit.Test;

import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link SparsePolynomial#toString()}
 */
public class SparsePolynomialToStringIsOverriddenTest {
	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		@SuppressWarnings("unused")
		Method toStringMethod = SparsePolynomial.class.getDeclaredMethod("toString");
		// note: we need not check the returned toStringMethod
		// getDeclaredMethod will throw a NoSuchMethodException if it is not found
	}
}
