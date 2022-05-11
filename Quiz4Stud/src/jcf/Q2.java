package jcf;

import java.util.HashMap;
import java.util.Map;

/**
 * What will be the output of the following code:
 * 1. {null=Test}
 * *2. {null=Fest}
 * 3. {null=Test}
	  {null=Fest} 
 * 4. error at line 	 m.put(null,"Fest");
 */
public class Q2 {
	public static void main (String[] args){
		Map<String, String> m= new HashMap<>();
		m.put(null, "Test");
		m.put(null,"Fest");
		System.out.println(m);
	}
}


