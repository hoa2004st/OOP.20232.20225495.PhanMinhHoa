package lab11mar;

import java.util.Scanner;

public class ex6_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String month = scanner.nextLine();
		int year = scanner.nextInt();
		scanner.close();
		boolean leap = true;
		if ( (year%4 != 0) || ((year%100 == 0) && (year%400 != 0)) ) {
			leap = false;
		}
		String[] odd = {"January", "Jan.", "Jan", "1",
				"March", "Mar.", "Mar", "3",
				"May", "May.", "5",
				"July", "Jul.", "Jul",  "7",
				"August", "Aug", "Aug.", "8",
				"October", "Oct", "Oct.", "10",
				"December", "Dec", "Dec.", "12"};
		String[] even = {"April", "Apr", "Apr.", "4",
				"June", "Jun", "Jun.", "6",
				"September", "Sep", "Sep.", "9", 
				"November", "Nov", "Nov.", "11"};
		String[] feb = {"Feruary", "Feb", "Feb.", "2"};
		int day = 0;
		for (String s : odd) {
			if (month.equals(s)) {
				day = 31;
			}
				
		}
		for (String s : even) {
			if (month.equals(s)) {
				day = 30;
			}
		}	
		for (String s : feb) {
			if (month.equals(s)) {
				if (leap) {
					day = 29;
				}
			}
			else {
				day = 28;
			}		
		}
		System.out.println(day);
	}
}
