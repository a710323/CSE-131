package lab8.tests.polynomial;

import java.util.function.Supplier;

import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialSupplierTest extends AbstractPolynomialTest {
	private final Supplier<Polynomial> polynomialSupplier;

	public AbstractPolynomialSupplierTest(Supplier<Polynomial> polynomialSupplier) {
		this.polynomialSupplier = polynomialSupplier;
	}

	protected Polynomial createPolynomial(Iterable<Term> terms) {
		return PolynomialTermUtils.create(polynomialSupplier, terms);
	}
}
