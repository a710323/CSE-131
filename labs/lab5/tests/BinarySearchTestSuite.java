package lab5.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab5.tests.binarysearch.BinarySearchComprehensiveTest;
import lab5.tests.binarysearch.BinarySearchEqualsTest;
import lab5.tests.binarysearch.BinarySearchLargeArrayTest;
import lab5.tests.binarysearch.BinarySearchPinPointInfiniteLoopTest;
import lab5.tests.binarysearch.MidpointTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ MidpointTest.class, BinarySearchEqualsTest.class, BinarySearchComprehensiveTest.class,
		BinarySearchPinPointInfiniteLoopTest.class, BinarySearchLargeArrayTest.class })
public class BinarySearchTestSuite {
}
