package eu.ase.test;

import java.util.Date;

/*
 * Create the class Juice which extends Product implements Cloneable and Comparable<Juice> interfaces.
 * 
 * Besides the fields and methods inherited from the abstract class Product, the class Juice has the following private fields:
 * ml : float representing the ml quantity of the Juice
 * serialVersionUID : static final long
 * 
 * Create the constructor method with 4 parameters: 
 * "id" of type int, "expDate" of type Date, "title" of type String, "ml" of type float
 * The constructor should throw an Exception if the "ml" or the "id" are less than 0
 * 
 * Implement proper get/set method(s) and override equals method:
 * public method equals(Object o) which returns boolean
 * The setMl() method must throw an exception if the ml are less than 0
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * Override the methods from Comparable (compareTo() -> returns int and it compares Juices in terms of ml)
 * 
 * Override method getAbstractProductInfo() which returns a String which represents the concatenation of the inherited value
 * for the "id" and the "title" field value
 * 
 * Override toString() -> String method in terms of returning the String concatenation of the fields content
 */

public class Juice extends Product /* implements Cloneable, Comparable<Juice> */ {
	
}
	
