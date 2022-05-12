package eu.ase.test;

import java.io.Serializable;
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

public class Juice extends Product implements Cloneable, Comparable<Juice>, Serializable {

	
	private float ml;
	private static final long serialVersionUID = -806571991288912011L;
	
	public Juice(int id, Date expDate, String title, float ml) throws Exception
	{
		super(id,expDate,title);
		if (ml<0.0f)
		{
			throw new Exception("Ml can't be negative");
		}
		else
		{
			this.ml=ml;
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		float ml=this.ml;
		Date expDate = new Date(this.getExpDate().getTime());
		int id=this.getId();
		String title=new String(this.getTitle());
		
		Juice juiceCopy;
		try {
			juiceCopy = new Juice(id,expDate,title,ml);
			return juiceCopy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public float getMl() {
		return ml;
	}
	

	public void setMl(float ml)throws Exception {
		if (ml<0.0f)
		{
			throw new Exception("Ml can't be negative");
		}
		else
		{
			this.ml = ml;
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Juice ceva=(Juice)obj;
		if (ceva.ml!=this.ml)
			return false;
		if (!this.getExpDate().toString().equals(ceva.getExpDate().toString()))
			return false;
		if (this.getId()!=ceva.getId())
			return false;
		if (!this.getTitle().equals(ceva.getTitle()))
			return false;
		return true;
			
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	@Override
	public int compareTo(Juice o) {
		// TODO Auto-generated method stub
		if (this.ml>o.ml)
		return 1;
		return 0;
	}

	@Override
	public String getAbstractProductInfo() {
		// TODO Auto-generated method stub
		String deReturnat="";
		deReturnat +=this.getId();
		deReturnat+=this.getTitle();
		return deReturnat;
	}
}
	
