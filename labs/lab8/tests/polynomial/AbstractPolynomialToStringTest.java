package lab8.tests.polynomial;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialToStringTest extends AbstractPolynomialSupplierTest {
	private final List<Term> terms;

	public AbstractPolynomialToStringTest(Supplier<Polynomial> polynomialSupplier, String text) {
		super(polynomialSupplier);
		this.terms = PolynomialTermUtils.parseTerms(text);
	}

	@Test
	public void test() {
		Polynomial polynomial = createPolynomial(terms);
		String stringRepresentation = polynomial.toString();

		// remove white space
		stringRepresentation = stringRepresentation.replaceAll("\\s+", "");

		// remove parentheses
		stringRepresentation = stringRepresentation.replaceAll("\\(+", "");
		stringRepresentation = stringRepresentation.replaceAll("\\)+", "");

		for (Term term : terms) {
			int degree = term.getDegree();
			double coefficient = term.getCoefficient();
			if (degree > 0) {
				if (degree > 1) {
					assertThat(stringRepresentation, containsString("x^"));
					assertThat(stringRepresentation, containsString(Integer.toString(degree)));
				} else {
					assertThat(stringRepresentation, containsString("x"));
				}
			}
			if (Math.abs(coefficient) != 1.0) {
				assertThat(stringRepresentation, containsString(Double.toString(coefficient)));
			}
		}
	}

	@Parameters(name = "{0} polynomial: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return generatePolynomialTextTestCaseParametersWithReverseAndShuffle();
	}
}