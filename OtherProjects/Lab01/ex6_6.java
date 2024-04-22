package lab11mar;
import java.util.Scanner;

public class ex6_6 {
	public static void main(String[] args) {
		System.out.print("Enter the size of the matrices: ");
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		System.out.println("Please enter two matrices of size: " + m + " x " + n);
		System.out.println("First matrix:");
		double[][] M = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				M[i][j] = scanner.nextDouble();
			}
		}
		System.out.println("Second matrix:");
		double[][] N = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				N[i][j] = scanner.nextDouble();
			}
		}
		scanner.close();
		
		System.out.println("Sum of two matrixes above is:");
		double[][] sum = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum[i][j] = M[i][j] + N[i][j];
				System.out.print(sum[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
}
