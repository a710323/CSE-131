package finalproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import finalproject.tests.ship.IsHitComprehensiveTest;
import finalproject.tests.ship.IsHitTester;
import finalproject.tests.ship.IsSunkTester;
import finalproject.tests.ship.ShipEqualsIsOverriddenTest;
import finalproject.tests.ship.ShipEqualsTest;
import finalproject.tests.ship.ShipToStringIsOverriddenTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ IsHitTester.class, IsHitComprehensiveTest.class, IsSunkTester.class,
		ShipEqualsIsOverriddenTest.class, ShipEqualsTest.class, ShipToStringIsOverriddenTest.class })
public class ShipTestSuite {

}
