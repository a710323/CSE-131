package lab6.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ MergeSortRange1Test.class, MergeSortPreliminaryTest.class,
		MergeSortDemonstrationVideoCompanionTest.class, MergeSortComprehensiveTest.class,
		MergeSortLargeArrayTest.class })
public class MergeSortTestSuite {
}
