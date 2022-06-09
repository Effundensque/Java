package eu.ase.test;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VectThread extends Plane implements Runnable {

	private List<Vehicle> planesList;
	private double avgWeight;
	
	public VectThread(String dbFileName)
	{
		PlaneDAO.setConnection(dbFileName);
		try {
			planesList=PlaneDAO.selectDataIntoList();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlaneDAO.closeConnection();
	}
	
	public VectThread(File txtFile)
	{
		planesList=PlaneUtils.readBinary(txtFile.getName());
	}
	
	public List<Vehicle> getPlanesList() {
		return planesList;
	}

	public double getAvgWeight() {
		return avgWeight;
	}

	@Override
	public void run() {
		Plane plane=null;
		int noOfPlanes=planesList.size();
		for (Vehicle veh:planesList)
		{
			plane=new Plane();
			plane=(Plane)veh;
			this.avgWeight+=plane.getWeight();
		}
		this.avgWeight/=noOfPlanes;
		
	}

	
}


