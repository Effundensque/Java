package multithreading.common;
/**
 * What will be the output of the following:
 * 1. It will print 20 times "Hello Thread" - giur / flav
 * 2. Compilation error
 * 3. Runtime error
 * 4. None of the above
 */


class ThreadDemo extends Thread {
	String x, y;

	public void run() {
		for (int i = 0; i < 10; i++)
			synchronized (this) {
				x = "Hello";
				y = "Thread";
				System.out.print(x + " " + y + " ");
			}
	}
}

class Q4 {
	public static void main(String args[]) {
		ThreadDemo obj1 = new ThreadDemo();
		ThreadDemo obj2 = new ThreadDemo();
		obj1.start();
		obj2.start();
	}
}