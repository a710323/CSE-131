package lab9.tests.polynomial.sparse;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class MapTestUtils {
	static Map<Integer, Double> createDegreeCoefficientMap(double... coefficients) {
		Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
		int degree = 0;
		for (double coefficient : coefficients) {
			if(coefficient!=0.0) {
				map.put(degree, coefficient);
			}
			degree++;
		}
		return map;
	}
}
