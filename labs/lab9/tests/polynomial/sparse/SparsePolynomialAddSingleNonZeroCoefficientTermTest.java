package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialAddSingleNonZeroCoefficientTermTest;
import lab8.tests.util.Term;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialAddSingleNonZeroCoefficientTermTest
		extends AbstractPolynomialAddSingleNonZeroCoefficientTermTest {
	public SparsePolynomialAddSingleNonZeroCoefficientTermTest(Term term) {
		super(term);
	}

	@Override
	public void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException {
		Polynomial polynomial = new SparsePolynomial();

		Map<Integer, Double> shouldBeEmptyMap = MapAccessUtils.getMap(polynomial);
		assertEquals(0, shouldBeEmptyMap.size());

		int degree = getDegree();
		double coefficient = getCoefficient();
		Polynomial polynomialPrime = polynomial.addTerm(coefficient, degree);

		assertSame(SparsePolynomial.class, polynomialPrime.getClass());

		Map<Integer, Double> shouldHaveOneEntryMap = MapAccessUtils.getMap(polynomialPrime);
		assertEquals(1, shouldHaveOneEntryMap.size());
		Entry<Integer, Double> entry = shouldHaveOneEntryMap.entrySet().iterator().next();
		assertEquals(degree, entry.getKey().intValue());
		final double EPSILON = 0.0;
		assertEquals(coefficient, entry.getValue().doubleValue(), EPSILON);
	}
}
