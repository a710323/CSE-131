package lab8.tests.polynomial.dense;

import java.lang.reflect.Field;

import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class CoefficientsAccessUtils {
	static double[] getCoefficients(Polynomial polynomial, Field coefficientsField)
			throws IllegalArgumentException, IllegalAccessException {
		coefficientsField.setAccessible(true);
		return (double[]) coefficientsField.get(polynomial);
	}

	static double[] getCoefficients(Polynomial polynomial) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = polynomial.getClass().getDeclaredFields();
		Field coefficientsField = fields[0];
		return getCoefficients(polynomial, coefficientsField);
	}
}
