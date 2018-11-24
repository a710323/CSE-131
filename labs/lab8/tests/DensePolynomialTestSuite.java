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
import lab8.tests.polynomial.dense.DensePolynomialAddTermPreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialAddZeroCoefficientTermPreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialConstructorTest;
import lab8.tests.polynomial.dense.DensePolynomialDegreePreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialDegreeTest;
import lab8.tests.polynomial.dense.DensePolynomialDerivativePreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialDerivativeTest;
import lab8.tests.polynomial.dense.DensePolynomialEvalATest;
import lab8.tests.polynomial.dense.DensePolynomialEvalBTest;
import lab8.tests.polynomial.dense.DensePolynomialEvalPreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialGetCoefficientAtDegreePreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialGetCoefficientAtDegreeTest;
import lab8.tests.polynomial.dense.DensePolynomialIsAPolynomialTest;
import lab8.tests.polynomial.dense.DensePolynomialSumPreliminaryTest;
import lab8.tests.polynomial.dense.DensePolynomialSumTest;
import lab8.tests.polynomial.dense.DensePolynomialToStringIsOverriddenTest;
import lab8.tests.polynomial.dense.DensePolynomialToStringTest;
import lab8.tests.polynomial.dense.SpaceLeftBlankDensePolynomialTest;
import lab8.tests.polynomial.dense.StepThroughDensePolynomialTest;

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
		CoefficientArrayCreateNextCoefficientsComprehensiveTest.class, DensePolynomialAddTermPreliminaryTest.class,
		DensePolynomialAddSingleNonZeroCoefficientTermTest.class,
		DensePolynomialAddZeroCoefficientTermPreliminaryTest.class,
		DensePolynomialAddSingleZeroCoefficientTermTest.class, DensePolynomialAddMultipleTermsTest.class,
		DensePolynomialGetCoefficientAtDegreePreliminaryTest.class, DensePolynomialGetCoefficientAtDegreeTest.class,
		DensePolynomialDegreePreliminaryTest.class, DensePolynomialDegreeTest.class,
		DensePolynomialEvalPreliminaryTest.class, DensePolynomialEvalATest.class, DensePolynomialEvalBTest.class,
		DensePolynomialDerivativePreliminaryTest.class, DensePolynomialDerivativeTest.class,
		DensePolynomialSumPreliminaryTest.class, DensePolynomialSumTest.class,
		DensePolynomialToStringIsOverriddenTest.class, DensePolynomialToStringTest.class,
		StepThroughDensePolynomialTest.class })
public class DensePolynomialTestSuite {
}
