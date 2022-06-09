package eu.ase.test;

public class ProgMain {

	private static void printPlane(PlaneCargo plane1)
	{
		System.out.println(
				"Price: " + plane1.getPrice()+" \n" +
				"Weight: " + plane1.getWeight()+" \n"+
				"Producer: " + plane1.getProducer()+" \n"+
				"Capacity: " + plane1.getCapacity()+" \n Vector: ");
				for (int i=0; i<plane1.getPackagesWeight().length;i++)
				{
					System.out.println(plane1.getPackagesWeight()[i] + " ");
				}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		Float[] mama= {1.2f,2.5f,3.5f};
		PlaneCargo plane1=null;
	
			plane1=new PlaneCargo(10,11, "Airbnb", 3, mama);
		
		printPlane(plane1);
		System.out.println("---------------------");
		mama[0]=1231.5f;
		printPlane(plane1);
		PlaneCargo plane2=null;
		
		plane2 = (PlaneCargo)plane1.clone();
		
		System.out.println("---------------------");
		Float[] tata= {43278.2f,2.5f,3.5f};
		plane1.setPackagesWeight(tata);
		plane1.setProducer("Pizda mati");
		printPlane(plane2);
			
		PlaneDAO.setConnection("test1.db");
		String cretin=PlaneDAO.selectData();
		System.out.println(cretin);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
				
	}

}
