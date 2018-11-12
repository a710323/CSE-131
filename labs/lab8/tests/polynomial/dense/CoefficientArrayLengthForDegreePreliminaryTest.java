package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lab8.CoefficientArrayUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CoefficientArrayLengthForDegreePreliminaryTest {
	@Test
	public void test() {
		int degree = 131;
		int expected = 132;
		int actual = CoefficientArrayUtils.calculateArrayLengthRequiredFor(degree);
		assertEquals(expected, actual);
	}
}
