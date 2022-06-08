package eu.ase.oop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils implements ElectronicDevice{

	@Override
	public String infoDevice() {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<ElectronicDevice> phones;

	public static List<ElectronicDevice> createPhones(int n) throws Exception
	{
		
		phones=new ArrayList<ElectronicDevice>();
		for (int i=0; i<n; i++)
		{
			Phone tata=new Phone();
			phones.add(tata);
		}
		
		return phones;
		
	}
	public static List<ElectronicDevice> readPhones(String file)
	{
		phones=new ArrayList<ElectronicDevice>();
		DataInputStream dis = null;
		try {
			FileInputStream fis=new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			Phone newPhone;
			while(true)
			{
				newPhone=new Phone();
				String weight=dis.readLine();
				if (weight==null)
					throw new EOFException("End of file.");
				else
				newPhone.setWeight(Float.parseFloat(weight));
				newPhone.setDiagonal(Double.parseDouble(dis.readLine()));
				newPhone.setProducer(dis.readLine());
				phones.add(newPhone);
			}
			
		} catch(EOFException eofException) {
			//exception might occur if EOF, then do nothing, just return orderTotal
			//eofException.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phones;
		
	}
	
	public static void writeBinaryPhones(String file, List<ElectronicDevice> listP)
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			
			for (ElectronicDevice phone : phones)
			{
				Phone ph=new Phone();
				ph=(Phone)phone;
				System.out.println(ph.getWeight());
				System.out.println(ph.getDiagonal());
				System.out.println(ph.getProducer());
				dos.writeFloat(ph.getWeight());
				dos.writeDouble(ph.getDiagonal());
				dos.writeUTF(ph.getProducer());
					
			}
			dos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		
	}
	
	public static List<ElectronicDevice> readBinaryPhones(String file)
	{
		phones=new ArrayList<ElectronicDevice>();
		FileInputStream fos;
		try {
			fos = new FileInputStream(file);
			BufferedInputStream bos = new BufferedInputStream(fos);
			DataInputStream dos = new DataInputStream(bos);
			Phone newPhone;
			while(true)
			{
				newPhone=new Phone();
				newPhone.setWeight(dos.readFloat());
				newPhone.setDiagonal(dos.readDouble());
				newPhone.setProducer(dos.readUTF());
				phones.add(newPhone);
			}
		}catch(EOFException eofException) {
			//exception might occur if EOF, then do nothing, just return orderTotal
			//eofException.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phones;
		
	}
	
}
