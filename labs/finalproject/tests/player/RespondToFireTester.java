package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Player;
import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class RespondToFireTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	private Player p;

	@Before
	public void setup() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		p = new HumanPlayer("Mariah", 10, 10, ap);
	}

	@Test
	public void testRespondToFireHit() {
		assertTrue(p.addShip(new Ship(0, 0, 1, true)));
		assertTrue("There is a ship at (0, 0), it should be a hit", p.respondToFire(0, 0));
	}

	@Test
	public void testRespondToFireMiss() {
		p.addShip(new Ship(0, 0, 1, true));
		for (int i = -100; i < 100; ++i) {
			for (int j = -100; j < 100; ++j) {
				if (i != 0 || j != 0) {
					assertFalse("There is not a ship at (" + i + ", " + j + "), it should not be a hit",
							p.respondToFire(i, j));
				}
			}
		}
	}

}
