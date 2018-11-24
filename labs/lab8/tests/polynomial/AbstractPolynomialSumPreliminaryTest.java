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
public abstract class AbstractPolynomialSumPreliminaryTest {
	private static final double EPSILON = 0.0;

	private static final String NO_MUTATION_MESSAGE = "\nsum(other) should NOT mutate (that is: change the contents of) the this instance's instance variable nor the parameter other's instance variable\n";

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected abstract Polynomial createZeroPolynomial();

	@Test
	public void testA() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly3xSquared = poly0.addTerm(3.0, 2);
		Polynomial poly4xSquared = poly0.addTerm(4.0, 2);

		// check that addTerm is working correctly
		assertEquals(2, poly3xSquared.degree());
		assertEquals(0.0, poly3xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly3xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(3.0, poly3xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly3xSquared.getCoefficientAtDegree(3), EPSILON);

		assertEquals(2, poly4xSquared.degree());
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(4.0, poly4xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly4xSquared.getCoefficientAtDegree(3), EPSILON);

		// check that sum(other) is working correctly
		Polynomial poly7xSquared = poly3xSquared.sum(poly4xSquared);
		assertEquals(2, poly7xSquared.degree());
		assertEquals(0.0, poly7xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly7xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(7.0, poly7xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly7xSquared.getCoefficientAtDegree(3), EPSILON);

		// check that this is NOT mutated by invoking sum(other)
		assertEquals(NO_MUTATION_MESSAGE, 2, poly3xSquared.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 3.0, poly3xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3xSquared.getCoefficientAtDegree(3), EPSILON);

		// check that other is NOT mutated by invoking sum(other)
		assertEquals(NO_MUTATION_MESSAGE, 2, poly4xSquared.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly4xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly4xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 4.0, poly4xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly4xSquared.getCoefficientAtDegree(3), EPSILON);
	}

	@Test
	public void testB() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly9x = poly0.addTerm(9.0, 1);
		Polynomial poly5xCubed = poly0.addTerm(5.0, 3);

		// check that addTerm is working correctly
		assertEquals(1, poly9x.degree());
		assertEquals(0.0, poly9x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(9.0, poly9x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly9x.getCoefficientAtDegree(3), EPSILON);

		assertEquals(3, poly5xCubed.degree());
		assertEquals(0.0, poly5xCubed.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly5xCubed.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly5xCubed.getCoefficientAtDegree(2), EPSILON);
		assertEquals(5.0, poly5xCubed.getCoefficientAtDegree(3), EPSILON);

		// check that sum(other) is working correctly
		Polynomial poly5xCubedPlus9x = poly9x.sum(poly5xCubed);
		assertEquals(3, poly5xCubedPlus9x.degree());
		assertEquals(0.0, poly5xCubedPlus9x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(9.0, poly5xCubedPlus9x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly5xCubedPlus9x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(5.0, poly5xCubedPlus9x.getCoefficientAtDegree(3), EPSILON);

		// check that this is NOT mutated by invoking sum(other)
		assertEquals(NO_MUTATION_MESSAGE, 1, poly9x.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly9x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 9.0, poly9x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly9x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly9x.getCoefficientAtDegree(3), EPSILON);

		// check that other is NOT mutated by invoking sum(other)
		assertEquals(NO_MUTATION_MESSAGE, 3, poly5xCubed.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xCubed.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xCubed.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xCubed.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 5.0, poly5xCubed.getCoefficientAtDegree(3), EPSILON);
	}
}
