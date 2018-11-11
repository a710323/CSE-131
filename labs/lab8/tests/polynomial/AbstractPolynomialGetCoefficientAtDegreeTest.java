package lab8.tests.polynomial;

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
public abstract class AbstractPolynomialGetCoefficientAtDegreeTest extends AbstractPolynomialSupplierTest {
	private final List<Term> terms;

	public AbstractPolynomialGetCoefficientAtDegreeTest(Supplier<Polynomial> polynomialSupplier, String text) {
		super(polynomialSupplier);
		this.terms = PolynomialTermUtils.parseTerms(text);
	}

	@Test
	public void test() {
		checkTerms(null, createPolynomial(terms), terms);
	}

	@Parameters(name = "{0} polynomial: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return generatePolynomialTextTestCaseParametersWithReverseAndShuffle();
	}
}
