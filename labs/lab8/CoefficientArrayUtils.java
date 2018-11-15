package lab8;

import java.util.Arrays;

import cse131.NotYetImplementedException;

public class CoefficientArrayUtils {
	/**
	 * Calculates the array length required to store a dense polynomial of a
	 * specified degree.
	 * 
	 * For example, the polynomial x^2 + x + 1 is of degree 2 and requires an array
	 * of length 3.
	 * 
	 * @param degree the specified degree
	 * @return length required for a dense array implementation of a polynomial of
	 *         the specified degree
	 */
	
	// length should be the maximum degree + 1
	public static int calculateArrayLengthRequiredFor(int degree) {
		return degree + 1;
	}

	/**
	 * Calculates the array length required to store a dense polynomial of the
	 * larger of a specified degree and an array of coefficients.
	 * 
	 * For example, the polynomial x^2 + x + 1 is of degree 2 and requires an array
	 * of length 3.
	 * 
	 * If a degree of 2 (which would require an array of length 3) was paired with a
	 * prevCoefficients array of length 1, then the returned required array length
	 * would be 3.
	 * 
	 * If a degree of 2 (which, again, would require an array of length 3) was
	 * paired with a prevCoefficients array of length 5, then the returned required
	 * array length would be 5.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * prevCoefficients array, nor would it have any real reason to do so.
	 * 
	 * @param degree           the specified degree
	 * @param prevCoefficients the previous coefficients array
	 * @return the maximum of the array length required for the specified degree and
	 *         the array length of the specified previous coefficients.
	 */
	
	//if the length of prevCoefficients is larger than degree, return it.
	// else set the length to degree + 1
	public static int calculateArrayLengthRequiredFor(int degree, double[] prevCoefficients) {
		if (degree < prevCoefficients.length) {
			return prevCoefficients.length;
		}
		else {
			return calculateArrayLengthRequiredFor(degree);
		}
	}

	/**
	 * Creates a new array of coefficients which contains the contents of the
	 * specified previous coefficients along with the added term of
	 * coefficient*x^degree (allocating extra space if necessary).
	 * 
	 * For example, if the coefficient 5.0 and the degree 2 are specified with a
	 * prevCoefficients of {1.0, 2.0, 3.0} then a new array would be returned with
	 * the contents {1.0, 2.0, 8.0}.
	 * 
	 * Further, if the coefficient 5.0 and the degree 4 are specified with a
	 * prevCoefficients of {1.0, 2.0, 3.0} then a new array would be returned with
	 * the contents {1.0, 2.0, 3.0, 0.0, 5.0}.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * prevCoefficients array, nor would it have any real reason to do so.
	 * 
	 * @param coefficient      the specified coefficient of the term to be added
	 * @param degree           the specified degree of the term to be added
	 * @param prevCoefficients the specified previous coefficients to which this
	 *                         term is being added
	 * @return a new double array that represents a dense polynomial which is the
	 *         result of adding coefficient*x^degree to the prevCoefficients array.
	 */
	
	//	If the length of prevCoefficients < degree
	//	create an array with length of degree + 1 
	// 	copy all coefficients in prevCoefficients and sum the coefficient with given degree
	// 	else, simply sum the coefficient with given degree
	// 	return the new array
	public static double[] createNextCoefficients(double coefficient, int degree, double[] prevCoefficients) {
		if(prevCoefficients.length  < calculateArrayLengthRequiredFor(degree) ) {
			if (coefficient == 0) {
				return prevCoefficients;
			}
			double[] answer = Arrays.copyOf(prevCoefficients, calculateArrayLengthRequiredFor(degree));
			answer[degree] += coefficient;
			return answer;
		}
		else {
			double[] answer = Arrays.copyOf(prevCoefficients, prevCoefficients.length);
			answer[degree] += coefficient;
			return answer;
		}
	}
}
