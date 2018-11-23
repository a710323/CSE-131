package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialAddZeroCoefficientTermPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testZeroCoefficient() throws IllegalArgumentException, IllegalAccessException {
		SparsePolynomial poly0 = new SparsePolynomial(); // 0.0 * x ^ 0
		Polynomial poly5xCubed = poly0.addTerm(5.0, 3); // 5.0 * x ^ 3

		assertSame(SparsePolynomial.class, poly5xCubed.getClass());

		Map<Integer, Double> expected5xCubed = MapTestUtils.createDegreeCoefficientMap(0.0, 0.0, 0.0, 5.0);
		Map<Integer, Double> actual5xCubed = MapAccessUtils.getMap(poly5xCubed);
		assertNotNull(actual5xCubed);
		assertEquals(expected5xCubed, actual5xCubed);

		Polynomial also5xCubed = poly5xCubed.addTerm(0.0, 9);

		Map<Integer, Double> actualAlso5xCubed = MapAccessUtils.getMap(also5xCubed);
		String message = "\nThere is no reason that adding 0.0 coefficient terms should result in a different polynomial in any way.\n"
				+ "Therefore, do NOT change the association of degrees to values for added 0.0 coefficient terms.\n";
		assertNotNull(actualAlso5xCubed);
		assertEquals(message, expected5xCubed, actualAlso5xCubed);
	}
}
