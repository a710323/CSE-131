package lab8.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab8.tests.polynomial.dense.CoefficientArrayCreateNextCoefficientsComprehensiveTest;
import lab8.tests.polynomial.dense.CoefficientArrayCreateNextCoefficientsPreliminaryTest;
import lab8.tests.polynomial.dense.CoefficientArrayLengthForDegreeAndPreviousArrayComprehensiveTest;
import lab8.tests.polynomial.dense.CoefficientArrayLengthForDegreeAndPreviousArrayPreliminaryTest;
import lab8.tests.polynomial.dense.CoefficientArrayLengthForDegreeComprehensiveTest;
import lab8.tests.polynomial.dense.CoefficientArrayLengthForDegreePreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialAddMultipleTermsTest;
import lab8.tests.polynomial.dense.DensePolynomialAddSingleNonZeroCoefficientTermTest;
import lab8.tests.polynomial.dense.DensePolynomialAddSingleZeroCoefficientTermTest;
import lab8.tests.polynomial.dense.DensePolynomialConstructorTest;
import lab8.tests.polynomial.dense.StepThroughDensePolynomialTest;
import lab8.tests.polynomial.dense.DensePolynomialDegreeTest;
import lab8.tests.polynomial.dense.DensePolynomialDerivativeTest;
import lab8.tests.polynomial.dense.DensePolynomialSumTest;
import lab8.tests.polynomial.dense.DensePolynomialEvalATest;
import lab8.tests.polynomial.dense.DensePolynomialEvalBTest;
import lab8.tests.polynomial.dense.DensePolynomialGetCoefficientAtDegreeTest;
import lab8.tests.polynomial.dense.DensePolynomialIsAPolynomialTest;
import lab8.tests.polynomial.dense.DensePolynomialToStringIsOverriddenTest;
import lab8.tests.polynomial.dense.DensePolynomialToStringTest;
import lab8.tests.polynomial.dense.SpaceLeftBlankDensePolynomialTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ SpaceLeftBlankDensePolynomialTest.class, DensePolynomialIsAPolynomialTest.class,
		DensePolynomialConstructorTest.class, CoefficientArrayLengthForDegreePreliminaryTest.class,
		CoefficientArrayLengthForDegreeComprehensiveTest.class,
		CoefficientArrayLengthForDegreeAndPreviousArrayPreliminaryTest.class,
		CoefficientArrayLengthForDegreeAndPreviousArrayComprehensiveTest.class,
		CoefficientArrayCreateNextCoefficientsPreliminaryTest.class,
		CoefficientArrayCreateNextCoefficientsComprehensiveTest.class,
		DensePolynomialAddSingleNonZeroCoefficientTermTest.class, DensePolynomialAddSingleZeroCoefficientTermTest.class,
		DensePolynomialAddMultipleTermsTest.class, DensePolynomialGetCoefficientAtDegreeTest.class,
		DensePolynomialDegreeTest.class, DensePolynomialEvalATest.class, DensePolynomialEvalBTest.class,
		DensePolynomialSumTest.class, DensePolynomialDerivativeTest.class,
		DensePolynomialToStringIsOverriddenTest.class, DensePolynomialToStringTest.class,
		StepThroughDensePolynomialTest.class })
public class DensePolynomialTestSuite {
}
