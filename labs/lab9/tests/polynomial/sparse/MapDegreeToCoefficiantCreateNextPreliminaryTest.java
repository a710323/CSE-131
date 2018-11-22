package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lab9.MapDegreeToCoefficientUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MapDegreeToCoefficiantCreateNextPreliminaryTest {
	private static final String NO_MUTATION_MESSAGE = "\ncreateNextMap should not mutate (that is: change the contents of) its prevMap parameter.";

	@Test
	public void testAssociatedDegree() {
		double coefficient = 757.0;
		int degree = 1;
		Map<Integer, Double> originalPrev = MapTestUtils.createDegreeCoefficientMap(10.0, 20.0, 30.0);
		Map<Integer, Double> passedInPrev = new TreeMap<>(originalPrev);
		Map<Integer, Double> expected = MapTestUtils.createDegreeCoefficientMap(10.0, 777.0, 30.0);
		Map<Integer, Double> actual = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, passedInPrev);

		Map<Integer, Double> unexpected = MapTestUtils.createDegreeCoefficientMap(10.0, coefficient, 30.0);
		assertNotEquals(unexpected, actual);
		assertEquals(expected, actual);
		assertEquals(NO_MUTATION_MESSAGE, originalPrev, passedInPrev);
	}

	@Test
	public void testNonAssociatedDegree() {
		double coefficient = 777.0;
		int degree = 4;
		Map<Integer, Double> originalPrev = MapTestUtils.createDegreeCoefficientMap(10.0, 20.0, 30.0);
		Map<Integer, Double> passedInPrev = new TreeMap<>(originalPrev);
		Map<Integer, Double> expected = MapTestUtils.createDegreeCoefficientMap(10.0, 20.0, 30.0, 0.0, 777.0);
		Map<Integer, Double> actual = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, passedInPrev);
		assertEquals(expected, actual);
		assertEquals(NO_MUTATION_MESSAGE, originalPrev, passedInPrev);
	}
}
