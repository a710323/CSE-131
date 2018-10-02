package lab5.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab5.tests.linearsearch.LinearSearchEqualsTest;
import lab5.tests.linearsearch.LinearSearchComprehensiveTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ LinearSearchEqualsTest.class, LinearSearchComprehensiveTest.class })
public class LinearSearchTestSuite {
}
