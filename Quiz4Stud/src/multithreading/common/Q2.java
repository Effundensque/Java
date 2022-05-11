package multithreading.common;

/**
 * What would be the output of the following code?
 * 1. msg1 msg2
 * 2. msg1 thread
 * 3. msg1 thread msg2  
 * *4. msg1 msg2 thread 
 *
 */

class MyThread extends Thread {
	public void run() {
		System.out.print("thread ");
	}
}

class Q2 {

	public static void main(String[] args) {
		System.out.print("msg1 ");
		
		MyThread q2 = new MyThread();
		q2.start();
		
		System.out.print("msg2 ");
	}

}
