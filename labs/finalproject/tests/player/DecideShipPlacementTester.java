package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Player;
import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class DecideShipPlacementTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testDecideShipSimple() {
		String[] input = new String[30];
		for (int i = 0; i < 10; ++i) {
			input[3 * i] = "" + i;
			input[3 * i + 1] = "" + i;
			input[3 * i + 2] = "" + (Math.random() < 0.5);
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship expected = new Ship(Integer.parseInt(input[3 * i]), Integer.parseInt(input[3 * i + 1]), 1,
					Boolean.parseBoolean(input[3 * i + 2]));
			Ship actual = p.decideShipPlacement(1);
			assertEquals("The ship you returned was not the ship indicated by the input", expected, actual);
			assertTrue(p.addShip(actual));
		}
	}

	@Test
	public void testDecideShipInvalidSimple() {
		String[] input = new String[30];
		for (int i = 0; i < 10; ++i) {
			input[3 * i] = "" + i;
			input[3 * i + 1] = "" + i;
			input[3 * i + 2] = "" + (Math.random() < 0.5);
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship expected = new Ship(Integer.parseInt(input[3 * i]), Integer.parseInt(input[3 * i + 1]), 1,
					Boolean.parseBoolean(input[3 * i + 2]));
			Ship actual = p.decideShipPlacement(1);
			assertEquals("The ship you returned was not the ship indicated by the input", expected, actual);
			assertTrue(p.addShip(actual));
			ap.setCurArg(3 * i);

			if (i < 9) {
				Ship shouldBeValid = p.decideShipPlacement(1);
				assertNotEquals("Given a repeat ship, you did not continue asking until a valid one was found",
						expected, shouldBeValid);
				ap.setCurArg(3 * (i + 1));
			}
		}
	}

	@Test
	public void testDecideShipComplex() {
		int[] xTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 1, 4 };
		int[] yTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 5, 1 };
		boolean[] oTest = new boolean[] { true, true, false, true, false, true, true, false, false, true };
		String[] input = new String[30];
		for (int i = 0; i < 10; ++i) {
			input[3 * i] = "" + xTest[i];
			input[3 * i + 1] = "" + yTest[i];
			input[3 * i + 2] = "" + oTest[i];
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship expected = new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i]);
			Ship actual = p.decideShipPlacement((i % 5) + 1);
			assertEquals("The ship you returned was not the ship indicated by the input", expected, actual);
			assertTrue(p.addShip(actual));
		}
	}

	@Test
	public void testDecideShipInvalidComplex() {
		int[] xTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 1, 4, 2, 6, 5, 0 };
		int[] yTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 5, 1, 1, 0, 9, 9 };
		boolean[] oTest = new boolean[] { true, true, false, true, false, true, true, false, false, true, false, false,
				true, true };
		String[] input = new String[3 * xTest.length];
		for (int i = 0; i < xTest.length; ++i) {
			input[3 * i] = "" + xTest[i];
			input[3 * i + 1] = "" + yTest[i];
			input[3 * i + 2] = "" + oTest[i];
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship expected = new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i]);
			Ship actual = p.decideShipPlacement((i % 5) + 1);
			assertEquals("The ship you return was not the ship indicated by the input", expected, actual);
			assertTrue(p.addShip(actual));
		}
		Ship expected = new Ship(xTest[xTest.length - 1], yTest[yTest.length - 1], 3, oTest[oTest.length - 1]);
		Ship actual = p.decideShipPlacement(3);
		assertEquals("You did not reject one of three invalid ships", expected, actual);
	}

}
