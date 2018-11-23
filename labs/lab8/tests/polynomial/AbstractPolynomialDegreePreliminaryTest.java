package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractPolynomialDegreePreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected abstract Polynomial createZeroPolynomial();
	
	@Test
	public void test0() {
		Polynomial poly0 = createZeroPolynomial();
		assertEquals(0, poly0.degree());

		Polynomial poly42 = poly0.addTerm(42.0, 0); // 42.0 * x ^ 0
		assertEquals(0, poly42.degree());
	}

	@Test
	public void test1() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly131x = poly0.addTerm(131.0, 1); // 131.0 * x ^ 1
		assertEquals(1, poly131x.degree());

		Polynomial poly131xPlus9 = poly131x.addTerm(9.0, 0); // (131.0 * x ^ 1) + (9.0 * x ^ 0);
		assertEquals(1, poly131xPlus9.degree());

		Polynomial poly231xPlus9 = poly131xPlus9.addTerm(100.0, 1); // (231.0 * x ^ 1) + (9.0 * x ^ 0);
		assertEquals(1, poly231xPlus9.degree());
	}

	@Test
	public void test2() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly7xSquared = poly0.addTerm(7.0, 2); // 7.0 * x ^ 2;
		assertEquals(2, poly7xSquared.degree());

		Polynomial poly7xSquaredPlus3x = poly7xSquared.addTerm(3.0, 1); // (7.0 * x ^ 2) + (3.0 * x ^ 1);
		assertEquals(2, poly7xSquaredPlus3x.degree());
	}

	@Test
	public void test71() {
		Polynomial poly0 = createZeroPolynomial();
		Polynomial poly20xToThe71 = poly0.addTerm(20.0, 71); // 20.0 * x ^ 71;
		assertEquals(71, poly20xToThe71.degree());
	}
}
