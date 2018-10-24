package lab1;

import java.util.*;

public class Exercise1 {
	public static void main(String[] args) {
		int[] num = new int[8];
		int N = num.length;
		int x = 6 > 3 ? 7 : 3;
		System.out.println(x);
		System.out.println("31" + 31 + 1);
		
		HashSet<String> h = new HashSet<String>();
		h.add("Alex");
		h.add("Teng");
		h.add("Zhang");
		h.add("Alex");
		System.out.println(h);
		System.out.println("HashSet contains Alex or not:" + " " + h.contains("Alex"));
		h.remove("Alex");
		System.out.println("HashSet contains Alex or not: " + h.contains("Alex"));
	}
}
