package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Q1 {

	public static void main(String[] args) {
		
		List<Integer> distances = Arrays.asList(23, 54, 12, 23, 89, 34);
		List<Integer> filteredDistances = 
				distances
				.stream()
				.filter(el -> {return el > 30;})
				.map(el -> el + 10)
				.collect(Collectors.toList());
		
		System.out.println(filteredDistances);
	}

}


/**
 * What will be the output of the following:
 *
 *	1. [54, 89, 34]
 *	2. [44, 64, 99]
 *	3. [34, 54, 89]
 *	4. [64, 99, 44] - giur / flav
 */
