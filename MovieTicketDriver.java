import java.sql.Connection;
import java.util.Scanner;

public class MovieTicketDriver {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin(scanner);
        ViewMovie viewMovie = new ViewMovie(); 

        int choice;
        do {
            System.out.println("=== Movie Ticket Booking System ===");
            System.out.println("1. Add Movie");
            System.out.println("2. View Movies");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    admin.addMovies();
                    System.out.println();
                    break;

                case 2:
                    admin.viewMovies();
                    System.out.println();
                    break;
                

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    System.out.println();
            }
        } while (choice != 3);

        scanner.close();
    }
}
