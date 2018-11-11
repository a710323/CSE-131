package lab8.tests.polynomial.dense;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab8.DensePolynomial;
import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialTest;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class DensePolynomialAddMultipleTermsTest extends AbstractPolynomialTest {
	private final List<Term> terms;

	public DensePolynomialAddMultipleTermsTest(String unusedDescription, String text) {
		terms = PolynomialTermUtils.parseTerms(text);
	}

	@Test
	public void testMultipleAddTerms() throws IllegalArgumentException, IllegalAccessException {
		final double EPSILON = 0.0;
		Polynomial polynomial = new DensePolynomial();

		double[] expecteds = { 0.0 };
		double[] actuals0 = CoefficientsAccessUtils.getCoefficients(polynomial);
		assertEquals(1, actuals0.length);
		assertArrayEquals(expecteds, actuals0, EPSILON);

		int termIndex = 0;
		for (Term term : terms) {
			int degree = term.getDegree();
			double coefficient = term.getCoefficient();
			polynomial = polynomial.addTerm(coefficient, degree);
			assertSame(DensePolynomial.class, polynomial.getClass());
			int newLength = Math.max(expecteds.length, term.getDegree() + 1);
			expecteds = Arrays.copyOf(expecteds, newLength);
			expecteds[term.getDegree()] += term.getCoefficient();
			double[] actuals = CoefficientsAccessUtils.getCoefficients(polynomial);
			assertEquals(String.format("termIndex: %d ", termIndex), expecteds.length, actuals.length);
			assertArrayEquals(String.format("termIndex: %d ", termIndex), expecteds, actuals, EPSILON);
			++termIndex;
		}
	}

	@Parameters(name = "{0} polynomial: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return generatePolynomialTextTestCaseParametersWithReverseAndShuffle();
	}

}
