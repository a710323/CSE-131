package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.tests.utils.UnitTestUtils;
import lab8.DensePolynomial;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DensePolynomialAddTermPreliminaryTest {
	private static String arrayMessage(double[] expecteds, double[] actuals) {
		return "\nexpecteds: " + Arrays.toString(expecteds) + "; actuals: " + Arrays.toString(actuals) + "\n";
	}

	private static String noMutationMessage(double[] expecteds, double[] actuals) {
		return "\naddTerm should NOT mutate (that is: change the contents of) the this instance's instance variable"
				+ arrayMessage(expecteds, actuals);
	}

	private static final double EPSILON = 0.0;

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testA() throws IllegalArgumentException, IllegalAccessException {
		DensePolynomial poly0 = new DensePolynomial(); // 0.0 * x ^ 0

		double[] expecteds0 = new double[] { 0.0 };
		double[] actuals0 = CoefficientsAccessUtils.getCoefficients(poly0);

		assertNotNull(actuals0);
		assertArrayEquals(expecteds0, actuals0, EPSILON);

		Polynomial poly7 = poly0.addTerm(7.0, 0); // 7.0 * x ^ 0

		assertSame(DensePolynomial.class, poly7.getClass());

		double[] expecteds7 = { 7.0 };
		double[] actuals7 = CoefficientsAccessUtils.getCoefficients(poly7);
		assertNotNull(actuals7);
		assertArrayEquals(arrayMessage(expecteds7, actuals7), expecteds7, actuals7, EPSILON);

		// ensure that poly0 is NOT mutated (that is: changed)
		double[] actuals0NoMutation = CoefficientsAccessUtils.getCoefficients(poly0);
		assertNotNull(actuals0NoMutation);
		assertArrayEquals(noMutationMessage(expecteds0, actuals0NoMutation), expecteds0, actuals0NoMutation, EPSILON);
	}

	@Test
	public void testB() throws IllegalArgumentException, IllegalAccessException {
		DensePolynomial poly0 = new DensePolynomial(); // 0.0 * x ^ 0

		double[] expecteds0 = new double[] { 0.0 };
		double[] actuals0 = CoefficientsAccessUtils.getCoefficients(poly0);

		assertNotNull(actuals0);
		assertArrayEquals(expecteds0, actuals0, EPSILON);

		Polynomial poly5xCubed = poly0.addTerm(5.0, 3); // 5.0 * x ^ 3

		assertSame(DensePolynomial.class, poly5xCubed.getClass());

		double[] expecteds5xCubed = { 0.0, 0.0, 0.0, 5.0 };
		double[] actuals5xCubed = CoefficientsAccessUtils.getCoefficients(poly5xCubed);
		assertNotNull(actuals5xCubed);
		assertArrayEquals(arrayMessage(expecteds5xCubed, actuals5xCubed), expecteds5xCubed, actuals5xCubed, EPSILON);

		// ensure that poly0 is NOT mutated (that is: changed)
		double[] actuals0NoMutation = CoefficientsAccessUtils.getCoefficients(poly0);
		assertNotNull(actuals0NoMutation);
		assertArrayEquals(noMutationMessage(expecteds0, actuals0NoMutation), expecteds0, actuals0NoMutation, EPSILON);
	}

	@Test
	public void testC() throws IllegalArgumentException, IllegalAccessException {
		DensePolynomial poly0 = new DensePolynomial(); // 0.0 * x ^ 0

		double[] expecteds0 = new double[] { 0.0 };
		double[] actuals0 = CoefficientsAccessUtils.getCoefficients(poly0);

		assertNotNull(actuals0);
		assertArrayEquals(expecteds0, actuals0, EPSILON);

		Polynomial poly4xSquared = poly0.addTerm(4.0, 2); // 4.0 * x ^ 2

		assertSame(DensePolynomial.class, poly4xSquared.getClass());

		double[] expecteds4xSquared = { 0.0, 0.0, 4.0 };
		double[] actuals4xSquared = CoefficientsAccessUtils.getCoefficients(poly4xSquared);
		assertNotNull(actuals4xSquared);
		assertArrayEquals(arrayMessage(expecteds4xSquared, actuals4xSquared), expecteds4xSquared, actuals4xSquared,
				EPSILON);

		// ensure that poly0 is NOT mutated (that is: changed)
		double[] actuals0NoMutation = CoefficientsAccessUtils.getCoefficients(poly0);
		assertNotNull(actuals0NoMutation);
		assertArrayEquals(noMutationMessage(expecteds0, actuals0NoMutation), expecteds0, actuals0NoMutation, EPSILON);

		Polynomial poly7xSquared = poly4xSquared.addTerm(3.0, 2); // 7.0 * x ^ 2

		assertSame(DensePolynomial.class, poly7xSquared.getClass());

		double[] expecteds7xSquared = { 0.0, 0.0, 7.0 };
		double[] actuals7xSquared = CoefficientsAccessUtils.getCoefficients(poly7xSquared);
		assertNotNull(actuals7xSquared);
		assertArrayEquals(arrayMessage(expecteds7xSquared, actuals7xSquared), expecteds7xSquared, actuals7xSquared,
				EPSILON);

		// ensure that poly4xSquared is NOT mutated (that is: changed)
		double[] actuals4xSquaredNoMutation = CoefficientsAccessUtils.getCoefficients(poly4xSquared);
		assertNotNull(actuals4xSquaredNoMutation);
		assertArrayEquals(noMutationMessage(expecteds4xSquared, actuals4xSquaredNoMutation), expecteds4xSquared,
				actuals4xSquaredNoMutation, EPSILON);
	}
}
