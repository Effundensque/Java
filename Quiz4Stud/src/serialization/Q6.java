package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * What would you write to serialize the object to the file?
 * 1. oos.writeObject(obj);
 * 2. oos.write(obj);
 * 3. oos.read(obj);
 * 4. oos.readObject(obj);
 *
 */
@SuppressWarnings({"unused", "resource"})

class Q6 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		Object obj = new Object();
		ObjectOutputStream oos = new ObjectOutputStream( 
				new FileOutputStream("file.txt"));
		/* Your code here */
		
		
		
	}

}
