package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialEvalPreliminaryTest {
	private static final double EPSILON = 0.0;

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected abstract Polynomial createZeroPolynomial();

	@Test
	public void testFourScoreAndSeven() {
		Polynomial poly0 = createZeroPolynomial();
		assertEquals(0, poly0.degree());
		assertEquals(0.0, poly0.getCoefficientAtDegree(0), EPSILON);

		double actual0 = poly0.evaluate(4.0);
		double expected0 = 0.0;
		assertEquals(expected0, actual0, EPSILON);

		Polynomial poly20x = poly0.addTerm(20.0, 1);
		assertEquals(1, poly20x.degree());
		assertEquals(0.0, poly20x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(20.0, poly20x.getCoefficientAtDegree(1), EPSILON);

		double actual80 = poly20x.evaluate(4.0);
		double expected80 = 80.0;
		assertEquals(expected80, actual80, EPSILON);

		Polynomial poly20xPlus7 = poly20x.addTerm(7.0, 0);
		assertEquals(1, poly20xPlus7.degree());
		assertEquals(7.0, poly20xPlus7.getCoefficientAtDegree(0), EPSILON);
		assertEquals(20.0, poly20xPlus7.getCoefficientAtDegree(1), EPSILON);

		double actualFourScoreAndSeven = poly20xPlus7.evaluate(4.0);
		double expectedFourScoreAndSeven = 87.0;
		assertEquals(expectedFourScoreAndSeven, actualFourScoreAndSeven, EPSILON);
	}

}
