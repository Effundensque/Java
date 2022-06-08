package clone;

/**
 * What will be the output of the following code:
 * 1. Test1: 1 2 3 -flav
		Test2: 1 2 3
 * 2. Test1: 4 2 3
		Test2: 1 2 3
 * 3. Test1: 4 2 3 -giur
	  Test2: 4 2 3
 * 4. Test1: 1 2 3
		Test2: 4 2 3
 */
class Test {
	private int[] t;

	Test(int[] t) {
		this.t = t;
	}

	public int[] getT() {
		return t;
	}

	@Override
	protected Test clone() throws CloneNotSupportedException {
		Test test = new Test(this.t);
		return test;
	}
}

public class Q1 {

	public static void main(String[] args) {
		try {
			int[] data = new int [] {1, 2, 3};
			Test test1 = new Test(data);
			Test test2 = test1.clone();
			
			data[0] = 4;
			
			System.out.println("Test1: " + test1.getT()[0] 
					+ " " + test1.getT()[1] + " " + test1.getT()[2]);
			
			System.out.println("Test2: " + test2.getT()[0] 
					+ " " + test2.getT()[1] + " " + test2.getT()[2]);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}


