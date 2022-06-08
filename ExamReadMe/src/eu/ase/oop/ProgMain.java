package eu.ase.oop;

import java.util.List;

public class ProgMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone phone1=new Phone();
		try {
			phone1.setDiagonal(10);
			phone1.setProducer("Nokia");
			phone1.setWeight(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Phone phone2=new Phone();
		try {
			phone2 = (Phone)phone1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Phone1: "+ phone1.getProducer());
		System.out.println("Phone2: "+ phone2.getProducer());
		try {
			phone1.setProducer("Alcatel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Phone1: "+ phone1.getProducer());
		System.out.println("Phone2: "+ phone2.getProducer());
		
		SmartPhone smp1=new SmartPhone();
		try {
			smp1.setProducer("Ceva Text");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			phone2=(Phone)smp1.clone();
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			smp1.setBatteryDuration(10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(smp1.getProducer()+" "+smp1.getBatteryDuration());
		
		
		try {
			Utils.createPhones(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ElectronicDevice> list;
		list = Utils.readPhones("fisierPhones");
		Utils.writeBinaryPhones("mama", list);
		list=Utils.readBinaryPhones("mama");
		System.out.println("---------------------");
		for (ElectronicDevice phone : list)
		{
			Phone ph=new Phone();
			ph=(Phone)phone;
			System.out.println(ph.getWeight());
			System.out.println(ph.getDiagonal());
			System.out.println(ph.getProducer());
		}
		
		VectThread thr1=new VectThread();
		VectThread thr2=new VectThread();
		thr1.run();
		System.out.println("Avg weight: " + thr1.getAvgWeight());
		
		
	}

}
