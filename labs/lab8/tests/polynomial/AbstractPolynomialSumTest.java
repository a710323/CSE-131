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
public abstract class AbstractPolynomialSumTest extends AbstractPolynomialSupplierTest {
	private final List<Term> aTerms;
	private final List<Term> bTerms;
	private final List<Term> expectedTerms;

	public AbstractPolynomialSumTest(Supplier<Polynomial> polynomialSupplier, String aText, String bText,
			String expectedText) {
		super(polynomialSupplier);
		this.aTerms = PolynomialTermUtils.parseTerms(aText);
		this.bTerms = PolynomialTermUtils.parseTerms(bText);
		this.expectedTerms = PolynomialTermUtils.parseTerms(expectedText);
	}

	@Test
	public void test() {
		Polynomial a = createPolynomial(aTerms);
		checkTerms("initial check of a", a, aTerms);

		Polynomial b = createPolynomial(bTerms);
		checkTerms("initial check of b", b, bTerms);

		Polynomial actual = a.sum(b);
		checkTerms("check of sum", actual, expectedTerms);

		checkTerms("post sum check of a", a, aTerms);
		checkTerms("post sum check of b", b, bTerms);
	}

	@Parameters(name = "a: {0}; b: {1}; a+b: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "1", "2", "3" });
		result.add(new Object[] { "x + 1", "x", "2x + 1" });
		result.add(new Object[] { "x + 1", "x^2", "x^2 + x + 1" });
		result.add(new Object[] { "x^2 + x + 1", "3x^2", "4x^2 + x + 1" });

		Random random = new Random();
		final int ITERATION_COUNT = 16;
		final int HIGHEST_DEGREE = 5;
		for (int i = 0; i < ITERATION_COUNT; ++i) {
			List<Term> aTerms = new LinkedList<>();
			List<Term> bTerms = new LinkedList<>();

			List<Term> expectedTerms = new LinkedList<>();

			double portionOfTermsIncluded = 0.8;
			for (int d = HIGHEST_DEGREE; d >= 0; --d) {
				double aCoefficient;
				double bCoefficient;
				if (random.nextDouble() < portionOfTermsIncluded) {
					aCoefficient = nextNonZeroCoefficient(random);
					aTerms.add(new Term(aCoefficient, d));
				} else {
					aCoefficient = 0.0;
				}
				if (random.nextDouble() < portionOfTermsIncluded) {
					bCoefficient = nextNonZeroCoefficient(random);
					bTerms.add(new Term(bCoefficient, d));
				} else {
					bCoefficient = 0.0;
				}
				double expectedCoefficient = aCoefficient + bCoefficient;
				if (expectedCoefficient != 0.0) {
					expectedTerms.add(new Term(expectedCoefficient, d));
				}
			}
			result.add(new Object[] { PolynomialTermUtils.toString(aTerms), PolynomialTermUtils.toString(bTerms),
					PolynomialTermUtils.toString(expectedTerms) });
		}

		result.add(new Object[] { "", "", "" });
		return result;
	}
}
