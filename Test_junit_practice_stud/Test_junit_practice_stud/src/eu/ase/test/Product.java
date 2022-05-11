package eu.ase.test;

import java.io.Serializable;
import java.util.Date;

/*
 * Create the abstract class Product which implements Cloneable, AutoCloseable and java.io.Serializable interfaces.
 * 
 * The class has the following private fields:
 * expDate : Date which is the expiration date of the product
 * id : int for the id of the product
 * title : String which is the name of the product
 * serialVersionUID : static final long
 * 
 * Create the constructor method without parameters and the one with 3 parameters: 
 * "id" of type int, "expDate" of type Date, "title" of type String
 * The constructor with parameters should throw an Exception if the "id" is less than 0 
 * 
 * Create the private, static field "productsNo" and and associated public, static get method (getProductsNo -> returns int). 
 * This variable ("productsNo") is used for counting how many objects from this class have been created. 
 * Also be sure this variable is incremented into the constructors and clone method and decremented into close method.
 * 
 * Implement proper get/set methods
 * 
 * Implement consistently the clone method for creating deep copy of the current object:
 * public clone() which return Object and may throw CloneNotSupportedException
 * 
 * AutoCloseable (close() -> returns void)
 * 
 * Declare public abstract method getAbstractProductInfo which has no parameter and returns -> String.
 */

public abstract class Product /* implements Cloneable, AutoCloseable, Serializable */{
	
}

