package lab9.tests.polynomial.sparse;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialConstructorTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		SparsePolynomial polynomial = new SparsePolynomial();

		Field[] fields = polynomial.getClass().getDeclaredFields();
		assertEquals(1, fields.length);
		Field coefficientsField = fields[0];
		Class<?> type = coefficientsField.getType();
		assertTrue(Map.class.isAssignableFrom(type));

		assertTrue(Modifier.isPrivate(coefficientsField.getModifiers()));
		assertTrue(Modifier.isFinal(coefficientsField.getModifiers()));

		Map<Integer, Double> actual = MapAccessUtils.getMap(polynomial);
		assertNotNull(actual);
		assertThat(actual, instanceOf(Map.class));
		assertEquals(0, actual.size());
	}
}
