package lab11mar;

import java.util.Scanner;

public class ex6_5 {
	public static int sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result = result + array[i];
		}
		System.out.println("Sum of the array is: " + result);
		return result;
	}
	public static double avg(int[] array) {
		double sum = (double)sum(array);
		double result = sum / array.length;
		System.out.println("Average value of the array is: " + result);
		return result;
	}
	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j] && i > j) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the lenght of your array: ");
		int len = scanner.nextInt();
		System.out.print("Please enter your array: ");
		int[] array = new int[len];
		for (int i = 0; i < len; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		avg(array);
		sort(array);
		System.out.print("Your sorted array is: ");
		for (int i = 0; i < len; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}
