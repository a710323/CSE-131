package lab5.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ StringsTestSuite.class, LinearSearchTestSuite.class, SortTestSuite.class,
		BinarySearchTestSuite.class })
public class Lab5TestSuite {

}
