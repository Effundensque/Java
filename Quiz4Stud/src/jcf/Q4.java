package jcf;

import java.util.HashSet;
import java.util.Set;

/**
 * Does Set allow at most one null element?
 *	*1. Yes
 *	2. No
 */
public class Q4 {
	public static void main(String args[]) {
		Set<String> mySet = new HashSet<String>();
		mySet.add(null);
		mySet.add(null);
		
		//prints out null only one time
		//sets do not contain duplicates
		System.out.println(mySet.toString());
	}
}
