package lab11mar;

import java.util.Scanner;

public class ex6_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		for (int i = 0; i < n; i++) {
			for (int j = n-i-1; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 1; j <= i; j++) {
				System.out.print("**");
			}
		System.out.print("\n");
		}
	}
}
