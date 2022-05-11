package poly;

/**
 * What will be the output of the following code:
 *
 *	1. Roar
 *		Roar
 *		Meow
 *	2. Roar
 *		Meow
 *		Roar
 *	3. Roar
 *		Roar
 *		Roar
 *	*4. Roar
 *		Meow
 *		Meow
 */

class Animal {
	public void makeSound() {
		System.out.println("Roar");
	}
}

class Cat extends Animal{
	public void makeSound() {
		System.out.println("Meow");
	}
}

public class Q1 {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Cat();
		Cat c = new Cat();
		
		a1.makeSound();
		a2.makeSound();
		c.makeSound();
	}

}
