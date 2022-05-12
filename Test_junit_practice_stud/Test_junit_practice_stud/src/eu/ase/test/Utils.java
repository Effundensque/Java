package eu.ase.test;

//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
//import java.io.Serializable;
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;

/*
 * Create the class Utils.
 * 
 * The class Utils has the following private fields:
 * vector: Object[] for the references to the Juice objects
 * 
 * Additionally, there the following private fields used for the intermediary results:
 *  listObjects of type List<Juice>;
 *  threadsArrayWorkerTasks of type MyRunnable[];
 * 
 * The class has no constructor - besides the default constructor (without parameters) 
 * automatically added by Java
 * 
 * Implement proper get/set method(s) for all fields:
 * (listObjects, threadsArrayWorkerTasks)
 * The set method for vector field (public void setVector(Object[] data) throws Exception)
 * is setting the "vector" field with a deep clone of "data" by applying clone method
 * for each element of the "data" array (and each element from "data" is casted to Juice class).
 * 
 * Create method displayVector() -> void which put on the screen the content of the matrix field
 * 
 * Create public methods:
 *  writeBinary(String file) which returns void and serialize the vector field into a file; 
 *  hint: 
 *  save the number of elements as first integer in file;
 *  each object from the "vector" is from class Juice
 *  
 *  readBinary(String file) which returns void and restore/de-serialize the objects into "vector" field from a file; 
 *  hint: 
 *  read the number of elements as first integer from file;
 *  each object from the "vector" is from class Juice
 *  
 *  
 *  Implement the public method sortPlusFilterWithLamdaPredicate() 
 *  which returns List<Juice>
 *  which transform the vector into an ArrayList<Juice> and then, 
 *  sort the juices and filter them by using lambda function as predicate within filter function (id > 10)
 *  and returns the new sorted list by using functional processing streams.
 *  This method must set the this.listObjects field;
 *  
 *
 *  Implement public method calculateSumMultiThreading() which use multi-threading / framework Executor-Service 
 *  for creating worker tasks using the field: this.threadsArrayWorkerTasks from class MyRunnable (which implements Runnable) 
 *  and calculates the ml sum of the "vector" elements by using
 *  the number of worker tasks equals to 2.
 *  This method uses the field this.threadsArrayWorkerTasks
 */


public class Utils {
	
	private Object[] vector;
	private List<Juice> listObjects;
	private MyRunnable[] threadsArrayWorkerTasks;
	
	
	
	public Object[] getVector() {
		return vector;
	}
	public List<Juice> getListObjects() {
		return listObjects;
	}
	public void setListObjects(List<Juice> listObjects) {
		this.listObjects = listObjects;
	}
	public MyRunnable[] getThreadsArrayWorkerTasks() {
		return threadsArrayWorkerTasks;
	}
	public void setThreadsArrayWorkerTasks(MyRunnable[] threadsArrayWorkerTasks) {
		this.threadsArrayWorkerTasks = threadsArrayWorkerTasks;
	}
	
	public void setVector(Object[] data) throws Exception
	{
		vector = new Juice[data.length];
		for (int i=0; i<data.length; i++)
		{
			if (data[i]!=null)
				vector[i]=((Juice)data[i]).clone();
		}
	}
	
	public void displayVector()
	{
		for (int i=0; i<vector.length;i++)
		{
			System.out.println(vector[i]);
		}
	}
	public void writeBinary(String file)
	{
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeInt(vector.length);
			for (int i=0; i<vector.length; i++)
			{
				oos.writeObject((Juice)vector[i]);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readBinary(String file)
	{
		try {
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream (file));
			int a=ois.readInt();
			vector= new Juice[a];
			for (int i=0; i<a; i++)
			{
				vector[i]=(Juice)ois.readObject();
			}
			ois.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Juice> sortPlusFilterWithLamdaPredicate()
	{
		List<Juice> juices= Arrays.asList((Juice[])vector);
		List<Juice> filteredJuices=juices.stream().filter(id-> id.getId()>10).collect(Collectors.toList());
		this.listObjects=filteredJuices;
		return filteredJuices;
	}
	
	// Wtf is this? 
	public float calculateSumMultiThreading()
	{
		int NTHREADS = 2;
		float sum=0L;
		//long startTime=0L;
		int startIdx = 0, stopIdx = 0;
		long[] vectSum = new long[NTHREADS];
//		startTime=System.currentTimeMillis();
		Thread[] vectThreads=new Thread[NTHREADS];
		this.threadsArrayWorkerTasks=new MyRunnable[NTHREADS];
		int dimVect = 80_000_000;
		for (int it = 0; it < NTHREADS; it++) {
			startIdx = it * (dimVect / NTHREADS);
			stopIdx = (it + 1) * (dimVect / NTHREADS);
			vectSum[it] = 0L;
			this.threadsArrayWorkerTasks[it] = new MyRunnable(vector, startIdx, stopIdx);
			vectThreads[it] = new Thread(this.threadsArrayWorkerTasks[it]);
		}
		for (int it = 0; it < NTHREADS; it++) {
			vectThreads[it].start();
		}

		for (int it = 0; it < NTHREADS; it++) {
			try {
				// inter-thread synchronization
				// the calling thread goes into a waiting state and
				// it remains in a waiting state until the referenced thread terminates
				vectThreads[it].join();
			} catch (InterruptedException ie) {
				// Thrown when a thread is waiting, sleeping, or otherwise occupied,
				// and the thread is interrupted, either before or during the activity
				ie.printStackTrace();
			}
		}
		for (int it = 0; it < NTHREADS; it++) {
			this.threadsArrayWorkerTasks[it].run();
			sum += this.threadsArrayWorkerTasks[it].getSumMl();
		}
		return sum;
	}
}
