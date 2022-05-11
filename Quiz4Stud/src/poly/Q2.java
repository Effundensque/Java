package poly;

/**
 * What will be the output of the following code:
 * 1. Nothing
 * 2. Compiler error
 * 3. 4 4
 * *4. 4
 *
 */
public class Q2 {

	Q2() {
		this(4);
	}

	Q2(int n) {
		System.out.println(n);
	}

	public static void main(String[] args) {
		Q2 q = new Q2();
	}

}
