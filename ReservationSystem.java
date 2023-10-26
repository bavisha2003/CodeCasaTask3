import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class ReservationSystem {
    private static Map<Integer, Reservation> reservations = new HashMap<>();
    private static int pnrCounter = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Online Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your login ID: ");
        String loginId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Simulated login validation (replace with actual user authentication)
        if (isValidUser(loginId, password)) {
            System.out.println("Login successful!");
            showReservationOptions(scanner);
        } else {
            System.out.println("Invalid login credentials. Please try again.");
        }
    }

    private static boolean isValidUser(String loginId, String password) {
        // Simulated user validation (replace with actual user authentication)
        // In a real system, you would have a database of valid users
        return true;
    }

    private static void showReservationOptions(Scanner scanner) {
        while (true) {
            System.out.println("Reservation System");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        // Simulated reservation process
        int pnr = generatePNR();
        System.out.println("Your PNR number is: " + pnr);
        System.out.println("Reservation successful!");
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter your PNR number to cancel the reservation: ");
        int pnr = scanner.nextInt();

        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Reservation with PNR " + pnr + " canceled successfully.");
        } else {
            System.out.println("Invalid PNR number. Please try again.");
        }
    }

    private static int generatePNR() {
        // Generate a random PNR (replace with a proper PNR generation logic)
        Random rand = new Random();
        return rand.nextInt(9000) + 1000;
    }
}

class Reservation {
    private int pnr;
    private String passengerName;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String source;
    private String destination;

    // Constructor, getters, and setters for Reservation class go here
}