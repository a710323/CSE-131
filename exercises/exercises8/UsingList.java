package exercises8;

import java.util.LinkedList;
import java.util.List;

public class UsingList {

	public static void main(String[] args) {
		//
		// Your code goes here:
		//
		LinkedList<String> eating = new LinkedList<String>();
		eating.add("open mouth");
		eating.add("insert food");
		eating.add("chew");
		eating.add("chew");
		eating.add("swallow");
		System.out.println(eating);
		eating.add("digest");
		System.out.println(eating);
		eating.add(0, "salivate");
		System.out.println(eating);
		eating.remove(2);
		System.out.println(eating);
		eating.remove("chew");
		System.out.println(eating);
	}

}
