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

public class IsValidShipToAddTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testIsValidShipSimple() {
		String[] input = new String[30];
		for (int i = 0; i < 10; ++i) {
			input[3 * i] = "" + i;
			input[3 * i + 1] = "" + i;
			input[3 * i + 2] = "" + (Math.random() < 0.5);
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship s = new Ship(Integer.parseInt(input[3 * i]), Integer.parseInt(input[3 * i + 1]), 1,
					Boolean.parseBoolean(input[3 * i + 2]));
			assertTrue("We should be able to add this ship as it's right down the diagonal", p.isValidShipToAdd(s));
			assertTrue(p.addShip(s));
		}
	}

	@Test
	public void testIsInvalidShipSimple() {
		String[] input = new String[30];
		for (int i = 0; i < 10; ++i) {
			input[3 * i] = "" + i;
			input[3 * i + 1] = "" + i;
			input[3 * i + 2] = "" + (Math.random() < 0.5);
		}
		ArgsProcessor ap = new ArgsProcessor(input);
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		for (int i = 0; i < 10; ++i) {
			Ship s = new Ship(Integer.parseInt(input[3 * i]), Integer.parseInt(input[3 * i + 1]), 1,
					Boolean.parseBoolean(input[3 * i + 2]));
			assertTrue("We should be able to add this ship as it's right down the diagonal", p.isValidShipToAdd(s));
			assertTrue(p.addShip(s));
			assertFalse("We should not be able to add a ship that is a repeat", p.isValidShipToAdd(s));
		}
	}

	@Test
	public void testIsValidShipComplex() {
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
			Ship s = new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i]);
			assertTrue("We should be able to add this ship", p.isValidShipToAdd(s));
			assertTrue(p.addShip(s));
			assertFalse("We should not be able to add a repeated ship", p.isValidShipToAdd(s));
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
			Ship s = new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i]);
			assertTrue("We should be able to add this ship", p.isValidShipToAdd(s));
			assertTrue(p.addShip(s));
			assertFalse("We should not be able to add a repeated ship", p.isValidShipToAdd(s));
		}
		for (int j = 10; j < xTest.length - 1; ++j) {
			Ship other = new Ship(xTest[j], yTest[j], 3, oTest[j]);
			assertFalse("This ship intersects one of the other ships on the board", p.isValidShipToAdd(other));
		}
		assertTrue("We should be able to add this ship", p.isValidShipToAdd(
				new Ship(xTest[xTest.length - 1], yTest[yTest.length - 1], 3, oTest[oTest.length - 1])));
	}

}
