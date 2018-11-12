package lab8.tests.polynomial.dense;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import lab8.DensePolynomial;
import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StepThroughDensePolynomialTest {
	@Test
	public void test() {
		Polynomial zeroPolynomial = new DensePolynomial();
		assertEquals(0, zeroPolynomial.degree());
		assertEquals(0.0, zeroPolynomial.getCoefficientAtDegree(0), 0.0);

		// addTerm
		Polynomial threeX = zeroPolynomial.addTerm(3, 1);
		assertSame(DensePolynomial.class, threeX.getClass());
		assertEquals(1, threeX.degree());
		assertEquals(0.0, threeX.getCoefficientAtDegree(0), 0.0);
		assertEquals(3.0, threeX.getCoefficientAtDegree(1), 0.0);

		Polynomial eightX = threeX.addTerm(5, 1);
		assertSame(DensePolynomial.class, eightX.getClass());
		assertEquals(1, eightX.degree());
		assertEquals(0.0, eightX.getCoefficientAtDegree(0), 0.0);
		assertEquals(8.0, eightX.getCoefficientAtDegree(1), 0.0);

		Polynomial sevenXCubedPlusEightX = eightX.addTerm(7, 3);
		assertSame(DensePolynomial.class, sevenXCubedPlusEightX.getClass());
		assertEquals(3, sevenXCubedPlusEightX.degree());
		assertEquals(0.0, sevenXCubedPlusEightX.getCoefficientAtDegree(0), 0.0);
		assertEquals(8.0, sevenXCubedPlusEightX.getCoefficientAtDegree(1), 0.0);
		assertEquals(0.0, sevenXCubedPlusEightX.getCoefficientAtDegree(2), 0.0);
		assertEquals(7.0, sevenXCubedPlusEightX.getCoefficientAtDegree(3), 0.0);

		// evaluate(0.0)
		assertEquals(0.0, zeroPolynomial.evaluate(0.0), 0.0);
		assertEquals(0.0, threeX.evaluate(0.0), 0.0);
		assertEquals(0.0, eightX.evaluate(0.0), 0.0);
		assertEquals(0.0, sevenXCubedPlusEightX.evaluate(0.0), 0.0);

		// evaluate(1.0)
		assertEquals(0.0, zeroPolynomial.evaluate(1.0), 0.0);
		assertEquals(3.0, threeX.evaluate(1.0), 0.0);
		assertEquals(8.0, eightX.evaluate(1.0), 0.0);
		assertEquals(15.0, sevenXCubedPlusEightX.evaluate(1.0), 0.0);

		// evaluate(131.0)
		assertEquals(0.0, zeroPolynomial.evaluate(131.0), 0.0);
		assertEquals(393.0, threeX.evaluate(131.0), 0.0);
		assertEquals(1048.0, eightX.evaluate(131.0), 0.0);
		assertEquals(15737685.0, sevenXCubedPlusEightX.evaluate(131.0), 0.0);

		// derivative
		Polynomial twentyOneXSquaredPlusEight = sevenXCubedPlusEightX.derivative();
		assertSame(DensePolynomial.class, twentyOneXSquaredPlusEight.getClass());
		assertEquals(2, twentyOneXSquaredPlusEight.degree());
		assertEquals(8.0, twentyOneXSquaredPlusEight.getCoefficientAtDegree(0), 0.0);
		assertEquals(0.0, twentyOneXSquaredPlusEight.getCoefficientAtDegree(1), 0.0);
		assertEquals(21.0, twentyOneXSquaredPlusEight.getCoefficientAtDegree(2), 0.0);

		// sum
		Polynomial elevenX = threeX.sum(eightX);
		assertSame(DensePolynomial.class, elevenX.getClass());
		assertEquals(1, elevenX.degree());
		assertEquals(0.0, elevenX.getCoefficientAtDegree(0), 0.0);
		assertEquals(11.0, elevenX.getCoefficientAtDegree(1), 0.0);

		Polynomial sevenXCubedPlusNineteenX = sevenXCubedPlusEightX.sum(elevenX);
		assertSame(DensePolynomial.class, sevenXCubedPlusNineteenX.getClass());
		assertEquals(3, sevenXCubedPlusNineteenX.degree());
		assertEquals(0.0, sevenXCubedPlusNineteenX.getCoefficientAtDegree(0), 0.0);
		assertEquals(19.0, sevenXCubedPlusNineteenX.getCoefficientAtDegree(1), 0.0);
		assertEquals(0.0, sevenXCubedPlusNineteenX.getCoefficientAtDegree(2), 0.0);
		assertEquals(7.0, sevenXCubedPlusNineteenX.getCoefficientAtDegree(3), 0.0);

		// toString
		String stringRepresentation = sevenXCubedPlusNineteenX.toString();
		// remove white space
		stringRepresentation = stringRepresentation.replaceAll("\\s+", "");
		// remove parentheses
		stringRepresentation = stringRepresentation.replaceAll("\\(+", "");
		stringRepresentation = stringRepresentation.replaceAll("\\)+", "");

		assertThat(stringRepresentation, containsString("7"));
		assertThat(stringRepresentation, containsString("x^"));
		assertThat(stringRepresentation, containsString("3"));

		assertThat(stringRepresentation, containsString("19"));
	}
}
