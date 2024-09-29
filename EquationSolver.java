import java.util.Scanner;

public class EquationSolver {

    // Solves first-degree equation: ax + b = 0
    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is: x = " + x);
        }
    }

    // Solves a system of two first-degree equations:
    // a11*x1 + a12*x2 = b1
    // a21*x1 + a22*x2 = b2
    public static void solveSystemOfLinearEquations(double a11, double a12, double b1, double a21, double a22, double b2) {
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution is: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    // Solves a second-degree equation: ax^2 + bx + c = 0
    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            // If a is 0, it's actually a first-degree equation
            solveLinearEquation(b, c);
        } else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The equation has two distinct real roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root: x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solve a linear equation
        System.out.println("Solve first-degree equation (ax + b = 0): ");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        solveLinearEquation(a, b);

        // Solve a system of two first-degree equations
        System.out.println("\nSolve a system of two first-degree equations: ");
        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter coefficient b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter coefficient b2: ");
        double b2 = scanner.nextDouble();
        solveSystemOfLinearEquations(a11, a12, b1, a21, a22, b2);

        // Solve a quadratic equation
        System.out.println("\nSolve second-degree equation (ax^2 + bx + c = 0): ");
        System.out.print("Enter coefficient a: ");
        double qa = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double qb = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double qc = scanner.nextDouble();
        solveQuadraticEquation(qa, qb, qc);

        scanner.close();
    }
}
