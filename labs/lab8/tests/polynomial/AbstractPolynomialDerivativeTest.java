package lab8.tests.polynomial;

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
public abstract class AbstractPolynomialDerivativeTest extends AbstractPolynomialSupplierTest {
	private final List<Term> terms;
	private final List<Term> termsPrime;

	public AbstractPolynomialDerivativeTest(Supplier<Polynomial> polynomialSupplier, String text, String textPrime) {
		super(polynomialSupplier);
		this.terms = PolynomialTermUtils.parseTerms(text);
		this.termsPrime = PolynomialTermUtils.parseTerms(textPrime);
	}

	@Test
	public void test() {
		Polynomial polynomial = createPolynomial(terms);
		checkTerms("initial check of original polynomial", polynomial, terms);
		checkTerms("check of derivative", polynomial.derivative(), termsPrime);
		checkTerms("post derivative check of original polynomial", polynomial, terms);
	}

	@Parameters(name = "polynomial: {0}; derivative: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "1", "0" });
		result.add(new Object[] { "x + 1", "1" });
		result.add(new Object[] { "x^2 + x + 1", "2x + 1" });

		result.add(new Object[] { "42", "0" });
		result.add(new Object[] { "2x + 3", "2" });
		result.add(new Object[] { "4x^2 + 5x + 6", "8x + 5" });

		result.add(new Object[] { "-273.15", "0" });
		result.add(new Object[] { "7x - 8", "7" });
		result.add(new Object[] { "-9x^2 + 10x - 11", "-18x + 10" });

		Random random = new Random();
		final int ITERATION_COUNT = 16;
		final int HIGHEST_DEGREE = 5;
		for (int i = 0; i < ITERATION_COUNT; ++i) {
			StringBuilder sbPrime = new StringBuilder();
			boolean[] isPositivePrefixIncluded = { false };
			String text = nextPolynomialText(random, 0.5, HIGHEST_DEGREE, (coefficient, d) -> {
				if (coefficient >= 0.0) {
					if (isPositivePrefixIncluded[0]) {
						sbPrime.append("+");
					}
				}
				if (d > 0) {
					sbPrime.append(coefficient * d);
					appendDegree(sbPrime, d - 1);
				}
				isPositivePrefixIncluded[0] = true;
			});
			result.add(new Object[] { text, PolynomialTermUtils.addSpacesAroundSigns(sbPrime.toString()) });
		}

		result.add(new Object[] { "", "" });
		return result;
	}
}
