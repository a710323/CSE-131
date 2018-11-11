package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;

/**
 * @author Ron Cytron
 * @author Dennis Cosgrove
 */
public abstract class AbstractPolynomialEvalBTest {
	private final double coeff;
	private final double x;

	public AbstractPolynomialEvalBTest(double coeff, double x) {
		this.coeff = coeff;
		this.x = x;
	}

	protected abstract Polynomial createZeroPolynomial();

	/**
	 * Evaluate the same coefficient and x with increasing degree.
	 * 
	 * So for random a and x, this tests a x ^ 0 a x ^1 a x ^2 etc.
	 * 
	 * We make sure neither a nor x is 0.0
	 */
	@Test
	public void testEvaluate() {
		Polynomial base = createZeroPolynomial();
		double singleTermResult = coeff;
		double allTermsResult = singleTermResult;
		Polynomial allTermsPolynomial = createZeroPolynomial();

		String allTermsMessage = "";
		for (int degree = 0; degree < 100; ++degree) {
			//
			// Loop invariants:
			// singleTermResult = coeff * x^degree
			// allTermsResult = coeff * x^degree + coeff * x^(degree-1) + ... + coeff * x^0
			//

			Polynomial singleTermPolynomial = base.addTerm(coeff, degree);
			String singleTermMessage = String.format("%f*%f^%d", coeff, x, degree);
			assertEquals(singleTermMessage, singleTermResult, singleTermPolynomial.evaluate(x),
					UnitTestUtils.reasonableRelativeEpsilon(singleTermResult));
			singleTermResult = singleTermResult * x;

			allTermsMessage = allTermsMessage + "(" + singleTermMessage + ")";
			allTermsPolynomial = allTermsPolynomial.addTerm(coeff, degree);
			assertEquals(allTermsMessage, allTermsResult, allTermsPolynomial.evaluate(x),
					UnitTestUtils.reasonableRelativeEpsilon(allTermsResult));
			allTermsResult += singleTermResult;

			allTermsMessage = allTermsMessage + "+";
		}
	}

	/**
	 * Generate a random number that is never 0.0
	 * 
	 * @return random double that is not 0.0
	 */
	private static double randomNonZero(Random r) {
		double ans = Math.abs(r.nextInt(4_000_000) * 0.000001) + 0.1; // ensure positive (not zero)
		ans = Math.random() < 0.5 ? ans : -ans; // randomly flip sign
		return ans;
	}

	@Parameters(name = "coeff: {0}, x: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 1.0, 2.0 });
		result.add(new Object[] { 3.0, 10.0 });
		Random random = new Random();
		for (int i = 0; i < 100; ++i) {
			double coeff = randomNonZero(random);
			double x = randomNonZero(random);
			result.add(new Object[] { coeff, x });
		}
		return result;
	}

}
