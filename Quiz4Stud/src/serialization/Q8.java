package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * What error is thrown if the file stream is closed?
 * 1. EOFException - Flav
 * 2. NullPointerException 
 * 3. IOException - giur
 * 4. ClassCastException
 */
public class Q8 {

	public static void main(String[] args) {
		try {
			//declaration 1
			FileInputStream fileInputStream = new FileInputStream("text.txt");
			//declaration 2
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (FileNotFoundException e) {
			//thrown by declaration 1
			e.printStackTrace();
		} catch (IOException e) {
			// thrown by declaration 2
			e.printStackTrace();
		}
	}
}
