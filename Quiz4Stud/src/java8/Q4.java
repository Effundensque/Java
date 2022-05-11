package java8;

import java.time.LocalDate;

/**
 * If refDate.getDayOfWeek() prints "FRIDAY", what would be the output of newDate.getDayOfWeek()?
 * 
 * 1. SUNDAY
 * *2. MONDAY
 * 3. TUESDAY
 * 4. SATURDAY
 */

class Q4 {

	public static void main(String [] args) {
		
		
		LocalDate refDate = LocalDate.parse("2022-04-15");

		System.out.println(refDate.getDayOfWeek());
		
		LocalDate newDate = refDate.plusDays(3);
		
		System.out.println(newDate.getDayOfWeek());
		
		
	}
}
