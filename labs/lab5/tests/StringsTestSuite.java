package lab5.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab5.tests.strings.StringComparisonTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ StringComparisonTest.class })
public class StringsTestSuite {
}
