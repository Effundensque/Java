package multithreading.common;

/**
 * What will be the output of the following program:
 * 1. Compiler error since there is no start method in Thread1 and Thread2
 * *2. It will print A B C D in random order
 * 3. It will print in this order AB... CD... AB...
 * 4. It will print in this order ABCD... ABCD...
 */


class Thread1 extends Thread { 
    public void run() { 
        for(int i = 0; i < 3; i++) { 
            System.out.println("A"); 
            System.out.println("B"); 
        } 
    } 
} 

class Thread2 extends Thread { 
    public void run() { 
        for(int i = 0; i < 3; i++) { 
            System.out.println("C"); 
            System.out.println("D"); 
        } 
    } 
} 

class Q3 extends Thread { 
    public static void main(String args[]) { 
        Thread1 t1 = new Thread1(); 
        Thread2 t2 = new Thread2();
        t1.start(); 
        t2.start(); 
    } 
}