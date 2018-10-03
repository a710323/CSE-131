package lab5.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab5.tests.sort.FindComprehensiveTest;
import lab5.tests.sort.FindPreliminaryTest;
import lab5.tests.sort.IsSortedTest;
import lab5.tests.sort.SelectionSortComprehensiveTest;
import lab5.tests.sort.SelectionSortLargeArrayTest;
import lab5.tests.sort.SelectionSortPreliminaryTest;
import lab5.tests.sort.SwapComprehensiveTest;
import lab5.tests.sort.SwapPreliminaryTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ FindPreliminaryTest.class, FindComprehensiveTest.class, SwapPreliminaryTest.class,
		SwapComprehensiveTest.class, SelectionSortPreliminaryTest.class, SelectionSortComprehensiveTest.class,
		SelectionSortLargeArrayTest.class, IsSortedTest.class, })
public class SortTestSuite {
}
