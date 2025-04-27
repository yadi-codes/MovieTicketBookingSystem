import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Admin {
    private Scanner sc;

    public Admin(Scanner sc) {
        this.sc = sc;
    }

    public void addMovies() {
    System.out.println("\n=== Add New Movie ===");
    
    System.out.print("Enter theater name: ");
    String theater = sc.nextLine();
    
    System.out.print("Enter movie name: ");
    String movie = sc.nextLine();
    
    String showtime = "";
    boolean validTime = false;
    while (!validTime) {
        System.out.print("Enter show time (yyyy-MM-dd HH:mm): ");
        showtime = sc.nextLine();
        try {
            LocalDateTime.parse(showtime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            validTime = true;
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid time format! Please use yyyy-MM-dd HH:mm");
        }
    }
    
    System.out.print("Enter total seats: ");
    int seats = getValidIntInput(sc);
    
    System.out.print("Enter ticket price: ");
    int price = getValidIntInput(sc);

    Movie newMovie = new Movie(theater, movie, showtime, seats, price);
    if (newMovie.insertMovie()) {
        System.out.println("✅ Movie added successfully!");
    } else {
        System.out.println("❌ Failed to add movie!");
    }
}

public void viewMovies() {
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_ticket", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM movies");

        System.out.println("\n=== Available Movies ===");
        while (rs.next()) {
            System.out.println("Theater: " + rs.getString("theatrename"));
            System.out.println("Movie: " + rs.getString("moviename"));
            System.out.println("Time: " + rs.getString("showtime"));
            System.out.println("Seats: " + rs.getInt("totalseats"));
            System.out.println("Price: ₹" + rs.getInt("price"));
            System.out.println("-----------------------");
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Error viewing movies: " + e.getMessage());
    }
}

}
