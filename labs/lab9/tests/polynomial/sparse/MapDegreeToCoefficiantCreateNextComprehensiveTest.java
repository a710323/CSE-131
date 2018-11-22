package lab9.tests.polynomial.sparse;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab9.MapDegreeToCoefficientUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class MapDegreeToCoefficiantCreateNextComprehensiveTest {
	private final Map<Integer, Double> originalPrev;
	private final double coefficient;
	private final int degree;
	private final Map<Integer, Double> expected;

	public MapDegreeToCoefficiantCreateNextComprehensiveTest(Map<Integer, Double> prev, double coefficient, int degree,
			Map<Integer, Double> expected) {
		this.originalPrev = prev;
		this.coefficient = coefficient;
		this.degree = degree;
		this.expected = expected;
	}

	@Test
	public void test() {
		Map<Integer, Double> passedInPrev = new TreeMap<>((SortedMap<Integer, Double>) originalPrev);
		Map<Integer, Double> next = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, passedInPrev);
		assertEquals(expected, next);
		assertEquals("\ncreateNextMap should not mutate (that is: change the contents of) its prev parameter.",
				originalPrev, passedInPrev);
	}

	@Parameters(name = "prev: {0}; coefficient: {1}; degree: {2}; expected: {3}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0), 7.0, 0, MapTestUtils.createDegreeCoefficientMap(9.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0), 7.0, 1, MapTestUtils.createDegreeCoefficientMap(2.0, 7.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0), 7.0, 2, MapTestUtils.createDegreeCoefficientMap(2.0, 0.0, 7.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0), 7.0, 3, MapTestUtils.createDegreeCoefficientMap(2.0, 0.0, 0.0, 7.0) });

		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 0, MapTestUtils.createDegreeCoefficientMap(9.0, 3.0, 4.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 1, MapTestUtils.createDegreeCoefficientMap(2.0, 10.0, 4.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 2, MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 11.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 3, MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0, 7.0) });
		result.add(new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 4, MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0, 0.0, 7.0) });
		result.add(
				new Object[] { MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0), 7.0, 5, MapTestUtils.createDegreeCoefficientMap(2.0, 3.0, 4.0, 0.0, 0.0, 7.0) });
		return result;
	}
}
