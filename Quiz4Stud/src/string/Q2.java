package string;

/**
 * What will be the output of the following code:
 *
 *	1. truetrue
 * 	2. falsefalse
 *	3. truefalse
 *	4. falsetrue

 */
public class Q2 {

	public static void main(String[] args) {
		String t1 = "abc";
		String t2 = new String("abc");
		System.out.print(t1.equals(t2));
		System.out.print(t1==t2);
	}

}