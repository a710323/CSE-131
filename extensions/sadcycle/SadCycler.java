package sadcycle;

import java.util.HashSet;
import java.util.Set;

public class SadCycler {
	
	public static Set<Long> findCycle(int base, long n){
		long temp;
		Set<Long> mySet = new HashSet<Long>();
		while (true) {
	        temp = 0;
	        while (n > 0) {
	            temp += Math.pow(n % 10, base);
	            n /= 10;
	        }
	        n = temp;
	        if (mySet.contains(n)) {
	            break;
	        } else {
	            mySet.add(n);
	        }
	    }
		return mySet;
	}
	public static void main(String[] args) {
		Set<Long> q = findCycle(2, 98);
		System.out.println(q);
	}
}
