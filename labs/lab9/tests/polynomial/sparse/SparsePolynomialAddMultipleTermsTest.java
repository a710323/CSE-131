package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab8.Polynomial;
import lab8.tests.polynomial.AbstractPolynomialTest;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class SparsePolynomialAddMultipleTermsTest extends AbstractPolynomialTest {
	private final List<Term> terms;

	public SparsePolynomialAddMultipleTermsTest(String unusedDescription, String text) {
		terms = PolynomialTermUtils.parseTerms(text);
	}

	@Test
	public void testMultipleAddTerms() throws IllegalArgumentException, IllegalAccessException {
		Polynomial polynomial = new SparsePolynomial();

		Map<Integer, Double> prevActualMap = MapAccessUtils.getMap(polynomial);
		assertEquals(0, prevActualMap.size());

		Map<Integer, Double> expectedMap = new HashMap<>();
		int termIndex = 0;
		for (Term term : terms) {
			int degree = term.getDegree();
			double coefficient = term.getCoefficient();
			polynomial = polynomial.addTerm(coefficient, degree);
			expectedMap.compute(degree, (k, v) -> v != null ? v + coefficient : coefficient);
			assertSame(SparsePolynomial.class, polynomial.getClass());
			Map<Integer, Double> actualMap = MapAccessUtils.getMap(polynomial);
			assertNotSame(prevActualMap, actualMap);
			assertEquals(String.format("termIndex: %d ", termIndex), expectedMap, actualMap);
			prevActualMap = actualMap;
			++termIndex;
		}
	}

	@Parameters(name = "{0} polynomial: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		return generatePolynomialTextTestCaseParametersWithReverseAndShuffle();
	}

}
