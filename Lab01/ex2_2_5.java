package lab11mar;

import java.util.Scanner;

public class ex2_2_5 {
	public static void sum(double a, double b) {
		double sum = a + b;
		System.out.println("a + b = " + sum);
	}
	public static void dif(double a, double b) {
		double dif = a - b;
		System.out.println("a - b = " + dif);
	}
	public static void pro(double a, double b) {
		double pro = a * b;
		System.out.println("a * b = " + pro);
	}
	public static void quo(double a, double b) {
		if (b == 0) {
			System.out.println("Cannot divide by zero!");
		}
		else {
			double quo = a / b;
			System.out.println("a / b = "+ quo);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first number: a = ");
		double a = scanner.nextDouble();
		System.out.print("Enter the second number: b = ");
		double b = scanner.nextDouble();
		sum(a, b);
		dif(a, b);
		pro(a, b);
		quo(a, b);
		scanner.close();
	}
}
