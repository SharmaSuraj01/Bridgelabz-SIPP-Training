package Methods;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();
        double[] roots = findRoots(a, b, c);
        if (roots.length == 2) {
            System.out.println("Two real roots: x1 = " + roots[0] + ", x2 = " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("One real root: x = " + roots[0]);
        } else {
            System.out.println("No real roots.");
        }

        scanner.close();
    }
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[] {};
        }
    }
}

