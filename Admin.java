import java.util.Scanner;

public class Admin {
    private Scanner sc;

    public Admin(Scanner sc) {
        this.sc = sc;
    }

    public void addMovies() {
        System.out.println("=== Add New Movie ===");

        System.out.print("Enter theater name: ");
        String theatrename = sc.nextLine();

        System.out.print("Enter movie name: ");
        String moviename = sc.nextLine();

        System.out.print("Enter show time (HH:MM:SS): ");
        String showtime = sc.nextLine();

        System.out.print("Enter total seats: ");
        int totalseats = sc.nextInt();

        System.out.print("Enter ticket price: ");
        int price = sc.nextInt();
        sc.nextLine(); // consume newline

        Movie m = new Movie(theatrename, moviename, showtime, totalseats, price);
        m.insertMovie();

        System.out.println("✅ Movie added successfully!\n");
    }

    public void selectMovies() {
        // coming soon :)
    }
}
