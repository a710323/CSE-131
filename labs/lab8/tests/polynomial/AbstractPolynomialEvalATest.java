package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialEvalATest extends AbstractPolynomialSupplierTest {
	private final List<Term> terms;

	public AbstractPolynomialEvalATest(Supplier<Polynomial> polynomialSupplier, String text) {
		super(polynomialSupplier);
		this.terms = PolynomialTermUtils.parseTerms(text);
	}

	@Test
	public void test() {
		Polynomial polynomial = createPolynomial(terms);

		double[] xs = { 0.0, 1.0, 0.5, 2.0, 71.0, 131.0 };

		for (double x : xs) {
			double expected = calculateExpected(terms, x);
			double actual = polynomial.evaluate(x);

			assertEquals("x=" + Double.toString(x), expected, actual,
					UnitTestUtils.reasonableRelativeEpsilon(expected));

			double expectedNegative = calculateExpected(terms, -x);
			double actualNegative = polynomial.evaluate(-x);

			assertEquals("x=" + Double.toString(-x), expectedNegative, actualNegative,
					UnitTestUtils.reasonableRelativeEpsilon(expectedNegative));
		}
	}

	@Parameters(name = "{0} polynomial: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return generatePolynomialTextTestCaseParametersWithReverseAndShuffle();
	}

	private static double calculateExpected(List<Term> terms, double x) {
		return terms.stream().mapToDouble(term -> term.getCoefficient() * Math.pow(x, term.getDegree())).sum();
	}
}
