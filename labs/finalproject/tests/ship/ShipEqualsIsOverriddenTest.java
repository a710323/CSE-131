package finalproject.tests.ship;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ShipEqualsIsOverriddenTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		@SuppressWarnings("unused")
		Method equalsMethod = Ship.class.getDeclaredMethod("equals", Object.class);
		// note: we need not check the returned equalsMethod
		// getDeclaredMethod will throw a NoSuchMethodException if it is not found
	}
}
