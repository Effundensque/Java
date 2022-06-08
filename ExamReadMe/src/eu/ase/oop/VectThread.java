package eu.ase.oop;

import java.util.List;

public class VectThread implements Runnable{

	private List<ElectronicDevice> phonesList;
	private double avgWeight;
	
	public VectThread()
	{
		phonesList=Utils.readBinaryPhones("mama");
	}
	
	public List<ElectronicDevice> getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(List<ElectronicDevice> phonesList) {
		this.phonesList = phonesList;
	}

	public double getAvgWeight() {
		return avgWeight;
	}

	public void setAvgWeight(double avgWeight) {
		this.avgWeight = avgWeight;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.avgWeight=0.0f;
		int noOfPhones=phonesList.size();
		Phone currentPhone;
		for (ElectronicDevice phone : phonesList)
		{
			currentPhone=(Phone)phone;
			//System.out.println(currentPhone.getWeight());
			this.avgWeight+=currentPhone.getWeight();
		}
		this.avgWeight/=noOfPhones;
		
		
	}

}
