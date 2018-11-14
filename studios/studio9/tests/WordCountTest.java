package studio9.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import studio9.WordCount;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class WordCountTest {
	@Test
	public void test() {
		List<String> words = Arrays.asList("to", "be", "or", "not", "to", "be");
		Map<String, Integer> map = WordCount.countWords(words);
		assertEquals(4, map.size());
		Map<String, Integer> expected = new HashMap<>();
		expected.put("to", 2);
		expected.put("be", 2);
		expected.put("or", 1);
		expected.put("not", 1);
		assertEquals(expected, map);
	}
}
