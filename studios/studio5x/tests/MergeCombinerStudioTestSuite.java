package studio5x.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ NonMutationOfParametersTest.class, NonNullTest.class, ArrayLengthTest.class,
		NonNullArrayContentsTest.class, DemonstrationVideoCompanionTest.class, MergeCombinerComprehensiveTest.class,
		MergeCombinerLargeArrayTest.class })
public class MergeCombinerStudioTestSuite {

}
