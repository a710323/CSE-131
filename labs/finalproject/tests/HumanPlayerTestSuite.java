package finalproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import finalproject.tests.player.AddShipTester;
import finalproject.tests.player.AllSunkTester;
import finalproject.tests.player.DecideShipPlacementTester;
import finalproject.tests.player.GetTargetLocationTester;
import finalproject.tests.player.IsValidShipToAddTester;
import finalproject.tests.player.RespondToFireTester;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AllSunkTester.class, RespondToFireTester.class, IsValidShipToAddTester.class, AddShipTester.class,
		GetTargetLocationTester.class, DecideShipPlacementTester.class })
public class HumanPlayerTestSuite {
}