package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.DensePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialConstructorTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		DensePolynomial polynomial = new DensePolynomial();

		Field[] fields = polynomial.getClass().getDeclaredFields();
		assertEquals(1, fields.length);
		Field coefficientsField = fields[0];
		Class<?> type = coefficientsField.getType();
		assertTrue(type.isArray());
		assertSame(Double.TYPE, type.getComponentType());

		assertTrue(Modifier.isPrivate(coefficientsField.getModifiers()));
		assertTrue(Modifier.isFinal(coefficientsField.getModifiers()));

		double[] expected = new double[] { 0.0 };
		double[] actual = CoefficientsAccessUtils.getCoefficients(polynomial);
		assertArrayEquals(expected, actual, 0.0);
	}
}
