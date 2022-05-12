package eu.ase.test;

import java.io.Serializable;
import java.util.Date;
//import java.io.IOException;

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

public abstract class Product implements Cloneable, AutoCloseable, Serializable {
	private Date expDate;
	private int id;
	private String title;
	private static final long serialVersionUID = -806571991288912011L;
	private static int productsNo;
	public abstract String getAbstractProductInfo();

	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id)throws Exception {
		if (id < 0)
		{
			throw new Exception("You can't put an id that is lower than 0.");
		}
		else
		{
			this.id = id;
		}
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static int getProductsNo() {
		return productsNo;
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		productsNo--;
		
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		productsNo++;
		return super.clone();
	}

	public Product()
	{
		productsNo++;
	}
	public Product(int id, Date expDate, String title) throws Exception
	{
		productsNo++;
		if (id<0)
		{
			throw new Exception("You can't put an id that is lower than 0.");
		}
		else
		{
			this.id=id;
		}
		this.expDate=expDate;
		this.title=title;
	}
	
}

