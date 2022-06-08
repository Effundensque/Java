package poly;

import java.io.Serializable;

/**
 * A class can implement only one interface but extend many classes.
 * 1. True
 * 2. False
 *
 */
public class Q7 extends Object implements Serializable, AutoCloseable {

	@Override
	public void close() throws Exception {
		
	}

}
