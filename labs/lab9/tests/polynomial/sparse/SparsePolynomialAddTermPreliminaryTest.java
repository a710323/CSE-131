package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SparsePolynomialAddTermPreliminaryTest {
	private static final String NO_MUTATION_MESSAGE = "\naddTerm should NOT mutate (that is: change the contents of) the this instance's instance variable\n";

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testA() throws IllegalArgumentException, IllegalAccessException {
		SparsePolynomial poly0 = new SparsePolynomial(); // 0.0 * x ^ 0

		Map<Integer, Double> expected0 = MapTestUtils.createDegreeCoefficientMap();
		Map<Integer, Double> actual0 = MapAccessUtils.getMap(poly0);

		assertNotNull(actual0);
		assertEquals(expected0, actual0);

		Polynomial poly7 = poly0.addTerm(7.0, 0); // 7.0 * x ^ 0

		assertSame(SparsePolynomial.class, poly7.getClass());

		Map<Integer, Double> expected7 = MapTestUtils.createDegreeCoefficientMap(7.0);
		Map<Integer, Double> actual7 = MapAccessUtils.getMap(poly7);
		assertNotNull(actual7);
		assertEquals(expected7, actual7);

		// ensure that poly0 is NOT mutated (that is: changed)
		Map<Integer, Double> actual0NoMutation = MapAccessUtils.getMap(poly0);
		assertNotNull(actual0NoMutation);
		assertEquals(NO_MUTATION_MESSAGE, expected0, actual0NoMutation);
	}

	@Test
	public void testB() throws IllegalArgumentException, IllegalAccessException {
		SparsePolynomial poly0 = new SparsePolynomial(); // 0.0 * x ^ 0

		Map<Integer, Double> expected0 = MapTestUtils.createDegreeCoefficientMap();
		Map<Integer, Double> actual0 = MapAccessUtils.getMap(poly0);

		assertNotNull(actual0);
		assertEquals(expected0, actual0);

		Polynomial poly5xCubed = poly0.addTerm(5.0, 3); // 5.0 * x ^ 3

		assertSame(SparsePolynomial.class, poly5xCubed.getClass());

		Map<Integer, Double> expected5xCubed = MapTestUtils.createDegreeCoefficientMap(0.0, 0.0, 0.0, 5.0);
		Map<Integer, Double> actual5xCubed = MapAccessUtils.getMap(poly5xCubed);
		assertNotNull(actual5xCubed);
		assertEquals(expected5xCubed, actual5xCubed);

		// ensure that poly0 is NOT mutated (that is: changed)
		Map<Integer, Double> actual0NoMutation = MapAccessUtils.getMap(poly0);
		assertNotNull(actual0NoMutation);
		assertEquals(NO_MUTATION_MESSAGE, expected0, actual0NoMutation);
	}

	@Test
	public void testC() throws IllegalArgumentException, IllegalAccessException {
		SparsePolynomial poly0 = new SparsePolynomial(); // 0.0 * x ^ 0

		Map<Integer, Double> expected0 = MapTestUtils.createDegreeCoefficientMap();
		Map<Integer, Double> actual0 = MapAccessUtils.getMap(poly0);

		assertNotNull(actual0);
		assertEquals(expected0, actual0);

		Polynomial poly4xSquared = poly0.addTerm(4.0, 2); // 4.0 * x ^ 2

		assertSame(SparsePolynomial.class, poly4xSquared.getClass());

		Map<Integer, Double> expecte4xSquared = MapTestUtils.createDegreeCoefficientMap(0.0, 0.0, 4.0);
		Map<Integer, Double> actual4xSquared = MapAccessUtils.getMap(poly4xSquared);
		assertNotNull(actual4xSquared);
		assertEquals(expecte4xSquared, actual4xSquared);

		// ensure that poly0 is NOT mutated (that is: changed)
		Map<Integer, Double> actual0NoMutation = MapAccessUtils.getMap(poly0);
		assertNotNull(actual0NoMutation);
		assertEquals(NO_MUTATION_MESSAGE, expected0, actual0NoMutation);

		Polynomial poly7xSquared = poly4xSquared.addTerm(3.0, 2); // 7.0 * x ^ 2

		assertSame(SparsePolynomial.class, poly7xSquared.getClass());

		Map<Integer, Double> expecte7xSquared = MapTestUtils.createDegreeCoefficientMap(0.0, 0.0, 7.0);
		Map<Integer, Double> actual7xSquared = MapAccessUtils.getMap(poly7xSquared);
		assertNotNull(actual7xSquared);
		assertEquals(expecte7xSquared, actual7xSquared);

		// ensure that poly4xSquared is NOT mutated (that is: changed)
		Map<Integer, Double> actual4xSquaredNoMutation = MapAccessUtils.getMap(poly4xSquared);
		assertNotNull(actual4xSquaredNoMutation);
		assertEquals(NO_MUTATION_MESSAGE, expecte4xSquared, actual4xSquaredNoMutation);
	}
}
