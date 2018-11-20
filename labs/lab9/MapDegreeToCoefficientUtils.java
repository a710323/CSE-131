package lab9;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import cse131.NotYetImplementedException;

public class MapDegreeToCoefficientUtils {
	/**
	 * Constructs a new Map with the same degree to coefficient mappings as the
	 * passed in map.
	 * 
	 * If it is a SortedMap, then a new TreeMap preserving its ordering is returned.
	 * Otherwise, a new HashMap is returned.
	 * 
	 * @param map a map from which to create a copy
	 * @return a copy of the specified map
	 */
	public static Map<Integer, Double> copyMap(Map<Integer, Double> map) {
		// Note:
		//
		// In order to support either a HashMap or a TreeMap solution to
		// SparsePolynomial we create new instances of those types based on whether or
		// not the specified map is a SortedMap or not.
		// (A TreeMap is a SortedMap.)
		//
		// Passing the specified map parameter to the appropriate constructor of TreeMap
		// and HashMap will copy over the mappings to the new instance.
		if (map instanceof SortedMap) {
			SortedMap<Integer, Double> sortedMap = (SortedMap<Integer, Double>) map;
			return new TreeMap<>(sortedMap);
		} else {
			return new HashMap<>(map);
		}
	}

	/**
	 * Create a new map which holds the degree to coefficient mappings of the
	 * specified prevMap with the addition of the term specified by coefficient and
	 * degree.
	 * 
	 * For example, if coefficient 5.0 and degree 2 are passed in with a prevMap of:
	 * {0=1.0, 1=2.0, 2=3.0} then a new map would be returned with the mappings
	 * {0=1.0, 1=2.0, 2=8.0}.
	 * 
	 * Further, if coefficient 5.0 and degree 4 are passed in with a prevMap of
	 * {0=1.0, 1=2.0, 2=3.0} then a new map would be returned with the mappings
	 * {0=1.0, 1=2.0, 2=3.0, 4=5.0}.
	 * 
	 * @param coefficient coefficient of the term to be added
	 * @param degree      degree of the term to be added
	 * @param prevMap     previous map which this term is to be added to a copy of
	 * @return a new resulting Map of adding coefficient*x^degree to a copy prevMap
	 */
	public static Map<Integer, Double> createNextMap(double coefficient, int degree, Map<Integer, Double> prevMap) {
		throw new NotYetImplementedException("delete this line of code and implement this method.");
	}
}
