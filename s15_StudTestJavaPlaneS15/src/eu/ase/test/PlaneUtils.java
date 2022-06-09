package eu.ase.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;




public class PlaneUtils {

	private static List<Vehicle> list;
	
	public static List<Vehicle> createList(int n) throws Exception
	{
		list=new ArrayList<Vehicle>();
		if (n>0)
		for (int i=0; i<n; i++)
		{
			Plane newPlane = new Plane();
			list.add(newPlane);
			
		}
		else
			throw new Exception("Ceva");
		return list;
	}
	
	public static List<Vehicle> readListFromFile(String file)
	{
		ArrayList<Vehicle> listaNoua=null;
		FileInputStream fis=null;
		try {
			File f = new File(file);
			if (!f.exists())
				throw new Exception("Nu exista");
			else
			{
				listaNoua=new ArrayList<Vehicle>();
				fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis);
				Plane newPlane=null;
				while(true)
				{
					newPlane = new Plane();
					String primu = dis.readLine();
					if (primu == null)
						throw new EOFException("end of file");
					else
						newPlane.setWeight(Float.parseFloat(primu));
					newPlane.setPrice(Double.parseDouble(dis.readLine()));
					newPlane.setProducer(dis.readLine());
					listaNoua.add(newPlane);
				}
			}
		}catch(EOFException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaNoua;
	}
	
	public static void writeBinary(String file, List<Vehicle> listP)
	{
		try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Vehicle veh:listP)
			{
				oos.writeObject(veh);
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
	
	public static List<Vehicle> readBinary(String file)
	{
		ArrayList<Vehicle> newList=null;
		FileInputStream fos;
		try {
			newList= new ArrayList<Vehicle>();
			fos = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fos);
			Plane newPlane=null;
			while (true)
			{
				newPlane=new Plane();
				newPlane=(Plane)oos.readObject();
				if (newPlane==null)
					throw new EOFException("Ceva");
				else
					newList.add(newPlane);
			}
			
			
		} catch(EOFException e)
		{
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list=newList;
		return newList;
		
	}
}
