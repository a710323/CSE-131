package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import java.util.Map;
import java.util.TreeMap;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialAddSingleZeroCoefficientTermTest;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialAddSingleZeroCoefficientTermTest
		extends AbstractPolynomialAddSingleZeroCoefficientTermTest {
	public SparsePolynomialAddSingleZeroCoefficientTermTest(int degree) {
		super(degree);
	}

	@Override
	public void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException {
		SparsePolynomial polynomial = new SparsePolynomial();

		Map<Integer, Double> shouldBeEmptyMap = MapAccessUtils.getMap(polynomial);
		assertEquals(0, shouldBeEmptyMap.size());

		int degree = getDegree();
		double coefficient = 0.0;
		Polynomial polynomialPrime = polynomial.addTerm(coefficient, degree);

		assertSame(SparsePolynomial.class, polynomialPrime.getClass());

		Map<Integer, Double> actualPrime = MapAccessUtils.getMap(polynomialPrime);

		Map<Integer, Double> expected = new TreeMap<>();
		Map<Integer, Double> unexpected = new TreeMap<>();
		unexpected.put(degree, 0.0);
		assertNotEquals(toNotIgnorigingZeroCoefficientMessage(), unexpected, actualPrime);
		assertEquals(toSizeMessage(expected, actualPrime), 0, actualPrime.size());
	}

	private static String toNotIgnorigingZeroCoefficientMessage() {
		return "\nThis error is so common we created a custom test to ensure that you are NOT returning this result.\nWhen asked to add a 0.0 coefficient term you should simply return the \"this\" polynomial unchanged.\nNote: you are free to do this because your class is immutable.\nIn this case, the map should be: {}";
	}

	private static String toSizeMessage(Map<Integer, Double> expected, Map<Integer, Double> actualPrime) {
		return "map sizes to not match\nmaps:\n\texpected: " + expected + " but was " + actualPrime + "\nsizes:\n\t";
	}
}
