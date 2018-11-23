package lab9.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab9.tests.polynomial.sparse.MapDegreeToCoefficiantCreateNextComprehensiveTest;
import lab9.tests.polynomial.sparse.MapDegreeToCoefficiantCreateNextPreliminaryTest;
import lab9.tests.polynomial.sparse.SpaceLeftBlankSparsePolynomialTest;
import lab9.tests.polynomial.sparse.SparsePolynomialAddMultipleTermsTest;
import lab9.tests.polynomial.sparse.SparsePolynomialAddSingleNonZeroCoefficientTermTest;
import lab9.tests.polynomial.sparse.SparsePolynomialAddSingleZeroCoefficientTermTest;
import lab9.tests.polynomial.sparse.SparsePolynomialAddTermPreliminaryTest;
import lab9.tests.polynomial.sparse.SparsePolynomialAddZeroCoefficientTermPreliminaryTest;
import lab9.tests.polynomial.sparse.SparsePolynomialConstructorTest;
import lab9.tests.polynomial.sparse.SparsePolynomialDegreeNotSizeNorCoefficientTest;
import lab9.tests.polynomial.sparse.SparsePolynomialDegreePreliminaryTest;
import lab9.tests.polynomial.sparse.SparsePolynomialDegreeTest;
import lab9.tests.polynomial.sparse.SparsePolynomialDerivativeTest;
import lab9.tests.polynomial.sparse.SparsePolynomialEvalATest;
import lab9.tests.polynomial.sparse.SparsePolynomialEvalBTest;
import lab9.tests.polynomial.sparse.SparsePolynomialEvalPreliminaryTest;
import lab9.tests.polynomial.sparse.SparsePolynomialExtremelyHighDegreeTest;
import lab9.tests.polynomial.sparse.SparsePolynomialGetCoefficientAtDegreePreliminaryTest;
import lab9.tests.polynomial.sparse.SparsePolynomialGetCoefficientAtDegreeTest;
import lab9.tests.polynomial.sparse.SparsePolynomialIsAPolynomialTest;
import lab9.tests.polynomial.sparse.SparsePolynomialSumTest;
import lab9.tests.polynomial.sparse.SparsePolynomialToStringIsOverriddenTest;
import lab9.tests.polynomial.sparse.SparsePolynomialToStringTest;
import lab9.tests.polynomial.sparse.StepThroughSparsePolynomialTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ SpaceLeftBlankSparsePolynomialTest.class, SparsePolynomialIsAPolynomialTest.class,
		SparsePolynomialConstructorTest.class, MapDegreeToCoefficiantCreateNextPreliminaryTest.class,
		MapDegreeToCoefficiantCreateNextComprehensiveTest.class, SparsePolynomialAddTermPreliminaryTest.class,
		SparsePolynomialAddSingleNonZeroCoefficientTermTest.class,
		SparsePolynomialAddZeroCoefficientTermPreliminaryTest.class,
		SparsePolynomialAddSingleZeroCoefficientTermTest.class, SparsePolynomialAddMultipleTermsTest.class,
		SparsePolynomialGetCoefficientAtDegreePreliminaryTest.class, SparsePolynomialGetCoefficientAtDegreeTest.class,
		SparsePolynomialDegreeNotSizeNorCoefficientTest.class, SparsePolynomialDegreePreliminaryTest.class,
		SparsePolynomialDegreeTest.class, SparsePolynomialEvalPreliminaryTest.class, SparsePolynomialEvalATest.class,
		SparsePolynomialEvalBTest.class, SparsePolynomialSumTest.class, SparsePolynomialDerivativeTest.class,
		SparsePolynomialToStringIsOverriddenTest.class, SparsePolynomialToStringTest.class,
		SparsePolynomialExtremelyHighDegreeTest.class, StepThroughSparsePolynomialTest.class })
public class SparsePolynomialTestSuite {
}
