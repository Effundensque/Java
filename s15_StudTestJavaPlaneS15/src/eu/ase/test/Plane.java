package eu.ase.test;

import java.io.Serializable;

public class Plane implements Vehicle, Serializable,Cloneable {
	private float weight;
	private double price;
	private String producer;
	
	public Plane()
	{
		
	}
	
	public Plane(float weight, double price, String producer)
	{
		this.weight=weight;
		this.price=price;
		this.producer=new String(producer);
		
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) throws Exception {
		if (weight>0)
		this.weight = weight;
		else
		{
			throw new Exception("Weight less than 0");
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws Exception {
		if (price>0)
		this.price = price;
		else
		{
			throw new Exception("Price less than 0.");
		}
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) throws Exception {
		if (producer!=null && producer.length()>1)
		{
			this.producer=new String(producer);
		}
		else
		{
			throw new Exception("Producer not good.");
		}
	}

	
	
	@Override
	public int hashCode() {
		return (int)(31*(getProducer().hashCode()+getPrice()+getWeight()));
	}

	@Override
	public boolean equals(Object obj) {
		Plane compPlane = (Plane)obj;
		if (compPlane.price!=this.price)
			return false;
		if (compPlane.weight!=this.weight)
			return false;
		if (!compPlane.producer.equals(this.producer))
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Plane newPlane = new Plane();
		newPlane.price=this.price;
		newPlane.weight=this.weight;
		newPlane.producer=new String(this.producer);
		return newPlane;
	}

	@Override
	public String infoVehicle() {
		// TODO Auto-generated method stub
		return this.producer;
	}
	

}
