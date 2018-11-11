package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialDegreeTest extends AbstractPolynomialSupplierTest {
	private final List<Term> terms;
	private final int expectedDegree;

	public AbstractPolynomialDegreeTest(Supplier<Polynomial> polynomialSupplier, String text, int expectedDegree) {
		super(polynomialSupplier);
		this.terms = PolynomialTermUtils.parseTerms(text);
		this.expectedDegree = expectedDegree;
	}

	@Test
	public void test() {
		Polynomial polynomial = createPolynomial(terms);
		int actualDegree = polynomial.degree();
		assertEquals(expectedDegree, actualDegree);
	}

	@Parameters(name = "{0} polynomial: {1}; degree: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "1", 0 });
		result.add(new Object[] { "x + 1", 1 });
		result.add(new Object[] { "x^2 + x + 1", 2 });

		result.add(new Object[] { "42", 0 });
		result.add(new Object[] { "2x + 3", 1 });
		result.add(new Object[] { "4x^2 + 5x + 6", 2 });

		result.add(new Object[] { "-273.15", 0 });
		result.add(new Object[] { "7x - 8", 1 });
		result.add(new Object[] { "-9x^2 + 10x - 11", 2 });

		Random random = new Random();
		final int ITERATION_COUNT = 16;
		final int HIGHEST_DEGREE = 5;
		for (int i = 0; i < ITERATION_COUNT; ++i) {
			int[] high = { 0 };
			String text = nextPolynomialText(random, 0.5, HIGHEST_DEGREE, (coefficient, d) -> {
				high[0] = Math.max(high[0], d);
			});
			result.add(new Object[] { text, high[0] });
		}
		result.add(new Object[] { "", 0 });

		List<Object[]> resultWithReversesAndShuffles = new LinkedList<>();
		result.forEach(
				array -> resultWithReversesAndShuffles.add(new Object[] { "in-descending-order", array[0], array[1] }));

		for (Object[] pair : result) {
			int degree = (int) pair[1];
			if (degree > 0) {
				String text = (String) pair[0];
				List<Term> reversedTerms = PolynomialTermUtils.toReversed(text);
				resultWithReversesAndShuffles
						.add(new Object[] { "reversed", PolynomialTermUtils.toString(reversedTerms), degree });
			}
		}

		for (Object[] pair : result) {
			int degree = (int) pair[1];
			if (degree > 1) {
				String text = (String) pair[0];
				List<Term> shuffledTerms = PolynomialTermUtils.toShuffled(text);
				resultWithReversesAndShuffles
						.add(new Object[] { "shuffled", PolynomialTermUtils.toString(shuffledTerms), degree });
			}
		}

		return resultWithReversesAndShuffles;
	}
}
