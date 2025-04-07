import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;

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

    public void viewMovies() {
    System.out.println("=== Available Movies ===");
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ticket", "root", "ponnarukannan");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

        while (rs.next()) {
            System.out.println("🎭 Theater: " + rs.getString("theatrename"));
            System.out.println("🎬 Movie: " + rs.getString("moviename"));
            System.out.println("🕒 Show Time: " + rs.getString("showtime"));
            System.out.println("💺 Seats: " + rs.getInt("totalseats"));
            System.out.println("💵 Price: ₹" + rs.getInt("price"));
            System.out.println("------------------------------");
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("❌ Error retrieving movies: " + e.getMessage());
    }
}

}
