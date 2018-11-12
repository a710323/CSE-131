package lab8.tests.polynomial.dense;

import java.lang.reflect.Method;

import org.junit.Test;

import lab8.DensePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link DensePolynomial#toString()}
 */
public class DensePolynomialToStringIsOverriddenTest {
	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		@SuppressWarnings("unused")
		Method toStringMethod = DensePolynomial.class.getDeclaredMethod("toString");
		// note: we need not check the returned toStringMethod
		// getDeclaredMethod will throw a NoSuchMethodException if it is not found
	}
}
