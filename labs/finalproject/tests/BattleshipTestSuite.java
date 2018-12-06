package finalproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import finalproject.tests.ship.*;
import finalproject.tests.player.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ShipTestSuite.class, HumanPlayerTestSuite.class })
public class BattleshipTestSuite {
}