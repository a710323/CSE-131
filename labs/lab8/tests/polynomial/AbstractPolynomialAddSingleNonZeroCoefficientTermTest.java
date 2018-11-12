package lab8.tests.polynomial;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.UnitTestUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialAddSingleNonZeroCoefficientTermTest extends AbstractPolynomialTest {
	private final Term term;

	public AbstractPolynomialAddSingleNonZeroCoefficientTermTest(Term term) {
		this.term = term;
	}

	protected double getCoefficient() {
		return term.getCoefficient();
	}

	protected int getDegree() {
		return term.getDegree();
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public abstract void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException;

	@Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		Random random = new Random();
		for (int degree = 0; degree < 5; ++degree) {
			result.add(new Object[] { new Term(0.5, degree) });
			result.add(new Object[] { new Term(1.0, degree) });
			result.add(new Object[] { new Term(42.0, degree) });
			result.add(new Object[] { new Term(131.0, degree) });
			for (int i = 0; i < 3; ++i) {
				double coefficient = nextNonZeroCoefficient(random);
				result.add(new Object[] { new Term(coefficient, degree) });
			}
		}
		return result;
	}

}
