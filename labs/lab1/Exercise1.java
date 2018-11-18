package lab1;

import java.util.*;

public class Exercise1 {
	public static void main(String[] args) {
		int[] num = new int[8];
		int N = num.length;
		
		double[][] cpy = {
				{-1,-3,78},
				{-2,8, 91}
		};
		
		for (double s : cpy[0]) {
			s = s * 2;
			System.out.println(s);
		}
		
		
//		Set<Set<Integer>> mySet = new HashSet<>();
//		Set<Integer> solution1 = new HashSet<>();
//		solution1.add(2);
//		solution1.add(1);
//		solution1.add(3);
//		Set<Integer> solution2 = new HashSet<>();
//		solution2.add(3);
//		solution2.add(2);
//		solution2.add(1);
//		System.out.println(mySet.add(solution1));
//		System.out.println(mySet.add(solution2));
//		
//		Set<int[]> mySet2 = new HashSet<>();
//		int[] solution3 = new int[] {1,2,3};
//		int[] solution4 = new int[] {2,1,3};
//		System.out.println(mySet2.add(solution4));
//		System.out.println(mySet2.add(solution3));
		
		int a = 3;
		int b = 3;
		System.out.println(a==b);
		
//		int x = 6 > 3 ? 7 : 3;
//		System.out.println(x);
//		System.out.println("31" + 31 + 1);
//		String z = "Alex";
//		System.out.println(z);
//		
//		HashSet<String> h = new HashSet<String>();
//		h.add("Alex");
//		h.add("Teng");
//		h.add("Zhang");
//		h.add("Alex");
//		System.out.println(h);
//		System.out.println("HashSet contains Alex or not:" + " " + h.contains("Alex"));
//		h.remove("Alex");
//		System.out.println("HashSet contains Alex or not: " + h.contains("Alex"));
	}
}
