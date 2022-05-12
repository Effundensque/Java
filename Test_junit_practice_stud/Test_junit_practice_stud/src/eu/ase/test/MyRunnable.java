package eu.ase.test;

/* 
 *  Implement the public class MyRunnable which implements Runnable interface
 *  The class contains the following private fields:
 *  vector of type Juice[] // classic array of juices
 *  sumMl of type float // the sum of the ml quantities
 *  startPos of type int //the start position in the vector
 *  endPos of type int //the end position in the vector
 *  
 *  Implement the public constructor with 3 parameters:
 *  "data" of type vector of Objects, "startPos" of type int, "endPos" of type int
 *  each element from the array of the class is reference to an object from the data array
 *  
 *  Override the run() method to be called in multi-threading environment for calculating the sum of ml fields from the "vector" array
 *  between "startPos" and "endPos" positions and provide public method getSumMl() which is returning the float "sumMl"
 */

public class MyRunnable implements Runnable {

	private Juice[] vector;
	private float sumMl;
	private int startPos;
	private int endPos;
	
	public MyRunnable(Object[] data,int startPos, int endPos)
	{
		this.vector=new Juice[data.length];
		for (int i=0; i<data.length; i++)
		{
			vector[i]=(Juice)data[i];
		}
		this.startPos=startPos;
		this.endPos=endPos;
	}
	
	public float getSumMl() {
		return sumMl;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sumMl = 0.0f;
		for(int i=startPos; i<endPos; i++) {
			sumMl += vector[i].getMl();
		}
		
		
	}

}
