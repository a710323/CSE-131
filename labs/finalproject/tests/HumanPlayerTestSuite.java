package finalproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import finalproject.tests.player.AddShipTester;
import finalproject.tests.player.AllSunkTester;
import finalproject.tests.player.DecideShipPlacementPreliminaryTest;
import finalproject.tests.player.DecideShipPlacementTester;
import finalproject.tests.player.GetNameTest;
import finalproject.tests.player.GetTargetLocationPreliminaryTest;
import finalproject.tests.player.GetTargetLocationTester;
import finalproject.tests.player.IsValidShipToAddInBoundsLessThanOrEqualToTest;
import finalproject.tests.player.IsValidShipToAddInBoundsPreliminaryTest;
import finalproject.tests.player.IsValidShipToAddIsOverlappingPreliminaryTest;
import finalproject.tests.player.IsValidShipToAddTester;
import finalproject.tests.player.RespondToFireLessThanTest;
import finalproject.tests.player.RespondToFirePreliminaryTest;
import finalproject.tests.player.RespondToFireTester;

@RunWith(Suite.class)
@Suite.SuiteClasses({ GetNameTest.class, IsValidShipToAddInBoundsLessThanOrEqualToTest.class,
		IsValidShipToAddInBoundsPreliminaryTest.class, AllSunkTester.class, RespondToFireLessThanTest.class,
		RespondToFirePreliminaryTest.class, RespondToFireTester.class,
		IsValidShipToAddIsOverlappingPreliminaryTest.class, IsValidShipToAddTester.class, AddShipTester.class,
		GetTargetLocationPreliminaryTest.class, GetTargetLocationTester.class, DecideShipPlacementPreliminaryTest.class,
		DecideShipPlacementTester.class })
public class HumanPlayerTestSuite {
}