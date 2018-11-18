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

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialAddSingleZeroCoefficientTermTest extends AbstractPolynomialTest {
	private final int degree;

	public AbstractPolynomialAddSingleZeroCoefficientTermTest(int degree) {
		this.degree = degree;
	}

	protected int getDegree() {
		return degree;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public abstract void testAddSingleNonZeroTerm() throws IllegalArgumentException, IllegalAccessException;

	@Parameters(name = "{0}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		final int N = 5;
		for (int degree = 0; degree < N; ++degree) {
			result.add(new Object[] { degree });
		}

		Random random = new Random();
		for (int i = 0; i < 3; ++i) {
			result.add(new Object[] { N + random.nextInt(100) });
		}

		return result;
	}

}
