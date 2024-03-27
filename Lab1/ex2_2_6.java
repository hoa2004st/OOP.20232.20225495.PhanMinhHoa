package lab11mar;
import java.util.Scanner;

public class ex2_2_6 {
	public static void main(String[] args) {
		System.out.println("Choose the type of solver:");
		System.out.println("For first degree equation with one variable, type 1");
		System.out.println("For system of first degree equations with two variable, type 2");
		System.out.println("For second degree equation with one variable, type 3");
		
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		switch (type) {
		case 1:
			System.out.print("The equation is in the form : ax + b = 0\nEnter a: a = ");
			double aa = scanner.nextDouble();
			System.out.print("Enter b: b = ");
			double bb = scanner.nextDouble();
			
			if (aa == 0) {
				System.out.println("The equation have no solution!");
			}
			else {
				Double solution = -bb/aa;
				System.out.println("The solution is: x = "+solution);
			}
			break;
		case 2:
			System.out.print("The system of equations is in the form :\nax + by = c\ndx + ey = f\nEnter a: a = ");
			double a = scanner.nextDouble();
			System.out.print("Enter b: b = ");
			double b = scanner.nextDouble();
			System.out.print("Enter c: c = ");
			double c = scanner.nextDouble();
			System.out.print("Enter d: d = ");
			double d = scanner.nextDouble();
			System.out.print("Enter e: e = ");
			double e = scanner.nextDouble();
			System.out.print("Enter f: f = ");
			double f = scanner.nextDouble();
			
			double det = b*d - a*e;
			if (det == 0) {
				if (c*d - a*f == 0) {
					System.out.println("The system have infinity amount of solution.");
				}
				else {
					System.out.println("The system have no solution.");
				}
			}
			else {
				double x = (b*f - c*e)/det;
				double y = (c*d - a*f)/det;
				System.out.println("The system have one solution: (x, y) = ("+x+", "+y+")");
			}
			break;
		case 3:
			System.out.print("The equation is in the form : ax + b = 0\nEnter a: a = ");
			double A = scanner.nextDouble();
			System.out.print("Enter b: b = ");
			double B = scanner.nextDouble();
			System.out.print("Enter c: c = ");
			double C = scanner.nextDouble();
			double delta = Math.sqrt(B*B - 4*A*C);
			double solution;
			if (delta < 0) {
				System.out.println("The equation have no real solution!");
			}
			else if (delta == 0) {
				solution = -B/2;
				System.out.println("The equation have one solution: x = "+ solution);
			}
			else {
				double m = -B/2;
				double n = Math.sqrt(delta)/2;
				double x1 = m + n;
				double x2 = m - n;
				System.out.println("The equation have two solutions: x1 = " + x1 + " and x2 = " + x2);
			}
			break;
		}
		scanner.close();
	}
}
