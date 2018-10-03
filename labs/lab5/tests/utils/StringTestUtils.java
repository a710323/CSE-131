package lab5.tests.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StringTestUtils {
	public static List<String> createStringList(String... elements) {
		return Arrays.asList(elements);
	}

	private static Set<String> createSet(Supplier<String> supplier, int length) {
		Set<String> set = new HashSet<>();
		while (set.size() < length) {
			String s = supplier.get();
			set.add(s);
		}
		return set;
	}

	public static List<String> createUniqueStringList(Supplier<String> supplier, int length) {
		Set<String> set = createSet(supplier, length);
		List<String> list = new ArrayList<>(set);
		// note: hash set should be unordered already
		Collections.shuffle(list);
		return list;
	}

	public static List<String> createUniqueSortedStringList(Supplier<String> supplier, int length) {
		Set<String> set = createSet(supplier, length);
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}

	public static String[] toStringArray(List<String> strings) {
		return strings.toArray(new String[strings.size()]);
	}

	public static String nextRandomString(Random random, int characterCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < characterCount; i++) {
			char c = (char) ('A' + random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}

}
