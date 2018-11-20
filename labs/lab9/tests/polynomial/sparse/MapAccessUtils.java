package lab9.tests.polynomial.sparse;

import java.lang.reflect.Field;
import java.util.Map;

import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class MapAccessUtils {
	static Map<Integer, Double> getMap(Polynomial polynomial, Field mapField)
			throws IllegalArgumentException, IllegalAccessException {
		mapField.setAccessible(true);
		return (Map<Integer, Double>) mapField.get(polynomial);
	}

	static Map<Integer, Double> getMap(Polynomial polynomial) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = polynomial.getClass().getDeclaredFields();
		Field mapField = fields[0];
		return getMap(polynomial, mapField);
	}
}
