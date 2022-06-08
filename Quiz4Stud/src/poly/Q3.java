package poly;

/**
 * What will be the output of the following code:
 * 1. 25 - flav
 * 2. Compilation error
 * 3. 15
 * 4. 26 - giur
 */
interface ITest {
	public static final int var = 5;
	void doIt(int n);
}

public class Q3 implements ITest {

	public static void main(String[] args) {
		int n = 10;
		new Q3().doIt(n);
	}

	@Override
	public void doIt(int n) {
		n += var + ++n;//10 + 5 + 11 26
		System.out.println("n = " + n);
	}
}
