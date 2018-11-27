package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ArgsProcessor;
import lab5.tests.utils.UnitTestUtils;
import finalproject.HumanPlayer;
import finalproject.Player;

public class GetTargetLocationTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testInvalidLocations() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {
				"-1", "-1",
				"-1", "4",
				"4", "-1",
				"0", "0",
				"10", "11",
				"1", "1",
				"9", "10",
				"10", "9",
				"2", "2",
				"100", "100",
				"3", "3"
		});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		int[] loc = p.getTargetLocation();
		assertEquals("You accepted a negative ship x location", loc[0], 0);
		assertEquals("You accepted a negative ship y location", loc[1], 0);
		
		loc = p.getTargetLocation();
		assertEquals("You accepted a ship x location that was too large", loc[0], 1);
		assertEquals("You accepted a ship y location that was too large", loc[1], 1);
		
		loc = p.getTargetLocation();
		assertEquals("You accepted a ship x location that was too large", loc[0], 2);
		assertEquals("You accepted a ship y location that was too large", loc[1], 2);
		
		loc = p.getTargetLocation();
		assertEquals("You accepted a ship x location that was too large", loc[0], 3);
		assertEquals("You accepted a ship y location that was too large", loc[1], 3);
	}

}
