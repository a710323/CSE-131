package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractPolynomialGetCoefficientAtDegreePreliminaryTest {
	private static final double EPSILON = 0.0;

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected abstract Polynomial createZeroPolynomial();

	@Test
	public void test0() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0
		assertEquals(0.0, poly0.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly0.getCoefficientAtDegree(131), EPSILON);
	}

	@Test
	public void testA() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0

		Polynomial poly7 = poly0.addTerm(7.0, 0); // 7.0 x ^ 0
		assertEquals(7.0, poly7.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly7.getCoefficientAtDegree(131), EPSILON);
	}

	@Test
	public void testB() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0

		Polynomial poly5x = poly0.addTerm(5.0, 1); // 5.0 x ^ 1
		assertEquals(0.0, poly5x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(5.0, poly5x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly5x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly5x.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly5x.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly5x.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly5x.getCoefficientAtDegree(131), EPSILON);

		Polynomial poly9x = poly5x.addTerm(4.0, 1); // 9.0 x ^ 1
		assertEquals(0.0, poly9x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(9.0, poly9x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(131), EPSILON);

		Polynomial poly9xPlus7 = poly9x.addTerm(7.0, 0); // (9.0 x ^ 1) + (7.0 x ^ 0)
		assertEquals(7.0, poly9xPlus7.getCoefficientAtDegree(0), EPSILON);
		assertEquals(9.0, poly9xPlus7.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly9xPlus7.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly9xPlus7.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly9xPlus7.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly9xPlus7.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly9xPlus7.getCoefficientAtDegree(131), EPSILON);
	}

	@Test
	public void testC() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0

		Polynomial poly6xSquared = poly0.addTerm(6.0, 2); // 6.0 x ^ 2
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(6.0, poly6xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly6xSquared.getCoefficientAtDegree(131), EPSILON);

		Polynomial poly4xSquared = poly6xSquared.addTerm(-2.0, 2); // 4.0 x ^ 2
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(4.0, poly4xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(131), EPSILON);

		Polynomial poly4xSquaredPlus9 = poly4xSquared.addTerm(9.0, 0); // (4.0 x ^ 2) + (9.0 x ^ 0)
		assertEquals(9.0, poly4xSquaredPlus9.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly4xSquaredPlus9.getCoefficientAtDegree(1), EPSILON);
		assertEquals(4.0, poly4xSquaredPlus9.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly4xSquaredPlus9.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly4xSquaredPlus9.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly4xSquaredPlus9.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly4xSquaredPlus9.getCoefficientAtDegree(131), EPSILON);
	}

	@Test
	public void testD() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0

		Polynomial poly7xCubed = poly0.addTerm(7.0, 3); // 7.0 x ^ 3
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(2), EPSILON);
		assertEquals(7.0, poly7xCubed.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly7xCubed.getCoefficientAtDegree(131), EPSILON);

		Polynomial poly7xCubedPlus2x = poly7xCubed.addTerm(2.0, 1); // (7.0 x ^ 3) + (2.0 x ^ 1)
		assertEquals(0.0, poly7xCubedPlus2x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(2.0, poly7xCubedPlus2x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly7xCubedPlus2x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(7.0, poly7xCubedPlus2x.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly7xCubedPlus2x.getCoefficientAtDegree(20), EPSILON);
		assertEquals(0.0, poly7xCubedPlus2x.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly7xCubedPlus2x.getCoefficientAtDegree(131), EPSILON);
	}

	@Test
	public void testG() {
		Polynomial poly0 = createZeroPolynomial(); // 0.0 x ^ 0

		Polynomial poly20xToThe71 = poly0.addTerm(20.0, 71); // 20.0 x ^ 71
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(3), EPSILON);
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(20), EPSILON);
		assertEquals(20.0, poly20xToThe71.getCoefficientAtDegree(71), EPSILON);
		assertEquals(0.0, poly20xToThe71.getCoefficientAtDegree(131), EPSILON);
	}
}
