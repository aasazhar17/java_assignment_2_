import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new Calculator();

    public void performAddition() {
        System.out.println("\n--- Perform Addition ---");
        System.out.println("Select addition type:");
        System.out.println("1. Two Integers (add(int, int))");
        System.out.println("2. Two Doubles (add(double, double))");
        System.out.println("3. Three Integers (add(int, int, int))");
        System.out.print("Enter choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter first integer: ");
                    int a1 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b1 = scanner.nextInt();
                    System.out.println("Result (int, int): " + calculator.add(a1, b1));
                    break;
                case 2:
                    System.out.print("Enter first double: ");
                    double a2 = scanner.nextDouble();
                    System.out.print("Enter second double: ");
                    double b2 = scanner.nextDouble();
                    System.out.println("Result (double, double): " + calculator.add(a2, b2));
                    break;
                case 3:
                    System.out.print("Enter first integer: ");
                    int a3 = scanner.nextInt();
                    System.out.print("Enter second integer: ");
                    int b3 = scanner.nextInt();
                    System.out.print("Enter third integer: ");
                    int c3 = scanner.nextInt();
                    System.out.println("Result (int, int, int): " + calculator.add(a3, b3, c3));
                    break;
                default:
                    System.out.println("Invalid addition choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine();
        }
    }

    public void performSubtraction() {
        System.out.println("\n--- Perform Subtraction ---");
        try {
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();
            int result = calculator.subtract(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();
        }
    }

    public void performMultiplication() {
        System.out.println("\n--- Perform Multiplication ---");
        try {
            System.out.print("Enter first double: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double b = scanner.nextDouble();
            double result = calculator.multiply(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter double values only.");
            scanner.nextLine();
        }
    }

    public void performDivision() {
        System.out.println("\n--- Perform Division ---");
        try {
            System.out.print("Enter first integer (numerator): ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer (denominator): ");
            int b = scanner.nextInt();
            
            int result = calculator.divide(a, b);
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            scanner.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        performAddition();
                        break;
                    case 2:
                        performSubtraction();
                        break;
                    case 3:
                        performMultiplication();
                        break;
                    case 4:
                        performDivision();
                        break;
                    case 5:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = 0;
            }
        } while (choice != 5);
        scanner.close();
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}