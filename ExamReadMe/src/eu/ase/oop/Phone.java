package eu.ase.oop;

import java.io.Serializable;

public class Phone implements ElectronicDevice,Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float weight;
	private double diagonal;
	private String producer;
	
	
	
	public Phone() {
		
	}



	public float getWeight() {
		return weight;
	}



	public void setWeight(float weight) throws Exception {
		if (weight<=0)
		{
			throw new Exception("Weight lower than 0.");
		}
		else
		{
			this.weight = weight;
		}
		
	}



	public double getDiagonal() {
		return diagonal;
	}



	public void setDiagonal(double diagonal) throws Exception {
		if (diagonal<=0)
		{
			throw new Exception("Diagonal lower than 0.");
		}
		else
		{
			this.diagonal = diagonal;
		}
		
	}



	public String getProducer() {
		return producer;
	}



	public void setProducer(String producer) throws Exception {
		if (producer==null || producer.length()<=1)
		{
			throw new Exception("Exceptie - producer null sau length mai mic ca 1");
		}
		else
		{
			this.producer = new String(producer);
		}
		
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		Phone compPhone=(Phone)obj;
		if (this.diagonal!=compPhone.diagonal)
			return false;
		if (this.weight!=compPhone.weight)
			return false;
		if (!(this.producer.equals(compPhone.producer)))
			return false;
		return true;
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Phone newPhone = new Phone();
		newPhone.diagonal=this.diagonal;
		newPhone.weight=this.weight;
		newPhone.producer=new String(this.producer);
		return newPhone;
	}



	@Override
	public String infoDevice() {
		// TODO Auto-generated method stub
		return this.producer;
	}



}
