package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * What will be the output of the following:
 * *1. [2, 1, 4]
 * 2. [2, 2, 1, 4, 2, 2]
 * 3. [2, 2, 3, 4, 2, 2]
 * 4. [2, 3, 4]
 */
class Q5 {

	public static void main(String[] args) {
		
		
		List<Integer> ids = Arrays.asList(1, 3, 2, 5, 3, 1);
		
		List<Integer> newIds = ids
				.stream()
				.map(id -> (id < 2) ? id + 1 : id - 1)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(newIds);
	}
}
