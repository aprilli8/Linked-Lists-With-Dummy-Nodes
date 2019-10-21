/*
Test for the LinkedList class from CS136 Lab 4
(c) 2016 Bill Jannen
*/

//$nice test cases!

import structure5.*;
import java.util.*;

public class TestLinkedList {

	// a simple helper method to display a list
	// pre: list != null
	public static <E> void compareList(String expected, LinkedList<E> list) {
		System.out.println("Expected: <LinkedList (" + list.size() + "):" +
		                   expected + ">");
		System.out.println("Received: " + list.toString());
	}

	/*
		THIS WILL NOT WORK UNTIL YOU HAVE DUMMY NODES IN YOUR LIST!!!
		The LinkedList.iterator() method assumes dummy nodes are present.
	*/
	public static void main(String s[]) {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 5; i >= 0; i--)
			list.addFirst(String.valueOf(i));
		compareList(" 0 1 2 3 4 5", list);

		list.clear();
		compareList("", list);

		for (int i = 0; i <= 5; i++)
			list.addLast(String.valueOf(i));
		compareList(" 0 1 2 3 4 5", list);

		for (int i = 0; i <= 5; i++)
			list.add(2*i, String.valueOf(i));
		compareList(" 0 0 1 1 2 2 3 3 4 4 5 5", list);

		for (int i = 0; i <= 5; i++)
			list.remove(String.valueOf(i));
		compareList(" 0 1 2 3 4 5", list);

		for (int i = 0; i <= 5; i++)
			list.set(i, "0");
		compareList(" 0 0 0 0 0 0", list);

		list.set(0, "1");
		list.set(list.size()-1, "1");
		compareList(" 1 0 0 0 0 1", list);

		list.add(6, "6");
		compareList(" 1 0 0 0 0 1 6", list);

		list.remove(6);
		compareList(" 1 0 0 0 0 1", list);

		System.out.println("Expected: false");
		System.out.println("Received: " + list.contains("7"));

		System.out.println("Expected: 0");
		System.out.println("Received: " + list.indexOf("1"));
		System.out.println("Expected: 5");
		System.out.println("Received: " + list.lastIndexOf("1"));
	}
}
