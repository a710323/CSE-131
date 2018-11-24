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
public abstract class AbstractPolynomialDerivativePreliminaryTest {
	private static final double EPSILON = 0.0;

	private static final String NO_MUTATION_MESSAGE = "\nderivative() should NOT mutate (that is: change the contents of) the this instance's instance variable\n";

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected abstract Polynomial createZeroPolynomial();

	@Test
	public void testA() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly5xSquared = poly0.addTerm(5.0, 2);

		// check that addTerm is working correctly
		assertEquals(2, poly5xSquared.degree());
		assertEquals(0.0, poly5xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly5xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(5.0, poly5xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly5xSquared.getCoefficientAtDegree(3), EPSILON);

		// check that derivative() is working correctly
		Polynomial poly10x = poly5xSquared.derivative();
		assertEquals(1, poly10x.degree());
		assertEquals(0.0, poly10x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(10.0, poly10x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly10x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly10x.getCoefficientAtDegree(3), EPSILON);

		// check that "this" is NOT mutated by invoking derivative()
		assertEquals(NO_MUTATION_MESSAGE, 2, poly5xSquared.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xSquared.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xSquared.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 5.0, poly5xSquared.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly5xSquared.getCoefficientAtDegree(3), EPSILON);
	}

	@Test
	public void testB() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly7xCubed = poly0.addTerm(7.0, 3);
		Polynomial poly7xCubedPlus4x = poly7xCubed.addTerm(4.0, 1);

		// check that addTerm is working correctly
		assertEquals(3, poly7xCubedPlus4x.degree());
		assertEquals(0.0, poly7xCubedPlus4x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(4.0, poly7xCubedPlus4x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly7xCubedPlus4x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(7.0, poly7xCubedPlus4x.getCoefficientAtDegree(3), EPSILON);

		// check that derivative() is working correctly
		Polynomial poly21xSquaredPlus4 = poly7xCubedPlus4x.derivative();
		assertEquals(2, poly21xSquaredPlus4.degree());
		assertEquals(4.0, poly21xSquaredPlus4.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly21xSquaredPlus4.getCoefficientAtDegree(1), EPSILON);
		assertEquals(21.0, poly21xSquaredPlus4.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly21xSquaredPlus4.getCoefficientAtDegree(3), EPSILON);

		// check that "this" is NOT mutated by invoking derivative()
		assertEquals(NO_MUTATION_MESSAGE, 3, poly7xCubedPlus4x.degree());
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly7xCubedPlus4x.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 4.0, poly7xCubedPlus4x.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly7xCubedPlus4x.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 7.0, poly7xCubedPlus4x.getCoefficientAtDegree(3), EPSILON);
	}

	@Test
	public void testZeroDerivative() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly3 = poly0.addTerm(3.0, 0);

		// check that addTerm is working correctly
		assertEquals(0, poly3.degree());
		assertEquals(3.0, poly3.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, poly3.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, poly3.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, poly3.getCoefficientAtDegree(3), EPSILON);

		// check that derivative() is working correctly
		Polynomial polyDeriv0 = poly3.derivative();
		assertEquals(0, polyDeriv0.degree());
		assertEquals(0.0, polyDeriv0.getCoefficientAtDegree(0), EPSILON);
		assertEquals(0.0, polyDeriv0.getCoefficientAtDegree(1), EPSILON);
		assertEquals(0.0, polyDeriv0.getCoefficientAtDegree(2), EPSILON);
		assertEquals(0.0, polyDeriv0.getCoefficientAtDegree(3), EPSILON);

		// check that "this" is NOT mutated by invoking derivative()
		assertEquals(NO_MUTATION_MESSAGE, 0, poly3.degree());
		assertEquals(NO_MUTATION_MESSAGE, 3.0, poly3.getCoefficientAtDegree(0), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3.getCoefficientAtDegree(1), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3.getCoefficientAtDegree(2), EPSILON);
		assertEquals(NO_MUTATION_MESSAGE, 0.0, poly3.getCoefficientAtDegree(3), EPSILON);
	}
}
