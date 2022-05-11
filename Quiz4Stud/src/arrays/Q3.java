package arrays;

/**
 *  What will be the output of the following code:
 *
 *	1. 1 2 3 4 5
 *	*2. 5 2 3 4 1
 *	3. 5 2 3 4 5
 *  4. 1 2 3 4 1
 */
class Switch {
	static void doIt(int[] z) {
		int temp = z[z.length - 1];
		z[z.length - 1] = z[0];
		z[0] = temp;
	}
}

public class Q3 {
	public static void main(String[] args) {
		int[] myArray = { 1, 2, 3, 4, 5 };
		Switch.doIt(myArray);
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
	}
}