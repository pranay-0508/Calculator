import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return a; // keep previous result
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;
        double result = 0;
        boolean firstTime = true; // to know if we need initial input

        while (keepRunning) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");
            int choice = input.nextInt();

            if (choice == 5) {
                keepRunning = false;
                System.out.println("Exiting... Goodbye!");
                break;
            }

            double num1;
            if (firstTime) {
                System.out.print("Enter first number: ");
                num1 = input.nextDouble();
                firstTime = false;
            } else {
                num1 = result; // use previous result
                System.out.println("Previous result = " + result);
            }

            System.out.print("Enter next number: ");
            double num2 = input.nextDouble();

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to continue with this result? (y/n): ");
            char cont = input.next().toLowerCase().charAt(0);
            if (cont != 'y') {
                firstTime = true; // reset for new start
            }
        }

        input.close();
    }
}
