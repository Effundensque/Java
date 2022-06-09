package eu.ase.test;

import java.io.Serializable;

public class PlaneCargo extends Plane implements Serializable, Cloneable {

	private float capacity;
	private Float[] packagesWeight;
	
	public PlaneCargo()
	{
		
	}
	
	public PlaneCargo(float weight, double price, String producer, float capacity, Float[] packagesWeight) throws Exception
	{
		super(weight,price,producer);
		this.capacity=capacity;
		this.packagesWeight=new Float[packagesWeight.length];
		for (int i=0; i<packagesWeight.length;i++)
		{
			this.packagesWeight[i]=packagesWeight[i];
		}
	}
	
	
	
	public float getCapacity() {
		return capacity;
	}



	public void setCapacity(float capacity) throws Exception {
		if (capacity>0)
		this.capacity = capacity;
		else
			throw new Exception("Capacity lower than 0.");
	}



	public Float[] getPackagesWeight() {
		return packagesWeight;
	}



	public void setPackagesWeight(Float[] packagesWeight) {
		this.packagesWeight=new Float[packagesWeight.length];
		for (int i=0; i<packagesWeight.length;i++)
		{
			this.packagesWeight[i]=packagesWeight[i];
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		PlaneCargo newPlaneCargo=new PlaneCargo();
		newPlaneCargo.capacity=this.capacity;
		newPlaneCargo.packagesWeight=new Float[this.packagesWeight.length];
		
		for (int i=0; i<this.packagesWeight.length; i++)
		{
			newPlaneCargo.packagesWeight[i]=this.packagesWeight[i];
		}
		
		
		try {
			newPlaneCargo.setPrice(this.getPrice());
			newPlaneCargo.setProducer(this.getProducer());
			newPlaneCargo.setWeight(this.getWeight());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return newPlaneCargo;
	}

	@Override
	public String infoVehicle() {
		
		String mama="";
		mama+=this.capacity;
		return mama;
	}



	

}
