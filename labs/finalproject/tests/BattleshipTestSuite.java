package finalproject.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import finalproject.tests.ship.*;
import finalproject.tests.player.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	IsHitTester.class,
	IsSunkTester.class,
	AllSunkTester.class,
	RespondToFireTester.class,
	IsValidShipToAddTester.class,
	AddShipTester.class,
	GetTargetLocationTester.class,
	DecideShipPlacementTester.class
})
public class BattleshipTestSuite { }